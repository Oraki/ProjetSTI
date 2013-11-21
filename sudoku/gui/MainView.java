package tchok.sudoku.gui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.part.ViewPart;

import tchok.sudoku.IEventTypes;
import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.ISolverListener;
import tchok.sudoku.core.Skill;
import tchok.sudoku.core.Solver;
import tchok.sudoku.core.State;
import tchok.sudoku.core.Template;
import tchok.sudoku.core.TemplateStoreManager;
import tchok.sudoku.prefs.IPrefConstants;
import tchok.swt.graphics.IDisposable;
import tchok.tools.events.TEvent;
import tchok.tools.events.TEventListener;
import tchok.tools.events.TEventManager;

/**
 * @author Tchok
 */
public class MainView extends ViewPart implements IPropertyChangeListener, TEventListener, IPrefConstants {
	/** This view's ID .*/
	public static final String VIEW_ID = "tchok.sudoku.gui.MainView"; //$NON-NLS-1$
	
	// the main composite
	Composite _mainComposite;
	
	// The board
	Board _board;
	
	// The highlight selector
	HighlightValueSelector _valueSelector;
	
	// Hide/show the value selector
	Button _valueSelectorCtrlButton;
	
	// Play mode (PLAY, MARK1 or MARK2)
	int _playMode = PLAY;
	
	// Allow invalid moves
	boolean _allowInvalidMove = SudokuPlugin.getDefault().getUserPreferences().getBoolean(ALLOW_INVALID_MOVE);
	
	// Mode for play
	static public final int PLAY = 0;
	
	// Current template
	Template _template = Template.T33;
	
	// Current skill
	Skill _skill = Skill.L2;
	
	// Play action
	Action _playAction = null;
	
	// Mark actions
	// Strike
	Action _mark1Action = null;
	
	// Solve it action
	Action _solveItAction = null;
	
	// New board action
	Action _buildOneAction = null;
	
	// Empty board 
	Action _cleanItAction = null;

	// Skill Selector
	SkillSelector _skillSelector = null;
	
	// TEmplate Selector
	TemplateSelector _templateSelector = null;
	
	// The undo manager
	UndoManager _undoManager;
	
	// Flag raised when a pending redraw is waiting...
	boolean _pendingRedraw = false;
	
	// Autoplay handler
	AutoPlayHandler _autoPlayHandler;
	
	// Current mouse handler
	IDisposable _actionMouseHandler;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent_p) {
		// Sub composite...
		_mainComposite = new Composite(parent_p, SWT.NULL);
		FormLayout layout = new FormLayout();
		layout.marginBottom =
			layout.marginHeight =
			layout.marginLeft = 
			layout.marginRight =
			layout.marginTop =
			layout.marginWidth = 0;
		_mainComposite.setLayout(layout);
		
		// Fix a background
		Image background =
			SudokuPlugin.getDefault().getImage("icons/background.png"); //$NON-NLS-1$
		_mainComposite.setBackgroundImage(background);

		// Add a board
		_board = new Board(_mainComposite, SWT.NULL);
		
		// Move selection
		new SelectionKeyHandler(_board, _board);
		new SelectionMouseHandler(_board);
		
		// Handle undo
		_undoManager = new UndoManager(this);
		
		// Initialise
		// Load last state
		UIState state = SudokuPlugin.loadState();
		
		// no last state ?
		boolean mustBuildOne = false;
		if(state == null) {
			state = new UIState(Template.T33);
			state.setSkill(_skill);
			mustBuildOne = true;
		}  else {
			_skill = state.getSkill();
			_template = state.getTemplate();
		}
		
		// store it
		_board.setState(state);
		
		// Register actions
		contributeToActionBar();
		
		// Auto play
		_autoPlayHandler = new AutoPlayHandler(this);

		// Need one ?
		if(mustBuildOne) {
			_buildOneAction.run();
		} 
		
		// Register to preferences
		SudokuPlugin.getDefault().getUserPreferences().addPropertyChangeListener(this);
		
		// Register to Sudoku events
		TEventManager.getInstance().addListener(IEventTypes.HIGHLIGHT_SELECTION, this);
		TEventManager.getInstance().addListener(IEventTypes.TEMPLATE_CHANGED, this);
		
		// Refresh selectors... when there up
		Runnable runner = new Runnable() {
			public void run() {
				refreshSelectors();
				new InfoManager(MainView.this);
			}
		};
		parent_p.getDisplay().asyncExec(runner);
		
		// Action handler. 
		new ActionKeyHandler(this, getBoard());
		installMouseHandler();
	}

	/**
	 * Install mouse handler according to prefs.
	 */
	void installMouseHandler() {
		// Dispose from previous
		if(_actionMouseHandler != null) {
			_actionMouseHandler.dispose();
			_actionMouseHandler = null;
		}
		
		// Install new one
		// Menu driven ?
		if(SudokuPlugin.getDefault().getUserPreferences().getBoolean(IPrefConstants.CTRL_USE_MENU_MOUSE_HANDLER)) {
			_actionMouseHandler = new ActionMouseHandler(this);
		}
		// direct ?
		else {
			_actionMouseHandler = new FastActionMouseHandler(this);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		_board.setFocus();
	}

	private void contributeToActionBar() {
		// Get action bar
		IActionBars bars = getViewSite().getActionBars();
		
		// Create actions
		makeActions();
		
		// Register them
		IToolBarManager manager = bars.getToolBarManager();
		manager.add(_playAction);
		manager.add(_mark1Action);
		manager.add(new Separator());
		_undoManager.contribute(manager);
		manager.add(new Separator());
		manager.add(_solveItAction);
		manager.add(_cleanItAction);
		// manager.add(_buildOneAction); This one is useless here ?
		manager.add(new Separator());
		
		// Template
		_templateSelector = new TemplateSelector(_template) {
			@Override
			protected void selectionChanged(Template template_p) {
				// Store new Template
				MainView.this._template = template_p;
				TEventManager.getInstance().fireEvent(
						new TEvent(IEventTypes.TEMPLATE_CHANGED, this, _template));
				
				// Start a new game
				_buildOneAction.run();
			}
		};
		manager.add(_templateSelector);
		
		// Skill
		_skillSelector = new SkillSelector(_skill) {
			@Override
			protected void selectionChanged(Skill skill_p) {
				// Store new Skill
				MainView.this._skill = skill_p;
				
				// Start a new game
				_buildOneAction.run();
			}
		};
		manager.add(_skillSelector);

		// Let's try this
		Action prefs = new Action() {
			@Override
			public void run() {
				String [] pages = 
					SudokuPlugin.getDefault().getPreferencePageIds();
				PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(_board.getShell(), null, pages, null);
				dialog.open();
			}
		};
		prefs.setText(Messages.getString("MainView.prefs")); //$NON-NLS-1$
		prefs.setToolTipText(Messages.getString("MainView.prefs")); //$NON-NLS-1$
		prefs.setImageDescriptor(getImageDescriptor("prefs.png")); //$NON-NLS-1$
		manager.add(prefs);
		
		
		// OK
		manager.markDirty();
	}
	
	private void makeActions() {
		// Enter play mode action
		_playAction = new Action() {
			@Override
			public void run() {
				_playMode = PLAY;
				setChecked(true);
				_mark1Action.setChecked(false);
			}
		};
		_playAction.setText("play mode"); //$NON-NLS-1$
		_playAction.setToolTipText(Messages.getString("MainView.playMode")); //$NON-NLS-1$
		_playAction.setChecked(true);
		_playAction.setImageDescriptor(getImageDescriptor("Play.png")); //$NON-NLS-1$
		
		// Enter mark mode action
		_mark1Action = new Action() {
			@Override
			public void run() {
				_playMode = Template.STRIKE;
				setChecked(true);
				_playAction.setChecked(false);
			}
		};
		_mark1Action.setText("mark off"); //$NON-NLS-1$
		_mark1Action.setToolTipText(Messages.getString("MainView.strikeMode")); //$NON-NLS-1$
		_mark1Action.setChecked(false);
		_mark1Action.setImageDescriptor(getImageDescriptor("MarkOff.png")); //$NON-NLS-1$
		
		// Solve it
		_solveItAction = new Action() {
			@Override
			public void run() {
				// Get a solver
				final ISolverListener listener = new ISolverListener() {
					int count = 0;
					public boolean foundASolution(final State state_p) {
						Runnable runner = new Runnable() {
							public void run() {
								UIState newState = new UIState(_board.getState());
								newState.loadFrom(state_p);
								_board.setState(newState);
							}
						};
						_board.getDisplay().asyncExec(runner);
						return false;
					}

					public boolean levelIs(final int level_p, final State state_p) {
						if((++count) % 2500 == 0) {
							if(level_p < 81) {
								Runnable runner = new Runnable() {
									public void run() {
										UIState newState = new UIState(_board.getState());
										newState.loadFrom(state_p);
										_board.setState(newState);
									}
								};
								_board.getDisplay().asyncExec(runner);
							}
						}
						
						return true;
					}
					
				};
				
				// Record it
				_board.getState().addSolve();
				
				// Make it undoable
				UIState state = new UIState(_board.getState());
				_undoManager.push(state);
				
				// In a new Thread
				Thread solvingThread = new Thread("Solving thread") { //$NON-NLS-1$
					@Override
					public void run() {
						Solver solver = new Solver(listener);
						solver.solve(_board.getState());
					}
				};
				solvingThread.start();
			}
		};
		_solveItAction.setText("solve"); //$NON-NLS-1$
		_solveItAction.setToolTipText(Messages.getString("MainView.solve")); //$NON-NLS-1$
		_solveItAction.setImageDescriptor(getImageDescriptor("Solve.png")); //$NON-NLS-1$
		
		// Build a new one
		_buildOneAction = new Action() {
			@Override
			public void run() {
				// Get ready to make it undoable
				UIState previousState = new UIState(_board.getState());

				
				// Get the manager
				TemplateStoreManager mgr = TemplateStoreManager.getManager(_template, true);
				
				// Get a state
				UIState state = new UIState(mgr.getState(_skill));
				state.setSkill(_skill);
				
				// Also rebuild solution
				state.loadSolution();

				// Play it
				_board.setState(state);
				
				// Push  old state
				_undoManager.push(previousState);
// Comment above and uncomment below
// To use a direct build, with graphical feedback (debug stuff)
//				
//				_template = WideTemplate.WIDE_TEST;
//				Runnable runner = new Runnable() {
//					public void run() {
//						// Get ready to make it undoable
//						final State previousState = new State(_board.getState());
//
//						Builder builder = new Builder() {
//							int count = 0;
//							int c2=0;
//							public boolean levelIs(int level_p,final State state_p) {
//								if((++count)%1000 == 0) {
//									Runnable subRunner = new Runnable() {
//										public void run() {
//											_board.setState(state_p);
//										}
//									};
//									_board.getDisplay().asyncExec(subRunner);
//								}
//								return super.levelIs(level_p, state_p);
//							}
//							
//							public boolean foundASolution(State state_p) {
//									Runnable subRunner = new Runnable() {
//										public void run() {
//											if(++c2 % 2 == 0) {
//												_board.getParent().setBackground(_board.getDisplay().getSystemColor(SWT.COLOR_BLUE));
//											} else {
//												_board.getParent().setBackground(_board.getDisplay().getSystemColor(SWT.COLOR_GREEN));
//											}
//										}
//									};
//									_board.getDisplay().asyncExec(subRunner);
//								return super.foundASolution(state_p);
//							}
//						};
//						final State state = builder.buildOne(_template);
//						
//						Runnable subRunner = new Runnable() {
//							public void run() {
//								// Play it
//								_board.setState(state);
//								
//								// Push  old state
//								_undoManager.push(previousState);
//
//							}
//						};
//						_board.getDisplay().asyncExec(subRunner);
//					}
//				};
//				new Thread(runner).start();
			}
		};
		_buildOneAction.setText("New board"); //$NON-NLS-1$
		_buildOneAction.setToolTipText(Messages.getString("MainView.new")); //$NON-NLS-1$
		_buildOneAction.setImageDescriptor(getImageDescriptor("New.png")); //$NON-NLS-1$
		
		// Clean it
		_cleanItAction = new Action() {
			@Override
			public void run() {
				// Make it undoable
				UIState state = new UIState(_board.getState());
				_undoManager.push(state);

				// Play it
				state = new UIState(_template);
				state.setSkill(_skill);
				_board.setState(state);
			}
		};
		_cleanItAction.setText("New empty board"); //$NON-NLS-1$
		_cleanItAction.setToolTipText(Messages.getString("MainView.clean")); //$NON-NLS-1$
		_cleanItAction.setImageDescriptor(getImageDescriptor("Clean.png")); //$NON-NLS-1$
	}
	
	/** Get the board. */
	public Board getBoard() {
		return _board;
	}

	/**
	 * @return the current play mode
	 */
	public int getPlayMode() {
		return _playMode;
	}

	/**
	 * Switch from PLAY to MARK modes
	 */
	public void rotatePlayMode() {
		// Get the action to invoque
		if(_playAction.isChecked()) {
			_mark1Action.run();
		} else {
			_playAction.run();
		}
	}
	
	/**
	 * @return the UndoManager
	 */
	public UndoManager getUndoManager() {
		return _undoManager;
	}
	
	/**
	 * Convenience access to the image registry.
	 * @param key_p path from PI base.
	 * @return the image
	 */
	ImageDescriptor getImageDescriptor(String key_p) {
		return SudokuPlugin.getDefault().getImageDescriptor("icons/" + key_p); //$NON-NLS-1$
	}

	public boolean isAllowInvalidMove() {
		return _allowInvalidMove;
	}

	// Change play mode
	public void setPlayMode(int mode_p) {
		// Store it
		_playMode = mode_p;

		// refresh states
		switch(mode_p) {
			// Play
			case PLAY:
				_playAction.setChecked(true);
				_mark1Action.setChecked(false);
				break;
				
			// First mark
			case Template.STRIKE:
				_playAction.setChecked(false);
				_mark1Action.setChecked(true);
				break;
		}
	}

	/**
	 * Refresh the selectors according to current state.
	 * Template and Skill.
	 */
	public void refreshSelectors() {
		// Template ?
		if(_template != getBoard().getState().getTemplate()) {
			_template = getBoard().getState().getTemplate();
			TEventManager.getInstance().fireEvent(
					new TEvent(IEventTypes.TEMPLATE_CHANGED, this, _template));
		}
		_templateSelector.select(_template);
		_skillSelector.select(getBoard().getState().getSkill());
		_autoPlayHandler.onUserAction(); 
	}
	
	@Override
	public void dispose() {
		_autoPlayHandler.dispose();
		SudokuPlugin.getDefault().getUserPreferences().removePropertyChangeListener(this);
		TEventManager.getInstance().removeListener(this);
	}

	public void propertyChange(PropertyChangeEvent event_p) {
		// only for graphical properties
		final String key = event_p.getProperty();
		if(key.startsWith(IPrefConstants.UI_PREFIX)) {
			// Some special cases
			// Show sub values
			if(SHOW_SUBVALUES.equals(key)) {
				_board.showSubValues(((Boolean)event_p.getNewValue()).booleanValue());
			}
			// Hide not allowed
			else if (HIDE_NOT_ALLOWED.equals(key)) {
				_board.hideNotAllowed(((Boolean)event_p.getNewValue()).booleanValue());
			}
			
			// I'll redraw...
			if(!_pendingRedraw) {
				// Build a runnable and start it
				Runnable runner = new Runnable() {
					public void run() {
						// redraw all
						Control[] childs = _mainComposite.getChildren();
						for (Control control : childs) {
							control.redraw();
						}
						_pendingRedraw = false;
					}
				};
				_pendingRedraw = true;
				_board.getDisplay().timerExec(200, runner);
			}
		}
		
		// Allow invalid moves
		else if (ALLOW_INVALID_MOVE.equals(key)) {
			_allowInvalidMove = ((Boolean)event_p.getNewValue()).booleanValue();
		}

		// Mouse handler
		else if ((CTRL_USE_DIRECT_MOUSE_HANDLER.equals(key) ||
				 CTRL_USE_MENU_MOUSE_HANDLER.equals(key)) &&
				 ((Boolean)event_p.getNewValue()).booleanValue()) {
			// Install new handler (later)
			Runnable runner = new Runnable(){
				public void run() {
					installMouseHandler();
				}
			};
			_board.getDisplay().asyncExec(runner);
		}
	}

	public void handleEvent(final TEvent event_p) {
		Runnable runner = new Runnable() {
			public void run() {
				switch ( event_p.type) {
					case IEventTypes.HIGHLIGHT_SELECTION:
						// Extract value
						final Integer value = (Integer) event_p.data;
						
						// propagate to board
						_board.setValueToHighlight(value.intValue());
						break;
						
					case IEventTypes.TEMPLATE_CHANGED:
						// Refresh layout
						if(_valueSelector != null) {
							fixLayoutWithValueSelector();
						} else {
							fixLayoutWithoutValueSelector();
						}
						
						// And layout
						_mainComposite.layout(true, true);
						_mainComposite.redraw();
						break;
				}
			}
		};
		_board.getDisplay().asyncExec(runner);
	}

	/**
	 * Show the value selector and layout widgets...
	 * @param lock true to lock the selector on.
	 */
	void addValueSelector(boolean lock) {
		// is this a real change ?
		boolean realChange = true;
		int currentSelectedValue = -1;
		if(_valueSelector != null) {
			realChange = false;
			currentSelectedValue = _valueSelector.getSelection();
		}
		
		// Add a button to hide/show the value selector
		// (only when not locked)
		
		// dispose from previous button
		if(_valueSelectorCtrlButton != null) {
			_valueSelectorCtrlButton.dispose();
			_valueSelectorCtrlButton = null;
		}
		
		// Insert new button (if required)
		if(!lock) {
			_valueSelectorCtrlButton = new Button(_mainComposite, SWT.ARROW | SWT.LEFT);
			_valueSelectorCtrlButton.moveAbove(null);
			_valueSelectorCtrlButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					removeValueSelector();
					
					// Store state
					SudokuPlugin.getDefault().getUserPreferences().setValue(EXPAND_VALUE_SELECTOR, false);
				}
			});
		}
		
		// Build value selector
		if(realChange) {
			_valueSelector = new HighlightValueSelector(this, getBoard());
		}

		// Layout
		fixLayoutWithValueSelector();
		
		// OK
		_valueSelector.setTemplate(_template);
		_valueSelector.setSelection(currentSelectedValue);
	}
	
	/**
	 * Fix layout when the value selector is displayed.
	 */
	void fixLayoutWithValueSelector() {
		// Compute ratio
		int size = 9;
		if(_board.getState() != null) {
			size = _board.getState().getTemplate().maxValue + 1;
		}
		int ratio = (100 * size) / (size + 2);
		
		// Layout value selector
		// Top, bottom and right to the parent...
		FormData data = new FormData();
		data.top = new FormAttachment(0);
		data.bottom = new FormAttachment(100);
		data.right = new FormAttachment(100);
		data.left = new FormAttachment(ratio);
		_valueSelector.setLayoutData(data);
		
		// Layout _board
		// top bottom and left to the parent, right to the selector
		data = new FormData();
		data.top = new FormAttachment(0);
		data.bottom = new FormAttachment(100);
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(_valueSelector, 0, SWT.LEFT);
		_board.setLayoutData(data);
		
		// Layout button
		if(_valueSelectorCtrlButton != null) {
			data = new FormData();
			data.top = new FormAttachment(0);
			data.right = new FormAttachment(100);
			data.left = new FormAttachment(100, -15);
			data.bottom = new FormAttachment(_board, 15, SWT.TOP);
			_valueSelectorCtrlButton.setLayoutData(data);
			_valueSelectorCtrlButton.moveAbove(null);
		}
		
		// Layout
		_mainComposite.layout(true);
	}
	
	/**
	 * Remove the value selector.
	 */
	void removeValueSelector() {
		// Dummy case
		if(_valueSelector == null) {
			return;
		}
		
		// Dispose from the selector
		_valueSelector.dispose();
		_valueSelector = null;
		
		// Add a button to show it
		if(_valueSelectorCtrlButton != null) {
			_valueSelectorCtrlButton.dispose();
		}
		_valueSelectorCtrlButton = new Button(_mainComposite,  SWT.ARROW | SWT.RIGHT);
		_valueSelectorCtrlButton.moveAbove(null);
		_valueSelectorCtrlButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addValueSelector(false);
				
				// Store state
				SudokuPlugin.getDefault().getUserPreferences().setValue(EXPAND_VALUE_SELECTOR, true);
			}
		});
		
		// Fix layout
		fixLayoutWithoutValueSelector();
		
		// Clear selection
		_board.setValueToHighlight(-1);
		
		// Store state
		SudokuPlugin.getDefault().getUserPreferences().setValue(EXPAND_VALUE_SELECTOR, false);

		// Ok
		_mainComposite.layout(true);
	}
	
	
	/**
	 * Fix layout when the value selector is not displayed.
	 */
	void fixLayoutWithoutValueSelector() {
		// Layout board...
		FormData data = (FormData) _board.getLayoutData();
		data.right = new FormAttachment(100);
		
		// Layout button
		data = new FormData();
		data.top = new FormAttachment(0);
		data.right = new FormAttachment(100);
		data.left = new FormAttachment(100, -15);
		data.bottom = new FormAttachment(_board, 15, SWT.TOP);
		_valueSelectorCtrlButton.setLayoutData(data);
		
		// Layout
		_mainComposite.layout(true);
	}
	
	/**
	 * Lock/unlock the value selector.
	 * When state is true, ensure the value selector is visible.
	 * @param state target lock state.
	 */
	public void setValueSelectorLocked(boolean state) {
		addValueSelector(state);
		if( !state && 
			!SudokuPlugin.getDefault().getUserPreferences().getBoolean(EXPAND_VALUE_SELECTOR)) {
			removeValueSelector();
		}
	}
}