package JunitAssignment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Assignment7
{
    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Go to amazon.com
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void junitAssignment7() throws IOException {
        // Go to amazon.com
        driver.get("https://www.amazon.com/");

        // Take Full Page Screenshot
        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(fullPageScreenshot, new File("full_page_screenshot.png"));

        // Replace with the specific WebElement you want to capture (e.g., search bar)
        WebElement specificElement = driver.findElement(By.xpath("//button[@type='submit']"));

        // Take specific WebElement Screenshot
        File elementScreenshot = specificElement.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(elementScreenshot, new File("specific_element_screenshot.png"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
