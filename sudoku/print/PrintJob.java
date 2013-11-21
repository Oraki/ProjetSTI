package tchok.sudoku.print;

import java.text.MessageFormat;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;

import tchok.sudoku.core.Skill;
import tchok.sudoku.core.Template;
import tchok.sudoku.core.TemplateStoreManager;
import tchok.sudoku.gui.BoardDrawer;
import tchok.sudoku.gui.UIState;
import tchok.sudoku.prefs.IPrefConstants;

/**
 * Handles a print job.
 * @author Tchok
 */
public class PrintJob extends Job {
	// Printer data
	PrinterData _data;
	
	// The printer itself
	Printer _printer;
	
	// Number of page to print
	int _pages;
	
	// Template to use
	IPrintTemplate _printTemplate;
	
	// Template for sheets
	Template _boardTemplate;
	
	// Skill of boards
	Skill _skill;
	
	// The drawer
	BoardDrawer _drawer;
	
	// The printing GC
	GC _gc;
	
	// Current page
	int _currentPage;
	
	/**
	 * @param name_p
	 */
	public PrintJob(String name_p, PrinterData data_p, int pages_p, IPrintTemplate printTemplate_p, Template boardTemplate_p, Skill skill_p) {
		super(name_p);
		_data = data_p;
		_pages = pages_p;
		_printTemplate = printTemplate_p;
		_boardTemplate = boardTemplate_p;
		_skill = skill_p;
		
		// This is a user job
		setUser(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor_p) {
		try {
			// Have a printer
			_printer = new Printer(_data);
			
			// Have a drawer
			_drawer = new BoardDrawer(_printer, IPrefConstants.PRINT_PREFIX);
			_drawer.drawAllowedMove(false);
			_drawer.showSubValues(false);
			_drawer.setSelection(-1);
			
			// Have a GC
			_gc = new GC(_printer);

			// Read client area
			_printTemplate.setPrinterData(_printer.getClientArea());
			
			// Initialize
			initalizePrintJob(monitor_p);
			
			// Loop on pages
			for(_currentPage=0; _currentPage<_pages; _currentPage++) {
				// Keep going
				if(monitor_p.isCanceled()) {
					break;
				}
				
				// Initialize page
				initializePage(monitor_p);
				
				// Loop on boards
				for(int currentBoard = 0; currentBoard<_printTemplate.getSheetsPerPage(); currentBoard++) {
					// Keep going ?
					if(monitor_p.isCanceled()) {
						// Give up
						break;
					}
					
					// print board
					printBoard(currentBoard, monitor_p);
				}
				
				// All right for this page
				finalizePage(monitor_p);
			}
			
			// OK
			_printer.endJob();
		} finally {
			dispose();
		}
		
		// Done
		return Status.OK_STATUS;
	}

	/**
	 * @param monitor_p
	 */
	private void finalizePage(IProgressMonitor monitor_p) {
		Runnable runner = new Runnable() {
			public void run() {
				_printer.endPage();
			}
		};
		Display.getDefault().syncExec(runner);
	}

	/**
	 * @param monitor_p
	 */
	private void initializePage(IProgressMonitor monitor_p) {
		Runnable runner = new Runnable() {
			public void run() {
				_printer.startPage();
			}
		};
		Display.getDefault().syncExec(runner);
	}

	/**
	 * @param monitor_p
	 */
	private void initalizePrintJob(IProgressMonitor monitor_p) {
		// Basic init
		monitor_p.beginTask(Messages.getString("PrintJob.task"),  //$NON-NLS-1$
							_pages * _printTemplate.getSheetsPerPage());
		
		// Start a job
		Runnable runner = new Runnable() {
			public void run() {
				_printer.startJob(getName());
			}
		};
		Display.getDefault().syncExec(runner);
	}

	/**
	 * @param currentBoard_p
	 */
	private void printBoard(int currentBoard_p, IProgressMonitor monitor_p) {
		// Have the user happy
		Object args[] = {
				new Integer(_currentPage+1),
				new Integer(currentBoard_p+1)
		};
		String message =
			MessageFormat.format(Messages.getString("PrintJob.prepare"), //$NON-NLS-1$
								 args);
		monitor_p.subTask(message);
		
		// Get a board
		TemplateStoreManager templateStoreManager = TemplateStoreManager.getManager(_boardTemplate, true);
		final UIState state = new UIState(templateStoreManager.getState(_skill));
		state.setSkill(_skill);
		
		// get the shape for this one
		Rectangle bounds = _printTemplate.getBounds(currentBoard_p);
		final Point origin = new Point(bounds.x, bounds.y);
		final Point size = new Point(bounds.width, bounds.height);
		
		// Get a runner to print it
		Runnable runner = new Runnable() {
			public void run() {
				_drawer.draw(state, origin, size, _gc);
			}
		};
		
		// And print it...
		message =
			MessageFormat.format(Messages.getString("PrintJob.print"), //$NON-NLS-1$
								 args);
		monitor_p.subTask(message);
		Display.getDefault().syncExec(runner);
		
		// OK
		monitor_p.worked(1);
	}

	void dispose() {
		if(_gc != null) {
			_gc.dispose();
		}
		
		if(_printer != null) {
			_printer.dispose();
		}
	}
}
