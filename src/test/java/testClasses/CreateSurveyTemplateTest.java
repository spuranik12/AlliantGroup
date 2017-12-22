package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.ClientsPage;
import pageClasses.DashboardPage;
import pageClasses.NewSurveyTemplatePage;
import pageClasses.SurveyTemplatesListPage;

public class CreateSurveyTemplateTest extends BaseTest {

	@Test(priority = 1)
	public void openSurveyTemplates(){ 
		DashboardPage dp = new DashboardPage(driver);
		dp.clickOnSurveyTemplates();
		SurveyTemplatesListPage templatesList = new SurveyTemplatesListPage(driver);
		Assert.assertTrue(templatesList.isSurveyHeadingDisplayed());
		System.out.println(templatesList.getSurveyTemplateHeading() + " page is displayed. ");
		templatesList.openNewSurveyTemplate(); 
	}

	@Test(priority = 2)
	public void createNewSurveyTemplate() throws InterruptedException{
		NewSurveyTemplatePage newTemplatePage = new NewSurveyTemplatePage(driver);
		Assert.assertTrue(newTemplatePage.isNewSurveyTemplatePageDisplayed());
		System.out.println(newTemplatePage.getCreateSurveyTemplateHeading() + " page is displayed. ");
		newTemplatePage.enterSurveyNameAndSectionInfo(); 
		newTemplatePage.createSurveyQuestions();
		newTemplatePage.saveSurveyTemplate();
		Assert.assertTrue(newTemplatePage.isSurveySavedSuccessfully());
		System.out.println(newTemplatePage.getSurveySuccessMessage());
	}
	
	@Test(priority = 3)
	public void selectClientsForTemplate() throws InterruptedException{
		Thread.sleep(2000);
		ClientsPage cp = new ClientsPage(driver);
		cp.openClientsTab();
		Assert.assertTrue(cp.isClientListDisplayed());
		System.out.println(cp.getClientListName() + " page is displayed. ");
		cp.selectClient();
		Thread.sleep(2000);
		Assert.assertTrue(cp.verifyClientSelection());
		cp.printClientSelectionSuccessMsg();
		cp.saveClientDetails();
		Assert.assertTrue(cp.isClientDetailsSaved());
		System.out.println(cp.printClientSaveMsg());
	}
}
