package automation.Screens;

import automation.BaseSetup;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CreateAccount extends BaseSetup {

    public static void CreateAccountScreenDisplayed() {

        String screenTitle = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Create Account\"]")).getText();
        System.out.println(screenTitle);
        Assert.assertEquals(screenTitle, "Create Account");

    }

    //public static void


}
