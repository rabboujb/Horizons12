package partie;

public interface VueJoueur {

    /** Termine le tour pour le joueur courant.*/
    public void FinDuTour();

    /** Fournit le montant actuel de la caisse de l'équipe (en euros). */
    public int getCaisse();

    /** Fournit l'état d'avancement de la réalisation d'une tâche pour l'équipe (en semaines). */
    public int getCurrent(String id);

    /** Fournit l'identifiant de la première tâche du PERT. */
    public String getDebutId();

    /** Retourne l'objet permettant d'acquérir la description de la configuration de jeu. */
    public Description getDescription();

    /** Fournit la durée réelle d'une tâche pour l'équipe. */
    public int getDuree(String id);

    /** Fournit l'état courant de la réalisation. */
    public Etat getEtat(String id);

    /** Fournit l'identifiant de la dernière tâche du PERT. */
    public String getFinId();

    /** Fournit le nom de l'équipe. */
    public String getNom();

    /** Fournit le numéro du tour courant. */
    public int getNumeroTour();

    /** Fournit la qualité actuelle du produit. */
    public int getQualite();

    /** Active ou désactive l'accélération de la tâche (réducton de 1 de la durée réelle). */
    public void setAcceleration(String id, boolean active);

    /** Active ou désactive la protection contre un alea. */
    public void setProtection(String id, Couleur couleur, boolean active);
}
