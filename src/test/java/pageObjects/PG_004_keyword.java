package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestContext;

public class PG_004_keyword {
	
	public PG_004_keyword(WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}

	@FindBy(xpath = "//button[contains(text(),'Add Keyword')]")
	WebElement Addkeywordbutton;
	
	@FindBy(xpath = "//input[@name='keyword'])")
	WebElement keywordtextbox;
			
	@FindBy(xpath = "//textarea[@name='instruction')]")
	WebElement instructiontextbox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;
	
	
	@FindBy(xpath = "//div[@role='presentation']//div[2]//div[5]//div[1]//button[1]//*[name()='svg']")
	WebElement Editicon;
	
	
	@FindBy(xpath = "//input[@name='keyword']")
	WebElement clear;
	
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement updatebutton;
	
	
	@FindBy(xpath = "//div[@role='presentation']//div[2]//div[5]//div[1]//button[2]//*[name()='svg']")
	WebElement deleteicon;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement yesdelete;
	
	
}
