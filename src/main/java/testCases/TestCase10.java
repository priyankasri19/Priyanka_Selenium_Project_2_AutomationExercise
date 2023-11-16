package testCases;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import setup.TestSetup;

public class TestCase10 extends TestSetup{
	
	@Test
	public void verifySubscriptionOnHomePage() throws IOException, ParseException {
        TestCase1.isHomePageVisible();
        checkTextSubscription();
        checkSuccessMsgYouHaveBeenSuccessfullySubscribed();
    }

    public static void checkTextSubscription() {
    	System.out.println("Step : Check text 'SUBSCRIPTION");
        String subscriptionText = new HomePage(getDriver())
                .getSubscription()
                .getText();
        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");
    }

    public static void checkSuccessMsgYouHaveBeenSuccessfullySubscribed() throws IOException, ParseException {
    	System.out.println("Step : Check Success Msg You Have Been Successfully Subscribed");
        String messageAlert = new HomePage(getDriver())
                .fillSubscribe()
                .getAlertSuccessSubscribe()
                .getText();
        Assert.assertEquals(messageAlert, "You have been successfully subscribed!", "Verify success message 'You have been successfully subscribed!' is visible");
    }

}
