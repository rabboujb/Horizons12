package description;

/**
 * Représente un des aleas envisagé durant le déroulement du jeu
 *
 * @author Equipe Horizons12
 */


public interface Alea {

	/** Méthode qui applique l'aléa sur l'équipe et la réalisation passée en paramètre	*/
	//public void appliquer(Donnees joueur, partie.RealisationConcrete realisationConcrete);
		
	
	/** 
	 * Indique la gravité d'un aléa
	 * @return le niveau de gravité de l'aléa
	 */
	public int getGravite();
	
	/** 
	 * Indique le type d'impact de l'alea
	 * @return le type d'aléa
	 *  */
	public TypeAlea getType();
	
}