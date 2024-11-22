package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class TC_003_Logout extends BaseClass{
	@BeforeClass
    public void testDetails() {
        // Set the sheet name for the test
        TestContext.setSheetName("Logout");
    }

	
	

    @Test(dataProvider = "sendData") 
public void validate_logout(String testNameDetails, String authorName, String category, String username, String Password, String testCaseType) throws InterruptedException {
    	
    	ExtentReportManager.setTest(extent.createTest(testNameDetails));
         ExtentReportManager.getTest().assignAuthor(authorName); 
         ExtentReportManager.getTest().assignCategory(category);  

      
     TestContext.getLoginPage()
	.Enter_Email(username)
	.Enter_Password(Password)
	.Click_on_Login_Button()
	.verify_toast_message(testCaseType)
	.click_on_logout()
	.Verify_the_URL();

	
     
     
}
}