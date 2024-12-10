package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

@Listeners(utils.CustomTestListener.class)
public class TC_005_EditKeyword extends BaseClass{
	@BeforeClass
    public void testDetails() {
        // Set the sheet name for the test
        TestContext.setSheetName("Login");
    }

    @Test(dataProvider = "sendData") 	
	public void Add_Keyword(String testNameDetails, String authorName, String category, String username, String Password, String testCaseType) throws InterruptedException {
		
		 ExtentReportManager.setTest(extent.createTest(testNameDetails));
         ExtentReportManager.getTest().assignAuthor(authorName); 
         ExtentReportManager.getTest().assignCategory(category);  

        
  	  TestContext.getLoginPage()	
      .Enter_Email(username)
		.Enter_Password(Password)
		.Click_on_Login_Button()
		.verify_toast_message(testCaseType)
		.click_on_Keyword_Module()
		.click_on_edit_icon()
		.update_keyword_textbox()
		.update_instruction_textbox()
		.click_on_update_button()
		.validate_toast_message();
		
}
}
