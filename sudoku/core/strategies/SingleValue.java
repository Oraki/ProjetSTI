package tchok.sudoku.core.strategies;

import tchok.sudoku.core.Template;

/**
 * Single value is when there is only one allowed value
 * for a box.
 * @author Tchok
 */
public class SingleValue extends Strategie {
	static final int VALUE = 15;
	
	/**
	 * Scan for solutions.
	 */
	@Override
	protected void doStudy() {
		// Loop on boxes
		for(int index=0; index<_template.maxIndex; index++) {
			// It has to be free,
			if(_state.isFree(index)) {
				// Loop on values...
				int foundValue = -1;
				for(int value=0; value<_template.maxValue; value++) {
					// It has to be allowed
					// It can't be Striked
					if(isAvailable(index, value)) {
						// This might be a value
						if(foundValue == -1) {
							foundValue = value;
						} else {
							// This is a second value...
							// No more hope !
							foundValue = -1;
							break;
						}
					}
				} // endloop on values
				
				// Something to play ?
				if(foundValue != -1) {
					// Yes !
					
					// But we might have known it before
					if((_state.getMark(index, foundValue) & Template.HIGHLIGHT) == 0) {
						// Play ?
						if(_mode) {
							// Do play
							_state.play(index, foundValue);
						} else {
							// Just mark
							_state.setMark(index, foundValue, Template.HIGHLIGHT);
						}
						
						// One more !
						_value ++;
						break;
					} // endif - this is new to me !
				} // Endif - found something
			} // endloop - on indexes

			// Update value
			if(_value != 0) {
				_value = 15;
				break;
			}
		} // Endloop - on boxes
		
		// Update value
		if(_value != 0) {
			_value = VALUE;
		}

	}

	@Override
	int getStaticValue() {
		return VALUE;
	}
}
