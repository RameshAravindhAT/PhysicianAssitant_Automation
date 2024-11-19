package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class TC_001_Login2 extends BaseClass {
	
	  @BeforeClass
	    public void testDetails() {
	        // Set the sheet name for the test
	        TestContext.setSheetName("Login");
	    }

	    @Test(dataProvider = "sendData") 
	public void validatelogin(String testNameDetails, String authorName, String category, String username, String Password, String testCaseType) throws InterruptedException {
	    	 ExtentReportManager.setTest(extent.createTest(testNameDetails)); // Create the test instance in Extent Reports
	         ExtentReportManager.getTest().assignAuthor(authorName); // Assign the author for the test
	         ExtentReportManager.getTest().assignCategory(category);  // Assign the category for the test

	         // Perform the login action using the login page object
	         TestContext.getLoginPage()
	    	
	    	
		.enterEmail(username)
		.enterPassword(Password)
		.clickLoginButton()
		.verifytoastmessage(testCaseType);

	}
}
