package tchok.sudoku.prefs;

import java.io.IOException;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import tchok.sudoku.SudokuPlugin;

public class UIPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public UIPrefPage() {
		super(GRID);
		setPreferenceStore(SudokuPlugin.getDefault().getUserPreferences());
		setDescription(Messages.getString("UIPrefPage.description")); //$NON-NLS-1$
	}
	
	@Override
	protected void createFieldEditors() {
		// Maybe a little too much colors...
		final String args[] = {
				IPrefConstants.GRID_BACKGROUND_0,
				IPrefConstants.GRID_BACKGROUND_1,
				IPrefConstants.SELECTION_BACKGROUND,
				IPrefConstants.GRID_FOREGROUND,
				IPrefConstants.SUBGRID_FOREGROUND,
				IPrefConstants.VALUE_FOREGROUND,
				IPrefConstants.MARK_FOREGROUND,
				IPrefConstants.HIGHLIGHT_BACKGROUND,
				IPrefConstants.START_VALUE_FOREGROUND,
				IPrefConstants.ST_LINK_COLOR
		};
		
		// Insert selectors
		for (int i = 0; i < args.length; i++) {
			String key = args[i];
			addColorSelector(key);
		}
		
		// Fonts
		addFontSelector(IPrefConstants.VALUE_FONT);
		addFontSelector(IPrefConstants.MARK_FONT);
		
	}

	private void addColorSelector(String key_p) {
		String label = Messages.getString(key_p);
		addField(new ColorFieldEditor(key_p, label, getFieldEditorParent()));
	}

	private void addFontSelector(String key_p) {
		String label = Messages.getString(key_p);
		addField(new FontFieldEditor(key_p, label, getFieldEditorParent()));
	}
	
	public void init(IWorkbench workbench) {
		// Empty block
	}

	/**
	 * Apply and save...
	 */
	@Override
	public boolean performOk() {
		boolean output = super.performOk();
		if (getPreferenceStore() instanceof ScopedPreferenceStore) {
			ScopedPreferenceStore store = (ScopedPreferenceStore) getPreferenceStore();
			try {
				store.save();
			} catch (IOException e) {
				// This should not happen, but still...
				SudokuPlugin.getDefault().error(Messages.getString("UIPrefPage.cantWritePrefs")); //$NON-NLS-1$
			}
		}
		return output;
	}


}