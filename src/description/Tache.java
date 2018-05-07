package description;

import java.util.Collection;

/**
 * Représente une tâche telle que définie par la structure du jeu
 *
 * @author Equipe Horizons12
 */

public interface Tache {
		
	/** 
	 * Indique le cout de l'accélération en euros
	 * @return le cout d'accélération de la tâche
	 */
	public int coutAcceleration();
	
	/** 
	 * Fournit l'alea associé à une couleur pour la tâche courante
	 * @return l'alea associé à la couleur
	 */
	public Alea getAlea(Couleur couleur);
	
	/** 
	 * Fournit la description de la tâche
	 * @return la description de la tâche (de l'ordre de 10 à 30 caractères)
	 */
	public String getDescription();
	
	/** 
	 * Fournit la durée initiale de la tâche
	 * @return la durée initiale de la tâche
	 */
	public int getDureeInitiale();
	
	/**
	 * Fournit la durée maximale de la tâche
	 * @return la durée maximale de la tâche
	 */
	public int getDureeMax();
	
	/**
	 * Donne l'identifiant de la tâche
	 * @return la tâche désignée
	 */
	public String getId();
	
	/**
	 * Fournit la liste des tâches précédentes
	 * @return la collection des tâches précédentes
	 */
	public Collection<Tache> getPredecesseurs();
	
	/**
	 * Fournit la lliste des tâches suivantes
	 * @return la liste des tâches suivantes
	 */
	public Collection<Tache> getSuccesseurs();

}
