package partie;
import description.*;

import java.util.ArrayList;
import java.util.List;

public class PartieTest implements VueJoueur, DonneesJoueur {

	private String nomEquipe;
	private int caisse;
	private int qualite;
	private List<DonneesJoueur> equipes;

	public PartieTest(String nomEquipe) {
		this.nomEquipe = nomEquipe;
		this.caisse = 300;
		this.qualite = 100;
		this.equipes = new ArrayList<>();
	}

	public void FinDuTour() 				{	}
	public void actualisation(int temps)	{	}
	public void baisseQualite(int delta)	{	}
	public void depense(int somme)			{	}
	public int getCaisse()					{ return 0; }
	public int getCurrent(String id)		{ return 0; }
	public String getDebutId()				{ return null; }
	public Description getDescription()		{ return null; }
	public int getDuree(String id)			{ return 0; }
	public String getFinId()				{ return null; }
	public String getNom()                  { return null; }
	public int getNumeroTour()              { return 0; }
	public int getQualite()                 { return 0; }

	public void setAcceleration(String id, boolean active)  {
	}
	public void setProtection(String id, Couleur couleur, boolean active) {
	}
}