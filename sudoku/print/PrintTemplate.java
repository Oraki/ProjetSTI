package tchok.sudoku.print;

import java.text.MessageFormat;

import org.eclipse.swt.graphics.Rectangle;

/**
 * @author Tchok
 */
public class PrintTemplate implements IPrintTemplate {
	/** Predefined .*/
	public static final PrintTemplate PT4x3 = new PrintTemplate(4, 3);
	public static final PrintTemplate PT3x2 = new PrintTemplate(3, 2);
	public static final PrintTemplate PT2x1 = new PrintTemplate(2, 1);
	public static final PrintTemplate PT1x1 = new PrintTemplate(1, 1);
	public static final PrintTemplate TEMPLATES[] = { PT4x3, PT3x2, PT2x1, PT1x1 };
	
	// Don't print it to clowned
	private static final double SPACE_COEF = 0.9;
	
	// Number of sheets per columns
	private int _columns;
	
	// Number of sheets per row
	private int _rows;
	
	// X margin
	private int _xMargin;
	
	// Y margin
	private int _yMargin;
	
	// X step
	private int _xStep;
	
	// Y Step
	private int _yStep;
	
	// Size
	private int _size;
	
	// Name
	public String name;
	
	/** Get one. */
	public PrintTemplate(int row_p, int column_p) {
		// Store a few
		_columns = column_p;
		_rows = row_p;
		name = _columns + "x" + _rows; //$NON-NLS-1$
	}
	
	/**
	 * @return the number of sheets per page.
	 */
	public int getSheetsPerPage() {
		return _columns * _rows;
	}
	
	/**
	 * @param index_p Sheet's index
	 * @return Sheet's bounds
	 */
	public Rectangle getBounds(int index_p) {
		// Compute a few
		
		// Which one is this ?
		int col = index_p % _columns;
		int row = index_p / _columns;
		
		// Origin
		int x = _xMargin + col * _xStep;
		int y = _yMargin + row * _yStep;
		
		// OK
		return new Rectangle(x, y, _size, _size);
	}
	
	public String getLabel() {
		// Args are template size.
		Object args[] = new Object[] {
				new Integer(_rows),
				new Integer(_columns)
		};
		return MessageFormat.format(Messages.getString("PrintTemplate.label"), args); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see tchok.sudoku.print.IPrintTemplate#setClientArea(org.eclipse.swt.graphics.Rectangle)
	 */
	public void setPrinterData(Rectangle area_p) {
		// First values
		_xStep = (int) ((area_p.width * SPACE_COEF) / _columns);
		_yStep = (int) ((area_p.height * SPACE_COEF) / _rows);
		
		// But a single size !
		_size = Math.min(_xStep, _yStep);
		
		// So what's left ?
		// On x
		int spare = (area_p.width - _size * _columns) / (_columns + 1);
		_xMargin = spare;
		_xStep = _size + spare;
		
		// On y
		spare = (area_p.height - _size * _rows) / (_rows + 1);
		_yMargin = spare;
		_yStep = _size + spare;
	}
}