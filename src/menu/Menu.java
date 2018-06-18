package menu;
import description.*;
import partie.VueEquipes;
import partie.VueJoueur;
import strategie.Robot;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author diallo, Bilal RABBOUJ
 */
public class Menu {
    private Scanner sc = new Scanner(System.in);
	private VueJoueur equipes;
	private Description description;
    private MenuJeu mj;
    private MenuPartie mp;
    private MenuSauvegarde ms;
    private MenuAbout ma;
    private Robot robot;
	private int affichageTour;
	private int affichageTache;

	public Menu() {
		robot = new Robot();
		equipes = new VueEquipes();
		description = new Description();
		mj = new MenuJeu(equipes, description);
		mp = new MenuPartie(equipes, description);
		ms = new MenuSauvegarde(equipes, description, robot.getTirages());
		ma = new MenuAbout();
		affichageTour = 0;
		affichageTache = 1;
	}

	public int getAffichageTour()   { return affichageTour;     }
	public int getAffichageTache()  { return affichageTache;    }
	public void setAffichageTour(int nombre)    { affichageTour = affichageTour + nombre;   }
	public void setAffichageTache(int nombre)   { affichageTache = affichageTache + nombre; }

	public void menuLancement() {
		String choix;

		System.out.println();
		System.out.println("**********  Horizon  **********");
		System.out.println("*                             *");
		System.out.println("*   Bienvenue sur le jeu      *");
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
		System.out.println("*  5 : DÉMARRER               *");
		System.out.println("*                             *");
		System.out.println("*  6 : Reprendre une partie   *");
		System.out.println("*                             *");
		System.out.println("*  7 : Supprimer une partie   *");
		System.out.println("*                             *");
		System.out.println("*  8 : Quitter                *");
		System.out.println("*                             *");
		System.out.println("*******************************");
		System.out.println("*  0 : À propos               *");
		System.out.println("*******************************");

		System.out.println();
		System.out.print("Veuillez indiquer votre choix : ");
		choix = sc.nextLine();
		System.out.println();

		int choixMenu = Integer.parseInt(getChoix(choix, "^[0-8]{1}$"));
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
        // Récupérer la sauvegarde
        if(choixMenu == 6) {
            String path = "sauvegarde/";
            File f = new File(path);

            if(!f.exists() || f.list().length == 0) {
                System.out.println("Aucune sauvegarde disponible.");
		        remonterMenu();
		        menuLancement();
            }
            else {
				ms.recoverSauvegarde(path);
				setAffichageTour(equipes.getEquipes().get(0).getNumeroTour());
				System.out.println();
				System.out.println("La sauvegarde a bien été récupérée.");
				System.out.println();
		        remonterMenu();
		        menuLancement();
            }
        }
        // Supprimer la sauvegarde
        if(choixMenu == 7) {
            String path = "sauvegarde/";
            File f = new File(path);

            if(!f.exists() || f.list().length == 0) {
                System.out.println("Aucune sauvegarde.");
		        remonterMenu();
		        menuLancement();
            }
            else {
				ms.deleteSauvegarde(path);
		        remonterMenu();
		        menuLancement();
            }
        }
        // Quitter
        if(choixMenu == 8) {
			System.out.println("Merci d'avoir utilisé Horizon !");
			System.out.println("À bientôt !");
			System.exit(0);
		}
        // À propos
        if(choixMenu == 0) {
            ma.about();
            ma.presentationJeu();
	        remonterMenu();
	        menuLancement();
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

		String infoTour;
		if(description.getTours().get(getAffichageTour()).getTYPE() == TypeTour.ALEA) {
			infoTour = "Tour "+description.getTours().get(getAffichageTour()).getNUMERO()+" : "+description.getTours().get
			(getAffichageTour()).getTYPE()+" ";
	        System.out.println("*       "+infoTour+"        *");
		}
		else if(description.getTours().get(getAffichageTour()).getTYPE() == TypeTour.JALON){
			infoTour = "Tour "+description.getTours().get(getAffichageTour()).getNUMERO()+" : "+description.getTours().get(getAffichageTour()).getTYPE();
	        System.out.println("*       "+infoTour+"        *");
		}
		else {
			infoTour = "Tour "+description.getTours().get(getAffichageTour()).getNUMERO()+" : "+description.getTours().get(getAffichageTour()).getTYPE();
	        System.out.println("*       "+infoTour+"       *");
		}
        if(description.getTours().get(getAffichageTour()).getTYPE() == TypeTour.ALEA) {
            if(robot.getTirage(getAffichageTour()) == Couleur.ROUGE)
                System.out.println("*       Tirage : "+robot.getTirage(getAffichageTour())+"        *");
            if(robot.getTirage(getAffichageTour()) == Couleur.ORANGE)
                System.out.println("*      Tirage : "+robot.getTirage(getAffichageTour())+"        *");
            if(robot.getTirage(getAffichageTour()) == Couleur.VERT)
                System.out.println("*       Tirage : "+robot.getTirage(getAffichageTour())+"         *");
        }
        else
			System.out.println("*        Aucun tirage         *");
        System.out.println("*                             *");
        System.out.println("*******************************");
        System.out.println("*                             *");
		System.out.println("*  1 : Consulter le PERT      *");
		System.out.println("*                             *");
		if(getAffichageTour() > description.getTours().size())
			System.out.println("*  2 : REVOIR LES SCORES      *");
		else
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
			if(description.getTour(getAffichageTour()).getTYPE() == TypeTour.JALON) {
				for(int j=0;j<equipes.getEquipes().size();j++) {
					robot.jouerJalon(equipes.getEquipes().get(j));
					robot.nouveauTour(equipes.getEquipes().get(j));
				}
				System.out.println();
				System.out.println("Le tour jalon est terminé pour toutes les équipes.");
			}
			if(description.getTour(getAffichageTour()).getTYPE() == TypeTour.ALEA) {
				for(int j=0;j<equipes.getEquipes().size();j++) {
					robot.jouerEtape(equipes.getEquipes().get(j));
					robot.nouveauTour(equipes.getEquipes().get(j));
				}
				System.out.println();
				System.out.println("L'étape "+getAffichageTour()+" est terminée pour toutes les équipes.");
			}
			if(description.getTour(getAffichageTour()).getTYPE() == TypeTour.FINAL) {
				for(int j=0;j<equipes.getEquipes().size();j++) {
					robot.jouerTourFinal(equipes.getEquipes().get(j));
				}
			}

			if(description.getTour(getAffichageTour()).getTYPE() != TypeTour.FINAL)
				setAffichageTour(1);
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
			String choixQuitter;
			System.out.print("Sauvegarder (o/n) ? ");
			choixQuitter = sc.nextLine();

			if(getChoix(choixQuitter, "[on]").equals("o")) {
				ms.sauvegarde();
		        remonterMenu();
		        menuPrincipal();
			}
			else {
		        remonterMenu();
		        menuPrincipal();
			}
		}
		// Quitter la partie
        if(choixMenu == 5) {
			String choixQuitter;

			System.out.println("Rappel : vous pouvez sauvegarder en revenant au menu précédent.");
			System.out.print("Quitter la partie (o/n) ? ");
			choixQuitter = sc.nextLine();

			if(getChoix(choixQuitter, "[on]").equals("o")) {
				affichageTour = 0;
				description.getTours().get(0).setNUMERO();
				new Menu().menuLancement();
			}
			else
				menuPrincipal();
		}
	}

	public void remonterMenu() {
		String choix;
		System.out.println();
		System.out.print("Appuyez sur 1 pour revenir au menu précédent : ");
		choix = sc.nextLine();
		getChoix(choix, "1");
	}

	public String getChoix(String choix, String regex) {
		while(!choix.matches(regex)) {
			System.out.print("Veuillez indiquer un choix parmi ceux proposés : ");
			choix = sc.nextLine();
		}
		return choix;
	}
}
