import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/*
 * Story 4 
 * 
 * As a user 
 * I want to be able see ratings of restaurants 
 * so that I can make a more informed decision
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestRatingsSearchStars.class, 				// Story 4, Scenario 1
					TestRatingsSearchNumber.class, 				// Story 4, Scenario 2
					TestRatingsPageStars.class, 				// Story 4, Scenario 3
					TestRatingsPageNumber.class, 				// Story 4, Scenario 4
					TestRatingsPageIndividualReviews.class}) 	// Story 4, Scenario 5
public class RatingsTestSuite {

}