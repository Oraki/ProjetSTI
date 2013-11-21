package tchok.sudoku.prefs;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Template;
import tchok.sudoku.core.TemplateFactory;

/**
 * Init the preferences...
 * This was fine this the default plugin preferences, but it just make no
 * sense with the getUserPreferences... but I could'nt find a way to use the IScope stuff....
 * TODO - Link with some IScopeContext... (without implementing IEclipsePreference)
 * @author Tchok
 */
public class PrefInitializer  extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = SudokuPlugin.getDefault()
		.getUserPreferences();
		
		// UI
		store.setDefault(IPrefConstants.GRID_BACKGROUND_0, "204,213,179"); //$NON-NLS-1$
		store.setDefault(IPrefConstants.GRID_BACKGROUND_1, "230,237,220"); //$NON-NLS-1$
		store.setDefault(IPrefConstants.SELECTION_BACKGROUND, "200,225,225"); //$NON-NLS-1$
		
		store.setDefault(IPrefConstants.GRID_FOREGROUND, "0,0,0"); //$NON-NLS-1$
		store.setDefault(IPrefConstants.SUBGRID_FOREGROUND, "0,0,255"); //$NON-NLS-1$
		
		store.setDefault(IPrefConstants.VALUE_FOREGROUND, "0,0,0"); //$NON-NLS-1$
		store.setDefault(IPrefConstants.START_VALUE_FOREGROUND, "0,0,255"); //$NON-NLS-1$
		
		store.setDefault(IPrefConstants.MARK_FOREGROUND, "128,128,128"); //$NON-NLS-1$
		store.setDefault(IPrefConstants.HIGHLIGHT_BACKGROUND, "225,200,200"); //$NON-NLS-1$
		
		store.setDefault(IPrefConstants.VALUE_FONT, "Arial|regular|10"); //$NON-NLS-1$
		store.setDefault(IPrefConstants.MARK_FONT, "Arial|regular|10"); //$NON-NLS-1$

		// Print
		store.setDefault(IPrefConstants.PRINT_GRID_BACKGROUND_0, "255,255,255"); //$NON-NLS-1$
		store.setDefault(IPrefConstants.PRINT_GRID_BACKGROUND_1, "225,225,225"); //$NON-NLS-1$
		
		store.setDefault(IPrefConstants.PRINT_GRID_FOREGROUND, "0,0,0"); //$NON-NLS-1$
		store.setDefault(IPrefConstants.PRINT_SUBGRID_FOREGROUND, "0,0,255"); //$NON-NLS-1$
		
		store.setDefault(IPrefConstants.PRINT_VALUE_FOREGROUND, "0,0,0"); //$NON-NLS-1$
		
		store.setDefault(IPrefConstants.PRINT_VALUE_FONT, "Arial|regular|10"); //$NON-NLS-1$
		
		// Stores
		for (int i = 0; i < TemplateFactory.TEMPLATES.length; i++) {
			Template template = TemplateFactory.TEMPLATES[i];
			store.setDefault(IPrefConstants.COMPUTE_LOCALS + template.name, false);
		}
		
		// Layout
		store.setDefault(IPrefConstants.EXPAND_VALUE_SELECTOR, true); 
		
		// Game
		store.setDefault(IPrefConstants.ALLOW_WRONG_MOVE, false);
		store.setDefault(IPrefConstants.ALLOW_INVALID_MOVE, false);
		
		// Subvalues
		store.setDefault(IPrefConstants.SHOW_SUBVALUES, true);
		store.setDefault(IPrefConstants.HIDE_NOT_ALLOWED, true);
		
		// Strong links
		store.setDefault(IPrefConstants.ST_SHOW_BIVALUE_CELLS, false);
		store.setDefault(IPrefConstants.ST_SHOW_BILOCAL_UNITS, false);
		store.setDefault(IPrefConstants.ST_LINK_WITH_SELECTION, true);
		store.setDefault(IPrefConstants.ST_LINK_COLOR, "255,255,255"); //$NON-NLS-1$
		
		// AutoPlay
		store.setDefault(IPrefConstants.AUTOPLAY_DELAY, 15);
		store.setDefault(IPrefConstants.AUTOPLAY_SingleValue, false);
		store.setDefault(IPrefConstants.AUTOPLAY_SinglePosition, false);
		store.setDefault(IPrefConstants.AUTOPLAY_MissingValuesInLine, false);
		store.setDefault(IPrefConstants.AUTOPLAY_Groups, false);
		store.setDefault(IPrefConstants.AUTOPLAY_HiddenGroups, false);
		store.setDefault(IPrefConstants.AUTOPLAY_Cheater, false);
		
		// Controls
		store.setDefault(IPrefConstants.CTRL_USE_MENU_MOUSE_HANDLER, false);
		store.setDefault(IPrefConstants.CTRL_USE_DIRECT_MOUSE_HANDLER, true);
		store.setDefault(IPrefConstants.CTRL_USE_KEYBOARD_DISPLAY, false);
		
		// Default font
		store.setDefault(IPrefConstants.DEFAULT_FONT, "Arial|regular|20"); //$NON-NLS-1$
		
		// Char set
		store.setDefault(IPrefConstants.CHARSET_NUMERIC, true);
		store.setDefault(IPrefConstants.CHARSET_LETTERS, false);
		store.setDefault(IPrefConstants.CHARSET_SYMBOLS, false);
	}

}