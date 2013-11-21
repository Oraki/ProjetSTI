package tchok.sudoku.gui;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import tchok.sudoku.core.Skill;

/**
 * @author Tchok
 */
public abstract class SkillSelector extends ContributionItem {

	// The menu
	Menu _menu;

	// The main item
	ToolItem _item;

	// The toolbar
	ToolBar _bar;

	// The last skill
	Skill _skill;

	public SkillSelector(Skill skill_p) {
		// Store it
		_skill = skill_p;
	}

	/** Called on selection events. */
	protected abstract void selectionChanged(Skill skill_p);

	@Override
	public void dispose() {
		// Clear menu
		if(_menu != null) {
			_menu.dispose();
		}
	}

	@Override
	public void fill(final ToolBar parentToolbar_p, int index_p) {
		// Store it
		_bar = parentToolbar_p;

		// Create the item
		_item = new ToolItem(parentToolbar_p, SWT.DROP_DOWN);

		// Build the menu
		createMenu(parentToolbar_p.getShell());

		//	Listen to events
		SelectionAdapter listener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// On the arrow ?
				if (e.detail == SWT.ARROW) {
					// Show the menu
					Point where = new Point(e.x, e.y);
					where = parentToolbar_p.getDisplay().map(parentToolbar_p, null, where);
					_menu.setLocation(where.x, where.y);
					_menu.setVisible(true);
				} else {
					// Redo
					selectionChanged(_skill);
				}
			}

		};
		_item.addSelectionListener(listener);

		// Set a tooltip
		_item.setToolTipText(Messages.getString("SkillSelector.selectSkill")); //$NON-NLS-1$
	}

	private void createMenu(Shell shell_p) {
		// Dispose ?
		if (_menu != null) {
			_menu.dispose();
		}

		// Create it
		_menu = new Menu(shell_p);

		// Listen to selection
		SelectionListener listener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {
				// Get item
				MenuItem item = (MenuItem) e.widget;

				// Update image
				_item.setImage(item.getImage());
				_bar.redraw();

				// Call for modification
				_skill = (Skill) item.getData();
				selectionChanged(_skill);
			}
		};

		// Create items
		for (int index = 0; index < Skill.LEVELS.length; index++) {
			// Create an item
			MenuItem item = new MenuItem(_menu, SWT.NULL);

			// Get and set the image
			Image img = Tools.getImage(Skill.LEVELS[index]);
			item.setImage(img);

			// Set the label
			item.setText(Messages.getString(Skill.LEVELS[index].name));

			// Store data
			item.setData(Skill.LEVELS[index]);

			// Original image
			if (Skill.LEVELS[index] == _skill) {
				_item.setImage(img);
			}

			// And add a listener
			item.addSelectionListener(listener);
		}
	}

	/** Update the icon to refresh the correct image.*/
	public void select(Skill skill_p) {
		// Be safe
		if((skill_p == null) || (_item == null)) {
			return;
		}
		
		// Change the image
		Image img = Tools.getImage(skill_p);
		_item.setImage(img);
		_bar.redraw();

		// Store the selection
		_skill = skill_p;
	}
}
