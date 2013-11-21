package tchok.sudoku;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import tchok.sudoku.gui.IconBuilder;
import tchok.sudoku.gui.MainView;
import tchok.sudoku.gui.UIState;
import tchok.sudoku.prefs.PrefInitializer;
import tchok.sudoku.print.PrintView;

/**
 * The index plugin class to be used in the desktop.
 */
public class SudokuPlugin extends AbstractUIPlugin {
	/** Directory for the stores. */
	public static final String DIRECTORY = ".sudoku"; //$NON-NLS-1$
	
	/** The warning icon. */
	public static final String WARN_ICON = "icons/warn.png"; //$NON-NLS-1$
	
	/** The preference file. */
	private static final String PREFERENCES_FILE = "/Sudoku.properties"; //$NON-NLS-1$
	
	/** The data directory - For test purpose */
	private static String __dataDirectory = null;
	
	//The shared instance.
	private static SudokuPlugin __plugin;
	
	/** The preference pages. */
	private static final String[] _preferencePageIds = {
		"tchok.sudoku.prefs.helper",  //$NON-NLS-1$
		"tchok.sudoku.prefs.controls",  //$NON-NLS-1$
		"tchok.sudoku.prefs.main", 	//$NON-NLS-1$
		"tchok.sudoku.prefs.print", //$NON-NLS-1$
		"tchok.sudoku.prefs.store" //$NON-NLS-1$
	};
	
	//Resource bundle.
	private ResourceBundle _resourceBundle;
	
	// Image registry
	private ImageRegistry _images;
	
	// Color registry
	private ColorRegistry _colors;
	
	// Icon builder
	private IconBuilder _iconBuilder;
	
	// The internal preference store.
	PreferenceStore _preferences;
	
	// Marker to clear messages
	int _lastUserMessage; 

	/**
	 * The constructor.
	 */
	public SudokuPlugin() {
		super();
		__plugin = this;
		try {
			_resourceBundle = ResourceBundle.getBundle("tchok.sudoku.SudokuPluginResources"); //$NON-NLS-1$
		} catch (MissingResourceException x) {
			_resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context_p) throws Exception {
		super.start(context_p);
		
		// Init preferences
		new PrefInitializer().initializeDefaultPreferences();
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context_p) throws Exception {
		// Save preferences
		_preferences.save();
		
		// And stop
		super.stop(context_p);
	}

	/**
	 * Returns the shared instance.
	 */
	public static SudokuPlugin getDefault() {
		return __plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key_p) {
		ResourceBundle bundle = SudokuPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key_p) : key_p;
		} catch (MissingResourceException e) {
			return key_p;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return _resourceBundle;
	}
	
	/** Get a descriptor from it's path.*/
	public ImageDescriptor getImageDescriptor(String imageKey_p) {
		// Init Image registry 
    	if(_images == null) {
    		_images = new ImageRegistry(PlatformUI.getWorkbench().getDisplay());
    	}

    	// Try from cache
        ImageDescriptor descriptor = _images.getDescriptor(imageKey_p);

        // Load it
        if (descriptor == null) {
        	// Get bundle id
        	String bundleId = __plugin.getBundle().getSymbolicName();
        	
        	// get image descriptor
            ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(bundleId, imageKey_p);
            
            // Store it
            _images.put(imageKey_p, desc);
            
            // And get it back
            descriptor = desc;
        }
        
        // OK
        return descriptor;
	}
	
	 /**
     * Get an image from its relative path.
     * The memory aspect is handled by this class
     * @param imageKey_p
     * @return an Image or null if no image could be found
     */
    public Image getImage(String imageKey_p) {
    	// Get the descritor
    	getImageDescriptor(imageKey_p);
    	
    	// Return the image
    	return _images.get(imageKey_p);
    }
    
    /**
     * Get a color from it's symbolic name.
     * @param name_p (from the IPrefsConstants)
     * @return
     */
    public Color getColor(String name_p) {
    	// Init ?
    	if(_colors == null) {
    		_colors = new ColorRegistry();
    	}
    	
    	// Make sure it's registered with the right values
    	// The ColorRegistry handles duplicates (by ignoring them).
    	// The only problem is that 'deprecated' colors are never disposed
    	// or re-used. 
    	_colors.put(name_p, PreferenceConverter.getColor(getUserPreferences(), name_p));
    	
    	// get it
    	return _colors.get(name_p);
    }

	/** 
	 * @return the data directory.
	 */
	static public String getUserDirectory() {
		// Store full path...
		StringBuffer buffer = new StringBuffer();
		
		// Do I know it already ?
		if(__dataDirectory == null) {
			// Get user's base dir
			URL base = null;
			try {
				// This runs in Eclipse
				base = Platform.getUserLocation().getURL();
			} catch ( Exception e) {
				// THis is a default for a static main
				try {
					base = new URL("file:C:"); //$NON-NLS-1$
				} catch (MalformedURLException e1) {
					// No C: disk ? and it's only when preparing states...
					e1.printStackTrace();
					return null;
				}
			}
			
			// User's dir
			buffer.append(base.getPath());
			
			// Sudoku store
			buffer.append(File.separatorChar).append(DIRECTORY);
		} // endif - I had to search..
		else {
			buffer.append(__dataDirectory);
		}
		
		// Create it ?
		File file = new File(buffer.toString());
		file.mkdirs();
	
		// OK
		return buffer.toString();
	}

	/**
	 * Store the data directory. For test purpose.
	 * @param path_p the new data directory
	 */
	public static void setUserDirectory(String path_p) {
		__dataDirectory = path_p;
	}
	
	// Get the curreent state file...
	private static String getStateFile() {
		return getUserDirectory() + "/current"; //$NON-NLS-1$
	}

	// save the current state...
	public static void saveCurrentState(UIState state_p) {
		try {
			// Not at start up
			if(state_p != null) {
				// Get output file
				String outputFile = getStateFile();
				
				// Open a stream
				FileOutputStream fout = new FileOutputStream(outputFile);
				ObjectOutputStream oFout = new ObjectOutputStream(fout);
				
				// write object
				oFout.writeObject(state_p);
				
				// close them all
				oFout.close();
				fout.close();
			}
		} catch ( Exception e) {
			// Empty catch...
			e.printStackTrace();
		}
	}

	// load back the current state
	public static UIState loadState() {
		try {
			// Get name
			String inputFile = getStateFile();
			
			// Check file
			File file = new File(inputFile);
			if(file.exists()) {
				// Open streams
				FileInputStream fin = new FileInputStream(inputFile);
				ObjectInputStream oFin = new ObjectInputStream(fin);
				
				// Read state
				UIState state = (UIState) oFin.readObject();
				
				// Close files
				oFin.close();
				fin.close();
				
				// All right
				SudokuPlugin.getDefault().message(Messages.getString("SudokuPlugin.stateLoaded"), null); //$NON-NLS-1$
				
				// OK
				return state;
			} else {
				// Say it
				SudokuPlugin.getDefault().message(Messages.getString("SudokuPlugin.noStateToLoad"), null); //$NON-NLS-1$
			}
		} catch (Exception e) {
			// Warn
			SudokuPlugin.getDefault().error(Messages.getString("SudokuPlugin.cantLoadState")); //$NON-NLS-1$
		}
		
		// bad luck (or no saved state)
		return null;
	}
	
	/**
	 * @return the icon builder.
	 */
	public IconBuilder getIconBuilder() {
		if(_iconBuilder == null) {
			_iconBuilder = new IconBuilder(PlatformUI.getWorkbench().getDisplay());
		}
		return _iconBuilder;
	}
	
	/**
	 * The user preferences (and games) are to be located in the user's home dir.
	 * In the RCP this may easily be done by setting: 
	 * 	<UL><LI>osgi.user.area=@user.home/sudoku (fpr the games)
	 *  <LI>osgi.instance.area=@user.home/sudoku (for the preferences)</UL>
	 * but this is not done in a standard workbench, so using sudoku in your
	 * IDE would lead to save preferences in the workspace. Thus loosing preferences
	 * for every new workspace...
	 * @return the user's preferences
	 */
	public IPreferenceStore getUserPreferences() {
		if(_preferences == null) {
			// Build file path
			String fullPath = getUserDirectory() + PREFERENCES_FILE;
			
			// Build preference store
			_preferences =
				new PreferenceStore(fullPath);
			
			// Load values
			try {
				_preferences.load();
			} catch (IOException e) {
				// We're gonna use the defaults...
				message(Messages.getString("SudokuPlugin.cantLoadPrefs"), WARN_ICON); //$NON-NLS-1$
			}
		}
		return _preferences;
	}
	
	/**
 	 * @return an array with the involved preference pages.
	 */
	public String [] getPreferencePageIds() {
		return _preferencePageIds;
	}
	
	/**
	 * Display a message in the active view's status line.
	 * @param message_p message to display
	 * @param imageKey_p the image to display (or null).
	 */
	public void message(final String message_p, final String imageKey_p) {
		Runnable runner = new Runnable() {
			public void run() {
				displayMessageOrError(true, message_p, imageKey_p);
			}
		};
		try {
			PlatformUI.getWorkbench().getDisplay().asyncExec(runner);
		} catch (NullPointerException npe) {
			// The workbench is going down...
		}
	}
	
	/**
	 * Display a warning in the active view's status line.
	 * @param message_p the message eto display
	 */
	public void error(final String message_p) {
		Runnable runner = new Runnable() {
			public void run() {
				displayMessageOrError(false, message_p, WARN_ICON);
			}
		};
		try {
			PlatformUI.getWorkbench().getDisplay().asyncExec(runner);
		} catch (NullPointerException npe) {
			// The workbench is going down...
		}
	}
	
	/**
	 * Display a message/error, and clear it later.
	 * @param asMessage_p true for a message, false for an error
	 * @param message_p message to display 
	 * @param imageKey_p key of image to display (or null)
	 */
	void displayMessageOrError(final boolean asMessage_p, String message_p, String imageKey_p) {
		try {
			// Find the actives views
			IWorkbenchWindow window =
				PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			final IViewPart[] viewParts = {
					page.findView(MainView.VIEW_ID),
					page.findView(PrintView.VIEW_ID)
			};
			
			// Find the image
			Image image = (imageKey_p == null) ? null : getImage(imageKey_p);
			
			// Fix the message
			for (int i = 0; i < viewParts.length; i++) {
				IViewPart part = viewParts[i];
				
				// Test it
				if(part != null) {
					// Message or error
					if(asMessage_p) {
						// A message
						part.getViewSite().getActionBars().getStatusLineManager().setMessage(image, message_p);
					} else {
						// as error
						part.getViewSite().getActionBars().getStatusLineManager().setErrorMessage(image, message_p);
						PlatformUI.getWorkbench().getDisplay().beep();
					}
				} // endif - part is not null
			} // endloop - on parts
			
			
			// Start a timer to clear the message
			final int count = ++_lastUserMessage;
			Runnable runner = new Runnable() {
				public void run() {
					// No new message
					if(count == _lastUserMessage) {
						// Clear the status lines
						for (int i = 0; i < viewParts.length; i++) {
							IViewPart part = viewParts[i];
							if(part != null) {
								if(asMessage_p) {
									part.getViewSite().getActionBars().getStatusLineManager().setMessage(""); //$NON-NLS-1$
								} else {
									part.getViewSite().getActionBars().getStatusLineManager().setErrorMessage(""); //$NON-NLS-1$
								}
							}
						} // endllop - on parts
					} // endif - no new messages
				} // endof - method run
			};
			
			// run it
			PlatformUI.getWorkbench().getDisplay().timerExec(3000, runner);
		} catch ( Exception e) {
			// Never mind...
		}
	}
}