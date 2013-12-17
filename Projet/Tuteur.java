package sudoku;

public class Tuteur 
{
	private String texteTuteur ="";

	
	private static String message_Connexion_Bienvenue = "Bienvenue sur SudokuSmartTutor, le systeme tutoriel intelligent pour apprendre a jouer au Sudoku !";
	private static String message_Connexion_Interface = "L'interface de SudokuSmartTutor te permet d'eliminer des hypotheses (ecrites en petites) a l'aide du clic droit sur une case. Tu peux aussi jouer un coup pour entrer une valeur definitive (ecrite en gros) a l'aide du clic gauche. Si tu es bloque, tu peux demander de l'aide avec le bouton Indice.";
	
	private static String message_Principe_Introduction = "Voici le principe de base du jeu du Sudoku :";
	private static String message_Principe_But = "Le but du jeu du Sudoku est de completer la grille, divisee en 9 lignes, 9 colonnes et 9 regions, en remplissant chaque case par un chiffre compris entre 1 et 9, de maniere a ce que les regles de bases soient satisfaites.";
	private static String message_Principe_Regles = "Un chiffre dans une case satisfait la regle de la colonne si aucun autre meme chiffre ne se trouve dans la colonne de la case en question. Il en va de meme avec la regle de la ligne et la regle de la region.";
	
	private static String message_Hypotheses_Introduction = "Voici le principe de fonctionnement des hypotheses.";
	private static String message_Hypotheses_Definition = "Un chiffre est une hypothese pour une case si ce chiffre satisfait les trois regles de bases dans cette case. Il peut y avoir plusieurs hypotheses par cases.";
	private static String message_Hypotheses_Conseil = "Il est pertinant de chercher e eliminer les hypotheses dans les cases dont la colonne, la ligne ou la region correspondante est le moins vide... Tu as plus de chance de pouvoir y appliquer des strategies par la suite !";
	
	private static String message_Strat1_Introduction = "Voici le principe de la premiere strategie dite de l'hypothese seule visible.";
	private static String message_Strat1_Definition = "Une hypothese est la valeur definitive dans une case si dans cette case se trouve cette hypothese et elle seule.";
	private static String message_Strat1_Conseil = "Tu dois appliquer la premiere strategie des que tu constates que c'est possible avant de continuer a chercher d'autres hypotheses... Et n'oublies pas de mettre a jour tes hypotheses en consequence !";
	
	private static String message_Strat2_Introduction = "Voici le principe de la deuxieme strategie dite de l'hypothese seule cachee.";
	private static String message_Strat2_Definition = "Une hypothese est la valeur definitive dans une case si cette hypothese ne se trouve pas dans la colonne, la ligne ou la region de cette case.";
	private static String message_Strat2_Conseil = "Applique la deuxieme strategie des que tu constates que c'est possible ou bien des que la premiere n'est plus applicable... Tu dois alors te concentrer d'avantage sur les hypotheses !";
	
	private static String message_Strat3_Introduction ="";
	private static String message_Strat3_Definition ="";
	private static String message_Strat3_Conseil ="";
	
	private static String message_Erreur_1 = "Attention ! Tu as fait 1 erreur. Tu peux l'apercevoir en rouge sur la grille.";
	private static String message_Erreur_2 = "Prends garde ! Tu as fait 2 erreurs. Tu peux les apercevoir en rouge sur la grille.";
	private static String message_Erreur_3 = "Misericorde ! Tu as fait 3 erreurs. Tu peux les apercevoir en rouge sur la grille.";
	private static String message_Erreur_4 = "Doux Jesus ! Tu as fait 3 erreurs. Je te laisse soin de les corriger...";



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
	
	public void messages_Hypothese_Introduction()
	{
		MAJTexteTuteur(message_Hypotheses_Introduction);
		
		MAJTexteTuteur(message_Hypotheses_Definition);
		
		MAJTexteTuteur(message_Hypotheses_Conseil);
		
		MAJTexteTuteur("\n");
	}
	
	public void messages_Strat1_Introduction()
	{
		MAJTexteTuteur(message_Strat1_Introduction);
		
		MAJTexteTuteur(message_Strat1_Definition);
		
		MAJTexteTuteur(message_Strat1_Conseil);
		
		MAJTexteTuteur("\n");
	}
	
	public static void main(String[] args)
	{
		Tuteur zeTuteur = new Tuteur();
		zeTuteur.messages_Connexion_Bienvenue();
		zeTuteur.messages_But_Introduction();
		zeTuteur.messages_Hypothese_Introduction();
		zeTuteur.messages_Strat1_Introduction();
	}
	
	
	
}
