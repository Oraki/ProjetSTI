package tchok.sudoku.core.strategies;

import tchok.sudoku.core.ISolverListener;
import tchok.sudoku.core.Solver;
import tchok.sudoku.core.State;


/**
 * The Cheater strategie class use a Solver.
 * It's useful to make sure the evaluation process goes to the end.
 * @author Tchok
 */
public class Cheater extends Strategie {
	static final int VALUE = 100000;
	static final int SIZE_VALUE = 20;
	
	/**
	 * The cheater select one of the positions with fewer allowed moves.
	 */
	@Override
	protected void doStudy() {
		// Find a candidate position
		int minAllowedValues = _template.maxValue + 1;
		int bestIndex=-1;
		for(int index=0; index<_template.maxIndex; index++) {
			// It has to be free
			if(_state.isFree(index)) {
				// Scan for allowed moves
				int allowedValues = 0;
				for(int value=0; value<_template.maxValue; value++) {
					// It has to be allowed
					if(isAvailable(index, value)) {
						allowedValues++;
						
						// Break it ?
						if(allowedValues > minAllowedValues) {
							break;
						}
					}
				}
				
				// New record ?
				if(allowedValues < minAllowedValues) {
					// Store it
					bestIndex = index;
					minAllowedValues = allowedValues;
				}
			}
		}
		
		// Found something ?
		if(bestIndex >= 0) {
			// Solve the current state
			
			// Copy the original state
			State state = new State(_state);
			
			// Get a solving solver listener
			final int selectedIndex = bestIndex;
			final int scoreValue = VALUE + SIZE_VALUE * minAllowedValues;
			ISolverListener listener = new ISolverListener() {
				public boolean foundASolution(State state_p) {
					// Get value for selected index
					int value = state_p.getValue(selectedIndex);
					
					// Play it
					_state.play(selectedIndex, value);
					
					// Update score
					_value = scoreValue;
					
					// And stop scanning...
					return false;
				}

				public boolean levelIs(final int level_p, final State state_p) {
					// Don't care
					return true;
				}
			};
			
			// Get a solver
			Solver solver = new Solver(listener);
			
			// Solve (and update original state and score)
			solver.solve(state);
		} // endif - found a best index
	}

	@Override
	int getStaticValue() {
		return VALUE;
	}
}
