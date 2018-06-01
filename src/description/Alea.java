package description;

/**
 * Classe représantant un Alea avec toutes les informations necessaires pour l'appliquer :
 *      Le type
 *      La couleur
 *      la gravité
 *      le nom
 *
 * @author Mickael
 */
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

    /**
     * Retourne le type de la tache
     * @return TYPE
     */
    public TypeAlea getTYPE() {
        return TYPE;
    }

    /**
     * Retourne la couleur de la tache
     * @return COULEUR
     */
    public Couleur getCOULEUR() {
        return COULEUR;
    }

    /**
     * Retourne la gravité de l'alea
     * @return GRAVITE
     */
    public int getGRAVITE() {
        return GRAVITE;
    }

    /**
     * Retourne le nom de la tache
     * @return NOM
     */
    public String getNOM() {
        return NOM;
    }

    /**
     * Retourne une description de l'Alea et de ses attributs
     * @return description
     */
    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append(COULEUR).append(" : ").append(TYPE).append("\t").append(GRAVITE).append("\t").append(NOM);
        return chaine.toString();
    }
}
