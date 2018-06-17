package testsUnitPartie;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testsUnitDescription.TestsUnitSuite;

/**
 * @author Ismerie
 */

public class TestRunnerUnit {

	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(TestsUnitSuite.class);
	  	
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }

	

}
