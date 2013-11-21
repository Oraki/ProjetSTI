package tchok.sudoku.gui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import tchok.sudoku.print.PrintView;

public class BoardPerspective implements IPerspectiveFactory {
	/** This perspective's id. */
	static public final String PERSPECTIVE_ID="tchok.sudoku.perspective.board"; //$NON-NLS-1$
	
	/** Initial layout. */
	public void createInitialLayout(IPageLayout layout_p) {
		// Really simple...
		
		// Create a folder
		IFolderLayout folder = layout_p.createFolder(PERSPECTIVE_ID, IPageLayout.BOTTOM, 0.5f, layout_p.getEditorArea());
		
		// Create views
		folder.addView(MainView.VIEW_ID);
		folder.addView(PrintView.VIEW_ID);
		
		// No closing
		layout_p.getViewLayout(MainView.VIEW_ID).setCloseable(false);
		layout_p.getViewLayout(PrintView.VIEW_ID).setCloseable(false);
		
		// And there ain't any editors
		layout_p.setEditorAreaVisible(false);
		layout_p.setFixed(true);
	}

}
