package menu;
import description.Couleur;
import description.Description;
import description.Tache;
import description.TypeTour;
import partie.VueEquipes;
import partie.VueJoueur;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bilal RABBOUJ
 */

public class MenuSauvegarde {
	private VueJoueur equipes;
	private Description description;
	private List<Couleur> tirages;
	private int affichageTour;

	public MenuSauvegarde(VueJoueur equipes, Description description, List<Couleur> tirages, int affichageTour) {
		this.equipes = equipes;
		this.description = description;
		this.tirages = tirages;
		this.affichageTour = affichageTour;
	}

	public void sauvegarde() {
//		DateFormat df = new SimpleDateFormat("dd/MM/yy");
//		Date dateSauvegarde = new Date();

        try {
//            String nomFichier = "Partie-"+d.format(dateSauvegarde).replaceAll("/", "-");
        	FileOutputStream fos = new FileOutputStream("src/Sauvegarde");
        	ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject("===  PERT  ===");
			for(Tache d: description.getPlateau()) {
				oos.writeObject("Tâche "+d.getID());
				oos.writeObject(d.getNOM());
				oos.writeObject("Coût d'accélération : "+d.getCOUT()+" €");
				oos.writeObject("Durée initiale : "+d.getSEMAINES()+" semaines");
				oos.writeObject("Durée maximale : "+d.getSEMAINES_MAX()+" semaines");
				oos.writeObject("Prédecesseurs :");
				for(Integer p: d.getPREDECESSEUR()) {
					if(d.getPREDECESSEUR().size() == 0)
						oos.writeObject("\tAucun");
					else
						oos.writeObject("\tTâche "+p);
				}
				oos.writeObject("Successeurs :");
				for(Integer s: d.getSUCCESSEUR()) {
					if(d.getSUCCESSEUR().size() == 0)
						oos.writeObject("\tAucun");
					else
						oos.writeObject("\tTâche : "+s);
				}
				oos.writeObject(d.getAlea(Couleur.ROUGE).toString());
				oos.writeObject(d.getAlea(Couleur.ORANGE).toString());
				oos.writeObject(d.getAlea(Couleur.VERT).toString());
				oos.writeObject("\n");
			}

			oos.writeObject("===  TIRAGES JOUÉS  ===");
			for(int i=0;i<affichageTour;i++) {
				if(tirages.size() == 0)
					oos.writeObject("Aucun tirage");
				else {
					if(description.getTours().get(i).getTYPE() != TypeTour.JALON)
						oos.writeObject("Tour "+i+" : "+tirages.get(i));
				}
			}
			oos.writeObject("\n");

			oos.writeObject("===  ÉQUIPES  ===");
			for(VueJoueur e: equipes.getEquipes()) {
				oos.writeObject(e.getNom());
				oos.writeObject("Tour "+e.getNumeroTour());
				oos.writeObject("Caisse : "+e.getDonneesEquipe().getCaisse()+" €");
				oos.writeObject("Qualité : "+e.getDonneesEquipe().getQualite()+" %");
				if(e.getPlateau().getTours().get(e.getNumeroTour()).getTYPE() != TypeTour.JALON)
					oos.writeObject("Semaines réelles : "+e.getRealisation(e.getNumeroTour()).getSemainesReel());
				oos.writeObject("\n");
			}

			fos.close();
			oos.close();
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
}