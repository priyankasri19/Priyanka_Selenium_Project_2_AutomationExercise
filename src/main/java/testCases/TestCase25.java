package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import setup.TestSetup;

public class TestCase25 extends TestSetup {

	 @Test
	 public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality() throws InterruptedException {
		 TestCase1.isHomePageVisible();
	     isSubscriptionVisible();
	     pageScrollVerification();
	 }

	 public static void isSubscriptionVisible() {
		 System.out.println("Step : Is Subscription Visible");
	     JavascriptExecutor js = (JavascriptExecutor) getDriver();
	     js.executeScript("arguments[0].scrollIntoView();", new HomePage(getDriver()).getSubscription());
	     boolean subscriptionIsDisplayed = new HomePage(getDriver()).getSubscription().isDisplayed();
	     Assert.assertTrue(subscriptionIsDisplayed, "Verify 'SUBSCRIPTION' is visible");
	 }

	 private void pageScrollVerification() throws InterruptedException {
		 System.out.println("Step : Page Scroll Verification");
	     Thread.sleep(1000);
	     JavascriptExecutor js = (JavascriptExecutor) getDriver();
	     boolean fullFledgedTextIsDisplayed = 
	    		 	new HomePage(getDriver())
	    		 			.scrollUpButtonClick()
	    		 			.getFullFledgedPracticeWebsiteForAutomationEngineers()
	    		 			.isDisplayed();
	     Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
	     long value = (long) js.executeScript("return window.pageYOffset;");
	     Assert.assertTrue(value < 2500, "Verify that page is scrolled up");
	     System.out.println(value);
	  }
}
