package partie;

import java.util.ArrayList;
import java.util.Arrays;

import description.Tache;

/**
 * Class de construction du pert, permettant de connaitre
 * la date au plus tôt, la date au plus tard
 * la marge libre, et le chemin critique
 * 
 * @author Ismérie
 */

public class Pert {
    ArrayList<Realisation> realisations = new ArrayList<>();

    /*for (Tache tache : description.getPlateau()) {
        realisations.add(new Realisation(tache));
    }*/
    
    public Pert(ArrayList<Realisation> realisations){
    	this.realisations=realisations;

	}
    
	public void calculeTempsAuPlusTot(){
		//cree la tache initiale fictive en lui trouvant pour 
		//successeur toutes les taches qui n'ont pas de prédécesseurs
		Tache alpha = construitAlpha(realisations);
		
		//Cree la tache finale fictive en lui trouvant pour predecesseur
		//toutes les taches qui n'ont pas de successeur
		//Tache tacheFinale = construitTFinale(realisations.length, taches);
		//condition initiale à l'algo on marque T0 et on lui
		//affecte la date au plus tot nulle
		//alpha.setMarque(true);
		//alpha.setTempsAuPlusTot(0);
		//nonMarque est l'index de la premiere tache non marquee
		//trouvee si il vaut -1 c'est qu'on ne peut plus en trouver
		//la boucle s'arrete
		//int nonMarque = trouveNonMarqueAvecTousPredecesseursMarque(taches);
		/*while (nonMarque != -1  ){
			//on marque la tache traitee
			taches[nonMarque].setMarque(true);
			//on calcul son temps au plus tot
			int tempsAuPlusTot = calculTempsAuPlusTot(taches[nonMarque]);
			//et on le met dans la tache
			taches[nonMarque].setTempsAuPlusTot(tempsAuPlusTot);
			//et on continue avec la prochaine tache non marquee suivante
			nonMarque = trouveNonMarqueAvecTousPredecesseursMarque(taches);
		}
		//on finalise avec la dernière tache
		int tempsAuPlusTotFinal = calculTempsAuPlusTot(tacheFinale);
		tacheFinale.setTempsAuPlusTot(tempsAuPlusTotFinal);*/
	}
	
	
	/**
	 * Construit la tache alpha celle qui sera le predecesseur de la tache 1
	 * @param ArrayList<Realisation>
	 * @return alpha
	 */
	public static Tache construitAlpha(ArrayList<Realisation> realisations){
		Tache alpha = new Tache("Alpha",0,0,0,null,null,null, new ArrayList <Integer>(),new ArrayList <Integer>());
		
		for(Realisation real : realisations){
			if (real.getTACHE().getPREDECESSEUR().size()==0){
				alpha.addSuccesseur(real.getIdTache());
			}		
		}
		return alpha;
	}
	
    
}
