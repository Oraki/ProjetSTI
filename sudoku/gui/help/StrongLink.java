package tchok.sudoku.gui.help;

import java.util.ArrayList;
import java.util.List;

import tchok.sudoku.prefs.IPrefConstants;

/**
 * Description of a strong link.
 * This is a simple data holder.
 * @author Tchok
 */
public class StrongLink {
	/**
	 * A link element.
	 * Defines cell and value involved in a link.
	 * @author Tchok
	 */
	public static class Element {
		public int cellIndex;
		public int cellValue;
		public Element(int cellIndex_p, int cellValue_p) {
			cellIndex = cellIndex_p;
			cellValue = cellValue_p;
		}
	}
	
	/**
	 * This defines stronglink types.
	 */
	public static enum Type {
		BIVALUE_CELL(IPrefConstants.ST_SHOW_BIVALUE_CELLS),
		BILOCAL_UNIT(IPrefConstants.ST_SHOW_BILOCAL_UNITS);
		
		private String _key;
		Type(String key) {
			_key = key;
		}
		
		/**
		 * @return the key for this type, see IPrefConstants
		 */
		public String getKey() {
			return _key;
		}
	}
	
	/** The elements .*/
	private List<Element> _elements;
	
	/** The link's type.*/
	private Type _type;
	
	/**
	 * Default constructor.
	 */
	public StrongLink(Type type) {
		_type = type;
		_elements = new ArrayList<Element>(2);
	}
	
	/**
	 * @return the link's type.
	 */
	public Type getType() {
		return _type;
	}
	
	/**
	 * @return the internal elements list.
	 */
	public List<Element> getElements() {
		return _elements;
	}
}
