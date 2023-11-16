package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import setup.TestSetup;

public class TestCase17 extends TestSetup{

	@Test
	public void removeProductsFromCart() {
		TestCase1.isHomePageVisible();
	    TestCase14.isCartPageDisplayed();
	    checkIsProductRemovedFromTheCart();
	}

	private void checkIsProductRemovedFromTheCart() {
		System.out.println("Step : Check Is Product Removed From The Cart");
	    String emptyCartText = 
	    			new CartPage(getDriver())
	                	.xButtonClick()
	                	.getEmptyCartSpan()
	                	.getText();
	    Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify that product is removed from the cart");
	}
}
