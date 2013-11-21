package tchok.sudoku.core.strategies;

import tchok.sudoku.core.Template;

/**
 * Single position is when there is just one place for
 * a value in line/col/box.
 * @author Tchok
 */
public class SinglePosition extends Strategie {
	static final int VALUE = 10;
	
	/**
	 * Do study.
	 */
	@Override
	protected void doStudy() {
		// First loop is on (LINE/COL/BOXE)
		for(int value=0; value<_template.maxValue; value++) {
			// Check one lines
			if(check(_template.LINE_NEIGHBOURGHOOD[value])) {
				break;
			}
			
			// Check on columns
			if(check(_template.COLUMNS_NEIGBOURGHOOD[value])) {
				break;
			}
			
			// Check on boxes
			if(check(_template.BOXES_NEIGBOURGHOOD[value])) {
				break;
			}
		}
		
		// Update value
		if(_value != 0) {
			_value = VALUE;
		}
	}

	/**
	 * Check for a given set of indexes.
	 * @param indexes_p
	 */
	private boolean check(int indexes_p[]) {
		// TODO - Optimise this by:
		// A first loop to remove values that are already played in this
		// neighbourhood
		// OR
		// break the loop if the target value is found
		// First make test on the builder and the reducer!
		
		// Loop on values
		for(int value = 0; value<_template.maxValue; value++) {
			// Scan for it in the neighbourhood
			int foundIndex = -1;
			for(int index=0; index<_template.maxValue; index++) {
				// It has to be allowed and not stroked
				int candidateIndex = indexes_p[index];
				if(isAvailable(candidateIndex, value)) {
					// The value is allowed here !
					// This might be the one ?
					if(foundIndex == -1) {
						foundIndex = candidateIndex;
					} else {
						// It's another location...
						foundIndex = -1;
						break;
					}
				} // endif - might be ?
			} // endloop - on index in the indexes array
			
			// Found one ?
			if(foundIndex != -1) {
				// But we have have known this before !
				if((_state.getMark(foundIndex, value) & Template.HIGHLIGHT) == 0) {
					// it's really a new one !
					if(_mode) {
						// Play it
						_state.play(foundIndex, value);
					} else {
						// Mark it
						_state.setMark(foundIndex, value, Template.HIGHLIGHT);
					}
					
					// Update value
					_value++;
					
					// And don't play more than once
					break;
				}
			}
		}
		
		return _value != 0;
	}

	@Override
	int getStaticValue() {
		return VALUE;
	}
}