package partie;

import description.*;
import java.util.ArrayList;
import java.util.List;

public class VueEquipes implements VueJoueur, DonneesJoueur {
	private int caisse;
	private DescriptionObsolete plateau;
	private String nomEquipe;
	private int numeroTour;
	private int qualite;
	private List<VueJoueur> equipes;
	private Equipes donneesEquipe;

	private boolean tabAcceleration[];
	private boolean tabProtection[];

	public VueEquipes() {
		this.equipes = new ArrayList<>();
	}

	public VueEquipes(String nomEquipe) {
		this.nomEquipe = nomEquipe;
		this.caisse = 300;
		this.qualite = 100;
		this.plateau = new DescriptionObsolete();
		this.donneesEquipe = new Equipes(nomEquipe, caisse, qualite);
		this.tabAcceleration = new boolean[8];
		this.tabProtection = new boolean[24];
		this.numeroTour = 0;
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

	public boolean[] getTabA()          { return tabAcceleration;       }
	public boolean[] getTabP()          { return tabProtection;         }
	public boolean getIdTabA(int id)    { return tabAcceleration[id];   }
	public boolean getIdTabP(int id)    { return tabProtection[id];     }

	public int getDureeReelle()         { return 0; }

	public void finDuTour()             { numeroTour++;         }
	public int getCaisse()              { return caisse;        }
	public int getCurrent(String id)    { return 0;             }
	public String getDebutId()          { return getPlateau().getTacheById("1").getId();        }
	public DescriptionObsolete getPlateau()     { return plateau;       }
	public int getDuree(String id)      { return getPlateau().getTacheById(id).getDureeMax();   }
	public String getFinId()            { return getPlateau().getTacheById("8").getId();        }
	public String getNom()              { return nomEquipe;     }
	public int getNumeroTour()          { return numeroTour;    }
	public int getQualite()             { return qualite;       }

	public void baisseQualite(int delta)    { qualite = qualite - delta;}
	public void depense(int somme)          { caisse = caisse - somme;  }
	public void actualisation(int temps)    {   }

//	public void creerTab() {
//		for(int i=0;i<tabAcceleration.length;i++)
//			tabAcceleration[i] = false;
//
//		for(int i=0;i<tabProtection.length;i++)
//			tabProtection[i] = false;
//	}

	public void setAcceleration(String id, boolean active) {
		tabAcceleration[Integer.parseInt(id) - 1] = active;
	}

	public void setProtection(String id, Couleur couleur, boolean active) {
		int tabCase = 0;

		if(couleur == Couleur.ROUGE)
			tabCase = ((Integer.parseInt(id) - 1) * 3);
		if(couleur == Couleur.ORANGE)
			tabCase = ((Integer.parseInt(id) - 1) * 3) + 1;
		if(couleur == Couleur.VERT)
			tabCase = ((Integer.parseInt(id) - 1) * 3) + 2;

		tabProtection[tabCase] = active;
	}
}