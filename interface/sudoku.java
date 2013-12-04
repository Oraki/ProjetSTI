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
	private JCommTextField case01;
	private JCommTextField case00;
	private JCommTextField case02;
	private JCommTextField case03;
	private JCommTextField case04;
	private JCommTextField case05;
	private JCommTextField case06;
	private JCommTextField case07;
	private JCommTextField case08;
	private JCommTextField case10;
	private JCommTextField case11;
	private JCommTextField case12;
	private JCommTextField case13;
	private JCommTextField case14;
	private JCommTextField case15;
	private JCommTextField case16;
	private JCommTextField case17;
	private JCommTextField case18;
	private JCommTextField case20;
	private JCommTextField case21;
	private JCommTextField case22;
	private JCommTextField case23;
	private JCommTextField case24;
	private JCommTextField case25;
	private JCommTextField case26;
	private JCommTextField case27;
	private JCommTextField case28;
	private JCommTextField case30;
	private JCommTextField case31;
	private JCommTextField case32;
	private JCommTextField case33;
	private JCommTextField case34;
	private JCommTextField case35;
	private JCommTextField case36;
	private JCommTextField case37;
	private JCommTextField case38;
	private JCommTextField case40;
	private JCommTextField case41;
	private JCommTextField case42;
	private JCommTextField case43;
	private JCommTextField case44;
	private JCommTextField case45;
	private JCommTextField case46;
	private JCommTextField case47;
	private JCommTextField case48;
	private JCommTextField case50;
	private JCommTextField case60;
	private JCommTextField case51;
	private JCommTextField case52;
	private JCommTextField case53;
	private JCommTextField case54;
	private JCommTextField case55;
	private JCommTextField case56;
	private JCommTextField case57;
	private JCommTextField case58;
	private JCommTextField case70;
	private JCommTextField case61;
	private JCommTextField case62;
	private JCommTextField case63;
	private JCommTextField case64;
	private JCommTextField case65;
	private JCommTextField case66;
	private JCommTextField case67;
	private JCommTextField case68;
	private JCommTextField case80;
	private JCommTextField case71;
	private JCommTextField case72;
	private JCommTextField case73;
	private JCommTextField case74;
	private JCommTextField case75;
	private JCommTextField case76;
	private JCommTextField case77;
	private JCommTextField case78;
	private JCommTextField case81;
	private JCommTextField case82;
	private JCommTextField case83;
	private JCommTextField case84;
	private JCommTextField case85;
	private JCommTextField case86;
	private JCommTextField case87;
	private JCommTextField case88;
	private JCommButton commButton;

public sudoku() {
	initComponents();
}
	private void initComponents() {
		setLayout(null);
		
		t_Options = new CTAT_Options();
		t_Options.setBounds(42, 528, 1, 1);
		add(t_Options);
		
		case00 = new JCommTextField();
		case00.setBounds(80, 61, 37, 37);
		add(case00);
		
		case01 = new JCommTextField();
		case01.setBounds(114, 61, 37, 37);
		add(case01);
		
		case02 = new JCommTextField();
		case02.setBounds(148, 61, 37, 37);
		add(case02);
		
		case03 = new JCommTextField();
		case03.setBounds(185, 61, 37, 37);
		add(case03);
		
		case04 = new JCommTextField();
		case04.setBounds(219, 61, 37, 37);
		add(case04);
		
		case05 = new JCommTextField();
		case05.setBounds(253, 61, 37, 37);
		add(case05);
		
		case06 = new JCommTextField();
		case06.setBounds(290, 61, 37, 37);
		add(case06);
		
		case07 = new JCommTextField();
		case07.setBounds(324, 61, 37, 37);
		add(case07);
		
		case08 = new JCommTextField();
		case08.setBounds(358, 61, 37, 37);
		add(case08);
		
		case10 = new JCommTextField();
		case10.setBounds(80, 95, 37, 37);
		add(case10);
		
		case11 = new JCommTextField();
		case11.setName("case221");
		case11.setBounds(114, 95, 37, 37);
		add(case11);
		
		case12 = new JCommTextField();
		case12.setBounds(148, 95, 37, 37);
		add(case12);
		
		case13 = new JCommTextField();
		case13.setBounds(185, 95, 37, 37);
		add(case13);
		
		case14 = new JCommTextField();
		case14.setBounds(219, 95, 37, 37);
		add(case14);
		
		case15 = new JCommTextField();
		case15.setBounds(253, 95, 37, 37);
		add(case15);
		
		case16 = new JCommTextField();
		case16.setBounds(290, 95, 37, 37);
		add(case16);
		
		case17 = new JCommTextField();
		case17.setBounds(324, 95, 37, 37);
		add(case17);
		
		case18 = new JCommTextField();
		case18.setBounds(358, 95, 37, 37);
		add(case18);
		
		case20 = new JCommTextField();
		case20.setBounds(80, 129, 37, 37);
		add(case20);
		
		case21 = new JCommTextField();
		case21.setBounds(114, 129, 37, 37);
		add(case21);
		
		case22 = new JCommTextField();
		case22.setBounds(148, 129, 37, 37);
		add(case22);
		
		case23 = new JCommTextField();
		case23.setBounds(185, 129, 37, 37);
		add(case23);
		
		case24 = new JCommTextField();
		case24.setBounds(219, 129, 37, 37);
		add(case24);
		
		case25 = new JCommTextField();
		case25.setBounds(253, 129, 37, 37);
		add(case25);
		
		case26 = new JCommTextField();
		case26.setBounds(290, 129, 37, 37);
		add(case26);
		
		case27 = new JCommTextField();
		case27.setBounds(324, 129, 37, 37);
		add(case27);
		
		case28 = new JCommTextField();
		case28.setBounds(358, 129, 37, 37);
		add(case28);
		
		case30 = new JCommTextField();
		case30.setBounds(80, 166, 37, 37);
		add(case30);
		
		case31 = new JCommTextField();
		case31.setBounds(114, 166, 37, 37);
		add(case31);
		
		case32 = new JCommTextField();
		case32.setBounds(148, 166, 37, 37);
		add(case32);
		
		case33 = new JCommTextField();
		case33.setBounds(185, 166, 37, 37);
		add(case33);
		
		case34 = new JCommTextField();
		case34.setBounds(219, 166, 37, 37);
		add(case34);
		
		case35 = new JCommTextField();
		case35.setBounds(253, 166, 37, 37);
		add(case35);
		
		case36 = new JCommTextField();
		case36.setBounds(290, 166, 37, 37);
		add(case36);
		
		case37 = new JCommTextField();
		case37.setBounds(324, 166, 37, 37);
		add(case37);
		
		case38 = new JCommTextField();
		case38.setBounds(358, 166, 37, 37);
		add(case38);
		
		case40 = new JCommTextField();
		case40.setBounds(80, 200, 37, 37);
		add(case40);
		
		case41 = new JCommTextField();
		case41.setBounds(114, 200, 37, 37);
		add(case41);
		
		case42 = new JCommTextField();
		case42.setBounds(148, 200, 37, 37);
		add(case42);
		
		case43 = new JCommTextField();
		case43.setBounds(185, 200, 37, 37);
		add(case43);
		
		case44 = new JCommTextField();
		case44.setBounds(219, 200, 37, 37);
		add(case44);
		
		case45 = new JCommTextField();
		case45.setBounds(253, 200, 37, 37);
		add(case45);
		
		case46 = new JCommTextField();
		case46.setBounds(290, 200, 37, 37);
		add(case46);
		
		case47 = new JCommTextField();
		case47.setBounds(324, 200, 37, 37);
		add(case47);
		
		case48 = new JCommTextField();
		case48.setBounds(358, 200, 37, 37);
		add(case48);
		
		case50 = new JCommTextField();
		case50.setBounds(80, 234, 37, 37);
		add(case50);
		
		case60 = new JCommTextField();
		case60.setBounds(80, 271, 37, 37);
		add(case60);
		
		case51 = new JCommTextField();
		case51.setBounds(114, 234, 37, 37);
		add(case51);
		
		case52 = new JCommTextField();
		case52.setBounds(148, 234, 37, 37);
		add(case52);
		
		case53 = new JCommTextField();
		case53.setBounds(185, 234, 37, 37);
		add(case53);
		
		case54 = new JCommTextField();
		case54.setBounds(219, 234, 37, 37);
		add(case54);
		
		case55 = new JCommTextField();
		case55.setBounds(253, 234, 37, 37);
		add(case55);
		
		case56 = new JCommTextField();
		case56.setBounds(290, 234, 37, 37);
		add(case56);
		
		case57 = new JCommTextField();
		case57.setBounds(324, 234, 37, 37);
		add(case57);
		
		case58 = new JCommTextField();
		case58.setBounds(358, 234, 37, 37);
		add(case58);
		
		case70 = new JCommTextField();
		case70.setBounds(80, 305, 37, 37);
		add(case70);
		
		case61 = new JCommTextField();
		case61.setBounds(114, 271, 37, 37);
		add(case61);
		
		case62 = new JCommTextField();
		case62.setBounds(148, 271, 37, 37);
		add(case62);
		
		case63 = new JCommTextField();
		case63.setBounds(185, 271, 37, 37);
		add(case63);
		
		case64 = new JCommTextField();
		case64.setBounds(219, 271, 37, 37);
		add(case64);
		
		case65 = new JCommTextField();
		case65.setBounds(253, 271, 37, 37);
		add(case65);
		
		case66 = new JCommTextField();
		case66.setBounds(290, 271, 37, 37);
		add(case66);
		
		case67 = new JCommTextField();
		case67.setBounds(324, 271, 37, 37);
		add(case67);
		
		case68 = new JCommTextField();
		case68.setBounds(358, 271, 37, 37);
		add(case68);
		
		case80 = new JCommTextField();
		case80.setBounds(80, 339, 37, 37);
		add(case80);
		
		case71 = new JCommTextField();
		case71.setBounds(114, 305, 37, 37);
		add(case71);
		
		case72 = new JCommTextField();
		case72.setBounds(148, 305, 37, 37);
		add(case72);
		
		case73 = new JCommTextField();
		case73.setBounds(185, 305, 37, 37);
		add(case73);
		
		case74 = new JCommTextField();
		case74.setBounds(219, 305, 37, 37);
		add(case74);
		
		case75 = new JCommTextField();
		case75.setBounds(253, 305, 37, 37);
		add(case75);
		
		case76 = new JCommTextField();
		case76.setBounds(290, 305, 37, 37);
		add(case76);
		
		case77 = new JCommTextField();
		case77.setBounds(324, 305, 37, 37);
		add(case77);
		
		case78 = new JCommTextField();
		case78.setBounds(358, 305, 37, 37);
		add(case78);
		
		case81 = new JCommTextField();
		case81.setBounds(114, 339, 37, 37);
		add(case81);
		
		case82 = new JCommTextField();
		case82.setBounds(148, 339, 37, 37);
		add(case82);
		
		case83 = new JCommTextField();
		case83.setBounds(185, 339, 37, 37);
		add(case83);
		
		case84 = new JCommTextField();
		case84.setBounds(219, 339, 37, 37);
		add(case84);
		
		case85 = new JCommTextField();
		case85.setBounds(253, 339, 37, 37);
		add(case85);
		
		case86 = new JCommTextField();
		case86.setBounds(290, 339, 37, 37);
		add(case86);
		
		case87 = new JCommTextField();
		case87.setBounds(324, 339, 37, 37);
		add(case87);
		
		case88 = new JCommTextField();
		case88.setBounds(358, 339, 37, 37);
		add(case88);
		
		commButton = new JCommButton();
		commButton.setText("Termine");
		commButton.setBounds(431, 61, 130, 29);
		add(commButton);
	}
	public void main(String args[]){
		new CTAT_Launcher(args).launch(new sudoku());
		int grille[][] = new int[9][9];
				grille[0][0] = Integer.parseInt(case00.getText());
				grille[0][1] = Integer.parseInt(case01.getText());
				grille[0][2] = Integer.parseInt(case02.getText());
				grille[0][3] = Integer.parseInt(case03.getText());
				grille[0][4] = Integer.parseInt(case04.getText());
				grille[0][5] = Integer.parseInt(case05.getText());
				grille[0][6] = Integer.parseInt(case06.getText());
				grille[0][7] = Integer.parseInt(case07.getText());
				grille[0][8] = Integer.parseInt(case08.getText());
				grille[1][0] = Integer.parseInt(case10.getText());
				grille[1][1] = Integer.parseInt(case11.getText());
				grille[1][2] = Integer.parseInt(case12.getText());
				grille[1][3] = Integer.parseInt(case13.getText());
				grille[1][4] = Integer.parseInt(case14.getText());
				grille[1][5] = Integer.parseInt(case15.getText());
				grille[1][6] = Integer.parseInt(case16.getText());
				grille[1][7] = Integer.parseInt(case17.getText());
				grille[1][8] = Integer.parseInt(case18.getText());
				grille[2][0] = Integer.parseInt(case20.getText());
				grille[2][1] = Integer.parseInt(case21.getText());
				grille[2][2] = Integer.parseInt(case22.getText());
				grille[2][3] = Integer.parseInt(case23.getText());
				grille[2][4] = Integer.parseInt(case24.getText());
				grille[2][5] = Integer.parseInt(case25.getText());
				grille[2][6] = Integer.parseInt(case26.getText());
				grille[2][7] = Integer.parseInt(case27.getText());
				grille[2][8] = Integer.parseInt(case28.getText());
				grille[3][0] = Integer.parseInt(case30.getText());
				grille[3][1] = Integer.parseInt(case31.getText());
				grille[3][2] = Integer.parseInt(case32.getText());
				grille[3][3] = Integer.parseInt(case33.getText());
				grille[3][4] = Integer.parseInt(case34.getText());
				grille[3][5] = Integer.parseInt(case35.getText());
				grille[3][6] = Integer.parseInt(case36.getText());
				grille[3][7] = Integer.parseInt(case37.getText());
				grille[3][8] = Integer.parseInt(case38.getText());
				grille[4][0] = Integer.parseInt(case40.getText());
				grille[4][1] = Integer.parseInt(case41.getText());
				grille[4][2] = Integer.parseInt(case42.getText());
				grille[4][3] = Integer.parseInt(case43.getText());
				grille[4][4] = Integer.parseInt(case44.getText());
				grille[4][5] = Integer.parseInt(case45.getText());
				grille[4][6] = Integer.parseInt(case46.getText());
				grille[4][7] = Integer.parseInt(case47.getText());
				grille[4][8] = Integer.parseInt(case48.getText());
				grille[5][0] = Integer.parseInt(case50.getText());
				grille[5][1] = Integer.parseInt(case51.getText());
				grille[5][2] = Integer.parseInt(case52.getText());
				grille[5][3] = Integer.parseInt(case53.getText());
				grille[5][4] = Integer.parseInt(case54.getText());
				grille[5][5] = Integer.parseInt(case55.getText());
				grille[5][6] = Integer.parseInt(case56.getText());
				grille[5][7] = Integer.parseInt(case57.getText());
				grille[5][8] = Integer.parseInt(case58.getText());
				grille[6][0] = Integer.parseInt(case60.getText());
				grille[6][1] = Integer.parseInt(case61.getText());
				grille[6][2] = Integer.parseInt(case62.getText());
				grille[6][3] = Integer.parseInt(case63.getText());
				grille[6][4] = Integer.parseInt(case64.getText());
				grille[6][5] = Integer.parseInt(case65.getText());
				grille[6][6] = Integer.parseInt(case66.getText());
				grille[6][7] = Integer.parseInt(case67.getText());
				grille[6][8] = Integer.parseInt(case68.getText());
				grille[7][0] = Integer.parseInt(case70.getText());
				grille[7][1] = Integer.parseInt(case71.getText());
				grille[7][2] = Integer.parseInt(case72.getText());
				grille[7][3] = Integer.parseInt(case73.getText());
				grille[7][4] = Integer.parseInt(case74.getText());
				grille[7][5] = Integer.parseInt(case75.getText());
				grille[7][6] = Integer.parseInt(case76.getText());
				grille[7][7] = Integer.parseInt(case77.getText());
				grille[7][8] = Integer.parseInt(case78.getText());
				grille[8][0] = Integer.parseInt(case80.getText());
				grille[8][1] = Integer.parseInt(case81.getText());
				grille[8][2] = Integer.parseInt(case82.getText());
				grille[8][3] = Integer.parseInt(case83.getText());
				grille[8][4] = Integer.parseInt(case84.getText());
				grille[8][5] = Integer.parseInt(case85.getText());
				grille[8][6] = Integer.parseInt(case86.getText());
				grille[8][7] = Integer.parseInt(case87.getText());
				grille[8][8] = Integer.parseInt(case88.getText());
	}
	}
