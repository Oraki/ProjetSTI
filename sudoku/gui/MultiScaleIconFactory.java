package tchok.sudoku.gui;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;

import tchok.sudoku.SudokuPlugin;
import tchok.swt.graphics.MultiScaleIcon;

// TODO Debug
@SuppressWarnings("nls")
public class MultiScaleIconFactory {
	static final String PREFIX = "images/";
	static final String[] SIZES = {
		"16", "24", "32", "48", "64", "72", "128", "256"
	};
	static final String[] NAMES = {
		"monkey", "parrot", "fish", "penguin", 
		"dog", "rhino", 
		"marine_star", "turtle", "giraffe",  
		"octopus", "boo", "toad"
	};
	public static MultiScaleIcon[] getIcons(Device device_p) {
		MultiScaleIcon[] output = new MultiScaleIcon[NAMES.length];
		for (int nameIndex = 0; nameIndex < NAMES.length; nameIndex++) {
			Image[] images = new Image[SIZES.length];
			for (int sizeIndex = 0; sizeIndex < SIZES.length; sizeIndex++) {
				String file = PREFIX + NAMES[nameIndex] + "_" + SIZES[sizeIndex] + ".png";
				images[sizeIndex] = SudokuPlugin.getDefault().getImage(file);
			}
			output[nameIndex] = new MultiScaleIcon(device_p, images);
		}
		return output;
	}
}
