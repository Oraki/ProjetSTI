package tchok.sudoku.print;

import org.eclipse.swt.graphics.Rectangle;

/**
 * Describe a print layout
 * @author Tchok
 */
public interface IPrintTemplate {
	/** 
	 * @return the number of sheets per page.
	 */
	public int getSheetsPerPage();

	/**
	 * Please set the client ares before !
	 * @param index_p Sheet's index
	 * @return Sheet's bounds
	 */
	public Rectangle getBounds(int index_p);
	
	/**
	 * Set the client area.
	 * @param area_p client area of the printer
	 */
	public void setPrinterData(Rectangle area_p);
	
	/** Get a label for it. */
	public String getLabel();
}