
import java.util.LinkedList;
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
    private Deftemplate dtValeur;
    private Deftemplate dtTrouve;
    private Deftemplate dtPoss;
    private final List<Coup>[] coupPossible;
    private Coup dernierCoup;
    private static final String[] STRATEGIES = {
        "(defrule eliminerPossi "
        + "?f <-(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
        + "(valeur (ligne ?x2) (col ?y2) (zone ?z2) (is ?v))"
        + "(test (or (eq ?x2 ?x) (eq ?z2 ?z) (eq ?y2 ?y))) "
        + "=> "
        + "(retract ?f)) "
        + "(defrule strategie "
        + "?f <- (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
        + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v2&:(neq ?v2 ?v)))) "
        + "=> "
        //+ "(assert (valeurTrouve (ligne ?x) (col ?y) (is ?v))) "
        + "(call (fetch EXPERT) ajouterCoup ?x ?y 0 ?v) "
        + "(retract ?f) "
        + ")"
    };

    /**
     * Constructeur de l'expert
     *
     * @param puzzle La grille de valeur, où 0 (zéro) représente une case vide.
     */
    public ExpertSudoku(int[][] puzzle) {
        this.puzzle = puzzle;
        this.moteur = new Rete();
        coupPossible = new List[STRATEGIES.length];
        for (int i = 0; i < coupPossible.length; ++i) {
            coupPossible[i] = new LinkedList<>();
        }
        trouverCout();
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

    private void definirTemplate() throws JessException {
        dtValeur = new Deftemplate("valeur", "une valeur dans le puzzle", moteur);
        Value zero = new Value(0, RU.INTEGER);
        dtValeur.addSlot("ligne", zero, "NUMBER");
        dtValeur.addSlot("col", zero, "NUMBER");
        dtValeur.addSlot("zone", zero, "NUMBER");
        dtValeur.addSlot("is", zero, "NUMBER");
        moteur.addDeftemplate(dtValeur);

        dtPoss = new Deftemplate("possibilite", "une possibilité de valeur", moteur);
        dtPoss.addSlot("ligne", zero, "NUMBER");
        dtPoss.addSlot("col", zero, "NUMBER");
        dtPoss.addSlot("zone", zero, "NUMBER");
        dtPoss.addSlot("is", zero, "NUMBER");
        moteur.addDeftemplate(dtPoss);

        dtTrouve = new Deftemplate("valeurTrouve", "une valeur trouvé dans le puzzle selon un strategie", moteur);
        dtTrouve.addSlot("ligne", zero, "NUMBER");
        dtTrouve.addSlot("col", zero, "NUMBER");
        dtTrouve.addSlot("is", zero, "NUMBER");
        moteur.addDeftemplate(dtTrouve);

        // moteur.defclass("expert", "ExpertSudoku", null);
    }

    private void ajouterPuzzleDansJess() throws JessException {
        moteur.store("EXPERT", this);

        for (int i = 0; i < puzzle.length; ++i) {
            for (int j = 0; j < puzzle[i].length; ++j) {
                if (puzzle[i][j] != 0) {
                    Fact f = new Fact(dtValeur);
                    f.setSlotValue("ligne", new Value(j, RU.INTEGER));
                    f.setSlotValue("col", new Value(i, RU.INTEGER));
                    f.setSlotValue("zone", new Value(i / 3 + (j / 3) * 3, RU.INTEGER));
                    f.setSlotValue("is", new Value(puzzle[i][j], RU.INTEGER));
                    moteur.assertFact(f);
                } else {
                    for (int k = 1; k <= 9; ++k) {
                        Fact f = new Fact(dtPoss);
                        f.setSlotValue("ligne", new Value(j, RU.INTEGER));
                        f.setSlotValue("col", new Value(i, RU.INTEGER));
                        f.setSlotValue("zone", new Value(i / 3 + (j / 3) * 3, RU.INTEGER));
                        f.setSlotValue("is", new Value(k, RU.INTEGER));
                        moteur.assertFact(f);
                    }
                }
            }
        }
    }

    public void ajouterCoup(int ligne, int col, int strat, int val) {
        coupPossible[strat].add(new Coup(ligne, col, val));
    }

    private void trouverCout() {
        try {
            for (int i = 0; i < STRATEGIES.length; ++i) {
                moteur.reset();
                definirTemplate();
                moteur.executeCommand(STRATEGIES[i]);
                ajouterPuzzleDansJess();
                moteur.run();
            }
        } catch (JessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] a) {
        int[][] g = new int[9][9];
        g[0][0] = 0;
        g[0][1] = 0;
        g[0][2] = 0;
        g[0][3] = 0;
        g[0][4] = 7;
        g[0][5] = 0;
        g[0][6] = 0;
        g[0][7] = 5;
        g[0][8] = 0;
        g[1][0] = 9;
        g[1][1] = 0;
        g[1][2] = 0;
        g[1][3] = 4;
        g[1][4] = 2;
        g[1][5] = 1;
        g[1][6] = 7;
        g[1][7] = 0;
        g[1][8] = 3;
        g[2][0] = 0;
        g[2][1] = 4;
        g[2][2] = 6;
        g[2][3] = 5;
        g[2][4] = 0;
        g[2][5] = 0;
        g[2][6] = 0;
        g[2][7] = 8;
        g[2][8] = 2;
        g[3][0] = 0;
        g[3][1] = 7;
        g[3][2] = 0;
        g[3][3] = 8;
        g[3][4] = 0;
        g[3][5] = 0;
        g[3][6] = 0;
        g[3][7] = 9;
        g[3][8] = 0;
        g[4][0] = 0;
        g[4][1] = 0;
        g[4][2] = 5;
        g[4][3] = 9;
        g[4][4] = 0;
        g[4][5] = 3;
        g[4][6] = 6;
        g[4][7] = 0;
        g[4][8] = 0;
        g[5][0] = 0;
        g[5][1] = 6;
        g[5][2] = 0;
        g[5][3] = 0;
        g[5][4] = 0;
        g[5][5] = 7;
        g[5][6] = 0;
        g[5][7] = 4;
        g[5][8] = 0;
        g[6][0] = 1;
        g[6][1] = 2;
        g[6][2] = 0;
        g[6][3] = 0;
        g[6][4] = 0;
        g[6][5] = 5;
        g[6][6] = 9;
        g[6][7] = 7;
        g[6][8] = 0;
        g[7][0] = 6;
        g[7][1] = 0;
        g[7][2] = 7;
        g[7][3] = 1;
        g[7][4] = 9;
        g[7][5] = 4;
        g[7][6] = 0;
        g[7][7] = 0;
        g[7][8] = 5;
        g[8][0] = 0;
        g[8][1] = 9;
        g[8][2] = 0;
        g[8][3] = 0;
        g[8][4] = 6;
        g[8][5] = 0;
        g[8][6] = 0;
        g[8][7] = 0;
        g[8][8] = 0;

        ExpertSudoku es = new ExpertSudoku(g);
    }
}
