package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
import projectspecification.Baseclass;

public class TC_002_Recordings extends BaseClass {
	
	
	
	@BeforeClass
	public void testcasedetails() {
	sheetName="Recordings";
	}

	@Test(dataProvider = "sendData")
	
	
	public void validaterecordings(String username, String Password, String testCaseType) throws InterruptedException {
		Login
		.enterEmail(username)
		.enterPassword(Password)
		.clickLoginButton()
		.verifytoastmessage(testCaseType)
		.clickonrecordings()
		.clickonrefresh()
		.clickonreset()
		.clickondoctorsdropdown()
		.selectdoctor()
		.selectdateincalender()
		.clickcleardateicon()
		.clickonviewrecording()
		.clickonEditicon()
		.Enterdataineditbox();
		
		
		
	}
	
}
