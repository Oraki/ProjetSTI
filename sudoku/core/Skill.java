package tchok.sudoku.core;

/**
 * Identify a skill level
 * @author Tchok
 */
public class Skill {
	/** Predefined .*/
	public static final Skill L1 = new Skill(1);
	public static final Skill L2 = new Skill(2);
	public static final Skill L3 = new Skill(3);
	public static final Skill L4 = new Skill(4);
	public static final Skill LEVELS[] = { L1, L2, L3, L4 };
	
	/** The value .*/
	public int value;
	
	/** The label. */
	public String name;
	
	/** Build one. */
	private Skill(int value_p) {
		value = value_p;
		name = "Level" + value_p;  //$NON-NLS-1$
	}
}
