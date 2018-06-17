package testsUnitDescription;

import static description.TypeTour.ALEA;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import description.TourAlea;
import description.TourFinal;

/**
 * @author Ismérie
 */


public class TourFinalTest {
	
	private final TourFinal exampleTourFinal;
	private TourFinal autreTourFinal;
	
	public TourFinalTest() {
		this.exampleTourFinal = new TourFinal();
		this.autreTourFinal = new TourFinal();
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de TourFinal" + "\n");
		System.out.println("Tour de référence: " + new TourFinal() + "\n");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("\n" + "Fin du test de TourFinal" + "\n");
	}
	
	@Before
	public void setUp() {
		this.autreTourFinal = new TourFinal();
	}
	
	@After
	public void tearDown() {
		autreTourFinal = null;
	}
	
	
	

}
