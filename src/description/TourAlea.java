package description;

/**
 * Classe représentant un tour semaine, elle est liée à une tâche et permet de tirer un lancer de dé
 *
 * @author mickael
 */
public class TourAlea extends Tour {

    /**
     * Id de la tâche concernée par le tirage
     */
    private int idTache;

    public TourAlea(int numero, TypeTour type, int idTache) {
        super(numero, type);
        this.idTache = idTache;
    }

    /**
     * Retourne l'ID de la tâche concernée par ce tour Aléa
     * @return
     */
    public int getIdTache() {
        return idTache;
    }

    /**
     * Permet de retourner un tirage de dé
     * @return une couleur aléatoire
     */
    public Couleur tirage() {
        return Couleur.tirage();
    }

    @Override
    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append(super.toString()).append(" concernant la tâche ").append(idTache);

        return chaine.toString();
    }
}