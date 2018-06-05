package description;

import java.io.Serializable;

/**
 * Classe abstraite qui sert de modèle aux différents types de tours, elle contiens un numero de tour ainsi qu'un type
 * de tour
 *
 * @author mickael
 */
public abstract class Tour implements Serializable {
    private static int compteurNum = -1;
    private final int NUMERO;
    private final TypeTour TYPE;

    public Tour(TypeTour type){
        compteurNum++;
        this.NUMERO = compteurNum;
        this.TYPE = type;
    }

    /**
     * Méthode qui retourne le numéro du tour
     * @return NUMERO
     */
    public int getNUMERO() {
        return NUMERO;
    }

	public void setNUMERO() { compteurNum = -1; }

    /**
     * Méthode qui retourne le type du tour (Alea, Jalon, Final)
     * @return TYPE
     */
    public TypeTour getTYPE() {
        return TYPE;
    }

    /**
     * Méthode qui retourne une description du tour
     * @return une description du tour
     */
    @Override
    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append("Tour ").append(NUMERO).append(" : ").append(TYPE);

        return chaine.toString();
    }
}