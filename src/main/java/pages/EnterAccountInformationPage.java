package pages;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import setup.AutomationExerciseConstants;
import setup.TestDataReader;
import setup.TestSetup;

public class EnterAccountInformationPage extends TestSetup {

    @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")
    private WebElement enterAccountInformation;

    @FindBy(id = "id_gender2")
    private WebElement titleMrCheckbox;
    
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[2]/label")
    private WebElement titleMrsCheckbox;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    private WebDriver driver;

    public EnterAccountInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getEnterAccountInformation() {
        return enterAccountInformation;
    }

    
    public AccountCreatedPage fillAccountDetails() throws IOException, ParseException {
    	
    	JSONObject validUserDetails = TestDataReader.validUserDetails();
		String password=(String) validUserDetails.get("password");
		
		JSONObject accountDetails = TestDataReader.accountDetails();
		
        titleMrsCheckbox.click();
        passwordInput.sendKeys(password);
        Select days = new Select(daysSelect);
        days.selectByValue((String) accountDetails.get("day"));
        
        Select months = new Select(monthsSelect);
        months.selectByValue((String) accountDetails.get("month"));
        
        Select years = new Select(yearsSelect);
        years.selectByValue((String) accountDetails.get("year"));
        
        newsletterCheckbox.click();
        specialOffersCheckbox.click();
        
        firstNameInput.sendKeys((String) accountDetails.get("firstName"));
        lastNameInput.sendKeys((String) accountDetails.get("lastName"));
        companyInput.sendKeys((String) accountDetails.get("company"));
        address1Input.sendKeys((String) accountDetails.get("address1"));
        address2Input.sendKeys((String) accountDetails.get("address2"));
        
        Select countrySelector = new Select(countrySelect);
        countrySelector.selectByValue((String) accountDetails.get("country"));
        
        stateInput.sendKeys((String) accountDetails.get("state"));
        cityInput.sendKeys((String) accountDetails.get("city"));
        zipcodeInput.sendKeys((String) accountDetails.get("zipcode"));
        mobileNumberInput.sendKeys((String) accountDetails.get("mobileNumber"));
        createAccountButton.click();
        
        return new AccountCreatedPage(driver);
    }
    
}