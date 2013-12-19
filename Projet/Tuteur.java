
public class Tuteur 
{
	private Apprenant _apprenant;
	private Grille _grille;
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
	
	private static String _succesStrat;
	
	private static String message_Connexion_Bienvenue = "Bienvenue sur SudokuSmartTutor, le systeme tutoriel intelligent pour apprendre a jouer au Sudoku !";
	private static String message_Connexion_Interface = "L'interface de SudokuSmartTutor te permet d'eliminer des hypotheses (ecrites en petites) a l'aide du clic droit sur une case. Tu peux aussi jouer un coup pour entrer une valeur definitive (ecrite en gros) a l'aide du clic gauche. Si tu es bloque, tu peux demander de l'aide avec le bouton Indice.";
	
	private static String message_Principe_Introduction = "Pour commencer, voici le principe de base du jeu du Sudoku :";
	private static String message_Principe_But = "Le but du jeu du Sudoku est de completer la grille, divisee en 9 lignes, 9 colonnes et 9 regions (notees de 1 a 9 selon le sens de lecture occidental), en remplissant chaque case par un chiffre compris entre 1 et 9, de maniere a ce que les regles de bases soient satisfaites.";
	private static String message_Principe_Regles = "Un chiffre dans une case satisfait la regle de la colonne si aucun autre meme chiffre ne se trouve dans la colonne de la case en question. Il en va de meme avec la regle de la ligne et la regle de la region.";
	
	private static String message_Strat0_Introduction = "Comme c'est tout premier Sudoku, voici la strategie initiale, dite des hypotheses simples.";
	private static String message_Strat0_Definition = "Un chiffre est une hypothese pour une case si ce chiffre satisfait les trois regles de bases dans cette case. Il peut y avoir plusieurs hypotheses par cases.";
	private static String message_Strat0_Conseil = "Il est pertinant de chercher a eliminer les hypotheses dans les cases dont la colonne, la ligne ou la region correspondante est le moins vide... Tu as plus de chance de pouvoir y appliquer des strategies par la suite !";
	
	private static String message_Strat1_Introduction = "Tu as l'air de bien maitriser le principe des hypotheses ! Pour aller plus loin, voici la premiere strategie, dite de l'hypothese seule visible.";
	private static String message_Strat1_Definition = "Une hypothese est la valeur definitive dans une case si dans cette case se trouve cette hypothese et elle seule.";
	private static String message_Strat1_Conseil = "Tu dois appliquer la premiere strategie des que tu constates que c'est possible avant de continuer a chercher d'autres hypotheses... Et n'oublies pas de mettre a jour tes hypotheses en consequence !";
	
	private static String message_Strat2_Introduction = "Tu as l'air de bien maitriser le principe de l'hypothese seule visible ! Pour aller plus loin, voici la deuxieme strategie, dite de l'hypothese seule cachee.";
	private static String message_Strat2_Definition = "Une hypothese est la valeur definitive dans une case si cette hypothese ne se trouve pas dans la colonne, la ligne ou la region de cette case.";
	private static String message_Strat2_Conseil = "Applique la deuxieme strategie des que tu constates que c'est possible ou bien des que la premiere n'est plus applicable... Tu dois alors te concentrer d'avantage sur les hypotheses !";
	
	private static String message_Strat3_Introduction = "Tu as l'air de bien maitriser le principe de l'hypothese seule cachee ! Pour aller plus loin, voici la troisieme strategie, dite des paires d'hypotheses visibles.";
	private static String message_Strat3_Definition = "";
	private static String message_Strat3_Conseil = "";
	
	private static String message_Erreur_0 = "Attention ! Tu as fait une erreur. Tu peux l'apercevoir en rouge sur la grille.";
	private static String message_Erreur_12 = "Prends garde ! Tu as fait quelques erreurs. Tu peux les apercevoir en rouge sur la grille.";
	private static String message_Erreur_3 = "Doux Jesus ! Tu as fait 3 erreurs. Je te laisse soin de les corriger...";

	private static String message_Indice_Introduction = "Voici un indice qui te debloquera j'espere.";
	private static String message_Indice_Strat = "Voici une strategie que tu n'as pas encore utilisee souvent. Il s'agit de la stragie dite "+_indiceStrat;
	private static String message_Indice_Coup = "Il y a une case ou un coup est jouable. Il s'agit de la case situee "+_indiceCoup+".";
	private static String message_Indice_Region = "Il y a une region ou au moins un coup est possible. Il s'agit de la region numero "+_indiceRegion+".";
	private static String message_Indice_Zone ="Il y a une zone ou au moins au coup est possible. Il s'agit de la partie "+_indiceZone+" de la grille.";
	
	private static String message_Succes_1 = "Bravo ! Tu as applique pour la premiere fois "+_succesStrat+" avec succes !";
	private static String message_Succes_2 = "Tu as encore une fois bien applique "+_succesStrat+" ! Bien joue !";
	private static String message_Succes_3 = "Felicitation ! Je crois que tu as compris le principe de "+_succesStrat+". Plus la peine de te feliciter a nouveau !";
	
	private static String message_Hasard = "Aucune strategie ne te permet de faire cela. J'estime que tu joues au hasard !";
	
	public Tuteur(Sudoku zeSudoku)
	{
		_apprenant = zeSudoku.apprenant;
		_expert = zeSudoku.expert;
		//_grille = zeSudoku
		_sudoku = zeSudoku;

	}
	
	public Tuteur()
	{
		
	}
	
	
	public void Message_Connexion()
	{
		_grille.ajouterMessage(message_Connexion_Bienvenue);
		
		int niveauExpertise = _apprenant.GetNiveau();
		
		if(niveauExpertise==0)
		{
			_grille.ajouterMessage(message_Connexion_Interface);
			_grille.ajouterMessage(message_Principe_Introduction);
			_grille.ajouterMessage(message_Principe_But);
			_grille.ajouterMessage(message_Principe_Regles);
		}
	}
	
	public void Message_Indice()
	{
		if(_aDejaEuUnIndice == false)
		{
			int strategieLaMoinsUtilisee = 0; //get de l'apprenant
			
			switch(strategieLaMoinsUtilisee)
			{
				case 0:
				{
					_indiceStrat = "des hypotheses.";
					
					_grille.ajouterMessage(message_Indice_Strat);
					_grille.ajouterMessage(message_Strat0_Definition);
					_grille.ajouterMessage(message_Strat0_Conseil);
				}
				break;
				
				case 1:
				{
					_indiceStrat = "de l'hypothese seule visible.";
					
					_grille.ajouterMessage(message_Indice_Strat);
					_grille.ajouterMessage(message_Strat1_Definition);
					_grille.ajouterMessage(message_Strat1_Conseil);
				}
				break;
				
				case 2:
				{
					_indiceStrat = "de l'hypothese seule cachee.";
					
					_grille.ajouterMessage(message_Indice_Strat);
					_grille.ajouterMessage(message_Strat2_Definition);
					_grille.ajouterMessage(message_Strat2_Conseil);
				}
				break;
				
				case 3:
				{
					_indiceStrat = "des paires d'hypotheses visible.";
					
					_grille.ajouterMessage(message_Indice_Strat);
					_grille.ajouterMessage(message_Strat3_Definition);
					_grille.ajouterMessage(message_Strat3_Conseil);
				}
				break;
			}
			
			_aDejaEuUnIndice = true;
		}
		if(_aDejaEuUnIndice == true)
		{
			int niveauExpertise = _apprenant.GetNiveau();
			
			switch(niveauExpertise)
			{
				case 0:
				{
					Coup coup = _expert.coupAJoueur();
					
					_indiceCoup = "a la ligne "+String.valueOf(coup.getLigne())+" et a la colonne "+String.valueOf(coup.getColonne());
					
					_grille.ajouterMessage(message_Indice_Introduction);
					_grille.ajouterMessage(message_Indice_Coup);

				}
				break;
					
				case 1:
				{
					int region = _expert.regionAJouer();
					
					_indiceRegion = String.valueOf(region);
					
					_grille.ajouterMessage(message_Indice_Introduction);
					_grille.ajouterMessage(message_Indice_Region);
				}
				break;
					
				case 2:
				{
					
					int zone = _expert.zoneAJouer();
					
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
					
					_grille.ajouterMessage(message_Indice_Introduction);
					_grille.ajouterMessage(message_Indice_Zone);
				}
				break;
			}
			
			_aDejaEuUnIndice = false;
		}
	}
	
	public void Message_Strategie()
	{
		int niveauExpertise = _apprenant.GetNiveau();
		
		switch(niveauExpertise)
		{
			case 0:
			{
				if(_aDejaVuStrat0 == false)
				{
					_grille.ajouterMessage(message_Strat0_Introduction);
					_grille.ajouterMessage(message_Strat0_Definition);
					_grille.ajouterMessage(message_Strat0_Conseil);
					
					_aDejaVuStrat0 = true;
				}
			}
			break;
			
			case 1:
			{
				if(_aDejaVuStrat1 == false)
				{
					_grille.ajouterMessage(message_Strat1_Introduction);
					_grille.ajouterMessage(message_Strat1_Definition);
					_grille.ajouterMessage(message_Strat1_Conseil);
					
					_aDejaVuStrat1 = true;
				}
			}
			break;
			
			case 2:
			{
				if(_aDejaVuStrat2 == false)
				{
					_grille.ajouterMessage(message_Strat2_Introduction);
					_grille.ajouterMessage(message_Strat2_Definition);
					_grille.ajouterMessage(message_Strat2_Conseil);
					
					_aDejaVuStrat2 = true;
				}
			}
			break;
			
			case 3:
			{
				if(_aDejaVuStrat3 == false)
				{
					_grille.ajouterMessage(message_Strat3_Introduction);
					_grille.ajouterMessage(message_Strat3_Definition);
					_grille.ajouterMessage(message_Strat3_Conseil);
					
					_aDejaVuStrat3 = true;
				}
			}
			break;
			
			
		}
	}

	public void Message_Erreur()
	{
		int niveauExpertise = _apprenant.GetNiveau();
		int nombreErreursPonderees = _sudoku.GetNbErreuCoup()*3+_sudoku.GetNbErreuHypo();
		
		switch(niveauExpertise)
		{
			case 0:
			{
				if(nombreErreursPonderees>0)
				{
					_grille.ajouterMessage(message_Erreur_0);
				}
				
			}
			break;
			
			case 1:
			{
				if(nombreErreursPonderees>5)
				{
					_grille.ajouterMessage(message_Erreur_12);
				}
			}
			break;

			case 2:
			{
				if(nombreErreursPonderees>8)
				{
					_grille.ajouterMessage(message_Erreur_12);
				}
			}
			break;
			
			case 3:
			{
				if(nombreErreursPonderees>8)
				{
					_grille.ajouterMessage(message_Erreur_3);
				}
			}
			break;
			
			//Maj interface
		}
	}
	
	public void Message_Succes(int numeroStrat)
	{
		int nbSuccesStrat = 0;
		
		switch(numeroStrat)
		{
			case 0:
			{
				_indiceStrat = "la strategie des hypotheses simples";
				nbSuccesStrat = _apprenant.knowledge_success[numeroStrat];
			}
				break;		
				
			case 1:
			{
				_indiceStrat = "la strategie de l'hypothese seule visible";
				nbSuccesStrat = _apprenant.knowledge_success[numeroStrat];
			}
				break;
				
			case 2:
			{
				_indiceStrat = "la strategie de l'hypothese seule cachee";
				nbSuccesStrat = _apprenant.knowledge_success[numeroStrat];
			}
				break;
				
			case 3:
			{
				_indiceStrat = "la strategie des paires d'hypotheses visibles";
				nbSuccesStrat = _apprenant.knowledge_success[numeroStrat];
			}
				break;
		}
		
		switch(nbSuccesStrat)
		{
			case 1:
			{
				_grille.ajouterMessage(message_Succes_1);
			}
			break;
			
			case 2:
			{
				_grille.ajouterMessage(message_Succes_2);
			}
			break;
			
			case 3:
			{
				_grille.ajouterMessage(message_Succes_3);
			}
			break;
			
			default:
			{
				//rien
			}
			break;
		}
	}
	
	public void Message_Hasard()
	{
		_grille.ajouterMessage(message_Hasard);
	}
	
	public static void main(String[] args)
	{
		/*
		Tuteur zeTuteur = new Tuteur();
		zeTuteur.messages_Connexion_Bienvenue();
		zeTuteur.messages_But_Introduction();
		zeTuteur.messages_Strat0_Introduction();
		zeTuteur.messages_Strat1_Introduction();
		*/
		Grille ZEinterface = new Grille();
	}
	
	
	
}
