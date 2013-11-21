package tchok.sudoku.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import tchok.sudoku.IEventTypes;
import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.strategies.StrategieManager;
import tchok.sudoku.prefs.IPrefConstants;
import tchok.tools.events.TEvent;
import tchok.tools.events.TEventManager;

/**
 * Handle a collection of store for a given template.
 * @author ofrouin
 */
public class TemplateStoreManager implements IPropertyChangeListener {
	/** Extension for store files. */
	public static final String EXTENSION = ".ts2"; //$NON-NLS-1$
	
	/** The template. */
	Template _template;
	
	/** Matching stores. */
	StateStore _stores[];
	
	/** Lower bounds (this is the min value to add a state to a skill. */
	int _bounds[];
	
	/** Current mode. true for usual playing, false for initial build.*/
	boolean _mode = true;
	
	/** All the stores. */
	private static TemplateStoreManager [] __instances;

	/** Is building new States. */
	boolean _isBuilding = false;
	
	/** Avoid starting too many building threads... */
	static private Object __mutex = new Object();
	
	/** Get one...
	 * @param template_p handled template
	 * @param mode_p true for usual playing, false for initial build
	 * @throws IOException 
	 */
	private TemplateStoreManager(Template template_p, int [] bounds_p, boolean mode_p) throws IOException {
		// Store data
		_bounds = bounds_p;
		_template = template_p;
		_mode = mode_p;
		
		// Install templates (if needed)
		boolean firstInstall = false;
		if(mode_p) {
			firstInstall = installDefaultStores();
		}
		
		// get Stores
		getStores(firstInstall);
		
		// Register to pref events
		// Allow non RCP exec (for the initial builder)
		if(SudokuPlugin.getDefault() != null) {
			SudokuPlugin.getDefault().getUserPreferences().addPropertyChangeListener(this);
		}
		
		// Start building
		startRefuelling();
	}
	
	/**
	 * Copy the default stores on first run.
	 * @return true if a lest one was installed.
	 */
	private boolean installDefaultStores() {
		// Get target directory
		File directory = new File(SudokuPlugin.getUserDirectory());
		boolean output = false;
		
		// Catch them !
		try {
			// Loop on skills
			for (int i = 0; i < Skill.LEVELS.length; i++) {
				Skill skill = Skill.LEVELS[i];
				
				// Get local name
				String localName = getLocalName(skill);
				
				// Check it
				File child = new File(directory, localName);
				if(child.exists()) {
					// All right
					continue;
				}
				
				// Get it from classpath
				InputStream source = getClass().getResourceAsStream(localName);

				// Target file
				OutputStream target = new FileOutputStream(child);
				
				// Let's copy...
				byte [] buffer = new byte[512];
				int size = 1;
				while(size >= 0) {
					// Read a few
					size = source.read(buffer);
					
					// Write it
					if(size > 0) {
						target.write(buffer, 0, size);
					}
				}
				
				// OK, let's close files
				source.close();
				target.close();
				
				// One new
				output = true;
			}
		} catch ( Exception e) {
			// TODO I Don't KNOW !
		}
		
		return output;
	}

	/**
	 * Load Stores.
	 * @param firstInstall_p true to update the predefCount in the Stores
	 * @throws IOException 
	 */
	private void getStores(boolean firstInstall_p) throws IOException {
		// On first call
		if(_stores == null) {
			// Allocate 
			_stores = new StateStore[Skill.LEVELS.length];
			
			// Loop on skills
			for (int i = 0; i < Skill.LEVELS.length; i++) {
				Skill aSkill = Skill.LEVELS[i];
				
				// Get full url for this Skill
				String fullPath = getFullPath(aSkill);
				
				// Get store for this url
				StateStore store = getStore(fullPath);
				
				// Update it
				if(firstInstall_p) {
					store.afterInstall();
				}
				
				// Store it
				_stores[aSkill.value - 1] = store;
			}
		}
	}
	
	/**
	 * Get the store at a given location.
	 * This one reads it.
	 * @param fullPath_p
	 * @return
	 * @throws IOException 
	 */
	private StateStore getStore(String fullPath_p) throws IOException {
		StateStore store = null;
		if(_mode) {
			store = new StateStore(fullPath_p);
		} else {
			// HINT This is where to change a Store's size
			store = new StateStore(fullPath_p, 100, _template);
		}
		return store;
	}
	
	/**
	 * Get full path for a given skill.
	 * @param skill_p
	 * @return path to the data file
	 */
	protected String getFullPath(Skill skill_p) {
		// Build it
		StringBuffer buffer = new StringBuffer();
		
		// Directory
		buffer.append(SudokuPlugin.getUserDirectory());
		
		// Local name
		buffer.append(File.separatorChar).append(getLocalName(skill_p));
		
		// OK
		return buffer.toString();
	}
	
	/**
	 * Get the local name for a given skill
	 * @param skill_p target skill
	 * @return the local name
	 */
	String getLocalName(Skill skill_p) {
		// A buffer
		StringBuffer buffer = new StringBuffer();
		
		// Template key
		buffer.append(_template.name);
		
		// Skill key
		buffer.append(skill_p.name);
		
		// And a suffix
		buffer.append(EXTENSION);
		
		// OK
		return buffer.toString();
	}
	
	/**
	 * Check if the stores are full.
	 * @param includePredef_p true to test also predefCount
	 * @return true when no states are missing
	 */
	boolean isFull(boolean includePredef_p) {
		// Answer
		boolean output = true;
		
		// Loop on stores
		for (int i = 0; i < _stores.length; i++) {
			StateStore store = _stores[i];
			
			// Test count
			if(store.getMissingCount() != 0) {
				output = false;
			}
			
			// test predef
			if(includePredef_p && (store.getPredefCount() != 0)) {
				output = false;
			}
		}
		
		// OK
		return output;
	}
	
	/**
	 * @return true if 'Local games' is on in the user's prefs.
	 */
	boolean getComputeLocals() {
		String key = IPrefConstants.COMPUTE_LOCALS + _template.name;
		return SudokuPlugin.getDefault().getUserPreferences().getBoolean(key);
	}
	
	/**
	 * Check if managed stores are full, testing user's prefs.
	 * @return true or false !
	 */
	boolean isFullAccordingToPrefs() {
		// OK
		return isFull(getComputeLocals());
	}
	
	/**
	 * Try to build (and store) a new State.
	 * The <i>best</i> type of State is build.
	 * @throws IOException 
	 */
	void createOne() throws IOException {
		// Warn listeners
		callListeners(_template, IEventTypes.BUILDING);
		
		// Get a builder
		Builder builder = new Builder();
		
		// Get an initial state
		State state = builder.buildOne(_template);
		
		// Get the initial skill for the new State
		State evaluated = new State(state);
		int score = StrategieManager.INSTANCE.study(evaluated, true);
		
		// Look for a Store that might want it
		if(!storeStateIfNeeded(state, score) && state.getTemplate().reducable) {
			// Warn listeners
			callListeners(_template, IEventTypes.REDUCING);

			// Reduce it and retry
			Reducer reducer = new Reducer();
			State reduced = reducer.simplify(state);
			
			// Evaluate again
			evaluated = new State(reduced);
			score = StrategieManager.INSTANCE.study(evaluated, true);
			
			// And try to save
			storeStateIfNeeded(reduced, score);
		}

		// Warn listeners
		callListeners(_template, IEventTypes.YIELD);
	}
	
	/**
	 * Store a state if needed.
	 * @param state_p state to store
	 * @param score_p value for this state
	 * @return true of stored, false otherwise
	 * @throws IOException 
	 */
	boolean storeStateIfNeeded(State state_p, int score_p) throws IOException {
		// Find the skill
		int skillIndex = -1;
		for(int index=0; index<_bounds.length; index++) {
			if(score_p >= _bounds[index]) {
				skillIndex = index;
			}
		}
		
		// Store ?
		if(skillIndex != -1) {
			// Get store
			StateStore store = _stores[skillIndex];
			
			// According to case
			if(_mode) {
				// Refill mode
				//	Test capacity (for a new one)
				if(store.getMissingCount() > 0) {
					// Do store
					store.pushState(state_p, false);
					return true;
				}
				
				// Test capacity, to replace a predef state
				else if(store.getPredefCount() != 0) {
					// Do store
					store.pushState(state_p, true);
					return true;
				}
			} else {
				// Build a new one
				// Test capacity (for a new one)
				if(store.getMissingCount() != 0) {
					// Do store
					store.pushState(state_p, false);
					return true;
				}
			}
		}
		
		// No ops
		return false;
	}
	
	/**
	 * Get a new State
	 * @param skill_p target skill
	 * @return the State, or null if the store is empty
	 */
	public State getState(Skill skill_p) {
		// Convert skill to index
		int storeIndex = skill_p.value - 1;
		
		// Output
		State output = null;
		
		// Try from the requested skill
		try {
			// Get store
			StateStore store = _stores[storeIndex];
			
			// Get a state
			output = store.popState();
		} catch ( Exception e) {
			// TODO - I don't know !
			// Might be an idea to wait ? or return a Future ????
			// First have to think of what we wanna do!
		}
		
		// Start the refuelling process
		startRefuelling();
		
		// And return it
		return output;
	}

	/**
	 * Get the store for a skill
	 * @param level_p target skill
	 * @return the store
	 */
	public StateStore getStore(Skill level_p) {
		return _stores[level_p.value - 1];
	}
	
	/**
	 * Build the managers.
	 * HINT This is where to change the skills definitions
	 * @param mode_p true for usual playing, false for initial build
	 * @throws IOException
	 */
	static void  buildObjects(boolean mode_p) throws IOException {
		// First run ?
		if(__instances == null) {
			// Allocate
			__instances = new TemplateStoreManager[4];
			
			// Create and store
			__instances[0] = new TemplateStoreManager(Template.T22, new int[] {60, 100, 110, 120}, mode_p);
			__instances[1] = new TemplateStoreManager(Template.T23, new int[] {180, 245, 260, 100000}, mode_p);
			__instances[2] = new TemplateStoreManager(Template.T33, new int[] {440, 580, 1000, 100000}, mode_p);
			__instances[3] = new TemplateStoreManager(WideTemplate.T34, new int[] {600, 810, 1000, 100000}, mode_p);
			
		}
	}
	
	/**
	 * Get the handler for a given template.
	 * @param mode_p true for usual playing, false for initial build
	 * @return
	 */
	public static TemplateStoreManager getManager(Template template_p, boolean mode_p) {
		// Init
		try {
			buildObjects(mode_p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Find it
		for (int i = 0; i < __instances.length; i++) {
			// Is it the one ?
			if(__instances[i]._template == template_p) {
				// OK
				return __instances[i];
			}
		}
		
		// Bad luck
		return null;
	}
	
	/**
	 * Start the State building thread if required.
	 * Only in play mode...
	 */
	private void startRefuelling() {
		synchronized ( this) {
			// Already running ?
			if(_isBuilding || !_mode) {
				return;
			}
			
			// Now running
			_isBuilding = true;
			
			// Building thread
			Thread buildingThread = new Thread("BuildingThread") { //$NON-NLS-1$
				@Override
				public void run() {
					try {
						fillHerUp();
					} finally {
						synchronized (TemplateStoreManager.this) {
							_isBuilding = false;
						}
					}
				}
			};
			
			// Make it a low priority thread
			int priority = Thread.MIN_PRIORITY + 
				(Thread.NORM_PRIORITY - Thread.MIN_PRIORITY) / 4;
			buildingThread.setPriority(priority);
			buildingThread.setDaemon(!_mode);
			
			// And get going
			buildingThread.start();
		}
	}

	/**
	 * Build state until it's all full.
	 */
	void fillHerUp() {
		// Easy
		while(!isFullAccordingToPrefs()) {
			try {
				// Only one builder active at a time...
				synchronized(__mutex) {
					// Because we've been waiting, let's check the users prefs again !
					if(!isFullAccordingToPrefs()) {
						createOne();
					}
				}
				
				// Give chance to another thread to start up...
				Thread.yield();
			} catch (IOException e) {
				// Warn the user, we're getting nowhere !
				SudokuPlugin.getDefault().error(Messages.getString("TemplateStoreManager.storeIOError")); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Start the refuelling thread when the property turns to true.
	 */
	public void propertyChange(PropertyChangeEvent event_p) {
		// Check it
		if(event_p.getProperty().startsWith(IPrefConstants.COMPUTE_LOCALS)) {
			// If it's getting to true, start them all, otherwise, do nothing,
			// they'll stop alone...
			if(getComputeLocals()) {
				startRefuelling();
			}
		}
	}
	
	/**
	 * Call listeners.
	 * @param template_p kind of template.
	 * @param state_p new state.
	 */
	static void callListeners(Template template_p, Integer state_p) {
		TEventManager.getInstance().fireEvent(
				new TEvent(	IEventTypes.BUILDER_EVENT,
							template_p,
							state_p));
	}
}