package tchok.sudoku.core;


/**
 * Template for the data encoding. Handles sudoku up to 9x9
 * A bit complex, I admit it!
 * Bit use:
 * <PRE>
 *  1-4  : value
 *  // 5    : free tag ( 1 means free)
 *  5    : start position marker (1 means yes)
 *  6-14 : possibility to play a value (1 is for yes)
 *  15-23: mark 1
 *  24-32: mark 2
 * </PRE>
 * @author Tchok.
 */
public class Template {
	// Predefined
	public static final Template T22 = new Template(2, 2, false, false);
	public static final Template T23 = new Template(2, 3, true, true);
//	public static final Template T32 = new Template(3, 2);
	public static final Template T33 = new Template(3, 3, true, true);
	
	/** The strike mark. */
	static public final int STRIKE = 1;
	
	/** The Highlight mark */
	static public final int HIGHLIGHT = 2;

	/** Number of columns. */
	public final int columns;
	
	/** Number of row; */
	public final int rows;
	
	/** Max value. */
	public final int maxValue;
	
	/** Max square index */
	public final int maxIndex;

	/** True for a symetrical board. */
	public final boolean symetrical;

	/** True if reducer is allowed. */
	public final boolean reducable;
	
	// Common name
	public final String name;
	
	// Initial value
	int INITIAL_VALUE;

	// Empty indicator (1111)
	int FREE_VALUE;

	// All marks mask
	int MARK_MASK;

	// First mark extractors
	int MARK1_EXTRACTOR[];

	// Secondary marks extractors
	int MARK2_EXTRACTOR[];

	// To check if a value is allowed
	int VALUE_AVAILABLE_EXTRACTOR[];
	
	// Available extractor
	int ALL_AVAILABLE_EXTRACTOR;

	// Value mask
	int VALUE_MASK;

	// Original position marker
	int ORIGINAL_POSITION;
	
	// Offset to reach the int with mark 1 bits
	int MARK1_OFFSET;
	
	// Offset to reach mark 2 bits
	int MARK2_OFFSET;
	
	// The column neighbourhood
	public int COLUMNS_NEIGBOURGHOOD[][];
	public int INDEX_TO_COLUMN[];
	
	// The lines
	public int LINE_NEIGHBOURGHOOD[][];
	public int INDEX_TO_LINE[];
	
	// The boxes
	public int BOXES_NEIGBOURGHOOD[][];
	public int INDEX_TO_BOX[];
	
	/** The neighbourghoods
	* <P>Say for box with index i, you may get
	* <PRE>
	* NEIGHBOURGHOODS[i][0] for the whole line
	* NEIGHBOURGHOODS[i][1] for the whole column
	* NEIGHBOURGHOODS[i][2] for the whole box
	* </PRE>
	* </P>
	**/
	public int NEIGHBOURGHOODS[][][];
	
	/**
	 * Set the internal constants.
	 */
	protected void fillBaseFields() {
		// Values are in bits 1-4
		VALUE_MASK = 15;
		
		// Max value is 9 so we may use 15
		FREE_VALUE = 15;
		
		// Bit 5 is for the 'original position' marker
		ORIGINAL_POSITION = 1 << 4;
		
		// Byte offset to reach markers
		MARK1_OFFSET = 0;
		MARK2_OFFSET = 0;
	}

	/** Get one
	 * @param row_p rows in a big square
	 * @param column_p columns in a big square
	 * @param symetrical_p true for a symetrical board
	 */
	protected Template(int row_p, int column_p, boolean symetrical_p, boolean reducable_p) {
		// Store shape
		columns = column_p;
		rows = row_p;
		symetrical = symetrical_p;
		reducable = reducable_p;
		
		// Build name
		name = new String(column_p + "x" + row_p); //$NON-NLS-1$
		
		// Simple extra computation
		maxValue = row_p * column_p;
		maxIndex = maxValue * maxValue;
		
		// Fill constants
		fillBaseFields();

		// Fill value extractors
		fillValueExtractors();
		
		// Fill mark extractor
		fillMarkExtractors();
		
		// Fill neighbourghoods
		fillNeigbourghoods();
	}
	
	protected void fillMarkExtractors() {
		MARK1_EXTRACTOR = new int[maxValue];
		MARK2_EXTRACTOR = new int[maxValue];
		MARK_MASK = 0;
		for(int i=0; i<maxValue; i++) {
			MARK1_EXTRACTOR[i] = 1 << (14 + i);
			MARK2_EXTRACTOR[i] = 1 << (23 + i);
			MARK_MASK |= MARK1_EXTRACTOR[i];
			MARK_MASK |= MARK2_EXTRACTOR[i];
		}
	}
	
	protected void fillValueExtractors() {		
		// Fill Extractors
		INITIAL_VALUE = FREE_VALUE;
		ALL_AVAILABLE_EXTRACTOR = 0;
		VALUE_AVAILABLE_EXTRACTOR = new int[maxValue];
		for(int i=0; i<VALUE_AVAILABLE_EXTRACTOR.length; i++) {
			VALUE_AVAILABLE_EXTRACTOR[i] = 1 << (i + 5);
			INITIAL_VALUE |= VALUE_AVAILABLE_EXTRACTOR[i];
			ALL_AVAILABLE_EXTRACTOR |= VALUE_AVAILABLE_EXTRACTOR[i];
		}
	}
	
	private void fillNeigbourghoods() {
		// Fill line neighbourghood
		LINE_NEIGHBOURGHOOD = new int[maxValue][maxValue];
		INDEX_TO_LINE = new int[maxIndex];
		for(int line=0; line<maxValue; line++) {
			for(int col=0; col<maxValue; col++) {
				int index = line * maxValue + col;
				LINE_NEIGHBOURGHOOD[line][col] = index;
				INDEX_TO_LINE[index] = line;
			}
		}
		
		// Fill columns neighbourghood
		COLUMNS_NEIGBOURGHOOD = new int[maxValue][maxValue];
		INDEX_TO_COLUMN = new int[maxIndex];
		for(int line=0; line<maxValue; line++) {
			for(int col=0; col<maxValue; col++) {
				int index = line * maxValue + col;
				COLUMNS_NEIGBOURGHOOD[col][line] = index;
				INDEX_TO_COLUMN[index] = col;
			}
		}
		
		// Fill boxes neighbourghood
		BOXES_NEIGBOURGHOOD = new int[maxValue][maxValue];
		INDEX_TO_BOX = new int[maxIndex];
		for(int boxLine=0; boxLine<columns; boxLine++) {
			for(int boxCol=0; boxCol<rows; boxCol++) {
				// Loop in box
				int boxIndex = boxLine * rows + boxCol;
				for(int line=0; line<rows; line++) {
					for(int col=0; col<columns; col++) {
						// value in box
						int indexInBox = line * columns + col;
						int index = (boxLine * rows + line) * maxValue +
							boxCol * columns + col;
						BOXES_NEIGBOURGHOOD[boxIndex][indexInBox] = index;
						INDEX_TO_BOX[index] = boxIndex;
					}
				}
				
			}
		}
		
		// Fill neighbourhoods
		NEIGHBOURGHOODS = new int[maxIndex][3][maxValue];
		for(int index=0; index<maxIndex; index++) {
			NEIGHBOURGHOODS[index][0] = LINE_NEIGHBOURGHOOD[INDEX_TO_LINE[index]];
			NEIGHBOURGHOODS[index][1] = COLUMNS_NEIGBOURGHOOD[INDEX_TO_COLUMN[index]];
			NEIGHBOURGHOODS[index][2] = BOXES_NEIGBOURGHOOD[INDEX_TO_BOX[index]];
		}
	}

	/**
	 * Convert index to row
	 * @param index_p
	 * @return the row index
	 */
	public int indexToRow(int index_p) {
		return index_p / maxValue;
	}
	
	/**
	 * Convert index to column
	 * @param index_p
	 * @return
	 */
	public int indexToColumn(int index_p) {
		return index_p % maxValue;
	}
	
	/**
	 * Convert index to box index.
	 * @param index_p
	 * @return
	 */
	public int indexToBox(int index_p) {
		// Get basic
		int line = indexToRow(index_p);
		int col = indexToColumn(index_p);
		
		// Transform to box indexes
		line = line / rows;
		col = col / columns;
		
		// Compute box index
		return line * rows + col;
	}
	
	/**
	 * @return memory to keep a state.
	 */
	public int [] allocate() {
		return new int[maxIndex];
	}
}
