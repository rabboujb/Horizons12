package essai;
import description.Couleur;
import partie.VueEquipes;
import partie.VueJoueur;
import strategie.Robot;

import java.util.ArrayList;
import java.util.List;

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
	    Equipes.ajouterEquipe(new VueEquipes(EquipeA)); // 1 équipe - 1 vue
	    Equipes.ajouterEquipe(new VueEquipes(EquipeB)); // 1 équipe - 1 vue

//		for(int i=0;i<2;i++) {
			// Joue le jalon
			monRobot.jouerJalon(Equipes.getEquipe(EquipeA));
			monRobot.jouerJalon(Equipes.getEquipe(EquipeB));

			// Déroule le jalon
			monRobot.jouerEtape(Equipes.getEquipe(EquipeA));
			monRobot.jouerEtape(Equipes.getEquipe(EquipeB));
			// Joue le jalon
			monRobot.jouerJalon(Equipes.getEquipe(EquipeA));
			monRobot.jouerJalon(Equipes.getEquipe(EquipeB));

			// Déroule le jalon
			monRobot.jouerEtape(Equipes.getEquipe(EquipeA));
			monRobot.jouerEtape(Equipes.getEquipe(EquipeB));
//		}
    }
}