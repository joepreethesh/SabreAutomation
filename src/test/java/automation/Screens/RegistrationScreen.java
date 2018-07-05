package automation.Screens;

import automation.BaseSetup;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static automation.BaseSetup.driver;
import static automation.BaseSetup.sleep;

public class RegistrationScreen  extends BaseSetup{

    public static void tapOnRegisterButton() {

        WebElement registerButton = driver.findElement(By.xpath("//*[@name='REGISTER']"));
        registerButton.click();
    }

    public static void RegistrationScreenIsDisplayed(){

        String screenTitle = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Contact Information\"]")).getText();
        System.out.println(screenTitle);
        Assert.assertEquals(screenTitle, "Contact Information");
    }

    public static ArrayList<String> getTheTextFields() {
        ArrayList<String> registrationFields = new ArrayList<>();
        WebElement elements = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Fieldable\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther"));
        List<WebElement> mainClassList = elements.findElements(By.className("XCUIElementTypeTextField"));
        for(int i=0; i<mainClassList.size(); i++) {
            WebElement textFieldsXpath = mainClassList.get(i);
            String textFieldName = textFieldsXpath.getText();
            registrationFields.add(textFieldName);
        }
        return  registrationFields;
    }

    public static void dismissTheKeyboard(){

        boolean status = BaseSetup.keyboardIsDisplayed();
        if(status)
        driver.findElement(By.name("Hide keyboard")).click();
    }

    public static void enterDataInRegistrationFields() {

        ArrayList<String> registrationFields = getTheTextFields();
        for(int i=0; i<registrationFields.size(); i++) {
            String text = BaseSetup.generateRandomString(5);
            String field = registrationFields.get(i);
            driver.findElement(By.name(field)).click();
            driver.findElement(By.name(field)).sendKeys(text);
        }
    }

    public static void getTheStatusOfContinueButton() {
        String buttonStatus;
        boolean status = BaseSetup.isElementDisplayed("CONTINUE");
        if (status) {
            buttonStatus = driver.findElement(By.name("CONTINUE")).getAttribute("enabled");
            System.out.println(buttonStatus);
        } else {
            dismissTheKeyboard();
        getTheStatusOfContinueButton();
        }
    }

    public static void tapOnContinueButton() {

       driver.findElement(By.name("CONTINUE")).click();

    }
}
