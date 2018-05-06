package essai;
import partie.VueEquipes;
import strategie.Robot;
import menu.*;

/**
 * @author Bilal RABBOUJ
 */

public class EssaiEtapeStrategie {
    public static void main(String[] args) {
        String EquipeA = "Horizons12";
        String EquipeB = "IA";

	    Robot monRobot = new Robot();
	    VueEquipes Horizons12 = new VueEquipes(EquipeA);
	    VueEquipes IA = new VueEquipes(EquipeB);

		Horizons12.getEquipes();
		Menu menu = new Menu(Horizons12);
		menu.menuLancement();
    }
}
