package essai;

import description.Couleur;
import description.Description;
import partie.Realisation;

/**
 * Classe de test des fonction de base de classe réalisation
 * 
 * @author Mickael
 */
public class EssaiRealisation {

    public static void main(String[] args) {
        Description description = new Description();
        Realisation realisation = new Realisation(description.getTacheById(3));

//        Affichage de l'état de base de la réalistation
        System.out.println(realisation);

//        Application d'un délai de gravité 2
        realisation.appliquerDelai(2);

//        Application de deux accélération consécutive afin de vérifier que seul la première est prise en compte
        System.out.println(realisation.appliquerAcceleration() + "\n");
        System.out.println(realisation.appliquerAcceleration() + "\n");

//        Application de deux protection rouge consécutive afin de vérifier que seul la première est prise en compte
        System.out.println(realisation.appliquerProtection(Couleur.ROUGE) + "\n");
        System.out.println(realisation.appliquerProtection(Couleur.ROUGE) + "\n");

//        Application des deux autres protections
        realisation.appliquerProtection(Couleur.ORANGE);
        realisation.appliquerProtection(Couleur.VERT);

//        Nouvel affichage de l'état de la réalisation afin de vérifier si tout les changements ont été pris en compte
        System.out.println(realisation + "\n");

//        Test des getter
        System.out.println(realisation.getEtat());
        System.out.println(realisation.getRouge());
        System.out.println(realisation.getOrange());
        System.out.println(realisation.getVert());
        System.out.println(realisation.getSemainesReel());

        // test equal
        Integer integer = new Integer(3);
        Integer integer1 =  new Integer(1);
        System.out.println(realisation.equals(integer));
        System.out.println(realisation.equals(integer1));
    }
}
