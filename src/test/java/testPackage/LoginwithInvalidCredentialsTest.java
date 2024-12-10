package testPackage;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginwithInvalidCredentialsTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void loginwithInvalidCredentials() {
    driver.get("https://pa.portal.ndproject.dev/");
    driver.manage().window().setSize(new Dimension(1850, 1053));
    driver.findElement(By.id(":r0:")).sendKeys("thejaswini+devscribe@navadhiti.com");
    driver.findElement(By.id(":r1:")).sendKeys("Teju@55");
    driver.findElement(By.cssSelector(".MuiButton-root")).click();
    driver.findElement(By.cssSelector(".MuiAlert-message")).click();
    driver.close();
  }
}
