package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import setup.TestSetup;

public class TestCase8 extends TestSetup{
	
	@Test
	public void verifyAllProductsAndProductDetailPage() {
		TestCase1.isHomePageVisible();
	    checkIsUserNavigatedToAllProductsPage();
	    new ProductsPage(getDriver()).viewProductOfFirstProductButtonClick();
	    isDetailsVisible();
	}

	public static void checkIsUserNavigatedToAllProductsPage() {
	   System.out.println("Step : Check Is User Navigated To All Products Page");
	   String allProductsText = 
			   	new HomePage(getDriver())
	                .productsButtonClick()
	                .getTitleTextCenter()
	                .getText();
	   Assert.assertEquals(allProductsText, "ALL PRODUCTS", "Verify user is navigated to ALL PRODUCTS page successfully");
	 }

	 private void isDetailsVisible() {
		System.out.println("Step : Is Details Visible");
		boolean name = new ProductDetailPage(getDriver()).getProductName().isDisplayed();
	    boolean category = new ProductDetailPage(getDriver()).getProductCategory().isDisplayed();
	    boolean price = new ProductDetailPage(getDriver()).getProductPrice().isDisplayed();
	    boolean availability = new ProductDetailPage(getDriver()).getProductAvailability().isDisplayed();
	    boolean condition = new ProductDetailPage(getDriver()).getProductCondition().isDisplayed();
	    boolean brand = new ProductDetailPage(getDriver()).getProductBrand().isDisplayed();

	    Assert.assertTrue(name, "Verify that detail detail is visible: name");
	    Assert.assertTrue(category, "Verify that detail detail is visible: category");
	    Assert.assertTrue(price, "Verify that detail detail is visible: price");
	    Assert.assertTrue(availability, "Verify that detail detail is visible: availability");
	    Assert.assertTrue(condition, "Verify that detail detail is visible: condition");
	    Assert.assertTrue(brand, "Verify that detail detail is visible: brand");
	 }

}
