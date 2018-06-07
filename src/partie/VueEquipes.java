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
	private int qualite;
	private int current;
	private List<VueJoueur> equipes;
	private Equipes donneesEquipe;
	private List<Realisation> realisations;

	public VueEquipes() {
		this.equipes = new ArrayList<>();
	}

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
	}

	public List<Realisation> getRealisations() { return realisations; }
	public Realisation getRealisation(int idTache) {
		for(Realisation r: realisations)
			if(r.getIdTache() == idTache)
				return r;
		return null;
	}

	public DonneesJoueur getDonneesEquipe()         { return donneesEquipe; }
	public List<VueJoueur> getEquipes()             { return equipes;       }

	public VueJoueur getEquipe(String nomEquipe)    {
		for(VueJoueur v: equipes) {
			if(nomEquipe.equals(v.getNom()))
				return v;
		}
		return null;
	}

	public void ajouterEquipe(VueJoueur equipe)     { equipes.add(equipe);  }

	public void finDuTour()             { numeroTour++;         }
	public int getCaisse()              { return caisse;        }
	public int getCurrent(String id)    { return 0;             }
	public String getDebutId()          { return getPlateau().getTacheById(1).getNOM(); }
	public Description getPlateau()     { return plateau;       }
	public int getDuree(int id)         { return getPlateau().getTacheById(id).getSEMAINES_MAX();   }
	public String getFinId()            { return getPlateau().getTacheById(8).getNOM();             }
	public String getNom()              { return nomEquipe;     }
	public int getNumeroTour()          { return numeroTour;    }
	public int getQualite()             { return qualite;       }

	public void baisseQualite(int delta)    { qualite = qualite - delta;}
	public void depense(int somme)          { caisse = caisse - somme;  }
	public void actualisation(int temps)    {
	}

	public String toString() {
		return "VueEquipes{" +
				", nomEquipe='" + nomEquipe + '\'' +
				", numeroTour=" + numeroTour +
				'}';
	}
}