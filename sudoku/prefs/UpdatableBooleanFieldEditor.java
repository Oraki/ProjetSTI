package tchok.sudoku.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A local boolean field editor to allow automatic update.
 * @author Tchok
 */
class UpdatableBooleanFieldEditor extends BooleanFieldEditor {
	/**
	 * Constructor
	 * @param key_p 
	 * @param label_p
	 * @param parent_p
	 */
	public UpdatableBooleanFieldEditor(String key_p, String label_p, Composite parent_p) {
		super(key_p, label_p, parent_p);
	}
	
	public UpdatableBooleanFieldEditor(String name, String labelText, int style, Composite parent) {
		super(name, labelText, style, parent);
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {
		// Do nothing...
		// But avoid messing up the layout
	}

	// Get the implementation Button
	Button getButton(Composite parent_p) {
		return getChangeControl(parent_p);
	}
}