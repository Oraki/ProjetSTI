
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Sudoku
{
	Apprenant apprenant = new Apprenant();
	Tuteur tuteur = new Tuteur();
	
	Case matriceSudoku[][] = new Case[9][9];
	Case matriceAffiche[][] = new Case[9][9];
	Case matrice[][] = new Case[9][9];
	
	List listeCoupStrat1 = new LinkedList(); //liste des coup possibles en applicant la stratégie 1
	List listeCoupStrat2 = new LinkedList(); //liste des coup possibles en applicant la stratégie 2
	List listeCoupStrat3 = new LinkedList(); //liste des coup possibles en applicant la stratégie 3
	
	public Sudoku()
	{
		for(int i = 0; i<9; i++)
		{
			for(int j = 0; j<9; j++)
			{
				matriceSudoku[i][j] = new Case();	
				matriceAffiche[i][j] = new Case();
			}
		}		
	}
	
	public boolean CheckValiditeDuCoup(Coup coup)
	{
		return true;
	}
	
	public void MAJCoupPossible()//Mise  jour des listes des coups possible
	{
		listeCoupStrat1.clear();
		listeCoupStrat2.clear();
		listeCoupStrat3.clear();
	}
	
	public void AddHypo(int ligne, int colonne, int numero)//Ajout d'une hypothèse par l'utilisateur
	{
		matriceSudoku[ligne][colonne].tabHypo[numero - 1] = true;
	}
	
	public void RemoveHypo(int ligne, int colonne, int numero)//Retrait d'une hypothèse par l'utilisateur
	{
		matriceSudoku[ligne][colonne].tabHypo[numero - 1] = false;
	}
	
	public void JouerCoup(int ligne, int colonne, int region, int  numero)
	{
		if(matriceSudoku[ligne][colonne].CaseRemplie())//on vérifie si la case n'est pas déjà remplie
		{
			return;
		}
		
		
	}
}