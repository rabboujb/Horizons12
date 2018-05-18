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

    private String type;

    TypeAlea(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
    
    
            
    

