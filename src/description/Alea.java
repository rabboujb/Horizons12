package description;

public class Alea {

    private final TypeAlea TYPE;
    private final Couleur COULEUR;
    private final int GRAVITE;
    private final String NOM;

    public Alea(TypeAlea type, Couleur couleur, int gravite, String nom) {
        this.TYPE = type;
        this.COULEUR = couleur;
        this.GRAVITE = gravite;
        this.NOM = nom;
    }

    public TypeAlea getTYPE() {
        return TYPE;
    }

    public Couleur getCOULEUR() {
        return COULEUR;
    }

    public int getGRAVITE() {
        return GRAVITE;
    }

    public String getNOM() {
        return NOM;
    }

    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append(COULEUR).append(" : ").append(TYPE).append("\t").append(GRAVITE).append("\t").append(NOM);
        return chaine.toString();
    }
}
