package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PG_002_Recordings {

	WebDriver driver;
	WebDriverWait wait;
	String targetMonthYear = "September 2024";
	String targetdate = "11";
	String targetyear = "2024";

	public PG_002_Recordings(WebDriver driver) {
		this.driver = driver;
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

	@FindBy(xpath = "//p[starts-with(text(),'REC-1776')]")
	WebElement viewrecording;

	@FindBy(xpath = "(//*[contains(@data-testid,'EditIcon')])[1]")
	WebElement Editicon;

	@FindBy(xpath = "//div[contains(@class, 'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-multiline')]")
	WebElement Editbox;

	public PG_002_Recordings clickonrefresh() throws InterruptedException {
		Thread.sleep(2000);
		refreshbutton.click();
		return this;
	}

	public PG_002_Recordings clickonreset() {
		Resetbutton.click();
		return this;
	}

	public PG_002_Recordings clickondoctorsdropdown() {
		doctorsdropdownbutton.click();
		return this;
	}

	public PG_002_Recordings clickcleardateicon() {
		cleardate.click();
		return this;
	}

	public PG_002_Recordings clickonviewrecording() {
		viewrecording.click();
		return this;
	}

	public PG_002_Recordings clickonEditicon() throws InterruptedException {
		Thread.sleep(10000);
		Editicon.click();
		return this;
	}

	public PG_002_Recordings selectdoctor() {
		List<WebElement> doctoroptions = driver.findElements((By.xpath("//ul[@role='listbox']/li")));
		for (WebElement webelement : doctoroptions) {
			if (webelement.getText().trim().equals("Teju two")) {
				webelement.click();
				break;
			}
		}
		return this;

	}

	public PG_002_Recordings selectdateincalender() throws InterruptedException {
		calendericon.click();
		yearbutton.click();
		driver.findElement(By.xpath("//button[contains(text(),'" + targetyear + "')]")).click();
		while (true) {
			// Get the currently displayed month and year
			String currentMonthYear = driver.findElement(By.xpath("//div[contains(@id,'grid-label')]")).getText();
			if (currentMonthYear.equals(targetMonthYear)) {
				break;
			} else {
				// Navigate to previous or next month depending on the target
				if (currentMonthYear.compareTo(targetMonthYear) > 0) {
					previousmonth.click();
				} else {
					Nextmonth.click();
				}
			}
		}
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//button[normalize-space()='" + targetdate + "']")).click();
		return this;
	}

	public PG_002_Recordings Enterdataineditbox() {
		Editbox.clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class, 'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-multiline')]")))
				.sendKeys("JoeThomas");
		return this;
	}
}
