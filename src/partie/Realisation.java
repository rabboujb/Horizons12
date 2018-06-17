package partie;
import description.Couleur;
import description.Tache;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Objet permetant d'enregistrer les action de la du jeu (Aleas) et du joueur :
 *      application d'alea de delai
 *      protection
 *      ecceleration
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
	 * Le noeud a-t-il été marqué durant le parcours ?
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
     * Méthode qui retourne la tache à laquelle est lié la réalisation
     * @return une Tache
     */
    public Tache getTACHE() {
        return TACHE;
    }

    /**
     * Methode qui retourne l'id de la tache concernee par la realisation, cela peu facilite la selection de la
     * realisation (qui serra placee dans une ArrayList) en fonction du tour joue
     * @return l'id de la tache concernee par la realisation
     */
    public int getIdTache() {
        return TACHE.getID();
    }

    /**
     * Methode qui retourne la liste des predecesseurs de la tache encapsulee sous forme d'ArrayList, cette methode
     * facilite la lecture du code du PERT
     * @return ArrayList
     */
    public ArrayList<Integer> getPredecesseurs(){
        return TACHE.getPREDECESSEUR();
    }

    /**
     * Methode qui retourne la liste des successeurs de la tache encapsulee sous forme d'ArrayList, cette methode
     * facilite la lecture du code du PERT
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
     */
	public int getDateAuPlusTard() {
		return dateAuPlusTard;
	}

	/**
     * Methode qui retourne la date au plus tard
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
     * Methode qui retourne le statut de l'alea rouge sous forme boolean (true si l'alea est protege et false dans le
     * cas contraire)
     * @return un boolean
     */
    public boolean getRouge() {
        return rouge;
    }

    /**
     * Methode qui retourne le statut de l'alea orange sous forme boolean (true si l'alea est protege et false dans le
     * cas contraire)
     * @return un boolean
     */
    public boolean getOrange() {
        return orange;
    }

    /**
     * Methode qui retourne le statut de l'alea vert sous forme boolean (true si l'alea est protege et false dans le
     * cas contraire)
     * @return un boolean
     */
    public boolean getVert() {
        return vert;
    }

    /**
     * Methode qui retourne l'état de la realisation lors du calcule de chemin critique, il peut etre :
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
     * Méthode qui permet l'application d'un aléa de type délai
     * @param gravite
     */
    public void appliquerDelai(int gravite) {
        this.semainesReel += gravite;
        this.semainesRestantes += gravite;
    }
    
    /**
     * Méthode qui permet de décrémenter le nombre de semaines à chaque tour, elle renvoie true si cela est possible (semaines restante > 0)
     * et false dans le cas contraire.
     * Si le nombre de semaines passe à 0 l'état de la tâche est mis à jour vers terminée.
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

    /** Méthode qui permet d'appliquer une accélération, retourne true si l'accélération à été correctement appliquée,
     * et false dans le cas contraire (tâche déja accéléré, car une seul accélération possible par tâche)
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
     * Méthode qui retourne un boolean indiquant si la tâche à déja été accélérée ou non
     * @return un boolean
     */
	public boolean getAccelere() { return accelere; }

	/**
     * Méthode qui permet de protéger l'aléa dont la couleur a été passée en paramètre, elle renvoie true si la
     * protection a pus être appliquée et false dans le cas où cela est impossible (alea déja protégé)
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
     * Equals qui permet de comparer deux réalisations
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
     * Méthode qui permet de comparer une réalisation via son ID, à l'ID d'une autre réalisation, ceci est utile pour
     * comparer une réalisation à un élément de l'ArraysList de prédécesseurs
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
     * Méthode utile au toString, elle permet de revoyer en toute lettre l'état d'un aléa
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
    
    private String jaugeSemainesRestantes() {
    	String jauge = "";
    	
    	for (int i = semainesRestantes ; i  > 0 ; i--) {
    		jauge += "*";
    	}
    	return jauge;
    }

    /**
     * Méthode qui décrit l'actuel de la tache pour le joueur, avec le nombre de semaines réele et le status des aléas
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
