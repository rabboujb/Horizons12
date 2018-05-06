package partie;

import description.*;

import java.util.ArrayList;
import java.util.List;

public class VueEquipes implements VueJoueur {
	private int caisse;
	private Description plateau;
	private String nomEquipe;
	private int numeroTour;
	private int qualite;

	public boolean tabAcceleration[] = new boolean[8];
	public boolean tabProtection[] = new boolean[24];

	public VueEquipes(String nomEquipe) {
		new Equipes(nomEquipe);
	}

	public VueEquipes() {

	}

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