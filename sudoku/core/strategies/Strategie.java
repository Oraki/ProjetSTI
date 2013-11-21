package tchok.sudoku.core.strategies;

import tchok.sudoku.core.State;
import tchok.sudoku.core.Template;

/**
 * Base class for strategies.
 * 
 * @author Tchok
 */
public abstract class Strategie {
	// The current state
	State _state;
	
	// The current state's template
	Template _template;
	
	// The current mode
	// true means 'play'
	boolean _mode;
	
	// The current 'value'
	int _value;
	
	/**
	 * Study a position.
	 * @param state_p position to study (may be modified) 
	 * @param mode_p true for 'do play', false for 'just mark'
	 * @return the 'value (hardness?)' of the strategie, 0 for 'nothing found'
	 */
	public int study(State state_p, boolean mode_p) {
		// Initialize
		_state = state_p;
		_template = _state.getTemplate();
		_mode = mode_p;
		_value = 0;
		
		// Do study this position
		doStudy();
		
		// And return count
		return _value;
	}
	
	/**
	 * Do study the current state.
	 */
	protected abstract void doStudy();
	
	/**
	 * The static value is the score for this Strategie.
	 * It's positive.
	 * @return the static value.
	 */
	abstract int getStaticValue();
	
	/**
	 * Convenience method to test a value.
	 * @param index_p
	 * @param value_p
	 * @return true if free, allowed, not striked
	 */
	boolean isAvailable(int index_p, int value_p) {
		return _state.isAvailable(index_p, value_p);
	}
}
