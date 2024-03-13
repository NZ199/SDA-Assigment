package JunitAssignment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Assignment4
{
    // ( This task should be managed with keyboard actions )
    // go to https://www.google.com/
    // search for "Scroll Methods" by using an Actions object

    private WebDriver driver;

    @Before
    public void setup() {
        // Set up ChromeDriver and navigate to the URL
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void junitAssignment4() {
        // Use Actions class to perform keyboard actions
        Actions actions = new Actions(driver);

        // Press and hold SHIFT key, type "s" and release SHIFT key
        actions.keyDown(Keys.SHIFT).sendKeys("s").keyUp(Keys.SHIFT);

        // Continue typing "croll"
        actions.sendKeys("croll");

        // Click SPACE key
        actions.sendKeys(Keys.SPACE);

        // Type "m" in capital
        actions.keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT);

        // Continue typing "ethods"
        actions.sendKeys("ethods");

        // Press ENTER key
        actions.sendKeys(Keys.ENTER);

        // Perform the actions
        actions.perform();
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}