import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/*
 * Story 1
 * 
 * As a user 
 * I want to log in 
 * so that I don’t have to enter my information every time I make an order
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestValidEmailAndPassword.class,			// Story 1, Scenario 1
		TestValidEmailAndInvalidPassword.class,		            // Story 1, Scenario 2
		TestInvalidEmailAndPassword.class,			              // Story 1, Scenario 3
		TestNoEmailPassword.class,					                  // Story 1, Scenario 4
		TestEmailNoPassword.class})					                  // Story 1, Scenario 5
public class LoginTestSuite {

}
