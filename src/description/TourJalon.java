package description;

import description.Tour;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un tour Jalon, elle contient une liste d'id représentant les tâches concernées par ce jalon
 *
 * @author mickael
 */
public class TourJalon extends Tour {

    /**
     * Id des tâches qui sont concernées par le jalon
     */
    private ArrayList<Integer> idTaches;

    public TourJalon(int numero, TypeTour type, int idTaches[]) {
        super(numero, type);

        this.idTaches = new ArrayList<>();
        for (int id : idTaches) {
            this.idTaches.add(id);
        }
    }

    /**
     * Renvoi l'id des tâches concernées par le jalon sous forme d'arrayList
     * @return une arrayList d'Id de tâches
     */
    public List<Integer> getIdTaches() {
        return idTaches;
    }

    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append(super.toString()).append(" concernant les tâches :");

        for (int id : idTaches) {
            chaine.append(" ").append(id);
        }

        return chaine.toString();
    }
}
