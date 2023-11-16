package testCases;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailPage;
import setup.TestSetup;

public class TestCase13 extends TestSetup{
	
	@Test
	public void verifyProductQuantityInCart() {
		TestCase1.isHomePageVisible();
		checkIfProductDetailOpened();
		checkThatProductIsDisplayedInCartPageWithExactQuantity();
	}

	private void checkIfProductDetailOpened() {
		System.out.println("Step : Check If Product Detail Opened");
		new HomePage(getDriver()).viewProduct1ButtonClick();
	    Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - Product Details", "Verify product detail is opened");
	}

	private void checkThatProductIsDisplayedInCartPageWithExactQuantity() {
		System.out.println("Step : Check That Product Is Displayed In CartPage With Exact Quantity");
		List<String> quantity = 
					new ProductDetailPage(getDriver())
							.increaseQuantity("4")
							.addToCartButtonClick()
							.viewCartButtonClick()
							.getQuantity();
	    Assert.assertEquals(quantity.get(0), "4", "Verify that product is displayed in cart page with exact quantity");
	 }
}
