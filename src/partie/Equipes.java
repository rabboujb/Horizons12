/**
 * @author Bilal RABBOUJ
 */

package partie;
import description.Description;

import java.util.ArrayList;
import java.util.List;

public class Equipes implements DonneesJoueur {
	private String nomEquipe;
	private int caisse;
	private int qualite;
	private Description description;
	private List<DonneesJoueur> equipes;
	public boolean tabB[] = {false, false, false, false, false, false, false, false};

	public Equipes() {  this.equipes = new ArrayList<>();	}

	public Equipes(String nomEquipe) {
		this.nomEquipe = nomEquipe;
		this.caisse = 300;
		this.qualite = 100;
		this.description = new Description();
	}

	public void ajouterEquipe(DonneesJoueur equipe) { equipes.add(equipe); }
	public void getEquipe(String id)        { equipes.get(Integer.parseInt(id)); }
	public Description getPlateau()         { return description;   }
	public int getCaisse()                  { return caisse;        }
	public String getNom()                  { return nomEquipe;     }
	public int getQualite()                 { return qualite;       }
	public List<DonneesJoueur> getEquipes() { return equipes;       }

	public void setAcceleration(String id, boolean active) {
			tabB[Integer.parseInt(id)-1] = true;
	}
}