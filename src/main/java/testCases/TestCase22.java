package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import setup.TestSetup;

public class TestCase22 extends TestSetup{

	 @Test
	 public void AddToCartFromRecommendedItems() {
		 checkRecommendedItemsAreVisible();
	     checkThatProductIsDisplayedInCartPage();
	    }

	 private void checkRecommendedItemsAreVisible() {
		 System.out.println("Step : Check Recommended Items Are Visible");
	        String recommendedItemsText = new HomePage(getDriver())
	                .getRecommendedItems()
	                .getText();
	        Assert.assertEquals(recommendedItemsText, "RECOMMENDED ITEMS", "Verify 'RECOMMENDED ITEMS' are visible");
	    }

	 private void checkThatProductIsDisplayedInCartPage() {
		 System.out.println("Step : Check That Product Is Displayed In CartPage");
	     List<String> productsNames = 
	    		 	new HomePage(getDriver())
	    		 			.blueTopAddToCartButtonClick()
	    		 			.viewCartButtonClick()
	    		 			.getProductsNames();
	     Assert.assertEquals(productsNames.get(0), "Blue Top", "Verify that product is displayed in cart page");
	 }

}
