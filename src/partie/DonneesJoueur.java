package partie;

/**
 * Représentation de l'état d'une équipe au cours de la partie.
 *
 * @author mickael
 */

public interface DonneesJoueur {

    /** Méthode de calcul du niveau d'avancement d'un projet */
    public void actualisation(int temps);

    /** Méthode qui permet d'appliquer une baisse de qualité au produit */
    public void baisseQualite(int delta);

    /** Méthode qui permet d'appliquer un malus de coût */
    public void depense(int somme);

    /**
     * Fournit le montant actuel de la caisse de l'équipe (en euros).
     * @return le montant de la caisse
     */
    public int getCaisse();

    /**
     * Fournit le nom de l'équipe.
     * @return le nom de l'équie
     */
    public String getNom();

    /**
     * Fournit la qualité actuelle du produit.
     * @return le qualité du produit
     */
    public int getQualite();

    /**
     * Fournit le l'état de réalisation de la tâche.
     * @param id - L'identifiant de la tâche réalisée.
     * @return La réalisation de la tâche (pour l'équipe courante)
     */
    public Realisation getRealisation(String id);

    /**
     * Fournit l'objet qui prend les décisions pour l'équipe.
     * @return IHM ou Robot
     */
    public Strategie getStrategie();
}
