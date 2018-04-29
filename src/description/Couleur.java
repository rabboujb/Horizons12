package description;


import java.util.Random;


/**
 *
 * @author diallo
 */

/**
 *
 * Déclaration de la liste des couleurs
 */
public enum Couleur {
    ROUGE, ORANGE, VERT;

	/**
	 * Choisit aléatoirement une couleur avec les probabilités associées.
	 * @return Couleur choisie.
	 */
	public static Couleur tirage() {
        Random rand = new Random();

        int nb = rand.nextInt(6);

        if(nb >= 0 && nb < 3)
			return ROUGE;
		else if(nb > 2 && nb < 5)
			return ORANGE;
		else
			return VERT;
    }
}