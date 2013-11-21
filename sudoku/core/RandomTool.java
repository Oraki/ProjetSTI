package tchok.sudoku.core;

import java.util.ArrayList;

/**
 * @author Tchok
 */
public class RandomTool {

	/**
	 * Just select, remove and return a value from a list 
	 * @param list_p of Integer !
	 * @return
	 */
	int random(ArrayList<Integer> list_p) {
		// Get it
		Integer value = list_p.remove(random(list_p.size()));
		return value.intValue();
	}

	/**
	 * Just get a random number...
	 * @param max_p
	 * @return
	 */
	int random(int max_p) {
		return (int)(Math.random() * max_p);
	}

}
