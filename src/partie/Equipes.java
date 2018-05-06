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

	public Equipes(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public int getCaisse()                  { return caisse;        }
	public String getNom()                  { return nomEquipe;     }
	public int getQualite()                 { return qualite;       }
	public void baisseQualite(int delta)    { qualite = qualite - delta;}
	public void depense(int somme)          { caisse = caisse - somme;  }
}