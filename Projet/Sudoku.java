
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Sudoku
{
	public static void main(String[] arg)
	{
		Sudoku sudo = new Sudoku();
	}
	
	
	Apprenant apprenant = new Apprenant();
	//Tuteur tuteur = new Tuteur();
	
	Case matriceSudoku[][] = new Case[9][9];
	Case matriceAffiche[][] = new Case[9][9];
	Case matrice[][] = new Case[9][9];
	
	ExpertSudoku expert;
	
	ArrayList<Coup> listeCoupStrat1 = new ArrayList<Coup>(); //liste des coup possibles en applicant la stratégie 1
	ArrayList<Coup> listeCoupStrat2 = new ArrayList<Coup>(); //liste des coup possibles en applicant la stratégie 2
	ArrayList<Coup> listeCoupStrat3 = new ArrayList<Coup>(); //liste des coup possibles en applicant la stratégie 3
	
	ArrayList<Coup> listErreurCoup = new ArrayList<Coup>();
	ArrayList<Coup> listErreurHypo = new ArrayList<Coup>();
	
	Interface inter;
	
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
		
		//expert = new ExpertSudoku( ConvertToTabInt(matriceSudoku));
		inter = new Interface();
		inter.show();
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
		
		listeCoupStrat1 = (ArrayList<Coup>)expert.getCoupPossible(1);
		listeCoupStrat2 = (ArrayList<Coup>)expert.getCoupPossible(2);
		listeCoupStrat3 = (ArrayList<Coup>)expert.getCoupPossible(3);
	}
	
	public void AjoutHypotheseMat(int ligne, int colonne, int numero)//Ajout d'une hypothèse par l'utilisateur
	{
		matriceSudoku[ligne][colonne].tabHypo[numero - 1] = true;
	}
	
	public void RetirerHypotheseMat(int ligne, int colonne, int numero)//Retrait d'une hypothèse par l'utilisateur
	{
		matriceSudoku[ligne][colonne].tabHypo[numero - 1] = false;
	}
	
	public void AjoutChiffreMat(int ligne, int colonne, int numero)//Ajout d'un chiffre dans la matrice
	{
		matriceSudoku[ligne][colonne].chiffre = numero;
	}
	
	public void RetraitChiffreMat(int ligne, int colonne)//Retrait d'un chiffre dans la matrice
	{
		matriceSudoku[ligne][colonne].chiffre = 0;
	}
	
	public void JouerCoup(int ligne, int colonne, int region, int  numero)
	{
		if(matriceSudoku[ligne][colonne].CaseRemplie())//on vérifie si la case n'est pas déjà remplie
		{
			Coup coup = new Coup(ligne, colonne, numero);
			int CoupPossible = expert.jouerValeur(coup); 
			
			
			switch (CoupPossible)
			{
			case -2 ://reponse fausse
				apprenant.AddFail(0);
				listErreurCoup.add(coup);
				break;
				
			case -1://réponse bonne mais impossible d'identifier les stratégies
				apprenant.AddRandom();
				break;
			
			case 0://strat 1
				apprenant.AddSuccess(0);
				break;
			
			case 1://strat 2
				apprenant.AddSuccess(1);
				break;
				
			default:
				break;
			}
			
			AjoutChiffreMat(ligne, colonne, numero);
		}
		
		
	}
	
	public void RetirerHypothese(int ligne, int colonne, int region, int  numero)
	{				
		Coup coup = new Coup(ligne, colonne, numero);
		int CoupPossible = expert.retirerPossibilite(coup);
		
		switch (CoupPossible)
		{
		case -2 ://reponse fausse
			apprenant.AddFail(1);
			listErreurHypo.add(coup);
			break;
			
		case -1://réponse bonne mais impossible d'identifier les stratégies
			apprenant.AddRandom();
			break;
		
		case 0://strat 1
			apprenant.AddSuccess(2);
			break;
		
		case 1://strat 2
			apprenant.AddSuccess(3);
			break;
			
		default:
			break;
		}
		
		RetirerHypotheseMat(ligne, colonne, numero);
	}
	
	public void RetirerCoup(int ligne, int colonne, int region, int  numero)
	{
		Coup coup = new Coup(ligne, colonne, numero);
		
		listErreurCoup.remove(coup);
		
		RetraitChiffreMat(ligne, colonne);
	}
	
	public void RemettreHypothèse(int ligne, int colonne, int region, int  numero)
	{
		Coup coup = new Coup(ligne, colonne, numero);
		listErreurHypo.remove(coup);
		AjoutHypotheseMat(ligne, colonne, numero);
	}
	
	public int GetNbErreuCoup()
	{
		return listErreurCoup.size();
	}
	
	public int GetNbErreuHypo()
	{
		return listErreurHypo.size();
	}
	
	public void ClearErreurs()
	{
		listErreurCoup.clear();
		listErreurHypo.clear();
	}
}