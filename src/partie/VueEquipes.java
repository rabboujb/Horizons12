package partie;

import description.*;

import java.util.ArrayList;
import java.util.List;

public class VueEquipes implements VueJoueur, DonneesJoueur {
	private int caisse;
	private Description plateau;
	private String nomEquipe;
	private int numeroTour;
	private int qualite;
	private List<VueJoueur> equipes;

	public boolean tabAcceleration[] = new boolean[8];
	public boolean tabProtection[] = new boolean[24];

	public VueEquipes() {
		this.equipes = new ArrayList<>();
	}

	public VueEquipes(String nomEquipe) {
		this.nomEquipe = nomEquipe;
		this.caisse = 300;
		this.qualite = 100;
		this.plateau = new Description();
	}

	public List<VueJoueur> getEquipes() { return equipes;       }

	public void FinDuTour()             {   }
	public int getCaisse()              { return caisse;        }
	public int getCurrent(String id)    { return 0;             }
	public String getDebutId()          { return getPlateau().getTacheById("1").getId();        }
	public Description getPlateau()     { return plateau;       }
	public int getDuree(String id)      { return getPlateau().getTacheById(id).getDureeMax();   }
	public String getFinId()            { return getPlateau().getTacheById("8").getId();        }
	public String getNom()              { return nomEquipe;     }
	public int getNumeroTour()          { return numeroTour;    }
	public int getQualite()             { return qualite;       }
	public void baisseQualite(int delta)    { qualite = qualite - delta;}
	public void depense(int somme)          { caisse = caisse - somme;  }

	public void creerTab() {
		for(int i=0;i<tabAcceleration.length;i++)
			tabAcceleration[i] = false;

		for(int i=0;i<tabProtection.length;i++)
			tabProtection[i] = false;
	}

	public void setAcceleration(String id, boolean active) {
		tabAcceleration[Integer.parseInt(id) - 1] = active;
	}

	public void setProtection(String id, Couleur couleur, boolean active) {
		int idCouleur = 0;

		if(couleur == Couleur.ROUGE)    idCouleur = 0;
		if(couleur == Couleur.ORANGE)   idCouleur = 1;
		if(couleur == Couleur.VERT)     idCouleur = 2;

		tabProtection[((Integer.parseInt(id) - 1) * 3) + idCouleur] = active;
	}
}