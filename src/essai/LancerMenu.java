/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai;
import java.io.IOException;
import  strategie.Menu;

/**
 *
 * @author diallo6
 */
public class LancerMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      Menu lancer = new Menu();
      lancer.menuLancement();
    }
    
}
