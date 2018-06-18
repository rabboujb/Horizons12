package strategie;
import description.*;
import partie.VueJoueur;
import java.io.Serializable;
import java.util.*;

/**
 * @author Bilal RABBOUJ
 */

public class Robot implements Strategie, Serializable {
	private Scanner sc = new Scanner(System.in);
	private Random rand = new Random();
	private List<Couleur> tirages;

	public Robot() {
		this.tirages = new ArrayList<>();
		for(int i=0;i<10;i++) {
			Couleur tirage = Couleur.tirage();
			tirages.add(tirage);
		}
	}

	public List<Couleur> getTirages()   { return tirages;                   }
	public Couleur getTirage(int id)    { return tirages.get(id);           }

	public void nouveauTour(VueJoueur vue) {
		vue.finDuTour();
	}

	public void jouerEtape(VueJoueur vue) {
		Tour tour = vue.getPlateau().getTours().get(vue.getNumeroTour());
		if(tour.getTYPE() == TypeTour.ALEA) {
			// Equipe Horizons12
			if(tour instanceof TourAlea) {
				int idTache = vue.getNumeroTache();
				// Accélération
				if(vue.getRealisation(idTache).getAccelere())
				// Baisse de la caisse de 10 euros
				vue.getDonneesEquipe().depense(vue.getPlateau().getTacheById(idTache).getCOUT());

				// Aléas
				Couleur tirage = tirages.get(tour.getNUMERO());

				if(vue.getRealisation(idTache).appliquerProtection(Couleur.ROUGE)
					|| vue.getRealisation(idTache).appliquerProtection(Couleur.ORANGE)
					|| vue.getRealisation(idTache).appliquerProtection(Couleur.VERT))
						vue.getDonneesEquipe().depense(10);

				if(tirage == Couleur.ROUGE) {
					// Si une protection sur la couleur ROUGE est désactivée (false)
					if(!vue.getRealisation(idTache).appliquerProtection(Couleur.ROUGE)) {
						// Si l'aléa est de type DELAI
						if(vue.getPlateau().getTacheById(idTache).getAlea(Couleur.ROUGE).getTYPE() == TypeAlea.DELAI)
							// La gravité représente le nombre de semaines à ajouter à la durée réelle
							vue.getRealisation(idTache).appliquerDelai(vue.getPlateau().getTacheById(idTache)
							.getAlea(Couleur.ROUGE).getGRAVITE());
						// Si l'aléa est de type COUT
						if(vue.getPlateau().getTacheById(idTache).getAlea(Couleur.ROUGE).getTYPE() == TypeAlea.COUT)
							// La gravité multipliée par 10 représente la baisse du montant de la caisse
							vue.getDonneesEquipe().depense(10*vue.getPlateau().getTacheById(idTache)
							.getAlea(Couleur.ROUGE).getGRAVITE());
					}
				}
				if(tirage == Couleur.ORANGE) {
					// Si une protection sur la couleur ROUGE est désactivée (false)
					if(!vue.getRealisation(idTache).appliquerProtection(Couleur.ORANGE)) {
						// Si l'aléa est de type DELAI
						if(vue.getPlateau().getTacheById(idTache).getAlea(Couleur.ORANGE).getTYPE() == TypeAlea.DELAI)
							// La gravité représente le nombre de semaines à ajouter à la durée réelle
							vue.getRealisation(idTache).appliquerDelai(vue.getPlateau().getTacheById(idTache)
							.getAlea(Couleur.ORANGE).getGRAVITE());
							// Si l'aléa est de type COUT
							if(vue.getPlateau().getTacheById(idTache).getAlea(Couleur.ORANGE).getTYPE() == TypeAlea.COUT)
							// La gravité multipliée par 10 représente la baisse du montant de la caisse
							vue.getDonneesEquipe().depense(10*vue.getPlateau().getTacheById(idTache)
							.getAlea(Couleur.ORANGE).getGRAVITE());
					}
				}
				if(tirage == Couleur.VERT) {
					// Si une protection sur la couleur ROUGE est désactivée (false)
					if(!vue.getRealisation(idTache).appliquerProtection(Couleur.VERT)) {
						// Si l'aléa est de type DELAI
						if(vue.getPlateau().getTacheById(idTache).getAlea(Couleur.VERT).getTYPE() == TypeAlea.DELAI)
							// La gravité représente le nombre de semaines à ajouter à la durée réelle
							vue.getRealisation(idTache).appliquerDelai(vue.getPlateau().getTacheById(idTache)
							.getAlea(Couleur.VERT).getGRAVITE());
						// Si l'aléa est de type COUT
						if(vue.getPlateau().getTacheById(idTache).getAlea(Couleur.VERT).getTYPE() == TypeAlea.COUT)
							// La gravité multipliée par 10 représente la baisse du montant de la caisse
							vue.getDonneesEquipe().depense(10*vue.getPlateau().getTacheById(idTache)
							.getAlea(Couleur.VERT).getGRAVITE());
						// Si l'aléa est de type QUALITE
						if(vue.getPlateau().getTacheById(idTache).getAlea(Couleur.VERT).getTYPE() == TypeAlea.QUALITE)
							// La gravité multipliée par 10 représente la baisse du montant de la caisse
							vue.getDonneesEquipe().baisseQualite(10*vue.getPlateau().getTacheById(idTache)
							.getAlea(Couleur.VERT).getGRAVITE());
					}
				}
				vue.finDeTache();
			}
		}
	}

	public void jouerJalon(VueJoueur vue) {
		Tour tour = vue.getPlateau().getTours().get(vue.getNumeroTour());
		if(vue.getNumeroTour() == tour.getNUMERO()) {
			if(tour instanceof TourJalon) {
				//Equipe Horizons12
				if(!vue.getNom().equals("IA")) {
					System.out.println(vue.getNom());
					System.out.println();
					for(int i=0;i<((TourJalon) tour).getIdTaches().size();i++) {
						int idTache = ((TourJalon) tour).getIdTaches().get(i);
						System.out.println("Tâche " + idTache);
						System.out.print("Accélérer la tâche pour " + vue.getPlateau().getTacheById(idTache).getCOUT()
						+ " € (o/n) ? ");
						if(getChoix(sc.nextLine(), "[on]").equals("o")) {
							vue.getRealisation(idTache).appliquerAcceleration();
							System.out.println("La tâche " + idTache + " a bien été accélérée");
						} else
							System.out.println("Pas d'accélération pour la tâche " + idTache);

						System.out.println();
						System.out.print("Protéger un ou plusieurs aléas pour 10€ (o/n) ? ");
						if(getChoix(sc.nextLine(), "[on]").equals("o")) {
							System.out.print("Protéger l'aléa " + vue.getPlateau()
							.getTacheById(idTache).getAlea(Couleur.ROUGE) + " (o/n) ? ");

							if(getChoix(sc.nextLine(), "[on]").equals("o")) {
								vue.getRealisation(idTache).appliquerProtection(Couleur.ROUGE);
								System.out.println("L'aléa ROUGE a bien été protégé");
							} else
								System.out.println("Pas de protection pour l'aléa ROUGE");

							System.out.println();
							System.out.print("Protéger l'aléa " + vue.getPlateau()
							.getTacheById(idTache).getAlea(Couleur.ORANGE) + " (o/n) ? ");
							if(getChoix(sc.nextLine(), "[on]").equals("o")) {
								vue.getRealisation(idTache).appliquerProtection(Couleur.ORANGE);
							System.out.println("L'aléa ORANGE a bien été protégé");
							} else
								System.out.println("Pas de protection pour l'aléa ORANGE");

							System.out.println();
							System.out.print("Protéger l'aléa " + vue.getPlateau()
							.getTacheById(idTache).getAlea(Couleur.VERT) + " (o/n) ? ");
							if(getChoix(sc.nextLine(), "[on]").equals("o")) {
								vue.getRealisation(idTache).appliquerProtection(Couleur.VERT);
								System.out.println("L'aléa VERT a bien été protégé");
							} else
								System.out.println("Pas de protection pour l'aléa VERT");
						} else
						System.out.println("Pas de protection pour les aléas");
						System.out.println();
					}
				}

				if(vue.getNom().equals("IA")) {
					// IA
					System.out.println(vue.getNom());
					System.out.println("Tour Jalon effectué.");
					System.out.println();
					for(int i = 0; i < ((TourJalon) tour).getIdTaches().size(); i++) {
						int idTache = ((TourJalon) tour).getIdTaches().get(i);

						if(rand.nextInt(2) == 0)
							vue.getRealisation(idTache).appliquerAcceleration();
						if(rand.nextInt(2) == 0)
							vue.getRealisation(idTache).appliquerProtection(Couleur.ROUGE);
						if(rand.nextInt(2) == 0)
							vue.getRealisation(idTache).appliquerProtection(Couleur.ORANGE);
						if(rand.nextInt(2) == 0)
							vue.getRealisation(idTache).appliquerProtection(Couleur.VERT);
					}
				}
			}
		}
	}

	public void jouerTourFinal(VueJoueur vue) {
		Tour tour = vue.getPlateau().getTours().get(vue.getNumeroTour());
		System.out.println("Appel du tour final pour : " + vue.getNom());
		((TourFinal) tour).calculerScore(vue.getNom(), vue.getRealisations(), vue.getDonneesEquipe().getCaisse(), vue.getDonneesEquipe().getQualite());
//		System.out.println(((TourFinal) tour).toString(vue.getNom()));
	}



	public String getChoix(String choix, String regex) {
		while(!choix.matches(regex)) {
			System.out.print("Veuillez indiquer un choix parmi ceux proposés : ");
			choix = sc.nextLine();
		}
		return choix;
	}
}