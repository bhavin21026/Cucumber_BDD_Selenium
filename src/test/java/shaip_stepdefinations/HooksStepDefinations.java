package shaip_stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import shaip_base.BrowserFactoryShaip;
import shaip_base.DriverFactoryShaip;
import shaip_utilitiescomponents.PropertiesOperationsShaip;

public class HooksStepDefinations {
	
	
	BrowserFactoryShaip bf = new BrowserFactoryShaip();
	public static WebDriverWait wait;
	public static WebDriver driver;
	public SoftAssert sa = new SoftAssert();

	
	
	

	@After
	public void tearDown() {
		
		DriverFactoryShaip.getInstance().closeBrowser();
	}
	
	

}
