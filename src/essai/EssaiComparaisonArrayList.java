package essai;

import description.Description;
import description.Tache;
import partie.Realisation;

import java.util.ArrayList;

/**
 * Un simple essai de comparaison de deux ArrayList de réalisations, utile pour l'algo de trie ordonnancé
 *
 * @author mickael
 */

public class EssaiComparaisonArrayList {
    public static void main(String[] args) {
        Description description = new Description();
        ArrayList<Realisation> rea1 = new ArrayList<>();
        ArrayList<Realisation> rea2 = new ArrayList<>();
        ArrayList<Realisation> rea3 = new ArrayList<>();

        // Remplissage Rea1
        for (Tache tache : description.getPlateau()) {
            rea1.add(new Realisation(tache));
        }

        // Remplissage partiel de rea2
        for (Realisation realisation : rea1){
            if (realisation.getIdTache() %2 == 0)
                rea2.add(realisation);
        }

        // Remplissage de rea3
        for (Realisation realisation : rea1){
            rea3.add(realisation);
        }

        System.out.println(rea2.containsAll(rea1));
        System.out.println(rea3.containsAll(rea1));
    }
}
