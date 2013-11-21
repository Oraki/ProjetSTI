package tchok.sudoku.prefs;

import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class HelperPrefPage extends AbstractPrefPage {
	public HelperPrefPage() {
		super(Messages.getString("HelperPrefPage.description")); //$NON-NLS-1$
	}
	
	@Override
	protected void doCreateFieldEditors() {
		// Control (forbidden move, wrong move)
		createGameGroup();
		
		// mark group
		createMarkGroup();
		
		// strong links
		createStrongLinksGroup();
		
		// Automatic play
		createAutoPlayGroup();
	}

	/**
	 * Creates the game group.
	 */
	void createGameGroup() {
		// Create group
		Group group = addGroup(Messages.getString("HelperPrefPage.game")); //$NON-NLS-1$
		addMouseTrackListener(group, "game"); //$NON-NLS-1$
		
		// Create editors
		addBooleanSelector(IPrefConstants.ALLOW_INVALID_MOVE, group);
		addBooleanSelector(IPrefConstants.ALLOW_WRONG_MOVE, group);
	}
	
	/**
	 * Creates the mark group.
	 */
	void createMarkGroup() {
		// Create group
		final Group group = addGroup(Messages.getString("HelperPrefPage.marks")); //$NON-NLS-1$
		addMouseTrackListener(group, "marks"); //$NON-NLS-1$
		
		// Create editors
		final UpdatableBooleanFieldEditor showSubValues = addBooleanSelector(IPrefConstants.SHOW_SUBVALUES, group);
		final UpdatableBooleanFieldEditor hideNotAllowed = addBooleanSelector(IPrefConstants.HIDE_NOT_ALLOWED, group);
		
		// a listener to link them
		SelectionListener listener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Check widget
				if(e.widget == showSubValues.getButton(group)) {
					// This is the show sub value button
					// Update the other one
					if(!((Button)e.widget).getSelection()) {
						hideNotAllowed.getButton(group).setSelection(false);
					}
				} else {
					// This is the hide not allowed button
					if(((Button)e.widget).getSelection()) {
						showSubValues.getButton(group).setSelection(true);
					}
				}
			}
		};

		// Link them
		showSubValues.getButton(group).addSelectionListener(listener);
		hideNotAllowed.getButton(group).addSelectionListener(listener);
	}
	
	void createStrongLinksGroup() {
		// Create group
		Group group = addGroup(Messages.getString("HelperPrefPage.strongLinks")); //$NON-NLS-1$ 
		addMouseTrackListener(group, "strongLinks"); //$NON-NLS-1$
		
		// Create editors
		addBooleanSelector(IPrefConstants.ST_SHOW_BIVALUE_CELLS, group);
		addBooleanSelector(IPrefConstants.ST_SHOW_BILOCAL_UNITS, group);
		addBooleanSelector(IPrefConstants.ST_LINK_WITH_SELECTION, group);
	}
	
	void createAutoPlayGroup() {
		// Build a group
		final Group group = addGroup(Messages.getString("HelperPrefPage.autoPlay")); //$NON-NLS-1$
		addMouseTrackListener(group, "autoPlay"); //$NON-NLS-1$
		
		// The properties...
		String args[] = {
				IPrefConstants.AUTOPLAY_SingleValue, 
				IPrefConstants.AUTOPLAY_SinglePosition, 
				IPrefConstants.AUTOPLAY_MissingValuesInLine, 
				IPrefConstants.AUTOPLAY_Groups, 
				IPrefConstants.AUTOPLAY_HiddenGroups, 
				IPrefConstants.AUTOPLAY_Cheater
		};
		
		// The editors array
		final UpdatableBooleanFieldEditor[] editors =
			new UpdatableBooleanFieldEditor[args.length];
		
		// Insert a selector for every property
		for (int i = 0; i < args.length; i++) {
			String key = args[i];
			editors[i] = addBooleanSelector(key, group);
		}
		
		//
		// Insert the select all/none buttons
		// composite for the buttons
		Composite dummy = new Composite(group, SWT.RIGHT);
		GridData data = new GridData();
		data.horizontalSpan = 2;
		data.horizontalAlignment = GridData.END;
		dummy.setLayoutData(data);
		
		// Fix a layout
		dummy.setLayout(new GridLayout(2, true));
		
		// select all button
		Button selectAll = new Button(dummy, SWT.PUSH);
		selectAll.setText(Messages.getString("HelperPrefPage.selectAll")); //$NON-NLS-1$
		selectAll.setData(Boolean.TRUE);
		addMouseTrackListener(selectAll, "HelperPrefPage.selectAll"); //$NON-NLS-1$
		
		// select none button
		Button selectNone = new Button(dummy, SWT.PUSH);
		selectNone.setText(Messages.getString("HelperPrefPage.selectNone")); //$NON-NLS-1$
		selectNone.setData(Boolean.FALSE);
		addMouseTrackListener(selectNone, "HelperPrefPage.selectNone"); //$NON-NLS-1$
		
		// A listener
		SelectionListener listener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Get value
				boolean value = ((Boolean)e.widget.getData()).booleanValue();
				
				// Loop on editors
				for (int i = 0; i < editors.length; i++) {
					UpdatableBooleanFieldEditor editor = editors[i];
					editor.getButton(group).setSelection(value);
				}
			}
		};
		
		// Fix listener
		selectAll.addSelectionListener(listener);
		selectNone.addSelectionListener(listener);
		
		// Insert an editor for the delay
		IntegerFieldEditor delayEditor = 
			new IntegerFieldEditor(	IPrefConstants.AUTOPLAY_DELAY,
									Messages.getString(IPrefConstants.AUTOPLAY_DELAY),
									group);
		delayEditor.setValidRange(0, 500);
		
		// Fix mouse track listener
		addMouseTrackListener(delayEditor.getTextControl(group), IPrefConstants.AUTOPLAY_DELAY);
		addMouseTrackListener(delayEditor.getLabelControl(group), IPrefConstants.AUTOPLAY_DELAY);

		// store it
		addField(delayEditor);
	}
}
