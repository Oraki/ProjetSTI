package sudoku;

public class Tuteur 
{
	private String texteTuteur ="";
	
	private static String nom_STI = "SudokuSmartTutor";
	private static String nom_Auteur1 = "Gilles Godefroid";
	private static String nom_Auteur2 = "Ludovic Lefebvre";
	private static String nom_Auteur3 = "Jules Mozes";
	private static String nom_Auteur4 = "Maxime Turmel";
	
	private static String message_Connexion_Bienvenue = "Bienvenue sur "+nom_STI+", le systeme tutoriel intelligent pour apprendre a jouer au Sudoku !";
	//private static String message_Connexion_Auteurs = nom_STI+" a ete realise par "+nom_Auteur1+", "+nom_Auteur2+", "+nom_Auteur3+" et "+nom_Auteur4+" dans le cadre du cours de maitrise INF7470 a l'UQAM.";
	
	private static String message_But_Introduction = "Voici le but du jeu du Sudoku :";
	private static String message_But_Definition = "Le but du jeu du Sudoku est de completer la grille, divisee en 9 lignes, 9 colonnes et 9 regions,  en remplissant chaque case par un chiffre compris entre 1 et 9, de maniere a ce que les regles de bases soient satisfaites.";
	
	private static String message_Regles_Introduction = "Voici les regles de bases.";
	private static String message_Regles_Rappel = "Rappel des regles de bases.";
	//private static String message_Regle_Grille = "La grille du Sudoku est composee de 81 cases reparties en un carre. On peut la diviser en 9 colonnes, 9 lignes ou 9 regions carrees.";
	//private static String message_Regle_Colonne1 = "Un chiffre dans une case satisfait la regle de la colonne si aucun autre meme chiffre ne se trouve dans la colonne de la case en question.";
	//private static String message_Regle_Colonne2 = "Il en va de meme avec la regle de la colonne.";
	//private static String message_Regle_Ligne1 = "Un chiffre dans une case satisfait la regle de la ligne si aucun autre meme chiffre ne se trouve dans la ligne de la case en question.";
	//private static String message_Regle_Ligne2 = "Il en va de meme avec la regle de la ligne.";
	//private static String message_Regle_Region1 = "Un chiffre dans une case satisfait la regle de la region si aucun autre meme chiffre ne se trouve dans la region de la case en question.";
	//private static String message_Regle_Region2 = "Il en va de meme avec la regle de la region.";
	private static String message_Regles_Definition = "Un chiffre dans une case satisfait la regle de la colonne si aucun autre meme chiffre ne se trouve dans la colonne de la case en question. Il en va de meme avec la regle de la ligne et la regle de la region.";
	private static String message_Regles_Application = "Il s'agit d'appliquer ces regles pour trouver les valeurs definitives (ecrites en gros) en utilisant des strategies ou bien pour trouver des hypotheses (ecrites en petit).";
	
	private static String message_Hypotheses_Introduction = "Voici le principe de fonctionnement des hypotheses.";
	private static String message_Hypotheses_Definition = "Un chiffre est une hypothese pour une case si ce chiffre satisfait presentement les trois regles de bases dans cette case. Il peut y avoir plusieurs hypotheses par cases.";
	private static String message_Hypotheses_Conseil1 = "Commence par chercher les hypotheses dans les cases dont les colonnes, lignes ou regions correspondantes semblent le plus remplies... Tu as plus de chance de pouvoir y appliquer des strategies !";
	private static String message_Hypotheses_Conseil2 = "Verifie les hypotheses concernees par une strategie avant de l'appliquer... Tu n'es jamais a l'abris des erreurs d'innattention !";
	private static String message_Hypotheses_Application = "Il s'agit d'eliminer pour chaque case tous les chiffres qui ne sont pas des hypotheses, et ce dans toutes les cases.";
	
	private static String message_Strat1_Introduction = "Voici le principe de la premiere strategie dite de l'hypothese seule visible.";
	private static String message_Strat1_Definition = "Une hypothese est la valeur definitive dans une case si dans cette case se trouve cette hypothese et elle seule.";
	private static String message_Strat1_Conseil1 = "Applique la premiere strategie des que tu constates que c'est possible avant de continuer a chercher d'autres hypotheses... Tu elimineras plus d'hypotheses par la suite !";
	private static String message_Strat1_Conseil2 = "";
	private static String message_Strat1_Application = "Il s'agit de reperer visuellement une case avec une seule hypothese puis d'inscrire la valeur definitive, sans oublier de mettre a jour tes hypotheses en consequence.";
	
	private static String message_Strat2_Introduction = "Voici le principe de la deuxieme strategie dite de l'hypothese seule cachee.";
	private static String message_Strat2_Definition = "Une hypothese est la valeur definitive dans une case si cette hypothese ne se trouve pas dans la colonne, la ligne ou la region de cette case.";
	private static String message_Strat2_Conseil1 = "Applique la deuxieme strategie des que tu constates que c'est possible ou bien des que la premiere n'est plus applicable... Tu dois alors concentrer d'avantage sur les hypotheses !";
	private static String message_Strat2_Conseil2 = "";
	private static String message_Strat2_Application = "Il s'agit d'analyser visuellement une colonne, une ligne ou une region pour determiner s'il s'y trouve une hypothese seule cachee.";
	
	private static String message_Erreur_Strat_Hasard = "Aucune strategie ne te permet de jouer ce coup. Verifie bien tes hypotheses ou essaye d'appliquer une strategie sur une autre case. Je suppose que tu as joue au hasard !";
	private static String message_Erreur_Hypotheses_Oups1 = "Tu as laisse une hypothese qui ne doit pas l'etre quelque part dans la grille. Je suppose que c'est un oublie !";
	private static String message_Erreur_Hypotheses_Oups2 = "Tu as elimine une hypothese que ne doit pas l'etre quelque part dans la grille. Je suppose que c'est de l'inattention !";
	
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
		
		//MAJTexteTuteur(message_Connexion_Auteurs);
		
		MAJTexteTuteur("\n");

	}
	
	public void messages_But_Introduction()
	{
		MAJTexteTuteur(message_But_Introduction);
		
		MAJTexteTuteur(message_But_Definition);
		
		MAJTexteTuteur("\n");
	}
	
	public void messages_Regle_Introduction()
	{
		MAJTexteTuteur(message_Regles_Introduction);
		
		MAJTexteTuteur(message_Regles_Definition);
		
		MAJTexteTuteur(message_Regles_Application);
		
		MAJTexteTuteur("\n");
	}
	
	public void messages_Hypothese_Introduction()
	{
		MAJTexteTuteur(message_Hypotheses_Introduction);
		
		MAJTexteTuteur(message_Hypotheses_Definition);
		
		MAJTexteTuteur(message_Hypotheses_Application);
		
		MAJTexteTuteur("\n");
	}
	
	public void messages_Strat1_Introduction()
	{
		MAJTexteTuteur(message_Strat1_Introduction);
		
		MAJTexteTuteur(message_Strat1_Definition);
		
		MAJTexteTuteur(message_Strat1_Application);
		
		MAJTexteTuteur("\n");
	}
	
	public static void main(String[] args)
	{
		Tuteur zeTuteur = new Tuteur();
		zeTuteur.messages_Connexion_Bienvenue();
		zeTuteur.messages_But_Introduction();
		zeTuteur.messages_Regle_Introduction();
		zeTuteur.messages_Hypothese_Introduction();
		zeTuteur.messages_Strat1_Introduction();
	}
	
	
	
}
