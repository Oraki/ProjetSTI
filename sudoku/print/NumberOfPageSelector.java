package tchok.sudoku.print;

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

import tchok.sudoku.gui.CharFigureProvider;
import tchok.sudoku.gui.IFigureProvider;
import tchok.sudoku.gui.IconBuilder;
import tchok.sudoku.gui.MainView;
import tchok.sudoku.gui.Messages;

/**
 * @author Tchok
 */
public abstract class NumberOfPageSelector extends ContributionItem {
		// The menu
		Menu _menu;

		// The main item
		ToolItem _item;

		// The toolbar
		ToolBar _bar;
		
		// The last value
		private int _selection;
		
		/** The values .*/
		private static final int VALUES[] = { 1, 2, 3, 4, 5};
		
		// An icon builder
		IconBuilder _iconBuilder;
		
		public NumberOfPageSelector(IconBuilder builder_p) {
			// Initialize
			_selection = 1;
			_iconBuilder = builder_p;
		}

		/** Called on selection events. */
		abstract void selectionChanged(int value_p);
		
		@Override
		public void dispose() {
			if (_menu != null) {
				// Clear menu
				MenuItem[] items = _menu.getItems();
				for (MenuItem menuItem : items) {
					menuItem.getImage().dispose();
				}
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
				}
			
			};
			_item.addSelectionListener(listener);
			
			// Set a tooltip
			_item.setToolTipText(Messages.getString("NumberOfPageSelector.selectPrintTemplate")); //$NON-NLS-1$
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
					Integer intValue = (Integer) item.getData();
					selectionChanged(intValue.intValue());
				}
			};
			
			// Create items
			IFigureProvider figProvider = new CharFigureProvider(CharFigureProvider.NUMBERS);
			for(int index=0; index<VALUES.length; index++) {
				// Create an item
				MenuItem item = new MenuItem(_menu, SWT.NULL);
				
				// Get and set the image
				int value = VALUES[index];
				Image img = _iconBuilder.getImageNoCache(value - 1, MainView.PLAY, true, figProvider);
				item.setImage(img);
				
				// Set the label
				item.setText("" + value); //$NON-NLS-1$
				
				// Store data
				item.setData(new Integer(value));
				
				// Original image
				if(value == _selection) {
					_item.setImage(img);
				}
				
				// And add a listener
				item.addSelectionListener(listener);
			}
		}

	}
