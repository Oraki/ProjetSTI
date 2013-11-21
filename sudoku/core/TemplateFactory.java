package tchok.sudoku.core;

/**
 * handles the available templates
 * @author Tchok
 */
public class TemplateFactory {
	static public final Template TEMPLATES[] = {
		Template.T22,
		Template.T23,
//		Template.T32,
		Template.T33,
		WideTemplate.T34
	};

	/**
	 * Get one by size.
	 * @param row_p number of rows
	 * @param column_p number of columns
	 * @return the Template or null
	 */
	public static Template getTemplate(int row_p, int column_p) {
		// Loop on them
		for (int i = 0; i < TEMPLATES.length; i++) {
			Template template = TEMPLATES[i];
			if((template.rows == row_p) && (template.columns == column_p)) {
				// This is it
				return template;
			}
		}
		
		// Bad luck !
		return null;
	}
}
