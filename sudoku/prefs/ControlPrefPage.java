package tchok.sudoku.prefs;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;

public class ControlPrefPage extends AbstractPrefPage {

	public ControlPrefPage() {
		super(Messages.getString("ControlPrefPage.description")); //$NON-NLS-1$
	}

	@Override
	protected void doCreateFieldEditors() {
		// Create the mouse group
		createMouseGroup();
		
		// Create the keyboard group
		createKeyboardGroup();
		
		// Create the charset group
		createCharsetGroup();
	}

	private void createMouseGroup() {
		// Create group
		final Group group = addGroup(Messages.getString("ControlPrefPage.mouseGroup")); //$NON-NLS-1$
		addMouseTrackListener(group, "ControlPrefPage.mouse");  //$NON-NLS-1$
		
		// Add editors (no radio buttons ?)
		final UpdatableBooleanFieldEditor menuDriven = addBooleanSelector(IPrefConstants.CTRL_USE_MENU_MOUSE_HANDLER, group);
		final UpdatableBooleanFieldEditor playStrike = addBooleanSelector(IPrefConstants.CTRL_USE_DIRECT_MOUSE_HANDLER, group);

		// a listener to link them (radio behaviour)
		SelectionListener listener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Check widget
				if(e.widget == menuDriven.getButton(group)) {
					// This is the menu driven button
					// Update the other one
					playStrike.getButton(group).setSelection(!menuDriven.getBooleanValue());
				} else {
					// Update the other one
					menuDriven.getButton(group).setSelection(!playStrike.getBooleanValue());
				}
			}
		};

		// Link them
		playStrike.getButton(group).addSelectionListener(listener);
		menuDriven.getButton(group).addSelectionListener(listener);
	}

	private void createKeyboardGroup() {
		// Create group
		Group group = addGroup(Messages.getString("ControlPrefPage.keyboard")); //$NON-NLS-1$
		addMouseTrackListener(group, "ControlPrefPage.keyboard"); //$NON-NLS-1$
		
		// Add editors
		addBooleanSelector(IPrefConstants.CTRL_USE_KEYBOARD_DISPLAY, group); 
	}

	private void createCharsetGroup() {
		// Create group
		final Group group = addGroup(Messages.getString("ControlPrefPage.charset")); //$NON-NLS-1$
		addMouseTrackListener(group, "ControlPrefPage.charset");  //$NON-NLS-1$
		
		// Add editors (no radio buttons ?)
		final UpdatableBooleanFieldEditor numeric = addBooleanSelector(IPrefConstants.CHARSET_NUMERIC, group);
		final UpdatableBooleanFieldEditor letters = addBooleanSelector(IPrefConstants.CHARSET_LETTERS, group);
		final UpdatableBooleanFieldEditor symbols = addBooleanSelector(IPrefConstants.CHARSET_SYMBOLS, group);
		final UpdatableBooleanFieldEditor icons = addBooleanSelector(IPrefConstants.CHARSET_ICONS, group);

		final UpdatableBooleanFieldEditor[] buttons = {
				numeric, letters, symbols, icons
		};
		
		// a listener to link them (radio behaviour)
		SelectionListener listener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Deselect ? => reselect !
				if(((Button)e.widget).getSelection() == false) {
					((Button)e.widget).setSelection(true);
				}
				
				// Update others
				for (int i = 0; i < buttons.length; i++) {
					if(e.widget != buttons[i].getButton(group)) {
						buttons[i].getButton(group).setSelection(false);
					}
				}
			}
		};

		// Link them
		for (int i = 0; i < buttons.length; i++) {
			UpdatableBooleanFieldEditor updatableBooleanFieldEditor = buttons[i];
			updatableBooleanFieldEditor.getButton(group).addSelectionListener(listener);
		}
	}
}
