package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test; 

import pageClasses.DashboardPage;
import pageClasses.LoginPage;
import utilities.DataProviderClass;
import common.BaseTest;

public class LoginPageTest extends BaseTest{ 
	
	@Test(priority = 1, dataProvider = "Login with valid credentials", dataProviderClass = DataProviderClass.class) 
	public void loginwithValidInfo(String emailId, String pwd){
		LoginPage lp = new LoginPage(driver); 
		lp.isLoginPageDisplayed();
		Assert.assertTrue(lp.isLoginPageDisplayed());
		lp.loginwithValidCredentials(emailId, pwd); 
		DashboardPage dp = new DashboardPage(driver);
		Assert.assertTrue(dp.isUserLoggedIn());
	}
}
