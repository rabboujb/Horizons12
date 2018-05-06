/**
 * @author Bilal RABBOUJ
 */

package strategie;
import partie.VueJoueur;

public class Robot implements Strategie {
	public Robot() {
	}

	public void jouerEtape(VueJoueur vue) {
		// Validation d'un tour simple
	}

	public void jouerJalon(VueJoueur vue) {
		System.out.println(vue.getNom());
		System.out.println(vue.getCaisse());
		System.out.println(vue.getQualite());
	}
}