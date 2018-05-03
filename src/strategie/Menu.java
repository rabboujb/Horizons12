/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategie;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author diallo
 */
public class Menu {
    Scanner sc=new Scanner(System.in);
    
  public  void menuLancement() throws IOException {

		int choix;

		

		

		System.out.println();
		System.out.println("**********  Horizon12   ********");
		System.out.println("*                              *");
		System.out.println("*     Voulez-vous créer une    *");
		System.out.println("*    nouvelle partie           *");
		System.out.println("*        ou Restaurer          *");
		System.out.println("*                              *");
		System.out.println("********************************");
		System.out.println("*                              *");
		System.out.println("*  1 : Nouvelle partie         *");
		System.out.println("*                              *");		
		System.out.println("*  2 : Restaurer sauvegarde    *");
		System.out.println("*                              *");				
		System.out.println("*  9 : Quitter                 *");		
		System.out.println("*                              *");
		System.out.println("********************************");
		try {
			choix = Integer.parseInt(sc.nextLine());
		} catch(java.lang.NumberFormatException nfe) {
			System.out.println("ERREUR FORMAT ENTIER: ce n'est pas un entier");
			choix = 0;

		}


		switch (choix) {
		case 1:
			menuPrincipal();
			

			
		
			break;
		case 2:
			//lectureFichierBinaire();
			

			
			menuPrincipal();
			break;
		case 9:
			

			;
			System.out.println("\nMerci d'avoir utiliser Horizon12!\n\nA bientot!\n\n");
			System.exit(0);
			break;
		default:
			

			;
			erreurChoix();
			System.out.println("Faite le bon choix");
			menuLancement();
		}
	}
public void menuPrincipal() throws IOException {

		int choix;

		System.out.println();
		System.out.println("**********  Horizon12 **********");
		System.out.println("*                              *");
		System.out.println("*        Créer l'Equipe        *");
		System.out.println("*                              *");
		System.out.println("********************************");
		System.out.println("*                              *");
		System.out.println("*  1 : Ajouter                 *");
		System.out.println("*                              *");
		System.out.println("*  2 : Modifier                *");
		System.out.println("*                              *");
		System.out.println("*  3 : Supprimer               *");
		System.out.println("*                              *");
		System.out.println("*  4 : Sauvegarde              *");
	  	System.out.println("*                              *");
		System.out.println("*  9 : Quitter                 *");
		System.out.println("*                              *");
		System.out.println("*                              *");
		System.out.println("********************************");

		try {
			choix = Integer.parseInt(sc.nextLine());
		} catch(java.lang.NumberFormatException nfe) {
			System.out.println("ERREUR FORMAT ENTIER: ce n'est pas un entier");
			choix = 0;

		}


		switch (choix) {
		case 1:
			

			;
			
			System.out.println("choix1");
			break;
		case 2:
			

			;
			
			System.out.println("choix2");
			break;
		case 3:
			

			;
			
			System.out.println("choix3");
			break;
		case 4:
			

			;
			
			System.out.println("choix4");
			break;
		case 5:
			

			;
			menuConfirmationSauvegarde();
			
			break;
		case 9:
			

			;
			menuQuitter();
			break;
		default:
			

			;
			erreurChoix();
			System.out.println();
			menuPrincipal();
		}
	}

	public void menuConfirmationSauvegarde() throws IOException {		

		int choix;

		System.out.println();
		System.out.println("*********  SAUVEGARDE  *********");
		System.out.println("*                              *");
		System.out.println("*        Voulez vous           *");
		System.out.println("*    vraiment sauvegarder ?    *");
		System.out.println("*                              *");
		System.out.println("********************************");
		System.out.println("*                              *");
		System.out.println("*  1 : oui                     *");
		System.out.println("*                              *");
		System.out.println("*  2 : non                     *");
		System.out.println("*                              *");
		System.out.println("********************************");

		try {
			choix = Integer.parseInt(sc.nextLine());
		} catch(java.lang.NumberFormatException nfe) {
			System.out.println("ERREUR FORMAT ENTIER: ce n'est pas un entier");
			choix = 0;

		}
		switch (choix) {
		case 1:
			

			;
			//ecritureFichierBinaire();
			menuPrincipal();
			break;
		case 2:
			

			;
			menuPrincipal();
			break;
		default:
			

			;
			erreurChoix();
			System.out.println();
			menuPrincipal();
		}
	}

	/**menu qui va demander a l'utilisateur 
	 * s'il veut sauvegarder avant de quitter l'application
	 */

	public void menuQuitter() throws IOException {

		int choix;

		System.out.println();
		System.out.println("*************  Horizon12  *********");
		System.out.println("*                                 *");
		System.out.println("*      Etes vous sur de vouloir   *");
		System.out.println("*         quitter Horizon12 ?     *");
		System.out.println("*                                 *");
		System.out.println("***********************************");
		System.out.println("*                                 *");
		System.out.println("*  1 : Sauvegarder et quitter     *");
		System.out.println("*                                 *");
		System.out.println("*  2 : Quitter sans sauvegarder   *");
		System.out.println("*                                 *");
		System.out.println("*  3 : annuler                    *");
		System.out.println("*                                 *");
		System.out.println("***********************************");

		try {
			choix = Integer.parseInt(sc.nextLine());
		} catch(java.lang.NumberFormatException nfe) {
			System.out.println("ERREUR FORMAT ENTIER: ce n'est pas un entier");
			choix = 0;

		}
		switch (choix) {
		case 1:
			

			;
			//ecritureFichierBinaire();
			System.out.println("\nMerci d'avoir utilisé Horizon12!\n\nA bientot!\n\n");
			System.exit(0);
			break;
		case 2:
			

			;
			System.out.println("\nMerci d'avoir utilisé Horizon12!\n\nA bientot!\n\n");
			System.exit(0);
			break;
		case 3:
			

			;
			System.out.println("\nRetour au menu principal\n\n");
			menuPrincipal();

		default:
			

			;
			erreurChoix();
			System.out.println("\nRetour au menu principal\n\n");
			menuPrincipal();
		}
	}

	/**message d'erreur : 
	 * lorsqu'une manipulation des choix est fait dans les menus
	 */

public	void erreurChoix() {
     
		  System.out.println();
		  System.out.println("        Ce choix n'existe pas  veuillez renseigner le bon choix!       ");
		  System.out.println();
		}
	

}

    

