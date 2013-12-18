package sudoku;

public class Tuteur 
{
	private Apprenant _apprenant;
	private Interface _interface;
	private ExpertSudoku _expert;
	private Sudoku _sudoku;
	
	private String _texteTuteur = "";
	
	private boolean _aDejaEuUnIndice = false;
	private boolean _aDejaVuStrat0 = false;
	private boolean _aDejaVuStrat1 = false;
	private boolean _aDejaVuStrat2 = false;
	private boolean _aDejaVuStrat3 = false;
	
	private static String _indiceStrat;
	private static String _indiceCoup;
	private static String _indiceRegion;
	private static String _indiceZone;
	
	
	private static String message_Connexion_Bienvenue = "Bienvenue sur SudokuSmartTutor, le systeme tutoriel intelligent pour apprendre a jouer au Sudoku !";
	private static String message_Connexion_Interface = "L'interface de SudokuSmartTutor te permet d'eliminer des hypotheses (ecrites en petites) a l'aide du clic droit sur une case. Tu peux aussi jouer un coup pour entrer une valeur definitive (ecrite en gros) a l'aide du clic gauche. Si tu es bloque, tu peux demander de l'aide avec le bouton Indice.";
	
	private static String message_Principe_Introduction = "Pour commencer, voici le principe de base du jeu du Sudoku :";
	private static String message_Principe_But = "Le but du jeu du Sudoku est de completer la grille, divisee en 9 lignes, 9 colonnes et 9 regions (notees de 1 a 9 selon le sens de lecture occidental), en remplissant chaque case par un chiffre compris entre 1 et 9, de maniere a ce que les regles de bases soient satisfaites.";
	private static String message_Principe_Regles = "Un chiffre dans une case satisfait la regle de la colonne si aucun autre meme chiffre ne se trouve dans la colonne de la case en question. Il en va de meme avec la regle de la ligne et la regle de la region.";
	
	private static String message_Strat0_Introduction = "Ensuite, voici la strategie initiale, dite des hypotheses.";
	private static String message_Strat0_Definition = "Un chiffre est une hypothese pour une case si ce chiffre satisfait les trois regles de bases dans cette case. Il peut y avoir plusieurs hypotheses par cases.";
	private static String message_Strat0_Conseil = "Il est pertinant de chercher a eliminer les hypotheses dans les cases dont la colonne, la ligne ou la region correspondante est le moins vide... Tu as plus de chance de pouvoir y appliquer des strategies par la suite !";
	
	private static String message_Strat1_Introduction = "Tu as l'air d'avoir compris le principe des hypotheses ! Voici la premiere strategie, dite de l'hypothese seule visible.";
	private static String message_Strat1_Definition = "Une hypothese est la valeur definitive dans une case si dans cette case se trouve cette hypothese et elle seule.";
	private static String message_Strat1_Conseil = "Tu dois appliquer la premiere strategie des que tu constates que c'est possible avant de continuer a chercher d'autres hypotheses... Et n'oublies pas de mettre a jour tes hypotheses en consequence !";
	
	private static String message_Strat2_Introduction = "Tu as l'air d'avoir compris le principe de l'hypothese seule visible ! Voici la deuxieme strategie, dite de l'hypothese seule cachee.";
	private static String message_Strat2_Definition = "Une hypothese est la valeur definitive dans une case si cette hypothese ne se trouve pas dans la colonne, la ligne ou la region de cette case.";
	private static String message_Strat2_Conseil = "Applique la deuxieme strategie des que tu constates que c'est possible ou bien des que la premiere n'est plus applicable... Tu dois alors te concentrer d'avantage sur les hypotheses !";
	
	private static String message_Strat3_Introduction = "Tu as l'air d'avoir compris le principe de l'hypothese seule cachee ! Voici la troisieme strategie, dite des paires d'hypotheses visibles.";
	private static String message_Strat3_Definition = "";
	private static String message_Strat3_Conseil = "";
	
	private static String message_Erreur_1 = "Attention ! Tu as fait 1 erreur. Tu peux l'apercevoir en rouge sur la grille.";
	private static String message_Erreur_2 = "Prends garde ! Tu as fait 2 erreurs. Tu peux les apercevoir en rouge sur la grille.";
	private static String message_Erreur_3 = "Misericorde ! Tu as fait 3 erreurs. Tu peux les apercevoir en rouge sur la grille.";
	private static String message_Erreur_4 = "Doux Jesus ! Tu as fait 3 erreurs. Je te laisse soin de les corriger...";

	private static String message_Indice_Introduction = "Voici un indice qui te debloquera j'espere.";
	private static String message_Indice_Strat = "Voici une strategie que tu n'as pas encore utilisee souvent. Il s'agit de la stragie dite "+_indiceStrat;
	private static String message_Indice_Coup = "Il y a une case ou un coup est jouable. Il s'agit de la case situee "+_indiceCoup+".";
	private static String message_Indice_Region = "Il y a une region ou au moins un coup est possible. Il s'agit de la region numero "+_indiceRegion+".";
	private static String message_Indice_Zone ="Il y a une zone ou au moins au coup est possible. Il s'agit de la partie "+_indiceZone+" de la grille.";
	
	public Tuteur(Apprenant zeApprenant, ExpertSudoku zeExpert, Interface zeInterface, Sudoku zeSudoku)
	{
		_apprenant = zeApprenant;
		_expert = zeExpert;
		_interface = zeInterface;
		_sudoku = zeSudoku;
	}
	
	public Tuteur()
	{
		
	}
	
	public void message_Indice()
	{
		if(_aDejaEuUnIndice == false)
		{
			int strategieLaMoinsUtilisee = 0; //get de l'apprenant
			
			switch(strategieLaMoinsUtilisee)
			{
				case 0:
				{
					_indiceStrat = "des hypotheses.";
					messages_Indice_Strat0();
				}
				break;
				
				case 1:
				{
					_indiceStrat = "de l'hypothese seule visible.";
					messages_Indice_Strat1();
				}
				break;
				
				case 2:
				{
					_indiceStrat = "de l'hypothese seule cachee.";
					messages_Indice_Strat2();
				}
				break;
				
				case 3:
				{
					_indiceStrat = "des paires d'hypotheses visible.";
					messages_Indice_Strat3();
				}
				break;
			}
			
			_aDejaEuUnIndice = true;
		}
		if(_aDejaEuUnIndice == true)
		{
			int niveauExpertise = 0; //get de l'apprenant
			
			switch(niveauExpertise)
			{
				case 0:
				{
					Coup coup = new Coup(1,1,1); //get de l'expert
					_indiceCoup = "a la ligne "+String.valueOf(coup.getLigne())+" et a la colonne "+String.valueOf(coup.getColonne());
					messages_Indice_Coup();
				}
				break;
					
				case 1:
				{
					int region = 0; //get de l'expert
					_indiceRegion = String.valueOf(region);
					messages_Indice_Region();
				}
				break;
					
				case 2:
				{
					
					int zone = 0; //get de l'expert
					switch(zone)
					{
					 	case 0:
					 	{
					 		_indiceZone = "gauche";
					 	}
					 	break;
					 		
					 	case 1:
					 	{
					 		_indiceZone = "droite";
					 	}
					 	break;
					 		
					 	case 2:
					 	{
					 		_indiceZone = "du haut";
					 	}
					 	break;
					 		
					 	case 3:
					 	{
					 		_indiceZone = "du bas";
					 	}
					 	break;
					 	
					 	case 4:
					 	{
					 		_indiceZone = "centrale";
					 	}
					 	break;	 
					}
					
					messages_Indice_Zone();
				}
				break;
			}
			
			_aDejaEuUnIndice = false;
		}
	}
	
	public void message_Coup()
	{
		
	}

	public void MAJTexteTuteur(String texte)
	{
		if(!texte.equals("\n"))
		{	
			System.out.print("Tuteur :\n");
		}
		
		try 
		{
			Thread.sleep(500);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i<texte.length();i++)
		{
			System.out.print(texte.charAt(i));
			
			try 
			{
				Thread.sleep(40);
			} catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("\n\n");
	}
	
	public void messages_Connexion_Bienvenue()
	{

		MAJTexteTuteur(message_Connexion_Bienvenue);
		MAJTexteTuteur(message_Connexion_Interface);	
		MAJTexteTuteur("\n");

	}
	
	public void messages_But_Introduction()
	{
		MAJTexteTuteur(message_Principe_Introduction);
		MAJTexteTuteur(message_Principe_But);
		MAJTexteTuteur(message_Principe_Regles);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Strat0_Introduction()
	{
		_aDejaVuStrat0 = true;
		
		MAJTexteTuteur(message_Strat0_Introduction);
		MAJTexteTuteur(message_Strat0_Definition);
		MAJTexteTuteur(message_Strat0_Conseil);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Strat1_Introduction()
	{
		_aDejaVuStrat1 = true;
		
		MAJTexteTuteur(message_Strat1_Introduction);
		MAJTexteTuteur(message_Strat1_Definition);
		MAJTexteTuteur(message_Strat1_Conseil);
		MAJTexteTuteur("\n");
	}

	public void messages_Strat2_Introduction()
	{
		_aDejaVuStrat2 = true;
		
		MAJTexteTuteur(message_Strat2_Introduction);
		MAJTexteTuteur(message_Strat2_Definition);
		MAJTexteTuteur(message_Strat2_Conseil);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Strat3_Introduction()
	{
		_aDejaVuStrat3 = true;
		
		MAJTexteTuteur(message_Strat3_Introduction);
		MAJTexteTuteur(message_Strat3_Definition);
		MAJTexteTuteur(message_Strat3_Conseil);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Indice_Strat0()
	{
		MAJTexteTuteur(message_Indice_Strat);
		MAJTexteTuteur(message_Strat0_Definition);
		MAJTexteTuteur(message_Strat0_Conseil);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Indice_Strat1()
	{
		MAJTexteTuteur(message_Indice_Strat);
		MAJTexteTuteur(message_Strat1_Definition);
		MAJTexteTuteur(message_Strat1_Conseil);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Indice_Strat2()
	{
		MAJTexteTuteur(message_Indice_Strat);
		MAJTexteTuteur(message_Strat2_Definition);
		MAJTexteTuteur(message_Strat2_Conseil);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Indice_Strat3()
	{
		MAJTexteTuteur(message_Indice_Strat);
		MAJTexteTuteur(message_Strat3_Definition);
		MAJTexteTuteur(message_Strat3_Conseil);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Indice_Coup()
	{
		MAJTexteTuteur(message_Indice_Introduction);
		MAJTexteTuteur(message_Indice_Coup);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Indice_Region()
	{
		MAJTexteTuteur(message_Indice_Introduction);
		MAJTexteTuteur(message_Indice_Region);
		MAJTexteTuteur("\n");
	}
	
	public void messages_Indice_Zone()
	{
		MAJTexteTuteur(message_Indice_Introduction);
		MAJTexteTuteur(message_Indice_Zone);
		MAJTexteTuteur("\n");
	}
	
	public static void main(String[] args)
	{
		Tuteur zeTuteur = new Tuteur();
		zeTuteur.messages_Connexion_Bienvenue();
		zeTuteur.messages_But_Introduction();
		zeTuteur.messages_Strat0_Introduction();
		zeTuteur.messages_Strat1_Introduction();
	}
	
	
	
}
