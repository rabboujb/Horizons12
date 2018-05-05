package partie;

import description.Description;

/**
 * Représentation de l'état d'une équipe au cours de la partie.
 *
 * @author mickael
 */

public interface DonneesJoueur {
	Description getPlateau();

    /**
     * Fournit le montant actuel de la caisse de l'équipe (en euros).
     * @return le montant de la caisse
     */
    int getCaisse();

    /**
     * Fournit le nom de l'équipe.
     * @return le nom de l'équie
     */
    String getNom();

    /**
     * Fournit la qualité actuelle du produit.
     * @return le qualité du produit
     */
    int getQualite();
}
