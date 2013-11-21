package tchok.sudoku.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

import tchok.sudoku.IEventTypes;
import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.State;
import tchok.sudoku.core.Template;
import tchok.sudoku.prefs.IPrefConstants;
import tchok.swt.graphics.IDisposable;
import tchok.tools.events.TEvent;
import tchok.tools.events.TEventListener;
import tchok.tools.events.TEventManager;

/**
 * Handles the mouse driven actions
 * @author Tchok
 */
public class ActionMouseHandler implements Listener, IPrefConstants, TEventListener, IDisposable {
	// Key for the value
	private static final String VALUE = "tchok.sudoku.value"; //$NON-NLS-1$

	// Key for the mode
	private static final String MODE = "tchok.sudoku.mode"; //$NON-NLS-1$

	// Spacing in the grid
	static final int SPACING = 3;
	
	/// The view we're active on.
	private MainView _view;

	// The shell
	private Shell _shell;
	
	// No child so far
	private Composite _composite;
	
	// Value to highlight
	private int _toHightlight = -1;
	
	// Rank of value to highlight
	private int _toHighLightRank = -1;
	
	// Number of displayed values
	private int _displayedValuesCount = -1;

	// true to hide not allowed values
	private boolean _diseableItems;

	// the two playing modes
	private static final int[] MODES = {
			MainView.PLAY, Template.STRIKE
	};

	// current state
	private State _state;

	// current selection
	private int _selection;
	
	// pushed button
	private Button _menuPushedButton = null;
	
	public ActionMouseHandler(MainView view_p) {
		// Store
		_view = view_p;
		
		// Register a mouse listener
		_view.getBoard().addListener(SWT.MouseDown, this);
		_view.getBoard().addListener(SWT.MouseUp, this);
		
		// Unlock value selector
		_view.setValueSelectorLocked(false);

		// And listen to the value selector
		TEventManager.getInstance().addListener(IEventTypes.HIGHLIGHT_SELECTION, this);
	}
	
	public void dispose() {
		// Dispose menu
		if(_shell != null) {
			_shell.dispose();
		}
		
		// Unregister listeners
		TEventManager.getInstance().removeListener(this);
		if(!_view.getBoard().isDisposed()) {
			_view.getBoard().removeListener(SWT.MouseDown, this);
			_view.getBoard().removeListener(SWT.MouseUp, this);
		}
	}
	
	/**
	 * Create the shell for the 'menu like' popup.
	 */
	private void createShell() {
		// Create shell
		_shell = new Shell(_view.getBoard().getShell(), SWT.NO_TRIM | SWT.ON_TOP);
		
		// Fix a layout
		GridLayout layout = new GridLayout(1, true);
		layout.marginWidth = layout.marginHeight = 1;
		_shell.setLayout(layout);
		_shell.addListener(SWT.Deactivate, this);
		_shell.addListener(SWT.Close, this);
		
		// Let's draw a border
		_shell.setBackground(_shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		
		// No content
		_composite = null;
	}
	
	/**
	 * Restore a clean child composite to display the menu.
	 */
	private void initializeComposite() {
		// Check shell
		if(_shell == null) {
			createShell();
		}
		
		// get rid off the current content
		if(_composite != null) {
			_composite.dispose();
			_composite = null;
		}
		
		// restore a composite
		_composite = new Composite(_shell, SWT.NONE);
		_composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		// Give it a layout
		GridLayout layout = new GridLayout(MODES.length, true);
		layout.marginHeight = layout.marginWidth = 
			layout.verticalSpacing = layout.horizontalSpacing = SPACING;
		_composite.setLayout(layout);
		
		
		// apply (should not be needed!) [but is]
		_shell.pack(true);
		
		// Fix a background
		_composite.setBackground(SudokuPlugin.getDefault().getColor(GRID_BACKGROUND_1));
	}
	
	/**
	 * Add a button to the composite.
	 * @param value_p value for the button
	 * @param playMode_p play mode (MainView.[PLAY|STRIKE|HIGHTLIGHT]
	 * @param iconFlag_p icon mode (see IconBuilder)
	 * @param enableFlag_p enabled flag (true for yes)
	 */
	private void addAButton(int value_p, int playMode_p, boolean iconFlag_p, boolean enableFlag_p) {
		// Build label
		Integer integerValue = new Integer(value_p);
		
		// Build a control
		Button button = new Button(_composite, SWT.NO_FOCUS | SWT.TOGGLE);

		// Listen to buttons
		button.setData(VALUE, integerValue);
		button.setData(MODE, new Integer(playMode_p));
		
		// Set image and label
		IconBuilder iconBuilder = SudokuPlugin.getDefault().getIconBuilder();
		Image image = iconBuilder.getImage(value_p, playMode_p, iconFlag_p);
		button.setImage(image);
		//button.setText(Integer.toString(value+1));
		
		// Enable/disable
		button.setEnabled(enableFlag_p);
	}
	
	/**
	 * Fill the popup according to current state...
	 * return false if nothing is available...
	 */
	private boolean fillComposite() {
		// Clean composite
		initializeComposite();
		
		// Fill child
		// max value
		int maxValue = _view.getBoard().getState().getTemplate().maxValue;
		
		// Initialise context
		_state = _view.getBoard().getState();
		_selection = _view.getBoard().getSelection();
		if(_selection < 0) {
			return false;
		}
		_diseableItems = _view.getBoard().isHiddingNotAllowed();
		
		// not empty flag
		boolean notEmpty = false;
		
		// Init highlight flags
		// (these are used by the drawer)
		_toHighLightRank = -1;
		_displayedValuesCount = 0;
		
		// Loop on values
		for(int value=0; value<maxValue; value++) {
			// Loop on modes (columns)
			for (int i = 0; i < MODES.length; i++) {
				int playMode = MODES[i];
				
				// Compute flags...
				boolean iconFlag = true;
				boolean enableFlag = true;
				switch ( playMode) {
					case MainView.PLAY:
						iconFlag = _state.isFree(_selection) || (value != _state.getValue(_selection));
						enableFlag = 
							// If it's free
							// No disable OR Allowed
							(_state.isFree(_selection) && (!_diseableItems || _state.isAllowed(_selection, value))) ||
							
							// If it's not free
							// Not a move from the original position and the current value
							(!_state.isFree(_selection) 
									&& !_state.isOriginalPosition(_selection)
									&& (_state.getValue(_selection) == value));
						
						break;
						
					case Template.STRIKE:
						iconFlag = (playMode != _state.getMark(_selection, value));
						enableFlag = _state.isFree(_selection) &&
						(!_diseableItems || _state.isAllowed(_selection, value));
						break;
				}			
				
				// Skip not enabled ?
				if(!enableFlag && _diseableItems) {
					// Skip this one
					// Note: because enableFlag and diseableItems are not related
					// to playMode, we'll break the loop and get to next value.
					break;
				}
				
				// Update stuff to highlight
				if(playMode == MainView.PLAY) {
					// This is the one to highlight
					if(value == _toHightlight) {
						_toHighLightRank = _displayedValuesCount;
					}
					
					// One more is displayed
					_displayedValuesCount++;
				}
				
				// Add the button
				addAButton(value, playMode, iconFlag, enableFlag);
				
				// Not empty
				notEmpty = true;
			} // endloop - on modes
		} // endloop - on values
		
		// Pack it
		_shell.pack(true);
		
		// Add a paint listener...
		if(_toHightlight >= 0) {
			_composite.addListener(SWT.Paint, this);
		}
		
		// OK
		return notEmpty;
	}
	

	/** handles selection events on buttons .*/
	private void onPopupButton(Widget button_p) {
		// Get values
		int value = ((Integer)button_p.getData(VALUE)).intValue();
		int mode = ((Integer)button_p.getData(MODE)).intValue();
		
		// Undo manager
		UndoManager manager = _view.getUndoManager();
		
		// According to case
		_view.setPlayMode(mode);
		switch ( mode ) {
			case MainView.PLAY:
				manager.playPosition(value);
				break;
				
			case Template.STRIKE:
				manager.toggleMark(value);
				break;
		}
		
		// Hide
		_shell.setVisible(false);
		_composite.setFocus();
	}

	/**
	 * React to mouse event by opening the popup menu.
	 */
	void onMouseDownInBoard() {
		// Update menu content
		if(!fillComposite()) {
			_shell.setVisible(false);
			return;
		}
		
		// Lock selection
		_view.getBoard().lockSelection(true);
		
		//
		// Compute menu's location
		//
		
		// Get shell's bounds
		Point size = _shell.getSize();
		
		// Get display's bounds
		Rectangle displayBounds = _shell.getDisplay().getBounds();
		
		// Compute position
		Point cursor = _shell.getDisplay().getCursorLocation();
		int x = cursor.x;
		int y = cursor.y;
		
		// Handle 'out of screen' case
		if((x + size.x) > displayBounds.width) {
			x = displayBounds.width - size.x;
		}
		if((y + size.y) > displayBounds.height) {
			y = displayBounds.height - size.y;
		}
		
		// Fix location
		_shell.setBounds(x, y, size.x, size.y);
		
		// Show it
		_shell.setVisible(true);
		_composite.setFocus();
		
		// Listen to motion (refresh selection)
		_view.getBoard().addListener(SWT.MouseMove, this);
	}

	/**
	 * This is a listener, too many events....
	 */
	public void handleEvent(Event event_p) {
		
		// Shell events (submenu)
		if(event_p.widget == _shell) {
			switch (event_p.type) {
			case SWT.Deactivate:
				// hide
				_shell.setVisible(false);
				break;

			case SWT.Close:
				// Forget it
				_shell = null;
				break;
				
			default:
				// Useless...
				break;
			}
			
			// Unlock selection
			_view.getBoard().lockSelection(false);
		}
		
		// Mouse event on the board
		else if (event_p.widget == _view.getBoard()) {
			if(event_p.type == SWT.MouseDown) {
				// Only mouse events...
				onMouseDownInBoard();
			} else if (event_p.type == SWT.MouseUp){
				onMouseUpInBoard();
			} else {
				onMouseMotionInBoard();
			}
		}
		
		// Paint event in the popup
		else if (event_p.widget == _composite) {
			// highlight
			drawHighLight(event_p.gc);
		}
	}

	/**
	 * Handles mouse motion to refresh the selected button.
	 */
	private void onMouseMotionInBoard() {
		// Get widget under pointer
		Control ctrl = _view.getBoard().getDisplay().getCursorControl();
		if((ctrl != _menuPushedButton) && (ctrl.getData(VALUE) != null)) {
			// This is a new one
			if((_menuPushedButton != null) && !_menuPushedButton.isDisposed()) {
				_menuPushedButton.setSelection(false);
			}
			_menuPushedButton = (Button) ctrl;
			_menuPushedButton.setSelection(true);
			_shell.redraw();
		}
	}

	/**
	 * Handles the mouse up event.
	 * On windows, the mouse down in the board shows the popup, and the
	 * Board still handles events that occurs in the shell as long as the 
	 * button is not released, so the handler is here.
	 */
	private void onMouseUpInBoard() {
		// Get widget under pointer
		try {
			Control ctrl = _view.getBoard().getDisplay().getCursorControl();
			onPopupButton(ctrl);
		} catch (Exception e) {
			// Out of the zone, just hide
			_shell.setVisible(false);
		}
		
		
		// Stop listening to motion
		_view.getBoard().removeListener(SWT.MouseMove, this);
		
		// Unlock selection
		// this is useless for Windows but needed for ubuntu
		_view.getBoard().lockSelection(false);

	}

	/**
	 * Store changes in highlighted value
	 */
	public void handleEvent(TEvent event_p) {
		// store value
		_toHightlight = ((Integer)event_p.data).intValue();
	}
	
	/**
	 * Paint hint to highlight a line
	 * @param gc_p drawing gc
	 */
	void drawHighLight(GC gc_p) {
		// Get bounds
		Point size = _composite.getSize();
		
		// Compute location
		int h = size.y - (_displayedValuesCount + 1) * SPACING;
		int y = (h * _toHighLightRank) / _displayedValuesCount + _toHighLightRank * SPACING;
		h = h / _displayedValuesCount + 2 * SPACING;
		
		// Fix gc
		gc_p.setBackground(SudokuPlugin.getDefault().getColor(HIGHLIGHT_BACKGROUND));
		gc_p.fillRectangle(0, y, size.x, h);
	}
}