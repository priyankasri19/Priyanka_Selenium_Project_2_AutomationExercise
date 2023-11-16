package pages;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.TestAutomationHelper;
import setup.TestDataReader;
import setup.TestSetup;

public class HomePage extends TestSetup {
    
    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesButton;

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

    @FindBy(css = "a[href='/product_details/2']")
    private WebElement viewProduct1Button;

    @FindBy(id = "accordian")
    private WebElement categories;

    @FindBy(xpath = "//*[@id='accordian']/div[1]/div[1]/h4/a/span/i")
    private WebElement womenCategory;

    @FindBy(css = "a[href='/category_products/1']")
    private WebElement dressCategory;

    @FindBy(css = "div[class='recommended_items'] h2")
    private WebElement recommendedItems;

    @FindBy(css = "div[id='recommended-item-carousel'] a[class='btn btn-default add-to-cart']")
    private WebElement blueTopAddToCartButton;

    @FindBy(css = "div[class='modal-content'] a[href='/view_cart']")
    private WebElement viewCartButton;

    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;

    @FindBy(xpath = "//section[1]/div/div/div/div/div/div[1]/div[1]/h2")
    private WebElement fullFledgedPracticeWebsiteForAutomationEngineers;
    
    //footer
    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement subscription;
    
    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInput;
    
    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(id = "success-subscribe")
    private WebElement alertSuccessSubscribe;

    //footer
    public WebElement getSubscription() {
        return subscription;
    }
    
    public WebElement getAlertSuccessSubscribe() {
        return alertSuccessSubscribe;
    }
    
    public HomePage fillSubscribe() throws IOException, ParseException {
    	
    	JSONObject validUserDetails = TestDataReader.validUserDetails();
		String email=(String) validUserDetails.get("email");
        subscribeEmailInput.sendKeys(email);
        TestAutomationHelper.waitForElementToBeClickable(driver, subscribeButton);
        subscribeButton.click();
        return this;
        
    }

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    /*
    public WebElement homePageIsVisible() {
        return girlImgResponsive;
    }*/

    public LoginSignupPage signupLoginClick() {
        signupLoginButton.click();
        return new LoginSignupPage(driver);
    }
    
    public ContactUsPage contactUsButtonClick() {
        contactUsButton.click();
        return new ContactUsPage(driver);
    }

    
    public TestCasesPage testCasesButtonClick() {
        testCasesButton.click();
        return new TestCasesPage(driver);
    }

    
    public ProductsPage productsButtonClick() {
        productsButton.click();
        return new ProductsPage(driver);
    }

    public CartPage cartButtonClick() {
        cartButton.click();
        return new CartPage(driver);
    }
    

    
    public ProductDetailPage viewProduct1ButtonClick() {
        TestAutomationHelper.waitForElementToBeClickable(driver, viewProduct1Button);
        viewProduct1Button.click();
        return new ProductDetailPage(driver);
    }
    
    
    public WebElement getCategories() {
        return categories;
    }

    
    public HomePage womenCategoryClick() {
        TestAutomationHelper.waitForElementToBeClickable(driver, womenCategory);
        womenCategory.click();
        return this;
    }
    

    
    public ProductsPage dressCategoryClick() {
        TestAutomationHelper.waitForElementToBeClickable(driver, dressCategory);
        dressCategory.click();
        return new ProductsPage(driver);
    }
    

    public WebElement getRecommendedItems() {
        return recommendedItems;
    }

    
    public HomePage blueTopAddToCartButtonClick() {
        TestAutomationHelper.waitForElementToBeClickable(driver, blueTopAddToCartButton);
        blueTopAddToCartButton.click();
        return this;
    }
    

    
    public CartPage viewCartButtonClick() {
        TestAutomationHelper.waitForElementToBeVisible(driver, viewCartButton);
        viewCartButton.click();
        return new CartPage(driver);
    }
    

    public HomePage scrollUpButtonClick() {
        scrollUpButton.click();
        return this;
    }

    
    public WebElement getFullFledgedPracticeWebsiteForAutomationEngineers() {
        TestAutomationHelper.waitForElementToBeVisible(driver, fullFledgedPracticeWebsiteForAutomationEngineers);
        return fullFledgedPracticeWebsiteForAutomationEngineers;
    }    
 
    public String homePageTitle() {
    	return driver.getTitle();
    }
    
}