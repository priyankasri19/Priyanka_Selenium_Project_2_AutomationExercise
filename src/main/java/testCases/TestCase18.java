package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;
import setup.TestSetup;

public class TestCase18 extends TestSetup {

	@Test
	public void viewCategoryProducts() {
        TestCase1.isHomePageVisible();
        checkIsCategoriesVisibleOnLeftSideBar();
        checkIsCategoryPageDisplayedAndConfirmTextWomenDressProducts();
        checkIsUserNavigatedToThatCategoryPage();
    }

    private void checkIsCategoriesVisibleOnLeftSideBar() {
    	System.out.println("Step : Check Is Categories Visible On Left SideBar");
        boolean categoriesAreVisible = new HomePage(getDriver())
                .getCategories()
                .isDisplayed();
        Assert.assertTrue(categoriesAreVisible, "Verify that categories are visible on left side bar");
    }

    private void checkIsCategoryPageDisplayedAndConfirmTextWomenDressProducts() {
    	System.out.println("Step : Check Is Category Page Displayed And Confirm Text Women Dress Products");
        String titleTextCenter = new HomePage(getDriver())
                .womenCategoryClick()
                .dressCategoryClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "WOMEN - DRESS PRODUCTS", "Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'");
    }

    private void checkIsUserNavigatedToThatCategoryPage() {
    	System.out.println("Step : Check Is User Navigated To That Category Page");
        String titleTextCenter = new ProductsPage(getDriver())
                .menCategoryClick()
                .tShirtsCategoryClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "MEN - TSHIRTS PRODUCTS", "Verify that user is navigated to that category page");
    }
}
