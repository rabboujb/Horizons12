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
        tours.add(new TourJalon(0, TypeTour.JALON, new int[]{1, 2, 3, 4}));

        tours.add(new TourAlea(1, TypeTour.ALEA, 1));
        tours.add(new TourAlea(2, TypeTour.ALEA, 2));
        tours.add(new TourAlea(3, TypeTour.ALEA, 3));
        tours.add(new TourAlea(4, TypeTour.ALEA, 4));

        tours.add(new TourJalon(5, TypeTour.JALON, new int[]{5, 6, 7, 8}));

        tours.add(new TourAlea(6, TypeTour.ALEA, 5));
        tours.add(new TourAlea(7, TypeTour.ALEA, 6));
        tours.add(new TourAlea(8, TypeTour.ALEA, 7));
        tours.add(new TourAlea(9, TypeTour.ALEA, 8));

        // test des diférentes méthodes des tours, un force-cast est nécessaire
        for (Tour tour : tours) {

            if (tour instanceof TourJalon) {
                System.out.println(((TourJalon) tour).getIdTaches());
            }
            else {
                System.out.println(((TourAlea) tour).tirtage());
            }
        }
    }
}
