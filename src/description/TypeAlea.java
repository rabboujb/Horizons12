/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package description;

/**
 *
 * @author diallo
 */


public enum TypeAlea{
    DELAI ("Délai"),
    COUT ("Coût"),
    QUALITE ("Qualité");

    private String nom;

    TypeAlea(String nom, int gravite) {
        this.nom = nom;
    }

    public String toString() {
        return nom;
    }
}
    
    
            
    

