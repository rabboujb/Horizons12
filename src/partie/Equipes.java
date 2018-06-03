package partie;
import java.io.Serializable;

/**
 * @author Bilal RABBOUJ
 */


public class Equipes implements DonneesJoueur, Serializable {
	private String nomEquipe;
	private int caisse;
	private int qualite;

	public Equipes(String nomEquipe, int caisse, int qualite) {
		this.nomEquipe = nomEquipe;
		this.caisse = caisse;
		this.qualite = qualite;
	}

	public int getCaisse()                  { return caisse;        }
	public String getNom()                  { return nomEquipe;     }
	public int getQualite()                 { return qualite;       }
	public void baisseQualite(int delta)    { qualite = getQualite() - delta;}
	public void depense(int somme)          { caisse = getCaisse() - somme;  }
}