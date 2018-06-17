package partie;

import java.util.ArrayList;
import java.util.List;

import description.Tache;

/**
 * Class de construction du pert permettant de
 * connaitre la date au plus tôt, la date au plus tard
 * le chemin critique
 * et de mettre en ordre total le pert
 * 
 * @author Ismerie, Mickael
 */

public class Pert {
    ArrayList<Realisation> realisations = new ArrayList<>();
	Tache alpha;
	Tache omega;
	Realisation realAlpha; 
	Realisation realOmega;
	
    public Pert(ArrayList<Realisation> realisations){
    	this.alpha = construitAlpha(realisations);
    	this.omega = construitOmega(realisations);
    	
    	realAlpha = new Realisation(alpha);
    	realOmega = new Realisation(omega);
    	this.realisations=realisations;
    	this.realisations.add(0, realAlpha);
    	this.realisations.add(realOmega);
    	// on inititialise les dates au plus tot et au plus tard
    	for(Realisation real : this.realisations){
    		real.setDateAuPlusTard(0);
    		real.setDateAuPlusTot(0);
    	}
	}

	/**
	 * Methode qui ordonnance les realisations, elle prend une ArrayList de realisations en parametre
	 * @return ArrayList de realisations ordonnance
	 */
	private void trieTopologique(){
	    ArrayList<Integer> idRealisationsTraitees = new ArrayList<>();
	    ArrayList<Integer> idRealisationsMarquees = new ArrayList<>();

		while (idRealisationsTraitees.size() < realisations.size()){
			for (Realisation realisation : realisations){
				if (!idRealisationsTraitees.contains(Integer.valueOf(realisation.getIdTache())) &&
						(realisation.getPredecesseurs().isEmpty() ||
						controlePredecesseurs(idRealisationsTraitees, realisation.getPredecesseurs()))){
                    idRealisationsMarquees.add(realisation.getIdTache());
				}
			}
			idRealisationsTraitees.addAll(idRealisationsMarquees);
			idRealisationsMarquees.clear();
		}
		this.reorganiserPert(idRealisationsTraitees);

//		test
//		for(Realisation  realisation : realisations) {
//			System.out.println(realisation);
//		}
	}

	/**
	 * Methode qui est utile a trieTopologique, elle verifie si une realisation a encore des predecesseurs non traite, et
     * renvoie false dans ce cas, et true si tout ces predecesseurs ont ete traites
	 * @param realisationsTraitees
	 * @param predecesseurs
	 * @return boolean
	 */
	private boolean controlePredecesseurs(ArrayList<Integer> realisationsTraitees, ArrayList<Integer> predecesseurs){
    	return (realisationsTraitees.containsAll(predecesseurs));
	}

	/**
	 * Reorganise le Pert a la fin du trie
	 * @param realisationTraitees
	 */
	private void reorganiserPert(ArrayList<Integer> realisationTraitees) {
		ArrayList<Realisation> realisationsTriees = new ArrayList<>();
		for(Integer idRealisation : realisationTraitees) {
			for(Realisation realisation : realisations) {
				if(idRealisation.intValue() == realisation.getIdTache()){
					realisationsTriees.add(realisation);
				}
			}
		}
		realisations = realisationsTriees;
	}
    
    /**
     * Methode qui calcul la date au plus tot de chaque realisation
     */
    public void calculDateAuPlusTot() {
    	this.trieTopologique();
    	// on parcourt la liste des realisations
    	for(int i = 0; i < this.realisations.size(); i++){
			Realisation temp = this.realisations.get(i);
			//si la tache de la realisation n'a pas de predecessuers,
			//cela veut dire que c'est la premiere tache
			//donc la date au plus tot=0
			if(temp.getTACHE().getPREDECESSEUR().size()==0){
				this.realisations.get(i).setDateAuPlusTot(0);
			}
			else{
                int max = 0;
                int calcul = 0;
                
                // on parcourt la liste des predecesseurs de la tache de la realisation
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
			}
    	}
    }

    /**
     * Calcul de la date au plus tard de chaque realisation
     */
    public void calculDateAuPlusTard() {
    	this.trieTopologique();
        // On parcourt la liste des realisations de la fin au debut
        for (int i = this.realisations.size() - 1; i >= 0; i--) {
			Realisation temp = this.realisations.get(i);

            // s'il n'y a pas de successeur la date au plus tard est la date au plus tot
			if(temp.getTACHE().getSUCCESSEUR().size()==0){
				this.realisations.get(i).setDateAuPlusTard(temp.getDateAuPlusTot());
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
                // Le calcul correspond au min de la date au plus tard des successeurs - duree de la tache
                calcul = min - temp.getSemainesReel();
                this.realisations.get(i).setDateAuPlusTard(calcul);
            }
        }
    }    

	
	/**
	 * Construit la tache alpha celle qui sera le predecesseur de la tache 1
	 * @param realisations
	 * @return alpha
	 */
	public Tache construitAlpha(ArrayList<Realisation> realisations){
		Tache alpha = new Tache("Alpha",0,0,0,null,null,null, new ArrayList <Integer>(),new ArrayList <Integer>());
		
		for(Realisation real : realisations){
			if (real.getTACHE().getPREDECESSEUR().size()==0){
				alpha.addSuccesseur(real.getIdTache());
				real.getTACHE().addPredecesseur(alpha.getID());
			}		
		}
		return alpha;
	}
	
	/**
	 * Construit la tache omega celle qui sera le successeur de toutes celles
	 * qui n'ont pas de successeurs.
	 * @param realisations
	 * @return omega
	 */
	public Tache construitOmega(ArrayList<Realisation> realisations){
		
		Tache omega = new Tache("Omega",0,0,0,null,null,null, new ArrayList <Integer>(),new ArrayList <Integer>());
		
		for(Realisation real : realisations){
			if (real.getTACHE().getSUCCESSEUR().size()==0){
				real.getTACHE().addSuccesseur(omega.getID());
				omega.addPredecesseur(real.getIdTache());
			}		
		}
		return omega;	
    
	}
	
	/**
	 * Methode d'affichage des dates au plus et date au plus tard
	 * de chaque realisation
	 */
	public void afficheDates() {
		for (int i = 0; i<this.realisations.size(); i++){
			System.out.print("tache: "+this.realisations.get(i).getTACHE().getNOM()+" Date au plus tot="+this.realisations.get(i).getDateAuPlusTot()+" Date au plus tard="+this.realisations.get(i).getDateAuPlusTard()+ "\n");
		}
	}
	
	/**
	 * Methode d'affichage du chemin critique
	 */
	public void afficheCheminCritique() {
		for (Realisation real : calculeCheminCritique()) {
			System.out.print("Tâche n°"+ real.getIdTache() + " - " + real.getTACHE().getNOM() + "\n");
		}
	}

	/**
	 * Methode de calcul du chemin critique
	 * Renvoie les realisations sur le chemin critique 
	 * @return cheminCritique
	 */
	public List<Realisation> calculeCheminCritique() {
		//On intialise le chemin critique
		List<Realisation> cheminCritique = new ArrayList<Realisation>();

		for(int j = 0; j < this.realisations.size(); j++){
			if(this.realisations.get(j).getDateAuPlusTard()-this.realisations.get(j).getDateAuPlusTot()==0){
				cheminCritique.add(this.realisations.get(j));
			}
		}
		return cheminCritique;
	}

}
