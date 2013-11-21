package tchok.sudoku.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import tchok.sudoku.IEventTypes;
import tchok.tools.events.TEvent;
import tchok.tools.events.TEventManager;

/**
 * Store States.
 * @author Tchok
 */
public class StateStore {
	// 6 short(s)
	private static final int HEADER_SIZE = 12;

	/** The max number of items in this Store. */
	int _size;
	
	/** The current number of items in this store. */
	int _currentCount;
	
	/** The last 'predef' State index (-1 for none).
	 *  Sudoku is delivered with precomputed States, but tries
	 *  to replace them with local State, to avoid allways playing the same games
	 *  when installed on a new computer.
	 *  After a certain amount of time, this should get down to 0.
	 */
	int _lastPredefIndex;
	
	/** Size for a state. */
	int _elementSize;
	
	/** Template description. */
	int _templateRows;
	int _templateCols;
	
	/** Where to store the whole. */
	String _targetFile;
	
	/**
	 * Create a new Store.
	 * THis is used only to <b>create</b> a new store from scratch.
	 * @param target_p storage location
	 * @param size_p size of store
	 * @throws IOException 
	 */
	StateStore(String target_p, int size_p, Template template_p) throws IOException {
		// Init a few
		_targetFile = target_p;
		_size = size_p;
		_currentCount = 0;
		_lastPredefIndex = -1;
		_elementSize = (template_p.allocate().length + 1) * 4;
		_templateRows = template_p.rows;
		_templateCols = template_p.columns;
		
		// 
		// Save initial state
		//
		// Get a File
		File file = new File(target_p);
		
		// Create it ?
		file.createNewFile();
		
		// Store current header
		RandomAccessFile rFile = new RandomAccessFile(file, "rw"); //$NON-NLS-1$
		writeHeader(rFile);
		rFile.close();
	}
	
	/**
	 * Create an <i>existing</i> store (reading it).
	 * @param target_p
	 * @throws IOException 
	 */
	StateStore(String target_p) throws IOException {
		// Store target
		_targetFile = target_p;
		
		// Get file
		RandomAccessFile rFile = getRandomFile();
		
		// Read header
		readHeaderInfo(rFile);
		
		// And close
		rFile.close();
	}
	
	/**
	 * Add a State to the Store.
	 * Using 'true' for predef should be limited to the initial
	 * games pre computing.
	 * @param state_p state to add.
	 * @param preDef_p true for a predef State.
	 * @throws IOException 
	 */
	synchronized void pushState(State state_p, boolean preDef_p) throws IOException {
		// Offset
		long offset = 0;
		
		// According to case
		if(preDef_p) {
			// Compute index
			offset = offsetFor(_lastPredefIndex);
			
			// Update count
			_lastPredefIndex--;
		} else {
			// Offset
			offset = offsetFor(_currentCount);
			
			// Update count
			_currentCount++;
		}
		
		// Get file
		RandomAccessFile rFile = getRandomFile();
		
		// Write state
		rFile.seek(offset);
		int raw[] = state_p.getRaw();
		for (int i = 0; i < raw.length; i++) {
			rFile.writeInt(raw[i]);
		}
		
		// Update header
		writeHeader(rFile);
		
		// OK
		rFile.close();
		
		// Call listeners
		fireEvent();

	}
	
	/**
	 * Read a State from the store.
	 * @return the last State or null.
	 * @throws IOException
	 */
	synchronized State popState() throws IOException {
		// Something to return ?
		if(_currentCount == 0) {
			return null;
		}
		
		// Get position
		_currentCount--;
		long offset = offsetFor(_currentCount);
		
		// Update predef count
		if(_lastPredefIndex >= _currentCount) {
			_lastPredefIndex = (_currentCount - 1);
		}
		
		// Get template
		Template template = getTemplate();
		
		// Allocate
		State output = new State(template);
		int [] raw = output.getRaw();
		
		// read values
		RandomAccessFile rFile = getRandomFile();
		rFile.seek(offset);
		for (int i = 0; i < raw.length; i++) {
			raw[i] = rFile.readInt();
		}
		
		// Update header
		writeHeader(rFile);
		
		// Done with file
		rFile.close();
		
		// Call listeners
		fireEvent();
		
		// Due to a previous bug in the reducer...
		output.registerOriginalPosition();
		
		// OK
		return output;
	}
	
	/**
	 * Get the state at given position without changing the store.
	 * This is for test purpose only.
	 * @param index_p index of state in the store
	 * @return the state.
	 * @throws IOException because this is reading a file!
	 */
	State getStateAtIndex(int index_p) throws IOException {
		// position
		long offset = offsetFor(index_p);
		
		// Get template
		Template template = getTemplate();
		
		// Allocate
		State output = new State(template);
		int [] raw = output.getRaw();
		
		// read values
		RandomAccessFile rFile = getRandomFile();
		rFile.seek(offset);
		for (int i = 0; i < raw.length; i++) {
			raw[i] = rFile.readInt();
		}
		
		// Due to a previous bug in the reducer...
		output.registerOriginalPosition();
		
		// OK
		return output;
	}
	
	/**
	 * @return the number of State to add to fill this store.
	 */
	public synchronized int getMissingCount() {
		return _size - _currentCount;
	}
	
	/**
	 * @return the number of predef states.
	 */
	public synchronized int getPredefCount() {
		return Math.max(0, _lastPredefIndex+1);
	}
	
	/**
	 * @return the max number of items.
	 */
	public int getSize() {
		return _size;
	}
	
	/**
	 * @return the Template for this store.
	 */
	private Template getTemplate() {
		return TemplateFactory.getTemplate(_templateRows, _templateCols);
	}
	
	/**
	 * Convert a state index to an offset in bytes.
	 * @param stateIndex_p
	 * @return
	 */
	private long offsetFor(int stateIndex_p) {
		return _elementSize * stateIndex_p + HEADER_SIZE;
	}
	
	/**
	 * Open the file for rw.
	 * @return the random file.
	 * @throws FileNotFoundException
	 */
	private RandomAccessFile getRandomFile() throws FileNotFoundException {
		// Get a File
		File file = new File(_targetFile);
		
		// Get random file
		RandomAccessFile rFile = new RandomAccessFile(file, "rw"); //$NON-NLS-1$
		
		// OK
		return rFile;
	}
	
	/**
	 * Update the headers info. 
	 * @param rFile_p file to update
	 * @throws IOException
	 */
	private void writeHeader(RandomAccessFile rFile_p) throws IOException {
		rFile_p.seek(0);
		rFile_p.writeShort(_size);
		rFile_p.writeShort(_currentCount);
		rFile_p.writeShort(_lastPredefIndex);
		rFile_p.writeShort(_elementSize);
		rFile_p.writeShort(_templateRows);
		rFile_p.writeShort(_templateCols);
	}
	
	/**
	 * Initialize by reading the current state.
	 * @param rFile_p
	 * @throws IOException
	 */
	private void readHeaderInfo(RandomAccessFile rFile_p) throws IOException {
		rFile_p.seek(0);
		_size = rFile_p.readShort();
		_currentCount = rFile_p.readShort();
		_lastPredefIndex = rFile_p.readShort();
		_elementSize = rFile_p.readShort();
		_templateRows = rFile_p.readShort();
		_templateCols = rFile_p.readShort();
	}
	
	/**
	 * Update the number of predefined states.
	 * @throws IOException 
	 */
	void afterInstall() throws IOException {
		// Get file
		RandomAccessFile rFile = getRandomFile();
		
		// Update header
		readHeaderInfo(rFile);
		_lastPredefIndex = _currentCount - 1;
		writeHeader(rFile);
		
		// And close
		rFile.close();		
	}
	
	/**
	 * Fire an event to all listeners.
	 */
	void fireEvent() {
		TEventManager.getInstance().fireEvent(new TEvent(IEventTypes.STATE_STORE_EVENT, this));
	}
}