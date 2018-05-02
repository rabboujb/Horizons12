package partie;

public class Jalon implements Tour{
    private final String TYPE;
    private final int NUM_TOUR;

    public Jalon(int numTour){
        this.TYPE = "Jalon";
        this.NUM_TOUR = numTour;
    }

    @Override
    public String getTYPE() {
        return TYPE;
    }

    @Override
    public int getNUM_TOUR() {
        return NUM_TOUR;
    }

    public void methodeJalon(){
        System.out.println("Ceci est un jalon");
    }
}
