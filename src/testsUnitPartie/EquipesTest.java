package testsUnitPartie;

import static description.TypeTour.ALEA;
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
import description.Couleur;
import description.Tache;
import description.TourAlea;
import description.TypeAlea;
import partie.Equipes;

/**
 * @author Ismerie
 */


public class EquipesTest {
	
	private final Equipes exampleEquipes;
	private Equipes autreEquipes;
	
	public EquipesTest() {
		this.exampleEquipes = new Equipes("Equipe 1", 300, 100);
		this.autreEquipes = new Equipes("Equipe 2", 300, 100);
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de Equipes");
		System.out.println("Tour de référence: " + new Equipes("Equipe 1", 300, 100));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de Equipes");
	}
	
	@Before
	public void setUp() {
		this.autreEquipes = new Equipes("Equipe 2", 300, 100);
	}
	
	@After
	public void tearDown() {
		autreEquipes = null;
	}
	
	/**
	 * Test de la methode getCaisse() de la class Equipes
	 */
	@Test
	public void testGetCaisse() {
		System.out.println("getCaisse");
		assertEquals(300,exampleEquipes.getCaisse());
	}
	
	/**
	 * Test de la methode getNom() de la class Equipes
	 */
	@Test
	public void testGetNom() {
		System.out.println("getNom");
		assertEquals("Equipe 1",exampleEquipes.getNom());
	}
	
	/**
	 * Test de la methode getQualite() de la class Equipes
	 */
	@Test
	public void testGetQualite() {
		System.out.println("getQualite");
		assertEquals(100,exampleEquipes.getQualite());
	}
	
	/**
	 * Test de la methode getBaisseQualite() de la class Equipes
	 */
	@Test
	public void testGetBaisseQualite() {
		System.out.println("getBaisseQualite");
		assertEquals(autreEquipes.getQualite(),exampleEquipes.getQualite());
	}
	
	/**
	 * Test de la methode depense(int somme) de la class Equipes
	 */
	@Test
	public void testdepense() {
		System.out.println("depense");
		autreEquipes.depense(10);
		assertEquals(290,autreEquipes.getCaisse());
	}	
	
	/**
	 * Test de la methode equals() de la class Equipes
	 * ne sera jamais true car les id des tours sont différents
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		Equipes instance = new Equipes("Equipe 2", 300, 100);
		assertTrue(instance.equals(autreEquipes));
	}
	
	/**
	 * Test de la methode equals() de la class Equipes
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autreEquipes.equals(exampleEquipes));
	}
	
	/**
	 * Test de la methode equals() de la class Equipes avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		Equipes instance = null;
		assertFalse(autreEquipes.equals(instance));
	}
	
	/**
	 * Test de la méthode equals() de la class Equipes avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "Equipe 1, 300, 100";
		assertFalse(instance.equals(autreEquipes));
	}
	
	/**
	 * Test de la methode toString() de la class Equipes
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Equipes instance = new Equipes("Equipe 1", 300, 100);
	    String chaine = "Equipes{nomEquipe='Equipe 1', caisse=300, qualite=100}";
		assertEquals(chaine, instance.toString());
	}
	

}
