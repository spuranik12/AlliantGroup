package pageClasses;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ReadPropertiesFile;
import common.BasePage;
import common.BaseTest;

public class SurveyFormPage extends BasePage {

	@FindBy(css = "input[placeholder='First Name']")
	private WebElement firstName;

	@FindBy(css = "input[placeholder='Last Name']")
	private WebElement LastName; 

	@FindBy(css = "input[type='email']")
	private WebElement email;

	@FindBy(css = "div:nth-child(6) > p:nth-child(2) > input[type='checkbox']")
	private WebElement noPhoneCheckbox;

	@FindBy(css = "div:nth-child(7) > p:nth-child(2) > input[type='checkbox']")
	private WebElement noSSNCheckbox;

	@FindBy(css = "input[placeholder='Number & Street Name']")
	private WebElement numberAndStreetName;

	@FindBy(css = "input[placeholder='Appartment #']")
	private WebElement apartment;

	@FindBy(css = "input[placeholder='City']")
	private WebElement city;

	@FindBy(css = "select[class='form-control']")
	private WebElement state;
	Select sel = new Select(state);

	@FindBy(css = "input[placeholder='Zip Code']")
	private WebElement zipCode;

	@FindBy(css = "input[placeholder='County']")
	private WebElement county;

	@FindBy(css = "span.k-widget")
	private WebElement monthDropDown;

	@FindBy(css = "div.k-list-container ul.k-list li.k-item")
	private List<WebElement> monthOptions;

	@FindBy(css = "div:nth-child(8) > div.col-xs-12.col-sm-12.mb10 > div > div > div > div.month > span > span > span.k-input")
	private WebElement month;
	
	@FindBy(css = "div:nth-child(8) > div.col-xs-12.col-sm-12.mb10 > div > div > div > div.day > span > span > span.k-input")
	private WebElement date;
	
	@FindBy(css = "div:nth-child(8) > div.col-xs-12.col-sm-12.mb10 > div > div > div > div.year > span > span > span.k-input")
	private WebElement year;
	
	@FindBy(css = "div:nth-child(6) > div > div:nth-child(3) > div > input[type='radio']")
	private WebElement QAAns1;

	@FindBy(css = "#btnCompleteSurvey")
	private WebElement saveSurveyBtn;

	@FindBy(xpath = "//*[.='You have successfully saved your information.']")
	private WebElement saveSuccessMsg; 

	public SurveyFormPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillApplicantInfo() throws Exception{
		actions.applyDefaultImplicitWait();
		firstName.sendKeys(ReadPropertiesFile.GetValue("FirstName"));
		LastName.sendKeys(ReadPropertiesFile.GetValue("LastName"));
		email.sendKeys(ReadPropertiesFile.GetValue("Email"));
		noPhoneCheckbox.click();
		noSSNCheckbox.click();
		numberAndStreetName.sendKeys(ReadPropertiesFile.GetValue("NumAndStreet"));
		apartment.sendKeys(ReadPropertiesFile.GetValue("Apartment"));
		city.sendKeys(ReadPropertiesFile.GetValue("City"));
		sel.selectByVisibleText(ReadPropertiesFile.GetValue("State"));
		zipCode.sendKeys(ReadPropertiesFile.GetValue("ZipCode"));
		county.sendKeys(ReadPropertiesFile.GetValue("County"));	
	}
	
	//---Dynamic Kendo drop down list using javascript executor for selecting month, day & year.
	public void selectMonthDayYear() throws InterruptedException{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
		month.click();
		js.executeScript("arguments[0].innerText = 'June'", month);
		date.click();
		js.executeScript("arguments[0].innerText = '2'", date);
		year.click();
		js.executeScript("arguments[0].innerText = '2017'", year);
	}
	
	public void selectAnsForQuestions(){
		actions.applyImplicitWait(10);
		QAAns1.click();
	}

	public boolean isAnsSelected(){
		actions.applyDefaultImplicitWait();
		if(QAAns1.isSelected()){
			System.out.println("Answer Selected.");
		}
		else{
			System.out.println("Answer not selected");
		}
		return QAAns1.isSelected(); 
	}

	public void saveSurvey(){
		actions.applyDefaultImplicitWait();
		saveSurveyBtn.click();
	}

	public boolean isSurveySaved(){
		actions.applyImplicitWait(10);
		return saveSuccessMsg.isDisplayed(); 
	}

	public String getSurveySuccessMessage(){
		actions.applyImplicitWait(10);
		return saveSuccessMsg.getText();   
	}
}
