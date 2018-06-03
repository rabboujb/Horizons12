package menu;
import description.Couleur;
import description.Description;
import description.Tache;
import description.TypeTour;
import partie.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	public MenuSauvegarde(VueJoueur equipes, Description description, List<Couleur> tirages) {
		this.equipes = equipes;
		this.description = description;
		this.tirages = tirages;
	}

	public void sauvegarde(int affichageTour) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date dateSauvegarde = new Date();
		String nomFichier;
		String choixC;

		System.out.println();
		System.out.println("Choisissez un nom de dossier pour la sauvegarde.");
		System.out.println("Rappel - les caractères suivants sont interdits :");
		System.out.println("\\\\/?%*:|\"<>");
		System.out.println();

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

        try {
            if(new File("src/Sauvegarde/"+nomFichier).mkdir()) {
	            new File("src/Sauvegarde/"+nomFichier+"/Pert");
	            new File("src/Sauvegarde/"+nomFichier+"/Tirages");
	            new File("src/Sauvegarde/"+nomFichier+"/Equipes");
            }
            else
                System.out.println("Fichiers non créés.");

        	FileOutputStream fosPert = new FileOutputStream("src/Sauvegarde/"+nomFichier+"/Pert");
        	ObjectOutputStream oosPert = new ObjectOutputStream(fosPert);
        	FileOutputStream fosTirages = new FileOutputStream("src/Sauvegarde/"+nomFichier+"/Tirages");
        	ObjectOutputStream oosTirages = new ObjectOutputStream(fosTirages);
        	FileOutputStream fosEquipes = new FileOutputStream("src/Sauvegarde/"+nomFichier+"/Equipes");
        	ObjectOutputStream oosEquipes = new ObjectOutputStream(fosEquipes);

			for(Tache d: description.getPlateau()) {
				oosPert.writeObject(d);
			}

			for(int i=0;i<tirages.size();i++)
				oosTirages.writeObject(tirages.get(i));

			for(VueJoueur v: equipes.getEquipes())
				oosEquipes.writeObject(v);

			fosPert.close();
			oosPert.close();
			fosTirages.close();
			oosTirages.close();
			fosEquipes.close();
			oosEquipes.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
		finally {
            System.out.println("La sauvegarde a bien été effectuée.");
        }
	}

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
        	FileInputStream fisPert = new FileInputStream("src/Sauvegarde/"+nomFichier+"/Pert");
        	ObjectInputStream oisPert = new ObjectInputStream(fisPert);
        	FileInputStream fisTirages = new FileInputStream("src/Sauvegarde/"+nomFichier+"/Tirages");
        	ObjectInputStream oisTirages = new ObjectInputStream(fisTirages);
        	FileInputStream fisEquipes = new FileInputStream("src/Sauvegarde/"+nomFichier+"/Equipes");
        	ObjectInputStream oisEquipes = new ObjectInputStream(fisEquipes);

			description.getPlateau().clear();
			while(fisPert.available() != 0) {
				description.getPlateau().add((Tache) oisPert.readObject());
			}

			tirages.clear();
			int j = 0;
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
}