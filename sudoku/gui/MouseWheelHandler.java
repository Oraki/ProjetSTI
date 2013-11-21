package tchok.sudoku.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import tchok.sudoku.IEventTypes;
import tchok.tools.events.TEvent;
import tchok.tools.events.TEventManager;

/**
 * Convenience class to link the mouse whell to highlighted value.
 * @author Tchok
 */
public class MouseWheelHandler implements Listener {

	/**
	 * Add a listener to the control, and fire update events.
	 * @param control_p
	 */
	public MouseWheelHandler(Control control_p) {
		// add a listener to the control
		control_p.addListener(SWT.MouseWheel, this);
		control_p.addListener(SWT.MouseEnter, this);
	}
	
	/**
	 * Handles the wheel.
	 */
	public void handleEvent(Event event) {
		switch ( event.type) {
			// Mouse down, gain focus
			case SWT.MouseEnter:
				((Control)event.widget).setFocus();
				break;

			// Mouse wheel
			case SWT.MouseWheel:
				// Up or down ?
				int delta = event.count > 0 ? 1 : 
						(event.count < 0 ? -1 : 0);

				// Dummy case...
				if(delta == 0) return;
		
				// Fire an event
				TEvent tEvent = new TEvent(IEventTypes.HIGHLIGHT_SELECTION_RQ, event.widget, new Integer(delta));
				TEventManager.getInstance().fireEvent(tEvent);
				break;
		}
	}

}
