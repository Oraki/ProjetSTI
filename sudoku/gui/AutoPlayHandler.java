package tchok.sudoku.gui;

import java.text.MessageFormat;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Display;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.strategies.Strategie;
import tchok.sudoku.core.strategies.StrategieManager;
import tchok.sudoku.prefs.IPrefConstants;

/**
 * Handles automatic playing.
 * @author Tchok
 */
public class AutoPlayHandler implements Runnable, IPropertyChangeListener, IPrefConstants {
	/** The basic timer period. */
	static final int PERIOD = 1000;
	
	/** The fast timer period. */
	static final int FAST_PERIOD = 33;
	
	/** The display .*/
	Display _display;
	
	/** The view. */
	MainView _view;
	
	/** period count-down. */
	int _countDown;
	
	/** is active flag. */
	boolean _isActive;
	
	/** The preference store. */
	IPreferenceStore _store;
	
	/**
	 * Build one.
	 * @param view_p the client view.
	 */
	AutoPlayHandler(MainView view_p) {
		_view = view_p;
		_display = _view.getBoard().getDisplay();
		
		// Listen to events
		_store = SudokuPlugin.getDefault().getUserPreferences();
		_store.addPropertyChangeListener(this);
		
		// Check for initial state
		_countDown = _store.getInt(AUTOPLAY_DELAY);
		checkForActivity();
	}

	/**
	 * Dispose from it...
	 */
	void dispose() {
		// unregister listeners
		_store.removePropertyChangeListener(this);
	}
	
	/**
	 * React to property events.
	 */
	public void propertyChange(PropertyChangeEvent event) {
		// Only for autoplay properties
		String key = event.getProperty();
		if(key.startsWith(AUTOPLAY_PREFIX)) {
			// Delay
			if(AUTOPLAY_DELAY.equals(key)) {
				// Update delay
				_countDown = ((Integer)event.getNewValue()).intValue();
			}
			
			// Otherwise, check for activity
			else {
				checkForActivity();
			}
		}
	}
	
	/**
	 * Inspect preferences and raise/lower the activity flag.
	 * Also launch the timer if required.
	 */
	void checkForActivity() {
		// Store current state
		boolean previousState = _isActive;
		
		// Check for closure
		if(_view.getBoard().isDisposed()) {
			_isActive = false;
			return;
		}
		
		// Checks for activity
		
		// Loop on strategies
		_isActive = false;
		for (int i = 0; i < StrategieManager.STRATEGIES.length; i++) {
			Strategie strategie = StrategieManager.STRATEGIES[i];
			
			// Is this strategy active?
			if(strategieIsActive(strategie)) {
				// Is active...
				_isActive = true;
				break;
			}
		}
		
		// Re-launch timer if required
		if(_isActive && !previousState) {
			_countDown = _store.getInt(AUTOPLAY_DELAY);
			rearmTimer();
		}
	}
	
	/**
	 * Re-init the count down when the user plays himself.
	 */
	void onUserAction() {
		// Update countDown, and check for state
		_countDown = _store.getInt(AUTOPLAY_DELAY);
		checkForActivity();
	}
	
	/**
	 * End of period.
	 */
	public void run() {
		// If not active any more
		checkForActivity();
		if(!_isActive) {
			return;
		}
		
		// count down is done ?
		_countDown--;
		if(_countDown <= 0) {
			// Do play
			if(doPlay()) {
				// Rearm
				_countDown = _store.getInt(AUTOPLAY_DELAY);
			} else {
				// No use trying again
				_isActive = false;
			}
		} else {
			// Update message 
			String format = Messages.getString("AutoPlayHandler.countDownFormat"); //$NON-NLS-1$
			String message =
				MessageFormat.format(format, new Object[] { new Integer(_countDown) });
			SudokuPlugin.getDefault().message(message, null);
		} // endif - _countDown ! 0
		
		// Rearm timer
		if(_isActive) {
			rearmTimer();
		}
	}
	
	/**
	 * Rearms the timer for next time.
	 */
	void rearmTimer() {
		// usual case
		if(_store.getInt(AUTOPLAY_DELAY) > 0) {
			_display.timerExec(PERIOD, this);
		} else {
			// Dummy case
			_display.asyncExec(this);
		}
	}
	
	/**
	 * Do automatic play according to current prefs...
	 * @return true if something was found...
	 */
	boolean doPlay() {
		// Loop on preferences
		for (int i = 0; i < StrategieManager.STRATEGIES.length; i++) {
			// Get strategy
			Strategie strategie = StrategieManager.STRATEGIES[i];
			
			// Is it active ?
			if(strategieIsActive(strategie)) {
				// Try it
				UIState state = new UIState(_view.getBoard().getState());
				int value = strategie.study(state, true);
				
				// Found something
				if(value !=  0) {
					// Yes !
					// Play it
					_view.getUndoManager().push(_view.getBoard().getState());
					_view.getBoard().getState().addAutoPlay();
					_view.getBoard().setState(state);
					
					// Message
					String message = Messages.getString(strategie.getClass().getName());
					SudokuPlugin.getDefault().message(message, null);
					
					// Was this the final move ?
					if(state.checkForEnd()) {
						// Handle this...
						_view.getUndoManager().handleEndOfGame(state);
					}
					
					// Done
					return true;
				}
			}
		}
		
		// Message - no help !
		SudokuPlugin.getDefault().message(Messages.getString("AutoPlayHandler.noAutoPlayStep"), null); //$NON-NLS-1$
		return false;
	}
	
	/**
	 * Check if strategy is active.
	 * @param strategie to test
	 * @return strategie_p true is yes !
	 */
	boolean strategieIsActive(Strategie strategie_p) {
		// Build key
		String className = strategie_p.getClass().getName();
		className = className.substring(className.lastIndexOf('.') + 1);
		String key = AUTOPLAY_PREFIX + className;
		
		// Check it
		return _store.getBoolean(key);
	}
}
