package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import setup.TestSetup;

public class TestCase11 extends TestSetup {
	
    @Test
	 public void verifySubscriptionOnCartPage() throws IOException, ParseException {
    	TestCase1.isHomePageVisible();
		checkTextSubscription();
		checkSuccessMsgYouHaveBeenSuccessfullySubscribed();
	 }

	private void checkTextSubscription() {
		System.out.println("Step : Check Text Subscription");
		String subscription=
					new HomePage(getDriver())
						.cartButtonClick()
						.getSubscription()
						.getText();
		Assert.assertEquals(subscription, "SUBSCRIPTION", "Verify text 'SUBSCRIPTION' is visible");
		
	}
	private void checkSuccessMsgYouHaveBeenSuccessfullySubscribed() throws IOException, ParseException {
		System.out.println("Step : Check Success Msg You Have Been Successfully Subscribed");
		String alertSuccessText=
					new HomePage(getDriver())
						.cartButtonClick()
						.fillSubscribe()
						.getAlertSuccessSubscribe()
						.getText();
		Assert.assertEquals(alertSuccessText, "You have been successfully subscribed!", "Verify alert message 'You have been successfully subscribed!' is visible");
	}

	

}
