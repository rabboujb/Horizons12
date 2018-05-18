package essai;

import description.Description;
import description.Tache;

import java.util.ArrayList;

public class AssaiDescription {

    public static void main(String[] args) {
        Description description = new Description();

        ArrayList<Tache> plateau = description.getPlateau();

        for (Tache tache : plateau) {
            System.out.println(tache);
        }
    }
}
