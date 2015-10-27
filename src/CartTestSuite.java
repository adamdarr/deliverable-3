import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/*
 * Story 2
 * 
 * As a user 
 * I want to have a shopping cart 
 * so that I can manage my order
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestCartAdd.class,              // Story 2, Scenario 1
    TestCartRemove.class,           // Story 2, Scenario 2
    TestCartAddMultiple.class,      // Story 2, Scenario 3
    TestCartSubtotal.class,         // Story 2, Scenario 4
    TestCartTotal.class             // Story 2, Scenario 5
})

public class CartTestSuite {
  //nothing
}


