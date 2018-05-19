package essai;

import description.Tour;
import description.TourJalon;
import description.TourAlea;
import description.TypeTour;

import java.util.ArrayList;

public class EssaiTour {

    public static void main(String[] args) {
        ArrayList<Tour> tours = new ArrayList<>();

        // Ajoput des tour dans l'arrayList de tours, notez qu'il est possible de passer un tableau en parametre pour les
        // tours Jalon sans le déclarer au préalable
        tours.add(new TourJalon(TypeTour.JALON, new int[]{1, 2, 3, 4}));

        tours.add(new TourAlea(TypeTour.ALEA, 1));
        tours.add(new TourAlea(TypeTour.ALEA, 2));
        tours.add(new TourAlea(TypeTour.ALEA, 3));
        tours.add(new TourAlea(TypeTour.ALEA, 4));

        tours.add(new TourJalon(TypeTour.JALON, new int[]{5, 6, 7, 8}));

        tours.add(new TourAlea(TypeTour.ALEA, 5));
        tours.add(new TourAlea(TypeTour.ALEA, 6));
        tours.add(new TourAlea(TypeTour.ALEA, 7));
        tours.add(new TourAlea(TypeTour.ALEA, 8));

        // test des diférentes méthodes des tours, un force-cast est nécessaire
        for (Tour tour : tours) {

            if (tour instanceof TourJalon) {
                System.out.println(tour);
                System.out.println(((TourJalon) tour).getIdTaches() + "\n"); // force-cast
            }
            else {
                System.out.println(tour);
                System.out.println(((TourAlea) tour).tirage());
                System.out.println(((TourAlea)tour).getIdTache() + "\n"); // force-cast
            }
        }
    }
}
