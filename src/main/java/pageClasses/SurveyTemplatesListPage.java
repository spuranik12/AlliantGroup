package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class SurveyTemplatesListPage extends BasePage {
	
	@FindBy(xpath = "//h1[.='Survey Templates']")
	private WebElement surveyTemplateLabel;
	
	@FindBy(css = "a[href='/SurveyTemplate/AddEditSurvey/0']")
	private WebElement createSurveyTemplateBtn;
	
	public SurveyTemplatesListPage(WebDriver driver){
		super(driver);
	}
	
	public boolean isSurveyHeadingDisplayed(){
		actions.applyDefaultImplicitWait();
		return surveyTemplateLabel.isDisplayed();
	}
	
	public String getSurveyTemplateHeading(){
		actions.applyDefaultImplicitWait();
		return surveyTemplateLabel.getText(); 
	}
	
	public void openNewSurveyTemplate(){
		actions.applyDefaultImplicitWait();
		createSurveyTemplateBtn.click();
	}
}
