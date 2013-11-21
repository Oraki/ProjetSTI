package tchok.sudoku.gui;

import java.text.MessageFormat;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import tchok.sudoku.SudokuPlugin;
import tchok.swt.graphics.LabelContributionItem;

/**
 * Periodically display information abiout the current game.
 * @author Tchok
 *
 */
public class InfoManager implements Runnable {
	/** The bad boy icon. */
	private static final String CHEATER_LABEL = "cheaterLabel"; //$NON-NLS-1$

	/** The wrong moves label.*/
	private static final String MISTAKE_LABEL = "mistakeLabel";//$NON-NLS-1$

	/** The invalid moves count label. */
	private static final String INVALID_LABEL = "invalidLabel";//$NON-NLS-1$

	/** The auto play count label. */
	private static final String AUTO_PLAY_LABEL = "autoPlayLabel";//$NON-NLS-1$

	/** The time id . */
	private static final String TIME_LABEL = "timeLabel";//$NON-NLS-1$

	/** The sad icon. */
	private static final String ICONS_SAD = "icons/Sad.gif";//$NON-NLS-1$

	/** The happy icon. */
	private static final String ICONS_HAPPY = "icons/Happy.gif";//$NON-NLS-1$

	private static final String FINAL_DUMMY = "finalDummyLabel";  //$NON-NLS-1$
	
	/** The view. */
	MainView _view;

	/** The StatutsLine. */
	IStatusLineManager _statutsLine;
	
	/** The time label. */
	LabelContributionItem _timeLabel;
	
	/** The autoplay label. */
	LabelContributionItem _autoPlayLabel;
	
	/** The invalid move label.*/
	LabelContributionItem _invalidLabel;
	
	/** The mistakes label.*/
	LabelContributionItem _mistakeLabel;
	
	/** The cheater label. */
	LabelContributionItem _cheater;
	
	/** Just for alignment purpose, there must be a better way...*/
	LabelContributionItem _finalDummy;
	
	/** The font. */
	Font _font;

	/**
	 * Constructor.
	 * @param view_p client view.
	 */
	public InfoManager(MainView view_p) {
		// Store datas
		_view = view_p;
		
		//A nice font
		_font = new Font(view_p.getBoard().getDisplay(), "Arial", 14, SWT.NORMAL); //$NON-NLS-1$
		
		// Build control(s)
		_statutsLine = _view.getViewSite().getActionBars().getStatusLineManager();
		_timeLabel = addLabel(TIME_LABEL);
		_autoPlayLabel = addLabel(AUTO_PLAY_LABEL);
		_invalidLabel = addLabel(INVALID_LABEL);
		_mistakeLabel = addLabel(MISTAKE_LABEL);
		_cheater = addLabel(CHEATER_LABEL);
		_finalDummy = addLabel(FINAL_DUMMY);
		_statutsLine.update(true);
		
		// And refresh
		_statutsLine.markDirty();
		
		// And get going
		_view.getBoard().getDisplay().timerExec(333, this);
	}
	
	/**
	 * Periodical refresh.
	 */
	public void run() {
		// Test view
		if(_view.getBoard().isDisposed()) {
			// Time to give up
			_font.dispose();
			_statutsLine.remove(TIME_LABEL);
			_statutsLine.remove(AUTO_PLAY_LABEL);
			_statutsLine.remove(INVALID_LABEL);
			_statutsLine.remove(MISTAKE_LABEL);
			_statutsLine.remove(CHEATER_LABEL);
			_statutsLine.remove(FINAL_DUMMY);
			return;
		}
		
		// Schedule next run
		_view.getBoard().getDisplay().timerExec(333, this);
		
		// Display...
		
		// Elapsed time
		long millis = _view.getBoard().getState().getElapsed();
		Object args[] = {
				new Long(millis/60000),
				new Long((millis/1000) % 60)
		};
		String elapsed = MessageFormat.format(Messages.getString("InfoManager.elapsedTimeFormat"), args);  //$NON-NLS-1$
		_timeLabel.setText(elapsed);
		_timeLabel.setFont(_font);

		
		// Auto play count
		UIState state = _view.getBoard().getState();
		_autoPlayLabel.setText(Integer.toString(state.getAutoPlay()));
		
		// Invalid moves
		_invalidLabel.setText(Integer.toString(state.getIllegalMoves()));
		
		// Mistakes moves
		_mistakeLabel.setText(Integer.toString(state.getWrongMoves()));
		
		// Cheater !
		boolean cheater = 	(_view.getBoard().getState().getAutoPlay() != 0) ||
							(_view.getBoard().getState().getWrongMoves() != 0) ||
							(_view.getBoard().getState().getIllegalMoves() != 0) ||
							(_view.getBoard().getState().getSolves() != 0);
		String key = cheater ? ICONS_SAD : ICONS_HAPPY;
		_cheater.setImage(SudokuPlugin.getDefault().getImage(key));
		
		// Final dummy
		_finalDummy.setText(" "); //$NON-NLS-1$
	}
	
	/**
	 * Build an item.
	 * @param id item's id
	 * @return the new item
	 */
	LabelContributionItem addLabel(String id) {
		LabelContributionItem item = new LabelContributionItem(id, Messages.getString("InfoManager." + id + ".tooltip")); //$NON-NLS-1$ //$NON-NLS-2$
		_statutsLine.add(item);
		_statutsLine.markDirty();
		return item;
	}
	
}
