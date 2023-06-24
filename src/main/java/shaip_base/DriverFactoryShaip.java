package shaip_base;

import org.openqa.selenium.WebDriver;

public class DriverFactoryShaip {

	//Singleton design Pattern
	//private constructor so that no one else can create object of this class
	private DriverFactoryShaip() {
		
	}
	
	private static DriverFactoryShaip shaipinstance  = new DriverFactoryShaip();
	
	public static DriverFactoryShaip getInstance() {
		return shaipinstance;
	}
	
	
	//factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(WebDriver driverParm) {
		driver.set(driverParm);
	}
	
	
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}
}
