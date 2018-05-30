package essai;

import description.Couleur;
import description.Description;
import description.TypeAlea;
import partie.Realisation;

/**
 * Classe de test qui montre un exemple d'application d'aléa de type délai
 * 
 * @author Mickael
 */
public class EssaiRealisation2 {

    public static void main(String[] args) {
        Description description = new Description();
        Realisation realisation = new Realisation(description.getTacheById(3));

        // exemple d'application d'un alea de type delai (tirage rouge pour la tache trois dans l'exemple)
        Couleur tirage = Couleur.ROUGE;
        TypeAlea typeAlea = description.getTacheById(3).getAlea(tirage).getTYPE();
        int gravite = description.getTacheById(3).getAlea(tirage).getGRAVITE();

        if (typeAlea.equals(TypeAlea.DELAI)) {
            // bien sur dans le programme final les réalisation seront placées dans une ArrayList et encapsulé dans
            // donneesJoueur
            realisation.appliquerDelai(gravite);
        }
        else if (typeAlea.equals(TypeAlea.COUT)) {
            // diminuer la caisse du joueur
        }
        else {
            // diminuer la qualité
        }

        System.out.println(realisation);
    }
}
