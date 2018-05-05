package essai;

import description.Alea;
import description.Couleur;
import description.Tache;
import partie.Equipes;

class essaiModif {
	public static void main(String[] args) {
		Equipes EquipeA = new Equipes("Equipe A");
		Equipes EquipeB = new Equipes("Equipe B");
		Equipes listeEquipes = new Equipes();

		listeEquipes.ajouterEquipe(EquipeA);
		listeEquipes.ajouterEquipe(EquipeB);

		Tache EAt2 = EquipeA.getPlateau().getTacheById("2");
		Tache EBt2 = EquipeB.getPlateau().getTacheById("2");

		System.out.println("==== Equipe A");
        System.out.println("Description de la tâche 2 pour l'équipe A : "+EAt2.getDescription());
        System.out.println("Durée maximale de la tâche 2 pour l'équipe A : "+EAt2.getDureeMax()+" semaines");
        System.out.println("Etat de l'accélération de la tâche 2 pour l'équipe A : "+EquipeA.tabB[1]);

        System.out.println("Aléa rouge de la tâche 2 pour l'équipe A :");
        Alea aleaRougeEquipeA = EAt2.getAlea(Couleur.ROUGE);
            System.out.println(aleaRougeEquipeA.toString());

		System.out.println();
		System.out.println("==== Equipe B");
        System.out.println("Description de la tâche 2 pour l'équipe B : "+EBt2.getDescription());
        System.out.println("Durée maximale de la tâche 2 pour l'équipe B : "+EBt2.getDureeMax()+" semaines");
        System.out.println("Etat de l'accélération de la tâche 2 pour l'équipe B : "+EquipeB.tabB[1]);

        System.out.println("Aléa rouge de la tâche 2 pour l'équipe B :");
        Alea aleaRougeEquipeB = EBt2.getAlea(Couleur.ROUGE);
            System.out.println(aleaRougeEquipeB.toString());

		System.out.println();
		System.out.println("** MODIFICATIONS **");
		System.out.println("Activer l'accélération de la tâche 2 pour l'équipe A : ");
		EquipeA.setAcceleration("2",true);
		System.out.println("Accélération de la tâche 2 pour l'équipe A : "+EquipeA.tabB[1]);
		System.out.println();
		System.out.println("Accélération de la tâche 2 pour l'équipe B : "+EquipeB.tabB[1]);
	}
}