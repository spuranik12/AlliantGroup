package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.SurveyFormPage;
import pageClasses.SurveyPage;
import common.BaseTest;

public class SurveyTest extends BaseTest {
	
	@Test(priority = 1)
	public void navigateToSurveyPage() throws Exception{
		String SurveyExpectedURL = "http://agwotc.azurewebsites.net/Survey"; 
		Thread.sleep(2000);
		driver.navigate().to(SurveyExpectedURL);
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(SurveyExpectedURL)){  
			System.out.println("Navigated successfully to Survey Page.");
		}
		else{
			System.out.println("Navigation unsuccessfull." + actualURL);
		}
		SurveyPage sp = new SurveyPage(driver);
		sp.selectClient();
		sp.verifyClientSelection();
		sp.clickOnBeginSurveyBtn();
		Thread.sleep(2000);
		sp.selectTemplateFromList();
		Assert.assertTrue(sp.isSurveyDisplayed());
		System.out.println(sp.printSurveyPageHeading() + " Survey is displayed.");
	}
	
	@Test(priority = 2)
	public void completeSurvey() throws Exception{
		Thread.sleep(2000);
		SurveyFormPage sf = new SurveyFormPage(driver);
		sf.fillApplicantInfo();
		sf.selectMonthDayYear();
		sf.selectAnsForQuestions();
		sf.isAnsSelected();
		Thread.sleep(2000);
		sf.saveSurvey();
		Assert.assertTrue(sf.isSurveySaved());
		System.out.println(sf.getSurveySuccessMessage()); 
	}
}
