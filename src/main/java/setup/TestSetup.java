package setup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSetup {

	public static ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<WebDriver>();
	
    public static synchronized WebDriver getDriver() {
        return threadLocaldriver.get();
    }
    
	@BeforeMethod
	public void setup() throws IOException {
		String url=PropertyLoader.loadProperty("url");
		WebDriver driver = loadBrowserSetup();
		driver.manage().window().maximize();
		threadLocaldriver.set(driver);
        getDriver().get(url);
	}
	
	@AfterMethod
	public void teardown() {
        getDriver().quit();
        threadLocaldriver.remove();
	}
	
	public WebDriver loadBrowserSetup() throws IOException{
		WebDriver driver = null;
		String browser=PropertyLoader.loadProperty("browser.name");

	     if (browser.equalsIgnoreCase("Firefox")) {
	    	 System.setProperty("webdriver.gecko.driver", "lib\\geckodriver.exe");
	         driver = new FirefoxDriver();
	     }
	     
	     if (browser.equalsIgnoreCase("Chrome")) {
	    	 System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
	         driver = new ChromeDriver(); 
	     }
	     
	     // Add any new browser on which automation has to be run
	     
		return driver;
	}
}
