package tchok.sudoku.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Template;
import tchok.sudoku.prefs.IPrefConstants;
import tchok.swt.graphics.IDisposable;

/**
 * Handles mouse event in a faster (for the user) way than ActionMouseHandler does.
 * From an idea of Andreas, left button plays the selected value and right button strikes it.
 * @author Tchok
 */
public class FastActionMouseHandler implements Listener, IPrefConstants, IDisposable {
	// The view we're active on.
	private MainView _view;
	
	/**
	 * Create an set a mouse handler on the view.
	 * @param view_p
	 */
	public FastActionMouseHandler(MainView view_p) {
		// Store
		_view = view_p;
		
		// Register a mouse listener
		_view.getBoard().addListener(SWT.MouseUp, this);
		
		// Lock the value selector
		_view.setValueSelectorLocked(true);
	}
	
	/**
	 * Dispose form this handler
	 */
	public void dispose() {
		if(!_view.getBoard().isDisposed()) {
			// Remove listener
			_view.getBoard().removeListener(SWT.MouseUp, this);
		}
	}

	public void handleEvent(Event event) {
		// Only one event type...
		
		// Get state
		UIState state = _view.getBoard().getState();
		
		// Get selected value
		int selectedValue = _view.getBoard().getValueToHighlight();
		
		// Get selected index
		int selectedIndex = _view.getBoard().getSelection();
		
		// Forget it?
		// No value selected
		if(selectedValue<0) {
			SudokuPlugin.getDefault().message(Messages.getString("FastActionMouseHandler.noSelection"), null); //$NON-NLS-1$
			return;
		}
		// Can't play here, it's an original value (from the grid definition)
		if(state.isOriginalPosition(selectedIndex)) {
			SudokuPlugin.getDefault().message(Messages.getString("FastActionMouseHandler.cantPlayHere"), null); //$NON-NLS-1$
			return;
			
		}
		// Can't play here the value is not allowed and the prefs states it's hidden 
		if(!state.isAllowed(selectedIndex, selectedValue) &&
			SudokuPlugin.getDefault().getUserPreferences().getBoolean(IPrefConstants.HIDE_NOT_ALLOWED) &&
			(selectedValue != state.getValue(selectedIndex))) {
			SudokuPlugin.getDefault().message(Messages.getString("FastActionMouseHandler.cantPlayThisHere"), null); //$NON-NLS-1$
			return;
		}
		
		// Get mode
		int playMode = -1;
		if(event.button == 1) {
			playMode = MainView.PLAY;
		} else if (event.button == 3) {
			playMode = Template.STRIKE;
		} else {
			return;
		}

		// Undo manager
		UndoManager manager = _view.getUndoManager();
		
		// According to case
		_view.setPlayMode(playMode);
		switch ( playMode ) {
			case MainView.PLAY:
				manager.playPosition(selectedValue);
				break;
				
			case Template.STRIKE:
				manager.toggleMark(selectedValue);
				break;
		}
	}
}
