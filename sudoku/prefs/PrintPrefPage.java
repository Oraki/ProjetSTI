package tchok.sudoku.prefs;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import tchok.sudoku.SudokuPlugin;

public class PrintPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PrintPrefPage() {
		super(GRID);
		setPreferenceStore(SudokuPlugin.getDefault().getUserPreferences());
		setDescription(Messages.getString("PrintPrefPage.description")); //$NON-NLS-1$
	}
	
	@Override
	protected void createFieldEditors() {
		// Maybe a little too much colors...
		final String args[] = {
				IPrefConstants.PRINT_GRID_BACKGROUND_0,
				IPrefConstants.PRINT_GRID_BACKGROUND_1,
				IPrefConstants.PRINT_GRID_FOREGROUND,
				IPrefConstants.PRINT_SUBGRID_FOREGROUND,
				IPrefConstants.PRINT_VALUE_FOREGROUND
		};
		
		// Insert selectors
		for (int i = 0; i < args.length; i++) {
			String key = args[i];
			addColorSelector(key);
		}
		
		// Fonts
		addFontSelector(IPrefConstants.PRINT_VALUE_FONT);
		
	}

	private void addColorSelector(String key_p) {
		String label = Messages.getString(key_p);
		addField(new ColorFieldEditor(key_p, label, getFieldEditorParent()));
	}

	private void addFontSelector(String key_p) {
		String label = Messages.getString(key_p);
		addField(new FontFieldEditor(key_p, label, getFieldEditorParent()));
	}
	
	public void init(IWorkbench workbench_p) {
		// Empty block
	}


}
