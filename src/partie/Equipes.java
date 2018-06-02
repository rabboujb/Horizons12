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
	public boolean tabAcceleration[] = new boolean[8];
	public boolean tabProtection[] = new boolean[24];


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