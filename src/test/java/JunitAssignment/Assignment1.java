package JunitAssignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1
{
//Go to URL: https://api.jquery.com/dblclick/
//Double click on the blue square at the bottom of the page and then write the changed color.
//Go top of the page and sendKeys "Thanks to JavascriptExecutor"
//Go to the bottom of the page and click the book, name"jQuery in Action"

    public WebDriver driver;

    @Before
    public void setup() {
        // Set up the ChromeDriver and navigate to the URL
        driver = new ChromeDriver();
        driver.get("https://api.jquery.com/dblclick/");
    }

    @Test
    public void junitAssignment1() {
        // Double-click on the blue square at the bottom of the page and print the changed color
        By frameLocator = By.tagName("iframe");
        WebElement iframe = driver.findElement(frameLocator);
        driver.switchTo().frame(iframe);

        By blueSquareButtonLocator = By.tagName("div");
        System.out.println("The old color is " + driver.findElement(blueSquareButtonLocator).getCssValue("background-color"));

        new Actions(driver)
                .doubleClick(driver.findElement(blueSquareButtonLocator))
                .perform();

        System.out.println("The color changed to " + driver.findElement(blueSquareButtonLocator).getCssValue("background-color"));

        driver.switchTo().defaultContent();

        // Go to the top of the page and search for a specific keyword
        By searchInputBoxLocator = By.name("s");
        driver.findElement(searchInputBoxLocator).sendKeys("Thanks to JavascriptExecutor" + Keys.RETURN);

        // Go to the bottom of the page and click on a book
        By bookLocator = By.xpath("//img[contains(@alt, 'jQuery in Action')]");
        driver.findElement(bookLocator).click();

        // Assert that the current URL is the expected book URL
        Assertions.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}