package tchok.sudoku.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Template;

/**
 * @author Tchok
 */
public class Board extends Canvas implements PaintListener, ITransformProvider {
	// Store current state
	private UIState _state;

	// Short cut to it's template
	private Template _template;
	
	private BoardDrawer _drawer;
	
	// Pending selection (when the selection is locked)
	private int _pendingSelection = 0;
	
	// Locked selection flag
	private boolean _selectionIsLocked = false;
	
	/**
	 * @param parent_p
	 * @param style_p
	 */
	public Board(Composite parent_p, int style_p) {
		super(parent_p, style_p | SWT.DOUBLE_BUFFERED);
		
		// delegates paint events to drawer
		addPaintListener(this);
		_drawer = new BoardDrawer(getDisplay());
		
		// looks good !
		Image background =
			SudokuPlugin.getDefault().getImage("icons/background.png"); //$NON-NLS-1$
		setBackgroundImage(background);
		
		// handle the wheel
		new MouseWheelHandler(this);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
	 */
	public void paintControl(PaintEvent event_p) {
		// Draw the board
		_drawer.draw(_state, getLocation(), getSize(), event_p.gc);
	}

	/** Store a new state. */
	public void setState(UIState state_p) {
		// Store and refresh
		_state = state_p;
		
		// update template ?
		if(_template != _state.getTemplate()) {
			_template = _state.getTemplate();
			_drawer.setTemplate(_template);
		}
		
		// Redraw
		redraw();
		
		// save state
		SudokuPlugin.saveCurrentState(state_p);
	}
	
	/** Get the current state. */
	public UIState getState() {
		return _state;
	}
	
	/** Display (or don't display) allowed move.*/
	public void drawAllowedMove(boolean value_p) {
		_drawer.drawAllowedMove(value_p);
		redraw();
	}
	
	/** Set the new selection and redraw.*/
	public void setSelection(int selection_p) {
		// Locked ?
		if(_selectionIsLocked) {
			// Just store
			_pendingSelection = selection_p;
		}
		
		// Not locked
		else {
			if(selection_p != getSelection()) {
				int lastValue = getSelection();
				_drawer.setSelection(selection_p);
				redrawCell(lastValue);
				redrawCell(selection_p);
				//redraw();
			}
		}
	}
	
	void redrawCell(int index_p) {
		if(index_p != -1) {
			// Get location
			Rectangle bounds = _drawer.getBoundingBox(index_p, false);
			redraw(bounds.x, bounds.y, bounds.width, bounds.height, false);
		}
	}
	
	/**
	 * @return the current selection.
	 */
	public int getSelection() {
		return _drawer.getSelection();
	}

	/**
	 * @param target_p true to display sub grid
	 */
	public void showSubValues(boolean target_p) {
		_drawer.showSubValues(target_p);
	}

	/**
	 * @param target_p true to hide not allowed moves.
	 */
	public void hideNotAllowed(boolean target_p) {
		_drawer.hideNotAllowed(target_p);
	}

	/**
	 * @return
	 */
	public boolean isShowingSubValues() {
		return _drawer.isShowingSubValues();
	}

	/**
	 * @return
	 */
	public boolean isHiddingNotAllowed() {
		return _drawer.isHiddingNotAllowed();
	}

	/**
	 * @param x_p
	 * @param y_p
	 */
	public void pointToSelection(int x_p, int y_p) {
		// New selection
		int selection = -1;
		
		// Get the inverted location
		Point where = _drawer.pixelToPoint(x_p, y_p);
		int iX = where.x;
		int iY = where.y;
		
		// Check it
		if((iX > 0) && (iY>0)) {
			// Transform to cell index
			int size = _drawer.computeSize();
			iX = (iX * _template.maxValue) / size;
			iY = (iY * _template.maxValue) / size;
			
			// Check case
			if((iX >= 0) && (iY >=0) &&
			    (iX <_template.maxValue) && (iY < _template.maxValue) ) {
				// Compute index
				selection = iX + iY * _template.maxValue;
			}
		}
		setSelection(selection);
		//redraw();
	}
	
	/**
	 * Lock/unlock selection.
	 * @param state_p
	 */
	public void lockSelection(boolean state_p) {
		if(state_p) {
			// Store datas
			_pendingSelection = getSelection();
			_selectionIsLocked = true;
		} else {
			_selectionIsLocked = false;
			setSelection(_pendingSelection);
		}
	}

	public Transform getInvertedTransform() {
		return _drawer.getInvertedTransform();
	}

	public Transform getTransform() {
		// Refresh it
		_drawer.computeTransform(getLocation(), getSize());
		
		// Return it
		return _drawer.getTransform();
	}

	public void setValueToHighlight(int value_p) {
		// propagate and refresh
		_drawer.setValueToHighlight(value_p);
		redraw();
	}
	
	public int getValueToHighlight() {
		return _drawer.getValueToHighlight();
	}
}