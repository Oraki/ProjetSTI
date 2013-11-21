package tchok.sudoku.core;

/**
 * @author Tchok
 */
public interface ISolverListener {
	/** Called when a solution is found.
	 * @param state_p the solution
	 * @return true to keep searching, false to stop
	 */
	public boolean foundASolution(State state_p);
	
	/** Called when level changes. 
	 * return false to stop scanning.
	 */
	public boolean levelIs(int level_p, State state_p);
}
