package automation;

import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.Random;

public class BaseSetup {

    public static IOSDriver driver;
    public static WebDriverWait driverWait;

    @BeforeClass
    public static void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities().iphone();
        capabilities.setCapability("appium-version", "1.8.0");
        capabilities.setCapability("platform-version", "iOS");
        capabilities.setCapability("platformName", "11.3");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("deviceName", "iPad");
        capabilities.setCapability("app", "/Users/jnoronha/Desktop/Fieldable/Build_94/CS/Fieldable.app");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("udid", "1e904c73e9b2fc5ab5be2d4980b83e2c60baf321");
        capabilities.setCapability("waitForScript", false);
        capabilities.setCapability("NewCommandTimeout", "500");
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driverWait = new WebDriverWait(driver, 5000);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    public static void sleep(long millisecond) {

        try{
            Thread.sleep(millisecond);
        }catch (InterruptedException e) {

        }
    }

    public static boolean keyboardIsDisplayed() {

        boolean status = driver.findElement(By.className("XCUIElementTypeKeyboard")).isDisplayed();
        return status;

    }

    public static String  generateRandomString(int length) {

        String stringSet = "abcdefghijklmnopqurestuvwxyz";
        Random randomString = new Random();
        StringBuilder randomsStringBuilder = new StringBuilder(length);
        for (int characterNumber=0; characterNumber<length; characterNumber++)
            randomsStringBuilder.append(stringSet.charAt(randomString.nextInt(stringSet.length())));
     return randomsStringBuilder.toString();

    }

    public static boolean isElementDisplayed(String elementName) {

        boolean status = driver.findElement(By.name(elementName)).isDisplayed();
        System.out.println("button status" + status);
        return status;

    }
}

