package tchok.sudoku.gui;

import org.eclipse.swt.graphics.Transform;

/**
 * Allows the board drawer to transmit geometrical datas
 * to the ValueSelector. 
 * (a bit imbricated...)
 * @author Tchok
 */
public interface ITransformProvider {
	/**
	 * @return the direct transformer.
	 */
	public Transform getTransform();
	
	/**
	 * @return the inverted transformer.
	 */
	public Transform getInvertedTransform();
}
