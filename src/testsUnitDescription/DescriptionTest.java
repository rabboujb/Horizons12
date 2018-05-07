package testsUnitDescription;

import static description.TypeAlea.*;
import static description.Couleur.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import description.Description;

/**
 * @author Equipe Horizons12
 */

class DescriptionTest {
	
	private final Description example;
	private Description autre;
	
	/*public DescriptionTest() {
		this.example = new Description();
	}*/
	
	
	public DescriptionTest() {
		this.example = new Description(ROUGE,"A",DELAI,1);
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de Description");
		System.out.println("Description de référence: " + new Description(ROUGE,"A",DELAI,1));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de Description");
	}
	
	@Before
	public void setUp() {
		this.autre = new Description(ROUGE,"A",DELAI,1);
	}
	
	@After
	public void tearDown() {
		autre = null;
	}

	/**
	 * Test de la méthode getCouleur() de la class Description
	 */
	@Test
	public void testGetCouleur() {
		System.out.println("getCouleur");
		assertEquals(ROUGE,autre.getCouleur());
	}
	
	/**
	 * Test de la méthode getNom() de la class Description
	 */
	@Test
	public void testGetNom() {
		System.out.println("getNom");
		assertEquals("A",autre.getNom());
	}
	
	/**
	 * Test de la méthode getType() de la class Description
	 */
	@Test
	public void testGetType() {
		System.out.println("getType");
		assertEquals(EUROS,autre.getType());
	}
	
	/**
	 * Test de la méthode getGravite() de la class Description
	 */
	@Test
	public void testGetGravite() {
		System.out.println("getGravite");
		assertEquals(1,autre.getGravite());
	}
	
	/**
	 * Test de la méthode equals() de la class Description
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		Description instance = new Description(ROUGE,"A",DELAI,1);
		assertTrue(instance.equals(example));
	}
	
	/**
	 * Test de la méthode equals() de la class Description
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autre.equals(example));
	}
	
	/**
	 * Test de la méthode equals() de la class Description avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		Description instance = null;
		assertFalse(example.equals(instance));
	}
	
	/**
	 * Test de la méthode equals() de la class Description avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "ROUGE,A,DELAI,1";
		assertFalse(instance.equals(example));
	}
	
	
	
	/**
	 * Test de la méthode toString() de la class Description
	 */
	/*@Test
	public void testToString() {
		System.out.println("toString");
		Description instance = new Description(ORANGE,"BB",DELAI,2);
		String expResult = "ORANGE,BB,DELAI,2";
		assertEquals(expResult, instance.toString());
	}*/
	



}
