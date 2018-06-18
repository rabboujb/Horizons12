package testsUnitDescription;

import static description.TypeTour.*;
import description.TourJalon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.ArrayList;

/**
 * @author Ismerie
 */

public class TourJalonTest {
	
	private final TourJalon exampleTourJalon;
	private TourJalon autreTourJalon;
	
	public TourJalonTest() {
		this.exampleTourJalon = new TourJalon(JALON,new int[]{1, 2, 3, 4});
		this.autreTourJalon = new TourJalon(JALON,new int[]{5, 6, 7, 8});
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("***** Début du test de TourJalon *****" + "\n");
		System.out.println("Tour de référence: " + new TourJalon(JALON,new int[]{1, 2, 3, 4}) + "\n");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("\n" + "***** Fin du test de TourJalon *****" + "\n");
	}
	
	@Before
	public void setUp() {
		this.autreTourJalon = new TourJalon(JALON,new int[]{1, 2, 3, 4});
	}
	
	@After
	public void tearDown() {
		autreTourJalon = null;
	}
	
	/**
	 * Test de la methode getIDTache() de la class TourJalon
	 */
	@Test
	public void testGetIDTaches() {
		System.out.println("Test méthode : getIDTaches");
		ArrayList<Integer> idTaches = new ArrayList<>();
		idTaches.add(1);
		idTaches.add(2);
		idTaches.add(3);
		idTaches.add(4);
		assertEquals(idTaches,exampleTourJalon.getIdTaches());
	}
	
	
	/**
	 * Test de la methode equals() de la class TourJalon
	 * ne sera jamais true car les id des tours sont differents
	 */
	@Test
	public void testEquals_True() {
		System.out.println("Test equals: true");
		TourJalon instance = new TourJalon(JALON,new int[]{5, 6, 7, 8});
		assertTrue(instance.equals(autreTourJalon));
	}
	
	/**
	 * Test de la methode equals() de la class TourJalon
	 */
	@Test
	public void testEquals_False() {
		System.out.println("Test equals: false");
		assertFalse(autreTourJalon.equals(exampleTourJalon));
	}
	
	/**
	 * Test de la methode equals() de la class TourJalon avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("Test equals avec null");
		TourJalon instance = null;
		assertFalse(autreTourJalon.equals(instance));
	}
	
	/**
	 * Test de la methode equals() de la class TourJalon avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("Test equals avec un autre objet");
		String instance = "1,ALEA,1";
		assertFalse(instance.equals(autreTourJalon));
	}
	
	
	/**
	 * Test de la methode toString() de la class TourJalon
	 */
	@Test
	public void testToString() {
		System.out.println("Test méthode : toString");
		TourJalon instance = new TourJalon(JALON,new int[]{1, 2, 3, 4});
	    String chaine = "Tour 17 : Jalon concernant les tâches : 1 2 3 4 ";
	    System.out.println(instance.toString());
	    System.out.println(chaine);
	    assertEquals(chaine, instance.toString());
	}
	
}
