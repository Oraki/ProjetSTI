package sudoku;

import javax.swing.JPanel;
import edu.cmu.pact.BehaviorRecorder.Controller.CTAT_Launcher;
import edu.cmu.pact.BehaviorRecorder.Controller.CTAT_Options;
import pact.CommWidgets.JCommTextField;
import pact.CommWidgets.HorizontalLine;
import pact.CommWidgets.JCommLabel;
import java.awt.Font;
import pact.CommWidgets.JCommButton;

public class sudoku extends JPanel {
	
	private CTAT_Options t_Options;
	private JCommTextField case121;
	private JCommTextField case111;
	private JCommTextField case131;
	private JCommTextField case142;
	private JCommTextField case152;
	private JCommTextField case162;
	private JCommTextField case173;
	private JCommTextField case183;
	private JCommTextField case193;
	private JCommTextField case211;
	private JCommTextField case221;
	private JCommTextField case231;
	private JCommTextField case242;
	private JCommTextField case252;
	private JCommTextField case262;
	private JCommTextField case273;
	private JCommTextField case283;
	private JCommTextField case293;
	private JCommTextField case311;
	private JCommTextField case321;
	private JCommTextField case331;
	private JCommTextField case342;
	private JCommTextField case352;
	private JCommTextField case362;
	private JCommTextField case373;
	private JCommTextField case383;
	private JCommTextField case393;
	private JCommTextField case414;
	private JCommTextField case424;
	private JCommTextField case434;
	private JCommTextField case445;
	private JCommTextField case455;
	private JCommTextField case465;
	private JCommTextField case476;
	private JCommTextField case486;
	private JCommTextField case496;
	private JCommTextField case514;
	private JCommTextField case524;
	private JCommTextField case534;
	private JCommTextField case545;
	private JCommTextField case555;
	private JCommTextField case565;
	private JCommTextField case576;
	private JCommTextField case586;
	private JCommTextField case596;
	private JCommTextField case614;
	private JCommTextField case717;
	private JCommTextField case624;
	private JCommTextField case634;
	private JCommTextField case645;
	private JCommTextField case655;
	private JCommTextField case665;
	private JCommTextField case676;
	private JCommTextField case686;
	private JCommTextField case696;
	private JCommTextField case817;
	private JCommTextField case727;
	private JCommTextField case737;
	private JCommTextField case748;
	private JCommTextField case758;
	private JCommTextField case768;
	private JCommTextField case779;
	private JCommTextField case789;
	private JCommTextField case799;
	private JCommTextField case917;
	private JCommTextField case827;
	private JCommTextField case837;
	private JCommTextField case848;
	private JCommTextField case858;
	private JCommTextField case868;
	private JCommTextField case879;
	private JCommTextField case889;
	private JCommTextField case899;
	private JCommTextField case927;
	private JCommTextField case937;
	private JCommTextField case948;
	private JCommTextField case958;
	private JCommTextField case968;
	private JCommTextField case979;
	private JCommTextField case989;
	private JCommTextField case999;
	private JCommButton commButton;

public sudoku() {
	initComponents();
}
	private void initComponents() {
		setLayout(null);
		
		t_Options = new CTAT_Options();
		t_Options.setBounds(42, 528, 1, 1);
		add(t_Options);
		
		case111 = new JCommTextField();
		case111.setBounds(80, 61, 37, 37);
		add(case111);
		
		case121 = new JCommTextField();
		case121.setBounds(114, 61, 37, 37);
		add(case121);
		
		case131 = new JCommTextField();
		case131.setBounds(148, 61, 37, 37);
		add(case131);
		
		case142 = new JCommTextField();
		case142.setBounds(185, 61, 37, 37);
		add(case142);
		
		case152 = new JCommTextField();
		case152.setBounds(219, 61, 37, 37);
		add(case152);
		
		case162 = new JCommTextField();
		case162.setBounds(253, 61, 37, 37);
		add(case162);
		
		case173 = new JCommTextField();
		case173.setBounds(290, 61, 37, 37);
		add(case173);
		
		case183 = new JCommTextField();
		case183.setBounds(324, 61, 37, 37);
		add(case183);
		
		case193 = new JCommTextField();
		case193.setBounds(358, 61, 37, 37);
		add(case193);
		
		case211 = new JCommTextField();
		case211.setBounds(80, 95, 37, 37);
		add(case211);
		
		case221 = new JCommTextField();
		case221.setName("case221");
		case221.setBounds(114, 95, 37, 37);
		add(case221);
		
		case231 = new JCommTextField();
		case231.setBounds(148, 95, 37, 37);
		add(case231);
		
		case242 = new JCommTextField();
		case242.setBounds(185, 95, 37, 37);
		add(case242);
		
		case252 = new JCommTextField();
		case252.setBounds(219, 95, 37, 37);
		add(case252);
		
		case262 = new JCommTextField();
		case262.setBounds(253, 95, 37, 37);
		add(case262);
		
		case273 = new JCommTextField();
		case273.setBounds(290, 95, 37, 37);
		add(case273);
		
		case283 = new JCommTextField();
		case283.setBounds(324, 95, 37, 37);
		add(case283);
		
		case293 = new JCommTextField();
		case293.setBounds(358, 95, 37, 37);
		add(case293);
		
		case311 = new JCommTextField();
		case311.setBounds(80, 129, 37, 37);
		add(case311);
		
		case321 = new JCommTextField();
		case321.setBounds(114, 129, 37, 37);
		add(case321);
		
		case331 = new JCommTextField();
		case331.setBounds(148, 129, 37, 37);
		add(case331);
		
		case342 = new JCommTextField();
		case342.setBounds(185, 129, 37, 37);
		add(case342);
		
		case352 = new JCommTextField();
		case352.setBounds(219, 129, 37, 37);
		add(case352);
		
		case362 = new JCommTextField();
		case362.setBounds(253, 129, 37, 37);
		add(case362);
		
		case373 = new JCommTextField();
		case373.setBounds(290, 129, 37, 37);
		add(case373);
		
		case383 = new JCommTextField();
		case383.setBounds(324, 129, 37, 37);
		add(case383);
		
		case393 = new JCommTextField();
		case393.setBounds(358, 129, 37, 37);
		add(case393);
		
		case414 = new JCommTextField();
		case414.setBounds(80, 166, 37, 37);
		add(case414);
		
		case424 = new JCommTextField();
		case424.setBounds(114, 166, 37, 37);
		add(case424);
		
		case434 = new JCommTextField();
		case434.setBounds(148, 166, 37, 37);
		add(case434);
		
		case445 = new JCommTextField();
		case445.setBounds(185, 166, 37, 37);
		add(case445);
		
		case455 = new JCommTextField();
		case455.setBounds(219, 166, 37, 37);
		add(case455);
		
		case465 = new JCommTextField();
		case465.setBounds(253, 166, 37, 37);
		add(case465);
		
		case476 = new JCommTextField();
		case476.setBounds(290, 166, 37, 37);
		add(case476);
		
		case486 = new JCommTextField();
		case486.setBounds(324, 166, 37, 37);
		add(case486);
		
		case496 = new JCommTextField();
		case496.setBounds(358, 166, 37, 37);
		add(case496);
		
		case514 = new JCommTextField();
		case514.setBounds(80, 200, 37, 37);
		add(case514);
		
		case524 = new JCommTextField();
		case524.setBounds(114, 200, 37, 37);
		add(case524);
		
		case534 = new JCommTextField();
		case534.setBounds(148, 200, 37, 37);
		add(case534);
		
		case545 = new JCommTextField();
		case545.setBounds(185, 200, 37, 37);
		add(case545);
		
		case555 = new JCommTextField();
		case555.setBounds(219, 200, 37, 37);
		add(case555);
		
		case565 = new JCommTextField();
		case565.setBounds(253, 200, 37, 37);
		add(case565);
		
		case576 = new JCommTextField();
		case576.setBounds(290, 200, 37, 37);
		add(case576);
		
		case586 = new JCommTextField();
		case586.setBounds(324, 200, 37, 37);
		add(case586);
		
		case596 = new JCommTextField();
		case596.setBounds(358, 200, 37, 37);
		add(case596);
		
		case614 = new JCommTextField();
		case614.setBounds(80, 234, 37, 37);
		add(case614);
		
		case717 = new JCommTextField();
		case717.setBounds(80, 271, 37, 37);
		add(case717);
		
		case624 = new JCommTextField();
		case624.setBounds(114, 234, 37, 37);
		add(case624);
		
		case634 = new JCommTextField();
		case634.setBounds(148, 234, 37, 37);
		add(case634);
		
		case645 = new JCommTextField();
		case645.setBounds(185, 234, 37, 37);
		add(case645);
		
		case655 = new JCommTextField();
		case655.setBounds(219, 234, 37, 37);
		add(case655);
		
		case665 = new JCommTextField();
		case665.setBounds(253, 234, 37, 37);
		add(case665);
		
		case676 = new JCommTextField();
		case676.setBounds(290, 234, 37, 37);
		add(case676);
		
		case686 = new JCommTextField();
		case686.setBounds(324, 234, 37, 37);
		add(case686);
		
		case696 = new JCommTextField();
		case696.setBounds(358, 234, 37, 37);
		add(case696);
		
		case817 = new JCommTextField();
		case817.setBounds(80, 305, 37, 37);
		add(case817);
		
		case727 = new JCommTextField();
		case727.setBounds(114, 271, 37, 37);
		add(case727);
		
		case737 = new JCommTextField();
		case737.setBounds(148, 271, 37, 37);
		add(case737);
		
		case748 = new JCommTextField();
		case748.setBounds(185, 271, 37, 37);
		add(case748);
		
		case758 = new JCommTextField();
		case758.setBounds(219, 271, 37, 37);
		add(case758);
		
		case768 = new JCommTextField();
		case768.setBounds(253, 271, 37, 37);
		add(case768);
		
		case779 = new JCommTextField();
		case779.setBounds(290, 271, 37, 37);
		add(case779);
		
		case789 = new JCommTextField();
		case789.setBounds(324, 271, 37, 37);
		add(case789);
		
		case799 = new JCommTextField();
		case799.setBounds(358, 271, 37, 37);
		add(case799);
		
		case917 = new JCommTextField();
		case917.setBounds(80, 339, 37, 37);
		add(case917);
		
		case827 = new JCommTextField();
		case827.setBounds(114, 305, 37, 37);
		add(case827);
		
		case837 = new JCommTextField();
		case837.setBounds(148, 305, 37, 37);
		add(case837);
		
		case848 = new JCommTextField();
		case848.setBounds(185, 305, 37, 37);
		add(case848);
		
		case858 = new JCommTextField();
		case858.setBounds(219, 305, 37, 37);
		add(case858);
		
		case868 = new JCommTextField();
		case868.setBounds(253, 305, 37, 37);
		add(case868);
		
		case879 = new JCommTextField();
		case879.setBounds(290, 305, 37, 37);
		add(case879);
		
		case889 = new JCommTextField();
		case889.setBounds(324, 305, 37, 37);
		add(case889);
		
		case899 = new JCommTextField();
		case899.setBounds(358, 305, 37, 37);
		add(case899);
		
		case927 = new JCommTextField();
		case927.setBounds(114, 339, 37, 37);
		add(case927);
		
		case937 = new JCommTextField();
		case937.setBounds(148, 339, 37, 37);
		add(case937);
		
		case948 = new JCommTextField();
		case948.setBounds(185, 339, 37, 37);
		add(case948);
		
		case958 = new JCommTextField();
		case958.setBounds(219, 339, 37, 37);
		add(case958);
		
		case968 = new JCommTextField();
		case968.setBounds(253, 339, 37, 37);
		add(case968);
		
		case979 = new JCommTextField();
		case979.setBounds(290, 339, 37, 37);
		add(case979);
		
		case989 = new JCommTextField();
		case989.setBounds(324, 339, 37, 37);
		add(case989);
		
		case999 = new JCommTextField();
		case999.setBounds(358, 339, 37, 37);
		add(case999);
		
		commButton = new JCommButton();
		commButton.setText("Termine");
		commButton.setBounds(431, 61, 130, 29);
		add(commButton);
	}
	public static void main(String args[]){
		new CTAT_Launcher(args).launch(new sudoku());
	}

}
