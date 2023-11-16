package testCases;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import setup.TestDataReader;
import setup.TestSetup;

public class TestCase20 extends TestSetup {
	
	@Test
	public void searchProductsAndVerifyCartAfterLogin() throws IOException, InterruptedException, ParseException {
		TestCase8.checkIsUserNavigatedToAllProductsPage();
	    TestCase9.isSearchedProductsVisible();
	    List<String> productsNames = TestCase9.checkIsAllTheProductsRelatedToSearchAreVisible();
	    new ProductsPage(getDriver()).addAllProducts();
	    clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
	    
    	JSONObject validUserDetails = TestDataReader.validUserDetails();
		String email=(String) validUserDetails.get("email");
		String password=(String) validUserDetails.get("password");
		
	    new HomePage(getDriver())
	                .signupLoginClick()
	                .fillCorrectLogin(email, password);
	    verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell(productsNames);
	    verifyThatCartIsEmpty();
	}

	private void clickCartButtonAndVerifyThatProductsAreVisibleInCart( List<String> productsNames) {
		System.out.println("Step : Click Cart Button And Verify That Products Are Visible In Cart");
	    List<String> productsNamesAdded = 
	    			new HomePage(getDriver())
	                		.cartButtonClick()
	                		.getProductsNames();
	    for (int i = 0; i < productsNames.size(); i++) {
	    	Assert.assertEquals(productsNames.get(i), productsNamesAdded.get(i), "Verify that products are visible in cart");
	        System.out.println("Search: " + productsNames.get(i) + " = Added: " + productsNamesAdded.get(i));
	    }
	    
	}

	private void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell( List<String> productsNames) {
	    System.out.println("Verify That Those Products Are Visible In Cart After Login As Well");
	    clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
	}

	private void verifyThatCartIsEmpty() throws InterruptedException {
		System.out.println("Step : Verify That Cart Is Empty");
	    String emptyCartText = 
	    			new CartPage(getDriver())
	                		.deleteAllAddedProducts()
	                		.getEmptyCartSpan()
	                		.getText();
	    Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify 'Cart is empty! Click here to buy products.' is visible");
	}
}
