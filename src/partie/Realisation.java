package partie;
import description.Couleur;
import description.Tache;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Objet permettant d'enregistrer les actions de la du jeu (Aleas) et du joueur :
 *      application d'alea de delai
 *      protection
 *      acceleration
 *
 * Il encapsule la tache à laquelle il est lié.
 *
 * @author Mickael, Ismerie
 */
public class Realisation implements Serializable {

    private final Tache TACHE;
    private int semainesReel;
    private int semainesRestantes;
    private int dateAuPlusTot;
    private int dateAuPlusTard;
    private boolean rouge;
    private boolean orange;
    private boolean vert;
    private boolean accelere;
    private Etat etat;
    
	/**
	 * Le noeud a-t-il ete marque durant le parcours ?
	 */
	private boolean marque = false;

    public Realisation(Tache tache) {
        this.TACHE = tache;
        this.semainesReel = tache.getSEMAINES();
        this.semainesRestantes = semainesReel;
        this.rouge = false;
        this.orange = false;
        this.vert = false;
        this.accelere = false;
        this.etat = Etat.NON_ENTAMEE;
    }

    /**
     * Methode qui retourne la tache a laquelle est lie la realisation
     * @return une Tache
     */
    public Tache getTACHE() {
        return TACHE;
    }

    /**
     * Methode qui retourne l'id de la tache concernee par la realisation, cela peut faciliter la selection de la
     * realisation (qui sera placee dans une ArrayList() en fonction du tour joue
     * @return l'id de la tache concernee par la realisation
     */
    public int getIdTache() {
        return TACHE.getID();
    }

    /**
     * Methode qui retourne la liste des predecesseurs de la tache encapsulee sous forme d'ArrayList
     * cette methode facilite la lecture du code du PERT
     * @return ArrayList
     */
    public ArrayList<Integer> getPredecesseurs(){
        return TACHE.getPREDECESSEUR();
    }

    /**
     * Methode qui retourne la liste des successeurs de la tache encapsulee sous forme d'ArrayList
     * cette methode facilite la lecture du code du PERT
     * @return ArrayList
     */
    public ArrayList<Integer> getSuccesseurs(){
        return TACHE.getSUCCESSEUR();
    }

    /**
     * Methode qui retourne le nombre reel de semaines reel que prendra la tache pour le joueur
     * @return le nombre reel de semaines
     */
    public int getSemainesReel() {
        return semainesReel;
    }

    /**
     * Methode qui retourne le nombre de semaines restantes
     * @return le nombre de semaines restantes
     */
    public int getSemainesRestantes() {
		return semainesRestantes;
	}

	/**
     * Methode qui retourne la date au plus tot
     * @return la date au plus tot
     */
    public int getDateAuPlusTot() {
		return dateAuPlusTot;
	}

    /**
     * Methode qui permet de mettre a jour
     * @param dateAuPlusTot
     */
	public void setDateAuPlusTot(int dateAuPlusTot) {
		this.dateAuPlusTot = dateAuPlusTot;
	}

	/**
     * Methode qui retourne la date au plus tard
     * @return la date au plus tard
     */
	public int getDateAuPlusTard() {
		return dateAuPlusTard;
	}

	/**
     * Methode qui met a jour la date au plus tard
     * @return la date au plus tard
     */
	public void setDateAuPlusTard(int dateAuPlusTard) {
		this.dateAuPlusTard = dateAuPlusTard;
	}

	/**
     * Methode qui retourne la valeur de l'attribut marque
     * @return la valeur de marque
     */
	public boolean getMarque() {
		return marque;
	}

	/**
     * Methode pour marquer une realisation
     * @param marque
     */
	public void setMarque(boolean marque) {
		this.marque = marque;
	}

	/**
     * Methode qui retourne le statut de l'alea rouge sous forme boolean
     * true si l'alea est protege et false dans le cas contraire
     * @return un boolean
     */
    public boolean getRouge() {
        return rouge;
    }

    /**
     * Methode qui retourne le statut de l'alea orange sous forme boolean 
     * true si l'alea est protege et false dans le cas contraire
     * @return un boolean
     */
    public boolean getOrange() {
        return orange;
    }

    /**
     * Methode qui retourne le statut de l'alea vert sous forme boolean
     * true si l'alea est protege et false dans le cas contraire
     * @return un boolean
     */
    public boolean getVert() {
        return vert;
    }

    /**
     * Methode qui retourne l'état de la realisation lors du calcul de chemin critique, il peut etre :
     *      NON_ENTAMEE,
     *      IMMINENT,
     *      EN_COURS,
     *      TERMINEE,
     *
     * @return Etat
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Methode qui permet de modifier l'etat de la realisation lors du calcul de chemin critique
     * @param etat
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * Methode qui permet l'application d'un alea de type delai
     * @param gravite
     */
    public void appliquerDelai(int gravite) {
        this.semainesReel += gravite;
        this.semainesRestantes += gravite;
    }
    
    /**
     * Methode qui permet de decrementer le nombre de semaines e chaque tour
     * elle renvoie true si cela est possible (semaines restantes > 0)
     * et false dans le cas contraire
     * Si le nombre de semaines passe à 0 l'etat de la tache est mis a jour vers terminee
     * @return un boolean
     */
    public boolean decrementerSemaine() {
    	boolean applique = false;
    	
    	if (semainesRestantes > 0) {
    		semainesRestantes --;
    		applique = true;
    		
    		if (semainesRestantes == 0) {
    			this.etat = etat.TERMINEE;
    		}
    	}
    	return applique;
    }

    /** Methode qui permet d'appliquer une acceleration
     * retourne true si l'acceleration a ete correctement appliquee
     * et false dans le cas contraire (tache deja accelere, car une seule acceleration possible par tache)
     * @return un boolean
     */
    public boolean appliquerAcceleration() {
        if (!accelere) {
            semainesReel --;
            semainesRestantes --;
            accelere = true;
            return true;
        }
        return false;
    }

    /**
     * Methode qui retourne un boolean indiquant si la tache a deja ete acceleree ou non
     * @return un boolean
     */
	public boolean getAccelere() { return accelere; }

	/**
     * Methode qui permet de proteger l'alea dont la couleur a ete passee en parametre
     * elle renvoie true si la protection a pu etre appliquee 
     * et false dans le cas ou cela est impossible (alea deja protege)
     * @param couleur
     * @return un booelan
     */
    public boolean appliquerProtection(Couleur couleur) {
    	boolean applique = false;
    	
        if (couleur.equals(Couleur.ROUGE) && !rouge) {
            rouge = true;
            applique = true;
        }
        else if (couleur.equals(Couleur.ORANGE) && !orange) {
            orange = true;
            applique = true;
        }
        else if (couleur.equals(Couleur.VERT) && !vert) {
            vert = true;
            applique = true;
        }
        return applique;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Realisation){
            return this.equals((Realisation)object);
        }
        return false;
    }

    /**
     * Equals qui permet de comparer deux realisations
     * @param realisation
     * @return
     */
    public boolean equals(Realisation realisation){
        if (this.getIdTache() == realisation.getIdTache()){
            return true;
        }
        return false;
    }

    /**
     * Methode qui permet de comparer une realisation via son ID, à l'ID d'une autre realisation
     * ceci est utile pour comparer une realisation a un element de l'ArraysList de predecesseurs
     * @param id
     * @return
     */
    public boolean equals(Integer id){
        if (this.getIdTache() == id.intValue()){
            return true;
        }
        return false;
    }

    /**
     * Methode utile au toString, elle permet de renvoyer en toute lettre l'état d'un alea
     * @param couleur
     * @return une String
     */
    private String protege(Couleur couleur) {
        if (couleur.equals(Couleur.ROUGE) && rouge) {
            return "protégé";
        }
        else if (couleur.equals(Couleur.ORANGE) && orange) {
            return "protégé";
        }
        else if (couleur.equals(Couleur.VERT) && vert) {
            return "protégé";
        }
        return "non protégé";
    }
    
    /**
     * Methode utile au toString, elle permet d'afficher une jauge d'etoiles
     * en fonction du nombre de semaines restantes
     * @return une String
     */
    private String jaugeSemainesRestantes() {
    	String jauge = "";
    	
    	for (int i = semainesRestantes ; i  > 0 ; i--) {
    		jauge += "*";
    	}
    	return jauge;
    }

    /**
     * Methode qui décrit l'actuel de la tache pour le joueur, avec le nombre de semaines réele et le status des aleas
     * @return une String
     */
    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append("Id : ").append(TACHE.getID())
                .append("\nNom : ").append(TACHE.getNOM())
                .append("\nSemaines : ").append(semainesReel).append("\tsemaines restantes : ").append(jaugeSemainesRestantes())
                .append("\n").append(TACHE.getAlea(Couleur.ROUGE))
                .append("\tstatus : ").append(this.protege(Couleur.ROUGE))
                .append("\n").append(TACHE.getAlea(Couleur.ORANGE))
                .append("\tstatus : ").append(this.protege(Couleur.ORANGE))
                .append("\n").append(TACHE.getAlea(Couleur.VERT))
                .append("\tstatus : ").append(this.protege(Couleur.VERT))
                .append("\n");

        return chaine.toString();
    }
}
