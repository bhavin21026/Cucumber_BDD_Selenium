package shaip_base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactoryShaip {

	//create webdriver object for given browser
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

	//	WebDriver driver = null;
		RemoteWebDriver driver = null;

		if(browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
//Headless browser********************************************
			
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			options.addArguments("disable-gpu");*/
			
//Real browser*********************************************** 		
			

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", 
		    Collections.singletonList("enable-automation"));
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);			driver = new ChromeDriver(options);

		}else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
		//	FirefoxOptions foptions = new FirefoxOptions();
		//	foptions.addArguments("-private");
			
			driver = new RemoteWebDriver(new URL("http:192.168.225.219:4444/wd/hub"), DesiredCapabilities.firefox());		        

			
			//driver = new FirefoxDriver(foptions);

		} if (browser.equalsIgnoreCase("ie")) {

			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iOptions = new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");

			driver = new InternetExplorerDriver(iOptions);
		}
		return driver;
	}


}
