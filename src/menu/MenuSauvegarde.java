package menu;
import description.*;
import partie.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author Bilal RABBOUJ
 */

public class MenuSauvegarde {
	private Scanner sc = new Scanner(System.in);
	private VueJoueur equipes;
	private Description description;
	private List<Couleur> tirages;
	private String dossierSauvegarde = "sauvegarde/";

	/**
	 * Constructeur de la classe MenuSauvegarde
	 * @param equipes
	 * @param description
	 * @param tirages
	 */
	public MenuSauvegarde(VueJoueur equipes, Description description, List<Couleur> tirages) {
		this.equipes = equipes;
		this.description = description;
		this.tirages = tirages;
	}

	/**
	 * Sauvegarde d'une partie en cours
	 * Le nom de la sauvegarde est libre
	 * Les sauvegardes sont stockées dans un dossier sauvegarde
	 * Sauvegarde du PERT
	 * Sauvegarde des tours
	 * Sauvegarde des tirages
	 * Sauvegarde des équipes
	 */
	public void sauvegarde() {
		String nomFichier;
		String choixC;

		System.out.println();
		System.out.println("Choisissez un nom de dossier pour la sauvegarde.");
		System.out.println("Rappel - les caractères suivants sont interdits :");
		System.out.println("\\/?%*:|\"<>");
		System.out.println();

		// Choix du nom du dossier de sauvegarde
		do {
			System.out.print("Nom du dossier de sauvegarde : ");
			nomFichier = sc.nextLine();
			System.out.println();

			if(nomFichier.matches("\\\\/?%*:|\"<>")) {
				System.out.println("Le nom de dossier n'est pas valide.");
				choixC = "n";
			}
			else {
				System.out.println("Nom : "+nomFichier);
				System.out.print("Conserver le nom (o/n) ? ");
				choixC = sc.nextLine();
				while(!choixC.matches("[on]")) {
					System.out.print("Veuillez indiquer votre choix parmi (o/n) : ");
					choixC = sc.nextLine();
				}
			}
		} while(choixC.equals("n"));

		/*
			Sauvegarde
			Si le dossier est créé, création des fichiers de sauvegarde
		 */
        try {
            if(!new File(dossierSauvegarde+nomFichier).mkdir())
                System.out.println("Un dossier existe déjà sous ce nom.\n");
            else {
	            new File(new File(dossierSauvegarde+nomFichier)+"/Pert");
	            new File(new File(dossierSauvegarde+nomFichier)+"/Tours");
	            new File(new File(dossierSauvegarde+nomFichier)+"/Tirages");
	            new File(new File(dossierSauvegarde+nomFichier)+"/Equipes");

	            FileOutputStream fosPert = new FileOutputStream(dossierSauvegarde+nomFichier+"/Pert", false);
	            ObjectOutputStream oosPert = new ObjectOutputStream(fosPert);
	            FileOutputStream fosTours = new FileOutputStream(dossierSauvegarde+nomFichier+"/Tours", false);
	            ObjectOutputStream oosTours = new ObjectOutputStream(fosTours);
	            FileOutputStream fosTirages = new FileOutputStream(dossierSauvegarde+nomFichier+"/Tirages", false);
	            ObjectOutputStream oosTirages = new ObjectOutputStream(fosTirages);
	            FileOutputStream fosEquipes = new FileOutputStream(dossierSauvegarde+nomFichier+"/Equipes", false);
	            ObjectOutputStream oosEquipes = new ObjectOutputStream(fosEquipes);

				/*
					Ajout des données aux fichiers de sauvegarde
				 */
				for(Tache d: description.getPlateau())
					oosPert.writeObject(d);

				for(Tour t: description.getTours())
					oosTours.writeObject(t);

				/*
					Problème : Tous les tirages sont sauvegardés, ils sont donc visibles et prévisibles si le joueur
					les consulte
				 */
		        for(Couleur tirage : tirages)
		            oosTirages.writeObject(tirage);

				for(VueJoueur v: equipes.getEquipes())
					oosEquipes.writeObject(v);

				fosPert.close();
				oosPert.close();
				fosTours.close();
				oosTours.close();
				fosTirages.close();
				oosTirages.close();
				fosEquipes.close();
				oosEquipes.close();

				System.out.println("La sauvegarde a bien été effectuée.");
            }
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
	}

	/**
	 * Récupération de la sauvegarde
	 * Affichage d'une liste des sauvegardes existantes
	 * Une fois choisie, reprise de la partie
	 */
	public void recoverSauvegarde(String path) {
		String nomFichier;
		String choixC;
		int i = 0;
		File f = new File(path);

		System.out.println("Liste des sauvegardes existantes : ");
		for(File file: f.listFiles()) {
			System.out.println((i+1)+". "+file.getName());
			i++;
		}

		System.out.println();

		do {
			int j = 0;
			System.out.print("Sauvegarde à récupérer : ");
			nomFichier = sc.nextLine();
			System.out.println();

			while(nomFichier.equals("0") || !nomFichier.matches("^[0-"+i+"\"]$")) {
				System.out.print("Veuillez indiquer votre choix parmi ceux proposés : ");
				nomFichier = sc.nextLine();
			}

			i = 0;
			int nomFichierInt = Integer.parseInt(nomFichier);
			for(File file: f.listFiles()) {
				if(nomFichierInt-1 == i)
					nomFichier = file.getName();
				i++;
			}

			System.out.println("Sauvegarde choisie : "+nomFichier);
			System.out.print("Récupérer la sauvegarde (o/n) ? ");
			choixC = sc.nextLine();
			while(!choixC.matches("[on]")) {
				System.out.print("Veuillez indiquer un choix parmi ceux proposés : ");
				choixC = sc.nextLine();
			}
		} while(choixC.equals("n"));

		try {
        	FileInputStream fisPert = new FileInputStream(dossierSauvegarde+nomFichier+"/Pert");
        	ObjectInputStream oisPert = new ObjectInputStream(fisPert);
        	FileInputStream fisTours = new FileInputStream(dossierSauvegarde+nomFichier+"/Tours");
        	ObjectInputStream oisTours = new ObjectInputStream(fisTours);
        	FileInputStream fisTirages = new FileInputStream(dossierSauvegarde+nomFichier+"/Tirages");
        	ObjectInputStream oisTirages = new ObjectInputStream(fisTirages);
        	FileInputStream fisEquipes = new FileInputStream(dossierSauvegarde+nomFichier+"/Equipes");
        	ObjectInputStream oisEquipes = new ObjectInputStream(fisEquipes);

			description.getPlateau().clear();
			while(fisPert.available() != 0) {
				description.getPlateau().add((Tache) oisPert.readObject());
			}

			description.getTours().clear();
			while(fisTours.available() != 0) {
				description.getTours().add((Tour) oisTours.readObject());
			}

			tirages.clear();
			while(fisTirages.available() != 0) {
				tirages.add((Couleur) oisTirages.readObject());
			}

			equipes.getEquipes().clear();
			while(fisEquipes.available() != 0) {
				equipes.getEquipes().add((VueJoueur) oisEquipes.readObject());
			}

			fisPert.close();
			oisPert.close();
			fisTirages.close();
			oisTirages.close();
			fisEquipes.close();
			oisEquipes.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Suppression d'une sauvegarde
	 * Affichage d'une liste des sauvegardes existantes
	 * Suppression après confirmation
	 */
	public void deleteSauvegarde(String path) {
		String nomFichier;
		String choixC;
		int i = 0;
		File f = new File(path);

		System.out.println("Liste des sauvegardes existantes : ");
		for(File file: f.listFiles()) {
			System.out.println((i+1)+". "+file.getName());
			i++;
		}

		System.out.println();

		// Demande de confirmation de suppression
		do {
			int j = 0;
			System.out.print("Sauvegarde à supprimer : ");
			nomFichier = sc.nextLine();
			System.out.println();

			while(nomFichier.equals("0") || !nomFichier.matches("^[0-"+i+"\"]$")) {
				System.out.print("Veuillez indiquer votre choix parmi ceux proposés : ");
				nomFichier = sc.nextLine();
			}

			i = 0;
			int nomFichierInt = Integer.parseInt(nomFichier);
			for(File file: f.listFiles()) {
				if(nomFichierInt-1 == i)
					nomFichier = file.getName();
				i++;
			}

			System.out.println("Sauvegarde choisie : "+nomFichier);
			System.out.print("Supprimer la sauvegarde (o/n) ? ");
			choixC = sc.nextLine();
			while(!choixC.matches("[on]")) {
				System.out.print("Veuillez indiquer un choix parmi ceux proposés : ");
				choixC = sc.nextLine();
			}
		} while(choixC.equals("n"));

		// Suppression
		try {
            File deletePert = new File(dossierSauvegarde+nomFichier+"/Pert");
            File deleteTours = new File(dossierSauvegarde+nomFichier+"/Tours");
            File deleteTirages = new File(dossierSauvegarde+nomFichier+"/Tirages");
            File deleteEquipes = new File(dossierSauvegarde+nomFichier+"/Equipes");
            File deleteDir = new File(dossierSauvegarde+nomFichier);

            if(deletePert.delete() && deleteTours.delete() && deleteTirages.delete() && deleteEquipes.delete()) {
                if(deleteDir.delete())
	                System.out.println("La sauvegarde a bien été supprimée.");
            }
            else
                System.out.println("La sauvegarde n'a pas été supprimée.");
		}
		catch(SecurityException se) {
			System.out.println(se);
		}
	}
}
