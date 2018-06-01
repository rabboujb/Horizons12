package menu;
import description.*;
import partie.VueJoueur;
import java.util.Scanner;

/**
 *
 * @author diallo, Bilal RABBOUJ
 */

public class MenuPartie {
	Scanner sc = new Scanner(System.in);
	private Description d;
	private VueJoueur equipes;

	public MenuPartie(VueJoueur equipes, Description description) {
		this.equipes = equipes;
		this.d = description;
	}

	public void consulterPert() {
        for(int i=1;i<d.getPlateau().size()+1;i++) {
        	Tache t = d.getTacheById(i);

            System.out.println("TÂCHE "+t.getID());
            System.out.println();
            System.out.println(t);
            System.out.println("===");
            System.out.println();
        }
	}

	public void infosJoueurs() {
		String oui = "";

		do {
			int i = 0;
			for(VueJoueur v: equipes.getEquipes()) {
				if(v.getNom().equals("IA"))
					System.out.println((i+1)+". "+v.getNom()+" (Informations non visualisables)");
				else
					System.out.println((i+1)+". "+v.getNom());
				i++;
			}

			System.out.println();
			System.out.print("Choisissez un joueur pour consulter ses informations (numéro) : ");
			String numJoueur;

			numJoueur = sc.nextLine();
			while(!numJoueur.matches("^[0-"+i+"\"]$")) {
				System.out.print("Veuillez indiquer votre choix parmi ceux proposés : ");
				numJoueur = sc.nextLine();
			}

			VueJoueur joueur = equipes.getEquipe(equipes.getEquipes().get(Integer.parseInt(numJoueur)-1).getNom());

			if(!joueur.getNom().equals("IA")) {
				System.out.println("Informations de l'équipe "+joueur.getNom()
					+"\nTour "+joueur.getNumeroTour()
					+"\n"
					+"\nCaisse : "+joueur.getDonneesEquipe().getCaisse()+" €"
					+"\nQualité : "+joueur.getDonneesEquipe().getQualite()+" %");
				if(joueur.getNumeroTour() > 0)
					System.out.println("\nSemaines jouées : "+joueur.getRealisation(joueur.getNumeroTour()).getSemainesReel());
			}
			else
				System.out.println("Les informations de l'IA ne sont pas visualisables.");

	        System.out.println("===");
	        System.out.println();

			System.out.print("Consulter les informations d'un autre joueur (o/n) ? ");
			oui = sc.nextLine();
			while(!oui.matches("[on]")) {
				System.out.print("Veuillez indiquer votre choix parmi ceux proposés : ");
				oui = sc.nextLine();
			}
		} while(oui.equals("o"));
	}

	public void actionsPossibles() {

	}
}