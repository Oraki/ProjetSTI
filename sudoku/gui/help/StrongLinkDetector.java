package tchok.sudoku.gui.help;

import java.util.ArrayList;
import java.util.List;

import tchok.sudoku.core.State;
import tchok.sudoku.core.Template;

/**
 * Detects strong links on a state.
 * @author Tchok (from Andreas's work)
 */
public class StrongLinkDetector {
	// Current state
	State _state;
	
	// current template
	Template _template;
	
	// current links
	List<StrongLink> _links;
	
	/**
	 * Builds and return the list of strong links for a given state.
	 * This is not thread safe!
	 * @param state_p the one to study
	 * @return a list of found links (never null)
	 */
	public List<StrongLink> buildLinks(State state_p) {
		// Initialise 
		_state = state_p;
		_template = _state.getTemplate();
		_links = new ArrayList<StrongLink>();
		
		// It's a good time to have a look to the strong link definition
		// at sudopedia.org (thanks to Andreas by the way)
		
		// scan for bivalue cells
		scanForBivalueCells();
		
		// scan for bilocal units
		scanForBilocalUnits();
		
		// scan for ALS
		scanForALS();
		
		// That's all
		return _links;
	}

	/**
	 * Bivalue cells are cell with only two available
	 * values. So one have to be the right one, and one
	 * have to be the wrong one.
	 */
	private void scanForBivalueCells() {
		// This one is simple...
		
		// Loop on cells
		for(int index = 0; index < _template.maxIndex; index++) {
			// It has to be free
			if(_state.isFree(index)) {
				// First and second available values
				int firstValue = -1;
				int secondValue = -1;
				
				// scan for available values
				for(int value=0; value<_template.maxValue; value++) {
					// It has to be free, not striked
					if(_state.isAvailable(index, value)) {
						// Is it the first one ?
						if(firstValue == -1) {
							firstValue = value;
						} 
						// Might be the second one ?
						else if (secondValue == -1) {
							secondValue = value;
						}
						// otherwise, this is not a bivalue cell...
						else {
							// we'll use secondValue for marker
							secondValue = -1;
							break;
						}
					}
				} // endloop on values
				
				// So did we find one ?
				if(secondValue != -1) {
					// Yes we did...
					StrongLink strongLink = new StrongLink(StrongLink.Type.BIVALUE_CELL);
					strongLink.getElements().add(new StrongLink.Element(index, firstValue));
					strongLink.getElements().add(new StrongLink.Element(index, secondValue));
					
					// store it
					_links.add(strongLink);
				}
			} // endif - it's a free cell
		} // endloop - on index
	}
	
	/**
	 * Bilocal units are values with only two positions in a house.
	 * (House is called neighbourhood elsewhere)
	 */
	private void scanForBilocalUnits() {
		// Scan in lines/columns/boxes
		for(int index=0; index<_template.maxValue; index++) {
			scanForBilocalUnitsInHouse(_template.LINE_NEIGHBOURGHOOD[index]);
			scanForBilocalUnitsInHouse(_template.COLUMNS_NEIGBOURGHOOD[index]);
			scanForBilocalUnitsInHouse(_template.BOXES_NEIGBOURGHOOD[index]);
		}
	}
	
	/**
	 * @param indexes_p the house to scan.
	 */
	private void scanForBilocalUnitsInHouse(int[] indexes_p) {
		// First loop in on values
		for(int value=0; value<_template.maxValue; value++) {
			// First and second position for the value
			int firstIndex = -1;
			int secondIndex = -1;
			
			// Start scanning for available positions
			for(int index=0; index<indexes_p.length; index++) {
				// Get real position index
				int candidateIndex = indexes_p[index];
				
				// It has to be available here
				if(_state.isAvailable(candidateIndex, value)) {
					// Is it the first position
					if(firstIndex == -1) {
						firstIndex = candidateIndex;
					}
					// Is it the second one
					else if(secondIndex == -1) {
						secondIndex = candidateIndex;
					}
					// Otherwise, this is not a bilocal units
					else {
						secondIndex = -1;
						break;
					}
				} // endif - it's available
			} // endloop - on positions
			
			// So did we find one ?
			if(secondIndex != -1) {
				// Yes we did...
				StrongLink strongLink = new StrongLink(StrongLink.Type.BILOCAL_UNIT);
				strongLink.getElements().add(new StrongLink.Element(firstIndex, value));
				strongLink.getElements().add(new StrongLink.Element(secondIndex, value));
				
				// store it
				_links.add(strongLink);
			}
		} // endloop - on values
	}

	private void scanForALS() {
		// TODO Auto-generated method stub
		// The hell if I understood that point !
	}
}
