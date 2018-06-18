package testsUnitDescription;

import description.Description;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Ismerie
 */

public class DescriptionTest {
	
    private Description exampleDescription;
    private Description autreDescription;

    Description instance = new Description();
    	
	public DescriptionTest() {
		this.exampleDescription = new Description();
		this.autreDescription = new Description();
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de la class Description" + "\n");
		System.out.println("Description de référence: " + new Description() + "\n");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("\n" + "Fin du test de Description" + "\n");
	}
	
	@Before
	public void setUp() {
		this.exampleDescription = new Description();
	}
	
	@After
	public void tearDown() {
		exampleDescription = null;
	}

	/**
	 * Test de la methode getPlateau() de la class Description
	 */
	@Test
	public void testGetPlateau() {
		System.out.println("getPlateau");
		assertEquals(instance.getPlateau(),exampleDescription.getPlateau());
	}
	
	/**
	 * Test de la methode getTache() de la class Description
	 */
	@Test
	public void testGetTache() {
		System.out.println("getTache");
		System.out.println(instance.getTache(1));
		System.out.println(exampleDescription.getTache(1));
		assertEquals(instance.getTache(1),exampleDescription.getTache(1));
	}
	
	/**
	 * Test de la methode getTacheById() de la class Description
	 */
	@Test
	public void testGetTacheById() {
		System.out.println("getTacheById");
		assertEquals(instance.getTacheById(1),exampleDescription.getTacheById(1));
	}
	
	/**
	 * Test de la methode getTours() de la class Description
	 */
	@Test
	public void testGetTours() {
		System.out.println("getTours");
		assertEquals(instance,exampleDescription.getTours());
	}
	
	/**
	 * Test de la methode getTour() de la class Description
	 */
	@Test
	public void testGetTour() {
		System.out.println("getTour");
		assertEquals(instance.getTour(1),exampleDescription.getTour(1));
	}
	
	/**
	 * Test de la methode equals() de la class Description
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		assertTrue(instance.equals(autreDescription));
	}
	
	/**
	 * Test de la methode equals() de la class Description
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(instance.equals(autreDescription));
	}
	
	/**
	 * Test de la methode equals() de la class Description avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		Description instance = null;
		assertFalse(autreDescription.equals(instance));
	}
	
	/**
	 * Test de la methode equals() de la class Description avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "ROUGE,A,DELAI,1";
		assertFalse(instance.equals(autreDescription));
	}
}
