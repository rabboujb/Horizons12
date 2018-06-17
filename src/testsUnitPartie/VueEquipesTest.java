package testsUnitPartie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import description.Description;
import partie.VueEquipes;
import partie.VueJoueur;

/**
 * @author Ismerie
 */

public class VueEquipesTest {

	private VueEquipes exampleEquipe;
	private VueEquipes autreEquipe;
	private VueEquipes autreEquipe1;
	
	public static Description description = new Description ();
	
	public VueEquipesTest() {
		this.exampleEquipe = new VueEquipes("Equipe 1",description);
		this.autreEquipe = new VueEquipes("Equipe 2", description);
		this.autreEquipe1 = new VueEquipes("Equipe 1", description); 
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de VueEquipes");
		System.out.println("VueEquipe de référence: " + new VueEquipes("Equipe 1",description));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de VueEquipes");
	}
	
	@Before
	public void setUp() {
		this.autreEquipe = new VueEquipes("Equipe 2", description);
	}		
		
	@After
	public void tearDown() {
		autreEquipe = null;
	}

	/**
	 * Test de la methode getRealisation() de la class VueEquipes
	 */
	@Test
	public void testGetRealisation() {
		System.out.println("getRealisation");
		assertEquals(2,exampleEquipe.getRealisation(2));
	}
	
	/**
	 * Test de la methode getDonneesEquipe() de la class VueEquipes
	 */
	@Test
	public void testDonneesEquipe() {
		System.out.println("getDonneesEquipe");
		assertEquals(2,exampleEquipe.getDonneesEquipe());
	}
	
	/**
	 * Test de la methode getEquipes() de la class VueEquipes
	 */
	@Test
	public void testGetEquipes() {
		System.out.println("getEquipes");
		assertEquals(autreEquipe.getEquipes(),exampleEquipe.getEquipes());
	}
	
	/**
	 * Test de la methode getEquipe() de la class VueEquipes
	 */
	@Test
	public void testGetEquipe() {
		System.out.println("getEquipe");
		assertEquals(autreEquipe1.getEquipe("Equipe 2"),exampleEquipe.getEquipe("Equipe 1"));
	}
	
	/**
	 * Test de la methode ajouterEquipe() de la class VueEquipes
	 */
	@Test
	public void testAjouterEquipe() {
		VueJoueur  equipe = new VueEquipes();
		equipe.ajouterEquipe(new VueEquipes("Equipe 2", description));
		System.out.println("getAjouterEquipe");
		assertEquals(equipe.getEquipe("Equipe 2"),exampleEquipe.getEquipe("Equipe 2"));
	}
	
	/**
	 * Test de la methode finDutour() de la class VueEquipes
	 */
	@Test
	public void testFinDuTour() {
		System.out.println("finDuTour()");
		assertEquals(1,exampleEquipe.getNumeroTour());
	}
		
	/**
	 * Test de la methode getCaisse() de la class VueEquipes
	 */
	@Test
	public void testGetCaisse() {
		System.out.println("getCaisse");
		assertEquals(300,exampleEquipe.getCaisse());
	}
	
	/**
	 * Test de la méthode getCurrent(String id) de la class VueEquipes
	 */
	@Test
	public void testGetCurrent() {
		System.out.println("getCurrent(String id)");
		assertEquals("A",exampleEquipe.getCurrent("A"));
	}
	
	/**
	 * Test de la methode getDebutId() de la class VueEquipes
	 */
	@Test
	public void testGetDebutId() {
		System.out.println("getDebutId()");
		assertEquals("A",exampleEquipe.getDebutId());
	}
	
	/**
	 * Test de la methode getPlateau() de la class VueEquipes
	 */
	@Test
	public void testGetPlateau() {
		System.out.println("getPlateau()");
		assertEquals("A",exampleEquipe.getPlateau());
	}
	
	/**
	 * Test de la methode getDuree(int id) de la class VueEquipes
	 */
	@Test
	public void testGetDuree() {
		System.out.println("getDuree(int id)");
		assertEquals(1,exampleEquipe.getDuree(1));
	}
	
	/**
	 * Test de la methode getFinId() de la class VueEquipes
	 */
	@Test
	public void testGetFinId() {
		System.out.println("getFinId()");
		assertEquals(1,exampleEquipe.getFinId());
	}

	/**
	 * Test de la methode getNom() de la class VueEquipes
	 */
	@Test
	public void testGetNom() {
		System.out.println("getNom");
		assertEquals("Equipe 2",exampleEquipe.getNom());
	}	

	/**
	 * Test de la methode getNumeroTour() de la class VueEquipes
	 */
	@Test
	public void testGetNumeroTour() {
		System.out.println("getNumeroTour");
		assertEquals(2,exampleEquipe.getNumeroTour());
	}	

	
	/**
	 * Test de la methode getQualite() de la class VueEquipes
	 */
	@Test
	public void testGetQualite() {
		System.out.println("getQualite");
		assertEquals(100,exampleEquipe.getQualite());
	}	
	
	/**
	 * Test de la methode baisseQualite(int delta) de la class VueEquipe
	 */
	@Test
	public void testBaisseQualite() {
		//System.out.println("baisseQualite");
		autreEquipe.baisseQualite(10);
		//System.out.println(this.autreEquipe);
		assertEquals(autreEquipe.getQualite(),exampleEquipe.getQualite());
	}	
	
	/**
	 * Test de la methode depense(int somme) de la class VueEquipes
	 */
	@Test
	public void testdepense() {
		System.out.println(autreEquipe.getCaisse());
		System.out.println("depense");
		autreEquipe.depense(10);
		assertEquals(290,exampleEquipe.getCaisse());
	}	
	
	
	/**
	 * Test de la methode equals() de la class Description
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		VueEquipes instance = new VueEquipes("Equipe 1", description);
		assertTrue(instance.equals(autreEquipe));
	}
	
	/**
	 * Test de la methode equals() de la class Description
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autreEquipe.equals(exampleEquipe));
	}
	
	/**
	 * Test de la methode equals() de la class Description avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		VueEquipes instance = null;
		assertFalse(autreEquipe.equals(instance));
	}
	
	/**
	 * Test de la methode equals() de la class Description avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "Equipe 1";
		assertFalse(instance.equals(autreEquipe));
	}
	
	/**
	 * Test de la methode toString() de la class Equipes
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		
		//String instance = "Equipe 1";
		//System.out.println(autreEquipe);
	    String chaine = "VueEquipes{, nomEquipe='Equipe 2', numeroTour=0}";
		assertEquals(chaine, autreEquipe.toString());
	}

}
