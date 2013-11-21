package tchok.sudoku.gui;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.prefs.IPrefConstants;

/**
 * Handle the undo/redo stacks.
 * 
 * @author Tchok
 */
public class UndoManager {
	// the undo stack
	ArrayList<UIState> _undos;
	
	// The redo stack
	ArrayList<UIState> _redos;
	
	// The client view and board
	MainView _view;
	
	// The undo action
	Action _undoAction;
	
	// The redo action
	Action _redoAction;
	
	// Get one.
	public UndoManager(MainView view_p) {
		// Initialize
		_view = view_p;
		_undos = new ArrayList<UIState>();
		_redos = new ArrayList<UIState>();
	}

	// Do clear a position
	public void clearPosition() {
		// Get selection
		int selection = _view.getBoard().getSelection();
		if(selection < 0) {
			return;
		}
		
		// Push state
		push(_view.getBoard().getState());
		
		// Build a new one
		UIState state = new UIState(_view.getBoard().getState());
		state.clean(selection);
		_view.getBoard().setState(state);
	}

	// Push a new state
	public void push(UIState state_p) {
		// Copy any pending redos
		_undos.addAll(_redos);
		_redos.clear();
		
		// Store new state
		_undos.add(state_p);
		
		// Limit undo size
		while(_undos.size() > 150) {
			_undos.remove(0);
		}
		
		// Update actions
		updateAction();
	}

	// Call for undo
	public void undo() {
		// Push current state in the redo queue
		UIState current = _view.getBoard().getState();
		_redos.add(current);
		
		// Get last state
		UIState state = _undos.remove(_undos.size()-1);
		state.addUndo();
		
		// Push it has current state
		_view.getBoard().setState(state);
		
		// Update actions
		updateAction();
	}
	
	// Call for redo
	public void redo() {
		// Push current state in the undo queue
		UIState current = _view.getBoard().getState();
		_undos.add(current);
		
		// Get last state
		UIState state = _redos.remove(_redos.size()-1);
		
		// Push it has current state
		_view.getBoard().setState(state);
		
		// Update actions
		updateAction();
	}
	
	// Update actions state.
	private void updateAction() {
		// Undo
		_undoAction.setEnabled(!_undos.isEmpty());
		_redoAction.setEnabled(!_redos.isEmpty());
		_view.refreshSelectors();
	}

	public void playPosition(int value_p) {
		// Get some datas
		UIState state = _view.getBoard().getState();
		int selection = _view.getBoard().getSelection();
		if(selection < 0) {
			return;
		}
		
		// Initialize the new state
		UIState target = new UIState(state);
		
		// If it's not free
		boolean clearing = false;
		if(!state.isFree(selection)) {
			// Get the old value
			int oldValue = state.getValue(selection);
			
			// Clearing ?
			if(oldValue == value_p) {
				clearing = true;
			}
			
			// Clear value
			target.clean(selection);
		}
		
		// If it's not allowed (or we're not checking)
		if(! _view.isAllowInvalidMove() &&
			! target.isAllowed(selection, value_p) &&
			! clearing) {
			// Say it
			warnOnStrangePlayerMove("UndoManager.invalidMove", IPrefConstants.ALLOW_INVALID_MOVE); //$NON-NLS-1$
			
			// And don't play it
			state.addIllegalMove();
			return;
		}
		
		// If it' a wrong move
		if(! SudokuPlugin.getDefault().getUserPreferences().getBoolean(IPrefConstants.ALLOW_WRONG_MOVE) &&
			((target.getSolution() != null) && (target.getSolution().getValue(selection) != value_p))) {
			// Say it
			warnOnStrangePlayerMove("UndoManager.wrongMove", IPrefConstants.ALLOW_WRONG_MOVE); //$NON-NLS-1$
			
			// And don't play it
			state.addWrongMove();
			return;
		}
		
		// Push state in the queue
		push(state);

		// The play
		if(!clearing) {
			// Play
			target.play(selection, value_p);
		}
		
		// refresh
		_view.getBoard().setState(target);
		
		// Handle the end of game
		// (IN THE UNDO MANAGER !!!!)
		if(target.checkForEnd()) {
			handleEndOfGame(target);
		}
	}


	/**
	 * Handles the end of game.
	 */
	void handleEndOfGame(UIState state_p) {
		// save state
		SudokuPlugin.saveCurrentState(state_p);

		// Check for errors
		ArrayList<int []> errors = state_p.findErrors();
		
		// TODO display errors graphicaly somehow
		
		// Find case...
		boolean withError = !errors.isEmpty();
		String format = withError ?
				Messages.getString("UndoManager.withErrorFormat") : //$NON-NLS-1$
				Messages.getString("UndoManager.withoutErrorFormat"); //$NON-NLS-1$
		
		// Build args
		Object args[] = {
				new Long(state_p.getElapsed() / 60000),
				new Long((state_p.getElapsed() / 1000) % 60),
				new Integer(state_p.getIllegalMoves()),
				new Integer(state_p.getWrongMoves()),
				new Integer(state_p.getSolves()),
				new Integer(state_p.getAutoPlay())
		};
		
		// Get string
		String message = MessageFormat.format(format, args);
		
		// Show dialog
		String title=Messages.getString("UndoManager.endTitle"); //$NON-NLS-1$
		
		// Display message
		MessageDialog.openInformation(_view.getBoard().getShell(), title, message);
	}

	/**
	 * @param value_p
	 */
	public void toggleMark(int value_p) {
		// Get selection
		int selection = _view.getBoard().getSelection();
		if(selection <0) {
			return;
		}
		
		// Push state
		push(_view.getBoard().getState());
		
		// Get state
		UIState state = new UIState(_view.getBoard().getState());
		
		// Current state
		int current = state.getMark(selection, value_p);
		
		// Target state 
		int target = (current == _view.getPlayMode()) ? 0 : _view.getPlayMode();
		
		// Set it
		state.setMark(selection, value_p, target);
		
		// Help the user a few
//		StrategieManager.INSTANCE.study(state, false);

		// And store
		_view.getBoard().setState(state);
	}
	
	/**
	 * Contribute to the action bar.
	 * @param manager_p
	 */
	public void contribute(IToolBarManager manager_p) {
		// Create actions...
		
		// Undo
		_undoAction = new Action() {
			@Override
			public void run() {
				undo();
			}
		};
		_undoAction.setToolTipText(Messages.getString("UndoManager.undo")); //$NON-NLS-1$
		_undoAction.setImageDescriptor(_view.getImageDescriptor("Back.png")); //$NON-NLS-1$
		_undoAction.setEnabled(false);
		manager_p.add(_undoAction);
		
		// Redo
		_redoAction = new Action() {
			@Override
			public void run() {
				redo();
			}
		};
		_redoAction.setToolTipText(Messages.getString("UndoManager.redo")); //$NON-NLS-1$
		_redoAction.setImageDescriptor(_view.getImageDescriptor("Forward.png")); //$NON-NLS-1$
		_redoAction.setEnabled(false);
		manager_p.add(_redoAction);
	}
	
	/**
	 * Display a warning message in a dialog,
	 * allowing the user to toggle the given property.
	 * @param messageKey_p message should be in the Messages list
	 * @param propertyKey_p key of the property + key of the label
	 */
	void warnOnStrangePlayerMove(	String messageKey_p, 
									String propertyKey_p) {
		// Get some labels...
		
		// Title
		String title = Messages.getString("UndoManager.errorTitle"); //$NON-NLS-1$
		
		// Message
		String message = Messages.getString(messageKey_p);
		
		// Label for the toggle
		String toggleLabel = Messages.getString(propertyKey_p); 
		
		// Handle the property
		
		// Get the store
		IPreferenceStore store = SudokuPlugin.getDefault().getUserPreferences();
		
		// Get current value (should always be false ?)
		boolean state = store.getBoolean(propertyKey_p);
		
		// Shows the dialog
		MessageDialogWithToggle dialog =
			MessageDialogWithToggle.openError(	_view.getBoard().getShell(), 
												title, 
												message, 
												toggleLabel, 
												state, 
												null, 
												null);
		
		// The dialog strangly use "allways/never" for values ????
		//store.setValue(propertyKey_p, Boolean.toString(dialog.getToggleState()));
		store.setValue(propertyKey_p, dialog.getToggleState());
	}
}