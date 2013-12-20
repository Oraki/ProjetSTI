
import java.util.ArrayList;

public class Sudoku
{
	public static void main(String[] arg)
	{
		Sudoku sudo = new Sudoku();
	}
	
	
	Apprenant apprenant = new Apprenant();
	ExpertSudoku expert;
	Tuteur tuteur = new Tuteur(this);
	Grille grille;
	
	Case matriceSudoku[][] = new Case[9][9];
	
	
	
	ArrayList<Coup> listeCoupStrat1 = new ArrayList<Coup>(); //liste des coup possibles en applicant la strat���gie 1
	ArrayList<Coup> listeCoupStrat2 = new ArrayList<Coup>(); //liste des coup possibles en applicant la strat���gie 2
	ArrayList<Coup> listeCoupStrat3 = new ArrayList<Coup>(); //liste des coup possibles en applicant la strat���gie 3
	
	ArrayList<Coup> listErreurCoup = new ArrayList<Coup>();
	ArrayList<Coup> listErreurHypo = new ArrayList<Coup>();

    public Sudoku() {
    	
    	/*
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriceSudoku[i][j] = new Case();
                matriceAffiche[i][j] = new Case();
            }
        }*/
    	
    	 matriceSudoku =  GenererSudoku1(); 
    	 //expert = new ExpertSudoku(ConvertToTabInt(matriceSudoku));
    	 
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        final Sudoku fSudo = this;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                grille = new Grille(fSudo);
                grille.setVisible(true);
                grille.setPuzzle(ConvertToTabInt(matriceSudoku));
            }
        });
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
	
	public void AjoutHypotheseMat(int ligne, int colonne, int numero)//Ajout d'une hypoth���se par l'utilisateur
	{
		matriceSudoku[ligne][colonne].tabHypo[numero - 1] = true;
	}
	
	public void RetirerHypotheseMat(int ligne, int colonne, int numero)//Retrait d'une hypoth���se par l'utilisateur
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
	
	public void JouerCoup(int ligne, int colonne, int  numero)
	{
		
		if(!matriceSudoku[ligne][colonne].CaseRemplie())//on v���rifie si la case n'est pas d���j��� remplie
		{
			grille.ajouterMessage("Caca");
			Coup coup = new Coup(ligne, colonne, numero);
			int CoupPossible = expert.jouerValeur(coup); 
			
			switch (CoupPossible)
			{
			case -2 ://reponse fausse
				apprenant.AddFail(0);
				listErreurCoup.add(coup);
				tuteur.Message_Erreur();
				break;
				
			case -1://réponse bonne mais impossible d'identifier les stratégies
				apprenant.AddRandom();
				tuteur.Message_Hasard();
				break;
			
			case 0://strat 1
				apprenant.AddSuccess(0);
				tuteur.Message_Succes(1);
				tuteur.Message_Strategie();
				break;
			
			case 1://strat 2
				apprenant.AddSuccess(1);
				tuteur.Message_Succes(2);
				tuteur.Message_Strategie();
				break;
				
			default:
				break;
			}
			
			AjoutChiffreMat(ligne, colonne, numero);
		}
		
		
	}
	
	public void RetirerHypothese(int ligne, int colonne, int  numero)
	{				
		Coup coup = new Coup(ligne, colonne, numero);
		int CoupPossible = expert.retirerPossibilite(coup);
		
		switch (CoupPossible)
		{
		case -2 ://reponse fausse
			apprenant.AddFail(1);
			listErreurHypo.add(coup);
			tuteur.Message_Erreur();
			break;
			
		case -1://r���ponse bonne mais impossible d'identifier les strat���gies
			apprenant.AddRandom();
			tuteur.Message_Hasard();
			break;
		
		case 0://strat 1
			apprenant.AddSuccess(2);
			tuteur.Message_Succes(0);
			tuteur.Message_Strategie();
			break;
		
		case 1://strat 2
			apprenant.AddSuccess(3);
			tuteur.Message_Succes(3);
			tuteur.Message_Strategie();
			break;
			
		default:
			break;
		}
		
		RetirerHypotheseMat(ligne, colonne, numero);
	}
	
	public void RetirerCoup(int ligne, int colonne, int  numero)
	{
		Coup coup = new Coup(ligne, colonne, numero);
		
		listErreurCoup.remove(coup);
		
		RetraitChiffreMat(ligne, colonne);
	}
	
	public void RemettreHypothese(int ligne, int colonne, int  numero)
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
	
	
	//----------------------------------------------------------------------------
	
	public Case[][] GenererSudoku1()
	{
		Case tab[][] = new Case[9][9];
		
		for(int i = 0; i<9; i++)
		{
			for(int j = 0; j<9; j++)
			{
				tab[i][j] = new Case();
			}
		}	
		
		tab[0][3].chiffre = 1;
		tab[0][5].chiffre = 5;
		tab[1][0].chiffre = 1;
		tab[1][1].chiffre = 4;
		tab[1][6].chiffre = 6;
		tab[1][7].chiffre = 7;
		tab[2][1].chiffre = 8;
		tab[2][5].chiffre = 2;
		tab[2][6].chiffre = 4;
		tab[3][1].chiffre = 6;
		tab[3][2].chiffre = 3;
		tab[3][4].chiffre = 7;
		tab[3][7].chiffre = 1;
		tab[4][0].chiffre = 9;
		tab[4][8].chiffre = 3;
		tab[5][1].chiffre = 1;
		tab[5][4].chiffre = 9;
		tab[5][6].chiffre = 5;
		tab[5][7].chiffre = 2;
		tab[6][2].chiffre = 7;
		tab[6][3].chiffre = 2;
		tab[6][7].chiffre = 8;
		tab[7][1].chiffre = 2;
		tab[7][2].chiffre = 6;
		tab[7][7].chiffre = 3;
		tab[7][8].chiffre = 5;
		tab[8][3].chiffre = 4;
		tab[8][5].chiffre = 9;
		
		
		return tab;
		
	}
	
	public Case[][] GenererSudoku2()
	{
		Case tab[][] = new Case[9][9];
		
		for(int i = 0; i<9; i++)
		{
			for(int j = 0; j<9; j++)
			{
				tab[i][j] = new Case();
			}
		}	
		
		tab[0][5].chiffre = 4;
		tab[0][7].chiffre = 2;
		tab[0][8].chiffre = 8;
		tab[1][0].chiffre = 4;
		tab[1][2].chiffre = 6;
		tab[1][8].chiffre = 5;
		tab[2][0].chiffre = 1;
		tab[2][4].chiffre = 3;
		tab[2][6].chiffre = 6;
		tab[3][3].chiffre = 3;
		tab[3][5].chiffre = 1;
		tab[4][1].chiffre = 8;
		tab[4][2].chiffre = 7;
		tab[4][6].chiffre = 1;
		tab[4][7].chiffre = 4;
		tab[5][3].chiffre = 7;
		tab[5][5].chiffre = 9;
		tab[6][2].chiffre = 2;
		tab[6][4].chiffre = 1;
		tab[6][7].chiffre = 3;
		tab[7][0].chiffre = 9;
		tab[7][6].chiffre = 5;
		tab[7][8].chiffre = 7;
		tab[8][0].chiffre = 6;
		tab[8][1].chiffre = 7;
		tab[8][3].chiffre = 4;
		
		
		return tab;
		
	}

    public void afficherIndice() {
        tuteur.Message_Indice();
    }
}
