package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.AutomationExerciseConstants;
import setup.AutomationExerciseUtility;

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
    

    public ContactUsPage fillForm() {
        nameInput.sendKeys(AutomationExerciseConstants.name);
        emailInput.sendKeys(AutomationExerciseConstants.email);
        subjectInput.sendKeys(AutomationExerciseConstants.subject);
        messageInput.sendKeys(AutomationExerciseConstants.message);
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
