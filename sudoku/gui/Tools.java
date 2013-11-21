package tchok.sudoku.gui;

import org.eclipse.swt.graphics.Image;

import tchok.sudoku.SudokuPlugin;
import tchok.sudoku.core.Skill;
import tchok.sudoku.core.Template;

public class Tools {
	/**
	 * Get the image for a given Template.
	 * @param template_p
	 * @return
	 */
	static  public Image getImage(Template template_p) {
		String name =  template_p.name + ".png"; 							//$NON-NLS-1$
		Image img = SudokuPlugin.getDefault().getImage("icons/" + name);    //$NON-NLS-1$
		return img;
	}
	
	/**
	 * Get the image for a given Skill.
	 * @param template_p
	 * @return
	 */
	static  public Image getImage(Skill skill_p) {
		// Oups, sorry about that...
		String name = skill_p.name.toLowerCase() + ".png"; //$NON-NLS-1$
		
		Image img = SudokuPlugin.getDefault().getImage("icons/" + name); //$NON-NLS-1$
		return img;
	}

}
