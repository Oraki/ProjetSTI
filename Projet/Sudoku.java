
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
	
	ExpertSudoku expert;
	
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
		
		expert = new ExpertSudoku( ConvertToTabInt(matriceSudoku));
	}
	
	private int[][] ConvertToTabInt(Case[][] tab)
	{
		int[][] tabTemp = new int[9][9];
		
		for(int i = 0; i<9; i++)
		{
			for(int j = 0; j<9; j++)
			{
				if (tab[i][j].CaseRemplie())
				{
					tabTemp[i][j] = tab[i][j].chiffre;
				}
				
				else
				{
					tabTemp[i][j] = 0;
				}
					
			}
		}
		
		return tabTemp;  
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
		
		listeCoupStrat1 = expert.getCoupPossible(1);
		listeCoupStrat2 = expert.getCoupPossible(2);
		listeCoupStrat3 = expert.getCoupPossible(3);
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
			Coup coup = new Coup(ligne, colonne, numero);
			boolean CoupPossible = expert.jouerValeur(new Coup(ligne, colonne, numero)); //Cette fonction check quoi? 
		}
		
		
	}
	
	public boolean VerifHypo()
	{
		//Savoir comment envoyer les cases déjà remplie.
		
		int[][][] tabTemp = new int[9][9][9];
		for(int i = 0; i<9; i++)
		{
			for(int j = 0; j<9; j++)
			{
				if(!matriceSudoku[i][j].CaseRemplie())
				{
					for(int k = 0; k < 9; k++)
					{
						if(matriceSudoku[i][j].tabHypo[k])
						{
							tabTemp[i][j][k] = 1;
						}
						else
						{
							tabTemp[i][j][k] = 0;
						}
					}
				}
				
				else
				{
					for(int k = 0; k < 9; k++)
					{
						tabTemp[i][j][k] = 0;
					}
				}
			}
		}	
		
		return true;
	}
}