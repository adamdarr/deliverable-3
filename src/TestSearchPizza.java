import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Story 3, Scenario 1
 * 
 * Given I type in a search for “pizza” 
 * when I press the search button 
 * then I’m given a results page with pizza restaurants
 */
public class TestSearchPizza {
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
  public void testSearchPizza() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("#ghs-start-order-new-address-input > div.s-input-group.placeAutocomplete-inputWrapper > input[name=\"places-autocomplete\"]")).clear();
    driver.findElement(By.cssSelector("#ghs-start-order-new-address-input > div.s-input-group.placeAutocomplete-inputWrapper > input[name=\"places-autocomplete\"]")).sendKeys("15213");
    driver.findElement(By.xpath("(//input[@type='search'])[4]")).click();
    driver.findElement(By.xpath("(//input[@type='search'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys("pizza");
    driver.findElement(By.id("ghs-startOrder-searchBtn")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector(".search-results-hero-searchTerm"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("Pizza", driver.findElement(By.cssSelector(".search-results-hero-searchTerm")).getText());
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
