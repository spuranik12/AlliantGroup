package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class DashboardPage extends BasePage {
	
	@FindBy(xpath = "//*[.='Dashboard']")
	private WebElement dashboardLink; 
	
	@FindBy(css = "img[title='alliantgroup']")
	private WebElement loggedInUser;
	
	@FindBy(xpath = "//*[.='Survey Templates']")
	private WebElement surveyTemplateLink;
	
	public DashboardPage(WebDriver driver){
		super(driver);
	}
	
	public boolean isUserLoggedIn(){ 
		actions.applyDefaultImplicitWait();
		return dashboardLink.isDisplayed(); 
	}
	
	public String getLoggedInUserName(){
		actions.applyDefaultImplicitWait();
		return loggedInUser.getText(); 
	}
	
	public void clickOnSurveyTemplates(){
		actions.applyImplicitWait(10);
		surveyTemplateLink.click();
	}
}
