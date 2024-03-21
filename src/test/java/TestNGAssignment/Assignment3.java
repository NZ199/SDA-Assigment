package TestNGAssignment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import tests.testng.Tests;

public class Assignment3  {
/* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!"
*/
WebDriver driver = new ChromeDriver();
@BeforeClass
public void setUp() {
    driver = new ChromeDriver();
}
 @Test
 public  void TestNGAssignment3()
 {

  driver.get("https://practicetestautomation.com/practice-test-login/");

  WebElement usernameField = driver.findElement(By.id("username"));
  usernameField.sendKeys("student");

  WebElement passwordField = driver.findElement(By.id("password"));
  passwordField.sendKeys("incorrectPassword");

  WebElement loginButton = driver.findElement(By.id("submit"));
  loginButton.click();

  SoftAssert softAssert = new SoftAssert();

  // SOFT ASSERT error message is shown
  WebElement errorMessage = driver.findElement(By.id("error"));
  softAssert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

  // SOFT ASSERT error message content
  String actualErrorMessage = errorMessage.getText();
  softAssert.assertEquals(actualErrorMessage, "Your password is invalid!", "Incorrect error message");

  softAssert.assertAll(); // Throw an exception if any soft assertions failed

   }
    @AfterClass
    public void tearDown() {
        // Close the WebDriver
        driver.quit();
    }
    }

