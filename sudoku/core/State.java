package tchok.sudoku.core;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * @author Tchok
 */
public class State implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** basic states.
	 * Bit use:
	 *  1-4  : value
	 *  // 5    : free tag ( 1 means free)
	 *  5    : start position marker (1 means yes)
	 *  6-14 : possibility to play a value (4 is for 0)
	 *  15-23: mark 1
	 *  24-32: mark 2
	 */
	private int _states[];
	
	/** This board's template.*/
	protected Template _template = Template.T33;
	
	/** Creates an emty board.*/
	public State(Template template_p) {
		// Store
		_template = template_p;
		
		// Allocate
		_states = _template.allocate();
		
		// All clear
		for (int i = 0; i < _template.maxIndex; i++) {
			_states[i] = _template.INITIAL_VALUE;
		}
	}
	
	public State(State state_p) {
		// Init
		_template = state_p._template;
		
		// Allocate
		_states = _template.allocate();
		
		// And copy
		loadFrom(state_p);
	}
	
	/** Load values. */
	public void loadFrom(State state_p) {
		// Just copy it
		System.arraycopy(state_p._states, 0, _states, 0, _states.length);
	}

	/**
	 * Play by modifying this state.
	 * @param index_p
	 * @param value_p
	 */
	public void play(int index_p, int value_p) {
		// Mark the new position.
		clearBits(index_p, _template.VALUE_MASK);
		clearBits(index_p, _template.ALL_AVAILABLE_EXTRACTOR);
		markBits(index_p, value_p);
		
		// Propagate forbidden move to neighbourhood
		int [][] indexes = _template.NEIGHBOURGHOODS[index_p];
		int extractor = _template.VALUE_AVAILABLE_EXTRACTOR[value_p];
		for(int value=0; value<_template.maxValue; value++) { 
			for(int cIndex=0; cIndex<3; cIndex++) { // LINE/COL/BOXES
				clearBits(indexes[cIndex][value], extractor);
			}
		}
	}

	/**
	 * Play by modifying this state.
	 * Stops when a position without allowed move is detected.
	 * @param index_p
	 * @param value_p
	 */
	public boolean playWhilePossible(int index_p, int value_p) {
		// TODO - define CONNECTED_INDEX (summing line, row and boxes) for every index (in Template)
		// and rewrite in one loop
		
		// Mark the new position.
		clearBits(index_p, _template.VALUE_MASK | _template.ALL_AVAILABLE_EXTRACTOR);
		markBits(index_p, value_p);
		
		// Propagate forbidden move to neighbourhood
		int [][] indexes = _template.NEIGHBOURGHOODS[index_p];
		int extractor = _template.VALUE_AVAILABLE_EXTRACTOR[value_p];
		for(int value=0; value<_template.maxValue; value++) { 
			for(int cIndex=0; cIndex<3; cIndex++) { // LINE/COL/BOXES
				int finalIndex = indexes[cIndex][value];
				clearBits(finalIndex, extractor);
				// Stop if...
				// the target cell (the one we're clearing marks) is free but shows
				// no more available values.
				if(isFree(finalIndex) && ((_states[finalIndex] & _template.ALL_AVAILABLE_EXTRACTOR) == 0)) {
					return false;
				}
			}
		}
		
		// OK
		return true;
	}	
	
	public void clean(int index_p) {
		// Let's get a copy of the current position
		State clean = new State(_template);
		
		// Let's clean the requested position
		markBits(index_p, _template.FREE_VALUE);
		
		// And start rebuilding
		for(int i = 0; i<_template.maxIndex; i++) {
			// Check it
			if(!isFree(i)) {
				clean.play(i, getValue(i));
			}
			
			// Copy marks
			clean.markBits(i, _states[i] & _template.ORIGINAL_POSITION);
			clean.markBits(i + _template.MARK1_OFFSET, _states[i + _template.MARK1_OFFSET] & _template.MARK_MASK);
			clean.markBits(i + _template.MARK2_OFFSET, _states[i + _template.MARK2_OFFSET] & _template.MARK_MASK);
		}
		
		// get new values
		_states = clean._states;
	}
	
	/** Check if free.*/
	public boolean isFree(int index_p) {
		return checkBit(index_p, _template.FREE_VALUE);
	}
	
	/** Check if a move is allowed. */
	public boolean isAllowed(int index_p, int value_p) {
		return checkBit(index_p, _template.VALUE_AVAILABLE_EXTRACTOR[value_p]);
	}
	
	/** Get a value.
	 * @param index_p
	 * @return the value but 0 if it's free !
	 */
	public int getValue(int index_p) {
		return _states[index_p] & _template.VALUE_MASK;
	}
	
	/**
	 * @param index case
	 * @param value to scan for
	 * @return the mark state 0, 1, 2 or 3 for both marks
	 */
	public int getMark(int index_p, int value_p) {
		// Output
		int output = 0;
		
		// Read mark 1
		if(checkBit(index_p + _template.MARK1_OFFSET, _template.MARK1_EXTRACTOR[value_p])) {
			output = Template.STRIKE;
		}
		
		// Read mark 2
		if(checkBit(index_p + _template.MARK2_OFFSET, _template.MARK2_EXTRACTOR[value_p])) {
			output += Template.HIGHLIGHT;
		}
		
		// Ok
		return output;
	}
	
	public void setMark(int index_p, int value_p, int mark_p) {
		// Mark 1
		if((mark_p & 1) != 0) {
			markBits(index_p + _template.MARK1_OFFSET, _template.MARK1_EXTRACTOR[value_p]);
		} else {
			clearBits(index_p + _template.MARK1_OFFSET, _template.MARK1_EXTRACTOR[value_p]);
		}
		
		// Mark 2
		if((mark_p & 2) != 0) {
			markBits(index_p + _template.MARK2_OFFSET, _template.MARK2_EXTRACTOR[value_p]);
		} else {
			clearBits(index_p + _template.MARK2_OFFSET, _template.MARK2_EXTRACTOR[value_p]);
		}
	}
	
	/** Mark this has the original position .*/
	public void registerOriginalPosition() {
		for(int index=0; index<_template.maxIndex; index++) {
			// If free
			if(isFree(index)) {
				clearBits(index, _template.ORIGINAL_POSITION);				
			} else {
				markBits(index, _template.ORIGINAL_POSITION);
			}
		}
	}
	
	public boolean isOriginalPosition(int index_p) {
		return checkBit(index_p, _template.ORIGINAL_POSITION);
	}

	public Template getTemplate() {
		return _template;
	}
	

	/** Convenience method to check a given bit. */
	private boolean checkBit(int index_p, int bit_p) {
		return (_states[index_p] & bit_p) == bit_p;
	}

	/** clear bits .*/
	private void clearBits(int index_p, int bits_p) {
		_states[index_p] = _states[index_p] & ~bits_p;
	}

	/** Mark a position. */
	private void markBits(int index, int bits_p) {
		_states[index] = _states[index] | bits_p;
	}

	int[] getRaw() {
		return _states;
	}

	
	/**
	 * Convenience method to test a value.
	 * @param index_p
	 * @param value_p
	 * @return true if free, allowed, not striked
	 */
	public boolean isAvailable(int index_p, int value_p) {
		return isFree(index_p) && isAllowed(index_p, value_p) &&
				((getMark(index_p, value_p) & Template.STRIKE) == 0);
	}

	/**
	 * Clear all marks
	 */
	public void clearMarks() {
		for(int index=0; index<_template.maxIndex; index++) {
			clearBits(index + _template.MARK1_OFFSET, _template.MARK_MASK);
			clearBits(index + _template.MARK2_OFFSET, _template.MARK_MASK);
		}
		
	}
	
	/**
	 * This is a custom Serialization (for the fun of it).
	 * @param out_p output stream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream out_p) throws IOException {
		// We'll write template, then states
		// Template
		out_p.writeShort(_template.rows);
		out_p.writeShort(_template.columns);
		
		// And states
		for (int i = 0; i < _states.length; i++) {
			int aValue = _states[i];
			out_p.writeInt(aValue);
		}
	}
	
	/**
	 * This is a custom serialisation.
	 * @param in_p stream to read from.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream in_p) throws IOException, ClassNotFoundException {
		// Read template
		int rows = in_p.readShort();
		int columns = in_p.readShort();
		_template = TemplateFactory.getTemplate(rows, columns);
		
		// Allocate
		_states = _template.allocate();
		
		// read state
		for (int i = 0; i < _states.length; i++) {
			_states[i] = in_p.readInt();
		}
	}
	
	// For serialization purpose
	@SuppressWarnings("unused")
	private State() {
		// Empty block
	}

}
