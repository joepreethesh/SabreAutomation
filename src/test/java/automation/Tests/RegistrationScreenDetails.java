package automation.Tests;

import automation.BaseSetup;
import automation.Screens.RegistrationScreen;
import org.testng.annotations.Test;

public class RegistrationScreenDetails extends BaseSetup {

    @Test

    public void test() {

        RegistrationScreen.tapOnRegisterButton();
        RegistrationScreen.RegistrationScreenIsDisplayed();
        RegistrationScreen.getTheStatusOfContinueButton();
        //RegistrationScreen.dismissTheKeyboard();
        //RegistrationScreen.enterDataInRegistrationFields();

    }
}
