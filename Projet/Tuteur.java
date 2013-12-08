package sudoku;

public class Tuteur 
{
	private static String nom_STI = "SudokuSmartTutor";
	private static String nom_Auteur1 = "Gilles Godefroid";
	private static String nom_Auteur2 = "Ludovic Lefebvre";
	private static String nom_Auteur3 = "Jules Mozes";
	private static String nom_Auteur4 = "Maxime Turmel";
	
	private static String message_Connexion_Bienvenue = "Bienvenue sur "+nom_STI+"! Le systeme tutoriel intelligent pour apprendre au joueur au Sudoku !";
	private static String message_Connexion_Auteurs = nom_STI+" a ete realise par "+nom_Auteur1+", "+nom_Auteur2+", "+nom_Auteur3+" et "+nom_Auteur4+" dans le cadre du cours de maitrise INF7470 a l'UQAM.";
	private static String message_Connexion_ButDuJeu = "Le but du jeu du Sudoku est de completer la grille en remplissant chaque case par un chiffre compris entre 1 et 9, de maniere a ce que les regles de bases soient satisfaites.";
	
	private static String message_Regle_Introduction = "Voici les regles de bases.";
	private static String message_Regle_Rappel = "Rappel des regles de bases.";
	private static String message_Regle_Grille = "La grille du Sudoku est composee de 81 cases reparties en un carre. On peut la diviser en 9 colonnes, 9 lignes ou 9 region carre.";
	private static String message_Regle_Colonne = "Un chiffre dans une case satisfait la regle de la colonne si aucun autre meme chiffre ne se trouve dans la colonne de la case en question.";
	private static String message_Regle_Ligne = "Un chiffre dans une case satisfait la regle de la ligne si aucun autre meme chiffre ne se trouve dans la ligne de la case en question.";
	private static String message_Regle_Region = "Un chiffre dans une case satisfait la regle de la region si aucun autre meme chiffre ne se trouve dans la region de la case en question.";
	
	private static String message_Hypotheses_Introduction = "Voici le principe de fonctionnement des hypotheses.";
	private static String message_Hypotheses_Definition = "Si un chiffre satisfait presentement les trois regles de bases dans une case, ce chiffre est une hypothese pour cette case.";
	private static String message_Hypotheses_Remarque1 = "Il peut exister plusieurs hypotheses pour chaque cases selon l'etat actuel de la grille.";
	private static String message_Hypotheses_Remarque2 = "Une hypothese dans une case n'est pas forcement la valeur definitive que doit prendre cette case. Pour se faire, il faut proceder a des verifications plus poussees.";
	private static String message_Hypotheses_Conseil1 = "Il est judicieux d'ecrire chaque hypothese trouvee au brouillon pour ne pas les oublier...";
	private static String message_Hypotheses_Conseil2 = "Un moyen pour commencer est de chercher des hypotheses dans les cases dont les colonnes, lignes ou regions correspondantes semblent le plus remplies...";
	private static String message_Hypotheses_Application1 = "Il s'agit trouver toutes les hypotheses pour une case d'abord puis de faire cela pour le plus grand nombre de case possible !";
	private static String message_Hypothses_Application2 = "Lorsque la premiere strategie est applicable, il faut l'appliquer avant de continuer a chercher d'autres hypotheses !";
	
	private static String message_Strat1_Introduction = "Voici le principe de la premiere strategie dite de l'hypothese seule.";
	private static String message_Strat1_Definition = "Si dans une case se trouve une et une seule hypothese, alors cette hypothese est la valeur definitive de cette case.";
	private static String message_Strat1_Remarque1 = "Cette strategie est a appliquer des que possible.";
	private static String message_Strat1_Remarque2 = "Avec un peu d'experience, cette strategie peut s'appliquer sans utiliser les hypotheses, mais necessite un bon coup d'oeil et une bonne memoire !";
	private static String message_Strat1_Conseil ="Si toutes les hypotheses sont inscrites, il est facile de detecter visuellement oe cette strategie peut etre appliquee...";
	private static String message_Strat1_Application1 = "Il s'agit de s'assurer que tous les chiffres ne sont pas des hypotheses sauf un seul avant d'ecrire la valeur definitif !";
	private static String message_Strat1_Application2 = "Il ne faut pas oublier d'eliminer les hypotheses ne le sont plus dans la grille a la suite de l'application de cette strategie !";
	
	private static String message_Strat2_Introduction = "";
	private static String message_Strat2_Definition = "";
	private static String message_Strat2_Remarque1 = "";
	private static String message_Strat2_Remarque2 = "";
	private static String message_Strat2_Conseil = "";
	private static String message_Strat2_Application1 = "";
	private static String message_Strat2_Application2 = "";
	
}
