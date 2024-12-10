package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import utils.ExtentReportManager;
import utils.TestContext;

public class PG_006_Deletekeyword {

	public PG_006_Deletekeyword(WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}
	
	@FindBy(xpath = "//div[@role='presentation']//div[2]//div[5]//div[1]//button[2]//*[name()='svg']")
	WebElement deleteicon;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement yesdelete;
	
	@FindBy(xpath = "//div[contains(text(),'keyword deleted')]")
	WebElement deletesuccessmessage;
	
	public PG_006_Deletekeyword Delete_keyword() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		
		try {
			Thread.sleep(3000);
			deleteicon.click();
			Thread.sleep(3000);
			yesdelete.click();
			Thread.sleep(3000);
			TestContext.getWait().until(ExpectedConditions.visibilityOf(deletesuccessmessage));	
			Assert.assertEquals(deletesuccessmessage.getText(), "keyword deleted");					
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;	
	}
	
}
