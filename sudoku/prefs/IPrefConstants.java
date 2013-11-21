package tchok.sudoku.prefs;

@SuppressWarnings("nls")
public interface IPrefConstants {
	//
	// Prefixes
	//
	
	// Prefix for UI properties
	public static final String UI_PREFIX = "ui.";
	
	// Print prefix
	public static final String PRINT_PREFIX = "print.";
	
	// Auto play
	public static final String AUTOPLAY_PREFIX = "autoPlay."; 
	
	//
	// Main board
	//
	
	// In the grid (event and odd)
	public static final String GRID_BACKGROUND_1 = "ui.gridBackground.0";
	public static final String GRID_BACKGROUND_0 = "ui.gridBackground.1";
	
	// Main grid
	public static final String GRID_FOREGROUND = "ui.gridForeground";
	
	// small grid
	public static final String SUBGRID_FOREGROUND = "ui.subGridForeground";
	
	// selection
	public static final String SELECTION_BACKGROUND = "ui.selectionBackground";
	
	// initial values
	public static final String START_VALUE_FOREGROUND = "ui.startValueForeground";
	
	// users value
	public static final String VALUE_FOREGROUND = "ui.valueForeground";
	
	// available moves
	public static final String MARK_FOREGROUND = "ui.markForeground";
	
	// highlighted numbers
	public static final String HIGHLIGHT_BACKGROUND = "ui.highlightBackground"; 
	
	//  values (and initial values) font
	public static final String VALUE_FONT = "ui.valueFont";
	
	// available move's font
	public static final String MARK_FONT = "ui.markFont";
	
	//
	// Printing
	//
	
	// In the grid
	public static final String PRINT_GRID_BACKGROUND_0 = "print.ui.gridBackground.0";
	public static final String PRINT_GRID_BACKGROUND_1 = "print.ui.gridBackground.1";
	
	// Main grid
	public static final String PRINT_GRID_FOREGROUND = "print.ui.gridForeground";
	
	// small grid
	public static final String PRINT_SUBGRID_FOREGROUND = "print.ui.subGridForeground";
	
	// users value
	public static final String PRINT_VALUE_FOREGROUND = "print.ui.valueForeground";
	
	//  values (and initial values) font
	public static final String PRINT_VALUE_FONT = "print.ui.valueFont";
	
	// do compute local games
	public static final String COMPUTE_LOCALS = "store.computeLocals";

	//
	// Various
	// 
	
	// Expand value selector
	public static final String EXPAND_VALUE_SELECTOR = "layouy.expandValueSelector"; 
	
	// Allow wrong move
	public static final String ALLOW_WRONG_MOVE = "game.allowWrongMove";
	
	// Allow invalid move
	public static final String ALLOW_INVALID_MOVE = "game.allowInvalidMove";
	
	// Show sub values
	public static final String SHOW_SUBVALUES = "ui.showSubValues";
	
	// Hide not allowed
	public static final String HIDE_NOT_ALLOWED = "ui.hideNotAllowed";
	
	//
	// Auto play
	//
	public static final String AUTOPLAY_DELAY="autoPlay.delay";
	public static final String AUTOPLAY_SingleValue="autoPlay.SingleValue";
	public static final String AUTOPLAY_SinglePosition="autoPlay.SinglePosition";
	public static final String AUTOPLAY_MissingValuesInLine="autoPlay.MissingValuesInLine";
	public static final String AUTOPLAY_Groups="autoPlay.Groups";
	public static final String AUTOPLAY_HiddenGroups="autoPlay.HiddenGroups";
	public static final String AUTOPLAY_Cheater="autoPlay.Cheater";
	
	// Strong links
	public static final String ST_SHOW_BIVALUE_CELLS="ui.strongLinks.showBivalueCells";
	public static final String ST_SHOW_BILOCAL_UNITS="ui.strongLinks.showBilocalUnits";
	public static final String ST_LINK_WITH_SELECTION="ui.strongLinks.linkWithSelection";
	public static final String ST_LINK_COLOR = "ui.strongLinks.color";
	
	// Mouse control (should be a single pref, but this is easier to implement)
	public static final String CTRL_USE_MENU_MOUSE_HANDLER = "ctrl.useMenuMouseHandler";
	public static final String CTRL_USE_DIRECT_MOUSE_HANDLER = "ctrl.useDirectMouseHandler";
	
	// Keyboard controls
	public static final String CTRL_USE_KEYBOARD_DISPLAY = "ui.useKeyboardDisplay";
	
	// Default font
	public static final String DEFAULT_FONT = "default.font";
	
	// Charset
	public static final String CHARSET_NUMERIC = "ui.charset.numeric";
	public static final String CHARSET_LETTERS = "ui.charset.letters";
	public static final String CHARSET_SYMBOLS = "ui.charset.symbols";
	public static final String CHARSET_ICONS = "ui.charset.icons";
}