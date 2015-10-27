import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Story 4, Scenario 2
 * 
 * Given I enter a search for restaurants in my area (15213) 
 * when I see the results 
 * then I should be able to see the number of ratings for each of the results 
 */
public class TestRatingsSearchNumber {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.grubhub.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRatingsSearchNumber() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("#ghs-start-order-new-address-input > div.s-input-group.placeAutocomplete-inputWrapper > input[name=\"places-autocomplete\"]")).clear();
    driver.findElement(By.cssSelector("#ghs-start-order-new-address-input > div.s-input-group.placeAutocomplete-inputWrapper > input[name=\"places-autocomplete\"]")).sendKeys("15213");
    driver.findElement(By.id("ghs-startOrder-searchBtn")).click();
    Number ratingNumber = driver.findElements(By.xpath("//*[contains(@class, 'rating-count')]")).size();
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | ${ratingNumber} > 0 ? true : false | ]]
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
