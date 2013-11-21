package tchok.sudoku.core;

/**
 * Simple solver, just solve it!
 */
public class SimpleSolver implements ISolverListener {
	/** The state to solve. */
	private State _state;
	
	/**
	 * Solve it!
	 * @param state_p the state to solve.
	 * @return a solved copy, or null when there is no solutions.
	 */
	public State solve(State state_p) {
		// Store datas
		_state = null;
		
		// Call solver
		Solver solver = new Solver(this);
		solver.solve(state_p);
		
		// Return answer...
		return  _state;
	}
	
	public boolean foundASolution(final State state_p) {
		_state = state_p;
		return false;
	}

	public boolean levelIs(final int level_p, final State state_p) {
		return true;
	}
}
