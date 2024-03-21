package TestNGAssignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.testng.Tests;

import java.time.Duration;

public class Assignment5  extends Tests {
    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.

    @Test
    public void TestNGAssignment5(){
        //Go to URL: http://crossbrowsertesting.github.io/
        bot.navigate("http://crossbrowsertesting.github.io/");

        //Click to To-Do App
        By ToDoLink = By.xpath("//a[@href='todo-app.html']");
        bot.click(ToDoLink);

        //Checking Box to do-4 and Checking Box to do-5
        By fourCheckbox = By.xpath("//input[@name='todo-4']");
        bot.click(fourCheckbox);

        By fiveCheckbox = By.xpath("//input[@name='todo-5']");
        bot.click(fiveCheckbox);

        //If both clicks worked, then the following List should be have length 2.
        By SelectedCheckbox = By.xpath("//span[@class='done-true']");
        int count = driver.findElements(SelectedCheckbox).size();

        SoftAssert softAssert=new SoftAssert();
        //Assert that this is correct
        softAssert.assertEquals(count,2);

        By textField = By.id("todotext");
        bot.type(textField,"test");
        By ButtonADD = By.id("addbutton");
        bot.click(ButtonADD);
        By test = By.xpath("//span[@class='done-false' and text()='test']");
        //Assert that the to do we added is present in the list
        softAssert.assertTrue(driver.findElement(test).isDisplayed());

        //Archiving old todos
        By Archive = By.xpath("//a[text()='archive']");
        bot.click(Archive);

        //If our archive link worked, then the following list should have length 4.
        By UnSelectedCheckbox = By.xpath("//span[@class='done-false']");
        int count1 = driver.findElements(UnSelectedCheckbox).size();
        //Assert that this is true as well
        softAssert.assertEquals(count1,4);
        softAssert.assertAll();

        //Doing Cross Browser Testing.
        /* - **Check Assignment5.xml file** - */

    }
}