package tchok.sudoku.gui;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import tchok.sudoku.core.OriginalPositionSolver;
import tchok.sudoku.core.SimpleSolver;
import tchok.sudoku.core.Skill;
import tchok.sudoku.core.State;
import tchok.sudoku.core.Template;
import tchok.sudoku.gui.help.StrongLink;
import tchok.sudoku.gui.help.StrongLinkDetector;

/**
 * UI state, it's a State, and it's more !
 */
public class UIState extends State {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Data holder for extra infos...
	 */
	static class Info {
		/** This board's skill. */
		Skill skill = null;
		
		/** Beginning of game. */
		long startTime;
		
		/** Number of illegal moves */
		int illegalMoves;
		
		/** Number of wrong moves */
		int wrongMoves;
		
		/** Number of undo  */
		int undos;
		
		/** Number of solve request */
		int solves;
		
		/** Number of autoplay  */
		int autoPlays;
		
		/**
		 * true when this game has been solved.
		 * (by the user, so elapsed time is locked).
		 */
		boolean solved;
		
		/** Solution for the current game.  */
		State solution;
		
		/** Initialise. */
		Info() {
			startTime = System.currentTimeMillis();
		}
		
		/**
		 * @return the number of millis this state has been on.
		 */
		long getElapsed() {
			if(!solved) {
				return System.currentTimeMillis() - startTime;
			}
			return startTime;
		}
		
		/**
		 * Lock it
		 */
		void lock() {
			if(!solved) {
				solved = true;
				startTime = System.currentTimeMillis() - startTime;
			}
		}
	}
	
	/** the data .*/
	Info info;
	
	/** Strong links for this state. */
	List<StrongLink> _strongLinks = null;
	
	/**
	 * Build from a State.
	 * @param state_p source data...
	 */
	public UIState(State state_p) {
		super(state_p);
		info = new Info();
	}

	/**
	 * Build from a Template.
	 * @param template_p source data...
	 */
	public UIState(Template template_p) {
		super(template_p);
		info = new Info();
	}

	/**
	 * Build from a UIState.
	 * @param state_p source data...
	 */
	public UIState(UIState state_p) {
		super(state_p);
		info = state_p.info;
	}

	/**
	 * Compute links on first call.
	 * @return the links for this state.
	 */
	public List<StrongLink> getStrongLinks() {
		if(_strongLinks == null) {
			// Compute them
			StrongLinkDetector builder = new StrongLinkDetector();
			_strongLinks = builder.buildLinks(this);
		}
		return _strongLinks;
	}
	/**
	 * @return the current skill (or null)
	 */
	public Skill getSkill() {
		return info.skill;
	}
	
	/**
	 * Set the skill.
	 * @param skill_p value to set.
	 */
	public void setSkill(Skill skill_p) {
		info.skill = skill_p;
	}
	
	/**
	 * @return the number of millis this state has been on.
	 */
	public long getElapsed() {
		return info.getElapsed();
	}
	
	/**
	 * @return the number of undos.
	 */
	public int getUndos() {
		return info.undos;
	}
	
	/**
	 * Add an undo
	 */
	public void addUndo() {
		info.undos++;
	}
	
	/**
	 * @return the number of illegal moves.
	 */
	public int getIllegalMoves() {
		return info.illegalMoves;
	}
	
	/**
	 * Add a illegal move
	 */
	public void addIllegalMove() {
		info.illegalMoves++;
	}
	
	/**
	 * @return the number of wrong moves.
	 */
	public int getWrongMoves() {
		return info.wrongMoves;
	}
	
	/**
	 * Add a wrong move
	 */
	public void addWrongMove() {
		info.wrongMoves++;
	}
	
	/**
	 * @return the number auto solve.
	 */
	public int getSolves() {
		return info.solves;
	}
	
	/**
	 * Add a solve request
	 */
	public void addSolve() {
		info.solves++;
	}
	
	/**
	 * @return the number of autoplay.
	 */
	public int getAutoPlay() {
		return info.autoPlays;
	}
	
	/**
	 * Add an auto play
	 */
	public void addAutoPlay() {
		info.autoPlays++;
	}
	
	/**
	 * Call a solver to build the solution of this State.
	 */
	public void loadSolution() {
		SimpleSolver solver = new OriginalPositionSolver();
		info.solution = solver.solve(this);
	}
	
	/**
	 * @return the solution of this State, or null...
	 */
	public State getSolution() {
		return info.solution;
	}

	/**
	 * Detects end of game...
	 * @return true when the game is over...
	 */
	public boolean checkForEnd() {
		// Let's first check for empty cells
		boolean output = true;
		for(int index=0; index<_template.maxIndex; index++) {
			if(isFree(index)) {
				output = false;
				break;
			}
		}
		
		// Remember
		if(output) {
			info.lock();
		}
		
		// OK
		return output;
	}
	
	/**
	 * Scan for errors in a solution.
	 * @return an array of group of cells with error. (int[])
	 */
	public ArrayList<int []> findErrors() {
		// The errors (indexes)
		ArrayList<int []> invalidIndexes = new ArrayList<int []>();
		
		// Have to loop on neighbourhoods
		for(int value=0; value<_template.maxValue; value++) {
			// Scan on ....
			findErrors(_template.LINE_NEIGHBOURGHOOD[value], invalidIndexes);
			findErrors(_template.COLUMNS_NEIGBOURGHOOD[value], invalidIndexes);
			findErrors(_template.BOXES_NEIGBOURGHOOD[value], invalidIndexes);
		}
		
		// OK
		return invalidIndexes;
	}
	
	/**
	 * Find groups of duplicates value
	 * @param indexes_p cells to scan
	 * @param invalidIndexes_p cells with error (groups of cells with error)
	 */
	void findErrors(int[] indexes_p, ArrayList<int []> invalidIndexes_p) {
		// Loop on values
		for(int value=0; value<_template.maxValue; value++) {
			// Store indexes
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			
			// Start scanning
			for (int loopIndex = 0; loopIndex < indexes_p.length; loopIndex++) {
				int index = indexes_p[loopIndex];
				if(getValue(index)==value) {
					indexes.add(new Integer(index));
				}
			}
			
			// Forget normal case
			if(indexes.size()>1) {
				// Bad luck...
				// Make it an array
				int indexArray[] = new int[indexes.size()];
				for (int loopIndex = 0; loopIndex < indexArray.length; loopIndex++) {
					Integer indexValue = indexes.get(loopIndex);
					indexArray[loopIndex] = indexValue.intValue();
				}
				
				// And store
				invalidIndexes_p.add(indexArray);
			}
		}
	}

	/**
	 * This is a custom Serialisation (for the fun of it).
	 * @param out_p output stream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream out_p) throws IOException {
		// We'll write the skill and elapsed time...
		out_p.writeShort(info.skill.value);
		out_p.writeBoolean(info.solved);
		if(info.solved) {
			out_p.writeLong(info.startTime);
		} else {
			out_p.writeLong(System.currentTimeMillis() - info.startTime);
		}
		out_p.writeInt(info.illegalMoves);
		out_p.writeInt(info.wrongMoves);
		out_p.writeInt(info.undos);
		out_p.writeInt(info.solves);
		out_p.writeInt(info.autoPlays);
	}
	
	/**
	 * This is a custom serialisation.
	 * @param in_p stream to read from.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream in_p) throws IOException, ClassNotFoundException {
		// Read skill
		info = new Info();
		int skill = in_p.readShort();
		for (int i = 0; i < Skill.LEVELS.length; i++) {
			Skill aSkill = Skill.LEVELS[i];
			if(aSkill.value == skill) {
				info.skill = aSkill;
				break;
			}
		}
		
		// Rebuild start time
		info.solved = in_p.readBoolean();
		info.startTime = in_p.readLong();
		if(!info.solved) {
			info.startTime = System.currentTimeMillis() - info.startTime;
		}
		
		// And follow
		info.illegalMoves = in_p.readInt();
		info.wrongMoves = in_p.readInt();
		info.undos = in_p.readInt();
		info.solves = in_p.readInt();
		info.autoPlays = in_p.readInt();
		
		// Also rebuild solution
		loadSolution();
	}
}
