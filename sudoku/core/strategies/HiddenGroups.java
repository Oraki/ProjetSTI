package tchok.sudoku.core.strategies;

import tchok.sudoku.core.Template;

/**
 * Detect two values allowed at the same two positions.
 * And strike other values.
 * @author Tchok
 */
public class HiddenGroups extends Strategie {
	static final int VALUE = 1000;
	static final int SIZE_VALUE = 15;
	
	/** Group size. */
	int _size = 2;
	
	/**
	 * Builds a group detector for a given group's size.
	 * @param size_p group's size
	 */
	public HiddenGroups(int size_p) {
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
		
		// We're looking for a group of N values allowed only
		// at N positions.
		
		// Here is where we'll store values
		int foundValues[] = new int[_size];
		
		// Loop on first value
		for(int value1=0; value1<(_template.maxValue-1);value1++) {
			// Store it
			foundValues[0] = value1;
			
			// Found positions
			int foundPositionsIndex = 0;
			int foundPositions[] = new int[_size];
			
			// Look for allowed values...
			for(int localIndex=0; localIndex<_template.maxValue; localIndex++) {
				// Get index
				int index = indexes_p[localIndex];
				
				// It has to be allowed, and not striked
				if(isAvailable(index, value1)) {
					// Is it one too much ?
					if(foundPositionsIndex == _size) {
						// Yes, there are too many available positions for value1
						foundPositionsIndex = 0;
						break; // Break scanning loop for available position for value1;
					}
					
					// Store and update
					foundPositions[foundPositionsIndex] = index;
					foundPositionsIndex++;
				}
			} // endloop - scanning for two allowed position for value1
			
			// Now, we've found the right number of positions for value1
			// if foundPositionIndex == _size
			if(foundPositionsIndex == _size) {
				// Now we must look for other values...
				// But this time, we must check allowed positions are
				// also allowed for value1 !
				
				// This is counting the number of 'other' matching values
				int otherValuesIndex=1;
				
				// Yes, no scan for another value
				for(int value2=value1+1; value2<_template.maxValue; value2++) {
					int foundPositionsCount = 0;
					//  Loop on values
					for(int localIndex=0; localIndex<_template.maxValue; localIndex++) {
						// Get index
						int index = indexes_p[localIndex];
						
						// It has to be allowed and not striked
						if(isAvailable(index, value2)) {
							// This might be one !
							// Check this position is in the allowed positions
							// for value1
							boolean positionIsAllowedForValue1 = false;
							for (int indexInValue1Positions = 0; indexInValue1Positions < foundPositions.length; indexInValue1Positions++) {
								int candidateIndex = foundPositions[indexInValue1Positions];
								if(index == candidateIndex) {
									// All right, we may keep this one
									foundPositionsCount++;
									positionIsAllowedForValue1 = true;
									break;
								}
							}
							
							// Shall we proceed ?
							if(!positionIsAllowedForValue1) {
								// No, let's break with value2
								foundPositionsCount = 0;
								break; // break loop on localIndex, scanning for position for value2
							}
						} // endif - allowed value
					} // endloop - scanning loop on value2
					
					// So if value is N, we found another value !
					if(foundPositionsCount == _size) {
						// Play safely...
						if(otherValuesIndex == foundValues.length) {
							// This is a default case !
							otherValuesIndex = 0;
							break; // break the loop on value2 !
						}
						
						// Store value
						foundValues[otherValuesIndex] = value2;
						otherValuesIndex++;
					}

				} // endloop - scanning for other values
				
				// How many values have we found ?
				// We're looking fo _size
				if(otherValuesIndex == _size) {
					// This is a success !
					// Log it
//					StringBuffer buffer = new StringBuffer();
//					buffer.append("HiddenGroup" + _size + " found something:\n");
//					for (int i = 0; i < foundPositions.length; i++) {
//						buffer.append(foundPositions[i]).append(", ");
//					}
//					buffer.append("\n");
//					for (int i = 0; i < foundValues.length; i++) {
//						buffer.append(foundValues[i]).append(", ");
//					}
//					buffer.append("\n");
//					System.out.println(buffer.toString());
					
					// Just strike other values
					for(int positionIndex=0; positionIndex<foundPositions.length; positionIndex++) {
						strikeButValues(foundPositions[positionIndex], foundValues);
					}
					
					// Update output
					if(_value != 0) {
//						System.out.println("Effective strike !");
						output = true;
						break;
					}
					
				}
			} // endif - Found two posiitons for value1
			
			// Break the loop
			if(output) {
				break;
			}
		} // endloop - on value1
			
		// OK
		return output;
	}

	/**
	 * update check 'index' by striking values other than those in the array
	 * @param index_p
	 * @param values_p
	 */
	private void strikeButValues(int index_p, int values_p[]) {
		// Loop on values
		for(int value=0; value<_template.maxValue; value++) {
			// Forget the values in the array
			boolean skipValue = false;
			for (int valueArrayIndex = 0; valueArrayIndex < values_p.length; valueArrayIndex++) {
				if(value == values_p[valueArrayIndex]) {
					// Skip it
					skipValue = true;
					break;
				}
			}
			
			if(skipValue) {
				continue;
			}
			
			// It has to be allowed and not striked
			if(isAvailable(index_p, value)) {
				// Strike it
				_state.setMark(index_p, value, Template.STRIKE);
				
				// Found one !
				_value++;
			}
		}
	}

	@Override
	int getStaticValue() {
		return VALUE + SIZE_VALUE * _size;
	}

}
