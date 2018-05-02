package essai;

import partie.Jalon;
import partie.Semaine;
import partie.Tour;

import java.util.ArrayList;
import java.util.List;

public class EssaiTours {

    public static void main(String[] args) {
        List<Tour> tours = new ArrayList<>();
        tours.add(new Jalon(1));
        tours.add(new Semaine(2));

        for (Tour tour : tours){
            if (tour instanceof Jalon){
                Jalon jalon = (Jalon)tour;
                jalon.methodeJalon();
            }
            else {
                Semaine semaine = (Semaine)tour;
                semaine.methodeSemaine();
            }
        }
    }
}
