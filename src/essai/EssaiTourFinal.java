package essai;

import description.Description;
import description.Tache;
import description.TourFinal;
import partie.Realisation;

import java.util.ArrayList;

/**
 * Classe d'essai de TourFinal
 *
 * @author mickael
 */
public class EssaiTourFinal {

    public static void main(String[] args) {
//        Préparation de l'arrayList de réalisation
        Description description = new Description();
        ArrayList<Realisation> realisations = new ArrayList<>();

        for (Tache tache : description.getPlateau()) {
            realisations.add(new Realisation(tache));
        }

        TourFinal tourFinal = new TourFinal();

        tourFinal.calculerScore("Les ChatontonFlingeurs", realisations, 200, 100);
        System.out.println(tourFinal);
    }
}
