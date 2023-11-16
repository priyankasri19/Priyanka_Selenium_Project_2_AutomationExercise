package testCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import setup.TestDataReader;
import setup.TestSetup;

public class TestCase3 extends TestSetup {
	
	@Test
    public void loginUserWithIncorrectEmailAndPassword() throws IOException, ParseException {
        TestCase1.isHomePageVisible();
        TestCase2.isLoginToYourAccountIsVisible();
        checkIfErrorMsgVisible();
    }

    private void checkIfErrorMsgVisible()  throws IOException, ParseException {
    	System.out.println("Step : Check If ErrorMsg Visible - 'Your email or password is incorrect!'");
    	JSONObject invalidUserDetails = TestDataReader.invalidUserDetails();
		String email=(String) invalidUserDetails.get("email");
		String password=(String) invalidUserDetails.get("password");
    	
        String errorLoginText = 
        			new LoginSignupPage(getDriver())
        				.fillIncorrectLogin(email, password)
        				.getErrorLogin()
        				.getText();
        Assert.assertEquals(errorLoginText, "Your email or password is incorrect!", "Verify error 'Your email or password is incorrect!' is visible");
    }
}
