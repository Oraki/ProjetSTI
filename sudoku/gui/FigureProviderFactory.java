package tchok.sudoku.gui;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.prefs.IPrefConstants;

/**
 * Builds figure provider according to prefs.
 */
public class FigureProviderFactory implements IPropertyChangeListener {
	private static FigureProviderFactory __instance = new FigureProviderFactory();
	
	private IFigureProvider _current;
	
	/**
	 * Register to pref event and initialise
	 */
	private FigureProviderFactory() {
		// Get from pref
		getProviderFromPreferences();
		
		// Register to preferences
		SudokuPlugin.getDefault().getUserPreferences().addPropertyChangeListener(this);

	}
	
	/**
	 * @return the current provider
	 */
	public static IFigureProvider getProvider() {
		return __instance._current;
	}

	/**
	 * Reset provider on pref events
	 */
	public void propertyChange(PropertyChangeEvent event) {
		// Check prefix
		if(event.getProperty().startsWith(IPrefConstants.UI_PREFIX)) {
			getProviderFromPreferences();
		}
	}
	
	/**
	 * Make sure provider reflect preferences
	 */
	private void getProviderFromPreferences() {
		// This is not that good...
		IPreferenceStore store = SudokuPlugin.getDefault().getUserPreferences();
		
		// Get new one
		if(store.getBoolean(IPrefConstants.CHARSET_NUMERIC)) {
			_current = new CharFigureProvider(CharFigureProvider.NUMBERS);
		}
		else if (store.getBoolean(IPrefConstants.CHARSET_LETTERS)) {
			_current = new CharFigureProvider(CharFigureProvider.LETTERS);
		}
		else if (store.getBoolean(IPrefConstants.CHARSET_SYMBOLS)){
			_current = new CharFigureProvider(CharFigureProvider.SYMBOLS);
		} else {
			_current = new IconFigureProvider();
		}
	}
}
