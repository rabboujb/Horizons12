package testsUnitDescription;

import static description.Couleur.ROUGE;
import static description.TypeAlea.DELAI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import description.Alea;
import description.Couleur;
import description.Description;
import description.Tache;
import description.TypeAlea;

/**
 * @author Equipe Horizons12
 */

public class TacheTest {
	
	private final Tache exampleTache;
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
		
        this.autreTache = new Tache("Dire", 20, 3, 4, alea0, alea1, alea2, new int[]{},new int[]{2, 3, 4});
		this.exampleTache = new Tache("Réfléchir", 10, 2, 4, alea0, alea1, alea2,new int[]{1},new int[]{5,7});
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de Tache");
		System.out.println("Tache de référence: " + new Tache("Dire", 20, 3, 4, alea0, alea1, alea2, new int[]{},new int[]{2, 3, 4}));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de Tache");
	}
	
	@Before
	public void setUp() {
		this.autreTache = new Tache("Dire", 20, 3, 4, alea0, alea1, alea2, new int[]{},new int[]{2, 3, 4});
    }
	
	@After
	public void tearDown() {
		autreTache = null;
	}
	
	
	/**
	 * Test de la méthode getAlea() de la class Tache
	 */
	@Test
	public void testGetAlea() {
		System.out.println("getAlea");
		assertEquals(alea0,autreTache.getAlea(ROUGE));
	}
	
	/**
	 * Test de la méthode getID() de la class Tache
	 */
	@Test
	public void testGetID() {
		System.out.println("getID");
		//à revoir pourquoi ça démarre à 4 ????
		System.out.println(autreTache.getID());
		assertEquals(4,autreTache.getID());
	}
	
	
	/**
	 * Test de la méthode getNOM() de la class Tache
	 */
	@Test
	public void testGetNOM() {
		System.out.println("getNOM");
		assertEquals("Dire",autreTache.getNOM());
	}
	
	/**
	 * Test de la méthode getCOUT() de la class Tache
	 */
	@Test
	public void testGetCOUT() {
		System.out.println("getCOUT");
		assertEquals(20,autreTache.getCOUT());
	}
	
	/**
	 * Test de la méthode getSEMAINES() de la class Tache
	 */
	@Test
	public void testGetSEMAINES() {
		System.out.println("getSEMAINES");
		assertEquals(3,autreTache.getSEMAINES());
	}
	
	/**
	 * Test de la méthode getSEMAINES_MAX() de la class Tache
	 */
	@Test
	public void testGetSEMAINES_MAX() {
		System.out.println("getSEMAINES_MAX");
		assertEquals(4,autreTache.getSEMAINES_MAX());
	}
	
	/**
	 * Test de la méthode getPREDECESSEUR() de la class Tache
	 * Méthode en attente car le predecesseur n'est pas encore utilisé
	 */
	/*
	@Test
	public void testGetPREDECESSEUR() {
		System.out.println("getPREDECESSEUR");
		System.out.println(autreTache.getPREDECESSEUR());
		assertEquals(new int[]{},autreTache.getPREDECESSEUR());
	}*/
	
	/**
	 * Test de la méthode getPREDECESSEUR() de la class Tache
	 * Méthode en attente car le predecesseur n'est pas encore utilisé
	 */
	/*
	@Test
	public void testGetSUCCESSEUR() {
		System.out.println("getSUCCESSEUR");
		System.out.println(autreTache.getSUCCESSEUR());
		assertEquals(new int[]{2, 3, 4},autreTache.getSUCCESSEUR());
	}*/
	
	/**
	 * Test de la méthode toString() de la class Tache
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Tache instance = new Tache("Dire", 20, 3, 4, alea0, alea1, alea2, new int[]{},new int[]{2, 3, 4});
		String expResult = "Id : 12\nNom : Dire\nSemaines : 3\nROUGE : Délai	3	KKK\nORANGE : Délai	1	L\nVERT : Délai	1	M\n";
		assertEquals(expResult, instance.toString());
	}
	
	/**
	 * Test de la méthode equals() de la class Tache
	 * ne pourra jamais tester 2 objets alea du fait
	 * de l'ID différent pour chaque alea
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		Tache instance = new Tache("Réfléchir", 10, 2, 4, alea0, alea1, alea2,new int[]{1},new int[]{5,7});
		assertTrue(instance.equals(exampleTache));
	}
	
	/**
	 * Test de la méthode equals() de la class Tache
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autreTache.equals(exampleTache));
	}
	
	/**
	 * Test de la méthode equals() de la class Tache avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		Tache instance = null;
		System.out.println(instance);
		System.out.println(exampleTache);
		assertFalse(exampleTache.equals(instance));
	}
	
	/**
	 * Test de la méthode equals() de la class Tache avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "Réfléchir, 10, 2, 4, alea0, alea1, alea2,new int[]{1},new int[]{5,7}";
		assertFalse(instance.equals(exampleTache));
	}

}
