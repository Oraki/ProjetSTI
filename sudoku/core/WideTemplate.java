package tchok.sudoku.core;

/**
 * Template for a 'big' Sudoku. Handle Sudoku up to 5x5.
 * 
 * Bit use (three int for a box): But bytes are entrelaced, soo bits [33-58] off the
 * first box are in the second stripe, and soo one.
 * <PRE>
 *  1-5   : value
 *  6     : start position marker (1 means yes)
 *  7-31  : possibility to play a value
 *  33-58 : mark 1 (stripe 2)
 *  96-121: mark 2 (stripe 3)
 * </PRE>

 * @author Tchok
 */
public class WideTemplate extends Template {
	// Predefined
	public static final Template T34 = new WideTemplate(3, 4);
	public static final Template T44 = new WideTemplate(4, 4);
	public static final Template T45 = new WideTemplate(4, 5);
	public static final Template T55 = new WideTemplate(5, 5);

	// Debug stuff
	public static final Template WIDE_TEST = new WideTemplate(2, 2);
	/**
	 * @param row_p
	 * @param column_p
	 */
	public WideTemplate(int row_p, int column_p) {
		super(row_p, column_p, true, false);
	}

	
	/**
	 * Set the internal constants.
	 */
	@Override
	protected void fillBaseFields() {
		// Values are in bits 1-5
		VALUE_MASK = 31;
		
		// Max value is 25 so we may use 31
		FREE_VALUE = 31;
		
		// Bit 6 is for the 'original position' marker
		ORIGINAL_POSITION = 1 << 5;
		
		// Byte offset to reach markers
		MARK1_OFFSET = maxIndex;
		MARK2_OFFSET = 2 * maxIndex;
	}
	
	@Override
	protected void fillMarkExtractors() {
		MARK1_EXTRACTOR = new int[maxValue];
		MARK2_EXTRACTOR = new int[maxValue];
		MARK_MASK = 0;
		for(int i=0; i<maxValue; i++) {
			MARK1_EXTRACTOR[i] = 1 << i;
			MARK2_EXTRACTOR[i] = 1 << i;
			MARK_MASK |= MARK1_EXTRACTOR[i];
			MARK_MASK |= MARK2_EXTRACTOR[i];
		}
	}
	
	@Override
	protected void fillValueExtractors() {		
		// Fill Extractors
		INITIAL_VALUE = FREE_VALUE;
		ALL_AVAILABLE_EXTRACTOR = 0;
		VALUE_AVAILABLE_EXTRACTOR = new int[maxValue];
		for(int i=0; i<VALUE_AVAILABLE_EXTRACTOR.length; i++) {
			VALUE_AVAILABLE_EXTRACTOR[i] = 1 << (i + 6);
			INITIAL_VALUE |= VALUE_AVAILABLE_EXTRACTOR[i];
			ALL_AVAILABLE_EXTRACTOR |= VALUE_AVAILABLE_EXTRACTOR[i];
		}
	}

	
	/**
	 * @return memory to keep a state.
	 */
	@Override
	public int [] allocate() {
		return new int[maxIndex * 3];
	}

}