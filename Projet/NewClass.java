
import java.util.List;

public class NewClass {

    ExpertSudoku ex = new ExpertSudoku(null);
    List<Coup> erreurs;
    int expertise;

    public void f(Coup c) {
        int strat = ex.jouerValeur(c);
        expertise = ajusterExpertise(strat);
        if (strat == -2) {
            erreurs.add(c);
            if (seuil(expertise) < erreurs.size()) {
                afficherErreur(expertise);
            }
        }
    }
}
