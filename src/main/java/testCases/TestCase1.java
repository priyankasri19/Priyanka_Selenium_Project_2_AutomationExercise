package testCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountCreatedPage;
import pages.EnterAccountInformationPage;
import pages.HomePage;
import pages.LoggedHomePage;
import pages.LoginSignupPage;
import setup.TestDataReader;
import setup.TestSetup;

public class TestCase1 extends TestSetup {
	
	@Test
	 public void registerUser() throws IOException, ParseException {
		 isHomePageVisible();
		 isNewUserSignUpVisible();
		 isEnterAccountInformationVisible();
		 isAccountCreatedVisible(); 
		 isLoggedInAsUsernameVisible();
		 isAccountDeletedIsVisibleAndClickContinueButton();
	 }

	public static void isHomePageVisible() {
		System.out.println("Step : Is Home Page Visible");
		String homePageTitle=new HomePage(getDriver()).homePageTitle();
		Assert.assertEquals(homePageTitle, "Automation Exercise");					
		
	}
	
	public static void isNewUserSignUpVisible() {
		System.out.println("Step : Is NewUser SignUp Visible");
		String newUserSignupText=
					new HomePage(getDriver())
							.signupLoginClick()
							.getNewUserSignup()
							.getText();
		Assert.assertEquals(newUserSignupText, "New User Signup!", "Verify 'New User Signup!' is visible");
	}
	
	private void isEnterAccountInformationVisible() throws IOException, ParseException {
		System.out.println("Step : Is Enter Account Information Visible");
		
		JSONObject commonTestDetails = TestDataReader.commonTestData();
		String name=(String) commonTestDetails.get("name");
		String email=(String) commonTestDetails.get("email");
		
		String enterAccountInformationText = 
					new LoginSignupPage(getDriver())
							.fillCorrectSignup(name, email)
							.getEnterAccountInformation()
							.getText();
        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "Verify that 'ENTER ACCOUNT INFORMATION' is visible");

	}
	
	private void isAccountCreatedVisible() throws IOException, ParseException {
		System.out.println("Step : Is Account Created Visible");
        String accountCreatedText = 
        			new EnterAccountInformationPage(getDriver())
        					.fillAccountDetails()
        					.getAccountCreated()
        					.getText();
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify that 'ACCOUNT CREATED!' is visible");
	}
	
	private void isLoggedInAsUsernameVisible() throws IOException, ParseException {
		System.out.println("Step : Is LoggedIn As Username Visible");
		
		JSONObject commonTestDetails = TestDataReader.commonTestData();
		String name=(String) commonTestDetails.get("name");
		String username = 
					new AccountCreatedPage(getDriver())
							.continueButtonClick()
							.getUsername()
							.getText();
        Assert.assertEquals(username, name, "Verify that 'Logged in as username' is visible");
		
	}
	
	public static void isAccountDeletedIsVisibleAndClickContinueButton() {
		System.out.println("Step : Is Account Deleted Visible");
		String accountDeletedText = 
					new LoggedHomePage(getDriver())
							.deleteAccountButtonClick()
							.getAccountDeleted()
							.getText();
        Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible");
        new pages.AccountCreatedPage(getDriver()).continueButtonClick();
	}
	
}
