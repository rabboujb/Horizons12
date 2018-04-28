package partie;
import description.*;

import java.util.ArrayList;
import java.util.List;

public class PartieTest implements VueJoueur, DonneesJoueur {

	private String nomEquipe;
	private int caisse;
	private int qualite;
	private List<DonneesJoueur> equipes;

	public PartieTest() {
		this.equipes = new ArrayList<>();
	}

	public PartieTest(String nomEquipe) {
		this.nomEquipe = nomEquipe;
		this.caisse = 300;
		this.qualite = 100;
	}

	public void ajouterEquipe(DonneesJoueur equipe) {
		equipes.add(equipe);
	}

	public void FinDuTour() 				{	}
	public void actualisation(int temps)	{	}
	public void baisseQualite(int delta)	{	}
	public void depense(int somme)			{	}
	public int getCaisse()					{ return caisse; }
	public int getCurrent(String id)		{ return 0; }
	public String getDebutId()				{ return null; }
	public Description getDescription()		{ return null; }
	public int getDuree(String id)			{ return 0; }
	public String getFinId()				{ return null; }
	public String getNom()                  { return nomEquipe; }
	public int getNumeroTour()              { return 0; }
	public int getQualite()                 { return qualite; }

	public List<DonneesJoueur> getEquipes() { return equipes; }
	public DonneesJoueur getEquipeByNom(String id) {
		for(DonneesJoueur e: equipes) {
			if(e.getNom().equals(id))
			return e;
		}
		return null;
	}

	public void setAcceleration(String id, boolean active)  {
	}
	public void setProtection(String id, Couleur couleur, boolean active) {
	}
}