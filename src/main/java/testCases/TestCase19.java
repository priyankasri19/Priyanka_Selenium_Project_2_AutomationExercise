package testCases;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;
import setup.TestDataReader;
import setup.TestSetup;

public class TestCase19 extends TestSetup{

	 @Test
	 public void viewCartBrandProducts() throws IOException, ParseException {
		 checkThatBrandsAreVisibleOnLeftSideBar();
	     checkThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed();
	     checkThatUserIsNavigatedToThatBrandPageAndCanSeeProducts();
	 }

	 private void checkThatBrandsAreVisibleOnLeftSideBar() {
	     System.out.println("Step : Check That Brands Are Visible On Left SideBar");
	     boolean brandsIsDisplayed = 
	    		 	new HomePage(getDriver())
	    		 			.productsButtonClick()
	    		 			.getBrands()
	    		 			.isDisplayed();
	     Assert.assertTrue(brandsIsDisplayed, "Verify that Brands are visible on left side bar");
	 }

	 private void checkThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed() throws IOException, ParseException {
		 System.out.println("Step : Check That User Is Navigated To Brand Page And Brand Products Are Displayed");
	     String titleTextCenter = 
	    		 	new ProductsPage(getDriver())
	    		 			.poloBrandClick()
	    		 			.getTitleTextCenter()
	    		 			.getText();
	     Assert.assertEquals(titleTextCenter, "BRAND - POLO PRODUCTS", "Verify that user is navigated to brand page");

	     List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();
	     			
	     for (int i = 0; i < productsNames.size(); i++) {
	          Assert.assertEquals(productsNames.get(i), TestDataReader.poloBrandProducts(String.valueOf(i)), "Verify that brand products are displayed");
	     }
	 }

	 private void checkThatUserIsNavigatedToThatBrandPageAndCanSeeProducts() throws IOException, ParseException {
		 System.out.println("Step : Check That User Is Navigated To That Brand Page And Can See Products");
	     String titleTextCenter = 
	    		 	new ProductsPage(getDriver())
	    		 			.madameBrandClick()
	    		 			.getTitleTextCenter()
	    		 			.getText();
	     Assert.assertEquals(titleTextCenter, "BRAND - MADAME PRODUCTS", "Verify that user is navigated to that brand page");

	     List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();
	     for (int i = 0; i < productsNames.size(); i++) {
	         Assert.assertEquals(productsNames.get(i), TestDataReader.madameBrandProducts(String.valueOf(i)), "Verify that can see products");
	     }
	 }
}
