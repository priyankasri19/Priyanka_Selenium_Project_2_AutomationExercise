package testCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoggedHomePage;
import setup.TestDataReader;
import setup.TestSetup;

public class TestCase16 extends TestSetup {
	
	@Test
	public void placeOrderLoginBeforeCheckout() throws IOException, ParseException {
		
		TestCase1.isHomePageVisible();
		JSONObject validUserDetails = TestDataReader.validUserDetails();
		String email=(String) validUserDetails.get("email");
		String password=(String) validUserDetails.get("password");
		
		new HomePage(getDriver())
            	.signupLoginClick()
            	.fillCorrectLogin(email, password);
		
		checkLoggedInAsUsernameAtTop();
    
    TestCase14.isCartPageDisplayed();
    new CartPage(getDriver()).proceedToCheckoutButtonClick();
    TestCase14.checkAddressDetailsAndReviewYourOrder();
    TestCase14.checkSuccessMessageCongratulationsYourOrderHasBeenConfirmed();
}

	private void checkLoggedInAsUsernameAtTop() throws IOException, ParseException {
		System.out.println("Step : Check Logged In As Username At Top");
		String username = 
					new LoggedHomePage(getDriver())
							.getUsername()
							.getText();
		
		JSONObject validUserDetails = TestDataReader.validUserDetails();
		String name=(String) validUserDetails.get("name");
		Assert.assertEquals(username, name, "Verify 'Logged in as username' at top");
	}
}
