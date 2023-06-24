package shaip_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shaip_base.DriverFactoryShaip;
import shaip_base.TestBaseShaip;

public class LoginPage_EP extends TestBaseShaip {
	
	public static WebDriver webdrivers;

	public LoginPage_EP() {

		wait = new WebDriverWait(DriverFactoryShaip.getInstance().getDriver(), 30);
		PageFactory.initElements(DriverFactoryShaip.getInstance().getDriver(), this);

	}

	@FindBy(xpath = "//input[@data-placeholder='Email Address']")
	WebElement Email;

	@FindBy(xpath = "//input[@data-placeholder='Password']")
	WebElement Password;

	@FindBy(xpath = "//span[contains(text(),'Sign In')]//parent::button")
	WebElement SignIn;
	
	@FindBy(xpath = "//img[@class='loader-icon']")
	WebElement processBar;


	
	
	public void enterEmail(String email) {

		click_custom(Email, "UsernameField");
		sendKeys_custom(Email, "UsernameField", email);
		

	}

	public void enterPassword(String password) {

		click_custom(Password, "PasswordField");
		sendKeys_custom(Password, "PasswordField", password);


	}

	public void doSignIn() {

		click_custom(SignIn, "SignIn button");
		System.out.println("Welcome to home page");

	}

	public void loginToEP(String email, String password) throws InterruptedException {

		
		

		
		enterEmail(email);
		enterPassword(password);
		doSignIn();
		waitForProcessBarToGo();


	}
	
	
	
	/*By EMAIL = By.xpath("//input[@data-placeholder='Email Address']");
	By PASSWORD = By.xpath("//input[@data-placeholder='Password']");
	By LOGIN_BTN = By.xpath("//span[contains(text(),'Sign In')]/parent::button");


	//login to App
	public void loginToEP(String email, String password) {
	
		
		webdrivers=DriverFactoryShaip.getInstance().getDriver();
		sendKeys_custom(DriverFactoryShaip.getInstance().getDriver().findElement(EMAIL), "LoginEmailFIeld", email);
		sendKeys_custom(DriverFactoryShaip.getInstance().getDriver().findElement(PASSWORD), "LoginPasswordFIeld", password);

		click_custom(DriverFactoryShaip.getInstance().getDriver().findElement(LOGIN_BTN), "LoginButton");

	}*/

}
