package tchok.sudoku.core.strategies;

import tchok.sudoku.core.Template;

/**
 * Detect missing values in a Box with allowed positions
 * sharing line or column.
 * Then strike those values from the rest of the line or column.
 * 
 * @author Tchok
 */
public class MissingValuesInLine extends Strategie {
	static final int VALUE = 50;
	
	/* (non-Javadoc)
	 * @see tchok.sudoku.core.strategies.Strategie#doStudy()
	 */
	@Override
	protected void doStudy() {
		// Loop on boxes
		for(int box=0; box<_template.maxValue; box++) {
			studyBox(box);
	
			// Update value
			if(_value != 0) {
				_value = -getStaticValue();
				break;
			}
		}
	}

	/**
	 * Study a single box.
	 * @param box
	 */
	private void studyBox(int box_p) {
		// Loop on values
		for(int value = 0; value<_template.maxValue; value++) {
			// Scan for a single line
			if(scanOnLine(box_p, value)) {
				break;
			}
			
			// Scan on columns !
			if(scanOnColumn(box_p, value)) {
				break;
			}
		}
	}

	/**
	 * Scan a given box for a given value.
	 * @return true if somehting was found
	 */
	private boolean scanOnLine(int box_p, int value_p) {
		// Scan lines for allowed lines
		int line = -1;
		for(int inBox=0; inBox<_template.maxValue; inBox++) {
			// It has to be allowed, and not striked
			int index = _template.BOXES_NEIGBOURGHOOD[box_p][inBox];
			if(isAvailable(index, value_p)) {
				// This might be the one ?
				int candidate = _template.indexToRow(index);
				if(line == -1) {
					line = candidate;
				} else if (candidate != line) {
					// Forget it
					line = -1;
					break;
				}
			}
		} // endloop - scanning loop for 'value'
		
		// Something found ?
		boolean somethingFound = false;
		if(line != -1) {
			// Yes !
			// No we must strike the value in line 
			for(int inLine=0; inLine<_template.maxValue; inLine++) {
				// It should not be in the current box
				int index = _template.LINE_NEIGHBOURGHOOD[line][inLine];
				int boxIndex = _template.indexToBox(index);
				if(boxIndex != box_p) {
					// It should not be striked
					if(isAvailable(index, value_p)) {
						// Strike it
						_state.setMark(index, value_p, Template.STRIKE);
						somethingFound = true;
					}
				}
			}
		} // endif - a line was found
		
		// Update value
		if(somethingFound) {
			_value++;
		}
		
		// OK
		return somethingFound;
	}
	

	/**
	 * Scan a given box for a given value.
	 * @return true if somehting was found
	 */
	private boolean scanOnColumn(int box_p, int value_p) {
		// Scan lines for allowed lines
		int col = -1;
		for(int inBox=0; inBox<_template.maxValue; inBox++) {
			// It has to be allowed, and not striked
			int index = _template.BOXES_NEIGBOURGHOOD[box_p][inBox];
			if(isAvailable(index, value_p)) {
				// This might be the one ?
				int candidate = _template.indexToColumn(index);
				if(col == -1) {
					col = candidate;
				} else if (candidate != col) {
					// Forget it
					col = -1;
					break;
				}
			}
		} // endloop - scanning loop for 'value'
		
		// Something found ?
		boolean somethingFound = false;
		if(col != -1) {
			// Yes !
			// No we must strike the value in col 
			for(int inCol=0; inCol<_template.maxValue; inCol++) {
				// It should not be in the current box
				int index = _template.COLUMNS_NEIGBOURGHOOD[col][inCol];
				int boxIndex = _template.indexToBox(index);
				if(boxIndex != box_p) {
					// It should not be striked
					if(isAvailable(index, value_p)) {
						// Strike it
						_state.setMark(index, value_p, Template.STRIKE);
						somethingFound = true;
					}
				}
			}
		} // endif - a line was found
		
		// Update value
		if(somethingFound) {
			_value++;
		}
		
		// OK
		return somethingFound;
	}

	@Override
	int getStaticValue() {
		return VALUE;
	}
}