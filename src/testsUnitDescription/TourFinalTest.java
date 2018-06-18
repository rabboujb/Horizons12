package testsUnitDescription;

import static description.TypeTour.ALEA;
import static description.TypeTour.JALON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import description.Description;
import description.TourAlea;
import description.TourFinal;
import description.TourJalon;
import description.TypeTour;
import partie.Realisation;

/**
 * @author Ismerie
 */


public class TourFinalTest {
	
	private final TourFinal exampleTourFinal;
	private TourFinal autreTourFinal;
	
	public TourFinalTest() {
		this.exampleTourFinal = new TourFinal(TypeTour.FINAL);
		this.autreTourFinal = new TourFinal(TypeTour.FINAL);
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("***** Début du test de TourFinal *****" + "\n");
		System.out.println("Tour de référence: " + new TourFinal(TypeTour.FINAL) + "\n");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("\n" + "***** Fin du test de TourFinal *****" + "\n");
	}
	
	@Before
	public void setUp() {
		this.autreTourFinal = new TourFinal(TypeTour.FINAL);
	}
	
	@After
	public void tearDown() {
		autreTourFinal = null;
	}
	
	/**
	 * Test de la methode equals() de la class TourFinal
	 */
	@Test
	public void testEquals_True() {
		System.out.println("Test equals: true");
		TourFinal instance = new TourFinal(TypeTour.FINAL);
		System.out.println(instance);
		assertTrue(instance.equals(autreTourFinal));
	}
	
	/**
	 * Test de la methode equals() de la class TourFinal
	 */
	@Test
	public void testEquals_False() {
		System.out.println("Test equals: false");
		assertFalse(autreTourFinal.equals(exampleTourFinal));
	}
	
	/**
	 * Test de la methode equals() de la class TourFinal avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("Test equals avec null");
		TourJalon instance = null;
		assertFalse(autreTourFinal.equals(instance));
	}
	
	/**
	 * Test de la methode equals() de la class TourFinal avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("Test equals avec un autre objet");
		String instance = "1,ALEA,1";
		assertFalse(instance.equals(autreTourFinal));
	}
	
	
	/**
	 * Test de la methode toString() de la class TourFinal
	 */
	@Test
	public void testToString() {
		System.out.println("Test méthode : toString");
        Description description = new Description();
        ArrayList<Realisation> realisations = new ArrayList<>();
        
        
		TourFinal instance = new TourFinal(TypeTour.FINAL);
		TourFinal chaine = new TourFinal(TypeTour.FINAL);
		
	    instance.calculerScore("test1", realisations, 200, 100);
	    chaine.calculerScore("test2", realisations, 200, 100);
	    assertEquals(chaine, instance.toString());
	}
	
	

}
