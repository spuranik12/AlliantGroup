package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ReadPropertiesFile;
import common.BasePage;

public class SurveyPage extends BasePage{
	
	@FindBy(css = "#ClientId")
	private WebElement clientDropdown; 
	Select oSelect = new Select(clientDropdown);
	
	@FindBy(xpath = "//a[.='BEGIN SURVEY']")
	private WebElement beginSurveyBtn;
	
	@FindBy(css = "li:nth-child(4) > a")
	private WebElement surveyName;
	
	@FindBy(css = "#btnCompleteSurvey")
	private WebElement saveAsDraftBtn;
	
	@FindBy(xpath = "//*[@id='frmSurvey']/div[1]/div/h3")
	private WebElement surveyPageHeading;
	
	public SurveyPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectClient() throws Exception{
		actions.applyDefaultImplicitWait();
		oSelect.selectByVisibleText(ReadPropertiesFile.GetValue("Client"));
	}
	
	public String verifyClientSelection() throws Exception{
		actions.applyDefaultImplicitWait();
		String optionSelected = oSelect.getFirstSelectedOption().getText();
		if(optionSelected.equals(ReadPropertiesFile.GetValue("Client"))){
			System.out.println(optionSelected + " client is selected");
			return optionSelected;
		}
		else{
			System.out.println(optionSelected +  "Not selected");
		}
		return null;
	}
	
	public void clickOnBeginSurveyBtn(){
		actions.applyDefaultImplicitWait();
		beginSurveyBtn.click();
	}
	
	public void selectTemplateFromList(){
		actions.applyDefaultImplicitWait();
		surveyName.click();
	}
	
	public boolean isSurveyDisplayed(){
		actions.waitElementToBeClickable(saveAsDraftBtn, 10);
		return saveAsDraftBtn.isDisplayed(); 
	}
	
	public String printSurveyPageHeading(){
		actions.applyDefaultImplicitWait();
		return surveyPageHeading.getText(); 
	}
}
