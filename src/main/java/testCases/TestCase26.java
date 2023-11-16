package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import setup.TestSetup;

public class TestCase26 extends TestSetup {
	 
	 @Test
	 public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionality() throws InterruptedException {
		TestCase1.isHomePageVisible();
	    TestCase25.isSubscriptionVisible();
	    pageScrollVerification();
	 }

	 private void pageScrollVerification() throws InterruptedException {
		 System.out.println("Step : Page Scroll Verification");
	     Thread.sleep(1000);
	     JavascriptExecutor js = (JavascriptExecutor) getDriver();
	     js.executeScript("arguments[0].scrollIntoView();", new HomePage(getDriver()).getFullFledgedPracticeWebsiteForAutomationEngineers());
	     boolean fullFledgedTextIsDisplayed = new HomePage(getDriver()).getFullFledgedPracticeWebsiteForAutomationEngineers().isDisplayed();
	     Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
	     long value = (long) js.executeScript("return window.pageYOffset;");
	     Assert.assertTrue(value < 400, "Verify that page is scrolled up");
	 }
}
