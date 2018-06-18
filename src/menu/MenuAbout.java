package menu;
import java.io.*;
import java.net.URL;

public class MenuAbout {

	/**
	 * Constructeur de la classe MenuAbout
	 * Affichage des auteurs, liens vers le dépôt et les ressources du projet
	 */
	public MenuAbout() {
	}

	/**
	 * Crédits, auteurs
	 */
	public void about() {
		StringBuilder chaine = new StringBuilder();

		chaine.append("========================== À PROPOS ========================")
		.append("\n||                                                        ||")
		.append("\n|| > Projet de S2 : Horizon                               ||")
		.append("\n|| Version stable - 1.0                                   ||")
		.append("\n||                                                        ||")
		.append("\n|| > Développement                                        ||")
		.append("\n|| Du 18 avril 2018 au 13 juin 2018                       ||")
		.append("\n||                                                        ||")
		.append("\n|| > Auteurs                                              ||")
		.append("\n|| Bilal RABBOUJ                                          ||")
		.append("\n|| Ismérie PERROT                                         ||")
		.append("\n|| Mickaël SPILMONT                                       ||")
		.append("\n|| Abdoulaye DIALLO                                       ||")
		.append("\n||                                                        ||")
		.append("\n============================================================");

		System.out.println(chaine);
	}

	/**
	 * Liens, ressources
	 */
	public void presentationJeu() {
		try {
			URL pageProjet = new URL("http://moodle.univ-lille1.fr/course/view.php?id=6443");
			URL gitProjet = new URL("https://github.com/rabboujb/Horizons12");

			System.out.println("||                                                        ||");
            System.out.println("|| > Ressources du projet : (Connexion requise)           ||");
            System.out.println("||"+pageProjet.toString()+"    ||");
			System.out.println("||                                                        ||");
            System.out.println("|| > Dépôt du projet :                                    ||");
            System.out.println("||"+gitProjet.toString()+"                  ||");
			System.out.println("||                                                        ||");
			System.out.println("============================================================");
			System.out.println();
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
}
