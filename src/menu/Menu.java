package menu;
import description.Couleur;
import description.Description;
import description.TypeTour;
import partie.VueEquipes;
import strategie.Robot;
import java.util.Scanner;

/**
 *
 * @author diallo, Bilal RABBOUJ
 */
public class Menu {
    private Scanner sc = new Scanner(System.in);
	private VueEquipes equipes;
	private Description description;
    private MenuJeu mj;
    private MenuPartie mp;
    private Robot robot;
	private int affichageTour;

	public Menu() {
		robot = new Robot();
		equipes = new VueEquipes();
		description = new Description();
		affichageTour = 0;

		mj = new MenuJeu(equipes, description);
		mp = new MenuPartie(equipes, description);
	}

	public void menuLancement() {
		String choix;

		System.out.println();
		System.out.println("**********  Horizon  **********");
		System.out.println("*                             *");
		System.out.println("*   Bienvenue sur le jeu      *");
		System.out.println("*   Équipe Horizon12          *");
		System.out.println("*                             *");
		System.out.println("*******************************");
		System.out.println("*                             *");
		System.out.println("*  1 : Joueur vs IA           *");
		System.out.println("*                             *");
		System.out.println("*  2 : Joueur vs Joueur       *");
		System.out.println("*                             *");
		System.out.println("*  3 : Multijoueurs           *");
		System.out.println("*                             *");
		System.out.println("*  4 : Voir les équipes       *");
		System.out.println("*                             *");
		System.out.println("*  5 : Lancer                 *");
		System.out.println("*                             *");
		System.out.println("*  6 : Quitter                *");
		System.out.println("*                             *");
		System.out.println("*******************************");

		System.out.println();
		System.out.print("Veuillez indiquer votre choix : ");
		choix = sc.nextLine();
		System.out.println();

		int choixMenu = Integer.parseInt(getChoix(choix, "^[1-6]{1}$"));
		// Joueur v IA
        if(choixMenu == 1) {
        	mj.joueurVsIA();
	        remonterMenu();
	        menuLancement();
        }
        // Joueur v Joueur
        if(choixMenu == 2) {
        	mj.joueurVsJoueur();
	        remonterMenu();
	        menuLancement();
        }
        // Multijoueurs
        if(choixMenu == 3) {
        	mj.multiJoueurs();
	        remonterMenu();
	        menuLancement();
        }
        // Voir équipes
        if(choixMenu == 4) {
        	mj.voirEquipes();
	        remonterMenu();
	        menuLancement();
        }
        // Lancer
        if(choixMenu == 5) {
            if(mj.getEquipes().size() == 0) {
                System.out.println("Veuillez choisir les équipes avant de lancer le jeu.");
		        remonterMenu();
		        menuLancement();
            }
            else
				menuPrincipal();
        }
        // Quitter
        if(choixMenu == 6) {
			System.out.println("Merci d'avoir utilisé Horizon !");
			System.out.println("À bientôt !");
			System.exit(0);
		}
	}

	public void menuPrincipal() {
		String choix;

		System.out.println();
		System.out.println("**********  Horizon  **********");
		System.out.println("*                             *");
		System.out.println("*       Nouvelle partie       *");
		if(equipes.getEquipes().size() > 2)
			System.out.println("*        Multijoueurs         *");
		if(equipes.getEquipes().size() == 2 && equipes.getEquipes().get(0).getNom().equals("IA"))
			System.out.println("*        Joueur vs IA         *");
		if(equipes.getEquipes().size() == 2 && !equipes.getEquipes().get(0).getNom().equals("IA"))
			System.out.println("*      Joueur vs Joueur       *");
		System.out.println("*                             *");
		System.out.println("*******************************");
        System.out.println("*                             *");

		String infoTour = "";
		if(description.getTours().get(affichageTour).getTYPE() == TypeTour.ALEA) {
			infoTour = "Tour "+description.getTours().get(affichageTour).getNUMERO()+" : "+description.getTours().get
			(affichageTour).getTYPE()+" ";
		}
		else {
			infoTour = "Tour "+description.getTours().get(affichageTour).getNUMERO()+" : "+description.getTours().get(affichageTour).getTYPE();
		}
        System.out.println("*       "+infoTour+"        *");
        if(description.getTours().get(affichageTour).getTYPE() == TypeTour.ALEA) {
            if(robot.getTirage(affichageTour) == Couleur.ROUGE)
                System.out.println("*       Tirage : "+robot.getTirage(affichageTour)+"        *");
            if(robot.getTirage(affichageTour) == Couleur.ORANGE)
                System.out.println("*      Tirage : "+robot.getTirage(affichageTour)+"        *");
            if(robot.getTirage(affichageTour) == Couleur.VERT)
                System.out.println("*       Tirage : "+robot.getTirage(affichageTour)+"         *");
        }
        else
			System.out.println("*        Aucun tirage         *");
        System.out.println("*                             *");
        System.out.println("*******************************");
        System.out.println("*                             *");
		System.out.println("*  1 : Consulter le PERT      *");
		System.out.println("*                             *");
		System.out.println("*  2 : JOUER / CONTINUER      *");
		System.out.println("*                             *");
		System.out.println("*  3 : Informations équipes   *");
		System.out.println("*                             *");
		System.out.println("*  4 : Sauvegarder            *");
		System.out.println("*                             *");
		System.out.println("*  5 : Quitter la partie      *");
		System.out.println("*                             *");
		System.out.println("*******************************");

		System.out.println();
		System.out.print("Veuillez indiquer votre choix : ");
		choix = sc.nextLine();
		System.out.println();

		int choixMenu = Integer.parseInt(getChoix(choix, "^[1-5]{1}$"));
        // Consulter le PERT statique
        if(choixMenu == 1) {
        	mp.consulterPert();
	        remonterMenu();
	        menuPrincipal();
        }
		// Dérouler les tours
        if(choixMenu == 2) {
			if(description.getTour(affichageTour).getTYPE() == TypeTour.JALON) {
				for(int j=0;j<equipes.getEquipes().size();j++) {
					if(affichageTour != 0)
						robot.nouveauTour(equipes.getEquipes().get(j));
					robot.jouerJalon(equipes.getEquipes().get(j));
				}
				System.out.println();
				System.out.println("Le tour jalon est terminé pour toutes les équipes.");
				affichageTour++;
			}
			else {
				for(int j=0;j<equipes.getEquipes().size();j++) {
					robot.nouveauTour(equipes.getEquipes().get(j));
					robot.jouerEtape(equipes.getEquipes().get(j));
				}
				System.out.println();
				System.out.println("L'étape "+affichageTour+" est terminée pour toutes les équipes.");
				affichageTour++;
			}
	        remonterMenu();
	        menuPrincipal();
		}
		// Informations joueurs
        if(choixMenu == 3) {
			mp.infosJoueurs();
	        remonterMenu();
	        menuPrincipal();
		}
		//Sauvegarde
        if(choixMenu == 4) {
			System.out.println("Menu en cours.");
	        remonterMenu();
	        menuPrincipal();
		}
		// Quitter la partie
        if(choixMenu == 5) {
			String choixQuitter;
			System.out.println("La partie ne sera pas sauvegardée.");
			System.out.print("Quitter la partie (o/n) ? ");
			choixQuitter = sc.nextLine();

			if(getChoix(choixQuitter, "^o{1}|n{1}$").equals("o"))
				new Menu().menuLancement();
			else
				menuPrincipal();
		}
	}

	public void remonterMenu() {
		String choix;
		System.out.println();
		System.out.print("Appuyez sur 1 pour revenir au menu précédent : ");
		choix = sc.nextLine();
		getChoix(choix, "^1{1}$");
	}

	public String getChoix(String choix, String regex) {
		while(!choix.matches(regex)) {
			System.out.print("Veuillez indiquer un choix parmi ceux proposés : ");
			choix = sc.nextLine();
		}
		return choix;
	}
}