package pages;


import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.AutomationExerciseConstants;
import setup.AutomationExerciseUtility;
import setup.TestDataReader;

public class ContactUsPage {

    @FindBy(css = "h2.title:nth-child(2)")
    private WebElement getInTouch;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "subject")
    private WebElement subjectInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(name = "upload_file")
    private WebElement uploadFileInput;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    private WebElement alertSuccess;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement homePageButton;

    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getGetInTouch() {
        return getInTouch;
    }
    

    public ContactUsPage fillForm() throws IOException, ParseException {
    	
		JSONObject commonTestDetails = TestDataReader.commonTestData();
		String name=(String) commonTestDetails.get("name");
		String email=(String) commonTestDetails.get("email");
		String subject=(String) commonTestDetails.get("subject");
		String message=(String) commonTestDetails.get("message");
		
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        subjectInput.sendKeys(subject);
        messageInput.sendKeys(message);
        uploadFileInput.
        	sendKeys(AutomationExerciseUtility.getAbsolutePath() + 
        				AutomationExerciseConstants.attachmentFileName);

        return this;
    }

    public ContactUsPage submitButtonClick() {
        submitButton.click();
        return this;
    }

    public ContactUsPage okButtonClick() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public WebElement getAlertSuccess() {
        return alertSuccess;
    }

    public HomePage homePageButtonClick() {
        homePageButton.click();
        return new HomePage(driver);
    }
}
