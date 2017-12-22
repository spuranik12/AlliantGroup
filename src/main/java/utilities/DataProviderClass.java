
package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name = "Login with valid credentials")
	public static Object[][] loginwithValidCredentials(){
		return new Object[][]{
				{"admin@alliantgroup.com", "silicus@123"},
		};
	}
}
