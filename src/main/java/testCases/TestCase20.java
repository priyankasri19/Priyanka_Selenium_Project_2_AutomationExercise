package testCases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.testng.Assert;

import pages.CartPage;
import pages.HomePage;
import pages.JSONReader;
import pages.ProductsPage;

public class TestCase20 extends TestSetup {

	   public void searchProductsAndVerifyCartAfterLogin() throws IOException, ParseException, InterruptedException {
	        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        TestCase9.verifySearchedProductsIsVisible();
	        List<String> productsNames = TestCase9.verifyAllTheProductsRelatedToSearchAreVisible();
	        new ProductsPage(getDriver()).addAllProducts();
	        clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
	        new HomePage(getDriver())
	                .signupLoginClick()
	                .fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
	        verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell(productsNames);
	        verifyThatCartIsEmpty();
	    }

	    @Step("Click 'Cart' button and verify that products are visible in cart")
	    private void clickCartButtonAndVerifyThatProductsAreVisibleInCart( List<String> productsNames) {
	        List<String> productsNamesAdded = new HomePage(getDriver())
	                .cartButtonClick()
	                .getProductsNames();
	        for (int i = 0; i < productsNames.size(); i++) {
	            Assert.assertEquals(productsNames.get(i), productsNamesAdded.get(i), "Verify that products are visible in cart");
	            System.out.println("Search: " + productsNames.get(i) + " = Added: " + productsNamesAdded.get(i));
	        }
	    }

	    @Step("Verify that those products are visible in cart after login as well")
	    private void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell( List<String> productsNames) {
	        clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
	    }

	    @Step("Verify 'Cart is empty! Click here to buy products.' is visible")
	    private void verifyThatCartIsEmpty() throws InterruptedException {
	        String emptyCartText = new CartPage(getDriver())
	                .deleteAllAddedProducts()
	                .getEmptyCartSpan()
	                .getText();
	        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify 'Cart is empty! Click here to buy products.' is visible");
	    }
}
