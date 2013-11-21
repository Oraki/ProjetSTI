package tchok.sudoku.print;


import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.part.ViewPart;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Skill;
import tchok.sudoku.core.Template;
import tchok.sudoku.gui.BoardDrawer;
import tchok.sudoku.gui.SkillSelector;
import tchok.sudoku.gui.TemplateSelector;
import tchok.sudoku.gui.UIState;
import tchok.sudoku.prefs.IPrefConstants;
import tchok.swt.graphics.ITransformer;
import tchok.swt.graphics.LinearTransformer;

public class PrintView extends ViewPart implements PaintListener, IPropertyChangeListener {
	// the view ID
	static public final String VIEW_ID = "tchok.sudoku.print.PrintView"; //$NON-NLS-1$
	
	// The canvas
	Canvas _canvas;
	
	// The template selector
	private TemplateSelector _templateSelector;
	
	// The skill selector
	private SkillSelector _skillSelector;

	// Number of pages to print
	protected int _numberOfPage;

	// Skill of printed games
	protected Skill _skill;

	// Template for printed games
	protected Template _template;

	// Current printer data
	protected PrinterData _printerData;

	// Current print template
	protected IPrintTemplate _printTemplate;
	
	// base drawer
	protected BoardDrawer _drawer;
	
	// The current transformer
	protected ITransformer _transformer;
	
	// Page bounds
	protected Rectangle _pageBounds;
	
	// Flag raised when a pending redraw is waiting...
	boolean _pendingRedraw = false;
	
	/**
	* @Override
	**/
	@Override
	public void createPartControl(Composite parent_p) {
		// Create Canvas
		_canvas = new Canvas(parent_p, SWT.DOUBLE_BUFFERED);
		_canvas.addPaintListener(this);
		Image background =
			SudokuPlugin.getDefault().getImage("icons/background.png"); //$NON-NLS-1$
		_canvas.setBackgroundImage(background);

		// Initialize
		_numberOfPage = 1;
		_skill = Skill.L2;
		_template = Template.T33;
		_printerData = Printer.getDefaultPrinterData();
		_printTemplate = PrintTemplate.PT3x2;
		
		// Init a drawer
		_drawer = new BoardDrawer(parent_p.getDisplay(), IPrefConstants.PRINT_PREFIX);
		_drawer.drawAllowedMove(false);
		_drawer.showSubValues(false);
		_drawer.setSelection(-1);

		// Contribute to action bar
		contributeToActionBar();
		
		// Register to preferences
		SudokuPlugin.getDefault().getUserPreferences().addPropertyChangeListener(this);

	}
	
	@Override
	public void dispose() {
		SudokuPlugin.getDefault().getUserPreferences().removePropertyChangeListener(this);
	}

	public void propertyChange(PropertyChangeEvent event_p) {
		// only for graphical properties
		if(event_p.getProperty().startsWith(IPrefConstants.PRINT_PREFIX)) {
			// I'll redraw...
			if(!_pendingRedraw) {
				// Build a runnable and start it
				Runnable runner = new Runnable() {
					public void run() {
						// redraw
						refreshView();
						_pendingRedraw = false;
					}
				};
				_pendingRedraw = true;
				_canvas.getDisplay().timerExec(200, runner);
			}
		}
	}
	
	private void contributeToActionBar() {
		// Get toolbar
		IToolBarManager manager = getViewSite().getActionBars().getToolBarManager();
		
		// Printer selector
		AbstractPrinterSelector printSelector = new AbstractPrinterSelector("sudoku.print.selector") { //$NON-NLS-1$
			@Override
			void fireEvent(PrinterData printer_p) {
				// Store and refresh
				_printerData = printer_p;
				refreshView();
			}
		};
		manager.add(printSelector);
		
		// Template
		_templateSelector = new TemplateSelector(Template.T33) {
			@Override
			protected void selectionChanged(Template template_p) {
				// Store new Template and refresh
				_template = template_p;
				refreshView();
			}
		};
		manager.add(_templateSelector);
		
		// Skill
		_skillSelector = new SkillSelector(_skill) {
			@Override
			protected void selectionChanged(Skill skill_p) {
				// Store new Skill
				_skill = skill_p;
				refreshView();
			}
		};
		manager.add(_skillSelector);

		// Number of page selector
		NumberOfPageSelector numberSelector = new NumberOfPageSelector(SudokuPlugin.getDefault().getIconBuilder()) {
			@Override
			void selectionChanged(int value_p) {
				// Store
				_numberOfPage = value_p;
			}
		};
		manager.add(numberSelector);
		
		// Print template selector
		PrintTemplateSelector prnTplSelector = new PrintTemplateSelector(_printTemplate) {
			@Override
			void selectionChanged(IPrintTemplate template_p) {
				_printTemplate = template_p;
				refreshView();
			}
		};
		manager.add(prnTplSelector);
		
		// Do print
		Action printParams = new Action(){
			@Override
			public void run() {
				if(_printerData != null) {
					PrintJob job = new PrintJob(Messages.getString("PrintSelector.jobName"), _printerData, _numberOfPage, _printTemplate, _template, _skill); //$NON-NLS-1$
					job.schedule();

				}
			}
		};
		printParams.setToolTipText(Messages.getString("PrintView.print.print")); //$NON-NLS-1$
		printParams.setImageDescriptor(SudokuPlugin.getDefault().getImageDescriptor("icons/printer.gif")); //$NON-NLS-1$
		manager.add(printParams);
		
		// Prefs
		Action prefs = new Action() {
			@Override
			public void run() {
				String [] pages = 
					SudokuPlugin.getDefault().getPreferencePageIds();
				PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(_canvas.getShell(), pages[2], pages, null);
				dialog.open();
			}
		};
		prefs.setText(Messages.getString("PrintView.prefs")); //$NON-NLS-1$
		prefs.setToolTipText(Messages.getString("PrintView.prefs")); //$NON-NLS-1$
		prefs.setImageDescriptor(SudokuPlugin.getDefault().getImageDescriptor("icons/prefs.png")); //$NON-NLS-1$
		manager.add(prefs);
	}

	protected void refreshView() {
		// Redraw
		_canvas.redraw();
	}

	/**
	* @Override
	**/
	@Override
	public void setFocus() {
		// Delegate
		_canvas.setFocus();
	}

	public void paintControl(PaintEvent event_p) {
		// Dummy case
		if(_printerData == null) {
			return;
		}
		
		// Hum hum hum...
		Printer printer = null;
		try {
			// Get canvas's bounds
			Rectangle viewBounds = ((Canvas)event_p.widget).getBounds();
			
			// Get printer's bounds
			printer = new Printer(_printerData);
			Rectangle printerBounds = printer.getClientArea();
			
			// Compute transformer
			computeTransformer(viewBounds, printerBounds);
			
			// Init template
			_printTemplate.setPrinterData(printerBounds);
			
			// Draw page
//			 TODO - handle clientArea/bounds
			GC gc = event_p.gc;
			gc.setBackground(_canvas.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			gc.setForeground(_canvas.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			gc.fillRectangle(_pageBounds);
			gc.drawRectangle(_pageBounds);
			
			// Get a board
			UIState state = new UIState(_template);
			state.setSkill(_skill);
			
			// Dummy fill...
			for(int i=0; i<_template.maxValue / 2; i++) {
				state.play(i + i * _template.maxValue, i);
			}
			for(int i=(_template.maxValue / 2); i<_template.maxValue; i++) {
				state.play(i + (_template.maxValue / 2) * _template.maxValue, i);
			}
			
			// Loop on boards
			for(int currentBoard = 0; currentBoard<_printTemplate.getSheetsPerPage(); currentBoard++) {
				
				// get the shape for this one
				Rectangle bounds = _printTemplate.getBounds(currentBoard);
				Point origin = new Point(bounds.x, bounds.y);
				Point size = new Point(bounds.width, bounds.height);
				
				origin = new Point(_transformer.getX(origin.x, origin.y),
						           _transformer.getY(origin.x, origin.y));
				size = new Point(_transformer.getW(size.x), _transformer.getH(size.y));
				
				// draw it
				_drawer.draw(state, origin, size, event_p.gc);
			}

		} finally {
			if(printer != null) {
				printer.dispose();
			}
		}
		
	}

	/**
	 * Compute transformer ...
	 * @param viewBounds_p view effective bounds
	 * @param printerBounds_p printer bounds
	 * @return
	 */
	private void computeTransformer(Rectangle viewBounds_p, Rectangle printerBounds_p) {
		// Compute ratio
		double ratioX = ((double)viewBounds_p.width)/printerBounds_p.width;
		double ratioY = ((double)viewBounds_p.height)/printerBounds_p.height;
		double ratio = 0.95 * Math.min(ratioX, ratioY);
		
		// Compute centering
		double deltaX = (viewBounds_p.width - (printerBounds_p.width * ratio)) / 2.;
		double deltaY = (viewBounds_p.height - (printerBounds_p.height * ratio)) / 2.;
		
		// Transformer
		_transformer = 
			new LinearTransformer((float)deltaX, (float)deltaY, (float)ratio, 0.f, 0.f, (float)ratio);
		
		// Compute page bounds
		_pageBounds = new Rectangle(
				_transformer.getX(printerBounds_p.x, printerBounds_p.y),
				_transformer.getY(printerBounds_p.x, printerBounds_p.y),
				_transformer.getW(printerBounds_p.width),
				_transformer.getH(printerBounds_p.height));
	}

}