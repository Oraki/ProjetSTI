package tchok.sudoku.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import tchok.sudoku.IEventTypes;
import tchok.sudoku.core.Template;
import tchok.tools.events.TEvent;
import tchok.tools.events.TEventManager;

/**
 * Handles selection by the keyboard.
 * @author Tchok
 */
public class SelectionKeyHandler implements Listener {
	// the board
	Board _board;
	
	// The control registering event handler
	Control _control;
	
	/** Construct and install.*/
	public SelectionKeyHandler(Board board_p, Control control_p) {
		_board = board_p;
		_control = control_p;
		control_p.addListener(SWT.KeyDown, this);
	}

	/** Dispose from it.*/
	public void dispose() {
		_control.removeListener(SWT.KeyDown, this);
	}
	
	public void handleEvent(Event event) {
		// Just delegate to methods
		handleSelectedIndex(event);
		handleSelectedValue(event);
	}
	
	/**
	 * Handles arrow keys to update selection.
	 */
	void handleSelectedIndex(Event event_p) {
		// Move selection
		int key  = event_p.keyCode;
		int deltaL = 0;
		int deltaC = 0;
		switch (key) {
			case SWT.ARROW_UP:
				deltaL = -1;
				break;
			
			case SWT.ARROW_DOWN:
				deltaL = 1;
				break;	
			
			case SWT.ARROW_LEFT:
				deltaC = -1;
				break;
				
			case SWT.ARROW_RIGHT:
				deltaC = 1;
				break;
		}
		
		// Handle it...
		if((deltaC !=0) || (deltaL != 0)) {
			// new position
			int current = _board.getSelection();
			if(current < 0) {
				current = 0;
			}
			Template tpl = _board.getState().getTemplate();
			int l = (tpl.indexToRow(current) + deltaL + tpl.maxValue) % tpl.maxValue;
			int c = (tpl.indexToColumn(current) + deltaC + tpl.maxValue) % tpl.maxValue;
			
			// Store it
			_board.setSelection(l * tpl.maxValue + c);
		}
	}
	
	/**
	 * Handle selected value.
	 * @param event_p source event
	 */
	void handleSelectedValue(Event event_p) {
		// Read key
		int key = event_p.keyCode;
		
		// handle page up/down
		int delta = 0;
		switch(key) {
		case SWT.PAGE_UP:
			delta = +1;
			break;
			
		case SWT.PAGE_DOWN:
			delta = -1;
			break;
		}
		
		// Handle it
		if(delta != 0) {
			TEvent event = new TEvent(IEventTypes.HIGHLIGHT_SELECTION_RQ, event_p.widget, new Integer(delta));
			TEventManager.getInstance().fireEvent(event);
		}
	}
}