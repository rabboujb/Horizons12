package partie;

public class Semaine implements Tour {
    private final String TYPE;
    private final int NUM_TOUR;

    public Semaine(int numTour){
        this.TYPE = "Semaine";
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

    public void methodeSemaine(){
        System.out.println("Ceci est une semaine");
    }
}
