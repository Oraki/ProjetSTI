package tchok.sudoku.gui;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

import tchok.swt.graphics.MultiScaleIcon;

public class IconFigureProvider implements IFigureProvider {

	// Current GC
	private GC _gc;
	
	// Current size
	private int _size;
	
	MultiScaleIcon[] _icons = MultiScaleIconFactory.getIcons(Display.getCurrent());
	
	public boolean acceptChar(char char_p) {
		// TODO Auto-generated method stub
		return false;
	}

	public void draw(int value, int x, int y) {
		_icons[value].draw(_gc, new Point(x, y), new Point(_size, _size));

	}

	public void setArgs(GC gc_p, String case_p, int size_p) {
		_gc = gc_p;
		_size = (size_p * 4) / 3; // This looks better!
	}

	public int valueFromChar(char str_p) {
		// TODO Auto-generated method stub
		return -1;
	}

}
