package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserAction {
	WebDriver driver;
	
	BrowserAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public void applyDefaultImplicitWait(){ 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void applyImplicitWait(long timeOutInSeconds){
		driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS); 
	}
	
	public void waitElementToBeClickable(WebElement element, long timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
