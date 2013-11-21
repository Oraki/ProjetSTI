package tchok.sudoku.gui;

/**
 * Share some drawing params...
 * @author Tchok
 */
public interface IDrawerParams {
	// The big square separator
	public static final int SEPARATOR = 18;
	
	// half the size of a value marker.
	public static final int HALF_STEP = SEPARATOR * 2;
	
	// The size of a value marker
	public static final int STEP = HALF_STEP * 2;
	
	// Small font size
	public static final int SMALL_FONT = HALF_STEP;
}
