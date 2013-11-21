package tchok.sudoku.gui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Tchok
 */
public class Messages {
	private static final String BUNDLE_NAME = "tchok.sudoku.gui.messages";//$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
		// NOP
	}

	public static String getString(String key_p) {
		try {
			return RESOURCE_BUNDLE.getString(key_p);
		} catch (MissingResourceException e) {
			return '!' + key_p + '!';
		}
	}
}