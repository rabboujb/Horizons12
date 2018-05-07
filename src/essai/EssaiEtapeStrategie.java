package essai;
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
	    // Création de l'ArrayList contenant les équipes
	    VueJoueur Equipes = new VueEquipes();

		// Création de l'équipe A et B et ajout dans l'ArrayList
	    Equipes.ajouterEquipe(new VueEquipes(EquipeA));
	    Equipes.ajouterEquipe(new VueEquipes(EquipeB));

		monRobot.jouerJalon(Equipes);

    }
}