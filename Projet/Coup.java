
public class Coup {

    private final int ligne;
    private final int colonne;
    private final int region;
    private final int numero;

    public Coup(int ligne, int colonne, int numero) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.region = colonne / 3 + (ligne / 3) * 3;
        this.numero = numero;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public int getRegion() {
        return region;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.ligne;
        hash = 71 * hash + this.colonne;
        hash = 71 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Coup other = (Coup) obj;
        if (this.ligne != other.ligne || this.colonne != other.colonne
                || this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coup{" + "ligne=" + ligne + ", colonne=" + colonne + ", region=" + region + ", numero=" + numero + '}';
    }
}
