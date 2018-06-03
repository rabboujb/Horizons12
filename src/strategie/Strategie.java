package strategie;
import description.Couleur;
import partie.VueJoueur;

/**
 * @author Bilal RABBOUJ
 */

public interface Strategie {
	void jouerEtape(VueJoueur vue);
	void jouerJalon(VueJoueur vue);
	Couleur getTirage(int id);
}