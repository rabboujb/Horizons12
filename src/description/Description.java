package description;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * La classe description se charge de créer la configuration de départ de la partie
 *
 * @author Mickael
 */
public class Description implements Serializable {

    private ArrayList<Tache> plateau;
    private ArrayList<Tour> tours;

    /**
     * Constructeur de description :
     *      Il remplis le plateau avec la méthode creationTache à laquelle il passe en paramètre la liste des Alea
     *      fournie par creationAlea.
     *      Il remplis la liste des tours avec la méthode creationTours
     */
    public Description() {
        plateau = this.creationTache(this.creationAleas());
        tours = this.creationTours();
    }

    /**
     * Méthode qui effectue la création de tout les Aléas et les renvoie au constructeur sous forme d'ArrayList
     * @return une ArrayList d'Aleas
     */
    private ArrayList<Alea> creationAleas() {
        ArrayList<Alea> aleas = new ArrayList<>();

//        Tache 1
        aleas.add(new Alea(TypeAlea.DELAI, Couleur.ROUGE, 1, "A"));
        aleas.add(new Alea(TypeAlea.DELAI, Couleur.ORANGE, 2, "BB"));
        aleas.add(new Alea(TypeAlea.COUT, Couleur.VERT, 1, "a"));

//        Tache 2
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ROUGE, 1, "C")));
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ORANGE, 1, "D")));
        aleas.add((new Alea(TypeAlea.COUT, Couleur.VERT, 2, "bb")));

//        Tache 3
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ROUGE, 2, "EE")));
        aleas.add((new Alea(TypeAlea.COUT, Couleur.ORANGE, 1, "c")));
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.VERT, 2, "FF")));

//        Tache 4
        aleas.add((new Alea(TypeAlea.COUT, Couleur.ROUGE, 1, "d")));
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ORANGE, 2, "GG")));
        aleas.add((new Alea(TypeAlea.COUT, Couleur.VERT, 1, "e")));

//        Tache 5
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ROUGE, 1, "H")));
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ORANGE, 3, "III")));
        aleas.add((new Alea(TypeAlea.COUT, Couleur.VERT, 2, "ff")));

//        Tache 6
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ROUGE, 1, "J")));
        aleas.add((new Alea(TypeAlea.COUT, Couleur.ORANGE, 1, "f")));
        aleas.add((new Alea(TypeAlea.QUALITE, Couleur.VERT,1, "y")));

//        Tache 7
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ROUGE, 3, "KKK")));
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ORANGE, 1, "L")));
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.VERT, 1, "M")));

//        Tache 8
        aleas.add((new Alea(TypeAlea.DELAI, Couleur.ROUGE, 1, "O")));
        aleas.add((new Alea(TypeAlea.COUT, Couleur.ORANGE, 2, "pp")));
        aleas.add((new Alea(TypeAlea.QUALITE, Couleur.VERT, 2, "zz")));

        return aleas;
    }

    /**
     * Méthode qui effectue la création de toutes les taches et les renvoient au constructeur sous forme d'ArrayList.
     * Elle prend en paramètre une ArrayList d'Alea
     * @param aleas
     * @return une ArrayList de Tache
     */
    private ArrayList<Tache> creationTache(ArrayList<Alea> aleas) {
        ArrayList<Tache> taches = new ArrayList<>();
        int compteurAlea = 0;

//        Tache 1
        taches.add(new Tache("Réfléchir",
                10,
                2,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new ArrayList <Integer>(),
                new ArrayList <Integer>(Arrays.asList(2,3,4))));

//        Tache 2
        taches.add(new Tache("Dire",
                20,
                3,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new ArrayList <Integer>(Arrays.asList(1)),
                new ArrayList <Integer>(Arrays.asList(5,7))));

//        Tache 3
        taches.add(new Tache("Écouter",
                10,
                2,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new ArrayList <Integer>(Arrays.asList(1)),
                new ArrayList <Integer>(Arrays.asList(5,7))));

//        Tache 4
        taches.add(new Tache("Faire",
                10,
                2,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new ArrayList <Integer>(Arrays.asList(1)),
                new ArrayList <Integer>(Arrays.asList(5,7))));

//        Tache 5
        taches.add(new Tache("Demander",
                10,
                1,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new ArrayList <Integer>(Arrays.asList(2,3,4)),
                new ArrayList <Integer>(Arrays.asList(6))));

//        Tache 6
        taches.add(new Tache("Controler",
                10,
                3,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new ArrayList <Integer>(Arrays.asList(5)),
                new ArrayList <Integer>(Arrays.asList(8))));

//        Tache 7
        taches.add(new Tache("Planifier",
                20,
                3,
                6,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new ArrayList <Integer>(Arrays.asList(2,3,4)),
                new ArrayList <Integer>(Arrays.asList(8))));;

//        Tache 8
        taches.add(new Tache("Présenter",
                10,
                2,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea),
                new ArrayList <Integer>(Arrays.asList(6,7)),
                new ArrayList <Integer>()));

        return taches;
    }

    /**
     * Méthode qui crée les tours de jeu et les retourne sous forme d'ArrayList au constructeur
     * @return une ArrayList de tours
     */
    private ArrayList<Tour> creationTours() {
        ArrayList<Tour> tours =  new ArrayList<>();

        tours.add(new TourJalon(TypeTour.JALON, new int[]{1, 2, 3, 4}));

        tours.add(new TourAlea(TypeTour.ALEA, 1));
        tours.add(new TourAlea(TypeTour.ALEA, 2));
        tours.add(new TourAlea(TypeTour.ALEA, 3));
        tours.add(new TourAlea(TypeTour.ALEA, 4));

        tours.add(new TourJalon(TypeTour.JALON, new int[]{5, 6, 7, 8}));

        tours.add(new TourAlea(TypeTour.ALEA, 5));
        tours.add(new TourAlea(TypeTour.ALEA, 6));
        tours.add(new TourAlea(TypeTour.ALEA, 7));
        tours.add(new TourAlea(TypeTour.ALEA, 8));

        tours.add(new TourFinal(TypeTour.FINAL));

        return tours;
    }

//    Getters relatifs aux taches

    /**
     * Méthode qui retourne le plateau de jeu complet,
     * <strong>Attention : il ne s'agit pas d'une duplication du plateau, mais d'une simple référence</strong>
     * @return une référence du plateau
     */
    public ArrayList<Tache> getPlateau() {
        return plateau;
    }

    /**
     * Méthode qui retourne la tache situé à l'index donné du plateau, retourne null si l'index est incorrect
     * @param index
     * @return Tache
     */
    public Tache getTache(int index) {
        if (index >= 0 && index < plateau.size()) {
            return plateau.get(index);
        }
        return null;
    }

    /**
     * Méthode qui renvoie une tache, retourne null si l'id est incorrect
     * @param id
     * @return Tache
     */
    public Tache getTacheById(int id) {
        for (Tache tache : plateau) {
            if (tache.getID() == id) {
                return tache;
            }
        }
        return null;
    }

//    Getters relatifs aux tours

    /**
     * Méthode qui retourne l'ArrayList complète des tours
     * @return tours
     */
    public ArrayList<Tour> getTours() {
        return tours;
    }

    /**
     * Méthode qui retourne le tour situé à l'index donné de l'ArrayList tours, retourne null si l'index est incorrect
     * <strong>Notez que l'index et le numéro de tour sont identiques</strong>
     * @param index
     * @return un tour
     */
    public Tour getTour(int index) {
        if (index >= 0 && index < tours.size()) {
            return tours.get(index);
        }
        return null;
    }
}
