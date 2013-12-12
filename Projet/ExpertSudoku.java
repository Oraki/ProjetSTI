
import jess.*;

/**
 * Expert du dommaine du sudoku
 * @author Tunel
 */
public class ExpertSudoku {

    private int[][] puzzle;
    private int[][] solution;
    private int[][][][] posibilite;
    private jess.Rete moteur;

    /**
     * Constructeur de l'expert
     *
     * @param puzzle La grille de valeur, où 0 (zéro) représente une case vide.
     */
    public ExpertSudoku(int[][] puzzle) {
        this.puzzle = puzzle;
        this.moteur = new Rete();
    }

    /**
     * Enregistre une nouvelle valeur par l'utilisateur.
     * S'il y a une erreur, soit une vrai erreur ou une valeur qui n'est pas en 
     * accord avec une stratégie, la valeur n'est pas intégé à la grille.
     * 
     * @param ligne coprdonnée de la case
     * @param colonne coordonnée de la case
     * @param valeur valeur mit par l'utilisateur
     * @return un objet qui contient la réponse au coup
     */
    public ReponseCoup jouerValeur(int ligne, int colonne, short valeur) {

        return null;
    }
    
    /**
     * Trouve les erreurs d'hypotheses 
     * 
     * @param grille La grille de toutes les valeurs possibles selon l'utilisateur
     * où la première dimention représente la ligne, 2e la colonne et 3e la valeur
     * possible.
     * @return La liste des positions où il y a une erreur d'hypothese, où la
     * première dimention représente chaque erreur, la deuxième-premier indique
     * la ligne, 2e indice, la collone, 3e, la stratégie probablement mal appliquée.
     */
    public int[][] verifierHypothese(int[][][] grille){
        return null;
    }
    
    /**
     * Pour obtenir la solution d'une case
     * 
     * @param ligne 
     * @param colonne
     * @return la valeur de la soltion
     */
    public int getSolution(int ligne, int colonne){
        return solution[ligne][colonne];
    }
}
