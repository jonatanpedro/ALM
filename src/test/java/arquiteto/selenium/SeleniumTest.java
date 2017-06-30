package arquiteto.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelenium() throws Exception {
    driver.get("http://localhost:8080/almproject/index.jsp");
    driver.findElement(By.name("ano")).clear();
    driver.findElement(By.name("ano")).sendKeys("2001");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertThat(driver.findElement(By.id("resposta")).getText()).isEqualTo("Ano 2001 não é bissexto.");
    driver.findElement(By.linkText("Voltar")).click();
    driver.findElement(By.name("ano")).clear();
    driver.findElement(By.name("ano")).sendKeys("2000");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertThat(driver.findElement(By.id("resposta")).getText()).isEqualTo("Ano 2000 é bissexto.");
    driver.findElement(By.linkText("Voltar")).click();
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
