package testsUnitDescription;

import static description.TypeAlea.*;
import static description.Couleur.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import description.Alea;
import description.Description;
import description.Tache;

/**
 * @author Equipe Horizons12
 */

class DescriptionTest {
	
	private final Description exampleAlea;
	private Description autreAlea;
	private final Description exampleTache;
	private Description autreTache;
	
	public DescriptionTest() {
		List<Alea> aleas = new ArrayList<>();		
		this.exampleAlea = new Description(ROUGE,"A",DELAI,1);
		aleas.add(this.exampleAlea);
		this.autreAlea = new Description(ORANGE,"BB",DELAI,2);
		aleas.add(this.autreAlea);
		
        this.exampleTache = new Description("1", "Réfléchir", 10, 2, 4, exampleAlea, exampleAlea, exampleAlea);
        this.autreTache = new Description("2", "Dire", 20, 3, 4, autreAlea, autreAlea, autreAlea);      
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de Description");
		System.out.println("Description de référence: " + new Description(ROUGE,"A",DELAI,1));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de Description");
	}
	
	@Before
	public void setUp() {
		this.autreAlea = new Description(ROUGE,"A",DELAI,1);
        this.autreTache = new Description("1", "Réfléchir", 10, 2, 4, autreAlea, autreAlea, autreAlea);	}
	
	@After
	public void tearDown() {
		autreAlea = null;
		autreTache = null;
	}

	/**
	 * Test de la méthode getCouleur() de la class Description
	 */
	@Test
	public void testGetCouleur() {
		System.out.println("getCouleur");
		assertEquals(ORANGE,autreAlea.getCouleur());
	}
	
	/**
	 * Test de la méthode getNom() de la class Description
	 */
	@Test
	public void testGetNom() {
		System.out.println("getNom");
		assertEquals("BB",autreAlea.getNom());
	}
	
	/**
	 * Test de la méthode getType() de la class Description
	 */
	@Test
	public void testGetType() {
		System.out.println("getType");
		assertEquals(DELAI,autreAlea.getType());
	}
	
	/**
	 * Test de la méthode getGravite() de la class Description
	 */
	@Test
	public void testGetGravite() {
		System.out.println("getGravite");
		assertEquals(2,autreAlea.getGravite());
	}
	
	/**
	 * Test de la méthode getId() de la class Description
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		assertEquals("2",autreTache.getId());
	}

	/**
	 * Test de la méthode getDescription() de la class Description
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		assertEquals("Dire",autreTache.getDescription());
	}

	/**
	 * Test de la méthode coutAcceleration() de la class Description
	 */
	@Test
	public void testCoutAcceleration() {
		System.out.println("coutacceleration");
		assertEquals(20,autreTache.coutAcceleration());
	}

	/**
	 * Test de la méthode getDureeInitiale() de la class Description
	 */
	@Test
	public void testGetDureeInitiale() {
		System.out.println("getDureeInitiale");
		assertEquals(3,autreTache.getDureeInitiale());
	}

	/**
	 * Test de la méthode getDureeMax() de la class Description
	 */
	@Test
	public void testGetDureeMax() {
		System.out.println("getDureeMax");
		assertEquals(4,autreTache.getDureeMax());
	}

	/**
	 * Test de la méthode getAlea() de la class Description
	 */
	@Test
	public void testGetAlea() {
		System.out.println("getAlea");
		assertEquals(autreAlea,autreTache.getAlea(ROUGE));
	}
	
	/**
	 * Test de la méthode equals() de la class Description
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		Description instance = new Description(ROUGE,"A",DELAI,1);
		assertTrue(instance.equals(exampleAlea));
	}
	
	/**
	 * Test de la méthode equals() de la class Description
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autreAlea.equals(exampleAlea));
	}
	
	/**
	 * Test de la méthode equals() de la class Description avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		Description instance = null;
		assertFalse(exampleAlea.equals(instance));
	}
	
	/**
	 * Test de la méthode equals() de la class Description avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "ROUGE,A,DELAI,1";
		assertFalse(instance.equals(exampleAlea));
	}
	
	
	
	/**
	 * Test de la méthode toString() de la class Description
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Description instance = new Description(ORANGE,"BB",DELAI,2);
		String expResult = "Aléa {" +
                "couleur=ORANGE" +
                ", nom='BB" + '\'' +
                ", type=DELAI" +
                ", gravite=2" +
                '}';
		assertEquals(expResult, instance.toString());
	}
	



}
