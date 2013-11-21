package tchok.sudoku.prefs;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import tchok.sudoku.SudokuPlugin;

/**
 * Common services to preference pages.
 * This is a helping class to design pref pages with groups
 * and a description text.
 * @author Tchok
 */
public abstract class AbstractPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage, Listener {
	/** A key to reach description. */
	static final String DESCRIPTION_KEY = ".description"; //$NON-NLS-1$
	
	/** The text zone for description. */
	Text _description;
	
	public AbstractPrefPage(String description) {
		super(GRID);
		setPreferenceStore(SudokuPlugin.getDefault().getUserPreferences());
		setDescription(description);
	}
	
	@Override
	protected void createFieldEditors() {
		// Create editors
		doCreateFieldEditors();
		
		// Description text
		_description = new Text(getFieldEditorParent(), SWT.MULTI | SWT.READ_ONLY | SWT.WRAP);
		
		// On Linux, the background is white, it's huggly
		Control ctrl = getFieldEditorParent();
		while(ctrl != null) {
			Color color = ctrl.getBackground();
			if(color != null) {
				_description.setBackground(color);
				break;
			}
			ctrl = ctrl.getParent();
		}
		
		// Fix layout
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		data.horizontalIndent = 10;
		data.verticalIndent = 15;
		_description.setLayoutData(data);
	}
	
	/**
	 * Called by createFieldEditors(), should create editors!
	 */
	protected abstract void doCreateFieldEditors();
	
	/**
	 * Create and return a Group in the main composite
	 * @param text_p label for the new group
	 * @return the new group
	 */
	Group addGroup(String text_p) {
		// Create a group
		Group group = new Group(getFieldEditorParent(), SWT.NONE);
		group.setText(text_p);
		
		// Fix group layout as a Control
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		group.setLayoutData(data);
		
		// Fix group layout as a container
		group.setLayout(new GridLayout(2, true));
		
		// OK
		return group;
	}
	
	/**
	 * Creates and return a boolean editor.
	 * @param key_p key of the label
	 * @param parent_p parent composite
	 * @return the new editor
	 */
	protected UpdatableBooleanFieldEditor addBooleanSelector(String key_p, Composite parent_p) {
		// Get label
		String label = Messages.getString(key_p);
		
		// Build editor
		UpdatableBooleanFieldEditor editor = new UpdatableBooleanFieldEditor(key_p, label, parent_p);
		
		// Add it
		addField(editor);
		
		// Listen to mouse
		addMouseTrackListener(editor.getButton(parent_p), key_p);
		
		// OK
		return editor;
	}

	/**
	 * Fix the control for mouse track events, also fix the data.
	 * @param ctrl_p control to fix.
	 * @param key_p key of the property the control is handling.
	 */
	void addMouseTrackListener(Control ctrl_p, String key_p) {
		ctrl_p.setData(DESCRIPTION_KEY, key_p);
		ctrl_p.addListener(SWT.MouseEnter, this);
		ctrl_p.addListener(SWT.MouseExit, this);
	}
	
	public void init(IWorkbench workbench_p) {
		// Empty block
	}

	/**
	 * Handle mouse in and out and refresh the description.
	 * @param event
	 */
	public void handleEvent(Event event) {
		// according to event type
		switch ( event.type ) {
		case SWT.MouseExit:
			// Clear message
			setDescriptionMessage(""); //$NON-NLS-1$
			break;
			
		case SWT.MouseEnter:
			// Get key
			String key = (String)event.widget.getData(DESCRIPTION_KEY);
			if(key != null) {
				// Get description
				String message = Messages.getString(key + DESCRIPTION_KEY);
				
				// set it
				setDescriptionMessage(message);
			}
		}
	}
	
	/**
	 * Set the description message.
	 * @param message_p new message to display
	 */
	void setDescriptionMessage(String message_p) {
		_description.setText(message_p);
	}
}
