package tchok.sudoku.core;


/**
 * @author Tchok
 */
public class Solver {
	// All the states 
	State _states[];
	
	// The listener
	ISolverListener _listener;
	
	// Limits
	private int _maxIndex;
	private int _maxValue;
	
	/** Give it a listener. */
	public Solver(ISolverListener listener_p) {
		_listener = listener_p;
	}
	
	/** Do solve it. */
	public void solve(State state_p) {
		// get template
		_maxIndex = state_p.getTemplate().maxIndex;
		_maxValue = state_p.getTemplate().maxValue;
		
		// Let's alocate a few..
		_states = new State[_maxIndex+1];
		for(int i=0; i<_states.length; i++) {
			_states[i] = new State(state_p.getTemplate());
		}
		
		// And get going
		_states[0].loadFrom(state_p);
		study(0);
	}

	/**
	 * Study a specific index
	 * @param index_p
	 * @return true to keep going, false to stop
	 */
	private boolean study(int index_p) {
		
		// Get it
		State state = _states[index_p];
		
		// Not too far
		if(index_p == _maxIndex) {
			return _listener.foundASolution(state);
		}
		
		// Warn listener
		if(!_listener.levelIs(index_p, state)) {
			return false;
		}

		// is it free ?
		if(state.isFree(index_p)) {
			// We'll have to study it all
			for(int value=0; value<_maxValue; value++) {
				// is it allowed ?
				if(state.isAvailable(index_p, value)) {
					// Let's try it
					_states[index_p + 1].loadFrom(state);
					boolean answer = _states[index_p + 1].playWhilePossible(index_p, value);
					
					// Recurse ?
					if(!answer) {
						continue;
					}
					
					// Recurse
					answer = study(index_p+1);
					if(!_listener.levelIs(index_p, state)) {
						return false;
					}
					
					// So what ?
					if(!answer) {
						return false;
					}
				} // endif - it's allowed
			} // endloop on values
			
			// Keep going
			return true;
		} // endif - it's free
		
		// Just call the next one
		_states[index_p+1].loadFrom(state);
		return study(index_p+1);
	}
}
