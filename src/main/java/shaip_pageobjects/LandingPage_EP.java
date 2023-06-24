package shaip_pageobjects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import shaip_base.DriverFactoryShaip;
import shaip_base.ExtentFactoryShaip;
import shaip_base.TestBaseShaip;

public class LandingPage_EP extends TestBaseShaip {

	public LandingPage_EP() {

		wait = new WebDriverWait(DriverFactoryShaip.getInstance().getDriver(), 30);
		PageFactory.initElements(DriverFactoryShaip.getInstance().getDriver(), this);

	}

	@FindBy(xpath = "//a[contains(text(),'shaip.com')]/parent::div")
	WebElement copyRights;

	@FindBy(xpath = "//a[text()='shaip.com']")
	WebElement shaipURI;

	public void verifyCopyRights() {

		waitForVisibility(copyRights);
		waitUntilClickable(copyRights);

		sa.assertTrue(isElementPresent_custom(copyRights, "CopyRightText"));
	}

	public void verifyShaipURI() throws InterruptedException {

		Thread.sleep(1000);
		waitForVisibility(shaipURI);
		waitUntilClickable(shaipURI);
		String URI = getText_custom(shaipURI, "Shaip URI");
		System.out.println("Shaip URI verification completed and URI is--->  " + URI);
		// click_custom(shaipURI, "URI");

	}

	public void verifyMenuPermissions(String user) {

		Set<String> tenantListOfMenus = new HashSet<String>(Arrays.asList("Dashboard", "Projects", "Notifications"));
		Set<String> vendorAdminListOfMenus = new HashSet<String>(Arrays.asList("Dashboard", "Notifications"));
		Set<String> customerAdminListOfMenus = new HashSet<String>(Arrays.asList("Dashboard", "Notifications"));

		List<WebElement> sidebar = DriverFactoryShaip.getInstance().getDriver()
				.findElements(By.xpath("//div[@class='sidebar-menu-items']//div[@class='mat-list-item-content']"));

		for (int i = 0; i < (sidebar.size()) - 2; i++) {

			String menu = sidebar.get(i).getText().replaceAll("\r\n", " ").replaceAll("\r", " ").replaceAll("\n", " ");

			String[] menues = menu.split(" ");
			String menuName = menues[1];

			if (user.equalsIgnoreCase("parth.parikh@shaip.com") && !tenantListOfMenus.contains(menuName))

			{
				sa.assertFalse(true);

			} else if (user.equalsIgnoreCase("c.orac@yopmail.com") && !customerAdminListOfMenus.contains(menuName)) {

				sa.assertFalse(false);

			} else if (user.equalsIgnoreCase("dkak@bitesatlanta.com") && !vendorAdminListOfMenus.contains(menuName)) {


				sa.assertFalse(false);

			}
			sa.assertAll();

		}

	}
	
	
	public void clickOnMenu(String menuToBeClicked) throws InterruptedException {
		
		Thread.sleep(2000);

		List<WebElement> sidebar = DriverFactoryShaip.getInstance().getDriver()
				.findElements(By.xpath("//div[@class='sidebar-menu-items']//div[@class='mat-list-item-content']"));

		for (int i = 0; i < (sidebar.size()) - 1; i++) {

			String menu = sidebar.get(i).getText().replaceAll("\r\n", " ").replaceAll("\r", " ").replaceAll("\n", " ");

			String[] menues = menu.split(" ");
			String menuName = menues[1];
			
			if(menuName.contains(menuToBeClicked)) 
			
			{
				click_custom(sidebar.get(i), menuToBeClicked);
				
				System.out.println("Menu admin clicked");
				break;
			}
			

	}
		
	
	}	
}