package menu;
import java.util.Scanner;

/**
 *
 * @author diallo
 */
public class Menu {
    Scanner sc = new Scanner(System.in);
    
	public void menuLancement() {
		int choix;

		System.out.println();
		System.out.println("**********  Horizon  **********");
		System.out.println("*                             *");
		System.out.println("*   Bienvenue sur le jeu      *");
		System.out.println("*   Équipe Horizon12          *");
		System.out.println("*                             *");
		System.out.println("*  1 : Nouvelle partie        *");
		System.out.println("*                             *");
		System.out.println("*  2 : Quitter                *");
		System.out.println("*                             *");
		System.out.println("*******************************");

		System.out.println();
		System.out.print("Veuillez indiquer votre choix : ");
		choix = sc.nextInt();
		System.out.println();

		if(choix == 1)
			menuPrincipal();
		else if(choix == 2) {
			System.out.println("Merci d'avoir utilisé Horizon !");
			System.out.println("À bientôt !");
			System.exit(0);
		}
		else {
			System.out.println("== Veuillez choisir l'un des menus proposés ==");
			System.out.println();
			menuLancement();
		}
	}

	public void menuPrincipal() {
		int choix;

		System.out.println();
		System.out.println("**********  Horizon  **********");
		System.out.println("*                             *");
		System.out.println("*       Nouvelle partie       *");
		System.out.println("*                             *");
		System.out.println("*******************************");
		System.out.println("*                             *");
		System.out.println("*  1 : Consulter le PERT      *");
		System.out.println("*                             *");
		System.out.println("*  2 : Informations équipes   *");
		System.out.println("*                             *");
		System.out.println("*  3 : Actions possibles      *");
		System.out.println("*                             *");
		System.out.println("*  4 : Quitter la partie      *");
		System.out.println("*                             *");
		System.out.println("*******************************");

		System.out.println();
		System.out.print("Veuillez indiquer votre choix : ");
		choix = sc.nextInt();
		System.out.println();

		MenuPartie maPartie = new MenuPartie();

		if(choix == 1)
			maPartie.consulterPert();
		else if(choix == 2)
			System.out.println("choix2");
		else if(choix == 3)
			System.out.println("choix3");
		else if(choix == 4)
			System.out.println("choix4");
		else {
			System.out.println("== Veuillez choisir l'un des menus proposés ==");
			System.out.println();
			menuPrincipal();
		}
	}
}