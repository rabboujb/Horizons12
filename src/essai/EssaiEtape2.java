/**
 * @author Bilal RABBOUJ
 */
package essai;
import partie.*;
import java.util.Scanner;

public class EssaiEtape2 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=0;

		PartieTest listeEquipes = new PartieTest();

		do {
			i++;
			System.out.print("Choisissez un nom d'équipe : ");
            listeEquipes.ajouterEquipe(new PartieTest(""+sc.nextLine()));
			System.out.print("Créer une nouvelle équipe (o/n) ? ");
		} while(sc.nextLine().charAt(0) == 'o');

        System.out.println();

		for(DonneesJoueur e: listeEquipes.getEquipes()) {
			System.out.println(e.getNom());
			System.out.println(e.getCaisse()+" €");
			System.out.println(e.getQualite()+" %");
	        System.out.println("===");
	        System.out.println();
		}
    }
}