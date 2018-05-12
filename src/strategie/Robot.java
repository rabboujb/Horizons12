package strategie;
import description.*;
import partie.VueJoueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Bilal RABBOUJ
 */

public class Robot implements Strategie {
	private Scanner sc = new Scanner(System.in);
	private Random rand = new Random();

	private List<Couleur> tirages;

	public Robot() {
		this.tirages = new ArrayList<>();

		for(int i=0;i<10;i++)
			tirages.add(Couleur.tirage());
	}

	public void jouerEtape(VueJoueur vue) {
        for(Tour seq : vue.getPlateau().getSequence()) {
	        if(seq.getTYPE() == TypeTour.ALEA && vue.getNumeroTour() == seq.getNUMERO()) {
			// Equipe Horizons12
//					if(!vue.getNom().equals("IA")) {
	            if(seq instanceof TourAlea) {
					// Accélération
					if(vue.getIdTabA(((TourAlea) seq).getIdTache()-1)) {
						// Baisse de la caisse de 10 euros
						vue.getDonneesEquipe().depense(vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache()
						).coutAcceleration());
						// Diminution de la durée réelle d'une semaine
						vue.getPlateau().retraitDureeReelle(""+((TourAlea) seq).getIdTache(), 1);
					}
					// Aléas
					Couleur tirage = tirages.get(seq.getNUMERO());

					if(vue.getIdTabP((((TourAlea) seq).getIdTache()-1)*3) || vue.getIdTabP(((((TourAlea) seq).getIdTache
					()-1)*3)+1) || vue.getIdTabP(((((TourAlea) seq).getIdTache()-1)*3)+2))
						vue.getDonneesEquipe().depense(10);

		            if(tirage == Couleur.ROUGE) {
						// Si une protection sur la couleur ROUGE est désactivée (false)
						if(!vue.getIdTabP((((TourAlea) seq).getIdTache()-1)*3)) {
							// Si l'aléa est de type DELAI
							if(vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
							.getAlea(Couleur.ROUGE).getType() == TypeAlea.DELAI)
								// La gravité représente le nombre de semaines à ajouter à la durée réelle
								vue.getPlateau().ajoutDureeReelle(""+((TourAlea) seq).getIdTache(), vue.getPlateau()
								.getTacheById(""+((TourAlea) seq).getIdTache()).getAlea(Couleur.ROUGE).getGravite());
							// Si l'aléa est de type EUROS
							if(vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
							.getAlea(Couleur.ROUGE).getType() == TypeAlea.EUROS)
								// La gravité multipliée par 10 représente la baisse du montant de la caisse
								vue.getDonneesEquipe().depense(10*vue.getPlateau().getTacheById(""+((TourAlea) seq)
								.getIdTache())
								.getAlea(Couleur.ROUGE).getGravite());
						}
		            }
					if(tirage == Couleur.ORANGE) {
						// Si une protection sur la couleur ORANGE est désactivée (false)
						if(!vue.getIdTabP(((((TourAlea) seq).getIdTache()-1)*3)+1)) {
							// Si l'aléa est de type DELAI
							if(vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
							.getAlea(Couleur.ORANGE).getType() == TypeAlea.DELAI)
								// La gravité représente le nombre de semaines à ajouter à la durée réelle
								vue.getPlateau().ajoutDureeReelle(""+((TourAlea) seq).getIdTache(), vue.getPlateau()
								.getTacheById(""+((TourAlea) seq).getIdTache()).getAlea(Couleur.ORANGE).getGravite());
							// Si l'aléa est de type EUROS
							if(vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
							.getAlea(Couleur.ORANGE).getType() == TypeAlea.EUROS)
								// La gravité multipliée par 10 représente la baisse du montant de la caisse
								vue.getDonneesEquipe().depense(10*vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
								.getAlea(Couleur.ORANGE).getGravite());
						}
					}
					if(tirage == Couleur.VERT) {
						// Si une protection sur la couleur VERT est désactivée (false)
						if(!vue.getIdTabP(((((TourAlea) seq).getIdTache()-1)*3)+2)) {
							// Si l'aléa est de type DELAI
							if(vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
							.getAlea(Couleur.VERT).getType() == TypeAlea.DELAI)
								// La gravité représente le nombre de semaines à ajouter à la durée réelle
								vue.getPlateau().ajoutDureeReelle(""+((TourAlea) seq).getIdTache(), vue.getPlateau()
								.getTacheById(""+((TourAlea) seq).getIdTache()).getAlea(Couleur.VERT).getGravite());
							// Si l'aléa est de type EUROS
							if(vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
							.getAlea(Couleur.VERT).getType() == TypeAlea.EUROS)
								// La gravité multipliée par 10 représente la baisse du montant de la caisse
								vue.getDonneesEquipe().depense(10*vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
								.getAlea(Couleur.VERT).getGravite());
							// Si l'aléa est de type QUALITE
							if(vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
							.getAlea(Couleur.VERT).getType() == TypeAlea.QUALITE)
								vue.getDonneesEquipe().baisseQualite(2*vue.getPlateau().getTacheById(""+((TourAlea) seq).getIdTache())
								.getAlea(Couleur.VERT).getGravite());
						}
					}
					System.out.println();
					System.out.println("*"+vue.getNom()+"*Tour "+vue.getNumeroTour());
					System.out.println("*Tirage "+tirage);
					System.out.println("*Caisse Données "+vue.getDonneesEquipe().getCaisse()+" €");
					System.out.println("*Caisse Vue "+vue.getCaisse()+" €");
					System.out.println("*Qualité "+vue.getDonneesEquipe().getQualite()+" %");
					System.out.println();
					vue.finDuTour();
	            }
//					}
	        }
        }
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
							System.out.print("Accélérer la tâche pour "+vue.getPlateau().getTacheById(""+((TourJalon)
							 seq).getIdTaches().get(i)).coutAcceleration()+" € (o/n) ? ");
							if(sc.nextLine().charAt(0) == 'o') {
								vue.setAcceleration(""+((TourJalon) seq).getIdTaches().get(i),true);
								System.out.println("La tâche "+((TourJalon) seq).getIdTaches().get(i)+" a bien été accélérée");
							}
							else
								System.out.println("Pas d'accélération pour la tâche "+((TourJalon) seq).getIdTaches().get(i));
							System.out.print("Protéger un ou plusieurs aléas pour 10€ (o/n) ? ");
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
					}
					System.out.println("=Tour "+vue.getNumeroTour());
					vue.finDuTour();
	            }
            }
        }
		System.out.println("Taille tableau tours : "+vue.getPlateau().getSequence().size());
		System.out.println();
		System.out.println("OK");
		System.out.println();
	}
}