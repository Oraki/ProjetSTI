package tchok.sudoku.core;

/**
 * Dummy case, no symetrie at all...
 * @author Tchok
 */
public class NoSymetrizer extends Symetrizer {

	public NoSymetrizer(Template template_p) {
		super(template_p);
	}

	@Override
	public int getIndex(int index_p) {
		return index_p;
	}
}
