package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

@Listeners(utils.CustomTestListener.class)
public class TC_002_Recordings extends BaseClass {
	
	@BeforeClass
	public void testcasedetails() {

		TestContext.setSheetName("Recordings");
	}

	@Test(dataProvider = "sendData")
	public void validate_recordings(String testNameDetails, String authorName, String category, String username,
			String Password, String testCaseType, String DoctorName,String Targetdates)
			throws InterruptedException {

		ExtentReportManager.setTest(extent.createTest(testNameDetails));
		ExtentReportManager.getTest().assignAuthor(authorName);
		ExtentReportManager.getTest().assignCategory(category);
		
		
		TestContext.getLoginPage()
		        .Enter_Email(username)
		        .Enter_Password(Password)
		        .Click_on_Login_Button()
				.verify_toast_message(testCaseType)
				.click_on_recordings_tab()
				.click_on_reset()
				.Select_doctor(DoctorName)				
				.select_date(Targetdates)		
				.click_on_view_recording()
				.validate_recording_File_fields();
						
				
	}

}
