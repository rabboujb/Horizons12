package testsUnitDescription;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * @author Equipe Horizons12
 */

@RunWith(Suite.class)

@Suite.SuiteClasses(
		{
			testsUnitDescription.DescriptionTest.class,
		}
)


public class TestsUnitSuite {

@BeforeClass
public static void setUpClass() throws Exception{
	System.out.println("Début de la suite de tests");
}

@AfterClass
public static void tearDownClass() throws Exception{
	System.out.println("Fin de la suite de tests");
}

}
