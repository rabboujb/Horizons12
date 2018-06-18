package partie;
import java.io.Serializable;

/**
 * @author Bilal RABBOUJ
 */


public class Equipes implements DonneesJoueur, Serializable {
	private String nomEquipe;
	private int caisse;
	private int qualite;

	/**
	 * Constructeur de la classe Equipes
	 * Contient les données joueurs
	 * @param nomEquipe
	 * @param caisse
	 * @param qualite
	 */
	public Equipes(String nomEquipe, int caisse, int qualite) {
		this.nomEquipe = nomEquipe;
		this.caisse = caisse;
		this.qualite = qualite;
	}

	/**
	 * Renvoie le montant de la caisse
	 */
	public int getCaisse()                  { return caisse;        }

	/**
	 * Renvoie le nom d'une équipe
	 * @return Le nom d'une équipe
	 */
	public String getNom()                  { return nomEquipe;     }

	/**
	 * Renvoie la qualité
	 * @return La qualité
	 */
	public int getQualite()                 { return qualite;       }

	/**
	 * Actualisation de la qualité
	 * @param delta
	 */
	public void baisseQualite(int delta)    { qualite = getQualite() - delta;}

	/**
	 * Actualise le montant de la caisse
	 * @param somme
	 */
	public void depense(int somme)          { caisse = getCaisse() - somme;  }

	/**
	 * toString
	 * @return Le nom d'équipe, la caisse et la qualité d'un joueur
	 */
	public String toString() {
		return "Equipes{" +
				"nomEquipe='" + nomEquipe + '\'' +
				", caisse=" + caisse +
				", qualite=" + qualite +
				'}';
	}
}