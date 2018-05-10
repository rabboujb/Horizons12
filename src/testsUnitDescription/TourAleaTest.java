package testsUnitDescription;

import static description.TypeTour.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import description.TourAlea;
/**
 * @author Equipe Horizons12
 */

class TourAleaTest {
	
	private final TourAlea exampleTour;
	private TourAlea autreTour;
	
	public TourAleaTest() {
		this.exampleTour = new TourAlea(1,ALEA,1);
		this.autreTour = new TourAlea(2,ALEA,1);
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de TourAlea");
		System.out.println("Tour de référence: " + new TourAlea(1,ALEA,1));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de TourAlea");
	}
	
	@Before
	public void setUp() {
		this.autreTour = new TourAlea(2,ALEA,1);
	}
	
	@After
	public void tearDown() {
		autreTour = null;
	}

	/**
	 * Test de la méthode getNUMERO() de la class TourALea
	 */
	@Test
	public void testGetNumero() {
		System.out.println("getNUMERO");
		assertEquals(2,autreTour.getNUMERO());
	}
	
	/**
	 * Test de la méthode getTYPE() de la class TourALea
	 */
	@Test
	public void testGetType() {
		System.out.println("getTYPE");
		assertEquals(ALEA,autreTour.getTYPE());
	}

	/**
	 * Test de la méthode equals() de la class TourAlea
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		TourAlea instance = new TourAlea(1,ALEA,1);
		assertTrue(instance.equals(exampleTour));
	}
	
	/**
	 * Test de la méthode equals() de la class TourAlea
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autreTour.equals(exampleTour));
	}
	
	/**
	 * Test de la méthode equals() de la class TourAlea avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		TourAlea instance = null;
		assertFalse(exampleTour.equals(instance));
	}
	
	/**
	 * Test de la méthode equals() de la class TourAlea avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "1,ALEA,1";
		assertFalse(instance.equals(exampleTour));
	}
	
	
	
	/**
	 * Test de la méthode toString() de la class TourAlea
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		TourAlea instance = new TourAlea(1,ALEA,1);
	    StringBuilder chaine = new StringBuilder();

	    chaine.append("Tour ").append("1").append(" : ").append("Aléa").append(" concernant la tâche ").append("1");
		assertEquals(chaine.toString(), instance.toString());
	}
	



}
