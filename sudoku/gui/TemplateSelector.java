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

import tchok.sudoku.core.Template;
import tchok.sudoku.core.TemplateFactory;

/**
 * @author Tchok
 */
public abstract class TemplateSelector extends ContributionItem {


	// The menu
	Menu _menu;

	// The main item
	ToolItem _item;

	// The toolbar
	ToolBar _bar;
	
	// The last template
	Template _template;
	
	public TemplateSelector(Template template_p) {
		// Store it
		_template = template_p;
	}

	/** Called on selection events. */
	protected abstract void selectionChanged(Template template_p);
	
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
				if(e.detail == SWT.ARROW) {
					// Show the menu
					Point where = new Point(e.x, e.y);
					where = parentToolbar_p.getDisplay().map(parentToolbar_p, null, where);
					_menu.setLocation(where.x, where.y);
					_menu.setVisible(true);
				}
				
				// Not on the arrow, call default action
				else {
					selectionChanged(_template);
				}
			}
		
		};
		_item.addSelectionListener(listener);
		
		// Set a tooltip
		_item.setToolTipText(Messages.getString("TemplateSelector.selectGridTemplate")); //$NON-NLS-1$
	}

	private void createMenu(Shell shell_p) {
		// Dispose ?
		if(_menu != null) {
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
				_template = (Template) item.getData();
				selectionChanged(_template);
			}
		};
		
		// Create items
		for(int index=0; index<TemplateFactory.TEMPLATES.length; index++) {
			// Create an item
			MenuItem item = new MenuItem(_menu, SWT.NULL);
			
			// Get the template
			Template template = TemplateFactory.TEMPLATES[index];
			
			// Get and set the image
			Image img = Tools.getImage(template);
			item.setImage(img);
			
			// Set the label
			item.setText(template.name);
			
			// Store data
			item.setData(template);
			
			// Original image
			if(template == _template) {
				_item.setImage(img);
			}
			
			// And add a listener
			item.addSelectionListener(listener);
		}
	}
	
	/** Update the icon to refresh the correct image.*/
	public void select(Template template_p) {
		// Be safe
		if(_item == null) {
			return;
		}
		
		// Change the image
		Image img = Tools.getImage(template_p);
		_item.setImage(img);
		_bar.redraw();
		
		// Store the selection
		_template = template_p;
	}
}
