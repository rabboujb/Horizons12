/**
 * @author Bilal RABBOUJ
 */

package strategie;
import description.Couleur;
import partie.VueJoueur;
import java.util.Random;
import java.util.Scanner;

public class Robot implements Strategie {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	public Robot() {
	}

	public void jouerEtape(VueJoueur vue) {
		for(int i=0;i<vue.getTabA().length;i++) {

		}
	}

	public void jouerJalon(VueJoueur vue) {
			System.out.println("Jalon 1");
			System.out.println();
			for(int j=0;j<vue.getEquipes().size();j++) {
				//Equipe Horizons12
				if(vue.getEquipes().get(j).getNom() != "IA") {
					System.out.println(vue.getEquipes().get(j).getNom());
					System.out.println();
					for(int i=1;i<5;i++) {
						System.out.println("Tâche "+i);
						System.out.print("Accélérer la tâche (o/n) ? ");
						if(sc.nextLine().charAt(0) == 'o') {
							vue.getEquipes().get(j).setAcceleration(""+i,true);
							System.out.println("La tâche "+i+" a bien été accélérée");
						}
						else
							System.out.println("Pas d'accélération pour la tâche "+i);
						System.out.print("Protéger un aléa (o/n) ? ");
						if(sc.nextLine().charAt(0) == 'o') {
							System.out.print("Protéger l'aléa "+vue.getEquipes().get(j).getPlateau()
							.getTacheById(""+i).getAlea(Couleur.ROUGE)+" (o/n) ? ");
							if(sc.nextLine().charAt(0) == 'o') {
								vue.getEquipes().get(j).setProtection(""+i, Couleur.ROUGE, true);
								System.out.println("L'aléa ROUGE a bien été protégé");
							}
							else
								System.out.println("Pas de protection pour l'aléa ROUGE");
							System.out.print("Protéger l'aléa "+vue.getEquipes().get(j).getPlateau()
							.getTacheById(""+i).getAlea(Couleur.ORANGE)+" (o/n) ? ");
							if(sc.nextLine().charAt(0) == 'o') {
								vue.getEquipes().get(j).setProtection(""+i, Couleur.ORANGE, true);
								System.out.println("L'aléa ORANGE a bien été protégé");
							}
							else
								System.out.println("Pas de protection pour l'aléa ORANGE");
							System.out.print("Protéger l'aléa "+vue.getEquipes().get(j).getPlateau()
							.getTacheById(""+i).getAlea(Couleur.VERT)+" (o/n) ? ");
							if(sc.nextLine().charAt(0) == 'o') {
								vue.getEquipes().get(j).setProtection(""+i, Couleur.VERT, true);
								System.out.println("L'aléa VERT a bien été protégé");
							}
							else
								System.out.println("Pas de protection pour l'aléa VERT");
						}
						else
							System.out.println("Pas de protection pour les aléas");
					}
				}
				else {
					// IA
					System.out.println(vue.getEquipes().get(j).getNom());
					System.out.println();
					for(int i=1;i<5;i++) {
						if(rand.nextInt(2) == 0) {
							vue.getEquipes().get(j).setAcceleration(""+i,true);
							System.out.println("La tâche "+i+" a bien été accélérée");
						}
						else
							System.out.println("Pas d'accélération pour la tâche "+i);
						if(rand.nextInt(2) == 0) {
							vue.getEquipes().get(j).setProtection(""+i, Couleur.ROUGE, true);
							System.out.println("L'aléa ROUGE a bien été protégé");
						}
						else
							System.out.println("Pas de protection pour l'aléa ROUGE");
						if(rand.nextInt(2) == 0) {
							vue.getEquipes().get(j).setProtection(""+i, Couleur.ORANGE, true);
							System.out.println("L'aléa ORANGE a bien été protégé");
						}
						else
							System.out.println("Pas de protection pour l'aléa ORANGE");
						if(rand.nextInt(2) == 0) {
							vue.getEquipes().get(j).setProtection(""+i, Couleur.VERT, true);
							System.out.println("L'aléa VERT a bien été protégé");
						}
						else
							System.out.println("Pas de protection pour l'aléa VERT");
					}
				}
			}
		System.out.println("OK");
	}
}