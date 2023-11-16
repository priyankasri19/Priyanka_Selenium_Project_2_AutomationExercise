package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PaymentPage;
import pages.DownloadVerification;
import setup.AutomationExerciseConstants;
import setup.TestSetup;

public class TestCase24 extends TestSetup1{

	String name = AutomationExerciseConstants.name;
    String email = AutomationExerciseConstants.email;
    
    @Test
	public void downloadInvoiceAfterPurchaseOrder() throws IOException, ParseException {
        TestCase1.isHomePageVisible();
        TestCase14.isCartPageDisplayed();
        TestCase14.checkIsAccountCreatedAndClickContinueButton(name, email);
        TestCase14.checkLoggedInAsUsernameAtTop(name);
        TestCase14.checkAddressDetailsAndReviewYourOrder();
        TestCase14.checkSuccessMessageCongratulationsYourOrderHasBeenConfirmed();
        invoiceDownloadAndVerification();
        new PaymentPage(getDriver()).continueButtonClick();
        TestCase1.isAccountDeletedIsVisibleAndClickContinueButton();
    }

    private void invoiceDownloadAndVerification() throws IOException {
    	System.out.println("Step : Invoice Download And Verification");
        new PaymentPage(getDriver()).downloadInvoiceButtonClick();
        boolean isFileDownloaded = DownloadVerification.isFileDownloaded("invoice", "txt", 5000);
        Assert.assertTrue(isFileDownloaded, "Verify invoice is downloaded successfully.");
    }
}
