package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_004_Addkeyword extends BaseClass{
	
	public PG_004_Addkeyword (WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}

	@FindBy(xpath = "(//button[normalize-space()='Add Keyword'])[1]")
	WebElement Addkeywordbutton;
	
	@FindBy(xpath = "//div[contains(@class, 'MuiInputBase-root') and contains(@class, 'MuiOutlinedInput-root')]//input[@name='keyword' and @type='text']")
	WebElement keywordtextbox;
			
	@FindBy(xpath = "//textarea[@name='instruction']")  
	WebElement instructiontextbox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;
	
	@FindBy(xpath = "//div[contains(text(),'Keyword added successfully.')]")
	WebElement Addedmessage;
	
	@FindBy(xpath = "//div[contains(text(),'Keyword already in use.')]")
	WebElement usedkeywordmessage;
	
	@FindBy(xpath = "//p[contains(@id,':rdn:-helper-text')]")
	WebElement KeywordEmpty;
	
	@FindBy(xpath = "//p[contains(@id,':rdn:-helper-text')]")
	WebElement instructionEmpty;
	
	@FindBy(xpath = "//p[contains(text(),'keyword is required')]")
	WebElement Requiredkeyword;
		
	@FindBy(xpath = "//p[contains(text(),'Instruction is required')]")
	WebElement Requiredinstruction;
	
	@FindBy(xpath = "//p[contains(text(),'//p[contains(text(),'keyword must be greater than 3')]'")
	WebElement keywordtextimit;
	
	@FindBy(xpath = "//p[contains(text(),'//p[contains(text(),'//p[contains(text(),'Instruction must be greater than 3')]")
	WebElement instructiontextimit;
	
	@FindBy(xpath = "(//*[name()='svg'][@data-testid='EditIcon'])[1]")
	WebElement Editicon;
	

	public PG_004_Addkeyword click_on_add_keyword() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {
			Thread.sleep(10000);
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(Addkeywordbutton)).click();		
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
            TestContext.getLogger().error(methodName);
            e.printStackTrace();
		}
		return this;	
	}
	
	public PG_004_Addkeyword Enter_data_in__keywordtextbox(String Keywordtext) throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {	
			Thread.sleep(3000);	
			keywordtextbox.sendKeys(Keywordtext);	
			Thread.sleep(3000);		
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
            TestContext.getLogger().error(methodName);
            e.printStackTrace();
		}
		return this;	
	}
	
	public PG_004_Addkeyword Enter_data_in__instructiontextbox(String instructiontext) throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {
			instructiontextbox.sendKeys(instructiontext);
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
            TestContext.getLogger().error(methodName);
            e.printStackTrace();
		}
		return this;	
	}
	
	public PG_004_Addkeyword click_on_submit_button() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {
			submitbutton.click();	
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
            TestContext.getLogger().error(methodName);
            e.printStackTrace();
		}
		return this;	
	}
		
	public PG_004_Addkeyword verify_keyword_toast_message(String testCaseType) throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			switch (testCaseType) {

			case "Positive":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(Addedmessage));
				Assert.assertEquals(Addedmessage.getText(), "Keyword added successfully.");
				break;

			case "Negative":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(usedkeywordmessage));
				Assert.assertEquals(usedkeywordmessage.getText(), "Keyword already in use.");
				break;
			

			case "Emptykeyword":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(Requiredkeyword));
				Assert.assertEquals(Requiredkeyword.getText(), "keyword is required");
				break;
				
			case "Emptyinstruction":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(Requiredinstruction));
				Assert.assertEquals(Requiredinstruction.getText(), "Instruction is required");
				break;
				
				
			case "Keywordlimit":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(keywordtextimit));
				Assert.assertEquals(keywordtextimit.getText(), "keyword must be greater than 3");
				break;

			case "instructionlimit":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(instructiontextimit));
				Assert.assertEquals(instructiontextimit.getText(), "Instruction must be greater than 3");
				break;
			}

			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			 ExtentReportManager.reportStep(methodName, "fail");
	            TestContext.getLogger().error(methodName);
	            e.printStackTrace();

		}

		return this;
	}
	
	public PG_005_Editkeyword click_on_edit_icon() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");		
		try {
			Thread.sleep(3000);
			Editicon.click();						
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			 ExtentReportManager.reportStep(methodName, "fail");
	            TestContext.getLogger().error(methodName);
	            e.printStackTrace();
		}
		return new PG_005_Editkeyword(TestContext.getDriver());	
	}
	
	
}
