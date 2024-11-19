package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

@Listeners(utils.CustomTestListener.class)  
public class TC_001_Login2 extends BaseClass {
	
	  @BeforeClass
	    public void testDetails() {
	        // Set the sheet name for the test
	        TestContext.setSheetName("Login");
	    }

	    @Test(dataProvider = "sendData") 
	public void validatelogin(String testNameDetails, String authorName, String category, String username, String Password, String testCaseType) throws InterruptedException {
	    	 ExtentReportManager.setTest(extent.createTest(testNameDetails));
	         ExtentReportManager.getTest().assignAuthor(authorName); 
	         ExtentReportManager.getTest().assignCategory(category);  

	      
	     TestContext.getLoginPage()
		.enterEmail(username)
		.enterPassword(Password)
		.clickLoginButton()
		.verifytoastmessage(testCaseType);

	}
}
