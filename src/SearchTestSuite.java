import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/*
 * Story 3
 * 
 * As a user 
 * I want to search for food categories 
 * so that I can narrow my selection
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestSearchPizza.class,          // Story 3, Scenario 1
    TestSearchHamburgers.class,     // Story 3, Scenario 2
    TestSearchSushi.class,          // Story 3, Scenario 3
    TestSearchChinese.class,        // Story 3, Scenario 4
    TestSearchCalzones.class        // Story 3, Scenario 5
})

public class SearchTestSuite {
  //nothing
}

