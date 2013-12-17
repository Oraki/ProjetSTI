
import java.util.LinkedList;
import java.util.List;
import jess.*;

/**
 * Expert du dommaine du sudoku
 *
 * @author Tunel
 */
public class ExpertSudoku {

    private final int[][] puzzle;
    private int[][] solution;
    private final List<Coup>[] coupPossible;

    //***  Objet Jess ***//
    private final jess.Rete moteur;
    private Deftemplate dtValeur;
    private Deftemplate dtPoss;

    /**
     * Constructeur de l'expert
     *
     * @param puzzle La grille de valeur, où 0 (zéro) représente une case vide.
     */
    public ExpertSudoku(int[][] puzzle) {
        this.puzzle = puzzle;
        this.moteur = new Rete();
        coupPossible = new List[3];
        initialiserList();
        trouverCoups();
    }

    private void initialiserList() {
        for (int i = 0; i < coupPossible.length; ++i) {
            coupPossible[i] = new LinkedList<>();
        }
    }

    /**
     * Enregistre une nouvelle valeur par l'utilisateur. S'il y a une erreur, la
     * valeur n'est pas intégé à la grille.
     *
     * @param c le coup du joueur
     * @return Si le coup est la bonne réponse et compatible avec une stratégie,
     * le numéro de la stratégie (>=0). Si le coup est la bonne réponse mais
     * sans stratégie, -1. Si mauvause réponse, -2.
     */
    public int jouerValeur(Coup c) {
        if (c.getNumero() != solution[c.getLigne()][c.getColonne()]) {
            return -2;
        } else {
            puzzle[c.getLigne()][c.getColonne()] = c.getNumero();
            initialiserList();
            trouverCoups();

            int strat = -1;
            for (int i = 0; i < coupPossible.length; ++i) {
                if (coupPossible[i].contains(c)) {
                    strat = i;
                }
            }
            return strat;
        }
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
     * Pour obtenir la solution d'une case
     *
     * @param ligne
     * @param colonne
     * @return la valeur de la soltion
     */
    public int getSolution(int ligne, int colonne) {
        return solution[ligne][colonne];
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
    }

    private void ajouterPuzzleDansJess() throws JessException {
        moteur.store("EXPERT", this);

        for (int i = 0; i < puzzle.length; ++i) {
            for (int j = 0; j < puzzle[i].length; ++j) {
                if (puzzle[i][j] != 0) {
                    Fact f = new Fact(dtValeur);
                    f.setSlotValue("ligne", new Value(i, RU.INTEGER));
                    f.setSlotValue("col", new Value(j, RU.INTEGER));
                    f.setSlotValue("zone", new Value(i / 3 + (j / 3) * 3, RU.INTEGER));
                    f.setSlotValue("is", new Value(puzzle[i][j], RU.INTEGER));
                    moteur.assertFact(f);
                } else {
                    for (int k = 1; k <= 9; ++k) {
                        Fact f = new Fact(dtPoss);
                        f.setSlotValue("ligne", new Value(i, RU.INTEGER));
                        f.setSlotValue("col", new Value(j, RU.INTEGER));
                        f.setSlotValue("zone", new Value(i / 3 + (j / 3) * 3, RU.INTEGER));
                        f.setSlotValue("is", new Value(k, RU.INTEGER));
                        moteur.assertFact(f);
                    }
                }
            }
        }
    }

    /**
     * Fonction pour Jess. Ne pas utiiliser.
     *
     * @param ligne
     * @param col
     * @param val
     * @param strat
     */
    public void ajouterCoup(int ligne, int col, int val, int strat) {
        coupPossible[strat].add(new Coup(ligne, col, val));
    }

    private void trouverCoups() {
        try {
            moteur.reset();
            definirTemplate();

            //Stratégie #0 (Retrait hypothese)
            moteur.executeCommand("(defrule eliminerPossi "
                    + "?f <-(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                    + "(valeur (ligne ?x2) (col ?y2) (zone ?z2) (is ?v))"
                    + "(test (or (eq ?x2 ?x) (eq ?z2 ?z) (eq ?y2 ?y))) "
                    + "=> "
                    + "(retract ?f)) ");

            //Stratégie #1 (Retrait hypothese)
            moteur.executeCommand("(defrule insertitude "
                    + "(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                    + "(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v2&:(neq ?v2 ?v))) "
                    + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v3&:(neq ?v3 ?v ?v2)))) "
                    + "(possibilite (ligne ?x2) (col ?y2) (zone ?z2) (is ?v)) "
                    + "(test (or (eq ?x ?x2) (eq ?y2 ?y) (eq ?z2 ?z)))"
                    + "(possibilite (ligne ?x2) (col ?y2) (zone ?z2) (is ?v2)) "
                    + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v4&:(neq ?v4 ?v ?v2)))) "
                    + "?f <- (possibilite (ligne ?x3) (ligne ?y3) (zone ?z3) (is ?v5&:(or (eq ?v5 ?v) (eq ?v5 ?v2)))) "
                    + "(test (or (eq ?x ?x3) (eq ?y3 ?y) (eq ?z3 ?z))) "
                    + "=> "
                    + "(retract ?f)"
                    + ")");

            //Stratégie #0 (Coup)
            moteur.executeCommand("(defrule strategie0 "
                    + "?f <- (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                    + "(or (not (possibilite (ligne ?x) (col ?y2&:(neq ?y2 ?y)) (is ?v))) "
                    + "(not (possibilite (ligne ?x2&:(neq ?x2 ?x)) (col ?y) (is ?v))) "
                    + "(not (and (possibilite (ligne ?x2) (col ?y2) (zone ?z) (is ?v)) "
                    + "(test (not (and (eq ?x2 ?x) (eq ?y2 ?y))))))) "
                    + "=> "
                    + "(call (fetch EXPERT) ajouterCoup ?x ?y ?v 0) "
                    + "(retract ?f)"
                    + ")");

            //Stratégie #1 (Coup)
            moteur.executeCommand("(defrule strategie1 "
                    + "?f <- (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                    + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v2&:(neq ?v2 ?v)))) "
                    + "=> "
                    + "(call (fetch EXPERT) ajouterCoup ?x ?y ?v 1) "
                    + "(retract ?f) "
                    + ")");

            //Stratégie #2 (Retrait hypothese)
            moteur.executeCommand("(defrule insertitude "
                    + "(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                    + "(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v2&:(neq ?v2 ?v))) "
                    + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v3&:(neq ?v3 ?v ?v2)))) "
                    + "(possibilite (ligne ?x2) (col ?y2) (zone ?z2) (is ?v)) "
                    + "(test (or (eq ?x ?x2) (eq ?y2 ?y) (eq ?z2 ?z)))"
                    + "(possibilite (ligne ?x2) (col ?y2) (zone ?z2) (is ?v2)) "
                    + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v4&:(neq ?v4 ?v ?v2)))) "
                    + "?f <- (possibilite (ligne ?x3) (ligne ?y3) (zone ?z3) (is ?v5&:(or (eq ?v5 ?v) (eq ?v5 ?v2)))) "
                    + "(test (or (eq ?x ?x3) (eq ?y3 ?y) (eq ?z3 ?z))) "
                    + "=> "
                    + "(retract ?f)"
                    + ")");
            ajouterPuzzleDansJess();
            moteur.run();
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
