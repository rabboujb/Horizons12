package testsUnitPartie;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Ismérie
 */

@RunWith(Suite.class)

@Suite.SuiteClasses(
		{
			testsUnitPartie.VueEquipesTest.class,
		}

)

public class TestsUnitSuites {
	
	@BeforeClass
	public static void setUpClass() throws Exception{
		System.out.println("Début de la suite de tests");
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception{
		System.out.println("Fin de la suite de tests");
	}

}
