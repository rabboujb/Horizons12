package testsUnitPartie;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Ismerie
 */

@RunWith(Suite.class)

@Suite.SuiteClasses(
		{
			testsUnitPartie.EquipesTest.class,
			testsUnitPartie.RealisationTest.class,
			testsUnitPartie.VueEquipesTest.class,
		}

)

public class TestsUnitSuites {
	
	@BeforeClass
	public static void setUpClass() throws Exception{
		System.out.println("Début de la suite de tests du package testsUnitPartie " + "\n");
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception{
		System.out.println("\n" + "Fin de la suite de tests du package testsUnitPartie" + "\n");
	}

}
