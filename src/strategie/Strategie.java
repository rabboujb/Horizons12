/**
 * @author Bilal RABBOUJ
 */

package strategie;
import description.Couleur;
import partie.VueJoueur;

public interface Strategie {
	void jouerEtape(VueJoueur vue);
	void jouerJalon(VueJoueur vue);
	Couleur getTirage(int id);
}