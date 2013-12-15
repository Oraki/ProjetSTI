
import java.util.List;
import jess.*;

/**
 * Expert du dommaine du sudoku
 *
 * @author Tunel
 */
public class ExpertSudoku {

    private int[][] puzzle;
    private int[][] solution;
    private int[][][][] posibilite;
    private jess.Rete moteur;
    private final List<Coup>[] coupPossible;
    private Coup dernierCoup;

    /**
     * Constructeur de l'expert
     *
     * @param puzzle La grille de valeur, où 0 (zéro) représente une case vide.
     */
    public ExpertSudoku(int[][] puzzle) {
        this.puzzle = puzzle;
        this.moteur = new Rete();
        coupPossible = new List[3];
    }

    /**
     * Enregistre une nouvelle valeur par l'utilisateur. S'il y a une erreur,
     * soit une vrai erreur ou une valeur qui n'est pas en accord avec une
     * stratégie, la valeur n'est pas intégé à la grille.
     *
     * @param c le coup du joueur
     * @return si le cout est la bonne réponce
     */
    public boolean jouerValeur(Coup c) {

        return false;
    }

    /**
     * La liste des couts suvants possibles pour une stratégie
     *
     * @param strategie le numéro de la stratégie
     * @return La liste de coup possible pour cette stratégie
     */
    public List<Coup> getCoupPossible(int strategie) {
        return coupPossible[strategie];
    }

    /**
     * Trouve les erreurs d'hypotheses
     *
     * @param grille La grille de toutes les valeurs possibles selon
     * l'utilisateur où la première dimention représente la ligne, 2e la colonne
     * et 3e la valeur possible.
     * @return La liste des positions où il y a une erreur d'hypothese, où la
     * première dimention représente chaque erreur, la deuxième-premier indique
     * la ligne, 2e indice, la collone, 3e, la stratégie probablement mal
     * appliquée.
     */
    public int[][] verifierHypothese(int[][][] grille) {
        return null;
    }

    /**
     * Pour obtenir la solution d'une case
     *
     * @param ligne
     * @param colonne
     * @return la valeur de la soltion
     */
    public int getSolution(int ligne, int colonne) {
        return solution[ligne][colonne];
    }

    /**
     * Trouve quelles stratégies peuvent avoir été utilisé.
     *
     * @return Un tableau d'indicateur pour chaque stratégie si elle a été
     * potentiellement
     */
    public boolean[] getStrategie() {
        boolean[] rep = new boolean[coupPossible.length];

        for (int i = 0; i < coupPossible.length; ++i) {
            rep[i] = coupPossible[i].contains(dernierCoup);
        }
        return rep;
    }

}
