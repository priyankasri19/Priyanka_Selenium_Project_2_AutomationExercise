package testCases;

import java.io.IOException;
import org.json.simple.parser.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import setup.TestSetup;


public class TestCase5 extends TestSetup 
{
	@Test
    public void registerUserWithExistingEmail() throws IOException, ParseException {
        TestCase1.isHomePageVisible();
        TestCase1.isNewUserSignUpVisible();
        checkErrorMsgIsEmailAddressAlreadyExist();
    }

    private void checkErrorMsgIsEmailAddressAlreadyExist() throws IOException, ParseException {
    	System.out.println("Step : Check ErrorMsg Is Email Address Already Exist");
        String emailAddressAlreadyExistText = new LoginSignupPage(getDriver()).fillIncorrectSignup()
                .getEmailAddressAlreadyExist()
                .getText();
        Assert.assertEquals(emailAddressAlreadyExistText, "Email Address already exist!", "Verify error 'Email Address already exist!' is visible");
    }

}
