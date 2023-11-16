package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import setup.TestSetup;

public class TestCase12 extends TestSetup{
	
	 @Test
	 public void addProductsInCart() {
		TestCase1.isHomePageVisible();
	    checkBothProductsAreAddedToCart();
	    checkTheirPricesQuantityAndTotalPrice();
	 }
	
	 private void checkBothProductsAreAddedToCart() {
		System.out.println("Step : Check Both Products Are Added To Cart");
		List<String> productNames = 
					new HomePage(getDriver())
	                	.productsButtonClick()
	                	.addProductsToCart()
	                	.getProductsNames();
	    Assert.assertEquals(productNames.size(), 2, "Verify both products are added to Cart");
	 }

	 private void checkTheirPricesQuantityAndTotalPrice() {
	     System.out.println("Step : Check Their Prices Quantity And Total Price"); 	
	     List<String> prices = new CartPage(getDriver()).getPrices();
	     List<String> quantity = new CartPage(getDriver()).getQuantity();
	     List<String> totalPrices = new CartPage(getDriver()).getTotalPrices();

	     for (int i = 0; i < 2; i++) {
	         Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify their prices and total price");
	         Assert.assertEquals(quantity.get(i), "1", "Verify their quantity");
	         System.out.println(i + ". Prices = Total Prices | " + prices.get(i) + " = " + totalPrices.get(i));
	         System.out.println(i + ". Quantity = 1 | " + quantity.get(i).equals("1"));
	     }
	 }
}
