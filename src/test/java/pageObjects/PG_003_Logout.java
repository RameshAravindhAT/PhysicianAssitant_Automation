package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestContext;

public class PG_003_Logout {
	
	public PG_003_Logout(WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}
	
	@FindBy(xpath="(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]")
	WebElement logouticon;
	
	@FindBy(xpath="//li[contains(text(),'Logout')]")
	WebElement logoutbutton;
	
	@FindBy(xpath="//p[contains(text(),'Teju')]")
	WebElement profilename;
	
	
	

}
