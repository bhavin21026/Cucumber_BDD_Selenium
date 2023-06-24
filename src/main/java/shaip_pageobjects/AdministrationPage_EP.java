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

import shaip_base.DriverFactoryShaip;
import shaip_base.TestBaseShaip;

public class AdministrationPage_EP extends TestBaseShaip {

	public AdministrationPage_EP() {

		wait = new WebDriverWait(DriverFactoryShaip.getInstance().getDriver(), 30);
		PageFactory.initElements(DriverFactoryShaip.getInstance().getDriver(), this);

	}

	@FindBy(xpath = "//div[contains(@class,'mat-menu-content')]")
	WebElement subMenuContent;
	
	
	public void selectAdministrationSubMenu(String submenu) throws InterruptedException
	
	{
		Thread.sleep(1000);	
		List<WebElement> subMenues=DriverFactoryShaip.getInstance().getDriver().findElements(By.xpath("//div[@role='menu']//child::button"));
		
		for (int i = 0; i < subMenues.size(); i++) {

			String menu = subMenues.get(i).getText().replaceAll("\r\n", " ").replaceAll("\r", " ").replaceAll("\n", " ");
			System.out.println(menu);
			//String[] menues = menu.split(" ");
			//String menuName = menues[1];
			
			if(menu.contains(submenu)) 
			
			{
				click_custom(subMenues.get(i), submenu);
				break;
			}
		
		
		
	}
		
	}
}
	
	
	

	

	
