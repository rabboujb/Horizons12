package partie;
import description.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal RABBOUJ
 */

public class VueEquipes implements VueJoueur, DonneesJoueur, Serializable {
	private int caisse;
	private Description plateau;
	private String nomEquipe;
	private int numeroTour;
	private int numeroTache;
	private int qualite;
	private int current;
	private List<VueJoueur> equipes;
	private Equipes donneesEquipe;
	private ArrayList<Realisation> realisations;

	/**
	 * Constructeur de la classe VueEquipes
	 * Création d'une liste de type <VueJoueur>
	 */
	public VueEquipes() {
		this.equipes = new ArrayList<>();
	}

	/**
	 * Constructeur de la classe VueEquipes
	 * Ajout des informations d'une équipe
	 * @param nomEquipe
	 * @param description
 	 */
	public VueEquipes(String nomEquipe, Description description) {
		this.nomEquipe = nomEquipe;
		this.caisse = 300;
		this.qualite = 100;
		this.plateau = description;
		this.realisations = new ArrayList<>();
		for(Tache tache : plateau.getPlateau())
			realisations.add(new Realisation(tache));
		this.donneesEquipe = new Equipes(nomEquipe, caisse, qualite);
		this.numeroTour = 0;
		this.numeroTache = 1;
	}

	/**
	 * Liste des réalisations d'une équipe
	 * @return Liste de réalisations
	 */
	public ArrayList<Realisation> getRealisations() { return realisations; }

	/**
	 * Réalisation
	 * @param idTache
	 * @return Réalisation
	 */
	public Realisation getRealisation(int idTache) {
		for(Realisation r: realisations)
			if(r.getIdTache() == idTache)
				return r;
		return null;
	}

	/**
	 * Données d'une équipe
	 * @return Données d'une équipe
	 */
	public DonneesJoueur getDonneesEquipe()         { return donneesEquipe; }

	/**
	 * Liste des équipes
	 * @return La liste des équipes
	 */
	public List<VueJoueur> getEquipes()             { return equipes;       }

	/**
	 * Equipe
	 * @param nomEquipe
	 * @return Une équipe
	 */
	public VueJoueur getEquipe(String nomEquipe)    {
		for(VueJoueur v: equipes) {
			if(nomEquipe.equals(v.getNom()))
				return v;
		}
		return null;
	}

	/**
	 * Ajouter une équipe
	 * @param equipe
	 */
	public void ajouterEquipe(VueJoueur equipe)     { equipes.add(equipe);  }

	/**
	 * Incrémente le numéro du tour
	 */
	public void finDuTour()             { numeroTour++;         }

	/**
	 * Incrémente le numéro de la tâche
	 */
	public void finDeTache()            { numeroTache++;        }

	/**
	 * Renvoie le montant de la caisse
	 */
	public int getCaisse()              { return caisse;        }

	public int getCurrent(String id)    { return 0;             }

	/**
	 * Renvoie la première tâche
	 * @return Première tâche
	 */
	public String getDebutId()          { return getPlateau().getTacheById(1).getNOM(); }

	/**
	 * Renvoie le plateau
	 * @return Le plateau de jeu
	 */
	public Description getPlateau()     { return plateau;       }

	/**
	 * Renvoie la durée maximale d'une tâche
	 * @param id
	 * @return La durée maximale d'une tâche
	 */
	public int getDuree(int id)         { return getPlateau().getTacheById(id).getSEMAINES_MAX();   }

	/**
	 * Renvoie la dernière tâche
	 * @return La dernière tâche
	 */
	public String getFinId()            { return getPlateau().getTacheById(8).getNOM();             }

	/**
	 * Renvoie le nom d'une équipe
	 * @return Le nom d'une équipe
	 */
	public String getNom()              { return nomEquipe;     }

	/**
	 * Renvoie le numéro du tour
	 * @return Le numéro du tour
	 */
	public int getNumeroTour()          { return numeroTour;    }

	/**
	 * Renvoie le numéro de la tâche
	 * @return Le numéro de la tâche
	 */
	public int getNumeroTache()         { return numeroTache; }

	/**
	 * Renvoie la qualité
	 * @return La qualité
	 */
	public int getQualite()             { return qualite;       }

	/**
	 * Actualisation de la qualité
	 * @param delta
	 */
	public void baisseQualite(int delta)    { qualite = qualite - delta;}

	/**
	 * Actualise le montant de la caisse
	 * @param somme
	 */
	public void depense(int somme)          { caisse = caisse - somme;  }

	/**
	 * toString
	 * @return Le nom d'équipe et le numéro du tour
	 */
	public String toString() {
		return "VueEquipes{" +
				", nomEquipe='" + nomEquipe + '\'' +
				", numeroTour=" + numeroTour +
				'}';
	}
}