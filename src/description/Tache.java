package description;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe qui représente une tache
 *
 * @author Mickael, Ismerie
 */
public class Tache implements Serializable {

    private static int compteurId = 0;
    private final int ID;
    private final String NOM;
    private final int COUT;
    private final int SEMAINES;
    private final int SEMAINES_MAX;

    private final Alea ROUGE;
    private final Alea ORANGE;
    private final Alea VERT;

    private final ArrayList <Integer> PREDECESSEUR;
    private final ArrayList <Integer> SUCCESSEUR;

    public Tache(String nom, int cout, int semaines, int semaineMax, Alea rouge, Alea jaune, Alea vert,
    		ArrayList <Integer> predecesseur, ArrayList <Integer> successeur) {

        compteurId ++;
        this.ID = compteurId;
        this.NOM = nom;
        this.COUT = cout;
        this.SEMAINES = semaines;
        this.SEMAINES_MAX = semaineMax;
        this.ROUGE = rouge;
        this.ORANGE = jaune;
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
        if (couleur.equals(Couleur.ROUGE)) {
            return ROUGE;
        }
        else if (couleur.equals(Couleur.ORANGE)) {
            return ORANGE;
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
    public ArrayList <Integer> getPREDECESSEUR() {
        return PREDECESSEUR;
    }

    /**
     * Retourne la tache suivante
     * @return SUCCESSEUR
     */
    public ArrayList <Integer> getSUCCESSEUR() {
        return SUCCESSEUR;
    }

    /**
     * Ajout d'un successeur à la tâche 1
     * Ismerie
     */
    public void addSuccesseur(int idTache) {
    	SUCCESSEUR.add(idTache);
    }

    /**
     * Ajout d'un predecesseur à une tache
     * Ismerie
     */
    public void addPredecesseur(int idTache) {
    	PREDECESSEUR.add(idTache);
    }

    /**
     * Retourne une description de la tache et de ses aléas (en se servant du toString de ceux-ci)
     * @return DescriptionObsolete de la tache
     */
    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append("Id : ").append(ID)
                .append("\nNom : ").append(NOM)
                .append("\nCoût d'accélération : ").append(COUT).append(" €");
                if(SEMAINES == 1)
	                chaine.append("\nDurée initiale : ").append(SEMAINES).append(" semaine");
                else
	                chaine.append("\nDurée initiale : ").append(SEMAINES).append(" semaines");
	            chaine.append("\nDurée totale : ").append(SEMAINES_MAX).append(" semaines")
                .append("\n").append(ROUGE)
                .append("\n").append(ORANGE)
                .append("\n").append(VERT)
                .append("\n");

        return chaine.toString();
    }

    @Override
    public boolean equals(Object objet) {
        if (objet != null && objet instanceof Tache){
            return this.equals((Tache)objet);
        }
        return false;
    }

    /**
     * Méthode equals qui se sert de l'ID pour définir si il y'a égalité
     * @param tache
     * @return un boolean
     */
    public boolean equals(Tache tache) {
        if (this.ID == tache.ID) {
            return true;
        }
        return false;
    }
}
