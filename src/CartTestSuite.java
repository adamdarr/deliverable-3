import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestCartAdd.class,
    TestCartRemove.class,
    TestCartAddMultiple.class,
    TestCartSubtotal.class,
    TestCartTotal.class
})

public class CartTestSuite {
  //nothing
}


