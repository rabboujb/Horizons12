package description;

import partie.Pert;
import partie.Realisation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * La classe qui permet de jouer le tour final durant lequel les score sont calculés.
 * Elle stock les score dans une hashmap aillant pour clée le nom de l'équipe, cette ashmap est déclaré static afin de
 * garder le score des joueur sans recréer de TourFinal
 */
public class TourFinal extends Tour {
    private static HashMap<String, Integer> SCORES;

    /**
     * Constructeur de TourFinal
     */
    public TourFinal() {
        super(TypeTour.FINAL);
        SCORES = new HashMap<>();
    }

    private void calculerScore(String nomEquipe, ArrayList<Realisation> realisations, int caisse, int qualite) {
        int score = Math.round((32 + (24 - dureeProjet(realisations) * (caisse(caisse) + 20)) / 8000) - qualite(qualite));
        SCORES.put(nomEquipe, score);
    }

    private int dureeProjet(ArrayList<Realisation> realisations) {
        Pert pert = new Pert(realisations);
        pert.calculDateAuPlusTot();

        return realisations.get(realisations.size() - 1).getDateAuPlusTot();
    }

    private int caisse(int caisse) {
        if (caisse > 200) {
            return 200;
        }
        else if(caisse < 0){
            return 0;
        }
        return caisse;
    }

    private int qualite(int qualite) {
        return 100 - qualite;
    }

    public String toString() {
        StringBuilder chaine = new StringBuilder();

        for (Map.Entry<String, Integer> entree : SCORES.entrySet()){
            chaine.append("Equipe : ").append(entree.getKey()).append("\tScore : ").append(entree.getValue()).append("\n");
        }

        return chaine.toString();
    }

}
