package tchok.sudoku.print;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


/**
 * A ControlContribution to select a printer.
 * @author Tchok
 */
public abstract class AbstractPrinterSelector extends ControlContribution implements SelectionListener {


	// Current printer
	private PrinterData _printer;

	/**
	 * A constructor is requiered.
	 * @param id_p
	 */
	public AbstractPrinterSelector(String id_p) {
		super(id_p);
	}
	
	@Override
	protected Control createControl(Composite parent_p) {
		// Let's build a combo
		Combo combo = new Combo(parent_p, SWT.READ_ONLY);
		combo.setText("123456789123456789"); //$NON-NLS-1$
		combo.setToolTipText(Messages.getString("PrinterSelector.printSelector.tooltip")); //$NON-NLS-1$
		
		// get printers
		PrinterData []printers = Printer.getPrinterList();
		
		// Get current value
		_printer = Printer.getDefaultPrinterData();
		
		// Extract names
		String [] names = new String[printers.length];
		int selectionIndex = -1;
		for (int i = 0; i < printers.length; i++) {
			PrinterData aPrinter = printers[i];
			names[i] = aPrinter.name;
			
			// selection
			if((_printer != null) && aPrinter.name.equals(_printer.name)) {
				selectionIndex = i;
			}
		}
		
		// Fill combo
		combo.setItems(names);

		// Fix it
		if(_printer != null) {
			combo.select(selectionIndex);
		}
		
		// Register a listener
		combo.addSelectionListener(this);
		
		// OK
		return combo;
	}

	@Override
	protected int computeWidth(Control ctrl_p) {
		// Compute size
		Point size = ctrl_p.computeSize(-1, -1, true);
		
		// Ok
		return size.x;
	}

	public void widgetDefaultSelected(SelectionEvent event_p) {
		widgetSelected(event_p);
	}

	public void widgetSelected(SelectionEvent event_p) {
		// Get value
		String name = ((Combo)event_p.widget).getText();
		
		// update
		setPrinter(name);
	}

	/**
	 * Set the current priner (and warn listeners)
	 * @param name_p
	 */
	void setPrinter(String name_p) {
		// Get it
		PrinterData candidates[] = Printer.getPrinterList();
		for (int i = 0; i < candidates.length; i++) {
			PrinterData data = candidates[i];
			if(data.name.equals(name_p)) {
				// Store it
				_printer = data;
				
				// send event
				fireEvent(_printer);
				
				// OK
				break;
			}
		}
		
	}

	/**
	 * Called when printer change.
	 * Please overload...
	 */
	abstract void fireEvent(PrinterData printer_p);

}
