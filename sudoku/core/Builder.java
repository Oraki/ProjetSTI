package tchok.sudoku.core;

import java.util.ArrayList;

/**
 * New game builder.
 * </BR>Initialize a position then:
 * <UL><LI>add a move to original position if it has more than one solution
 * <LI>remove a move from original position if it has no solution
 * </UL></BR>
 * until a solution is found....
 * 
 * @author Tchok
 */
public class Builder extends RandomTool implements ISolverListener {
	// Initial position
	State _initialPosition = null;

	// Solution
	State _solution;

	// No remove flag
	private boolean _noRemove;

	// Current count
	private int _count;

	// Solve number of ops
	private int _opsCount;

	// Max value
	private int _maxValue;

	// Max index
	private int _maxIndex;

	// Symetrizer
	private Symetrizer _symetrizer;
	
	/** Get one. */
	public Builder() {
		// NOP
	}

	/**
	 * @return initial state.
	 */
	public State buildOne(Template tpl_p) {
		// Initialize
		_initialPosition = new State(tpl_p);
		_maxIndex = _initialPosition.getTemplate().maxIndex;
		_maxValue = _initialPosition.getTemplate().maxValue;
		_symetrizer = tpl_p.symetrical ?
				new Symetrizer(tpl_p) :
				new NoSymetrizer(tpl_p);

		// Feed it
		initializeState();

		// Clear solution
		_solution = null;
		//		
		// // Say it
		// System.out.println("Builder is starting: " + _count);

		// Start it
		Solver solver = new Solver(this);
		while (_solution == null) {
			// Look for a solution
			_noRemove = false;
			_opsCount = getMaxOpsCount(tpl_p);
			solver.solve(_initialPosition);
			
			// If no solution was found, remove one of the original values
			if ((_solution == null) && (!_noRemove)) {
				removeFromInitialPosition();
			}
			//			
			// // Say it
			// System.out.println("Builder : " + _count);
		}

		// Found a solution, mark it
		State output = new State(_initialPosition);
		output.registerOriginalPosition();

		// OK
		return output;
	}

	/**
	 * Get the max operations count allowed according to template.
	 * This is because some configurations just takes too much time...
	 * 
	 * @param tpl_p
	 *            target template
	 * @return a max number of operation
	 */
	private int getMaxOpsCount(Template tpl_p) {
		// Get size
		int size = tpl_p.maxValue;

		// Fix answer...
		int base = 1000000;
		// TODO Get values from resource ?
		if (size < 10) {
			return base;
		} else if (size < 13) {
			return base * 10;
		} else {
			return base * 100;
		}
	}

	/**
	 * Initialize the starting state.
	 * The <code>_initialPosition</code> should be clean.
	 */
	private void initializeState() {
		// Clean a bit
		_count = 0;

		// 
		// Let's begin with at least one per row/column
		//
		
		// Build two list [0, _maxValue[  
		ArrayList<Integer> columns = new ArrayList<Integer>();
		ArrayList<Integer> rows = new ArrayList<Integer>();
		for (int i = 0; i < _maxValue; i++) {
			columns.add(new Integer(i));
			rows.add(new Integer(i));
		}

		// TODO - Perf - _maxValue - 1 is enough.. Study for speed !!!
		// Insert values...
		// select a random (line, column) and a random value
		for (int i = 0; i < _maxValue; i++) {
			// Get an index
			int l = random(rows);
			int c = random(columns);
			int index = l * _maxValue + c;
			int symIndex = _symetrizer.getIndex(index);

			// It is free ! (we know it)
			// Find a playable value
			int dontRunAllNight = _maxValue;
			while (_initialPosition.isFree(index)
					&& _initialPosition.isFree(symIndex)
					&& (dontRunAllNight-- > 0)) {

				// Try a value
				int value = random(_maxValue);
				if (_initialPosition.isAllowed(index, value)) {
					// Play it
					if (_initialPosition.playWhilePossible(index, value)) {
						_count++;

						// Try for the other one
						if (symIndex != index) {
							boolean rewind = true;
							for (int maxTry = _maxValue * 2; maxTry > 0; maxTry--) {
								value = random(_maxValue);

								// Try it
								if (_initialPosition.isAllowed(symIndex, value)) {
									// Play it
									if (_initialPosition.playWhilePossible(
											symIndex, value)) {
										_count++;
										rewind = false;
										break;
									} else {
										_initialPosition.clean(symIndex);
									}
								}
							} // endloop - on maxTry (sym move)

							// Rewind ?
							if (rewind) {
								// Clear it
								_initialPosition.clean(index);
								_initialPosition.clearMarks();
								_count--;
							}
						} // endif - symIndex != index
					} // endif - index was all right
					else {
						_initialPosition.clean(index);
					}
				} // endif - initial position allowed index
			} // endloop - while it's alowed
		} // endloop - insert a few (one per line/col)
	}

	/**
	 * Just remove any from the original position
	 */
	private void removeFromInitialPosition() {
		// Debug
		// System.out.print(" --- " + _count); //$NON-NLS-1$

		// Scan for different values
		ArrayList<Integer> candidates = new ArrayList<Integer>();

		// Start searchin
		for (int i = 0; i < _maxIndex; i++) {
			if (!_initialPosition.isFree(i)) {
				// Store it
				candidates.add(new Integer(i));
			}
		}

		// Select one
		int index = random(candidates);

		// Remove it
		_count--;
		_initialPosition.clean(index);

		// Remove symetrical
		int symIndex = _symetrizer.getIndex(index);
		if (symIndex != index) {
			_count--;
			_initialPosition.clean(symIndex);
		}

		// Clear marks
		_initialPosition.clearMarks();
	}

	/**
	 * Overriden for a builder...
	 * Store first solution (and keep searching).
	 * add a value to the initial position and stop searching if another solution is found.
	 * @see tchok.sudoku.core.ISolverListener#foundASolution(tchok.sudoku.core.State)
	 */
	public boolean foundASolution(State state_p) {
		// Is it the first one ?
		if (_solution == null) {
			// Yes it is, store it and look for another one
			_solution = new State(state_p);

			// Keep searching
			return true;
		}

		// No it's not, add a move to the original position and replay
		addAMoveToOriginalPosition(state_p);
		
		_solution = null;
		_noRemove = true;
		return false;
	}

	/**
	 * Called when more than one solution is found.
	 * Selects a value that differs in <code>_solution</code> and <code>state_p</code>.
	 * 
	 * @param state_p another solution to the original position.
	 */
	private void addAMoveToOriginalPosition(State state_p) {
		// Debug
		// System.out.print(" +++ " + _count); //$NON-NLS-1$

		// 
		// Scan for different values
		//
		ArrayList<Integer> candidates = new ArrayList<Integer>();

		// Start searching
		for (int i = 0; i < _maxIndex; i++) {
			if (state_p.getValue(i) != _solution.getValue(i)) {
				// Store it
				candidates.add(new Integer(i));
			}
		}

		// Select one
		int index = random(candidates);

		// Play it
		_count++;
		_initialPosition.play(index, state_p.getValue(index));

		// Play the symetrical one
		int symIndex = _symetrizer.getIndex(index);
		if (symIndex != index) {
			_count++;
			_initialPosition.play(symIndex, state_p.getValue(symIndex));
		}
	}

	/*
	 * (non-Javadoc)
	 * Overriden to limit building time...
	 * @see tchok.sudoku.core.ISolverListener#levelIs(int,
	 *      tchok.sudoku.core.State)
	 */
	public boolean levelIs(int level_p, State state_p) {
		// Watch for time limit !
		_opsCount--;

		// Debug stuff
		if ((_opsCount % 1000000) == 0) {
			// System.out.print("."); //$NON-NLS-1$
		}

		// Give up ?
		boolean giveUp = (_opsCount < 0) && (_solution == null);
		return !giveUp;
	}
}