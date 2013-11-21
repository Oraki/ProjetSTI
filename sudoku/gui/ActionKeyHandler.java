package tchok.sudoku.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import tchok.sudoku.core.State;

/**
 * @author Tchok
 */
public class ActionKeyHandler implements Listener {
	// Allowed delay between keys
	static final long KEY_DELAY = 300l;
	
	// The same, but with a security margin
	static final long KEY_DELAY_WITH_SECURITY = KEY_DELAY - 20l;
	
	// The view
	MainView _view;
	
	// The board
	Board _board;
	
	// The control listening to events
	Control _control;
	
	/** Build and install .*/
	public ActionKeyHandler(MainView view_p, Control control_p) {
		_view = view_p;
		_board = view_p.getBoard();
		_control = control_p;
		_control.addListener(SWT.KeyDown, this);
	}
	
	/** Dispose from it.*/
	public void dispose() {
		_control.removeListener(SWT.KeyDown, this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
	 */
	public void handleEvent(Event event_p) {
		// Get it
		char key = event_p.character;

		// Is it a number ?
		if(FigureProviderFactory.getProvider().acceptChar(key)) {
			// handle it
			handleFigureKey(key);
		}	
		
		// More action ?
		else {
			// Toggle mode
			if(' ' == key) {
				_view.rotatePlayMode();
			}
			
			// Clear value
			if(_view.getPlayMode() == MainView.PLAY) {
				switch ( event_p.keyCode ) {
					case SWT.DEL:
					case 8: // Backspace has no SWT entry ?
						_view.getUndoManager().clearPosition();
				}
			}
		}
	}

	/**
	 * Handle key when it's a number...
	 * @param value_p key value (as a number)
	 */
	void handleFigureKey(char key_p) {
		// Get current state
		State state = _board.getState();
		
		// Get selection
		int selection = _board.getSelection();
		if(selection < 0) {
			return;
		}
		
		// Do nothing on original position
		if(state.isOriginalPosition(selection)) {
			return;
		}
		
		// If mode is PLAY and current value is not null, clear it
		if(	(_view.getPlayMode() == MainView.PLAY) &&
			!state.isFree(selection)) {
			// Clear it
			_view.getUndoManager().clearPosition();
		} else {
			// Only keep allowed
			int value = FigureProviderFactory.getProvider().valueFromChar(key_p);
			if(value >= state.getTemplate().maxValue || value < 0) {
				return;
			}
			
			// According to mode
			if(_view.getPlayMode() == MainView.PLAY) {
				// Is it a free place ?
				if(state.isFree(selection)) {
					// Play it
					_view.getUndoManager().playPosition(value);
				} 
			} else {
				// This is mark mode !
				if(state.isFree(selection)) {
					_view.getUndoManager().toggleMark(value);
				}
			}
		}
	}
}
