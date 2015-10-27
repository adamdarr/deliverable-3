import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/*
 * Test suite containing tests for all stories (see other suites for individual stories)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestValidEmailAndPassword.class,                // Story 1, Scenario 1
    TestValidEmailAndInvalidPassword.class,         // Story 1, Scenario 2
    TestInvalidEmailAndPassword.class,              // Story 1, Scenario 3
    TestNoEmailPassword.class,                      // Story 1, Scenario 4
    TestEmailNoPassword.class,                      // Story 1, Scenario 5
    
    TestCartAdd.class,                              // Story 2, Scenario 1
    TestCartRemove.class,                           // Story 2, Scenario 2
    TestCartAddMultiple.class,                      // Story 2, Scenario 3
    TestCartSubtotal.class,                         // Story 2, Scenario 4
    TestCartTotal.class,                            // Story 2, Scenario 5
    
    TestSearchPizza.class,                          // Story 3, Scenario 1
    TestSearchHamburgers.class,                     // Story 3, Scenario 2
    TestSearchSushi.class,                          // Story 3, Scenario 3
    TestSearchChinese.class,                        // Story 3, Scenario 4
    TestSearchCalzones.class,                       // Story 3, Scenario 5
    
    TestRatingsSearchStars.class,                   // Story 4, Scenario 1
    TestRatingsSearchNumber.class,                  // Story 4, Scenario 2
    TestRatingsPageStars.class,                     // Story 4, Scenario 3
    TestRatingsPageNumber.class,                    // Story 4, Scenario 4
    TestRatingsPageIndividualReviews.class})        // Story 4, Scenario 5
public class AllTestsSuite {}