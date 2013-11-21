package tchok.sudoku.core;

/**
 * Given an index, gives back the symetrical index.
 * @author Tchok
 */
public class Symetrizer {
	Template _template;
	
	public Symetrizer(Template template_p) {
		_template = template_p;
	}
	
	/**
	 * Computes the symetrical index.
	 * @param index_p source index
	 * @return target index.
	 */
	public int getIndex(int index_p) {
		//return index_p;
		return _template.maxIndex - (index_p + 1);
	}
}
