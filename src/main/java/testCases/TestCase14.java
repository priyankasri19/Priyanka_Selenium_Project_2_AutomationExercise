package testCases;


import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountCreatedPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoggedHomePage;
import pages.ProductsPage;
import setup.AutomationExerciseConstants;
import setup.TestDataReader;
import setup.TestSetup;

public class TestCase14 extends TestSetup {
	
    @Test
    public void placeOrderRegisterWhileCheckout() throws IOException, ParseException {
		JSONObject commonTestDetails = TestDataReader.commonTestData();
		String name=(String) commonTestDetails.get("name");
		String email=(String) commonTestDetails.get("email");
    	
    	TestCase1.isHomePageVisible();
    	isCartPageDisplayed();
    	checkIsAccountCreatedAndClickContinueButton(name, email);
    	checkLoggedInAsUsernameAtTop(name);
    	checkAddressDetailsAndReviewYourOrder();
    	checkSuccessMessageCongratulationsYourOrderHasBeenConfirmed();
    	TestCase1.isAccountDeletedIsVisibleAndClickContinueButton();
    }

    public static void isCartPageDisplayed() {
    	System.out.println("Step : Is CartPage Displayed");
        String shoppingCartText = 
        			new ProductsPage(getDriver())
        					.addProductsToCart()
        					.getShoppingCart()
        					.getText();
    	Assert.assertEquals(shoppingCartText, "Shopping Cart", "Verify that cart page is displayed");
    }

    public static void checkIsAccountCreatedAndClickContinueButton(String name, String email) throws IOException, ParseException {
    	System.out.println("Step : Check Is Account Created And Click Continue Button");
    	String accountCreatedText = 
    				new HomePage(getDriver())
    						.signupLoginClick()
    						.fillCorrectSignup(name, email)
    						.fillAccountDetails()
    						.getAccountCreated()
    						.getText();
    	Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify 'ACCOUNT CREATED!'");
    	
    	new AccountCreatedPage(getDriver()).continueButtonClick();
    }

    public static void checkLoggedInAsUsernameAtTop(String name) {
    	System.out.println("Step : Check LoggedIn As Username At Top");
        String username = 
        			new LoggedHomePage(getDriver())
        					.getUsername()
        					.getText();
    	Assert.assertEquals(username, name, "Verify ' Logged in as username' at top");
    }

    public static void checkAddressDetailsAndReviewYourOrder() throws IOException, ParseException {
    	System.out.println("Step : Check Address Details And Review Your Order");
    	verifyAddressDetails();

    	List<String> productNames = new CartPage(getDriver()).getProductsNames();
    	List<String> prices = new CartPage(getDriver()).getPrices();
    	List<String> quantity = new CartPage(getDriver()).getQuantity();
    	List<String> totalPrices = new CartPage(getDriver()).getTotalPrices();
    	String totalAmount = new CheckoutPage(getDriver()).getTotalAmount().getText();

    	for (int i = 0; i < 2; i++) {
    	    Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify Review Your Order");
    	    Assert.assertEquals(quantity.get(i), "1", "Verify Review Your Order");
    	}

    	Assert.assertEquals(productNames.get(0), "Blue Top", "Verify Review Your Order");
    	Assert.assertEquals(productNames.get(1), "Men Tshirt", "Verify Review Your Order");
    	Assert.assertEquals(totalAmount, "Rs. 900", "Verify Review Your Order");
    }

    public static void verifyAddressDetails() throws IOException, ParseException {
    	List<String> addressDelivery = new HomePage(getDriver())
    	        .cartButtonClick()
    	        .proceedToCheckoutLoggedButtonClick()
    	        .getAddressDelivery();
    	List<String> addressInvoice = new CheckoutPage(getDriver()).getAddressInvoice();

    	Assert.assertEquals(addressDelivery.get(0), "YOUR DELIVERY ADDRESS", "Verify Address Details");
    	Assert.assertEquals(addressInvoice.get(0), "YOUR BILLING ADDRESS", "Verify Address Details");

    	for (int i = 1; i < 8; i++) {
    	    Assert.assertEquals(addressDelivery.get(i), addressInvoice.get(i), "Verify Address Details");
    	}

    	JSONObject accountDetails = TestDataReader.accountDetails();
    	
    	String no1 = "Mrs. " + (String) accountDetails.get("firstName") + " " + (String) accountDetails.get("lastName");
    	String no2 = (String) accountDetails.get("company");
    	String no3 = (String) accountDetails.get("address1");
    	String no4 = (String) accountDetails.get("address2");
    	String no5 = (String) accountDetails.get("city") + " " + (String) accountDetails.get("state") + " " + (String) accountDetails.get("zipcode");
    	String no6 = (String) accountDetails.get("country");
    	String no7 = (String) accountDetails.get("mobileNumber");

    	Assert.assertEquals(addressDelivery.get(1), no1, "Verify Address Details");
    	Assert.assertEquals(addressDelivery.get(2), no2, "Verify Address Details");
    	Assert.assertEquals(addressDelivery.get(3), no3, "Verify Address Details");
    	Assert.assertEquals(addressDelivery.get(4), no4, "Verify Address Details");
    	Assert.assertEquals(addressDelivery.get(5), no5, "Verify Address Details");
    	Assert.assertEquals(addressDelivery.get(6), no6, "Verify Address Details");
    	Assert.assertEquals(addressDelivery.get(7), no7, "Verify Address Details");
    }

    public static void checkSuccessMessageCongratulationsYourOrderHasBeenConfirmed() throws IOException, ParseException {
    	System.out.println("Step : Check Success Message Congratulations Your Order Has Been Confirmed");
    	String alertSuccessText = 
    				new CheckoutPage(getDriver())
    						.enterComment("Sed fringilla aliquet turpis, ut vestibulum orci vulputate sit amet.")
    						.fillPaymentDetails()
    						.getSuccessMessage()
    						.getText();
    	Assert.assertEquals(alertSuccessText, "Congratulations! Your order has been confirmed!", "Verify success message 'Congratulations! Your order has been confirmed!'");
    }   
}
