package pageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ReadPropertiesFile;
import common.BasePage;
import common.BaseTest;

public class NewSurveyTemplatePage extends BasePage{

	@FindBy(xpath = "//h1[.='Create Survey Template']")
	private WebElement createSurveyTemplateHeading;

	@FindBy(css = "input.form-control")
	private WebElement surveyNameField;

	@FindBy(xpath = "//div[@class='section']//*[1][@required = 'required']")
	private WebElement surveySectionNameField; 

	@FindBy(xpath = "//*[@placeholder='Enter section instructions']")
	private WebElement surveySectionInstTxtArea;

	@FindBy(xpath = "//*[@title='Editable area. Press F10 for toolbar.']")
	private WebElement iframeElement;  

	@FindBy(xpath = "/html/body") 
	private WebElement surveyQuestionArea;

	@FindBy(css = "input[data-bind='checked: Required']") 
	private WebElement surveyQuestionReqBox; 

	@FindBy(css = "div:nth-child(2) > div:nth-child(1) > div.col-xs-10 > input.form-control")
	private WebElement surveyAnsFirstOption;

	@FindBy(css = "div:nth-child(2) > div:nth-child(3) > div.col-xs-10 > input.form-control")
	private WebElement surveyAnsSecondOption;

	@FindBy(css = "div:nth-child(2) > div:nth-child(3) > div.col-xs-2 > input[type='checkbox']")
	private WebElement surveyAnsEligible;
	
	@FindBy(css = "#SaveButton")
	private WebElement surveySaveBtn;
	
	@FindBy(xpath = "//*[.='Survey Template has been saved successfully.']")
	private WebElement surveySaveMessage;
	
	public NewSurveyTemplatePage(WebDriver driver) {
		super(driver);
	}

	public boolean isNewSurveyTemplatePageDisplayed(){
		actions.applyDefaultImplicitWait();
		return createSurveyTemplateHeading.isDisplayed(); 
	}

	public String getCreateSurveyTemplateHeading(){
		actions.applyDefaultImplicitWait();
		return createSurveyTemplateHeading.getText(); 
	}

	public void enterSurveyNameAndSectionInfo() throws Exception{ 
		actions.applyDefaultImplicitWait();
		surveyNameField.sendKeys(Keys.chord(Keys.CONTROL + "a"), ReadPropertiesFile.GetValue("SurveyName"));
		actions.applyDefaultImplicitWait();
		surveySectionNameField.sendKeys(Keys.chord(Keys.CONTROL + "a"), ReadPropertiesFile.GetValue("SurveySectionName"));
		actions.applyDefaultImplicitWait();
		surveySectionInstTxtArea.sendKeys(ReadPropertiesFile.GetValue("SurveySectionInstruction"));
	}

	public void createSurveyQuestions() throws Exception{  
		actions.applyDefaultImplicitWait();
		BaseTest.driver.switchTo().frame(0);
		actions.applyDefaultImplicitWait();
		surveyQuestionArea.sendKeys(Keys.chord(Keys.CONTROL + "a"), ReadPropertiesFile.GetValue("SurveyQuestion"));
		BaseTest.driver.switchTo().defaultContent();
		actions.applyDefaultImplicitWait();
		surveyQuestionReqBox.click();
		actions.applyDefaultImplicitWait();
		surveyAnsFirstOption.sendKeys(ReadPropertiesFile.GetValue("SurveyQuestionFirstAnswer"));
		surveyAnsSecondOption.sendKeys(ReadPropertiesFile.GetValue("SurveyQuestionSecondAnswer"));
		surveyAnsEligible.click();
	}
	
	public void saveSurveyTemplate(){
		actions.applyDefaultImplicitWait();
		surveySaveBtn.click();
	}
	
	public boolean isSurveySavedSuccessfully(){
		actions.applyImplicitWait(10);
		return surveySaveMessage.isDisplayed(); 
	}
	
	public String getSurveySuccessMessage(){
		actions.applyDefaultImplicitWait();
		return surveySaveMessage.getText(); 
	}
}
