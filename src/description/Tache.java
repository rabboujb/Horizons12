package description;

public class Tache {

    private final int ID;
    private final String NOM;
    private final int COUT;
    private final int SEMAINES;
    private final int SEMAINES_REEL;

    private final Alea ROUGE;
    private final Alea JAUNE;
    private final Alea VERT;

    private final int PREDECESSEUR;
    private final int SUCCESSEUR;

    public Tache(int id,
                 String nom,
                 int cout,
                 int semaines,
//                 int semainesReel,
                 Alea rouge,
                 Alea jaune,
                 Alea vert,
                 int predecesseur,
                 int successeur) {

        this.ID = id;
        this.NOM = nom;
        this.COUT = cout;
        this.SEMAINES = semaines;
//        this.SEMAINES_REEL = semainesReel;
        this.ROUGE = rouge;
        this.JAUNE = jaune;
        this.VERT = vert;
        this.PREDECESSEUR = predecesseur;
        this.SUCCESSEUR = successeur;
    }

    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append("Id : ").append(ID)
                .append("\nNom : ").append(NOM)
                .append("\nSemaines : ").append(SEMAINES)
                .append("\n").append(ROUGE)
                .append("\n").append(JAUNE)
                .append("\n").append(VERT);
    }
}
