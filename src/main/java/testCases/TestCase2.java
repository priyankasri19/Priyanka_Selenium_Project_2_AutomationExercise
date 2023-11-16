package testCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginSignupPage;
import setup.TestDataReader;
import setup.TestSetup;

public class TestCase2 extends TestSetup {
	
	@Test
	public static void loginUserWithCorrectEmailAndPassword() throws IOException, ParseException {
		TestCase1.isHomePageVisible();
	    isLoginToYourAccountIsVisible();
	    isLoggedInAsUsernameIsVisible();
	}

	public static void isLoginToYourAccountIsVisible() {
		System.out.println("Step : Verify 'Login to your account' is visible");
	    String loginToYourAccountText = new HomePage(getDriver())
	                .signupLoginClick()
	                .getLoginToYourAccount()
	                .getText();
	    Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify 'Login to your account' is visible");
	}

	
	private static void isLoggedInAsUsernameIsVisible() throws IOException, ParseException {
		System.out.println("Step : isLoggedInAsUsernameIsVisible");
		JSONObject validUserDetails = TestDataReader.validUserDetails();
		String name=(String) validUserDetails.get("name");
		String email=(String) validUserDetails.get("email");
		String password=(String) validUserDetails.get("password");
		
	    String username = new LoginSignupPage(getDriver())
	                .fillCorrectLogin(email, password)
	                .getUsername()
	                .getText();
	     Assert.assertEquals(username, name, "Verify that 'Logged in as username' is visible");
	}
	
}

