package testCases;

import java.io.IOException;
import org.json.simple.parser.ParseException;

import org.testng.annotations.Test;

import setup.AutomationExerciseConstants;
import setup.TestSetup;

public class TestCase23 extends TestSetup{

	String name = AutomationExerciseConstants.name;
    String email = AutomationExerciseConstants.email;
    
    @Test
    public void verifyAddressDetailsInCheckoutPage() throws IOException, ParseException {
        TestCase1.isHomePageVisible();
        TestCase14.checkIsAccountCreatedAndClickContinueButton(name, email);
        TestCase14.checkLoggedInAsUsernameAtTop(name);
        TestCase14.isCartPageDisplayed();
        matchAddress();
        TestCase1.isAccountDeletedIsVisibleAndClickContinueButton();
    }

    private void matchAddress() throws IOException, ParseException {
    	System.out.println("Step : Match Address");
        TestCase14.verifyAddressDetails();
    }
}
