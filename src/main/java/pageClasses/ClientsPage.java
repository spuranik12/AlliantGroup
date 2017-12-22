package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class ClientsPage extends BasePage{
	
	@FindBy(css = "#clientsTab")
	private WebElement clientsTab;
	
	@FindBy(css = "#isAssignedTR_15 > td:nth-child(1) > input[type='checkbox']")
	private WebElement selectReqClient;
	
	@FindBy(css = "#isAssignedTR_15 > td:nth-child(2) > span")
	private WebElement clientName;
	
	@FindBy(css = "#AssignClientsButton")
	private WebElement clientSaveBtn;
	
	@FindBy(xpath = "//*[.='Client have been assigned successfully.']")
	private WebElement clientSaveMsg;
	
	public ClientsPage(WebDriver driver) {
		super(driver);
	}
	
	public void openClientsTab(){
		actions.applyDefaultImplicitWait();
		clientsTab.click();
	}
	
	public boolean isClientListDisplayed(){
		actions.applyDefaultImplicitWait();
		return clientsTab.isDisplayed(); 
	}
	
	public String getClientListName(){
		actions.applyDefaultImplicitWait();
		return clientsTab.getText(); 
	}
	
	public void selectClient(){
		actions.applyDefaultImplicitWait();
		selectReqClient.click();
	}
	
	public boolean verifyClientSelection(){
		actions.applyDefaultImplicitWait();
		return selectReqClient.isSelected(); 
	}
	
	public void printClientSelectionSuccessMsg(){
		actions.applyDefaultImplicitWait();
		if(selectReqClient.isSelected()){
			System.out.println("Client : " + " '" + clientName.getText() + "' " + " is selected.");
		}else{
			System.out.println("Client : " + " '" + clientName.getText() + "' " + " is not selected.");
		}
	}
	
	public void saveClientDetails(){
		actions.applyDefaultImplicitWait();
		clientSaveBtn.click();
	}
	
	public boolean isClientDetailsSaved(){
		actions.applyDefaultImplicitWait();
		return clientSaveMsg.isDisplayed();
	}
	
	public String printClientSaveMsg(){
		actions.applyDefaultImplicitWait();
		return clientSaveMsg.getText(); 
	}
}
