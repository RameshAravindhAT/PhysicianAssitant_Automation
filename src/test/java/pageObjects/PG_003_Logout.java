package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.ExtentReportManager;
import utils.TestContext;

public class PG_003_Logout {
	
	public PG_003_Logout(WebDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements
	}
	

	public PG_003_Logout Verify_the_URL(){
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
    {
        try {
            
                String currentUrl = TestContext.getDriver().getCurrentUrl();
                Assert.assertEquals(currentUrl, "https://pa.portal.ndproject.dev/");
            
            ExtentReportManager.reportStep(methodName+" "+currentUrl , "pass");
            TestContext.getLogger().info(methodName); 
        } catch (Exception e) {
            TestContext.getLogger().error(methodName);

            // e.printStackTrace();
        }
        return this;
    }
    }
}

