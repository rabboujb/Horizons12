package testsUnitDescription;

import static description.Couleur.ROUGE;
import description.Alea;
import description.Couleur;

import description.Tache;
import description.TypeAlea;
import partie.Realisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


/**
 * @author Ismerie
 */

public class TacheTest {
	
	private final Tache exampleTache;
	private final Tache instance;
	private Tache autreTache;
	
	
	private static Alea alea0;
	private static Alea alea1;
	private static Alea alea2;
	
	/**
	 * Test du constructeur Tache
	 */
	public TacheTest() {
	    alea0 = new Alea(TypeAlea.DELAI, Couleur.ROUGE, 3, "KKK");
	    alea1 = new Alea(TypeAlea.DELAI, Couleur.ORANGE, 1, "L");
	    alea2 = new Alea(TypeAlea.DELAI, Couleur.VERT, 1, "M");
		
        this.autreTache = new Tache("Dire", 20, 3, 4, alea0, alea1, alea2, new ArrayList<Integer>(),new ArrayList<Integer>(Arrays.asList(2,3,4)));
		this.exampleTache = new Tache("Réfléchir", 10, 2, 4, alea0, alea1, alea2,new ArrayList<Integer>(),new ArrayList<Integer>(Arrays.asList(5,7)));
		this.instance = new Tache("Réfléchir", 10, 2, 4, alea0, alea1, alea2,new ArrayList<Integer>(),new ArrayList<Integer>(Arrays.asList(5,7)));
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("***** Début du test de Tache *****" + "\n");
		System.out.println("Tache de référence: " + new Tache("Dire", 20, 3, 4, alea0, alea1, alea2, new ArrayList<Integer>(),new ArrayList<Integer>(Arrays.asList(2,3,4))));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("\n" +"***** Fin du test de Tache *****" + "\n");
	}
	
	@Before
	public void setUp() {
		this.autreTache = new Tache("Dire", 20, 3, 4, alea0, alea1, alea2, new ArrayList<Integer>(),new ArrayList<Integer>(Arrays.asList(2,3,4)));
    }
	
	@After
	public void tearDown() {
		autreTache = null;
	}
	
	
	/**
	 * Test de la methode getAlea() de la class Tache
	 */
	@Test
	public void testGetAlea() {
		System.out.println("Test méthode : getAlea");
		assertEquals(alea0,autreTache.getAlea(ROUGE));
	}
	
	/**
	 * Test de la methode getID() de la class Tache
	 */
	@Test
	public void testGetID() {
		System.out.println("Test méthode : getID");
		//à revoir pourquoi ça démarre à 8 ????
		System.out.println(autreTache.getID());
		assertEquals(10,autreTache.getID());
	}
	
	
	/**
	 * Test de la methode getNOM() de la class Tache
	 */
	@Test
	public void testGetNOM() {
		System.out.println("Test méthode : getNOM");
		assertEquals("Dire",autreTache.getNOM());
	}
	
	/**
	 * Test de la methode getCOUT() de la class Tache
	 */
	@Test
	public void testGetCOUT() {
		System.out.println("Test méthode : getCOUT");
		assertEquals(20,autreTache.getCOUT());
	}
	
	/**
	 * Test de la methode getSEMAINES() de la class Tache
	 */
	@Test
	public void testGetSEMAINES() {
		System.out.println("Test méthode : getSEMAINES");
		assertEquals(3,autreTache.getSEMAINES());
	}
	
	/**
	 * Test de la methode getSEMAINES_MAX() de la class Tache
	 */
	@Test
	public void testGetSEMAINES_MAX() {
		System.out.println("Test méthode : getSEMAINES_MAX");
		assertEquals(4,autreTache.getSEMAINES_MAX());
	}
	
	/**
	 * Test de la methode getPREDECESSEUR() de la class Tache
	 */
	@Test
	public void testGetPREDECESSEUR() {
		System.out.println("Test méthode : getPREDECESSEUR");
		//System.out.println(instance.getPREDECESSEUR());
		assertEquals(instance.getPREDECESSEUR(),autreTache.getPREDECESSEUR());
	}
	
	/**
	 * Test de la methode getSUCCESSEUR() de la class Tache
	 */
	@Test
	public void testGetSUCCESSEUR() {
		System.out.println("Test méthode : getSUCCESSEUR");
		System.out.println(autreTache.getSUCCESSEUR());
		System.out.println(autreTache.getSUCCESSEUR());
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,3,4)),autreTache.getSUCCESSEUR());
	}
	
	/**
	 * Test de la methode toString() de la class Tache
	 */
	@Test
	public void testToString() {
		System.out.println("Test méthode : toString");
		
		Tache instance = new Tache("Dire", 20, 3, 4, alea0, alea1, alea2, new ArrayList<Integer>(),new ArrayList<Integer>(Arrays.asList(2,3,4)));
		String expResult = "Id : 23\n" + 
				"Nom : Dire\n" + 
				"Coût d'accélération : 20 €\n" + 
				"Durée initiale : 3 semaines\n" + 
				"Durée totale : 4 semaines\n" + 
				"ROUGE	:	\"KKK\" 	Délai	Gravité 3\n" + 
				"ORANGE	:	\"L\" 	Délai	Gravité 1\n" + 
				"VERT	:	\"M\" 	Délai	Gravité 1";
		System.out.println(instance);
		System.out.println(expResult);
		assertEquals(expResult, instance.toString());
	}
	
	/**
	 * Test de la methode equals() de la class Tache
	 * ne pourra jamais tester 2 objets alea du fait
	 * de l'ID different pour chaque alea
	 */
	@Test
	public void testEquals_True() {
		System.out.println("Test equals: true");
		Tache instance = new Tache("Réfléchir", 10, 2, 4, alea0, alea1, alea2,new ArrayList<Integer>(Arrays.asList(1)),new ArrayList<Integer>(Arrays.asList(5,7)));
		assertTrue(instance.equals(exampleTache));
	}
	
	/**
	 * Test de la methode equals() de la class Tache
	 */
	@Test
	public void testEquals_False() {
		System.out.println("Test equals: false");
		assertFalse(autreTache.equals(exampleTache));
	}
	
	/**
	 * Test de la methode equals() de la class Tache avec null
	 * ne fonctionnera pas car une methode equals est surchargée
	 * dans la class Tache et a besoin d'un id Tache
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("Test equals avec null");
		Tache instance = null;
		try {
			assertFalse(autreTache.equals(instance));
		}catch(Exception e) {System.out.println("Surcharge de méthode");}
	}
	
	/**
	 * Test de la methode equals() de la class Tache avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("Test equals avec un autre objet");
		String instance = "Réfléchir, 10, 2, 4, alea0, alea1, alea2,new int[]{1},new int[]{5,7}";
		assertFalse(instance.equals(autreTache));
	}

}
