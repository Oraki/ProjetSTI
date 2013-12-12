
import java.util.List;

/**
 * Informations généré par l'expert suite à un coup du joueur
 *
 * @author Tunel
 */
public class ReponseCoup {

    private final List<Coup>[] coupPossible;
    private final boolean valide;
    private final Coup coup;

    /**
     * Constructeur
     *
     * @param coupPossible la liste des coups possibles par strategie
     * @param valide si le coup joué est valide
     * @param coup le coup du joueur
     */
    public ReponseCoup(List<Coup>[] coupPossible, boolean valide, Coup coup) {
        this.coupPossible = coupPossible;
        this.valide = valide;
        this.coup = coup;
    }

    /**
     * La liste des couts suvants possibles pour une stratégie
     *
     * @param strategie le numéro de la stratégie
     * @return La liste de coup possible pour cette stratégie
     */
    public List getCoupPossible(int strategie) {
        return coupPossible[strategie];
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
            rep[i] = coupPossible[i].contains(coup);
        }
        return rep;
    }

    /**
     * Vérifie si le coup est bon.
     *
     * @return si le coup est bon.
     */
    public boolean isValide() {
        return valide;
    }

}
