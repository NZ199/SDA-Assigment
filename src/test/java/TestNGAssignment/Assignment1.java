package TestNGAssignment;
import org.testng.annotations.Test;
import tests.testng.Tests;

public class Assignment1 extends Tests {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */

    @Test
    public void ToFacebook()
    {
        //First go to Facebook.
        driver.get("https://www.facebook.com");
    }

    @Test(dependsOnMethods = "ToFacebook")
    public void ToGoogle()
    {
        //Go to Google depending on Facebook
        driver.get("https://www.google.com");
    }

    @Test(dependsOnMethods = "ToGoogle")
    public void ToAmazon()
    {
        //Go to Amazon depending on Google
        driver.get("https://www.amazon.com");
    }

}
