package essai;

import description.Description;
import description.Tache;
import partie.Pert;
import partie.Realisation;

import java.util.ArrayList;

public class EssaiAlgoOrdonnance {

    public static void main(String[] args) {
//        Préparation de l'arrayList de réalisation
        Description description = new Description();
        ArrayList<Realisation> realisations = new ArrayList<>();

        for (Tache tache : description.getPlateau()) {
            realisations.add(new Realisation(tache));
        }

//        Création du pert
        Pert pert = new Pert(realisations);

        pert.trieTopologique();
    }
}
