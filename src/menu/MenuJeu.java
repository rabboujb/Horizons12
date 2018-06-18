package menu;
import description.*;
import partie.VueEquipes;
import partie.VueJoueur;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bilal RABBOUJ
 */

public class MenuJeu {
	private Scanner sc = new Scanner(System.in);
	private Description d;
	private VueJoueur equipes;

	/**
	 * Constructeur de la classe MenuJeu, gère la création des équipes en fonction du choix
	 * @param equipes
	 * @param description
	 */
	public MenuJeu(VueJoueur equipes, Description description) {
		this.equipes = equipes;
		this.d = description;
	}

	/**
	 * Liste des équipes
	 * @return La liste des équipes
	 */
	public List<VueJoueur> getEquipes() { return equipes.getEquipes(); }

	/**
	 * Choix du joueur : joueur VS IA
	 * Le joueur a la possibilité de modifier le nom d'équipe
	 * Les décisions de l'IA ne sont pas visibles
	 */
	public void joueurVsIA() {
		if(equipes.getEquipes().size() != 0)
			System.out.println("Les équipes sont déjà créées.");
		else {
			System.out.println();
			System.out.println("== Création des équipes (Joueur vs IA) ==");
			String equipeA = "Horizons12";
			String equipeIA = "IA";

			equipes.ajouterEquipe(new VueEquipes(equipeIA, d));

			System.out.println("== Equipe par défaut : "+equipeA+" ==");
			System.out.println();
			System.out.print("Modifier le nom d'équipe (o/n) ? ");
			String choix = sc.nextLine();
			while(!choix.matches("[on]")) {
				System.out.print("Veuillez indiquer votre choix parmi (o/n) : ");
				choix = sc.nextLine();
			}

			if(choix.equals("o"))
				ajouterEquipe();
			else
				equipes.ajouterEquipe(new VueEquipes(equipeA, d));

			System.out.println();
			System.out.println("Les équipes ont bien été créées.");
		}
	}

	/**
	 * Joueur VS Joueur
	 * Deux équipes
	 * Les joueurs peuvent modifier leur nom d'équipe
	 * Chaque équipe peut consulter les informations à chaque étape
	 */
	public void joueurVsJoueur() {
		if(equipes.getEquipes().size() != 0)
			System.out.println("Les équipes sont déjà créées.");
		else {
			System.out.println();
			System.out.println("== Création des équipes (Joueur vs Joueur) ==");
			for(int i=1;i<3;i++) {
				System.out.println("Équipe "+i);
				System.out.println();
				ajouterEquipe();
			}

			System.out.println();
			System.out.println("Les équipes ont bien été créées.");
		}
	}

	/**
	 * Partie Multijoueurs
	 * Trois équipes minimum
	 * Le nombre d'équipes n'est pas limité
	 * Chaque équipe peut consulter les informations à chaque étape
	 */
	public void multiJoueurs() {
		if(equipes.getEquipes().size() != 0)
			System.out.println("Les équipes sont déjà créées.");
		else {
			System.out.println();
			System.out.println("== Création des équipes (Mulitjoueurs) ==");

			ajouterEquipe();
			ajouterEquipe();

			String choix;
			do {
				ajouterEquipe();
				System.out.println();
				System.out.print("Ajouter une équipe (o/n) ? ");
				choix = sc.nextLine();
				while(!choix.matches("[on]")) {
					System.out.print("Veuillez indiquer votre choix parmi (o/n) : ");
					choix = sc.nextLine();
				}
			} while(choix.equals("o"));

			System.out.println();
			System.out.println("Les équipes ont bien été créées.");
		}
	}

	/**
	 * Ajouter une équipe
	 */
	public void ajouterEquipe() {
		String nNom;
		String choixC;

		do {
			int j = 0;
			System.out.println();
			System.out.print("Nom d'équipe : ");
			nNom = sc.nextLine();
			System.out.println();

			for(int i=0;i<equipes.getEquipes().size();i++)
				j = (nNom.equals(equipes.getEquipes().get(i).getNom())) ? j+1 : j;

			if(j > 0) {
				System.out.println("Le nom est déja pris. Veuillez choisir un nouveau nom.");
				choixC = "n";
			}
			else {
				System.out.println("Nom : "+nNom);
				System.out.print("Conserver le nom (o/n) ? ");
				choixC = sc.nextLine();
				while(!choixC.matches("[on]")) {
					System.out.print("Veuillez indiquer votre choix parmi (o/n) : ");
					choixC = sc.nextLine();
				}
			}
		} while(choixC.equals("n"));

		if(choixC.equals("o")) {
			equipes.ajouterEquipe(new VueEquipes(nNom, d));
		}
	}

	/**
	 * Voir les équipes
	 */
	public void voirEquipes() {
		if(equipes.getEquipes().size() == 0)
			System.out.println("Aucune équipe créée !");
		else {
			for(VueJoueur e: equipes.getEquipes())
				System.out.println(e.getNom());
		}
	}
}
