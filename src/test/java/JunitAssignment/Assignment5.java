package JunitAssignment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
public class Assignment5
{
    /*   Go to URL: http://facebook.com
     getCookies,
     addCookie,
     deleteCookieNamed,
     deleteAllCookies
*/
    private WebDriver driver;

    @Before
    public void setUp()
    {
    driver = new ChromeDriver();
    driver.get("http://facebook.com");
    }

     @Test
      public void junitAssignment5()
     {
            // Get all cookies
            Set<Cookie> allCookies = driver.manage().getCookies();
            System.out.println("Existing Cookies:");
            for (Cookie cookie : allCookies) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }

            // Add a new cookie
            Cookie newCookie = new Cookie("myCustomCookie", "myValue");
            driver.manage().addCookie(newCookie);
            System.out.println("\nAdded Cookie: " + newCookie.getName() + ": " + newCookie.getValue());

            // Delete cookie by name
            driver.manage().deleteCookieNamed("myCustomCookie");
            System.out.println("\nDeleted Cookie: myCustomCookie");

            // Delete all cookies
            driver.manage().deleteAllCookies();
            System.out.println("\nDeleted All Cookies");
        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }


