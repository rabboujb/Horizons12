package essai;
import description.Description;
import description.Tour;
import description.TypeTour;
import partie.Equipes;
import partie.VueEquipes;
import partie.VueJoueur;
import strategie.Robot;

/**
 * @author Bilal RABBOUJ
 */

public class EssaiEtapeStrategie {
    public static void main(String[] args) {
        String EquipeA = "Horizons12";
        String EquipeB = "IA";

		// Création de l'IHM ou Robot
	    Robot monRobot = new Robot();
	    Description description = new Description();

		VueJoueur equipes = new VueEquipes();

	    equipes.ajouterEquipe(new VueEquipes(EquipeA, description));
	    equipes.ajouterEquipe(new VueEquipes(EquipeB, description));

//			monRobot.jouerJalon(equipeB);
		for(int i=0;i<2;i++) {
//			// Joue le jalon
			monRobot.jouerJalon(equipes.getEquipe(EquipeA));
			monRobot.jouerJalon(equipes.getEquipe(EquipeB));

//			// Déroule le jalon
			monRobot.jouerEtape(equipes.getEquipe(EquipeA));
			monRobot.jouerEtape(equipes.getEquipe(EquipeB));
	}
    }
}