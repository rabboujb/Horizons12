package description;

import java.util.ArrayList;

/**
 * La classe description se charge de créer la configuration de départ de la partie
 *
 * @author Equipe Horizon12
 */
public class Description {

    private ArrayList<Tache> plateau;
    private ArrayList<Tour> tours;
    int compteurAlea = 0;

    /**
     * Constructeur de description, il se charge de remplir le plateau de jeu avec les taches qu'il crées, il récupère
     * les Aléas grace à la méthode creationAleas, et les ajoute aux taches grace à un compteur.
     */
    public Description() {
        plateau = new ArrayList<>();
        tours = new ArrayList<>();

        ArrayList<Alea> aleas =  this.creationAleas();

//        Tache 1
        plateau.add(new Tache("Réfléchir",
                10,
                2,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new int[]{},
                new int[]{2, 3, 4}));

//        Tache 2
        plateau.add(new Tache("Dire",
                20,
                3,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new int[]{1},
                new int[]{5, 7}));

//        Tache 3
        plateau.add(new Tache("Écouter",
                10,
                2,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new int[]{1},
                new int[]{5, 7}));

//        Tache 4
        plateau.add(new Tache("Faire",
                10,
                2,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new int[]{1},
                new int[]{5, 7}));

//        Tache 5
        plateau.add(new Tache("Demander",
                10,
                1,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new int[]{2, 3, 4},
                new int[]{6}));

//        Tache 6
        plateau.add(new Tache("Controler",
                10,
                3,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new int[]{5},
                new int[]{8}));

//        Tache 7
        plateau.add(new Tache("Planifier",
                20,
                3,
                6,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new int[]{2, 3, 4},
                new int[]{8}));

//        Tache 8
        plateau.add(new Tache("Présenter",
                10,
                2,
                4,
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                aleas.get(compteurAlea++),
                new int[]{6, 7},
                new int[]{}));
    }

    /**
     * Méthode qui effectue la création de tout les Aléas et les renvois au constructeur sous forme d'ArrayList
     * @return ArrayList d'Aleas
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

    public ArrayList<Tache> getPlateau() {
        return plateau;
    }
}
