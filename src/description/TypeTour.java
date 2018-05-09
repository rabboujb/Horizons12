package description;

/**
 * Enumération contenant les diférent type de tour :
 *          Jalon
 *          Alea
 *          Final
 *
 * @author mickael
 */

public enum TypeTour {

    JALON ("Jalon"),
    ALEA ("Aléa"),
    FINAL ("Final");

    private String nom;

    private TypeTour (String nom){
        this.nom = nom;
    }

    public String toString(){
        return nom;
    }
}
