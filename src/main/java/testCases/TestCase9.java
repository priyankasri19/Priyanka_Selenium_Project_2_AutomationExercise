package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductsPage;
import setup.PropertyLoader;
import setup.TestSetup;

public class TestCase9 extends TestSetup {

	static String search;

	static {
		try {
	        	search = PropertyLoader.loadProperty("search.product.input");
	        }catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	}

	@Test   
	public void searchProduct() {
		TestCase1.isHomePageVisible();
	    TestCase8.checkIsUserNavigatedToAllProductsPage();
	    isSearchedProductsVisible();
	    checkIsAllTheProductsRelatedToSearchAreVisible();
	}

	public static void isSearchedProductsVisible() {
	    System.out.println("Step : Is Searched Products Visible");
	    String searchedProductsText = 
	    			new ProductsPage(getDriver())
	                	.fillSearchProductInput(search)
	                	.getTitleTextCenter()
	                	.getText();
	    Assert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS", "Verify 'SEARCHED PRODUCTS' is visible");
	 }

	public static List<String> checkIsAllTheProductsRelatedToSearchAreVisible() {
	    System.out.println("Step : Check Is All The Products Related To Search Are Visible");
	    List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();

	    for (int i = 0; i < productsNames.size(); i++) {
	    	Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
	        System.out.println(i + ". " + productsNames.get(i) + " - contain: " + search);
	    }
	    return productsNames;
	}
}
