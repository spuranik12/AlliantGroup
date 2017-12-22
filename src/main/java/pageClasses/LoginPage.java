package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(css = "#Email")
	private WebElement emailId;
	
	@FindBy(css = "#Password")
	private WebElement pwd;
	
	@FindBy(css = "input[type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//*[.='Dashboard']")
	private WebElement dashboardLink; 
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	public void loginwithValidCredentials(String email, String password){
		actions.applyDefaultImplicitWait();
		emailId.sendKeys(email);
		actions.applyDefaultImplicitWait();
		pwd.sendKeys(password);
		actions.applyDefaultImplicitWait();
		loginBtn.click(); 
	}
	
	public boolean isLoginPageDisplayed(){
		return loginBtn.isDisplayed(); 
	}
}
