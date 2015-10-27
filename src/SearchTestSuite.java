import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestSearchPizza.class,
    TestSearchHamburgers.class,
    TestSearchSushi.class,
    TestSearchChinese.class,
    TestSearchCalzones.class
})

public class SearchTestSuite {
  //nothing
}

