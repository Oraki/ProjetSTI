package tchok.sudoku;

/**
 * Defines events type for sudoku.
 * @author Tchok
 */
public interface IEventTypes {
	/** 
	 *  fired when a StateStore push or pop a state.
	 *  source is the store.
	 */
	static public final int STATE_STORE_EVENT = 1;
	
	/**
	 * fired when a builder reach an specific state.
	 * source is the template.
	 * data is one of BUILDING, REDUCING, YIELD.
	 */
	static public final int BUILDER_EVENT = 2;
	
	/** The builder is building a new state. (not an event's type)*/
	public static final Integer BUILDING = new Integer(1);
	
	/** The builder is trying to reduce (make more difficult) a state.  (not an event's type)*/
	public static final Integer REDUCING = new Integer(2);
	
	/** The builder is going to bed.  (not an event's type)*/
	public static final Integer YIELD = new Integer(0);

	/**
	 * fired when the user selects a new value to highlight.
	 * data is the new selected value (in an Integer).
	 */
	public static final int HIGHLIGHT_SELECTION = 3;
	
	/**
	 * fired to request for a change in the highlighted value.
	 * this is NOT a message but a request.
	 * data is the request (-1, +1).
	 */
	public static final int HIGHLIGHT_SELECTION_RQ = 4;
	
	/**
	 * fired when the current template change.
	 * data is the new template.
	 */
	public static final int TEMPLATE_CHANGED = 5;
}
