package tchok.sudoku.gui;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Template;
import tchok.sudoku.prefs.IPrefConstants;

/**
 * Builds (an get) icons....
 * @author Tchok
 */
public class IconBuilder implements IPropertyChangeListener {
	// Separator in key computation
	private static final char SEPARATOR = '_';
	
	// Size of icons
	private static final int SIZE = 24;
	
	// The existing images (these are Image)
	private HashMap<String, Image> _images;

	// The device to use
	private Device _device;

	public IconBuilder(Device device_p) {
		// Init a bit
		_device = device_p;
		_images = new HashMap<String, Image>(30);
		
		// Register to preferences
		SudokuPlugin.getDefault().getUserPreferences().addPropertyChangeListener(this);
	}
	
	/**
	 * Get one.
	 * @param value_p value for the image (likely to be in [1-9])
	 * @param mode_p a play mode from the main view
	 * @param flag_p according to case: play/clear, strike/don't strike...
	 * @return the image (don't dispose it!)
	 */
	public Image getImage(int value_p, int mode_p, boolean flag_p) {
		// get the key
		StringBuffer buffer = new StringBuffer();
		buffer.append(value_p).append(SEPARATOR);
		buffer.append(mode_p).append(SEPARATOR);
		buffer.append(flag_p);
		String key = buffer.toString();
		
		// If it's not in the hash
		if(!_images.containsKey(key)) {
			// Build it
			IFigureProvider figureProvider = FigureProviderFactory.getProvider();
			Image image =
				getImageNoCache(value_p, mode_p, flag_p, figureProvider);
			
			// Store
			_images.put(key, image);
		}
		
		// OK
		return _images.get(key);
	}
	
	/**
	 * Get the image, no cache, you'll dispose from it
	 * @param value_p value for the image (likely to be in [1-9])
	 * @param mode_p a play mode from the main view
	 * @param flag_p according to case: play/clear, strike/don't strike...
	 * @param figureProvider_p what kind of drawing
	 * @return the image, you'll have to dispose from it
	 */
	public Image getImageNoCache(int value_p, int mode_p, boolean flag_p, IFigureProvider figureProvider_p) {
		// Output
		Image image = new Image(_device, SIZE, SIZE);
		
		// And draw now...
		GC gc = new GC(image);
		
		// An empty background
		gc.setBackground(_device.getSystemColor(SWT.COLOR_WHITE));
		gc.fillRectangle(0, 0, SIZE, SIZE);
		
		// A blue border
		gc.setForeground(_device.getSystemColor(SWT.COLOR_BLUE));
		gc.drawRectangle(0, 0, SIZE-1, SIZE-1);
		
		//
		// Target number...
		//
		
		// Init string and font
		figureProvider_p.setArgs(gc, IPrefConstants.DEFAULT_FONT, SIZE / 2);
		
		// Init color
		if(flag_p) {
			gc.setForeground(_device.getSystemColor(SWT.COLOR_BLACK));
		} else {
			gc.setForeground(_device.getSystemColor(SWT.COLOR_GRAY));
		}
		
		// And draw
		figureProvider_p.draw(value_p, SIZE/2, SIZE/2);
		
		//
		// Strike mark
		//
		if(mode_p == Template.STRIKE) {
			gc.setForeground(_device.getSystemColor(SWT.COLOR_RED));
			if(flag_p) {
				gc.setLineStyle(SWT.LINE_SOLID);
			} else {
				gc.setLineStyle(SWT.LINE_DOT);
			}
			gc.drawLine(2, 2, SIZE - 4, SIZE - 4);
		}
		
		// 
		// Done
		//
		gc.dispose();
		
		// OK
		return image;
	}
	/**
	 * Destroy all images
	 */
	public void dispose() {
		// Get them all
		for (Iterator<Image> iter = _images.values().iterator(); iter.hasNext();) {
			iter.next().dispose();
		}
		
		// Clear the map
		_images.clear();
	}

	public void propertyChange(PropertyChangeEvent event) {
		if(event.getProperty().startsWith(IPrefConstants.UI_PREFIX)) {
			dispose();
		}
	}
}
