package tchok.sudoku.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import tchok.sudoku.IEventTypes;
import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Template;
import tchok.sudoku.prefs.IPrefConstants;
import tchok.tools.events.TEvent;
import tchok.tools.events.TEventListener;
import tchok.tools.events.TEventManager;

/**
 * A control to select a value to highlight.
 * @author Tchok
 */
public class HighlightValueSelector extends Canvas implements TEventListener, IDrawerParams, IPrefConstants, Listener {

	/** Current template. */
	Template _template;
	
	/** max value (number of cells). */
	int _maxValue;
	
	/** The transformer provider. */
	ITransformProvider _transformerProvider;
	
	/** A cell size. */
	int _cellSize;
	
	/** Font Size. */
	int _fontSize;
	
	/** current selection. */
	int _selection = -1;
	
	/** Selection key handler.*/
	SelectionKeyHandler _selectionKeyhandler;
	
	/** Action key handler */
	ActionKeyHandler _actionKeyHandler;
	
	/**
	 * get one.
	 * @param board_p the board to work with
	 */
	public HighlightValueSelector(MainView view_p, Control control_p) {
		super(control_p.getParent(), SWT.DOUBLE_BUFFERED);
		
		// Store datas...
		_transformerProvider = view_p.getBoard();
		
		// Set background image
		Image background =
			SudokuPlugin.getDefault().getImage("icons/background.png"); //$NON-NLS-1$
		setBackgroundImage(background);
		
		//Default init
		setTemplate(Template.T33);
		
		// handle paint rq and mouse
		int events[] = {
				SWT.MouseUp,
				SWT.Paint
		};
		for (int i = 0; i < events.length; i++) {
			addListener(events[i], this);
		}
		
		// Handle key events
		_selectionKeyhandler = new SelectionKeyHandler(view_p.getBoard(), this);
		_actionKeyHandler = new ActionKeyHandler(view_p, this);
		
		// Handle templates events
		TEventManager.getInstance().addListener(IEventTypes.TEMPLATE_CHANGED, this);
		TEventManager.getInstance().addListener(IEventTypes.HIGHLIGHT_SELECTION_RQ, this);
		
		// Handle the mouse wheel
		new MouseWheelHandler(this);
	}

	/**
	 * Set max value (starting at 0, drawn as 1).
	 * @param value_p target value.
	 */
	public void setTemplate(Template template_p) {
		// Store 
		_template = template_p;
		_maxValue = _template.maxValue + 1;
		
		// geometrical implications...
		_cellSize = Math.max(_template.rows, _template.columns) * STEP;
		_fontSize = _cellSize / 2;
		
		// Clean selection
		setSelection(-1);
		
		// And redraw
		getParent().layout(true);
		redraw();
	}
	
	/** Do paint the canvas... */
	void updateTransformAndPaint(GC gc_p) {
		// Get board transformer...
		Transform boardTransform =
			_transformerProvider.getTransform();
		
		// Transform some points, to evaluate translation
		float[] coords = new float[] {
			0, 0,
			_cellSize, _cellSize  * _maxValue + SEPARATOR * _template.rows
		};
		boardTransform.transform(coords);
		
		// Extract transformed size...
		float width = coords[2] - coords[0];
		
		// Extract offsets
		Point size = getSize();
		float xOffset = (size.x - width) / 2;
		
		// Make a transformer for that...
		// Extract elements
		float[] coefs = new float[6];
		boardTransform.getElements(coefs);
		
		// A transform is a resource, so...
		Transform transform = null;
		try {
			// Update x position 
			coefs[4] = xOffset;
			transform =  new Transform(	getDisplay(), coefs);
			
			// and draw...
			gc_p.setTransform(transform);
			doPaint(gc_p);
		} finally {
			// clean and leave...
			gc_p.setTransform(null);
			if(transform != null) {
				transform.dispose();
			}
		}
	}

	/**
	 * Effective drawing...
	 * @param gc_p drawing context.
	 */
	private void doPaint(GC gc_p) {
		// Main grid
		gc_p.setBackground(SudokuPlugin.getDefault().getColor(GRID_FOREGROUND));
		gc_p.fillRectangle(	-SEPARATOR, 
							-SEPARATOR, 
							_cellSize + 2 * SEPARATOR,
							_cellSize * _template.maxValue + SEPARATOR * (_template.columns + 1));
		
		// background, sub grid and values
		gc_p.setLineWidth(HALF_STEP / 5);
		int partHeight = _template.rows * _cellSize;
		for(int i=0; i<_template.columns; i++) {
			// Background
			String colorKey = (( i % 2) == 0) ? GRID_BACKGROUND_0 : GRID_BACKGROUND_1;
			gc_p.setBackground(SudokuPlugin.getDefault().getColor(colorKey));
			
			// Rectangle
			gc_p.fillRectangle(	0, 
								i * (partHeight + SEPARATOR), 
								_cellSize, 
								partHeight);
			
			// subgrid 
			gc_p.setForeground(SudokuPlugin.getDefault().getColor(SUBGRID_FOREGROUND));
			for(int j=1; j<_template.rows; j++) {
				// Sub grid
				gc_p.drawLine(	0,
								i * (partHeight + SEPARATOR) + j * _cellSize,
								_cellSize,
								i * (partHeight + SEPARATOR) + j * _cellSize);
			}
			
			// Values and selection
			gc_p.setForeground(SudokuPlugin.getDefault().getColor(START_VALUE_FOREGROUND));
			gc_p.setBackground(SudokuPlugin.getDefault().getColor(HIGHLIGHT_BACKGROUND));
			
			// Prepare figure provider
			IFigureProvider figureProvider = FigureProviderFactory.getProvider();

			figureProvider.setArgs(gc_p, VALUE_FONT, _fontSize);

			// Loop on values
			for(int j=0; j<_template.rows; j++) {
				// Value in a string
				int valueInt = i * _template.rows + j;
				
				// selection
				if(valueInt == _selection) {
					gc_p.fillRectangle(	0,
										i * (partHeight + SEPARATOR) + j * _cellSize,
										_cellSize,
										_cellSize);
				}
				
				// Value
				figureProvider.draw(i * _template.rows + j, _cellSize / 2, i * (partHeight + SEPARATOR) + j * _cellSize + _cellSize / 2);
			}
		}
	}
	
	/**
	 * Handles SWT events.
	 * (Mouse up)
	 */
	public void handleEvent(Event event) {
		// According to event type
		switch ( event.type ) {
		
		// Paint
		case SWT.Paint:
			updateTransformAndPaint(event.gc);
			break;
			
		// Mouse up, change selection
		case SWT.MouseUp: 
			{
				// Extract location...
				// Will use the board drawer
				float[] coords = new float[] {
						event.x, event.y
				};
				_transformerProvider.getInvertedTransform().transform(coords);
				
				// Transform this back to a value...
				// TODO - not very accurate!
				int value = (int) (coords[1] / _cellSize); 
				
				// Toggle behavior
				if(_selection == value) {
					setSelection(-1);
				} else {
					setSelection(value);
				}
			}
			break;

		// wheel - update selection
		case SWT.MouseWheel:
			{	
				// Update selection
				int delta = event.count > 0 ? 1 : 
					(event.count < 0 ? -1 : 0);
				int target = _selection + delta;
				
				// Apply limits
				// (from -1 (no selection) to _maxValue
				// this will cycles through values, allowing no selection.
				target = (target + _maxValue) % _maxValue;
				if(target == _template.maxValue) {
					target = -1;
				}
				
				// set selection
				setSelection(target);
			}
			break;
		}
	}

	/**
	 * Update the selection.
	 * Fires an event and redraws.
	 * @param value_p the new value
	 */
	void setSelection(int value_p) {
		// Forget it ?
		if(_selection != value_p) {
			// No don't
			_selection = value_p;
			
			// Fire an event and redraw
			TEventManager.getInstance().fireEvent(
					new TEvent(	IEventTypes.HIGHLIGHT_SELECTION,
								this,
								new Integer(_selection)));
			
			// redraw
			redraw();
		}
	}
	
	int getSelection() {
		return _selection;
	}
	
	/**
	 * Overriden to dispose from listeners.
	 */
	@Override
	public void dispose() {
		// Forget listener
		TEventManager.getInstance().removeListener(this);
		_actionKeyHandler.dispose();
		_selectionKeyhandler.dispose();
		super.dispose();
	}

	/**
	 * Handles Sudoku events.
	 * TEMPLATE_CHANGED: 		refresh and clear selection.
	 * HIGHLIGHT_SELECTION_RQ:	update value to highlight and fire event.
	 */
	public void handleEvent(final TEvent event_p) {
		// Not too late ?
		if(isDisposed()) {
			// probably already done, but ...
			TEventManager.getInstance().removeListener(this);
		}
		
		// Async exec...
		Runnable runner = new Runnable() {
			public void run() {
				// According to event
				switch ( event_p.type) {
					case IEventTypes.TEMPLATE_CHANGED:
						// redraw
						setTemplate((Template) event_p.data);
						break;
						
					case IEventTypes.HIGHLIGHT_SELECTION_RQ:
					{
						// New value
						int target = _selection - ((Integer)event_p.data).intValue();
						
						// Apply limits
						// (from -1 (no selection) to _maxValue
						// this will cycles through values, allowing no selection.
						target = (target + _maxValue) % _maxValue;
						if(target == _template.maxValue) {
							target = -1;
						}
						
						// set selection
						setSelection(target);
					}
				}
			}
		};
		getDisplay().asyncExec(runner);
	}
}
