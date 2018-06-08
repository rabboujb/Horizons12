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
 * @author Ismerie
 */

public class Pert {
    ArrayList<Realisation> realisations = new ArrayList<>();
	Tache alpha;
	Tache omega;
	Realisation realAlpha; 
	Realisation realOmega;
	
    public Pert(ArrayList<Realisation> realisations){
    	this.realisations=realisations;
    	// on intitialise le marque et les dates au plus tot / au plus tard
    	for(Realisation real : this.realisations){
    		//real.setMarque(false);
    		real.setDateAuPlusTard(0);
    		real.setDateAuPlusTot(0);
    	}
	}
    
    // Calcul de la date au plus tot de chaque realisation
    public void calculDateAuPlusTot() {
    	// on parcourt la liste des realisations
    	for(int i = 0; i < this.realisations.size(); i++){
			Realisation temp = this.realisations.get(i);
			//si la tache de la realisation n'a pas de predecessuers, cela veut dire que c'est la premiere tache
			//donc la date au plus tot=0
			if(temp.getTACHE().getPREDECESSEUR().size()==0){
				this.realisations.get(i).setDateAuPlusTot(0);
				//temp.setDateAuPlusTot(0);
			}
			else{
				// on parcourt la liste des predecesseurs de la tache de la realisation
                int max = 0;
                int calcul = 0;
				for(int j=0; j< temp.getTACHE().getPREDECESSEUR().size();j++) {
					//boucle qui parcourt toutes les réalisations pour retrouver celle du predecesseur
					for(int k = 0; k < this.realisations.size(); k++){
						if(this.realisations.get(k).getIdTache()==temp.getTACHE().getPREDECESSEUR().get(j)){
		                    calcul = this.realisations.get(k).getDateAuPlusTot() + this.realisations.get(k).getSemainesReel();
		                    if (calcul > max) {
		                        max = calcul;
		                    }
						}
					}
				}
				this.realisations.get(i).setDateAuPlusTot(max);
				//temp.setDateAuPlusTot(max);
			}
    	}
    }

    /**
     * Calcul de la date au plus tard de chaque realisation
     *
     */
    public void calculDateAuPlusTard() {
        // On parcourt la liste des realisations de la fin au debut
        for (int i = this.realisations.size() - 1; i >= 0; i--) {
			Realisation temp = this.realisations.get(i);

            // s'il n'y a pas de successeur la date au plus tard est la date au plus tot
			if(temp.getTACHE().getSUCCESSEUR().size()==0){
                
				this.realisations.get(i).setDateAuPlusTard(temp.getDateAuPlusTot());
				//temp.setDateAuPlusTard(temp.getDateAuPlusTot());
            } else {
                int min = Integer.MAX_VALUE;
                int calcul = 0;
                // Si il y a des successeurs il faut faire le calcul avec la date au plus tard
                // minimum des successeurs
                // Boucle qui recupere la date au plus tard minimun des successeurs
				for(int j=0; j< temp.getTACHE().getSUCCESSEUR().size();j++) {
					//boucle qui parcourt toutes les réalisations pour retrouver celle du successeur
					for(int k = 0; k < this.realisations.size(); k++){
						if(this.realisations.get(k).getIdTache()==temp.getTACHE().getSUCCESSEUR().get(j))
						{
		                    calcul = this.realisations.get(k).getDateAuPlusTard() + this.realisations.get(k).getSemainesReel();
		                    if (this.realisations.get(k).getDateAuPlusTard() < min) {
		                        min = this.realisations.get(k).getDateAuPlusTard();
		                    }
						}
					}
				
				}
                // Le calcul correspond au min de la date au plus tard des successeurs - duree
                // de la tache
                calcul = min - temp.getSemainesReel();
                this.realisations.get(i).setDateAuPlusTard(calcul);
                //temp.setDateAuPlusTard(calcul);
            }
        }
    }    

	
	/**
	 * Construit la tache alpha celle qui sera le predecesseur de la tache 1
	 * @param ArrayList<Realisation>
	 * @return alpha
	 */
	public Tache construitAlpha(ArrayList<Realisation> realisations){
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
	public Tache construitOmega(ArrayList<Realisation> realisations){
		
		Tache omega = new Tache("Omega",0,0,0,null,null,null, new ArrayList <Integer>(),new ArrayList <Integer>());
		
		for(Realisation real : realisations){
			if (real.getTACHE().getSUCCESSEUR().size()==0){
				real.getTACHE().addSuccesseur(omega.getID());
			}		
		}
		return omega;	
    
	}
	
	/*
	 * Methode d'affichage des dates au plus et date au plus tard
	 * de chaque realisation
	 */
	public void afficheTemps() {
		for (int i = 0; i<this.realisations.size(); i++){
			System.out.print("tache: "+this.realisations.get(i).getTACHE().getNOM()+" Date au plus tot="+this.realisations.get(i).getDateAuPlusTot()+" Date au plus tard="+this.realisations.get(i).getDateAuPlusTard()+ "\n");
		}
	}

	/**
	 * Renvoie les realisations sur le chemin critique 
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
