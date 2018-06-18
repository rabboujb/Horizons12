package testsUnitDescription;

import static description.TypeTour.*;
import description.Couleur;
import description.TourAlea;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Ismerie
 */

public class TourAleaTest {
	
	private final TourAlea exampleTourAlea;
	private TourAlea autreTourAlea;
	
	public TourAleaTest() {
		this.exampleTourAlea = new TourAlea(ALEA,1);
		this.autreTourAlea = new TourAlea(ALEA,2);
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("***** Début du test de TourAlea *****" + "\n");
		System.out.println("Tour de référence: " + new TourAlea(ALEA,1) + "\n");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println( "\n" + "***** Fin du test de TourAlea *****" + "\n");
	}
	
	@Before
	public void setUp() {
		this.autreTourAlea = new TourAlea(ALEA,1);
	}
	
	@After
	public void tearDown() {
		autreTourAlea = null;
	}

	/**
	 * Test de la methode getIDTache() de la class TourALea
	 */
	@Test
	public void testGetIDTache() {
		System.out.println("Test méthode : getIDTache");
		assertEquals(1,exampleTourAlea.getIdTache());
	}
	
	/**
	 * Test de la methode tirage() de la class TourALea
	 */
	@Test
	public void testTirage() {
		System.out.println("Test méthode : tirage");
		Couleur coul = exampleTourAlea.tirage();
		assertTrue(coul.equals(Couleur.ROUGE)||coul.equals(Couleur.ORANGE)||coul.equals(Couleur.VERT));
	}

	/**
	 * Test de la methode equals() de la class TourAlea
	 * ne sera jamais true car les id des tours sont différents
	 */
	@Test
	public void testEquals_True() {
		System.out.println("Test equals: true");
		TourAlea instance = new TourAlea(ALEA,1);
		assertTrue(instance.equals(autreTourAlea));
	}
	
	/**
	 * Test de la methode equals() de la class TourAlea
	 */
	@Test
	public void testEquals_False() {
		System.out.println("Test equals: false");
		assertFalse(autreTourAlea.equals(exampleTourAlea));
	}
	
	/**
	 * Test de la methode equals() de la class TourAlea avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("Test equals avec null");
		TourAlea instance = null;
		System.out.println(instance);
		System.out.println(autreTourAlea);
		assertFalse(autreTourAlea.equals(instance));
	}
	
	/**
	 * Test de la methode equals() de la class TourAlea avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "1,ALEA,1";
		assertFalse(instance.equals(autreTourAlea));
	}
	
	/**
	 * Test de la methode toString() de la class TourAlea
	 */
	@Test
	public void testToString() {
		System.out.println("Test méthode : toString");
		TourAlea instance = new TourAlea(ALEA,1);
	    String chaine = "Tour 14 : Aléa concernant la tâche 1";
		assertEquals(chaine, instance.toString());
	}


}
