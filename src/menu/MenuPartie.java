package menu;
import description.*;
import partie.DonneesJoueur;
import partie.Equipes;
import partie.VueJoueur;

import java.util.Scanner;

public class MenuPartie {
	Scanner sc = new Scanner(System.in);
	private VueJoueur equipe;

	public MenuPartie(VueJoueur vue) {
		this.equipe = vue;
	}

	public void consulterPert() {
        Description description = new Description();

        for(int i=1;i<9;i++) {
                System.out.println("TÂCHE "+i);
               System.out.println();
            Tache t = description.getTacheById(""+i+"");
                System.out.println("Nom : "+t.getId());
                System.out.println("Description : "+t.getDescription());
                System.out.println("Coût d'accélération : "+t.coutAcceleration()+" €");
                if(i == 5)
                    System.out.println("Durée prévue : "+t.getDureeInitiale()+" semaine");
                else
                    System.out.println("Durée prévue : "+t.getDureeInitiale()+" semaines");
                    System.out.println("Retard éventuel : "+t.getDureeMax()+" semaines");
            Alea aR = t.getAlea(Couleur.ROUGE);
                System.out.println(aR.toString());
            Alea aO = t.getAlea(Couleur.ORANGE);
                System.out.println(aO.toString());
            Alea aV = t.getAlea(Couleur.VERT);
                System.out.println(aV.toString());
                System.out.println("===");
                System.out.println();
        }


	}

	public void infosEquipes() {
		System.out.println("Afficher les informations de l'équipe : ");
		System.out.println("1. "+equipe.getNom());
		System.out.println("2. IA");

		System.out.println();
		System.out.print("Veuillez saisir votre choix : ");

//		DonneesJoueur DonneesEquipe;

		if(sc.nextInt() == 1) {
			System.out.println(equipe.getNom());
			System.out.println(equipe.getCaisse()+" €");
			System.out.println(equipe.getQualite()+" %");
//	        consulterPert();
		}
		if(sc.nextInt() == 2) {
			System.out.println(equipe.getNom());
			System.out.println(equipe.getCaisse()+" €");
			System.out.println(equipe.getQualite()+" %");
//	        consulterPert();
		}

        System.out.println("===");
        System.out.println();
	}

	public void actionsPossibles() {

	}
}