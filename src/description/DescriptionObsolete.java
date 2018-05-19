/**
 * @author Bilal RABBOUJ
 */
package description;
import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static description.TypeAlea.*;
import static description.Couleur.*;
import static description.TypeTour.*;

public class DescriptionObsolete implements Alea, Tache {
/**
* Définition des attributs
**/
    private Couleur couleur;
    private String nom;
    private TypeAlea type;
    private int gravite;
    private String idTache;
    private String description;
    private int cout;
    private int dureeInitiale;
    private int dureeMax;
    private Alea alea1, alea2, alea3;
    private List<Tache> taches;
    private Collection<Tache> predecesseurs;
    private Collection<Tache> successeurs;
    private LinkedList<Tour> sequence;
    private List<Integer> duree;
	private static List<Couleur> tirage;
	private int[] nbToursJalon1, nbToursJalon2;
	private int calendrier;

    private DescriptionObsolete t1, t2, t3, t4, t5, t6, t7, t8;

			//  Constructeur sans paramètre
    public DescriptionObsolete() {
        List<Alea> aleas = new ArrayList<>();
            // Alea - Tache 1
        aleas.add(new DescriptionObsolete(ROUGE, "A", DELAI, 1));
        aleas.add(new DescriptionObsolete(ORANGE, "BB", DELAI, 2));
        aleas.add(new DescriptionObsolete(VERT, "a", EUROS, 1));
            // Alea - Tache 2
        aleas.add(new DescriptionObsolete(ROUGE, "C", DELAI, 1));
        aleas.add(new DescriptionObsolete(ORANGE, "D", DELAI, 1));
        aleas.add(new DescriptionObsolete(VERT, "bb", EUROS, 2));
            // Aleas - Tache 3
        aleas.add(new DescriptionObsolete(ROUGE, "EE", DELAI, 2));
        aleas.add(new DescriptionObsolete(ORANGE, "c", EUROS, 1));
        aleas.add(new DescriptionObsolete(VERT, "FF", DELAI, 2));
            // Aleas - Tache 4
        aleas.add(new DescriptionObsolete(ROUGE, "d", EUROS, 1));
        aleas.add(new DescriptionObsolete(ORANGE, "GG", DELAI, 2));
        aleas.add(new DescriptionObsolete(VERT, "e", EUROS, 1));
            // Aleas - Tache 5
        aleas.add(new DescriptionObsolete(ROUGE, "H", DELAI, 1));
        aleas.add(new DescriptionObsolete(ORANGE, "III", DELAI, 3));
        aleas.add(new DescriptionObsolete(VERT, "ff", EUROS, 2));
            // Aleas - Tache 6
        aleas.add(new DescriptionObsolete(ROUGE, "J", DELAI, 1));
        aleas.add(new DescriptionObsolete(ORANGE, "f", EUROS, 1));
        aleas.add(new DescriptionObsolete(VERT, "y", QUALITE, 1));
            // Aleas - Tache 7
        aleas.add(new DescriptionObsolete(ROUGE, "KKK", DELAI, 3));
        aleas.add(new DescriptionObsolete(ORANGE, "L", DELAI, 1));
        aleas.add(new DescriptionObsolete(VERT, "M", DELAI, 1));
            // Aleas - Tache 8
        aleas.add(new DescriptionObsolete(ROUGE, "O", DELAI, 1));
        aleas.add(new DescriptionObsolete(ORANGE, "pp", EUROS, 2));
        aleas.add(new DescriptionObsolete(VERT, "zz", QUALITE, 2));

        taches = new ArrayList<>();
            // Instanciation des taches
        t1 = new DescriptionObsolete("1", "Réfléchir", 10, 2, 4, aleas.get(0), aleas.get(1), aleas.get(2));
        t2 = new DescriptionObsolete("2", "Dire", 20, 3, 4, aleas.get(3), aleas.get(4), aleas.get(5));
        t3 = new DescriptionObsolete("3", "Ecouter", 10, 2, 4, aleas.get(6), aleas.get(7), aleas.get(8));
        t4 = new DescriptionObsolete("4", "Faire", 10, 2, 4, aleas.get(9), aleas.get(10), aleas.get(11));
        t5 = new DescriptionObsolete("5", "Demander", 10, 1, 4, aleas.get(12), aleas.get(13), aleas.get(14));
        t6 = new DescriptionObsolete("6", "Contrôler", 10, 3, 4, aleas.get(15), aleas.get(16), aleas.get(17));
        t7 = new DescriptionObsolete("7", "Planifier", 20, 3, 6, aleas.get(18), aleas.get(19), aleas.get(20));
        t8 = new DescriptionObsolete("8", "Présenter", 10, 2, 4, aleas.get(21), aleas.get(22), aleas.get(23));
            // Ajout des Taches à la liste
        taches.add(t1);
        taches.add(t2);
        taches.add(t3);
        taches.add(t4);
        taches.add(t5);
        taches.add(t6);
        taches.add(t7);
        taches.add(t8);

            // Predecesseurs
        t2.predecesseurs.add(t1);
        t3.predecesseurs.addAll(taches.subList(0,taches.indexOf(t3)));
        t4.predecesseurs.addAll(taches.subList(0,taches.indexOf(t4)));
        t5.predecesseurs.addAll(taches.subList(0,taches.indexOf(t5)));
        t6.predecesseurs.addAll(taches.subList(0,taches.indexOf(t6)));
        t7.predecesseurs.addAll(taches.subList(0,taches.indexOf(t7)));
        t8.predecesseurs.addAll(taches.subList(0,taches.indexOf(t8)));

            // Successeurs
        t1.successeurs.addAll(taches.subList(taches.indexOf(t2),taches.size()));
        t2.successeurs.addAll(taches.subList(taches.indexOf(t3),taches.size()));
        t3.successeurs.addAll(taches.subList(taches.indexOf(t4),taches.size()));
        t4.successeurs.addAll(taches.subList(taches.indexOf(t5),taches.size()));
        t5.successeurs.addAll(taches.subList(taches.indexOf(t6),taches.size()));
        t6.successeurs.addAll(taches.subList(taches.indexOf(t7),taches.size()));
        t7.successeurs.add(t8);

		this.sequence = new LinkedList<>();
		this.nbToursJalon1 = new int[]{Integer.parseInt(t1.getId())
										, Integer.parseInt(t2.getId())
										, Integer.parseInt(t3.getId())
										, Integer.parseInt(t4.getId())};
		this.nbToursJalon2 = new int[]{Integer.parseInt(t5.getId())
										, Integer.parseInt(t6.getId())
										, Integer.parseInt(t7.getId())
										, Integer.parseInt(t8.getId())};

		sequence.add(new TourJalon(0, JALON, nbToursJalon1));
		sequence.add(new TourAlea(1, ALEA, nbToursJalon1[0]));
		sequence.add(new TourAlea(2, ALEA, nbToursJalon1[1]));
		sequence.add(new TourAlea(3, ALEA, nbToursJalon1[2]));
		sequence.add(new TourAlea(4, ALEA, nbToursJalon1[3]));
		sequence.add(new TourJalon(5, JALON, nbToursJalon2));
		sequence.add(new TourAlea(6, ALEA, nbToursJalon2[0]));
		sequence.add(new TourAlea(7, ALEA, nbToursJalon2[1]));
		sequence.add(new TourAlea(8, ALEA, nbToursJalon2[2]));
		sequence.add(new TourAlea(9, ALEA, nbToursJalon2[3]));

		this.calendrier = 0;

		this.duree = new ArrayList<>();
		duree.add(t1.getDureeMax() - t1.getDureeInitiale());
		duree.add(t2.getDureeMax() - t2.getDureeInitiale());
		duree.add(t3.getDureeMax() - t3.getDureeInitiale());
		duree.add(t4.getDureeMax() - t4.getDureeInitiale());
		duree.add(t5.getDureeMax() - t5.getDureeInitiale());
		duree.add(t6.getDureeMax() - t6.getDureeInitiale());
		duree.add(t7.getDureeMax() - t7.getDureeInitiale());
		duree.add(t8.getDureeMax() - t8.getDureeInitiale());
    }

		// Constructeur aleas
    public DescriptionObsolete(Couleur couleur, String nom, TypeAlea type, int gravite) {
        this.couleur = couleur;
        this.nom = nom;
        this.type = type;
        this.gravite = gravite;
    }

		// Constructeur taches
    public DescriptionObsolete(String idTache, String description, int cout, int
        dureeInitiale, int dureeMax, Alea alea1, Alea alea2, Alea alea3) {
        this.idTache = idTache;
        this.description = description;
        this.cout = cout;
        this.dureeInitiale = dureeInitiale;
        this.dureeMax = dureeMax;
        this.alea1 = alea1;
        this.alea2 = alea2;
        this.alea3 = alea3;
        predecesseurs = new ArrayList<>();
        successeurs = new ArrayList<>();
    }

	public Couleur getRandom()  { return Couleur.tirage(); }

	public LinkedList<Tour> getSequence()   { return sequence;      }
	public void supprimerTour()             { sequence.poll();      }

	public int[] getTachesJalon1()  { return nbToursJalon1; }
	public int[] getTachesJalon2()  { return nbToursJalon2; }

	public int getCalendrier()      { return calendrier;    }
	public void setCalendrier()     { calendrier++;         }

	/**
* @return Couleur d'un aléa
**/
    public Couleur getCouleur()     {   return this.couleur;        }
/**
* @return Nom d'un aléa
**/
    public String getNom()          {   return this.nom;            }
/**
* @return Type d'un aléa
**/
    public TypeAlea getType()       {   return this.type;           }
/**
* @return Gravité d'un aléa
**/
    public int getGravite()         {   return this.gravite;        }
/**
* @return Id d'une tâche
**/
    public String getId()           {   return this.idTache;        }
/**
* @return DescriptionObsolete d'une tâche
**/
    public String getDescription()  {   return this.description;    }
/**
* @return Coût d'une tâche
**/
    public int coutAcceleration()   {   return this.cout;           }
/**
* @return Durée prévue d'une tâche
**/
    public int getDureeInitiale()   {   return this.dureeInitiale;  }
/**
* @return Retard éventuel d'une tâche
**/
    public int getDureeMax()        {   return this.dureeMax;       }

    public int getDureeReelle(String id)    {   return duree.get(Integer.parseInt(id)-1); }

	public void ajoutDureeReelle(String id, int semaines) {
		int dureeReelle = duree.get(Integer.parseInt(id)-1) + semaines;
		duree.set(Integer.parseInt(id)-1,dureeReelle);
	}
	public void retraitDureeReelle(String id, int semaines) {
		int dureeReelle = duree.get(Integer.parseInt(id)-1) - semaines;
		duree.set(Integer.parseInt(id)-1,dureeReelle);
	}

	/**
* @return Aléas d'une tâche
**/
    public Alea getAlea(Couleur couleur) {
        if(couleur == ROUGE)    return alea1;
        if(couleur == ORANGE)   return alea2;
        if(couleur == VERT)     return alea3;
        return null;
    }
/**
* @return Prédecesseurs d'une tâche
**/
    public Collection<Tache> getPredecesseurs() {   return predecesseurs;   }
/**
* @return Successeurs d'une tâche
**/
    public Collection<Tache> getSuccesseurs()   {   return successeurs;     }

/**
* @param id String
* @return Tâche dont l'id est passé en paramètre
**/
	public Tache getTacheById(String id) {
		for(Tache t: taches) {
			if(t.getId().equals(id))
			return t;
		}
		return null;
	}

/**
* @return DescriptionObsolete d'un aléa
**/
    public String toString() {
        return "Aléa {" +
                "couleur=" + couleur +
                ", nom='" + nom + '\'' +
                ", type=" + type +
                ", gravite=" + gravite +
                '}';
    }
}