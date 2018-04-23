/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package description;


import java.util.Random;


/**
 *
 * @author diallo
 */

    

/**
 *
 * déclaration des liste des couleurs
 */
    public enum Couleur{ 
                        JAUNE, ORANGE,ROUGE,VERT;
                            
    


    
    
     private Couleur couleurName;
    
    
    

    private Couleur() {
        this.couleurName = couleurName;
    }

    public Couleur getCouleur() {
        return couleurName;
    }
    
 public static Couleur tirage(){
      Random random = new Random();
      int p0 ,p1,p2;
      Couleur couleurName = null;
    
      int choix = random.nextInt(1);
      switch(couleurName){
           case JAUNE:
           case ORANGE:
               
                p0=2/6;
                if(choix<p0)
                System.out.println(Couleur.ORANGE);
                
                break;
               
                
            case ROUGE:
                 p1=(2/6)+(1/6);
                if(choix<p1)
                    System.out.println(Couleur.ROUGE);
                break;
            case VERT:
                  p1=(2/6)+(1/6);
                if(choix<p1)
                    System.out.println(Couleur.VERT);
                break;
            default:
               System.out.println("faite un choix");
       
       
           }
    return couleurName;
       }
}