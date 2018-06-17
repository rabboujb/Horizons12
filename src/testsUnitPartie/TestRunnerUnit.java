package testsUnitPartie;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testsUnitPartie.TestsUnitSuites;

/**
 * @author Ismerie
 */

public class TestRunnerUnit {

	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(TestsUnitSuites.class);
	  	
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }

	

}
