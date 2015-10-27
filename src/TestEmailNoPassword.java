import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Story 1, Scenario 5
 * 
 * Given no password is entered 
 * when logging in 
 * then I should be prompted to enter a password
 */
public class TestEmailNoPassword {
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
  public void testEmailNoPassword() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.cssSelector("form[name=\"signInVm.signInForm\"] > div.s-row.s-form-group > div.s-col-sm-12 > input[name=\"email\"]")).clear();
    driver.findElement(By.cssSelector("form[name=\"signInVm.signInForm\"] > div.s-row.s-form-group > div.s-col-sm-12 > input[name=\"email\"]")).sendKeys("billlaboon@gmx.com");
    driver.findElement(By.cssSelector("div.s-col-sm-12.s-form-group > input[name=\"password\"]")).clear();
    driver.findElement(By.cssSelector("div.s-col-sm-12.s-form-group > input[name=\"password\"]")).sendKeys("");
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    assertEquals("Valid password is required", driver.findElement(By.cssSelector("p > span")).getText());
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
