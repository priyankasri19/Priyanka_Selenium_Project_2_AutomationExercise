package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import setup.TestSetup;

public class TestCase7 extends TestSetup{

	@Test
	public void verifyTestCasesPage() {
		TestCase1.isHomePageVisible();
		checkIsUserNavigatedToTestCasesPage();
	 }

	private void checkIsUserNavigatedToTestCasesPage() {
		System.out.println("Check Is User Navigated To TestCases Page");
	    String testCasesText = 
	    		 		new HomePage(getDriver())
	    		 			.testCasesButtonClick()
	    		 			.getTestCases()
	    		 			.getText();
	    Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");

	    }
}