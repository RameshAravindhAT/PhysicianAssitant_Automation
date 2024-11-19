package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.ExtentReportManager;
import utils.TestContext;

public class PG_001_Login {

	WebDriver driver;
	WebDriverWait wait;

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
	
	@FindBy(xpath="(//p[contains(text(),'Recordings')])")
	WebElement recordingstabbutton;


	// Method to enter email
	public PG_001_Login enterEmail(String email) throws InterruptedException {
		 String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			emailField.sendKeys(email);
			  ExtentReportManager.reportStep(methodName + " " + email, "pass");
	            TestContext.getLogger().info(methodName + " " + email);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName + " " + email);
			e.printStackTrace();
		}
		return this;
	}

	// Method to enter password
	public PG_001_Login enterPassword(String password) throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			passwordField.sendKeys(password);
			ExtentReportManager.reportStep(methodName + " " + password, "pass");
	         TestContext.getLogger().info(methodName + " " + password);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName + " " + password);
			e.printStackTrace();
		}
		 
		return this;
	}
	// Method to click login button
	public PG_001_Login clickLoginButton() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            loginButton.click();
            ExtentReportManager.reportStep(methodName, "pass");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            
            e.printStackTrace();
            TestContext.getLogger().error(methodName);
        }
		return this;

	}

	
	

	public PG_001_Login verifytoastmessage(String testCaseType) throws InterruptedException {
		 String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		 try 
		 {
			 switch (testCaseType) {
				
				case "Positive":
					Thread.sleep(30000);
					OTPButton.click();
					TestContext.getWait().
					until(ExpectedConditions.visibilityOf(loginSuccessMessage));			
					Assert.assertEquals(loginSuccessMessage.getText(), "Login successful");
					break;

				case "Negative":
					TestContext.getWait().
					until(ExpectedConditions.visibilityOf(invalidcredentialsmessage));
					Assert.assertEquals(invalidcredentialsmessage.getText(), "Invalid ");
					 
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
		 
			 ExtentReportManager.reportStep(methodName, "pass");
	         TestContext.getLogger().info(methodName);
		 }
			 catch (Exception e) {
					
					e.printStackTrace();
					TestContext.getLogger().error(methodName);
				
		 }
		
		return this;
	}
	
	public PG_002_Recordings clickonrecordings() throws InterruptedException {
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
		return new PG_002_Recordings(driver);
	}
	
	
}
