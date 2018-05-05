/**
 * @author Bilal RABBOUJ
 */

package partie;
import description.*;

import java.util.ArrayList;
import java.util.List;

public class Equipes implements DonneesJoueur {
	private String nomEquipe;
	private int caisse;
	private int qualite;
	private Description description;
	private List<DonneesJoueur> equipes;
	public boolean tabA[] = new boolean[8];
	public boolean tabP[] = new boolean[24];

	public Equipes() {  this.equipes = new ArrayList<>();	}

	public Equipes(String nomEquipe) {
		this.nomEquipe = nomEquipe;
		this.caisse = 300;
		this.qualite = 100;
		this.description = new Description();
	}

	public void creerTab() {
		for(int i=0;i<tabA.length;i++)
			tabA[i] = false;

		for(int i=0;i<tabP.length;i++)
			tabP[i] = false;
	}

	public void ajouterEquipe(DonneesJoueur equipe) { equipes.add(equipe); }
	public void getEquipe(String id)        { equipes.get(Integer.parseInt(id)); }
	public Description getPlateau()         { return description;   }
	public int getCaisse()                  { return caisse;        }
	public String getNom()                  { return nomEquipe;     }
	public int getQualite()                 { return qualite;       }
	public List<DonneesJoueur> getEquipes() { return equipes;       }

	public void setAcceleration(String id, boolean active) {
		tabA[Integer.parseInt(id) - 1] = active;
	}

	public void setProtection(String id, Couleur couleur, boolean active) {
		int idCouleur = 0;

		if(couleur == Couleur.ROUGE)   idCouleur = 0;
		if(couleur == Couleur.ORANGE)   idCouleur = 1;
		if(couleur == Couleur.VERT)     idCouleur = 2;

		tabP[((Integer.parseInt(id) - 1) * 3) + idCouleur] = active;
	}
}