package tchok.sudoku.core;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Reduce the initial number of played case.
 * @author Tchok
 */
public class Reducer extends RandomTool implements ISolverListener {
	private static final int MAX_CANDIDATE_SIZE = 10;

	// The best solution
	private State _bestSolution = null;
	
	// the increment
	private int _bestIncrement = 0;
	
	// To look for single solution
	private boolean _singleSolutionMarker;

	// To keep symetry
	private Symetrizer _symetrizer;
	
	/** Get one. */
	public Reducer() {
		// NOP
	}
	
	/** Simplify a board.*/
	public State simplify(State state_p) {
		// Should not appen..
		if(!state_p.getTemplate().reducable) {
			// But let's be safe
			return new State(state_p);
		}
		
		// Initialize
		_bestSolution = state_p;
		_bestIncrement = -1;
		_symetrizer = state_p.getTemplate().symetrical ?
				new Symetrizer(state_p.getTemplate()) :
				new NoSymetrizer(state_p.getTemplate());
		state_p.clearMarks();
		
		// Build candidates list
		ArrayList<Integer> candidates = selectCandidates(state_p);
		int originalCandidatesSize = candidates.size();
		
		// Filter the candidate list
		filterCandidates(state_p, candidates);
		
		// Sort the list
		ArrayList<Integer> sortedCandidates = new ArrayList<Integer>();
		sortedCandidates = sort(state_p, candidates);
		
		// Limit candidate size.
		// This leads to an not - optimal reduction but also to real perf
		// improvment !
		boolean tooBig = limitSize(sortedCandidates);
		
		// Let's go
		study(state_p, 0, sortedCandidates, 0);
		
		// Play again if a limitation was found
		if(tooBig) {
			// Check something was found, to avoid endless recursions...
			if(selectCandidates(state_p).size() != originalCandidatesSize) {
				// Play again
				return simplify(_bestSolution);
			}
		}
		
		// Clean initial value marks
		_bestSolution.registerOriginalPosition();
		
		// Return what was found
		return _bestSolution;
	}
	
	/**
	 * Limit list's size to N elements, removing the tail.
	 * @param candidates_p
	 */
	private boolean limitSize(ArrayList<Integer> candidates_p) {
		if(candidates_p.size() > MAX_CANDIDATE_SIZE) {
			ArrayList<Integer> shortened = new ArrayList<Integer>(candidates_p.subList(0, MAX_CANDIDATE_SIZE));
			candidates_p.clear();
			candidates_p.addAll(shortened);
			return true;
		}
		return false;
	}
	
	/**
	 * Extract the list of candidates.
	 * (Not free)
	 * @param state_p
	 * @return
	 */
	private ArrayList<Integer> selectCandidates(State state_p) {
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		for(int index=0; index<state_p.getTemplate().maxIndex; index++) {
			if(!state_p.isFree(index)) {
				candidates.add(new Integer(index));
			}
		}
		return candidates;
	}
	
	/**
	 * Filter out candidates if they can't be removed at first level.
	 * @param state_p initial state
	 * @param candidates_p initial list (filtered)
	 */
	private void filterCandidates(State state_p, ArrayList<Integer> candidates_p) {
		// Loop on candidates
		for (Iterator<Integer> iter = candidates_p.iterator(); iter.hasNext();) {
			int index = iter.next().intValue();
			
			// Try to remove it
			State state = new State(state_p);
			state.clean(index);
				
			// And remove symetrical
			int symIndex = _symetrizer.getIndex(index);
			if(symIndex != index) {
				state.clean(symIndex);
			}
			
			// If not still a single solution ?
			state.clearMarks();
			if(!singleSolution(state)) {
				// Remove candidate
				iter.remove();
			} 
		}
	}
	
	/**
	 * Study a state and scan for freeable positions.
	 * When a good score is find, _bestSolution is updated to reflect it.
	 * @param state_p initial state
	 * @param increment_p current score (number of erased position)
	 * @param candidates_p candidate positions (these are Integer)
	 * @param first_p index of the first position to study (in the array)
	 */
	private void study(State state_p, int increment_p, ArrayList<Integer> candidates_p, int first_p) {
//		// Trace it ?
//		if(increment_p < 3) {
//			System.out.println("Reducer.study() -> Level: " + increment_p + ", From: " + first_p + "/" + candidates_p.size() + ", Best: " + _bestIncrement);
//		}
		
		// Loop on positions
		// TODO - candidate.size() ? reduce by something close to (_bestIncrement - increment_p) ?
		for(int cpt=first_p; cpt<candidates_p.size(); cpt++) {
			// Get value
			int index =  candidates_p.get(cpt).intValue();
			int symIndex = _symetrizer.getIndex(index);
			
			// If it's not free
			if(!(state_p.isFree(index) || state_p.isFree(symIndex))) {
				// Remove it
				State state = new State(state_p);
				state.clean(index);
				if(index != symIndex) {
					state.clean(symIndex);
				}
				state.clearMarks();
				
				// Still a single solution ?
				if(singleSolution(state)) {
					// Is it the best one ?
					if(increment_p > _bestIncrement) {
						// Store state
						_bestIncrement = increment_p;
						_bestSolution = new State(state);
//						
//						// Say it
//						System.out.println("Reducer is storing: " + (increment_p+1));
					}
					
					// Try to go farther...
					study(state, increment_p+1, candidates_p, cpt+1);
				}
			}
		}
	}

	/**
	 * @param state_p
	 * @return
	 */
	private boolean singleSolution(State state_p) {
		// Initialize
		_singleSolutionMarker = true;
		Solver solver = new Solver(this);
		
		// Start searching
		solver.solve(state_p);
		
		// So what ?
		// On first solutinon, the flag goeas to false,
		// On second solution, it gets back to true.
		return !_singleSolutionMarker;
	}

	/* (non-Javadoc)
	 * @see tchok.sudoku.core.ISolverListener#foundASolution(tchok.sudoku.core.State)
	 */
	public boolean foundASolution(State state_p) {
		// This is the first one ?
		if(_singleSolutionMarker) {
			// Yes !
			_singleSolutionMarker = false;
			return true;
		}
		
		// No !
		_singleSolutionMarker = true;
		return false;
	}

	/* (non-Javadoc)
	 * @see tchok.sudoku.core.ISolverListener#levelIs(int, tchok.sudoku.core.State)
	 */
	public boolean levelIs(int level_p, State state_p) {
		return true;
	}
	
	/** Sort list by puttin at the end those less seamable to be
	 * removables.
	 * @param candiates_p
	 * @return
	 */
	private ArrayList<Integer> sort(State state_p, ArrayList<Integer> candidates_p) {
		// Let's begin by some counting
		Template tpl = state_p.getTemplate();
		int maxValue = tpl.maxValue;
		int columns[] = new int[maxValue];
		int lines[] = new int[maxValue];
		int square[] = new int[maxValue];
		int values[] = new int[maxValue];
		
		// Loop on indexes
		for (Iterator<Integer> iter = candidates_p.iterator(); iter.hasNext();) {
			int index = iter.next().intValue();
			
			// Column
			int c = tpl.indexToColumn(index);
			int r = tpl.indexToRow(index);
			int s = (r/tpl.rows) * tpl.rows + (c/tpl.columns);
			int v = state_p.getValue(index);
			
			// Update
			columns[c]++;
			lines[r]++;
			square[s]++;
			values[v]++;
		}
		
		// Now let's compute scores
		int scores[] = new int[candidates_p.size()];
		
		// Loop on indexes
		int i = 0;
		for (Iterator<Integer> iter = candidates_p.iterator(); iter.hasNext();) {
			int index = iter.next().intValue();
			
			// Column
			int c = tpl.indexToColumn(index);
			int r = tpl.indexToRow(index);
			int s = (r/tpl.rows) * tpl.rows + (c/tpl.columns);
			int v = state_p.getValue(index);
		
			// Score ?
			scores[i] = 3*(columns[c] + lines[r] + square[s]) + values[v];
			i++;
		}
		
		// And now extract values
		ArrayList<Integer> output = new ArrayList<Integer>();
		while(output.size() != candidates_p.size()) {
			// Scan for the min
			int min = 32768;
			int index = 0;
			for (int j = 0; j < scores.length; j++) {
				int s = scores[j];
				
				// Is it the best ?
				if(s < min) {
					// Store
					min = s;
					index = j;
				}
			}
			
			// Store it
			output.add(candidates_p.get(index));
			scores[index] = 32768;
		}
		
		// Ok
		return output;
	}
}