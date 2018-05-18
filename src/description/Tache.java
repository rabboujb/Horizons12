package description;

/**
 * Classe qui représente une tache
 *
 * @author Equipe Horizon12
 */
public class Tache {

    private final int ID;
    private final String NOM;
    private final int COUT;
    private final int SEMAINES;
    private final int SEMAINES_MAX;

    private final Alea ROUGE;
    private final Alea JAUNE;
    private final Alea VERT;

    private final int PREDECESSEUR;
    private final int SUCCESSEUR;

    public Tache(int id, String nom, int cout, int semaines, int semaineMax, Alea rouge, Alea jaune, Alea vert,
                 int predecesseur, int successeur) {

        this.ID = id;
        this.NOM = nom;
        this.COUT = cout;
        this.SEMAINES = semaines;
        this.SEMAINES_MAX = semaineMax;
        this.ROUGE = rouge;
        this.JAUNE = jaune;
        this.VERT = vert;
        this.PREDECESSEUR = predecesseur;
        this.SUCCESSEUR = successeur;
    }

    /**
     * Retourne l'Alea corespondant à la couleur passée en paramètre
     * @param couleur
     * @return un Alea
     */
    public Alea getAlea(Couleur couleur) {
        if (couleur.equals(ROUGE)) {
            return ROUGE;
        }
        else if (couleur.equals(JAUNE)) {
            return JAUNE;
        }
        return VERT;
    }

    /**
     * Retourne l'Id de la tache
     * @return ID
     */
    public int getID() {
        return ID;
    }

    public String getNOM() {
        return NOM;
    }

    /**
     * Retourne le coute d'acceleration de la tache
     * @return COUT
     */
    public int getCOUT() {
        return COUT;
    }

    /**
     * Retourne le nombre de semaine par défaut de la tache
     * @return SEMAINES
     */
    public int getSEMAINES() {
        return SEMAINES;
    }

    /**
     * Retourne le nombre de semaines maximum que peut durer la tache
     * @return SEMAINES_MAX
     */
    public int getSEMAINES_MAX() {
        return SEMAINES_MAX;
    }

    /**
     * Retourne l'Id de la tache précédente
     * @return PREDECESSEUR
     */
    public int getPREDECESSEUR() {
        return PREDECESSEUR;
    }

    /**
     * Retourne la tache suivante
     * @return SUCCESSEUR
     */
    public int getSUCCESSEUR() {
        return SUCCESSEUR;
    }

    /**
     * Retourne une description de la tache et de ses aléas (en se servant du toString de ceux-ci)
     * @return DescriptionObsolete de la tache
     */
    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append("Id : ").append(ID)
                .append("\nNom : ").append(NOM)
                .append("\nSemaines : ").append(SEMAINES)
                .append("\n").append(ROUGE)
                .append("\n").append(JAUNE)
                .append("\n").append(VERT);

        return chaine.toString();
    }
}
