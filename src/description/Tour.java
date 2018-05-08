package description;

/**
 * Classe abstraite qui sert de modèle aux différents types de tours, elle contiens un numero de tour ainsi qu'un type
 * de tour
 *
 * @author mickael
 */
public abstract class Tour {

    /** Numéro du tour*/
    private final int NUMERO;

    /** type de tour (Jalon, Alea, ou Final)*/
    private final TypeTour TYPE;

    public Tour(int numero, TypeTour type){
        this.NUMERO = numero;
        this.TYPE = type;
    }

    public int getNUMERO() {
        return NUMERO;
    }

    public TypeTour getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        StringBuilder chaine = new StringBuilder();

        chaine.append("Tour ").append(NUMERO).append(" : ").append(TYPE);

        return chaine.toString();
    }
}
