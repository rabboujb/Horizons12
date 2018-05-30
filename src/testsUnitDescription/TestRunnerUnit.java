package testsUnitDescription;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Ismérie
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
	
