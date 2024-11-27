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

public class PG_001_Login extends BaseClass{
	String Loginmessage = "Login successful";
	public PG_001_Login(WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}

	// Locate elements using PageFactory annotations
	@FindBy(name = "email")
	WebElement emailField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement viewPasswordButton;

	@FindBy(xpath = "(//button[normalize-space()='Login'])[1]")
	WebElement loginButton;

	@FindBy(xpath = "//button[normalize-space()='Verify OTP']")
	WebElement OTPButton;

	@FindBy(xpath = "//div[text()='Login successful']")
	WebElement loginSuccessMessage;

	@FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
	WebElement invalidcredentialsmessage;

	@FindBy(xpath = "//p[contains(@id,'helper-text')]")
	WebElement Emailwarning;

	@FindBy(xpath = "//p[contains(@id,'helper-text')]")
	WebElement Passwordwarning;

	@FindBy(xpath = "(//p[contains(text(),'Recordings')])")
	WebElement recordingstabbutton;
	
	@FindBy(xpath = "(//p[contains(text(),'Keyword')])")
	WebElement keywordbutton;
	
	@FindBy(xpath="(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]")
	WebElement logouticon;
	
	@FindBy(xpath="//li[contains(text(),'Logout')]")
	WebElement logoutbutton;
	
	@FindBy(xpath="//p[contains(text(),'Teju')]")
	WebElement profilename;

	// Method to enter email
	public PG_001_Login Enter_Email(String email) throws InterruptedException {
		ExtentReportManager.reportStep("Opening the Browser", "Pass");
		ExtentReportManager.reportStep("Navigating to the URL"+properties.getProperty("url"), "pass");
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		
		try {
			emailField.sendKeys(email);
			ExtentReportManager.reportStep(methodName + " :: " + email, "pass");
			TestContext.getLogger().info(methodName + " :: " + email);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName + " :: " + email);
			e.printStackTrace();
		}
		return this;
		
		
	}

	// Method to enter password
	public PG_001_Login Enter_Password(String password) throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			passwordField.sendKeys(password);
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName + " :: " + password);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}

		return this;
	}

	// Method to click login button
	public PG_001_Login Click_on_Login_Button() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			Thread.sleep(3000);
			loginButton.click();
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {

			e.printStackTrace();
			TestContext.getLogger().error(methodName);
		}
		return this;

	}

	public PG_001_Login verify_toast_message(String testCaseType) throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		
		try {
			switch (testCaseType) {

			case "Positive":
				Thread.sleep(30000);
				OTPButton.click();
				TestContext.getWait().until(ExpectedConditions.visibilityOf(loginSuccessMessage));
				
				Assert.assertEquals(loginSuccessMessage.getText(), "Login successful");
				break;

			case "Negative":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(invalidcredentialsmessage));
				Assert.assertEquals(invalidcredentialsmessage.getText(), "Invalid Credentials");
				break;

			case "Emailwarning":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(Emailwarning));
				Assert.assertEquals(Emailwarning.getText(), "Email cannot be empty");
				break;

			case "Passwordwarning":
				TestContext.getWait().until(ExpectedConditions.visibilityOf(Passwordwarning));
				Assert.assertEquals(Passwordwarning.getText(), "Password cannot be empty");
				break;

			}

			ExtentReportManager.reportStep(methodName+ " :: " +Loginmessage, "pass");
			
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {

			e.printStackTrace();
			TestContext.getLogger().error(methodName);

		}

		return this;
	}

	public PG_002_Recordings click_on_recordings_tab() throws InterruptedException {
		Thread.sleep(15000);
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			recordingstabbutton.click();
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			e.printStackTrace();
			TestContext.getLogger().error(methodName);
		}
		return new PG_002_Recordings(TestContext.getDriver());
	}
	
	public PG_002_Recordings click_on_Keyword_tab() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			keywordbutton.click();
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
			}catch (Exception e) {
				e.printStackTrace();
				TestContext.getLogger().error(methodName);
			}
			return new PG_002_Recordings(TestContext.getDriver());
		}
		
	
	public  PG_003_Logout  click_on_logout() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
	Assert.assertEquals(profilename.getText(), "Teju");
	Thread.sleep(2000);
	TestContext.getWait().until(ExpectedConditions.elementToBeClickable(logouticon)).click();
	Thread.sleep(2000);
	TestContext.getWait().until(ExpectedConditions.elementToBeClickable(logoutbutton)).click();
	Thread.sleep(3000);
	ExtentReportManager.reportStep(methodName, "pass");
	TestContext.getLogger().info(methodName);
		} catch (Exception e) {

			e.printStackTrace();
			TestContext.getLogger().error(methodName);
		}
		return new PG_003_Logout(TestContext.getDriver());

	}

}
