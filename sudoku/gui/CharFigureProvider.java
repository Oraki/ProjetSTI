package tchok.sudoku.gui;

import org.eclipse.swt.graphics.GC;

public class CharFigureProvider implements IFigureProvider {
	static public final String LETTERS = "abcdefghijkl"; //$NON-NLS-1$
	static public final String NUMBERS = "123456789abc"; //$NON-NLS-1$
//	static public final String SYMBOLS = "+&%$?€§µ£!Ox"; //$NON-NLS-1$
	static public final String SYMBOLS = "\u0023\u0024\u0025\u0026\u00b5\u003f\u00A3\u00A4\u00A7\u00A9\u00B6\u00D8"; //$NON-NLS-1$

	// Current chars
	String _chars = NUMBERS;
	
	// Drawing GC (transient)
	private GC _gc;
	
	/**
	 * Get one
	 * @param chars chars to use
	 */
	public CharFigureProvider(String chars) {
		_chars = chars;
	}
	
	public void draw(int value, int x, int y) {
		// Get String
		String str = getString(value);
		
		// draw it
		UIStringUtil.drawString(_gc, str, x, y, 1);
	}

	public void setArgs(GC gc_p, String case_p, int size_p) {
		_gc = gc_p;
		UIStringUtil.setGCFont(gc_p, case_p, size_p);
	}

	public int valueFromChar(char str_p) {
		// Scan for it
		return _chars.indexOf(str_p);
	}

	public boolean acceptChar(char char_p) {
		return _chars.indexOf(char_p) != -1;
	}
	
	/**
	 * Transform a value to a string.
	 * @param value_p value to get
	 * @return the string
	 */
	protected String getString(int value_p) {
		return _chars.substring(value_p, value_p+1);
	}
}
