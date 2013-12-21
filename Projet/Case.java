
public class Case {

    //chiffre définitif mis dans la case
    public int chiffre;
    //false le chiffre ne peut se trouver là
    public boolean tabHypo[] = new boolean[9]; 

    public Case() {
        chiffre = 0;

        for (int i = 0; i < 9; i++) {
            tabHypo[i] = false;
        }
    }

    public boolean CaseRemplie() {
        return (chiffre != 0);
    }
}
