package menu;
import description.*;
import partie.VueEquipes;
import partie.VueJoueur;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author diallo, Bilal RABBOUJ
 */

public class MenuJeu {
	Scanner sc = new Scanner(System.in);
	private Description d;
	private VueJoueur equipes;

	public MenuJeu(VueJoueur equipes, Description description) {
		this.equipes = equipes;
		this.d = description;
	}

	public List<VueJoueur> getEquipes() { return equipes.getEquipes(); }

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
			while(!choix.matches("^o{1}|n{1}$")) {
				System.out.print("Veuillez indiquer votre choix parmi (o/n) : ");
				choix = sc.nextLine();
			}

			if(choix == "o")
				ajouterEquipe();
			else
				equipes.ajouterEquipe(new VueEquipes(equipeA, d));

			System.out.println();
			System.out.println("Les équipes ont bien été créées.");
		}
	}

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

	public void ajouterEquipe() {
		String nNom;
		String choixC;

		do {
			System.out.println();
			System.out.print("Nom d'équipe : ");
			nNom = sc.nextLine();
			System.out.println();

			System.out.println("Nom : "+nNom);
			System.out.print("Conserver le nom (o/n) ? ");
			choixC = sc.nextLine();
			while(!choixC.matches("[on]")) {
				System.out.print("Veuillez indiquer votre choix parmi (o/n) : ");
				choixC = sc.nextLine();
			}
		} while(choixC.equals("n"));

		if(choixC.equals("o"))
			equipes.ajouterEquipe(new VueEquipes(nNom, d));
	}

	public void voirEquipes() {
		if(equipes.getEquipes().size() == 0)
			System.out.println("Aucune équipe créée !");
		else {
			for(VueJoueur e: equipes.getEquipes())
				System.out.println(e.getNom());
		}
	}
}