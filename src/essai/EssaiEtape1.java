/**
 * @author Bilal RABBOUJ
 */
package essai;
import description.*;

public class EssaiEtape1 {
    public static void main(String[] args) {
        DescriptionObsolete descriptionObsolete = new DescriptionObsolete();

        for(int i=1;i<9;i++) {
                System.out.println("TÂCHE "+i);
                System.out.println();
            Tache t = descriptionObsolete.getTacheById(""+i+"");
                System.out.println("Nom : "+t.getId());
                System.out.println("DescriptionObsolete : "+t.getDescription());
                System.out.println("Coût d'accélération : "+t.coutAcceleration()+" €");
                if(i == 5)
                    System.out.println("Durée prévue : "+t.getDureeInitiale()+" semaine");
                else
                    System.out.println("Durée prévue : "+t.getDureeInitiale()+" semaines");
                    System.out.println("Retard éventuel : "+t.getDureeMax()+" semaines");
            Alea aR = t.getAlea(Couleur.ROUGE);
                System.out.println(aR.toString());
            Alea aO = t.getAlea(Couleur.ORANGE);
                System.out.println(aO.toString());
            Alea aV = t.getAlea(Couleur.VERT);
                System.out.println(aV.toString());
                System.out.println("===");
                System.out.println();
        }
    }
}