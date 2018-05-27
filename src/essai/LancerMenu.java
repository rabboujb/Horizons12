/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai;
import menu.Menu;
import partie.VueEquipes;
import partie.VueJoueur;


/**1111
 *
 * @author diallo1
 */
public class LancerMenu {

    /**
     * @param args the command line arguments1
     */
    public static void main(String[] args) {
        /**
         * création d'un objet vue;
         */
        VueJoueur vue=new VueEquipes();
        /**
         * création d'un lancer pour demarrer le Menu;
         * @param vue
         */
        Menu lancer = new Menu(vue);
       
       lancer.menuLancement();
       
      
       
    }
    
}
