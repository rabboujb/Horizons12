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

        // Le même avec des Integers
        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            list0.add(i);
            list1.add(i);
            if (i % 2 == 0) {
                list2.add(i);
            }
        }

        System.out.println(list1.containsAll(list0));
        System.out.println(list2.containsAll(list0));
    }
}
