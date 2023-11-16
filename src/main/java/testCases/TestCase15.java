package testCases;

import java.io.IOException;
import org.json.simple.parser.ParseException;

import org.testng.annotations.Test;

import pages.CartPage;
import setup.AutomationExerciseConstants;
import setup.TestSetup;

public class TestCase15 extends TestSetup{

	String name = AutomationExerciseConstants.name;
    String email = AutomationExerciseConstants.email;
	
    @Test
	public void placeOrderRegisterBeforeCheckout() throws IOException, ParseException {
	        TestCase1.isHomePageVisible();
	        TestCase14.checkIsAccountCreatedAndClickContinueButton(name, email);
	        TestCase14.checkLoggedInAsUsernameAtTop(name);
	        TestCase14.isCartPageDisplayed();
	        new CartPage(getDriver()).proceedToCheckoutButtonClick();
	        TestCase14.checkAddressDetailsAndReviewYourOrder();
	        TestCase14.checkSuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        TestCase1.isAccountDeletedIsVisibleAndClickContinueButton();
	    }
}
