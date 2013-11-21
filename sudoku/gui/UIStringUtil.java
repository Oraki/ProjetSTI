package tchok.sudoku.gui;

import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

import tchok.sudoku.SudokuPlugin;

/**
 * Dummy class to share string utilities...
 * @author Tchok
 */
public class UIStringUtil {
	/** Cache a font, to dispose it later... */
	private static Font __font;
	
	/**
	 * Set GC font from property.
	 * @param gc_p the GC to update
	 * @param propertyKey_p key of the property to use
	 * @param size_p font's size
	 */
	public static void setGCFont(GC gc_p, String propertyKey_p, int size_p) {
		// get fontdata from properties
		FontData fontData = 
			PreferenceConverter.getFontData(SudokuPlugin.getDefault().getUserPreferences(), 
											propertyKey_p);
		
		// Dispose from the old one
		if(__font != null) {
			__font.dispose();
		}
		
		// Get font
		// Strangly, the best way I found to do it is to get the
		// font from the Display, without handling any transformation.
		// (It should come from the _device ?)
		__font = new Font(Display.getDefault(), fontData.getName(), size_p, fontData.getStyle());
		
		// And set it
		gc_p.setFont(__font);
	}
	
	/**
	 * Draw a String.
	 * @param string_p string to draw
	 * @param xlabel_p x center
	 * @param ylabel_p y center
	 * @param align_p align mode (-1, 0, 1) for (LEFT, CENTER, RIGHT)
	 */
	public static void drawString(GC gc_p, String string_p, int xlabel_p, int ylabel_p, int align_p) {
		// Compute dim
		Point extent = gc_p.stringExtent(string_p);
		int height = extent.y;
		int width = extent.x;

		// Delta X
		// This looks strange, but is correct!
		int deltaX = width * align_p / 2;

		// draw
		gc_p.drawString(string_p, xlabel_p - deltaX, ylabel_p - ((height / 2) + 1), true);
	}

}
