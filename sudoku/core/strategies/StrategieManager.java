package tchok.sudoku.core.strategies;

import java.util.Arrays;
import java.util.Comparator;

import tchok.sudoku.core.State;

/**
 * Handles all know strategies.
 * @author Tchok
 */
public class StrategieManager {
	/** Get it. */
	static public final StrategieManager INSTANCE = new StrategieManager();
	
	// Known strategies
	static public final Strategie STRATEGIES[];
	
	// Fills the Stategies array.
	static  {
		// Instantiate strategies
		Strategie array[] = new Strategie[] {
				new SinglePosition(),
				new SingleValue(),
				new MissingValuesInLine(),
				new Groups(2),
				new Groups(3),
				new Groups(4),
				new Groups(5),
				new Groups(6),
				new Groups(7),
				new Groups(8),
				new Groups(9),
				new HiddenGroups(2),
				new HiddenGroups(3),
				new HiddenGroups(4),
				new HiddenGroups(5),
				new HiddenGroups(6),
				new HiddenGroups(7),
				new HiddenGroups(8),
				new HiddenGroups(9),
				new Cheater()
			};
		
		// Sort them
		Comparator<Strategie> cmp = new Comparator<Strategie>(){
			public int compare(Strategie arg0, Strategie arg1) {
				return new Integer(arg0.getStaticValue()).compareTo(new Integer(arg1.getStaticValue()));
			}
		};
		Arrays.sort(array, 0, array.length, cmp);
		
		// And store
		STRATEGIES = array;
	}
	
	/**
	 * Study a position.
	 * <p>The 'play' mode is dedicated to the evaluation of an initial state.</p>
	 * <p>The 'mark' mode is to help the player (but it's like cheating!)</p>
	 * @param state_p the state to study (update)
	 * @param mode_p the mode to use (true for play, false for mark)
	 * @return the 'hardness' of found solutions (and the state is updated)
	 */
	public int study(State state_p, boolean mode_p) {
		return doStudy(state_p, mode_p, STRATEGIES);
	}
	
	private  synchronized int doStudy(State state_p, boolean mode_p, Strategie strategies_p[]) {
		// Output value
		int output = 0;
		
		// Start looping on strategies
		// Strategies are supposed to be ordered, so we'll scan from the first to the last,
		// starting back at the beginning every time something is found
		int currentIncrement = 0;
		do {
			// Nothing so far
			currentIncrement = 0;
			
			// Loop on strategies
			for (int i = 0; i < strategies_p.length; i++) {
				// Get it
				Strategie strategie = strategies_p[i];
				
				// Get answer from the strategie
				currentIncrement = strategie.study(state_p, mode_p);
				
				// Something found ?
				if(currentIncrement != 0) {
					// Update count
					if(currentIncrement > 0) {
						output += currentIncrement;
					} else {
						output -= currentIncrement;
					}
					
					// And restart
					break;
				}
			}
		} while( currentIncrement != 0);
		
		// OK
		return output;
	}
}