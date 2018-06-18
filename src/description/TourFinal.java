package description;

import partie.Pert;
import partie.Realisation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * La classe qui permet de jouer le tour final durant lequel les score sont calculés.
 * Elle stock les scores dans une hashmap aillant pour clée le nom de l'équipe, cette ashmap est déclarée static afin de
 * garder le scores des joueurs en mémoire directement dans la classe.
 * Notez bien que le tour final ne fais appelle qu'au calcule de date au plus tôt du Pert pour obtenir les scores, toute
 * autre méthode relative au Pert devra être appellé ensuite.
 *
 * @author mickael
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

    /**
     * Méthode qui contiens la formule de calcule des scores, elle arondi le score afin d'obtenir un nombre entier.
     * Si le score est négatif il est rammené à 0
     * @param nomEquipe
     * @param realisations
     * @param caisse
     * @param qualite
     */
    public void calculerScore(String nomEquipe, ArrayList<Realisation> realisations, int caisse, int qualite) {
        int score = Math.toIntExact(Math.round(((32 + (24 - dureeProjet(realisations)) * (caisse(caisse) + 20.0)) / 8000) * 100));
        score -= qualite(qualite);

        if (score < 0) {
            score = 0;
        }

        SCORES.put(nomEquipe, score);
    }

    /**
     * Méthode privé qui se sert du calcule de date au plus tot du Pert afin d'obtenir le temps mis par le joueur pour
     * réaliser le projet.
     * @param realisations
     * @return Le temps mis par le joueur pour terminer le projet
     */
    private int dureeProjet(ArrayList<Realisation> realisations) {
        Pert pert = new Pert(realisations);
        pert.calculDateAuPlusTot();

        return realisations.get(realisations.size() - 1).getDateAuPlusTot();
    }

    /**
     * Méthode qui se charge de retournmer un montant de caisse compris entre 0 et 200
     * @param caisse
     * @return montant compris entre 0 et 200
     */
    private int caisse(int caisse) {
        if (caisse > 200) {
            System.out.println(caisse);
            return 200;
        }
        else if(caisse < 0){
            return 0;
        }
        return caisse;
    }

    /**
     * Méthode qui calcule le pourcentage de baisse de qualité
     * @param qualite
     * @return le pourcentage de malus de qualité
     */
    private int qualite(int qualite) {
        return 100 - qualite;
    }

    /**
     * Méthode toString qui retourne une chaine contenant le nom et le score de chaque équipe
     * @return
     */
    public String toString() {
        StringBuilder chaine = new StringBuilder();

        for (Map.Entry<String, Integer> entree : SCORES.entrySet()){
            chaine.append("Equipe : ").append(entree.getKey()).append("\tScore : ").append(entree.getValue()).append("%\n");
        }

        return chaine.toString();
    }

}
