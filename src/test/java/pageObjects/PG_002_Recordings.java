package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_002_Recordings extends BaseClass{
	
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

	public PG_002_Recordings click_on_reset() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {

			refreshbutton.click();
			Resetbutton.click();
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			 ExtentReportManager.reportStep(methodName, "fail");
	            TestContext.getLogger().error(methodName);
	            e.printStackTrace();
		}
		return this;
	}

	public PG_002_Recordings Select_doctor(String DoctorName) {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			Thread.sleep(2000);
			doctorsdropdownbutton.click();
			List<WebElement> doctoroptions = TestContext.getDriver()
					.findElements((By.xpath("//ul[@role='listbox']/li")));
			  for (WebElement webelement : doctoroptions) {
		            if (webelement.getText().equals(DoctorName)) {
		                webelement.click();
		            }
			  }
		
			ExtentReportManager.reportStep(methodName + " :: " + DoctorName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			 ExtentReportManager.reportStep(methodName, "fail");
	            TestContext.getLogger().error(methodName);
	            e.printStackTrace();
		}

		return this;
	}

	/*
	 * public PG_002_Recordings select_date(String Targetdate) throws
	 * InterruptedException { String methodName =
	 * Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
	 * try {
	 * 
	 * SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
	 * SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy"); Date
	 * date = inputFormat.parse(Targetdate); String formattedDate =
	 * outputFormat.format(date); // Split the target date into parts (e.g.,
	 * "27 September 2024") String[] parts = formattedDate.split(" "); String
	 * targetDay = parts[0]; // 27 String targetMonthYear = parts[1] + " " +
	 * parts[2]; // September 2024 String targetYear = parts[2]; // 2024
	 * calendericon.click(); Thread.sleep(3000); yearbutton.click(); WebElement
	 * targetYearElement = TestContext.getDriver()
	 * .findElement(By.xpath("//	button[contains(text(),'" + targetYear +
	 * "')]")); targetYearElement.click(); Thread.sleep(3000); // Navigate to the
	 * correct month while (true) { String currentMonthYear =
	 * TestContext.getDriver()
	 * .findElement(By.xpath("//div[contains(@id,'grid-label')]")).getText();
	 * 
	 * if (currentMonthYear.equals(targetMonthYear)) { break; // Correct month-year
	 * found } // Determine direction for navigation WebElement navigationButton =
	 * currentMonthYear.compareTo(targetMonthYear) > 0 ? Nextmonth : previousmonth;
	 * TestContext.getWait().until(ExpectedConditions.elementToBeClickable(
	 * navigationButton)).click(); }
	 * 
	 * Thread.sleep(3000); WebElement targetDateElement = TestContext.getDriver()
	 * .findElement(By.xpath("//button[normalize-space()='" + targetDay + "']"));
	 * targetDateElement.click(); Thread.sleep(2000);
	 * 
	 * // Log the selected date String selectedDate = Targetdate;
	 * ExtentReportManager.reportStep("Selected date: " + selectedDate, "pass");
	 * TestContext.getLogger().info(methodName);
	 * 
	 * } catch (Exception e) { TestContext.getLogger().error(methodName);
	 * e.printStackTrace(); } return this; }
	 */

	
	public PG_002_Recordings select_date() throws InterruptedException { 
	    String targetMonthYear = "September 2024"; 
	    String targetdate = "27"; 
	    String targetyear = "2024"; 
	    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
	    
	    try { 
	        calendericon.click(); 
	        Thread.sleep(3000); 
	        yearbutton.click(); 
	        
	        // Select the target year 
	        WebElement targetYearElement = TestContext.getDriver()
	                .findElement(By.xpath("//button[contains(text(),'" + targetyear + "')]")); 
	        targetYearElement.click(); 
	        Thread.sleep(5000); 
	        
	        // Loop to navigate to the correct month
	        while (true) { 
	            String currentMonthYear = TestContext.getDriver()
	                    .findElement(By.xpath("//div[contains(@id,'grid-label')]")).getText();	            
	            if (currentMonthYear.equals(targetMonthYear)) { 
	                break; // Target month-year is displayed, exit loop
	            } 	            
	            // Determine navigation direction 
	            WebElement navigationButton = currentMonthYear.compareTo(targetMonthYear) > 0 ? Nextmonth : previousmonth;
	            TestContext.getWait().until(ExpectedConditions.elementToBeClickable(navigationButton)).click(); 
	        } 	        
	        Thread.sleep(3000); 
	        
	        // Select the target date
	        WebElement targetDateElement = TestContext.getDriver()
	                .findElement(By.xpath("//button[normalize-space()='" + targetdate + "']"));
	        targetDateElement.click(); 
	        Thread.sleep(2000); 
	        
	        String selectedDate = targetdate + " " + targetMonthYear;
	        ExtentReportManager.reportStep("Selected date: " + selectedDate, "pass");
	        TestContext.getLogger().info(methodName);
	        
	    } catch (Exception e) {
	    	 ExtentReportManager.reportStep(methodName, "fail");
	            TestContext.getLogger().error(methodName);
	            e.printStackTrace();
	    } 
	    
	    return this;
	}

	public PG_002_Recordings click_on_view_recording() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			TestContext.getWait()
					.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//div[@class='MuiDataGrid-row'])[1]//div[@data-field='actions']//button")))
					.click();
			Thread.sleep(6000);
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			 ExtentReportManager.reportStep(methodName, "fail");
	            TestContext.getLogger().error(methodName);
	            e.printStackTrace();
		}
		return this;
	}

	public PG_007_Recordingfilepage validate_recording_File_fields() {
		String[] expectedData = { "Teju two", "REC-1774", "scribe review pending" };
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			// Validate that the array has all required values
			if (expectedData == null || expectedData.length != 3) {
				throw new IllegalArgumentException(
						"Expected data must contain exactly three values: [DoctorName, RecordingCode, FileStatus]");
			}
			// Map of field names to their corresponding dynamic XPath templates
			String[] xpaths = {
					"(//div[contains(@class,'MuiStack-root')])[2]//p[text()='Dr. 'and '" + expectedData[0] + "' ]", // DoctorName

					"(//div[contains(@class,'MuiStack-root')])[2]//p[text()='Recording id : ' and '" + expectedData[1]
							+ "']", // RecordingCode

					"(//div[contains(@class,'MuiStack-root')])[2]//p[text()='File status :']/following-sibling::p[text()='"
							+ expectedData[2] + "']" };
			// Validate each field
			for (int i = 0; i < xpaths.length; i++) {
				WebElement element = TestContext.getWait()
						.until(ExpectedConditions.elementToBeClickable(By.xpath(xpaths[i])));
				String actualText = element.getText().replaceAll("(?i)dr\\. |recording id :|file status :", "").trim()
						.toLowerCase(); // Remove prefixes and normalize case
				String expectedText = expectedData[i].trim().toLowerCase(); // Normalize case
				Assert.assertEquals(actualText, expectedText);
			}
			// Log overall success
			ExtentReportManager.reportStep(methodName, "pass");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			// Log any errors encountered during execution
			TestContext.getLogger().error(methodName);
			e.printStackTrace();
		}
		return new PG_007_Recordingfilepage(TestContext.getDriver());
	}


}
