package TestNGAssignment;

import org.junit.Assert;
import org.junit.Test;
import pages.ecommercePlayground.Register;
import tests.testng.Tests;

public class Assignment6  extends Tests {

    @Test
    public void validRegister(){
        new Register(driver , bot)
                .toGo()
                .register("NOUF","ALSUBHI","NOUF@gmail.com","966559887655","123456","123456");
    }
}