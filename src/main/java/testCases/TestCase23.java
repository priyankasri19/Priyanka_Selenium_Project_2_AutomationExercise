package testCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import setup.TestDataReader;
import setup.TestSetup;

public class TestCase23 extends TestSetup{

    
    @Test
    public void verifyAddressDetailsInCheckoutPage() throws IOException, ParseException {
        TestCase1.isHomePageVisible();
        
		JSONObject commonTestDetails = TestDataReader.commonTestData();
		String name=(String) commonTestDetails.get("name");
		String email=(String) commonTestDetails.get("email");
		
        TestCase14.checkIsAccountCreatedAndClickContinueButton(name, email);
        TestCase14.checkLoggedInAsUsernameAtTop(name);
        TestCase14.isCartPageDisplayed();
        matchAddress();
        TestCase1.isAccountDeletedIsVisibleAndClickContinueButton();
    }

    private void matchAddress() throws IOException, ParseException {
    	System.out.println("Step : Match Address");
        TestCase14.verifyAddressDetails();
    }
}
