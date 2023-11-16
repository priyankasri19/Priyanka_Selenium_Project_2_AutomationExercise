package testCases;

import java.io.IOException;
import org.json.simple.parser.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailPage;
import pages.ProductsPage;
import setup.TestSetup;

public class TestCase21 extends TestSetup {

	 @Test
	 public void addReviewOnProduct() throws IOException, ParseException {
	        TestCase8.checkIsUserNavigatedToAllProductsPage();
	        checkIsWriteYourReview();
	        checkSuccessMessageThankYouForYourReview();
	    }

	    private void checkIsWriteYourReview() {
	    	System.out.println("Step : Check Is Write Your Review");
	        String writeYourReviewText = new ProductsPage(getDriver())
	                .viewProductOfFirstProductButtonClick()
	                .getWriteYourReview()
	                .getText();
	        Assert.assertEquals(writeYourReviewText, "WRITE YOUR REVIEW", "Verify 'Write Your Review' is visible");
	    }

	    private void checkSuccessMessageThankYouForYourReview() throws IOException, ParseException {
	    	System.out.println("Step : Check Success Message Thank You For Your Review");
	        String successMessageText = new ProductDetailPage(getDriver())
	                .fillReview()
	                .getSuccessMessage()
	                .getText();
	        Assert.assertEquals(successMessageText, "Thank you for your review.", "Verify success message 'Thank you for your review.'");
	    }
}
