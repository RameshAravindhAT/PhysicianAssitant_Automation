package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import utils.ExtentReportManager;
import utils.TestContext;

public class PG_002_Recordings {

	String targetMonthYear = "September 2024";
	String targetdate = "27";
	String targetyear = "2024";
	
	public PG_002_Recordings(WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}

	@FindBy(xpath = "(//*[name()='svg'][@aria-label='Refresh'])[1]")
	WebElement refreshbutton;

	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	WebElement Resetbutton;

	@FindBy(xpath = "//div[contains(text(),'All Doctors')]")
	WebElement doctorsdropdownbutton;

	@FindBy(xpath = "(//button[@aria-label='Choose date'])[1]")
	WebElement calendericon;

	@FindBy(xpath = "//button[@aria-label='calendar view is open, switch to year view']")
	WebElement yearbutton;

	@FindBy(xpath = "(//button[@title='Previous month'])[1]")
	WebElement previousmonth;

	@FindBy(xpath = "//button[@title='Next month']")
	WebElement Nextmonth;

	@FindBy(xpath = "//button[@title='Clear value']")
	WebElement cleardate;

	/*
	 * @FindBy(xpath = "//p[contains(text(),'REC-1782')]") WebElement REcordingcode;
	 */

	@FindBy(xpath = "(//p[text()='REC-1782']//following::button)[1])")
	WebElement viewrecording;

	@FindBy(xpath = "(//div[@data-field='doctor_name']//div[contains(text(),'Teju two')])[1]")
	WebElement doctorname;

	@FindBy(xpath = "(//span[contains(text(),'scribe review pending')])[1]")
	WebElement Recordingstatus;

	@FindBy(xpath = "//div//p[contains(text(),'scribe review pending')]")
	WebElement filestatus;

	@FindBy(xpath = "(//div[contains(@class, 'MuiStack-root')])[1]//following::p[contains(normalize-space(),'Dr. Teju two')]")
	WebElement validateDoctorname;

	@FindBy(xpath = "(//div[contains(@class, 'MuiStack-root')])[1]//following::p[contains(normalize-space(),'Recording id : REC-1782')]")
	WebElement validateReccode;

	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[4]")
	WebElement moreicon;
	
	
	
	
	/*
	 * @FindBy(xpath = "//p[starts-with(text(),'REC-1776')]") WebElement
	 * viewrecording;
	 */

	@FindBy(xpath = "(//*[contains(@data-testid,'EditIcon')])[1]")
	WebElement Editicon;

	@FindBy(xpath = "//div[contains(@class, 'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-multiline')]")
	WebElement Editbox;

	/*
	 * public PG_002_Recordings clickonrefresh() throws InterruptedException {
	 * String methodName =
	 * Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
	 * try { Thread.sleep(2000); refreshbutton.click();
	 * ExtentReportManager.reportStep(methodName, "pass");
	 * TestContext.getLogger().info(methodName); } catch (Exception e) {
	 * TestContext.getLogger().error(methodName); e.printStackTrace(); } return
	 * this; }
	 */

	public PG_002_Recordings click_on_reset() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			refreshbutton.click();
			Resetbutton.click();
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;
	}

	public PG_002_Recordings Select_doctor(String DoctorName) {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			doctorsdropdownbutton.click();
			List<WebElement> doctoroptions = TestContext.getDriver()
					.findElements((By.xpath("//ul[@role='listbox']/li")));
			for (WebElement webelement : doctoroptions) {
				if (webelement.getText().trim().equals(DoctorName)) {
					webelement.click();
					break;
				}
			}
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;
	}

	public PG_002_Recordings select_date_in_calender() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			calendericon.click();
			Thread.sleep(4000);
			yearbutton.click();
			TestContext.getDriver().findElement(By.xpath("//button[contains(text(),'" + targetyear + "')]")).click();
			Thread.sleep(4000);
			while (true) {
				// Get the currently displayed month and year
				String currentMonthYear = TestContext.getDriver()
						.findElement(By.xpath("//div[contains(@id,'grid-label')]")).getText();
				if (currentMonthYear.equals(targetMonthYear)) {
					break;
				} else {
					// Navigate to previous or next month depending on the target
					if (currentMonthYear.compareTo(targetMonthYear) > 0) {
						previousmonth.click();
						Thread.sleep(2000);
					} else {
						
						Nextmonth.click();
					}
				}
			}
			Thread.sleep(3000);
			TestContext.getDriver().findElement(By.xpath("//button[normalize-space()='" + targetdate + "']")).click();
			Thread.sleep(5000);
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {

			e.printStackTrace();
			TestContext.getLogger().error(methodName);
		}
		return this;
	}

	/*
	 * public PG_002_Recordings clickcleardateicon() { String methodName =
	 * Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
	 * try {
	 * 
	 * 
	 * cleardate.click(); ExtentReportManager.reportStep(methodName, "pass");
	 * TestContext.getLogger().info(methodName); } catch (Exception e) {
	 * TestContext.getLogger().error(methodName); e.printStackTrace(); } return
	 * this; }
	 */

	public PG_002_Recordings click_on_view_recording() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(viewrecording)).click();
		} catch (Exception e) {
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;
	}

	public PG_002_Recordings validateDynamicData( ) {
		String[] data1 = { "Teju two", "REC-1782","scribe review pending"  };
	    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
	    try {
	        // Ensure `data` is valid and contains all required fields
	        if (data1 == null || data1.length != 3) {
	            throw new IllegalArgumentException("Data array must contain exactly three values: [DoctorName, FileStatus, RecCode]");
	        }

	        // Array of XPaths to validate
	        String[] xpaths = {
	            "(//div[contains(@class,'MuiStack-root')])[2]//p[text()='" + data1[0] + "']", // DoctorName
	            
	        "//p[contains(@class, 'MuiTypography-body1') and starts-with(text(), 'Recording id : '" + data1[2] + "'') " ,// RecCode
	        "//p[contains(@class, 'MuiTypography-root MuiTypography') and starts-with(text(), 'File status : '" + data1[1] + "'')" // FileStatus
	        };

	        // Loop through XPaths and validate
	        for (int i = 0; i < xpaths.length; i++) {
	            // Locate the element using the current XPath
	            WebElement element = TestContext.getDriver().findElement(By.xpath(xpaths[i]));

	            // Assert the element is displayed
	            Assert.assertTrue(element.isDisplayed(), "Element not displayed for XPath: " + xpaths[i]);

	            // Log success for each element
	            String fieldName = (i == 0) ? "DoctorName" : (i == 1) ? "FileStatus" : "RecCode";
	            ExtentReportManager.reportStep("Validated " + fieldName + ": " + data1[i], "pass");
	            TestContext.getLogger().info("Validated " + fieldName + ": " + data1[i]);
	        }

	        // Log overall success
	        ExtentReportManager.reportStep(methodName, "pass");
	        TestContext.getLogger().info(methodName);

	    } catch (Exception e) {
	        // Log the error with context
	        TestContext.getLogger().error("Error in " + methodName + ": " + e.getMessage());
	        e.printStackTrace();
	    }

	    return this;
	}


	public PG_002_Recordings click_on_Editicon() throws InterruptedException {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {

			Thread.sleep(10000);
			Editicon.click();
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;
	}

	/*
	 * public PG_002_Recordings select_doctor() { String methodName =
	 * Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
	 * try { List<WebElement> doctoroptions =
	 * TestContext.getDriver().findElements((By.xpath("//ul[@role='listbox']/li")));
	 * for (WebElement webelement : doctoroptions) { if
	 * (webelement.getText().trim().equals("Teju two")) { webelement.click(); break;
	 * } } ExtentReportManager.reportStep(methodName, "pass");
	 * TestContext.getLogger().info(methodName); } catch (Exception e) {
	 * TestContext.getLogger().error(methodName); e.printStackTrace(); } return
	 * this;
	 * 
	 * }
	 */

	public PG_002_Recordings Enterdataineditbox() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			Editbox.clear();
			TestContext.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[contains(@class, 'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-multiline')]")))
					.sendKeys("JoeThomas");
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return this;
	}
}
