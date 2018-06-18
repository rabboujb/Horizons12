package testsUnitDescription;

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
			testsUnitDescription.AleaTest.class,
			testsUnitDescription.DescriptionTest.class,
			testsUnitDescription.TacheTest.class,
			testsUnitDescription.TourAleaTest.class,
			testsUnitDescription.TourFinalTest.class,
			testsUnitDescription.TourJalonTest.class,
		}
)

public class TestsUnitSuite {

		@BeforeClass
		public static void setUpClass() throws Exception{
			System.out.println("***** Début de la suite de tests du package testsUnitDescription *****" + "\n");
		}
		
		@AfterClass
		public static void tearDownClass() throws Exception{
			System.out.println("\n" + "***** Fin de la suite de tests du package testsUnitDescription *****" + "\n");
		}

}
