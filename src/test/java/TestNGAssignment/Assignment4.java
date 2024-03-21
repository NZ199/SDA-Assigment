package TestNGAssignment;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.testng.Tests;

public class Assignment4 extends Tests {
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    @Test(dataProvider = "searchQuery")
    public void searchProduct(String searchTerm) throws InterruptedException {
        // Login
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys("clarusway@gmail.com");

        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys("123456789");

        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();

        // Search for product

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));

        searchButton.click();

        // Verify search results (add your verification logic here)
        Thread.sleep(2000); // Add a short wait for results to load (replace with proper verification)
        System.out.println("Searched for: " + searchTerm);
    }
    @DataProvider(name = "searchQuery")
    public Object[][] searchQuery() {
        return new Object[][] {
                {"iPad"}, {"Mac"},{"Samsung"}
        };
    }
}

