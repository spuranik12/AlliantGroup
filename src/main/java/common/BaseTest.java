package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Parameters;

import utilities.ReadPropertiesFile;

public class BaseTest {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeTest
	@Parameters({"Browser"})
	public void openBrowser(String browserName) throws Exception{
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/allDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(ReadPropertiesFile.GetValue("URL")); 
		}
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/allDrivers/chromedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(ReadPropertiesFile.GetValue("URL"));  
		}
	}

	@AfterTest 
	public void closeBrowser(){
		driver.quit();
	}
}
