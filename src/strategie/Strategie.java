/**
 * @author Bilal RABBOUJ
 */

package strategie;
import partie.VueJoueur;

public interface Strategie {
	void jouerEtape(VueJoueur vue);
	void jouerJalon(VueJoueur vue);
}