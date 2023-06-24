package shaip_base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import java.util.Collections;
import java.util.List;

import shaip_utilitiescomponents.ActionEngineShaip;
import shaip_utilitiescomponents.PropertiesOperationsShaip;

public class TestBaseShaip extends ActionEngineShaip {
	
	
	BrowserFactoryShaip bf = new BrowserFactoryShaip();
	public static WebDriverWait wait;
	public SoftAssert sa = new SoftAssert();

	


	public WebDriver LaunchShaipCloud() throws Exception {
		
		
		String browser = PropertiesOperationsShaip.getPropertyValueByKey("browser");
		String url = 	PropertiesOperationsShaip.getPropertyValueByKey("url");

		DriverFactoryShaip.getInstance().setDriver(bf.createBrowserInstance(browser));
		DriverFactoryShaip.getInstance().getDriver().manage().window().maximize();
		DriverFactoryShaip.getInstance().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(DriverFactoryShaip.getInstance().getDriver(), 50);
		DriverFactoryShaip.getInstance().getDriver().navigate().to(url);

		return DriverFactoryShaip.getInstance().getDriver();

	}

	public void tearDown() {
		
		DriverFactoryShaip.getInstance().closeBrowser();
	}
	
	
	
	//Common methods
	
	public void waitForVisibility(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitForVisibilityOfAll(List<WebElement> element) {

		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

	public void waitUntilClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void waitForProcessBarToGo() throws InterruptedException {

		
		WebElement processBar=DriverFactoryShaip.getInstance().getDriver().findElement(By.xpath("//div[contains(@class,'loader-wrapper')]//ancestor::shaip-loader"));
		if(wait.until(ExpectedConditions.visibilityOf(processBar)) != null) {
			System.out.println("processbar displayed");

		wait.until(ExpectedConditions.invisibilityOf(processBar));
		System.out.println("processbar gone");
		Thread.sleep(1000);

		}
	}
	
	public void clearText(WebElement element) throws InterruptedException {
		
		
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(Keys.chord(Keys.BACK_SPACE));

	}
	

	
	
}
