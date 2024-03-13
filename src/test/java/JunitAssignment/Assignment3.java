package JunitAssignment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Assignment3
{
/*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/

    private WebDriver driver;

    @Before
    public void setup() {
        // Set up ChromeDriver and navigate to the URL
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/drag_drop.html");
    }

    @Test
    public void junitAssignment3() {
        // Perform drag and drop actions
        Actions actions = new Actions(driver);

        WebElement bankButton = driver.findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement debitSideAccount = driver.findElement(By.xpath("//ol[@id='bank']/li"));
        actions.dragAndDrop(bankButton, debitSideAccount).build().perform();

        WebElement salesButton = driver.findElement(By.xpath("//a[text()=' SALES ']"));
        WebElement creditSideAccount = driver.findElement(By.xpath("//ol[@id='loan']/li"));
        actions.dragAndDrop(salesButton, creditSideAccount).build().perform();

        WebElement amount5000Button = driver.findElement(By.xpath("//a[text()=' 5000 ']"));
        WebElement debitSideAmount = driver.findElement(By.xpath("//ol[@id='amt7']/li"));
        actions.dragAndDrop(amount5000Button, debitSideAmount).build().perform();

        WebElement amount5000Button2 = driver.findElement(By.xpath("//a[text()=' 5000 ']"));
        WebElement creditSideAmount = driver.findElement(By.xpath("//ol[@id='amt8']/li"));
        actions.dragAndDrop(amount5000Button2, creditSideAmount).build().perform();

        // Verify the visibility of the Perfect text
        WebElement perfectText = driver.findElement(By.xpath("(//a[contains(@class,'button-green')])[1]"));
        Assert.assertTrue(perfectText.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
