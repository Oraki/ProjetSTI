package tchok.sudoku.core.strategies;

import tchok.sudoku.core.Template;

/**
 * Detect groups of N positions allowing only the same N values
 * and strike the values from other positions.
 * @author Tchok
 */
public class Groups extends Strategie {
	static final int VALUE = 1000;
	static final int SIZE_VALUE = 10;
	
	/** Group size. */
	int _size = 2;
	
	/**
	 * Build a Groups detector for a given group's size.
	 * @param size_p group's size
	 */
	public Groups(int size_p) {
		_size = size_p;
	}
	
	/**
	 * Do scan...
	 */
	@Override
	protected void doStudy() {
		// Have to loop on neighbourghoods
		for(int value=0; value<_template.maxValue; value++) {
			// Scan on ....
			// Stoping when something is found
			if(scan(_template.LINE_NEIGHBOURGHOOD[value])) {
				break;
			}
			if(scan(_template.COLUMNS_NEIGBOURGHOOD[value])) {
				break;
			}
			if(scan(_template.BOXES_NEIGBOURGHOOD[value])) {
				break;
			}
		}

		// Update value
		if(_value != 0) {
			_value = -getStaticValue();
		}
	}

	/**
	 * Scan a set of indexes
	 * @return true if something was found
	 */
	private boolean scan(int[] indexes_p) {
		// Output
		boolean output = false;
		
		// We're looking for N group of N values, only values allowed 
		// at those positions.

		// Loop on position
		for (int pos1Index = 0; pos1Index < (indexes_p.length - _size); pos1Index++) {
			// First position is
			int pos1 = indexes_p[pos1Index];
			int foundPositions[] = new int[_size];
			int foundPositionsIndex=0;

			// Look for allowed values (we're looking for excatly N)
			int foundValues[] = new int[_size];
			int foundValuesIndex=0;
			for(int value=0; value<_template.maxValue; value++) {
				// It has to be allowed
				if(isAvailable(pos1, value)) {
					// Is it one too much ?
					if(foundValuesIndex == _size) {
						// This is one too much...
						// retry with another first position...
						foundValuesIndex = 0;
						break; // break loop on value
					}
					
					// Store it
					foundValues[foundValuesIndex] = value;
					foundValuesIndex++;
				}
			} // endloop - on values for pos1
			
			// Give up ? (wrong number of available moves)
			if(foundValuesIndex != _size) {
				// Yes, give up... But try again with next first position
				continue;
			}
			
			// Now we have to scan other position, looking
			// for excatly the same allowed values
			
			// Store a few
			foundPositions[0] = pos1;
			foundPositionsIndex++;
			
			// And start scanning
			for(int pos2Index=pos1Index+1; pos2Index<_template.maxValue; pos2Index++) {
				// Get index
				int pos2 = indexes_p[pos2Index];
				
				// It has to allow the same positions
				int matchingValuesCount=0;
				
				// scan for allowed values
				for(int value=0; value<_template.maxValue; value++) {
					// If it's allowed, check it's the right value
					if(isAvailable(pos2, value)) {
						// Is it one to much ?
						if(matchingValuesCount == _size) {
							// Yes it it, give up with pos2
							matchingValuesCount = 0;
							break; // break loop on value
						}
						
						// Check value
						if(value != foundValues[matchingValuesCount]) {
							// It's not the right one !
							matchingValuesCount = 0;
							break; // break loop on value
						}
						
						// It's the right one !
						matchingValuesCount++;
					} else {
						// It's not allowed...
						// But should it be ?
						if(matchingValuesCount < _size) {
							if(value == foundValues[matchingValuesCount]) {
								// It should have been allowed !
								matchingValuesCount = 0;
								break; // break loop on value
							}
						}
					}
				} // endloop - scanning for other allowed moves
				
				// wrong number of other positions ?
				if(matchingValuesCount != _size) {
					// bad luck!
					// retry with another position
					continue;
				}
				
				// Store this position
				if(foundPositionsIndex == _size) {
					// THis is one too much (should never appen ?)
					foundPositionsIndex = 0;
					break; // break loop on other positions
				}
				foundPositions[foundPositionsIndex] = pos2;
				foundPositionsIndex++;
			} // endloop - on other positions
			
			// So what ?
			if(foundPositionsIndex == _size) {	
				// Found matching groups !
				// This is a success !
				// Log it
//				StringBuffer buffer = new StringBuffer();
//				buffer.append("Group" + _size + " found something:\n");
//				for (int i = 0; i < foundPositions.length; i++) {
//					buffer.append(foundPositions[i]).append(", ");
//				}
//				buffer.append("\n");
//				for (int i = 0; i < foundValues.length; i++) {
//					buffer.append(foundValues[i]).append(", ");
//				}
//				buffer.append("\n");
//				System.out.println(buffer.toString());
				
				// Just strike values at other places
				strikeValuesElsewhere(indexes_p, foundPositions, foundValues);
				
				// Update output
				if(_value != 0) {
//					System.out.println("Effective strike !");
					output = true;
					break;
				}		
			}
		}
			
		// OK
		return output;
	}

	/**
	 * Strike 'values' everywhere but 'position' in 'indexes'
	 * @param indexes
	 * @param positions
	 * @param values
	 */
	private void strikeValuesElsewhere(int indexes[], int positions[], int values[]) {
		// Loop on positions
		for (int indexIndex = 0; indexIndex < indexes.length; indexIndex++) {
			int position = indexes[indexIndex];
			
			// Process it ?
			boolean skip = false;
			for (int positionIndex = 0; positionIndex < positions.length; positionIndex++) {
				if(positions[positionIndex] == position) {
					// Do skip
					skip = true;
					break;
				}
			}
			
			// Do strike
			if(!skip) {
				// Loop on values
				for (int valueIndex = 0; valueIndex < values.length; valueIndex++) {
					int value = values[valueIndex];
					
					// It has to be allowed and not striked
					if(isAvailable(position, value)) {
						// Strike it
						_state.setMark(position, value, Template.STRIKE);
						
						// Found one !
						_value++;
					}					
				} // endloop - striking loop
			} // endif - don't skip
		} // endloop - positions in neighbourghood
	}

	@Override
	int getStaticValue() {
		return VALUE + SIZE_VALUE * _size;
	}
}
