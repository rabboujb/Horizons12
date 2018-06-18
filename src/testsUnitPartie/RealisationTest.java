package testsUnitPartie;

import partie.Equipes;
import partie.Realisation;
import partie.VueEquipes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import description.Couleur;

/**
 * @author Ismerie
 */

public class RealisationTest {
	
	private final Realisation exampleRealisation;
	private Realisation autreRealisation;
	private Realisation autreRealisation2;
	
	public static Description description = new Description();
	
	
	public RealisationTest() {
		this.exampleRealisation = new Realisation(description.getTacheById(3));
		this.autreRealisation = new Realisation(description.getTacheById(2));
		this.autreRealisation2 = new Realisation(description.getTacheById(2));
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
	
	/**
	 * Test de la methode appliquerDelai() de la class Realisation
	 */
	@Test
	public void testAppliquerDelai() {
		System.out.println("appliquerDelai");
		exampleRealisation.appliquerDelai(2);
		assertEquals(4,exampleRealisation.getSemainesReel());
	}
	
	/**
	 * Test de la methode decrementerSemaine() de la class Realisation
	 */
	@Test
	public void testDecrementerSemaine() {
		System.out.println("decrementerSemaine");
		assertEquals(true,exampleRealisation.decrementerSemaine());
	}
	
	/**
	 * Test de la methode appliquerAcceleration() de la class Realisation
	 */
	@Test
	public void testAppliquerAcceleration() {
		System.out.println("appliquerAcceleration");
		assertEquals(true,exampleRealisation.appliquerAcceleration());
	}
	
	/**
	 * Test de la methode appliquerProtection() de la class Realisation
	 */
	@Test
	public void testAppliquerProtection() {
		System.out.println("appliquerProtection");
		assertEquals(true,exampleRealisation.appliquerProtection(Couleur.ROUGE));
	}
	
	/**
	 * Test de la methode equals() de la class Realisation
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		Realisation instance = new Realisation(description.getTacheById(2));
		assertTrue(instance.equals(autreRealisation));
	}
	
	/**
	 * Test de la methode equals() de la class Realisation
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autreRealisation.equals(exampleRealisation));
	}
	
	/**
	 * Test de la methode equals() de la class Realisation avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		Realisation instance = null;
		assertFalse(autreRealisation.equals(instance));
	}
	
	/**
	 * Test de la methode equals() de la class Realisation avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "Equipe 1";
		assertFalse(instance.equals(autreRealisation));
	}
	
	/**
	 * Test de la methode toString() de la class Realisation
	 */
	@Test
	public void testToString() {
		System.out.println("protege");
		assertEquals(autreRealisation2,autreRealisation);
	}
	
	
}
