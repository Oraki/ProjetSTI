package tchok.sudoku.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * Handles the mouse events relative to the selection.
 * @author Tchok
 */
public class SelectionMouseHandler implements Listener {
	// The board
	Board _board;
	
	/** 
	 * Get one.
	 * @param board_p client board
	 */
	SelectionMouseHandler(Board board_p) {
		// Store board
		_board = board_p;
		
		// Handled events
		int[] events = {
				SWT.MouseDoubleClick,
				SWT.MouseMove,
				SWT.MouseDown,
				SWT.MouseExit,
		};
		
		// Register has a listener.
		for (int i = 0; i < events.length; i++) {
			_board.addListener(events[i], this);
		}
	}
	
	/**
	 * Update selection according to event's location.
	 */
	public void handleEvent(Event event_p) {
		// Just ask the board itself !
		_board.pointToSelection(event_p.x, event_p.y);
	}
}