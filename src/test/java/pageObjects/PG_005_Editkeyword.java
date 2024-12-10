package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import utils.ExtentReportManager;
import utils.TestContext;

public class PG_005_Editkeyword{
	
	public PG_005_Editkeyword(WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}
	
	@FindBy(xpath = "//div[contains(@class, 'MuiInputBase-root') and contains(@class, 'MuiOutlinedInput-root')]//input[@name='keyword' and @type='text']")
	WebElement keywordtextbox;
			
	@FindBy(xpath = "//textarea[@name='instruction']")  
	WebElement instructiontextbox;
	
	@FindBy(xpath = "//div[contains(text(),'Keyword already in use.')]")
	WebElement usedkeywordmessage;
		
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement updatebutton;
	
	@FindBy(xpath = "//div[contains(text(),'Keyword updated successfully.')]")
	WebElement updatedsuccessmessage;
			
	public PG_005_Editkeyword update_keyword_textbox() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {
	Thread.sleep(3000);
	keywordtextbox.sendKeys(Keys.CONTROL + "a");
	keywordtextbox.sendKeys(Keys.DELETE);
	keywordtextbox.sendKeys("SOAP");
	ExtentReportManager.reportStep(methodName, "pass");
	TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
            TestContext.getLogger().error(methodName);
            e.printStackTrace();
		}
		return this;	
	}
	public PG_005_Editkeyword update_instruction_textbox() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {
			instructiontextbox.sendKeys(Keys.CONTROL + "a");
			instructiontextbox.sendKeys(Keys.DELETE);
			instructiontextbox.sendKeys("8765rfghnbvcw4567uj");
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
            TestContext.getLogger().error(methodName);
            e.printStackTrace();
		}
		return this;	
	}

	public PG_005_Editkeyword click_on_update_button() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {
			updatebutton.click();	
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
            TestContext.getLogger().error(methodName);
            e.printStackTrace();
		}
		return this;	
	}
	public PG_005_Editkeyword validate_toast_message() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {
			TestContext.getWait().until(ExpectedConditions.visibilityOf(updatedsuccessmessage));	
			Assert.assertEquals(updatedsuccessmessage.getText(), "Keyword updated successfully.");		
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
            TestContext.getLogger().error(methodName);
            e.printStackTrace();
		}
		return this;	
	}

	
	
	
}