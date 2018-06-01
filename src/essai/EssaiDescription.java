package essai;

import description.Couleur;
import description.Description;
import description.Tache;
import description.Tour;

import java.util.ArrayList;

/**
 * @author Mickael
 */
public class EssaiDescription {

    public static void main(String[] args) {

//        Création d'une nouvelle description
        Description description = new Description();

//        test de la méthode get plateau
        System.out.println("\n################## getPlateau ##################\n");

        ArrayList<Tache> plateau = description.getPlateau();

        for (Tache tache : plateau) {
            System.out.println(tache);
        }

//        test de la méthode getTache
        System.out.println("\n################## getTache ##################\n");

        System.out.println(description.getTache(0));
        System.out.println(description.getTache(4));
        System.out.println(description.getTache(7));
        System.out.println(description.getTache(8));
        System.out.println(description.getTache(-1));

//        test de la méthode getTacheById
        System.out.println("\n################## getTacheById ##################\n");

        System.out.println(description.getTacheById(0));
        System.out.println(description.getTacheById(4));
        System.out.println(description.getTacheById(7));
        System.out.println(description.getTacheById(8));
        System.out.println(description.getTacheById(-1));

//        test de la méthode getTours, il s'agit d'un simple test d'affichage, pour utiliser les méthodes spécifiques à
//        chaque type de tour il faut effectuer un force-cast (voir comment faire sur EssaiTour)
        System.out.println("\n################## getTours ##################\n");

        ArrayList<Tour> tours = description.getTours();

        for (Tour tour : tours) {
            System.out.println(tour);
        }

//        test de la méthode getTour
        System.out.println("\n################## getTour ##################\n");

        System.out.println(description.getTour(0));
        System.out.println(description.getTour(4));
        System.out.println(description.getTour(9));
        System.out.println(description.getTour(10));
        System.out.println(description.getTour(-1));

//        test Divers
        System.out.println("\n################## Divers ##################\n");

        System.out.println(description.getTacheById(1).getAlea(Couleur.ORANGE));
        System.out.println(description.getTacheById(4).getCOUT());
        System.out.println(description.getTacheById(7).getCOUT());
    }
}
