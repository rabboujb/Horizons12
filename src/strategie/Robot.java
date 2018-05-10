package strategie;
import description.*;
import partie.VueJoueur;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Bilal RABBOUJ
 */

public class Robot implements Strategie {
	private Scanner sc = new Scanner(System.in);
	private Random rand = new Random();

	public Robot() {
	}

	public void jouerEtape(VueJoueur vue) {
	}

	public void jouerJalon(VueJoueur vue) {
        for(Tour seq : vue.getPlateau().getSequence()) {
            if(vue.getNumeroTour() == seq.getNUMERO()) {
	            if(seq instanceof TourJalon) {
					//Equipe Horizons12
					if(!vue.getNom().equals("IA")) {
						System.out.println(vue.getNom());
						System.out.println();
			            for(int i=0;i<((TourJalon) seq).getIdTaches().size();i++) {
							System.out.println("Tâche "+((TourJalon) seq).getIdTaches().get(i));
							System.out.print("Accélérer la tâche (o/n) ? ");
							if(sc.nextLine().charAt(0) == 'o') {
								vue.setAcceleration(""+((TourJalon) seq).getIdTaches().get(i),true);
								System.out.println("La tâche "+((TourJalon) seq).getIdTaches().get(i)+" a bien été accélérée");
							}
							else
								System.out.println("Pas d'accélération pour la tâche "+((TourJalon) seq).getIdTaches().get(i));
							System.out.print("Protéger un aléa (o/n) ? ");
							if(sc.nextLine().charAt(0) == 'o') {
								System.out.print("Protéger l'aléa "+vue.getPlateau()
								.getTacheById(""+((TourJalon) seq).getIdTaches().get(i)).getAlea(Couleur.ROUGE)+" (o/n) ? ");
								if(sc.nextLine().charAt(0) == 'o') {
									vue.setProtection(""+((TourJalon) seq).getIdTaches().get(i), Couleur.ROUGE, true);
									System.out.println("L'aléa ROUGE a bien été protégé");
								}
								else
									System.out.println("Pas de protection pour l'aléa ROUGE");
								System.out.print("Protéger l'aléa "+vue.getPlateau()
								.getTacheById(""+((TourJalon) seq).getIdTaches().get(i)).getAlea(Couleur.ORANGE)+" (o/n) ? ");
								if(sc.nextLine().charAt(0) == 'o') {
									vue.setProtection(""+((TourJalon) seq).getIdTaches().get(i), Couleur.ORANGE, true);
									System.out.println("L'aléa ORANGE a bien été protégé");
								}
								else
									System.out.println("Pas de protection pour l'aléa ORANGE");
								System.out.print("Protéger l'aléa "+vue.getPlateau()
								.getTacheById(""+((TourJalon) seq).getIdTaches().get(i)).getAlea(Couleur.VERT)+" (o/n) ? ");
								if(sc.nextLine().charAt(0) == 'o') {
									vue.setProtection(""+((TourJalon) seq).getIdTaches().get(i), Couleur.VERT, true);
									System.out.println("L'aléa VERT a bien été protégé");
								}
								else
									System.out.println("Pas de protection pour l'aléa VERT");
							}
							else
								System.out.println("Pas de protection pour les aléas");
						}
						vue.finDuTour();
						System.out.println(vue.getNumeroTour());
					}
					else {
						// IA
						System.out.println(vue.getNom());
						System.out.println();
			            for(int i=0;i<((TourJalon) seq).getIdTaches().size();i++) {
							System.out.println("Tâche "+((TourJalon) seq).getIdTaches().get(i));
							if(rand.nextInt(2) == 0) {
								vue.setAcceleration(""+((TourJalon) seq).getIdTaches().get(i),true);
								System.out.println("La tâche "+((TourJalon) seq).getIdTaches().get(i)+" a bien été accélérée");
							}
							else
								System.out.println("Pas d'accélération pour la tâche "+((TourJalon) seq).getIdTaches().get(i));
							if(rand.nextInt(2) == 0) {
								vue.setProtection(""+((TourJalon) seq).getIdTaches().get(i), Couleur.ROUGE, true);
								System.out.println("L'aléa ROUGE a bien été protégé");
							}
							else
								System.out.println("Pas de protection pour l'aléa ROUGE");
							if(rand.nextInt(2) == 0) {
								vue.setProtection(""+((TourJalon) seq).getIdTaches().get(i), Couleur.ORANGE, true);
								System.out.println("L'aléa ORANGE a bien été protégé");
							}
							else
								System.out.println("Pas de protection pour l'aléa ORANGE");
							if(rand.nextInt(2) == 0) {
								vue.setProtection(""+((TourJalon) seq).getIdTaches().get(i), Couleur.VERT, true);
								System.out.println("L'aléa VERT a bien été protégé");
							}
							else
								System.out.println("Pas de protection pour l'aléa VERT");
						}
						vue.finDuTour();
						System.out.println(vue.getNumeroTour());
					}
	            }
            }
        }
		System.out.println("OK");
	}
}