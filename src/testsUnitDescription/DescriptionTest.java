package testsUnitDescription;

import static description.TypeAlea.*;
import static description.Couleur.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import description.DescriptionObsolete;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

/**
 * @author Equipe Horizons12
 */

class DescriptionTest {
	
	private final DescriptionObsolete exampleAlea;
	private DescriptionObsolete autreAlea;
	private final DescriptionObsolete exampleTache;
	private DescriptionObsolete autreTache;
	
	public DescriptionTest() {
		List<Alea> aleas = new ArrayList<>();		
		this.exampleAlea = new DescriptionObsolete(ROUGE,"A",DELAI,1);
		aleas.add(this.exampleAlea);
		this.autreAlea = new DescriptionObsolete(ORANGE,"BB",DELAI,2);
		aleas.add(this.autreAlea);
		
        this.exampleTache = new DescriptionObsolete("1", "Réfléchir", 10, 2, 4, exampleAlea, exampleAlea, exampleAlea);
        this.autreTache = new DescriptionObsolete("2", "Dire", 20, 3, 4, autreAlea, autreAlea, autreAlea);
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Début du test de DescriptionObsolete");
		System.out.println("DescriptionObsolete de référence: " + new DescriptionObsolete(ROUGE,"A",DELAI,1));
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fin du test de DescriptionObsolete");
	}
	
	@Before
	public void setUp() {
		this.autreAlea = new DescriptionObsolete(ROUGE,"A",DELAI,1);
        this.autreTache = new DescriptionObsolete("1", "Réfléchir", 10, 2, 4, autreAlea, autreAlea, autreAlea);	}
	
	@After
	public void tearDown() {
		autreAlea = null;
		autreTache = null;
	}

	/**
	 * Test de la méthode getCouleur() de la class DescriptionObsolete
	 */
	@Test
	public void testGetCouleur() {
		System.out.println("getCouleur");
		assertEquals(ORANGE,autreAlea.getCouleur());
	}
	
	/**
	 * Test de la méthode getNom() de la class DescriptionObsolete
	 */
	@Test
	public void testGetNom() {
		System.out.println("getNom");
		assertEquals("BB",autreAlea.getNom());
	}
	
	/**
	 * Test de la méthode getType() de la class DescriptionObsolete
	 */
	@Test
	public void testGetType() {
		System.out.println("getType");
		assertEquals(DELAI,autreAlea.getType());
	}
	
	/**
	 * Test de la méthode getGravite() de la class DescriptionObsolete
	 */
	@Test
	public void testGetGravite() {
		System.out.println("getGravite");
		assertEquals(2,autreAlea.getGravite());
	}
	
	/**
	 * Test de la méthode getId() de la class DescriptionObsolete
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		assertEquals("2",autreTache.getId());
	}

	/**
	 * Test de la méthode getDescription() de la class DescriptionObsolete
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		assertEquals("Dire",autreTache.getDescription());
	}

	/**
	 * Test de la méthode coutAcceleration() de la class DescriptionObsolete
	 */
	@Test
	public void testCoutAcceleration() {
		System.out.println("coutacceleration");
		assertEquals(20,autreTache.coutAcceleration());
	}

	/**
	 * Test de la méthode getDureeInitiale() de la class DescriptionObsolete
	 */
	@Test
	public void testGetDureeInitiale() {
		System.out.println("getDureeInitiale");
		assertEquals(3,autreTache.getDureeInitiale());
	}

	/**
	 * Test de la méthode getDureeMax() de la class DescriptionObsolete
	 */
	@Test
	public void testGetDureeMax() {
		System.out.println("getDureeMax");
		assertEquals(4,autreTache.getDureeMax());
	}

	/**
	 * Test de la méthode getAlea() de la class DescriptionObsolete
	 */
	@Test
	public void testGetAlea() {
		System.out.println("getAlea");
		assertEquals(autreAlea,autreTache.getAlea(ROUGE));
	}
	
	/**
	 * Test de la méthode equals() de la class DescriptionObsolete
	 */
	@Test
	public void testEquals_True() {
		System.out.println("equals: true");
		DescriptionObsolete instance = new DescriptionObsolete(ROUGE,"A",DELAI,1);
		assertTrue(instance.equals(exampleAlea));
	}
	
	/**
	 * Test de la méthode equals() de la class DescriptionObsolete
	 */
	@Test
	public void testEquals_False() {
		System.out.println("equals: false");
		assertFalse(autreAlea.equals(exampleAlea));
	}
	
	/**
	 * Test de la méthode equals() de la class DescriptionObsolete avec null
	 */
	@Test
	public void testEquals_Null_Object() {
		System.out.println("equals avec null");
		DescriptionObsolete instance = null;
		assertFalse(exampleAlea.equals(instance));
	}
	
	/**
	 * Test de la méthode equals() de la class DescriptionObsolete avec un autre objet
	 */
	@Test
	public void testEquals_Other_Object() {
		System.out.println("equals avec un autre objet");
		String instance = "ROUGE,A,DELAI,1";
		assertFalse(instance.equals(exampleAlea));
	}
	
	
	
	/**
	 * Test de la méthode toString() de la class DescriptionObsolete
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		DescriptionObsolete instance = new DescriptionObsolete(ORANGE,"BB",DELAI,2);
		String expResult = "Aléa {" +
                "couleur=ORANGE" +
                ", nom='BB" + '\'' +
                ", type=DELAI" +
                ", gravite=2" +
                '}';
		assertEquals(expResult, instance.toString());
	}
	



}
