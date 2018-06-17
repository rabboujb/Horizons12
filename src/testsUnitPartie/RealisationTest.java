package testsUnitPartie;

import partie.Equipes;
import partie.Realisation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import description.Alea;
import description.Description;
import description.Tache;

/**
 * @author Ismérie
 */

public class RealisationTest {
	
	private final Realisation exampleRealisation;
	private Realisation autreRealisation;
	
	public static Description description = new Description();
	
	
	public RealisationTest() {
		this.exampleRealisation = new Realisation(description.getTacheById(3));
		this.autreRealisation = new Realisation(description.getTacheById(2));
	}

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de Realisation");
		System.out.println("Tour de référence: " + new Realisation(description.getTacheById(3)));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de Realisation");
	}
	
	@Before
	public void setUp() {
		this.autreRealisation = new Realisation(description.getTacheById(2));
	}
	
	@After
	public void tearDown() {
		autreRealisation = null;
	}
	
	/**
	 * Test de la methode getTACHE() de la class Realisation
	 */
	@Test
	public void testGetTACHE() {
		System.out.println("getTACHE");
		Realisation instance = new Realisation(description.getTacheById(3));
		assertEquals(instance.getTACHE(),exampleRealisation.getTACHE());
	}
	
	/**
	 * Test de la methode getIdTache() de la class Realisation
	 */
	@Test
	public void testGetIdTache() {
		System.out.println("getIdTache");
		Realisation instance = new Realisation(description.getTacheById(3));
		assertEquals(instance.getIdTache(),exampleRealisation.getIdTache());
	}
	
	/**
	 * Test de la methode getPredeesseurs() de la class Realisation
	 */
	@Test
	public void testGetPredecesseurs() {
		System.out.println("getPredecesseurs");
		Realisation instance = new Realisation(description.getTacheById(3));
		assertEquals(instance.getTACHE().getPREDECESSEUR(),exampleRealisation.getTACHE().getPREDECESSEUR());
	}
	
	/**
	 * Test de la methode getSuccesseurs() de la class Realisation
	 */
	@Test
	public void testGetSuccesseurs() {
		System.out.println("getSuccesseurs");
		Realisation instance = new Realisation(description.getTacheById(3));
		assertEquals(instance.getTACHE().getSUCCESSEUR(),exampleRealisation.getTACHE().getSUCCESSEUR());
	}
	
	/**
	 * Test de la methode getSemainesReel() de la class Realisation
	 */
	@Test
	public void testGetSemainesReel() {
		System.out.println("getSemainesReel");
		Realisation instance = new Realisation(description.getTacheById(3));
		assertEquals(instance.getSemainesReel(),exampleRealisation.getSemainesReel());
	}

	/**
	 * Test de la methode getSemainesRestantes() de la class Realisation
	 */
	@Test
	public void testGetSemainesRestantes() {
		System.out.println("getSemainesRestantes");
		Realisation instance = new Realisation(description.getTacheById(3));
		assertEquals(instance.getSemainesRestantes(),exampleRealisation.getSemainesRestantes());
	}
	
	/**
	 * Test de la methode getDateAuPlusTot() de la class Realisation
	 */
	@Test
	public void testGetDateAuPlusTot() {
		System.out.println("getDateAuPlusTot");
		assertEquals(autreRealisation.getDateAuPlusTot(),exampleRealisation.getDateAuPlusTot());
	}
	
	/**
	 * Test de la methode setDateAuPlusTot() de la class Realisation
	 */
	@Test
	public void testSetDateAuPlusTot() {
		System.out.println("setDateAuPlusTot");
		exampleRealisation.setDateAuPlusTot(2);
		assertEquals(2,exampleRealisation.getDateAuPlusTot());
	}
	
	/**
	 * Test de la methode getDateAuPlusTard() de la class Realisation
	 */
	@Test
	public void testGetDateAuPlusTard() {
		System.out.println("getDateAuPlusTard");
		assertEquals(autreRealisation.getDateAuPlusTard(),exampleRealisation.getDateAuPlusTard());
	}
	
	/**
	 * Test de la methode setDateAuPlusTard() de la class Realisation
	 */
	@Test
	public void testSetDateAuPlusTard() {
		System.out.println("setDateAuPlusTard");
		exampleRealisation.setDateAuPlusTard(4);
		assertEquals(4,exampleRealisation.getDateAuPlusTard());
	}
	
	/**
	 * Test de la methode getMarque() de la class Realisation
	 */
	@Test
	public void testGetMarque() {
		System.out.println("getMarque");
		assertEquals(autreRealisation.getMarque(),exampleRealisation.getMarque());
	}
	
	/**
	 * Test de la methode setMarque() de la class Realisation
	 */
	@Test
	public void testSetMarque() {
		System.out.println("setMarque");
		exampleRealisation.setMarque(true);
		assertEquals(true,exampleRealisation.getMarque());
	}
	
	/**
	 * Test de la methode getRouge() de la class Realisation
	 */
	@Test
	public void testGetRouge() {
		System.out.println("getRouge");
		assertEquals(autreRealisation.getRouge(),exampleRealisation.getRouge());
	}
	
	/**
	 * Test de la methode getRouge() de la class Realisation
	 */
	@Test
	public void testGetOrange() {
		System.out.println("getOrange");
		assertEquals(autreRealisation.getOrange(),exampleRealisation.getOrange());
	}
	
	/**
	 * Test de la methode getRouge() de la class Realisation
	 */
	@Test
	public void testGetvert() {
		System.out.println("getVert");
		assertEquals(autreRealisation.getVert(),exampleRealisation.getVert());
	}
	
	/**
	 * Test de la methode getEtat() de la class Realisation
	 */
	@Test
	public void testGetEtat() {
		System.out.println("getEtat");
		assertEquals(autreRealisation.getEtat(),exampleRealisation.getEtat());
	}
	
	/**
	 * Test de la methode setEtat() de la class Realisation
	 */
	@Test
	public void testSetEtat() {
		System.out.println("setEtat");
		exampleRealisation.setEtat(null);
		assertEquals(null,exampleRealisation.getEtat());
	}
	
	
	
}
