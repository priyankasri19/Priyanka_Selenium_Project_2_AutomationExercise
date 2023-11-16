package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoggedHomePage;
import setup.TestSetup;

public class TestCase4 extends TestSetup {
	
	@Test
	public void logoutUser() throws IOException, ParseException {
		TestCase2.loginUserWithCorrectEmailAndPassword();
	    isUserNavigatedToLoginPage();
	}


	private void isUserNavigatedToLoginPage() {
		System.out.println("Step : Is User navigated to login page");
	    String loginToYourAccountText = 
	    				new LoggedHomePage(getDriver())
	    					.logoutButtonClick()
	    					.getLoginToYourAccount()
	    					.getText();
	    Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");
	}
}
