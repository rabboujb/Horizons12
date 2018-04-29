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
	private List<DonneesJoueur> equipes;

	public Equipes() {
		this.equipes = new ArrayList<>();
	}

	public Equipes(String nomEquipe) {
		this.nomEquipe = nomEquipe;
		this.caisse = 300;
		this.qualite = 100;
	}

	public void ajouterEquipe(DonneesJoueur equipe) {
		equipes.add(equipe);
	}

	public void actualisation(int temps)    {   }
	public void baisseQualite(int delta)    {
		qualite = qualite - delta;
	}
	public void depense(int somme)          {
		caisse = caisse - somme;
	}
	public int getCaisse()                  { return caisse; }
	public String getNom()                  { return nomEquipe; }
	public int getQualite()                 { return qualite; }
	public List<DonneesJoueur> getEquipes() { return equipes; }

	public void setAcceleration(String id, boolean active)  { }
	public void setProtection(String id, Couleur couleur, boolean active)   { }
}