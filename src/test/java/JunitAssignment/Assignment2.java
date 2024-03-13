package JunitAssignment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
public class Assignment2
{
//Go to URL: https://the-internet.herokuapp.com/windows
//Verify the text: “Opening a new window”
//Verify the title of the page is “The Internet”
//Click on the “Click Here” button
//Verify the new window title is “New Window”
//Go back to the previous window and then verify the title: “The Internet”
    private WebDriver driver;
    private String WindowTitle;

    @Before
    public void setup() {
        // Set up ChromeDriver and navigate to the URL
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        // Store the title of the main window for later verification
        WindowTitle = driver.getTitle();
    }

    @Test
    public void junitAssignment2() {
        // Verify the text "Opening a new window"
        WebElement openingText = driver.findElement(By.tagName("h3"));
        Assert.assertEquals("Opening a new window", openingText.getText());

        // Verify the title of the page is "The Internet"
        Assert.assertEquals("The Internet", driver.getTitle());

        // Click on the "Click Here" button
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();

        // Switch to the new window
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Verify the new window title is "New Window"
        Assert.assertEquals("New Window", driver.getTitle());

        // Go back to the previous window
        driver.switchTo().window(mainWindowHandle);

        // Verify the title of the main window is "The Internet"
        Assert.assertEquals("The Internet", driver.getTitle());
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

