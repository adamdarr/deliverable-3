
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCartAddMultiple {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.grubhub.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCartAddMultiple() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("#ghs-start-order-new-address-input > div.s-input-group.placeAutocomplete-inputWrapper > input[name=\"places-autocomplete\"]")).clear();
    driver.findElement(By.cssSelector("#ghs-start-order-new-address-input > div.s-input-group.placeAutocomplete-inputWrapper > input[name=\"places-autocomplete\"]")).sendKeys("346 Meyran Ave, Pittsburgh, PA, 15213");
    driver.findElement(By.id("ghs-startOrder-searchBtn")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.searchResultsSnippet-wrapper"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.get(baseUrl + "/restaurant/rbs-pizza-place-107-smithfield-st-pittsburgh/283688");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='ghs-outerWrapper']/div[3]/div/div[2]/div/div[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div[@id='Item13599192']/div/div/span[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("(//div[@class='s-row menu-item-add-cta'])"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("item_qty")).clear();
    driver.findElement(By.name("item_qty")).sendKeys("2");
    driver.findElement(By.cssSelector("div.s-modal-subHeader.menu-item-add-subHeader > div.s-row")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])")).click();
    driver.findElement(By.cssSelector("span.cartToggle-icon.icon-s-bag")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("(//div[@class='orderItems'])"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertTrue(isElementPresent(By.cssSelector("div.orderItem-name")));
    assertEquals("2", driver.findElement(By.cssSelector("div.orderItem-quantity-container.globalCart-plainText > span")).getText());
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
