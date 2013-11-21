package tchok.sudoku.gui;

import org.eclipse.swt.graphics.GC;

/**
 * Root interface for figures provider.
 * A figure provider is able to draw a value and to fetch it back from a string.
 * This enable playing with figures, letters symbols and so on.
 */
public interface IFigureProvider {
	
	/**
	 * Set args for drawing.
	 * @param gc_p gc to use
	 * @param case_p maybe a font key in the preferences
	 * @param size_p close to a font size.
	 */
	public void setArgs(GC gc_p, String case_p, int size_p);
	
	/**
	 * Draw value.
	 * @param value value to draw 
	 * @param x center x
	 * @param y center y
	 */
	public void draw(int value, int x, int y);
	
	/**
	 * Convert a string to a value
	 * @param str_p string to read
	 * @return value or -1 when no value is found
	 */
	public int valueFromChar(char str_p);
	
	/**
	 * Does a char match any of the figures?
	 * @param char_p char to test
	 * @return true when it's in a figure
	 */
	public boolean acceptChar(char char_p);

}
