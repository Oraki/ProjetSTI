
import java.util.Iterator;
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
    private final boolean[][][] possibilites;
    private final int[][] solution;
    private final List<Coup>[] coupPossible;
    private final List<Coup>[] retraitPossible;

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
        coupPossible = new List[2];
        retraitPossible = new List[2];
        possibilites = new boolean[9][9][9];
        solution = new int[9][9];
        for (int i = 0; i < puzzle.length; ++i) {
            for (int j = 0; j < puzzle[i].length; ++j) {
                if (puzzle[i][j] == 0) {
                    for (int k = 0; k < possibilites[i][j].length; ++k) {
                        possibilites[i][j][k] = true;
                    }
                }
            }
        }
        try {
            trouverSolution();
            initialiserList();
            trouverCoups();
        } catch (JessException e) {
            e.printStackTrace();
        }
    }

    private void initialiserList() {
        for (int i = 0; i < coupPossible.length; ++i) {
            coupPossible[i] = new LinkedList<>();
        }
        for (int i = 0; i < retraitPossible.length; ++i) {
            retraitPossible[i] = new LinkedList<>();
        }
    }

    private void trouverSolution() throws JessException {
        System.out.println("*** Recherche de la solution ***");
        moteur.reset();
        definirTemplate();
        moteur.store("EXPERT", this);

        String rule = "(defrule sulution\n";
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                rule += "(possibilite (ligne " + i + ") (col " + j + ") (zone "
                        + (j / 3 + (i / 3) * 3) + ") (is ?v" + i + j + "&:(neq ?v"
                        + i + j;
                for (int k = 0; k < i; ++k) {
                    rule += " ?v" + k + j;
                }
                for (int k = 0; k < j; ++k) {
                    rule += " ?v" + i + k;
                }
                for (int k = 1; k <= i % 3; ++k) {
                    for (int l = 1; l <= j % 3; ++l) {
                        rule += " ?v" + (i - k) + (j - l);
                    }
                }
                rule += ")))\n";
            }
        }
        rule += "=>\n";
        rule += "(call (fetch EXPERT) solutionTrouve ";
        for (int i = 0; i < 9; ++i) {
            rule += "(create$";
            for (int j = 0; j < 9; ++j) {
                rule += " ?v" + i + j;
            }
            rule += ")";
        }
        rule += "))";
        moteur.executeCommand(rule);

        for (int i = 0; i < puzzle.length; ++i) {
            for (int j = 0; j < puzzle[i].length; ++j) {
                if (puzzle[i][j] != 0) {
                    Fact f = new Fact(dtPoss);
                    f.setSlotValue("ligne", new Value(i, RU.INTEGER));
                    f.setSlotValue("col", new Value(j, RU.INTEGER));
                    f.setSlotValue("zone", new Value(j / 3 + (i / 3) * 3, RU.INTEGER));
                    f.setSlotValue("is", new Value(puzzle[i][j], RU.INTEGER));
                    moteur.assertFact(f);
                } else {
                    for (int k = 1; k <= 9; ++k) {
                        Fact f = new Fact(dtPoss);
                        f.setSlotValue("ligne", new Value(i, RU.INTEGER));
                        f.setSlotValue("col", new Value(j, RU.INTEGER));
                        f.setSlotValue("zone", new Value(j / 3 + (i / 3) * 3, RU.INTEGER));
                        f.setSlotValue("is", new Value(k, RU.INTEGER));
                        moteur.assertFact(f);
                    }
                }
            }
        }
        moteur.run();
        System.out.println("*** Fin de la recherche ***");
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
            try {
                int strat = -1;
                for (int i = 0; i < coupPossible.length; ++i) {
                    if (coupPossible[i].contains(c)) {
                        strat = i;
                    }
                }

                puzzle[c.getLigne()][c.getColonne()] = c.getNumero();
                initialiserList();
                trouverCoups();

                return strat;
            } catch (JessException e) {
                e.printStackTrace();
                return -3;
            }
        }
    }

    /**
     * Enregistre le retrait d'une possibilité de valeur par l'utilisateur. S'il
     * y a une erreur, la valeur n'est pas intégé à la grille.
     *
     * @param c le coup du joueur
     * @return Si le retrait d'une valeur possible n'est la réponse de la case
     * et est compatible avec une stratégie, le numéro de la stratégie (>=0). Si
     * le retrait n'est la réponse de la case mais que la stratégie n'est pas
     * identifiable, -1. Si mauvause réponse, -2.
     */
    public int retirerPossibilite(Coup c) {
        if (c.getNumero() == solution[c.getLigne()][c.getColonne()]) {
            return -2;
        } else {
            try {
                int strat = -1;
                for (int i = 0; i < retraitPossible.length; ++i) {
                    if (retraitPossible[i].contains(c)) {
                        strat = i;
                    }
                }

                possibilites[c.getLigne()][c.getColonne()][c.getNumero() - 1] = false;
                initialiserList();
                trouverCoups();

                return strat;
            } catch (JessException e) {
                e.printStackTrace();
                return -3;
            }
        }
    }

    /**
     * Retire une valeur de l'utilisateur
     *
     * @param c le coup à retirer
     */
    public void retirerCoup(Coup c) {
        puzzle[c.getLigne()][c.getColonne()] = 0;
    }

    /**
     * Remet une valeur possible
     *
     * @param c le cout à remettre
     */
    public void remettrePossibilite(Coup c) {
        possibilites[c.getLigne()][c.getColonne()][c.getNumero() - 1] = true;
    }

    /**
     * La liste des couts suivants possibles pour une stratégie
     *
     * @param strategie le numéro de la stratégie
     * @return La liste de coup possible pour cette stratégie
     */
    public List<Coup> getCoupPossible(int strategie) {
        return coupPossible[strategie];
    }

    public List<Coup> getRetraitHypothesePossible(int strategie) {
        return retraitPossible[strategie];
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
                    f.setSlotValue("zone", new Value(j / 3 + (i / 3) * 3, RU.INTEGER));
                    f.setSlotValue("is", new Value(puzzle[i][j], RU.INTEGER));
                    moteur.assertFact(f);
                } else {
                    for (int k = 0; k < 9; ++k) {
                        if (possibilites[i][j][k]) {
                            Fact f = new Fact(dtPoss);
                            f.setSlotValue("ligne", new Value(i, RU.INTEGER));
                            f.setSlotValue("col", new Value(j, RU.INTEGER));
                            f.setSlotValue("zone", new Value(j / 3 + (i / 3) * 3, RU.INTEGER));
                            f.setSlotValue("is", new Value(k + 1, RU.INTEGER));
                            moteur.assertFact(f);
                        }
                    }
                }
            }
        }
    }

    /**
     * Fonction pour communiquer avec Jess. Ne pas utiiliser.
     *
     * @param ligne
     * @param col
     * @param val
     * @param strat
     */
    public void ajouterCoup(int ligne, int col, int val, int strat) {
        assert (solution[ligne][col] == val);
        Coup c = new Coup(ligne, col, val);
        if (!coupPossible[strat].contains(c)) {
            coupPossible[strat].add(c);
        }
    }

    /**
     * Fonction pour communiquer avec Jess. Ne pas utiiliser.
     *
     * @param ligne
     * @param col
     * @param val
     * @param strat
     */
    public void retirerPossibilite(int ligne, int col, int val, int strat) {
        //assert (solution[ligne][col] != val);
        Coup c = new Coup(ligne, col, val);
        if (!retraitPossible[strat].contains(c)) {
            retraitPossible[strat].add(c);
        }
    }

    /**
     * Fonction pour communiquer avec Jess. Ne pas utiiliser.
     *
     * @param l0
     * @param l1
     * @param l2
     * @param l3
     * @param l4
     * @param l5
     * @param l6
     * @param l7
     * @param l8
     */
    public void solutionTrouve(int[] l0, int[] l1, int[] l2, int[] l3,
            int[] l4, int[] l5, int[] l6, int[] l7, int[] l8) {
        solution[0] = l0;
        solution[1] = l1;
        solution[2] = l2;
        solution[3] = l3;
        solution[4] = l4;
        solution[5] = l5;
        solution[6] = l6;
        solution[7] = l7;
        solution[8] = l8;
    }

    private void trouverCoups() throws JessException {
        //Stratégie #0 (Retrait hypothese)
        moteur.clear();
        definirTemplate();
        ajouterPuzzleDansJess();
        moteur.executeCommand("(defrule eliminerPossi "
                + "?f <-(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                + "(valeur (ligne ?x2) (col ?y2) (zone ?z2) (is ?v))"
                + "(test (or (eq ?x2 ?x) (eq ?z2 ?z) (eq ?y2 ?y))) "
                + "=> "
                + "(call (fetch EXPERT) retirerPossibilite ?x ?y ?v 0) "
                + "(retract ?f)) ");
        moteur.run();

        //Stratégie #1 (Coup)
        moteur.executeCommand("(defrule strategie1 "
                + "?f <- (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                + "(or (not (possibilite (ligne ?x) (col ?y2&:(neq ?y2 ?y)) (is ?v))) "
                + "(not (possibilite (ligne ?x2&:(neq ?x2 ?x)) (col ?y) (is ?v))) "
                + "(not (and (possibilite (ligne ?x2) (col ?y2) (zone ?z) (is ?v)) "
                + "(test (not (and (eq ?x2 ?x) (eq ?y2 ?y))))))) "
                + "=> "
                + "(call (fetch EXPERT) ajouterCoup ?x ?y ?v 1) "
                + ")");
        moteur.run();

        //Stratégie #0 (Coup)
        moteur.clear();
        definirTemplate();
        moteur.executeCommand("(defrule elimPos "
                + "?f <- (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                + "(valeur (ligne ?x2) (col ?y2) (zone ?z2) (is ?v))"
                + "(test (or (eq ?x2 ?x) (eq ?z2 ?z) (eq ?y2 ?y))) "
                + "=> "
                + "(retract ?f)) ");
        moteur.executeCommand("(defrule strategie0 "
                + "?f <- (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v2&:(neq ?v2 ?v)))) "
                + "=> "
                + "(call (fetch EXPERT) ajouterCoup ?x ?y ?v 0) "
                + ")");
        ajouterPuzzleDansJess();
        moteur.run();

        //Stratégie #1 (Retrait hypothese)
        moteur.executeCommand("(defrule insertitude "
                + "(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v)) "
                + "(possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v2&:(neq ?v2 ?v))) "
                + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v3&:(neq ?v3 ?v ?v2)))) "
                + "(possibilite (ligne ?x2) (col ?y2) (zone ?z2) (is ?v)) "
                + "(test (or (eq ?x ?x2) (eq ?y2 ?y) (eq ?z2 ?z)))"
                + "(possibilite (ligne ?x2) (col ?y2) (zone ?z2) (is ?v2)) "
                + "(not (possibilite (ligne ?x) (col ?y) (zone ?z) (is ?v4&:(neq ?v4 ?v ?v2)))) "
                + "(possibilite (ligne ?x3) (ligne ?y3) (zone ?z3) (is ?v5&:(or (eq ?v5 ?v) (eq ?v5 ?v2)))) "
                + "(test (or (eq ?x ?x3) (eq ?y3 ?y) (eq ?z3 ?z))) "
                + "=> "
                + "(call (fetch EXPERT) retirerPossibilite ?x3 ?y3 ?v5 1) "
                + ")");

        moteur.run();
    }

    private int getIndiceMax(int[] tab) {
        int max = Integer.MIN_VALUE;
        int ind = -1;

        for (int i = 0; i < tab.length; ++i) {
            if (tab[i] > max) {
                max = tab[i];
                ind = i;
            }
        }
        return ind;
    }

    /**
     * Trouve une zone qui est itéressante à jouer. Une zone étant le carré de 9
     * cases du sudoku
     *
     * @return le numéro de la zone
     */
    public int zoneAJouer() {
        int[] cmpt = new int[9];

        for (int i = 0; i < coupPossible.length; ++i) {
            Iterator<Coup> it = coupPossible[i].iterator();
            while (it.hasNext()) {
                ++cmpt[it.next().getRegion()];
            }
        }

        return getIndiceMax(cmpt);
    }

    /**
     * Trouve une région qui est itéressante à jouer.
     *
     * @return 0 pour la gauche du puzzle, 1 pour la droite, 2, le haut, 3 le
     * bas ou 4 pour la zone du centre.
     */
    public int regionAJouer() {
        int[] cmpt = new int[5];

        for (int i = 0; i < coupPossible.length; ++i) {
            Iterator<Coup> it = coupPossible[i].iterator();
            while (it.hasNext()) {
                int z = it.next().getRegion();
                if (z == 4) {
                    ++cmpt[4];
                } else {
                    if (z % 3 == 0) {
                        ++cmpt[0];
                    } else if (z % 3 == 2) {
                        ++cmpt[1];
                    }
                    if (z < 3) {
                        ++cmpt[2];
                    } else if (z >= 6) {
                        ++cmpt[3];
                    }
                }
            }
        }

        return getIndiceMax(cmpt);
    }

    /**
     * Trouve une valeur qui peut être mit dans le tableau.
     *
     * @return Un coup possible. Si le puzzle est fini, null.
     */
    public Coup coupAJoueur() {
        if (!coupPossible[0].isEmpty()) {
            return coupPossible[0].get(0);
        } else if (!coupPossible[1].isEmpty()) {
            return coupPossible[1].get(0);
        } else {
            for (int i = 0; i < solution.length; ++i) {
                for (int j = 0; j < solution[i].length; ++j) {
                    if (puzzle[i][j] == 0) {
                        return new Coup(i, j, solution[i][j]);
                    }
                }
            }
            return null;
        }
    }

    /**
     * Vérifie si le puzzle est complèté
     *
     * @return true, si complèté, false, sinon.
     */
    public boolean puzzleComplete() {
        for (int i = 0; i < solution.length; ++i) {
            for (int j = 0; j < solution[i].length; ++j) {
                if (puzzle[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Main de test
     *
     * @param a
     */
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
        System.out.println("Fin");
    }
}
