package essai;

import description.Description;
import description.Tache;
import partie.Realisation;

import java.util.ArrayList;

public class EssaiAlgoOrdonnance {
    ArrayList<Realisation>realisationsTriees;

    public EssaiAlgoOrdonnance(){

        // Ce code permet de créer une ArrayList de Realisations à des fin de test
        Description description = new Description();
        ArrayList<Realisation>realisations = new ArrayList<>();
        for (Tache tache : description.getPlateau()) {
            realisations.add(new Realisation(tache));
        }

        realisationsTriees = new ArrayList<>();
        trieOrdonnance(realisations);
    }

    /**
     * Méthode qui ordonnance les réalisations, elle prend une ArrayList de réalisations en paramètre, et agit
     * directement sur realisationsTriees
     * @param realisations
     * @return ArrayList de réalisations ordonnancé
     */
    private void trieOrdonnance(ArrayList<Realisation> realisations){
        while (realisations.size() != realisationsTriees.size()){
            for (Realisation realisation : realisations){
                if (realisation.getPredecesseurs().isEmpty() || controlePredecesseurs(realisation)){
                    realisationsTriees.add(realisation);
                    // System.out.println(realisation.getIdTache());
                }
            }
        }
    }

    /**
     * Méthode qui est utile à trieOrdonnance, elle vérifie si une réalisation à encore des prédécesseurs non traité, et
     * renvoie false dans ce cas, et true si tout ces prédécesseurs ont été traités
     * @param realisation
     * @return un boolean
     */
    private boolean controlePredecesseurs(Realisation realisation){
        System.out.println("Appel");
        for (Integer idPredecesseur : realisation.getPredecesseurs()){
            System.out.println("Boucle 1");
            for (Realisation realisationTriee : realisationsTriees){
                System.out.println("Boucle 2");
                if (idPredecesseur.intValue() == realisation.getIdTache()){
                    System.out.println("IF");
                    System.out.println(idPredecesseur + "<>" + realisation.getIdTache() );
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<Realisation> getRealisationsTriees(){
        return realisationsTriees;
    }

    public static void main(String[] args) {
        EssaiAlgoOrdonnance test = new EssaiAlgoOrdonnance();
        for (Realisation realisation : test.getRealisationsTriees()){
            System.out.println(realisation.getIdTache());
        }
    }
}
