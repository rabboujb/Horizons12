/**
 * @author Bilal RABBOUJ
 */
package essai;
import partie.Equipes;
import partie.VueJoueur;
import strategie.Robot;
import java.util.Scanner;

public class EssaiEtapeStrategie {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	    Robot monRobot = new Robot();
	    Equipes Horizons12 = new Equipes("Horizons12");

	    monRobot.jouerJalon(Horizons12);

   		Horizons12.depense(10);
   		Horizons12.baisseQualite(2);

   	    monRobot.jouerJalon(Horizons12);
    }
}
