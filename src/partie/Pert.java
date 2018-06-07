package partie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	Tache alpha;
	Tache omega;
	Realisation realAlpha; 
	Realisation realOmega;

    
    public Pert(ArrayList<Realisation> realisations){
    	this.realisations=realisations;

	}
    
	public void calculeTempsAuPlusTot(){
		//création de la tache initiale fictive en lui trouvant pour 
		//successeur toutes les tâches qui n'ont pas de prédécesseurs
		this.alpha = construitAlpha(realisations);
		
		//création de la tache finale fictive en lui trouvant pour predecesseur
		//toutes les tâches qui n'ont pas de successeurs
		this.omega = construitOmega(realisations);
		
		this.realAlpha = new Realisation(alpha);
		this.realOmega = new Realisation(omega);
		
		//condition initiale à l'algo on marque T0 et on lui
		//affecte la date au plus tot nulle
		realAlpha.setMarque(true);
		realAlpha.setDateAuPlusTot(0);
		
		//nonMarque est l'index de la premiere tache non marquee
		//trouvee si il vaut -1 c'est qu'on ne peut plus en trouver
		//la boucle s'arrete
		int nonMarque = trouveNonMarqueAvecTousPredecesseursMarque();
		while (nonMarque != -1  ){
			//on marque la tache traitee
			this.realisations.get(nonMarque).setMarque(true);
			//on calcul son temps au plus tot
			int tempsAuPlusTot = calculTempsAuPlusTot(this.realisations.get(nonMarque));
			//et on le met dans la tache
			this.realisations.get(nonMarque).setDateAuPlusTot(tempsAuPlusTot);
			//et on continue avec la prochaine tache non marquee suivante
			nonMarque = trouveNonMarqueAvecTousPredecesseursMarque();
		}
		//on finalise avec la dernière tache
		int tempsAuPlusTotFinal = calculTempsAuPlusTot(realOmega);
		realOmega.setDateAuPlusTot(tempsAuPlusTotFinal);
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
	
	/**
	 * Construit la tache omega celle qui sera le successeur de toutes celles
	 * qui n'ont pas de successeurs.
	 * @param ArrayList<Realisation>
	 * @return
	 */
	public static Tache construitOmega(ArrayList<Realisation> realisations){
		
		Tache omega = new Tache("Omega",0,0,0,null,null,null, new ArrayList <Integer>(),new ArrayList <Integer>());
		
		for(Realisation real : realisations){
			if (real.getTACHE().getSUCCESSEUR().size()==0){
				real.getTACHE().addSuccesseur(omega.getID());
			}		
		}
		return omega;	
    
	}
	
	
	/**
	 * Trouve une tâche non marquée dont tous les prédécesseurs sont marqués.
	 * @return
	 */
	public int trouveNonMarqueAvecTousPredecesseursMarque(){
		//boucle qui parcourt toutes les réalisations
		for(int i = 0; i < this.realisations.size(); i++){
			//on récupère à chaque tour la réalisation
			//que l'on met dans une variable temp 
			//pour pouvoir la manipuler
			Realisation temp = this.realisations.get(i);
			
			//on test si la réalisation est marquée
			if (temp.getMarque()){
				continue;
			}
			
			boolean predecesseursTousMarques = true;
			
			//on récupère la tâche de la réalisation temp
			//et de cette tâche on récupère la liste des prédécesseurs
			for(int j=0; j< temp.getTACHE().getPREDECESSEUR().size();j++) {
				//boucle qui parcourt toutes les réalisations
				for(int k = 0; k < this.realisations.size(); k++){
					if(this.realisations.get(k).getIdTache()==temp.getTACHE().getPREDECESSEUR().get(j))
					{
						if(!this.realisations.get(k).getMarque())
						{
							predecesseursTousMarques = false;
						}
					}
				}
				
			}
			
			if (predecesseursTousMarques){
				return i;
			}
		}
		//signifie qu'on a pas pu trouver de non marqué
		return -1;
	}
	
	/**
	 * Calcul le temps au plus tot d'une tache 
	 * 
	 * Le calcul de ce temps est fourni par l'algorithme de Bellman,
	 * tj = max { tk + ex(Tk) } ou k est l'ensemble des predecesseurs de j
	 * 
	 * @param tache
	 * @return
	 */
	public int calculTempsAuPlusTot(Realisation real) {
		int max = 0;
		for(int i=0; i< real.getTACHE().getPREDECESSEUR().size();i++) {		
			//boucle qui parcourt toutes les réalisations
			for(int j = 0; j < this.realisations.size(); j++){
				if(this.realisations.get(j).getIdTache()==real.getTACHE().getPREDECESSEUR().get(i))
				{
					if((this.realisations.get(j).getDateAuPlusTot() + this.realisations.get(j).getSemainesReel())>max)
					{
						max = this.realisations.get(j).getDateAuPlusTot() + this.realisations.get(j).getSemainesReel(); 						
					}
				}
			}
		}
		return max;
	}
	
	public void afficheTempsAuPlusTot() {
		for (int i = 0; i<this.realisations.size(); i++){
			System.out.print("t"+this.realisations.get(i).getIdTache()+"="+this.realisations.get(i).getDateAuPlusTot()+ " ");
		}
	}
	
	/**
	 * Renvoie les taches sur le chemin critique 
	 * cette m�thode ne peut etre appel� qu'apres l'appel
	 * de la m�thode {@link #calculeTempsAuPlusTot()}
	 * @return
	 */
	public List<Realisation> calculeCheminCritique() {
		//On intialise le chemin critique
		List<Realisation> cheminCritique = new ArrayList<Realisation>();
		//on ajoute la tache initiale
//		Tache tacheInitale = taches[0].getPredecesseurs().iterator().next();
		cheminCritique.add(this.realAlpha);
		Realisation realSurLeChemin = this.realAlpha;
		while ((realSurLeChemin = getSuccesseurTempsAuPlusTotMax(realSurLeChemin))!=null){
			cheminCritique.add(realSurLeChemin);
		}		
		return cheminCritique;
	}

	public Realisation getSuccesseurTempsAuPlusTotMax(Realisation Real) {
		Realisation realLaPlusTardive = null;
		int tempsAuPlusTot = 0;
		for(int i=0;i<Real.getTACHE().getSUCCESSEUR().size();i++)
		{
			for(int j = 0; j < this.realisations.size(); j++){
				if(this.realisations.get(j).getIdTache()==Real.getTACHE().getSUCCESSEUR().get(i))
				{
					if (this.realisations.get(j).getDateAuPlusTot() >= tempsAuPlusTot) {
						realLaPlusTardive = this.realisations.get(j);
					}					
				}
			}
		}
		return realLaPlusTardive;
	}
	
	
	
	
}
