package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ReadPropertiesFile;
import common.BasePage;

public class DocuSignMappingPage extends BasePage {

	@FindBy(css = "#docuSignMappingTab")
	private WebElement documentMappingTab;
	
	@FindBy(css = "select.custom-options-select")
	private WebElement mappingDropdown;
	Select sel = new Select(mappingDropdown);
	
	@FindBy(css = "#MappingSaveButton")
	private WebElement mappingSaveBtn;
	
	@FindBy(xpath = "//*[.='DocuSign mapping has been updated successfully.']")
	private WebElement mappingSaveMsg;
	
	public DocuSignMappingPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickDocuSignMappingTab(){
		actions.applyDefaultImplicitWait();
		documentMappingTab.click();
	}
	
	public void selectTemplateToMap() throws Exception{
		actions.applyDefaultImplicitWait();
		sel.selectByVisibleText(ReadPropertiesFile.GetValue("SelectTemplateToMapSurvey"));
	}
	
	public void saveMapping(){
		actions.applyDefaultImplicitWait();
		mappingSaveBtn.click();
	}
	
	public boolean isMappingSaveSuccessMsgDisplayed(){
		actions.applyDefaultImplicitWait();
		return mappingSaveMsg.isDisplayed(); 
	}
	
	public String printMappingSuccessMsg(){
		actions.applyImplicitWait(10);
		return mappingSaveMsg.getText(); 
	}
}
