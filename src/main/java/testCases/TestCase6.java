package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;
import setup.TestSetup;


public class TestCase6 extends TestSetup{
	
	@Test
	public void contactUsForm() {
        TestCase1.isHomePageVisible();
        isGetInTouchVisible();
        checkSuccessMsgYourDetailsSubmittedSuccessfully();
        clickHomeButtonAndCheckIsLandedToHomePage();
    }

    private void isGetInTouchVisible() {
    	System.out.println("Step : Is 'GET IN TOUCH' visible");
        String getGetInTouchText = new HomePage(getDriver())
                .contactUsButtonClick()
                .getGetInTouch()
                .getText();
        Assert.assertEquals(getGetInTouchText, "GET IN TOUCH", "Verify 'GET IN TOUCH' is visible");
    }

    private void checkSuccessMsgYourDetailsSubmittedSuccessfully() {
    	System.out.println("Check Success Msg Your Details Submitted Successfully");
        String alertSuccessText = new ContactUsPage(getDriver())
                .fillForm()
                .submitButtonClick()
                .okButtonClick()
                .getAlertSuccess()
                .getText();
        Assert.assertEquals(alertSuccessText, "Success! Your details have been submitted successfully.", "Verify success message 'Success! Your details have been submitted successfully.' is visible");
    }

    private void clickHomeButtonAndCheckIsLandedToHomePage() {
    	System.out.println("Click Home Button And Check Is Landed To Home Page");
        boolean homePageVisible = new ContactUsPage(getDriver())
                .homePageButtonClick()
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(homePageVisible, "Click 'Home' button and verify that landed to home page successfully");
    }

}
