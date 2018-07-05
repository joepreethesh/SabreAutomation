package automation.Tests;

import automation.BaseSetup;
import automation.Screens.CreateAccount;
import automation.Screens.RegistrationScreen;
import org.testng.annotations.Test;

public class CreateAccountScreenDetails  extends BaseSetup{

   @Test

   public void test() {

       RegistrationScreen.tapOnRegisterButton();
       RegistrationScreen.enterDataInRegistrationFields();
       RegistrationScreen.dismissTheKeyboard();
       RegistrationScreen.tapOnContinueButton();
       CreateAccount.CreateAccountScreenDisplayed();
   }


}
