package essai;

import description.Couleur;
import description.Description;
import description.Tache;
import description.TypeAlea;
import partie.Pert;
import partie.Realisation;

import java.util.ArrayList;

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

        // ArrayList de réalisations pour Ismérie, n'oublie pas de créer la description avant
        ArrayList<Realisation> realisations = new ArrayList<>();

        for (Tache tache : description.getPlateau()) {
            realisations.add(new Realisation(tache));
        }

        // petit test pour voir si l'ArrayList fonctionne
        for (Realisation real : realisations) {
            System.out.println(realisation);
            System.out.println(realisation.getDateAuPlusTard());
            System.out.println(realisation.getDateAuPlusTot());
        }
        
        Pert pert = new Pert(realisations);
       // pert.construitAlpha(realisations);
        //pert.construitOmega(realisations);
		//on calcul les temps au plus tot pour chaque tache
		System.out.println("=== CALCUL DES CHEMINS AU PLUS TOT ===");
		pert.calculDateAuPlusTot();
		pert.calculDateAuPlusTard();
		pert.afficheDates();

		//on obtient le chemin critique une fois que se calcul est fait
		System.out.println();
		System.out.println("=== CALCUL DU CHEMIN CRITIQUE ===");
		pert.afficheCheminCritique();
		
    }
}
