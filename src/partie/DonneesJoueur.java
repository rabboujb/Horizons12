package partie;

import description.Description;

/**
 * Représentation de l'état d'une équipe au cours de la partie.
 *
 * @author mickael
 */

public interface DonneesJoueur {

    int getCaisse();

    String getNom();

    int getQualite();

    void baisseQualite(int delta);

    void depense(int somme);
}
