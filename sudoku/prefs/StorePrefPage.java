package tchok.sudoku.prefs;


import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import tchok.sudoku.IEventTypes;
import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Skill;
import tchok.sudoku.core.StateStore;
import tchok.sudoku.core.Template;
import tchok.sudoku.core.TemplateFactory;
import tchok.sudoku.core.TemplateStoreManager;
import tchok.sudoku.gui.Tools;
import tchok.swt.graphics.TwoValueBar;
import tchok.tools.events.TEvent;
import tchok.tools.events.TEventListener;
import tchok.tools.events.TEventManager;

/**
 * Handle preferences about the StoreManager.
 * @author Tchok
 */
public class StorePrefPage  extends FieldEditorPreferencePage 
	implements IWorkbenchPreferencePage, TEventListener {
	
	/**
	 * Sorry, but I could not find any other way to handle the layout...
	 */
	static class ThreeColsBooleanEditor extends BooleanFieldEditor {
		public ThreeColsBooleanEditor(String name, String label, Composite parent) {
			super(name, label, parent);
		}

		// @Override
		@Override
		public int getNumberOfControls() {
			return 3;
		}
		
	}
	
	// All bars...
	ArrayList<TwoValueBar> _bars = new ArrayList<TwoValueBar>();
	
	// The background image
	Image _backgroundImage;
	
	public StorePrefPage() {
		super(GRID);
		setPreferenceStore(SudokuPlugin.getDefault().getUserPreferences());
		setDescription(Messages.getString("StorePrefPage.description")); //$NON-NLS-1$
	}

	@Override
	protected void createFieldEditors() {
		// The create other display...
		doCreateInfo();
		
		// Register listeners
		TEventManager.getInstance().addListener(IEventTypes.STATE_STORE_EVENT, this);
	}
	
	/**
	 * Do create the info group.
	 */
	private void doCreateInfo() {
		// Build a group
		Group group = new Group(getFieldEditorParent(), SWT.NONE);
		group.setText(Messages.getString("StorePrefPage.groupLabel")); //$NON-NLS-1$
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// Give it a layout
		GridLayout layout = new GridLayout(2, true);
		group.setLayout(layout);
		
		// Label
		String labelString = Messages.getString(IPrefConstants.COMPUTE_LOCALS);
		
		// Start inserting childs....
		// Loop on templates
		for (int i = 0; i < TemplateFactory.TEMPLATES.length; i++) {
			// Get template
			Template template = TemplateFactory.TEMPLATES[i];
			
			// Insert a child composite
			Composite childCompo = new Composite(group, SWT.NONE);
			childCompo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			childCompo.setLayout(new GridLayout(3, false));
			
			// insert editor
			addField(new ThreeColsBooleanEditor(IPrefConstants.COMPUTE_LOCALS + template.name, labelString,  childCompo));

			// Loop on Skills
			for (int j = 0; j < Skill.LEVELS.length; j++) {
				Skill skill = Skill.LEVELS[j];
				
				// Now insert it
				createSimpleInfoLine(childCompo, template, skill);
			}
		}
	}
	
	/**
	 * Create a line for...
	 * @param parent_p parent composite.
	 * @param template_p template do display
 	 * @param skill_p skill to display
	 */
	private void createSimpleInfoLine(Composite parent_p, Template template_p, Skill skill_p) {
		// Template
		Label label = new Label(parent_p, SWT.NONE);
		label.setImage(Tools.getImage(template_p));
		
		// Skill
		label = new Label(parent_p, SWT.NONE);
		label.setImage(Tools.getImage(skill_p));
		
		// Line it
		TwoValueBar bar = new TwoValueBar(parent_p, SWT.NONE);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 12;
		bar.setLayoutData(data);
		bar.setBackground(bar.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		
		// Get current state
		TemplateStoreManager storeManager =
			TemplateStoreManager.getManager(template_p, true);
		StateStore store = storeManager.getStore(skill_p);
		
		// Init viewer
		storeValues(bar, store);
		
		// Setup listener infos...
		bar.setData(store);
		_bars.add(bar);
	}
	
	/**
	 * Store values....
	 * @param bar_p bar to update.
	 * @param store_p data source.
	 */
	void storeValues(TwoValueBar bar_p, StateStore store_p) {
		bar_p.setMinValue(0);
		bar_p.setMaxValue(store_p.getSize());
		bar_p.setValue1(store_p.getPredefCount());
		bar_p.setValue2(store_p.getSize() - store_p.getMissingCount());
	}
	
	@Override
	public void dispose() {
		// Unregister listeners...
		TEventManager.getInstance().removeListener(this);
		
		// super call
		super.dispose();
		
		// And release image
		if(_backgroundImage != null) {
			_backgroundImage.dispose();
		}
	}

	public void init(IWorkbench workbench_p) {
		// Empty block
	}

	/**
	 * handle events...
	 */
	public void handleEvent(TEvent event_p) {
		switch ( event_p.type) {
			// push or pop on a StateStore
			case IEventTypes.STATE_STORE_EVENT:
				onStoreEvent((StateStore) event_p.source);
		}

	}

	/**
	 * Called on StateStore events..
	 * @param store_p modified store.
	 */
	private void onStoreEvent(final StateStore store_p) {
		Runnable runner = new Runnable() {
			public void run() {
				// Find back the object
				for (Iterator<TwoValueBar> iter = _bars.iterator(); iter.hasNext();) {
					TwoValueBar bar = iter.next();

					// Is it the one?
					if (bar.getData() == store_p) {
						// Yes !
						storeValues(bar, store_p);
						bar.redraw();
						
						// Done...
						break;
					}
				}
			}

		};
		getFieldEditorParent().getDisplay().asyncExec(runner);		
	}

}