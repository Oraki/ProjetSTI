package tchok.sudoku.gui;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Template;
import tchok.sudoku.gui.help.StrongLink;
import tchok.sudoku.gui.help.StrongLink.Element;
import tchok.sudoku.prefs.IPrefConstants;
import tchok.swt.graphics.Drawer;

/**
 * @author Tchok
 */
public class BoardDrawer implements IPrefConstants, IDrawerParams, ITransformProvider{
	// The current Transformer
	Transform _transformer;
	Transform _invertedTransformer;
	
	// Auto hide not allowed move ?
	private boolean _hideNotAllowed = SudokuPlugin.getDefault().getUserPreferences().getBoolean(HIDE_NOT_ALLOWED);
	
	// Display sub values
	private boolean _displaySubValues = SudokuPlugin.getDefault().getUserPreferences().getBoolean(SHOW_SUBVALUES);
	
	// Store current state
	private UIState _state;

	// Short cut to it's template
	private Template _template = Template.T33;
	
	// Selection 
	private int _selection = -1;
	
	// Half the size of a the offset from a box (a set of 9? available values)
	private int _halfBigStep = HALF_STEP * 4;

	private int _bigStep = _halfBigStep * 2;
	
	private int _fontSize;
	
	// The full size.
	// @see computeSize
	private int _fullSize = 1;
	
	// Template max size
	private int _templateSize = 1;
	
	// Store a font...
	private Font _font;
	
	// prefix for preferences
	// (likely to be "", expect when printing)
	private String _prefPrefix; 
	
	// Current drawing device
	private Device _device;
	
	// Value to highlight
	private int _valueToHighlight = -1;

	// True to change mark order
	private boolean _revertMarks = false;
	
	/**
	 * this boolean array holds visibility status for cells according to GC
	 * clipping.
	 */
	private boolean _isCellVisible[];

	// Radius of strong links and marks
	private static int MARK_RADIUS = 3 * STEP / 8;

	// Current figure provider
	IFigureProvider _figureProvider;
	
	/**
	 * @param parent
	 */
	public BoardDrawer(Device device_p) {
		this(device_p, ""); //$NON-NLS-1$
	}

	/**
	 * @param parent
	 * @param prefix_p Prefix for resources access ("" or "print.")
	 */
	public BoardDrawer(Device device_p, String prefix_p) {
		_device = device_p;
		_prefPrefix = prefix_p;
		_transformer = new Transform(device_p);
		_invertedTransformer = new Transform(device_p);
	}

	/**
	 * Compute Transform according to new geometry
	 * @param where_p origin
	 * @param size_p size
	 */
	void computeTransform(Point where_p, Point size_p) {
		// Compute transformer
		computeSize();
		Point ptSize = size_p;
		int size = Math.min(ptSize.x, ptSize.y);
		float factor = (float)(size - 30) / _fullSize;
		
		// Get margins
		float tx = (ptSize.x - (_fullSize - SEPARATOR) * factor) / 2 + where_p.x;
		float ty = (ptSize.y - (_fullSize - SEPARATOR) * factor) / 2 + where_p.y;
		
		// Set transformer
		if(_transformer != null) {
			_transformer.dispose();
			_invertedTransformer.dispose();
		}
		_transformer = new Transform(_device, factor, 0f, 0f, factor, tx, ty);
		_invertedTransformer =
			new Transform(_device, factor, 0f, 0f, factor, tx, ty);
		_invertedTransformer.invert();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
	 */
	public void draw(UIState state_p, Point where_p, Point size_p, GC gc_p) {
		// Store a few
		_state = state_p;
		_template = _state.getTemplate();
		
		// Compute transformer
		computeTransform(where_p, size_p);
		
		// Draw
		try {
			doPaint(gc_p);
		} finally {
			gc_p.setTransform(null);
		}
	}

	/**
	 * Dispose it.
	 */
	public void dispose() {
		// Release ressources
		if(_font != null) {
			_font.dispose();
		}
		if(_transformer != null) {
			_transformer.dispose();
			_invertedTransformer.dispose();
		}
	}
	
	/** Real painting */
	void doPaint(GC gc_p) {
		// Update mark order
		_revertMarks = SudokuPlugin.getDefault().getUserPreferences().getBoolean(IPrefConstants.CTRL_USE_KEYBOARD_DISPLAY);
		
		// Update figure provider
		_figureProvider = FigureProviderFactory.getProvider();
		
		// Fix transformer
		gc_p.setTransform(_transformer);
		
		// Refresh cell's visibility
		computeCellsVisibility(gc_p);

		// Surrounding rectangle
		drawBorder(gc_p);
		
		// Draw index grid (background)
		drawGrids(gc_p, true);
		
		// Selection ?
		if (_selection >= 0) {
			drawSelection(gc_p);
		}
		
		// Highlighted values
		drawHighlighted(gc_p);
		
		// Draw index grid (lines)
		drawGrids(gc_p, false);
		
		// Anything to draw ?
		if (_state != null) {
			// Strong links
			drawStrongLinks(gc_p);
			
			// Draw sub values
			drawAllowedMove(gc_p);
			
			// Draw marks
			drawMarks(gc_p);
			
			// Draw current state
			drawCurrentState(gc_p);
			
			// Draw level
			drawCurrentSkill(gc_p);
		}
	}
	
	private void drawCurrentSkill(GC gc_p) {
		// Only when printing...
		if(IPrefConstants.PRINT_PREFIX.equals(_prefPrefix)) {
			// Build String
			String label = Messages.getString(_state.getSkill().name);
			
			// Set font
			UIStringUtil.setGCFont(gc_p, _prefPrefix + VALUE_FONT, SMALL_FONT);
	
			// Draw it
			gc_p.setForeground(getColor(IPrefConstants.GRID_FOREGROUND));
			int where = _bigStep * _template.maxValue;
			UIStringUtil.drawString(gc_p, label, where, where + SMALL_FONT * 2, 2);
		}
	}

	/**
	 * @param gc_p
	 */
	private void drawSelection(GC gc_p) {
		// Forget it ?
		if(_selection < 0) {
			return;
		}
		
		// Fast exit
		if(!_isCellVisible[_selection]) {
			return;
		}
		
		// Selection to position
		int l = _template.indexToRow(_selection);
		int c = _template.indexToColumn(_selection);
		
		// set gc
		gc_p.setBackground(getColor(SELECTION_BACKGROUND));
		gc_p.fillRectangle(getCPos(c), getRPos(l), _bigStep, _bigStep);
	}

	private void drawHighlighted(GC gc_p) {
		// Forget it ?
		if((_valueToHighlight < 0) || !_displaySubValues) {
			return;
		}

		// Loop on indexes
		for(int index=0; index<_template.maxIndex; index++) {
			// Check value
			if(((_state.isAvailable(index, _valueToHighlight) && _hideNotAllowed) 
				|| (_state.isFree(index) && (_state.getMark(index, _valueToHighlight) != Template.STRIKE) && !_hideNotAllowed)) &&
			   _isCellVisible[index]) {
				// Highlight
				
				// Index to position
				int cellLine = _template.indexToRow(index);
				int cellColumn = _template.indexToColumn(index);
				
				// fill cell
				gc_p.setBackground(getColor(HIGHLIGHT_BACKGROUND));
				gc_p.fillRectangle(getCPos(cellColumn), getRPos(cellLine), _bigStep, _bigStep);
				
				// Redraw selection ?
				if(index == _selection) {
					int x= getCPos(cellColumn);
					int y= getRPos(cellLine);
					int[] coords = {
							x, y,
							x+_bigStep, y,
							x, y+_bigStep
					};
					gc_p.setBackground(getColor(SELECTION_BACKGROUND));
					gc_p.fillPolygon(coords);
				}
				
				// underline it
				// Compute pos
				int x = getCPos(cellColumn) + getValueCPos(_valueToHighlight);
				int y = getRPos(cellLine) + getValueRPos(_valueToHighlight);
				
				// draw them
				gc_p.setBackground(_device.getSystemColor(SWT.COLOR_GREEN));
				gc_p.fillOval(	x - MARK_RADIUS, 
								y - MARK_RADIUS, 
								MARK_RADIUS * 2,
								MARK_RADIUS * 2);
			}
		}

	}

	/**
	 * Show strong links. Does not guess if the links are helpful; just
	 * exposes them. !!
	 * 
	 * @param gc_p
	 */
	private void drawStrongLinks(GC gc_p) {
		// Not when printing...
		if (IPrefConstants.PRINT_PREFIX.equals(_prefPrefix)) {
			return;
		}
		
		// Define graphic attributes
		gc_p.setForeground(getColor(ST_LINK_COLOR));
		gc_p.setLineWidth(0);
		
		// Check if filtering on selected value is on
		int filteringValue = -1;
		if(SudokuPlugin.getDefault().getUserPreferences().getBoolean(IPrefConstants.ST_LINK_WITH_SELECTION)) {
			// Get selected value
			filteringValue = _valueToHighlight;
			
			// Forget it all?
			if(filteringValue < 0) {
				return;
			}
		}
		
		// Loop on links
		for (StrongLink link : _state.getStrongLinks()) {
			// Filter on link type according to preferences
			if(!SudokuPlugin.getDefault().getUserPreferences().getBoolean(link.getType().getKey())) {
				// Skip this one
				continue;
			}
			
			// Get points from link
			List<StrongLink.Element> elements = link.getElements();
			
			// Filter on selected value ?
			if(filteringValue >= 0) {
				// Check the link
				boolean drawIt = false;
				for (Element element : elements) {
					if(element.cellValue == filteringValue) {
						// Draw it
						drawIt = true;
						break;
					}
				}
				
				// So what ?
				if(!drawIt) {
					continue;
				}
			}
			
			// Loop on segments to draw link.
			for(int index=1; index<elements.size(); index++) {
				// Get from location
				StrongLink.Element from = elements.get(index-1);
				int c1 = getCPos(_template.indexToColumn(from.cellIndex)) + getValueCPos(from.cellValue);
				int l1 = getRPos(_template.indexToRow(from.cellIndex)) + getValueRPos(from.cellValue);
				
				// Get to location
				StrongLink.Element to = elements.get(index);
				int c2 = getCPos(_template.indexToColumn(to.cellIndex)) + getValueCPos(to.cellValue);
				int l2 = getRPos(_template.indexToRow(to.cellIndex)) + getValueRPos(to.cellValue);
				
				// Get vector
				int vectorX = c2 - c1;
				int vectorY = l2 - l1;
				double hypoth = Math.hypot(vectorX, vectorY);
				double angle = Math.atan2(vectorY, vectorX);
				
				// Compute normal
				int vectorNormalX = (int)(-vectorY * MARK_RADIUS / hypoth);
				int vectorNormalY = (int)(vectorX * MARK_RADIUS / hypoth);
				
				// draw lines
				gc_p.drawLine(	c1 + vectorNormalX, l1 + vectorNormalY, 
						c2 + vectorNormalX, l2 + vectorNormalY);
				gc_p.drawLine(	c1 - vectorNormalX, l1 - vectorNormalY, 
						c2 - vectorNormalX, l2 - vectorNormalY);
				
				// Draw half-circles
				Drawer.drawArc(gc_p, c1, l1, MARK_RADIUS, angle + Math.PI / 2., Math.PI, 5);
				Drawer.drawArc(gc_p, c2, l2, MARK_RADIUS, angle - Math.PI / 2., Math.PI, 5);
			}
		}
	}
	
	/**
	 * @param gc
	 */
	private void drawGrids(GC gc_p, boolean background_p) {
		// Set graphic attributes for sub grid
		gc_p.setForeground(getColor(SUBGRID_FOREGROUND));
		gc_p.setLineWidth(HALF_STEP / 5);
		
		// Just loop on them...
		for(int l=0; l<_template.columns; l++) {
			for(int c=0; c<_template.rows; c++) {
				// Get color
				String colorkey = ((l + c) % 2 == 0) ? GRID_BACKGROUND_0 : GRID_BACKGROUND_1;
				gc_p.setBackground(getColor(colorkey));
				
				// Compute pos
				int x = c * (_bigStep * _template.columns + SEPARATOR);
				int y = l * (_bigStep * _template.rows + SEPARATOR);
				
				// draw
				drawGrid(gc_p, x, y, _bigStep, background_p);
			}
		}
	}

	/**
	 * @param gc_p
	 */
	private void drawCurrentState(GC gc_p) {
		// set font
		_figureProvider.setArgs(gc_p, _prefPrefix + VALUE_FONT, _fontSize);

		// Loop on indexes
		for(int index=0; index<_template.maxIndex; index++) {
			// Something to do
			if(_isCellVisible[index] && !_state.isFree(index)) {
				// Get value
				int value = _state.getValue(index);
				
				// extract pos
				int column = _template.indexToColumn(index);
				int row = _template.indexToRow(index);
				
				// Set color
				if(_state.isOriginalPosition(index)) {
					gc_p.setForeground(getColor(START_VALUE_FOREGROUND));
				} else {
					gc_p.setForeground(getColor(VALUE_FOREGROUND));
				}
				
				// draw
				_figureProvider.draw(value, 
									getCPos(column) + _halfBigStep, 
									getRPos(row)+ _halfBigStep);
			}
		}
		
	}

	/**
	 * @param gc_p
	 */
	private void drawAllowedMove(GC gc_p) {
		// Do it
		if(!_displaySubValues) {
			return;
		}
		
		// Get color
		gc_p.setForeground(getColor(MARK_FOREGROUND));
		
		// set font
		_figureProvider.setArgs(gc_p, _prefPrefix + MARK_FONT, SMALL_FONT);
		
		// Loop on indexes
		for(int index=0; index<_template.maxIndex; index++) {
			// Something to do ?
			if(_isCellVisible[index] && _state.isFree(index)) {
				// Compute pos
				int line = _template.indexToRow(index);
				int column = _template.indexToColumn(index);

				// Loop on values
				for(int value=0; value<_template.maxValue; value++) {
					// test if it should be displayed
					boolean displayIt =  
						!(_hideNotAllowed && !_state.isAllowed(index, value));
					if(displayIt) {
						// Compute pos
						int c = getCPos(column) + getValueCPos(value);
						int l = getRPos(line) + getValueRPos(value);
						
						// draw it
						_figureProvider.draw(value, c, l);
					}
				}
			}
		}
	}
	/**
	 * @param gc_p
	 */
	private void drawMarks(GC gc_p) {
		// Fast exit
		if(!_displaySubValues) {
			return;
		}
		
		// Set colors
		gc_p.setForeground(_device.getSystemColor(SWT.COLOR_RED));
		gc_p.setBackground(_device.getSystemColor(SWT.COLOR_GREEN));
		gc_p.setLineWidth(SEPARATOR / 2);
		
		// Strike offset
		int strikeLength =  3 * STEP / 10;
		
		// Loop on indexes
		for(int index=0; index<_template.maxIndex; index++) {
			// Something to do ?
			if(_isCellVisible[index] && _state.isFree(index)) {
				// Compute position
				int line = _template.indexToRow(index);
				int column = _template.indexToColumn(index);
				
				// Loop on values
				for(int value=0; value<_template.maxValue; value++) {
					// So what do we want to do ?
					// Strike if:
					// 	-target mode is strike
					//  -the value is striked
					//  -the value is displayed (thus !hiding || allowed)
					//
					// highlight if:
					//  -target mode is highlight
					//  -the value is highlighted
					//  -(the value is displayed OR 
					//		the value is the highlighted value) AND
					//   the value is displayed
					
					// Is the value displayed?
					boolean displayed = _state.isAllowed(index, value) || !_hideNotAllowed;
					
					// Get marks for this value
					int mark = _state.getMark(index, value);
					
					// Handle case...
					boolean displayMark = (mark == Template.STRIKE) && displayed;
					
					// is the value displayed ?
					if(displayMark) {
						// Compute pos
						int c = getCPos(column) + getValueCPos(value);
						int l = getRPos(line) + getValueRPos(value);
						
						// draw them
						gc_p.drawLine(	c -strikeLength, l - strikeLength, 
										c + strikeLength, l + strikeLength);
						
					}
				}
			}
		}
	}
	
	/** Display (or don't display) allowed move.*/
	public void drawAllowedMove(boolean value_p) {
		_hideNotAllowed = value_p;
	}
	
	private int getCPos(int squareIndex_p) {
		return squareIndex_p * _bigStep + (squareIndex_p / _template.columns) * SEPARATOR;
	}
	
	private int getRPos(int squareIndex_p) {
		return squareIndex_p * _bigStep + (squareIndex_p / _template.rows) * SEPARATOR;
	}
	
	private int getValueCPos(int value_p) {
		return (value_p % _templateSize) * STEP + HALF_STEP;
	}
	
	private int getValueRPos(int value_p) {
		int offset = (_template.rows == _template.columns) ?
				HALF_STEP : STEP;
		// handle reverted order
		int valueToUse = _revertMarks ? (_template.maxValue - (value_p + 1)) : value_p;
		
		return (valueToUse / _templateSize) * STEP + offset;
	}
	/**
	 * Draw single grid
	 * @param gc_p gc to use
	 * @param start_p start value
	 * @param end_p end value
	 * @param step_p step
	 * @param background_p true to draw the background, false for the lines
	 */
	private void drawGrid(GC gc_p, int x_p, int y_p, int step_p, boolean background_p) {
		// Final values
		int endX = x_p + _template.columns * step_p;
		int endY = y_p + _template.rows * step_p;
		
		// Background
		if(background_p) {
			gc_p.fillRectangle(x_p, y_p, _template.columns * step_p, _template.rows * step_p);
		}
		// Or grid
		else {
			// Loops...
			for(int index=1; index<_template.rows; index++) {
				// Line...
				int y = y_p + index * step_p;
				gc_p.drawLine(x_p, y, endX, y);
			}
			
			// Loops...
			for(int index=1; index<_template.columns; index++) {
				// Line...
				int x = x_p + index * step_p;
				gc_p.drawLine(x, y_p, x, endY);
			}
		}
	}
	
	/**
	 * @param gc_p
	 */
	private void drawBorder(GC gc_p) {
		// Let's show a black rectangle
		// Graphic attributes...
		gc_p.setBackground(getColor(GRID_FOREGROUND));
		// gc_p.setLineWidth(SEPARATOR);
		
		// Position and size
		int from = -SEPARATOR;
		int h = _bigStep * _template.maxValue + (_template.columns + 1) * SEPARATOR;
		int w = _bigStep * _template.maxValue + (_template.rows + 1) * SEPARATOR;
		
		// And draw
		gc_p.fillRectangle(from, from, w, h);
	}
	
	/** Set the new selection and redraw.*/
	public void setSelection(int selection_p) {
		_selection = selection_p;
	}
	
	/**
	 * @return the current selection.
	 */
	public int getSelection() {
		return _selection;
	}

	/**
	 * @param target_p true to display sub grid
	 */
	public void showSubValues(boolean target_p) {
		_displaySubValues = target_p;
	}

	/** Compute size. */
	public int computeSize() {
		_templateSize = Math.max(_template.columns, _template.rows);
		_halfBigStep = HALF_STEP * _templateSize;
		_bigStep = _halfBigStep * 2;
		_fullSize = STEP * _template.maxValue * _templateSize + _template.rows * SEPARATOR;
		_fontSize = _halfBigStep;
		return _fullSize;
	}
	
	
	/**
	 * @param target_p true to hide not allowed moves.
	 */
	public void hideNotAllowed(boolean target_p) {
		_hideNotAllowed = target_p;
	}

	/**
	 * @return
	 */
	public boolean isShowingSubValues() {
		return _displaySubValues;
	}

	/**
	 * @return
	 */
	public boolean isHiddingNotAllowed() {
		return _hideNotAllowed;
	}

	/**
	 * @param template_p
	 */
	public void setTemplate(Template template_p) {
		_template = template_p;
		
	}

	/**
	 * Given a point (in pixels) get the equivalent through the inverted
	 * transformation.
	 * 
	 * @param x_p
	 * @param y_p
	 * @return Point
	 */
	public Point pixelToPoint(int x_p, int y_p) {
		float [] args = { x_p, y_p};
		_invertedTransformer.transform(args);
		return new Point((int)args[0], (int)args[1]);
	}
	
	private Color getColor(String name_p) {
		// Some cases are dummy !
		String localName = name_p;
		if(IPrefConstants.PRINT_PREFIX.equals(_prefPrefix)) {
			if(IPrefConstants.START_VALUE_FOREGROUND.equals(name_p)) {
				localName = IPrefConstants.VALUE_FOREGROUND;
			} 
		}
		return SudokuPlugin.getDefault().getColor(_prefPrefix + localName);
	}

	public Transform getInvertedTransform() {
		return _invertedTransformer;
	}

	public Transform getTransform() {
		return _transformer;
	}

	public void setValueToHighlight(int value_p) {
		// Store and refresh
		_valueToHighlight = value_p;
	}

	/**
	 * Get a cell bounding box
	 * @param index_p cell's index
	 * @param local_p true for local, false for pixel ref
	 * @return the cell's bounding box
	 */
	public Rectangle getBoundingBox(int index_p, boolean local_p) {
		// Compute pos
		int line = _template.indexToRow(index_p);
		int column = _template.indexToColumn(index_p);
		
		// Extract bounding box
		Rectangle box = new Rectangle(getCPos(column), getRPos(line), _bigStep, _bigStep);

		// transform
		if(!local_p) {
			// transform to floats
			float coords[] = new float[] {
					box.x, box.y,
					box.x + box.width, box.y + box.height
			};
			
			// transform
			_transformer.transform(coords);
			
			// Make it a rectangle
			box = new Rectangle((int)floor(coords[0]), (int)floor(coords[1]),
								(int)ceil(coords[2] - coords[0]) + 1, (int)ceil(coords[3] - coords[1]) + 1);
		}
		
		// OK
		return box;
	}
	
	/**
	 * Refresh the cell's visibility array
	 * @param gc_p drawing GC (with transformer set)
	 */
	private void computeCellsVisibility(GC gc_p) {
		// Extract clipping
		// TODO - Use GC.clipping(region) but SWT does'nt transform it!
		Rectangle clipping = gc_p.getClipping();
		
		// Allocate ?
		if( (_isCellVisible == null) ||
			(_isCellVisible.length != _template.maxIndex)) {
			_isCellVisible = new boolean[_template.maxIndex];
		}
		
		// Loop on cells
		for (int index = 0; index < _isCellVisible.length; index++) {
			// Extract bounding box
			Rectangle box = getBoundingBox(index, true);
			
			// Fill array
			_isCellVisible[index] = clipping.intersects(box);
		}
	}

	public int getValueToHighlight() {
		return _valueToHighlight;
	}
}