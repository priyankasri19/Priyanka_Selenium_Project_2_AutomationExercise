package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.AutomationExerciseConstants;
import setup.AutomationExerciseUtility;
import setup.TestAutomationHelper;
import setup.TestDataReader;

import java.io.IOException;
import org.json.simple.parser.ParseException;

public class ProductDetailPage {

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div")
    private WebElement productName;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    private WebElement productCategory;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
    private WebElement productPrice;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[2]")
    private WebElement productAvailability;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[3]")
    private WebElement productCondition;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[4]")
    private WebElement productBrand;

    @FindBy(id = "quantity")
    private WebElement quantityInput;

    @FindBy(css = "button[class='btn btn-default cart']")
    private WebElement addToCartButton;

    @FindBy(css = "a[href='/view_cart'] u")
    private WebElement viewCartButton;

    @FindBy(css = "a[href='#reviews']")
    private WebElement writeYourReview;

    @FindBy(id = "name")
    private WebElement yourNameInput;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "review")
    private WebElement addReviewHere;

    @FindBy(id = "button-review")
    private WebElement submitButton;

    @FindBy(css = "div[class='alert-success alert'] span")
    private WebElement successMessage;

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductCategory() {
        return productCategory;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getProductAvailability() {
        return productAvailability;
    }

    public WebElement getProductCondition() {
        return productCondition;
    }

    public WebElement getProductBrand() {
        return productBrand;
    }

    public ProductDetailPage increaseQuantity(String value) {
        quantityInput.clear();
        quantityInput.sendKeys(value);
        return this;
    }

    public ProductDetailPage addToCartButtonClick() {
        addToCartButton.click();
        return this;
    }

    public CartPage viewCartButtonClick() {
        TestAutomationHelper.waitForElementToBeClickable(driver, viewCartButton);
        viewCartButton.click();
        return new CartPage(driver);
    }

    public WebElement getWriteYourReview() {
        return writeYourReview;
    }

    public ProductDetailPage fillReview() throws IOException, ParseException {
    	
    	JSONObject validUserDetails = TestDataReader.validUserDetails();
		String name=(String) validUserDetails.get("name");
		String email=(String) validUserDetails.get("email");
		
		JSONObject commonTestDetails = TestDataReader.commonTestData();
		String sampleReview=(String) commonTestDetails.get("sampleReview");
		
        yourNameInput.sendKeys(name);
        emailAddress.sendKeys(email);
        addReviewHere.sendKeys(sampleReview);
        submitButton.click();
        return this;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }
}