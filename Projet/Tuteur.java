
public class Tuteur 
{
	private Apprenant _apprenant;
	private Grille _grille;
	private ExpertSudoku _expert;
	private Sudoku _sudoku;
	
	private boolean _aDejaEuUnIndice = false;
	private boolean _aDejaVuStrat0 = false;
	private boolean _aDejaVuStrat1 = false;
	private boolean _aDejaVuStrat2 = false;
	private boolean _aDejaVuStrat3 = false;
	
	private String message_Connexion_Bienvenue =      "Bienvenue sur SudokuSmartTutor, le systeme tutoriel intelligent pour apprendre a jouer au Sudoku !";
	private String message_Connexion_Interface =      "L'interface de SudokuSmartTutor te permet d'eliminer des hypotheses (ecrites en petites) a l'aide\n du clic droit sur une case. Tu peux aussi jouer un coup pour entrer une valeur definitive (ecrite\n en gros) a l'aide du clic gauche. Si tu es bloque, tu peux demander de l'aide avec le bouton Indice.";
	
	private String message_Principe_Introduction =    "Pour commencer, voici le principe de base du jeu du Sudoku :";
	private String message_Principe_But =             "Le but du jeu du Sudoku est de completer la grille, divisee en 9 lignes, 9 colonnes et 9 regions\n (notees de 1 a 9 selon le sens de lecture occidental), en remplissant chaque case par un chiffre\n compris entre 1 et 9, de maniere a ce que les regles de bases soient satisfaites.";
	private String message_Principe_Regles =          "Voici les regles de base. Un chiffre dans une case satisfait la regle de la colonne si aucun autre\n meme chiffre ne se trouve dans la colonne de la case en question. Il en va de meme avec la regle\n de la ligne et la regle de la region.";
	
	private String message_Strat0_Introduction =      "Comme c'est tout premier Sudoku, voici la strategie initiale, dite des hypotheses simples.";
	private String message_Strat0_Definition =        "Un chiffre est une hypothese pour une case si ce chiffre satisfait les trois regles de bases dans\n cette case. Il peut y avoir plusieurs hypotheses par cases.";
	private String message_Strat0_Conseil =           "Il est pertinant de chercher a eliminer les hypotheses dans les cases dont la colonne, la ligne ou\n la region correspondante est le moins vide... Tu as plus de chance de pouvoir y appliquer des\n strategies par la suite !";
	
	private String message_Strat1_Introduction =      "Tu as l'air de bien maitriser le principe des hypotheses ! Pour aller plus loin, voici la premiere\n strategie, dite de l'hypothese seule visible.";
	private String message_Strat1_Definition =        "Une hypothese est la valeur definitive dans une case si dans cette case se trouve cette hypothese\n et elle seule.";
	private String message_Strat1_Conseil =           "Tu dois appliquer la premiere strategie des que tu constates que c'est possible avant de continuer\n a chercher d'autres hypotheses... Et n'oublies pas de mettre a jour tes hypotheses en consequence !";
	
	private String message_Strat2_Introduction =      "Tu as l'air de bien maitriser le principe de l'hypothese seule visible ! Pour aller plus loin,\n voici la deuxieme strategie, dite de l'hypothese seule cachee.";
	private String message_Strat2_Definition =        "Une hypothese est la valeur definitive dans une case si cette hypothese ne se trouve pas dans\n les autres cases de la colonne, de la ligne ou de la region de cette case.";
	private String message_Strat2_Conseil =           "Applique la deuxieme strategie des que tu constates que c'est possible ou bien des que la premiere\n n'est plus applicable... Tu dois alors te concentrer d'avantage sur les hypotheses !";
	
	private String message_Strat3_Introduction =      "Tu as l'air de bien maitriser le principe de l'hypothese seule cachee ! Pour aller plus loin,\n voici la troisieme strategie, dite des paires d'hypotheses visibles.";
	private String message_Strat3_Definition =        "Si dans deux cases parmi une colonne, un ligne ou une region se trouvent les deux memes\n hypotheses et elles seules, alors toutes ces mêmes hypothèses dans les autres cases de la colonne, de la\n ligne ou de la region en question peuvent etre eliminee.";
	private String message_Strat3_Conseil =           "Cette strategie ne permet que d'eliminer des hypotheses. Applique la des que possible...Puis\n essaye d'appliquer a nouveau les precedentes strategies !";
	
	private String message_Erreur_0 =                 "Attention ! Tu as fait une erreur. Tu peux l'apercevoir en rouge sur la grille.";
	private String message_Erreur_12 =                "Prends garde ! Tu as fait quelques erreurs. Tu peux les apercevoir en rouge sur la grille.";
	private String message_Erreur_3 =                 "Doux Jesus ! Tu as fait plusieurs erreurs. Je te laisse soin de les corriger...";

	private String message_Hasard_12 =                "C'est la bonne valeur, mais aucune strategie ne permet de jouer cela ! Serais-tu en train\n de jouer au hasard ?";
	private String message_Hasard_3 =                 "C'est encore la bonne valeur mais c'est encore du hasard. C'est la derniere fois que\n je te previens !";
	
	private String message_Indice_Introduction =      "Voici un indice qui te debloquera j'espere.";
	private String message_Indice_Strat = "";
	private String message_Indice_Coup = "";
	private String message_Indice_Region = "";
	private String message_Indice_Zone ="";
	
	private String message_Succes_1 = "";
	private String message_Succes_2 = "";
	private String message_Succes_3 = "";
	
	private String _indiceStrat = "";
	private String _indiceCoup = "";
	private String _indiceRegion = "";
	private String _indiceZone = "";	
	private String _succesStrat = "";
	
	public void MettreAjourMessages()
	{
		message_Indice_Strat =                        "Pour avancer, tu dois appliquer la strategie dite "+_indiceStrat+". Voici un petit rappel.";
		message_Indice_Coup =                         "Il y a une case ou un coup est jouable. Il s'agit de la case situee "+_indiceCoup+".";
		message_Indice_Region =                       "Il y a une region ou au moins un coup est possible. Il s'agit de la region numero "+_indiceRegion+".";
		message_Indice_Zone =                         "Il y a une zone ou au moins au coup est possible. Il s'agit de la partie "+_indiceZone+" de la grille.";
		
		message_Succes_1 =                            "Bravo ! Tu as applique pour la premiere fois "+_succesStrat+" avec succes !";
		message_Succes_2 =                            "Tu as encore une fois bien applique "+_succesStrat+" ! Bien joue !";
		message_Succes_3 =                            "Felicitation ! Je crois que tu as compris le principe de "+_succesStrat+".\n Plus la peine de te feliciter a nouveau !";
	}
	
	public Tuteur(Sudoku zeSudoku)
	{
		_apprenant = zeSudoku.apprenant;
		_expert = zeSudoku.expert;
		_grille = zeSudoku.grille;
		_sudoku = zeSudoku;
		
		Message_Connexion();
		Message_Strategie();

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
			int strategieUtilisable = _expert.strategieAJoueur();
			
			switch(strategieUtilisable)
			{
				case 0:
				{
					_indiceStrat = "des hypotheses simples.";
					MettreAjourMessages();
					
					_grille.ajouterMessage(message_Indice_Strat);
					_grille.ajouterMessage(message_Strat0_Definition);
					_grille.ajouterMessage(message_Strat0_Conseil);
				}
				break;
				
				case 1:
				{
					_indiceStrat = "de l'hypothese seule visible.";
					MettreAjourMessages();
					
					_grille.ajouterMessage(message_Indice_Strat);
					_grille.ajouterMessage(message_Strat1_Definition);
					_grille.ajouterMessage(message_Strat1_Conseil);
				}
				break;
				
				case 2:
				{
					_indiceStrat = "de l'hypothese seule cachee.";
					MettreAjourMessages();
					
					_grille.ajouterMessage(message_Indice_Strat);
					_grille.ajouterMessage(message_Strat2_Definition);
					_grille.ajouterMessage(message_Strat2_Conseil);
				}
				break;
				
				case 3:
				{
					_indiceStrat = "des paires d'hypotheses visible.";
					MettreAjourMessages();
					
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
					
					_indiceCoup = "a la ligne "+String.valueOf(coup.getLigne()+1)+" et a la colonne "+String.valueOf(coup.getColonne()+1);
					MettreAjourMessages();
					
					_grille.ajouterMessage(message_Indice_Introduction);
					_grille.ajouterMessage(message_Indice_Coup);

				}
				break;
				
				case 1:
				{
					Coup coup = _expert.coupAJoueur();
					
					_indiceCoup = "a la ligne "+String.valueOf(coup.getLigne())+" et a la colonne "+String.valueOf(coup.getColonne());
					MettreAjourMessages();
					
					_grille.ajouterMessage(message_Indice_Introduction);
					_grille.ajouterMessage(message_Indice_Coup);

				}
				break;
					
				case 2:
				{
					int region = _expert.regionAJouer();
					
					_indiceRegion = String.valueOf(region);
					MettreAjourMessages();
					
					_grille.ajouterMessage(message_Indice_Introduction);
					_grille.ajouterMessage(message_Indice_Region);
				}
				break;
					
				case 3:
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
					MettreAjourMessages();
					
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
					_sudoku.afficherErreurs();
				}
			}
			break;
			
			case 1:
			{
				if(nombreErreursPonderees>5)
				{
					_grille.ajouterMessage(message_Erreur_12);
					_sudoku.afficherErreurs();
				}
			}
			break;

			case 2:
			{
				if(nombreErreursPonderees>8)
				{
					_grille.ajouterMessage(message_Erreur_12);
					_sudoku.afficherErreurs();
				}
			}
			break;
			
			case 3:
			{
				if(nombreErreursPonderees>8)
				{
					_grille.ajouterMessage(message_Erreur_3);
					_sudoku.afficherErreurs();
				}
			}
			break;
		}
		
		_aDejaEuUnIndice = false;
	}
	
	public void Message_Succes(int numeroStrat)
	{
		int nbSuccesStrat = 0;
		
		switch(numeroStrat)
		{
			case 0:
			{
				_succesStrat = "la strategie des hypotheses simples";
				MettreAjourMessages();
				
				nbSuccesStrat = _apprenant.knowledge_success[numeroStrat];
			}
				break;		
				
			case 1:
			{
				_succesStrat = "la strategie de l'hypothese seule visible";
				MettreAjourMessages();
				
				nbSuccesStrat = _apprenant.knowledge_success[numeroStrat];
			}
				break;
				
			case 2:
			{
				_succesStrat = "la strategie de l'hypothese seule cachee";
				MettreAjourMessages();
				
				nbSuccesStrat = _apprenant.knowledge_success[numeroStrat];
			}
				break;
				
			case 3:
			{
				_succesStrat = "la strategie des paires d'hypotheses visibles";
				MettreAjourMessages();
				
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
		
		_aDejaEuUnIndice = false;
	}
	
	public void Message_Hasard()
	{
		int nombreCoupsHasard = _apprenant.numRandom;
		
		switch(nombreCoupsHasard)
		{
			case 1:
			{
				_grille.ajouterMessage(message_Hasard_12);
			}
			break;
			
			case 2:
			{
				_grille.ajouterMessage(message_Hasard_12);
			}
			break;
			
			case 3:
			{
				_grille.ajouterMessage(message_Hasard_3);
			}
			break;
			
			default:
			{
				//rien
			}
			break;
		}
		
		_aDejaEuUnIndice = false;
	}
	
	public static void main(String[] args)
	{
		/*
		
		zeTuteur.messages_Connexion_Bienvenue();
		zeTuteur.messages_But_Introduction();
		zeTuteur.messages_Strat0_Introduction();
		zeTuteur.messages_Strat1_Introduction();
		*/
		//Grille ZEinterface = new Grille();
		
		Tuteur zeTuteur = new Tuteur(new Sudoku());
		
		zeTuteur.Message_Succes(0);
	}
	
	
	
}
