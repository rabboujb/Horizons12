package testsUnitPartie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import partie.VueEquipes;

/**
 * @author Equipe Horizons12
 */

class VueEquipesTest {
	
	private final VueEquipes exampleEquipe;
	private VueEquipes autreEquipe;
	
	public VueEquipesTest() {
		this.exampleEquipe = new VueEquipes("Equipe 1");
		this.autreEquipe = new VueEquipes("Equipe 2");
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de VueEquipe");
		System.out.println("VueEquipe de référence: " + new VueEquipes("Equipe 1"));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de VueEquipe");
	}
	
	@Before
	public void setUp() {
		this.autreEquipe = new VueEquipes("Equipe 2");
	}		
		
	@After
	public void tearDown() {
		autreEquipe = null;
	}

	/**
	 * Test de la méthode getCaisse() de la class VueEquipe
	 */
	@Test
	public void testGetCaisse() {
		System.out.println("getCaisse");
		assertEquals(300,autreEquipe.getCaisse());
	}
	
	/**
	 * Test de la méthode getNom() 
	 * de la class VueEquipe
	 */
	@Test
	public void testGetNom() {
		System.out.println("getNom");
		assertEquals("Equipe 2",autreEquipe.getNom());
	}	

	/**
	 * Test de la méthode getQualite() de la class VueEquipe
	 */
	@Test
	public void testGetQualite() {
		System.out.println("getQualite");
		assertEquals(100,autreEquipe.getQualite());
	}	
	
	/**
	 * Test de la méthode baisseQualite() de la class VueEquipe
	 */
	@Test
	public void testbaisseQualite() {
		System.out.println("baisseQualite");
		autreEquipe.baisseQualite(10);
		assertEquals(90,autreEquipe.getQualite());
	}	
	
	/**
	 * Test de la méthode depense() de la class VueEquipe
	 */
	@Test
	public void testdepense() {
		System.out.println("depense");
		autreEquipe.depense(10);
		assertEquals(290,autreEquipe.getCaisse());
	}	
	
	
	/**
	 * Test de la méthode equals() de la class Description
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		VueEquipes instance = new VueEquipes("Equipe 1");
		assertTrue(instance.equals(exampleEquipe));
	}
	
	/**
	 * Test de la méthode equals() de la class Description
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autreEquipe.equals(exampleEquipe));
	}
	
	/**
	 * Test de la méthode equals() de la class Description avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		VueEquipes instance = null;
		assertFalse(autreEquipe.equals(instance));
	}
	
	/**
	 * Test de la méthode equals() de la class Description avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "Equipe 1";
		assertFalse(instance.equals(autreEquipe));
	}
}
