package pageObjects;

//Testing Purpose


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_007_Recordingfilepage extends BaseClass {

	public PG_007_Recordingfilepage(WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}

	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[4]")
	WebElement more;

	@FindBy(xpath = "(//*[name()='svg'][@data-testid='EditIcon'])[1]")
	WebElement Editicon;

	@FindBy(xpath = "//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary')]//textarea")
	WebElement Editbox;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelbutton;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement Nextbutton;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebutton;

	@FindBy(xpath = "//button[text()='No']")
	WebElement Nobutton;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesbutton;

	@FindBy(xpath = "//div[text()='Note updated successfully.']")
	WebElement Updatednotestoastmessage;

	@FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
	WebElement approvaltoastmessage;

	@FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
	WebElement doctoracceptmessage;

	@FindBy(xpath = "//div[contains(text(),'All Content copied to clipboard')]")
	WebElement Copiedmessage;

	@FindBy(xpath = "(//*[name()='svg'][@data-testid='SendIcon'])")
	WebElement sendbutton;

	@FindBy(xpath = "(//*[name()='svg'][@data-testid='MicIcon'])")
	WebElement Micbutton;

	@FindBy(xpath = "//button[text()='Undo']")
	WebElement undobutton;

	@FindBy(xpath = "//button[contains(text(),'Comments')]")
	WebElement commentstab;

	@FindBy(xpath = "//textarea[contains(@placeholder,'Type message....')]")
	WebElement commentstextbox;

	@FindBy(xpath = "//*[name()='svg'][@data-testid='PauseIcon']")
	WebElement pausebutton;

	@FindBy(xpath = "(//*[name()='svg'][@data-testid='ArrowDropDownIcon'])[1]")
	WebElement versiondropdownarrow;

	@FindBy(xpath = "(//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root')])[1]")
	WebElement selectversionnumber;
		
	@FindBy(xpath = "//div[contains(@class,'_icon_')]")
	WebElement backarrow;
	

	public PG_007_Recordingfilepage update_patient_name() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			Thread.sleep(3000);
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(Editicon)).click();
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(Editbox)).sendKeys(Keys.CONTROL + "a");
			Editbox.sendKeys(Keys.DELETE);
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(Editbox)).sendKeys("Martin Mathew");
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(Nextbutton)).click();
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(savebutton)).click();
			/*
			 * //go back confirmation backarrow.click(); savebutton.click();
			 */
			// save preview
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(savebutton)).click();
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(yesbutton)).click();
			TestContext.getWait().until(ExpectedConditions.visibilityOf(Updatednotestoastmessage));
			Assert.assertEquals(Updatednotestoastmessage.getText(), "Note updated successfully.");
			// TestContext.getWait().until(ExpectedConditions.elementToBeClickable(undobutton)).click();
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;
	}

	public PG_007_Recordingfilepage Copy_and_Paste_in_comments() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		String moreicon = "Copy All";
		try {
			Thread.sleep(5000);
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(more)).click();
			List<WebElement> moreoptions = TestContext.getDriver()
					.findElements((By.xpath("//ul[@aria-labelledby='basic-button']/li")));
			for (WebElement webelement : moreoptions) {
				if (webelement.getText().equals(moreicon)) {
					webelement.click();
					TestContext.getWait().until(ExpectedConditions.visibilityOf(Copiedmessage));
					Assert.assertEquals(Copiedmessage.getText(), "All Content copied to clipboard");
					Thread.sleep(2000);
					commentstab.click();
					TestContext.getWait().until(ExpectedConditions.elementToBeClickable(commentstextbox))
							.sendKeys(Keys.CONTROL + "v");
					TestContext.getWait().until(ExpectedConditions.visibilityOf(sendbutton)).click();
				}
			}
			ExtentReportManager.reportStep(methodName + " :: " + Copiedmessage, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}

		return this;
	}

	public PG_007_Recordingfilepage Send_for_approval() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		String expectedData = "doctor approval pending";
		String moreicon = "Send for Approval";
		try {
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(more)).click();
			List<WebElement> moreoptions = TestContext.getDriver()
					.findElements((By.xpath("//ul[@aria-labelledby='basic-button']/li")));
			for (WebElement webelement : moreoptions) {
				if (webelement.getText().equals(moreicon)) {
					webelement.click();
					TestContext.getWait().until(ExpectedConditions.elementToBeClickable(yesbutton)).click();
					TestContext.getWait().until(ExpectedConditions.visibilityOf(approvaltoastmessage));
					Assert.assertEquals(approvaltoastmessage.getText(), "Final version for recording marked.");
					Thread.sleep(5000);
					String xpath = "(//div[contains(@class,'MuiStack-root')])[2]//p[text()='File status :']/following-sibling::p[text()='"
							+ expectedData + "']";
					String text = TestContext.getDriver().findElement(By.xpath(xpath)).getText();
					System.out.println(text);
					Assert.assertEquals(text, "Doctor Approval Pending");

				}
			}
			// Log overall success
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (StaleElementReferenceException e) {
			// Log any errors encountered during execution
			WebElement element = TestContext.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//div[contains(@class,'MuiStack-root')])[2]//p[text()='File status :']/following-sibling::p[text()='"
							+ expectedData + "']")));
			String actualText = element.getText().toLowerCase(); // Normalize case
			String expectedText = expectedData.trim().toLowerCase(); // Normalize case
			Assert.assertEquals(actualText, expectedText);
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;
	}

	public PG_007_Recordingfilepage Mark_as_complete() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		String expectedData = "doctor accepted";
		String moreicon = "Mark as Complete";
		try {
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(more)).click();
			List<WebElement> moreoptions = TestContext.getDriver()
					.findElements((By.xpath("//ul[@aria-labelledby='basic-button']/li")));
			for (WebElement webelement : moreoptions) {
				if (webelement.getText().equals(moreicon)) {
					webelement.click();
					TestContext.getWait().until(ExpectedConditions.elementToBeClickable(yesbutton)).click();
					TestContext.getWait().until(ExpectedConditions.visibilityOf(doctoracceptmessage));
					Assert.assertEquals(doctoracceptmessage.getText(), "Doctor accept.");
					Thread.sleep(4000);
					String xpath = "(//div[contains(@class,'MuiStack-root')])[2]//p[text()='File status :']/following-sibling::p[text()='"
							+ expectedData + "']";
					String text = TestContext.getDriver().findElement(By.xpath(xpath)).getText();
					System.out.println(text);
					Assert.assertEquals(text, "Doctor Accepted");
				}
			}
			// Log overall success
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			WebElement element = TestContext.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//div[contains(@class,'MuiStack-root')])[2]//p[text()='File status :']/following-sibling::p[text()='"
							+ expectedData + "']")));
			String actualText = element.getText().toLowerCase(); // Normalize case
			String expectedText = expectedData.trim().toLowerCase(); // Normalize case
			Assert.assertEquals(actualText, expectedText);
			TestContext.getLogger().error(methodName);
			ExtentReportManager.reportStep(methodName, "pass");
			e.printStackTrace();
		}
		return this;
	}

	public PG_007_Recordingfilepage commentstab() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			Thread.sleep(3000);
			commentstab.click();
			commentstextbox.sendKeys("hey doctor! i have edited the current version and check for approval");
			sendbutton.click();
			Micbutton.click();
			Thread.sleep(10000);
			pausebutton.click();
			Thread.sleep(5000);
			sendbutton.click();

			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.reportStep(methodName, "fail");
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;
	}

	public PG_007_Recordingfilepage selectversion() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			Thread.sleep(5000);
			versiondropdownarrow.click();
			Thread.sleep(3000);
			selectversionnumber.click();
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

}
