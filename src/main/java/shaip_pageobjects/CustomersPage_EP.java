package shaip_pageobjects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shaip_base.DriverFactoryShaip;
import shaip_base.TestBaseShaip;

public class CustomersPage_EP extends TestBaseShaip {

	public CustomersPage_EP() {

		wait = new WebDriverWait(DriverFactoryShaip.getInstance().getDriver(), 20);
		PageFactory.initElements(DriverFactoryShaip.getInstance().getDriver(), this);

	}

	@FindBy(xpath = "//*[name()='rect' and @id='Rectangle_285']//ancestor::button")
	WebElement addCustomerBtn;

	// Create customer

	@FindBy(xpath = "//input[@name='name']")
	WebElement nameOfCustomer;

	@FindBy(xpath = "//textarea[@data-placeholder='Description' or @id='mat-input-61']")
	WebElement descriptionOfCustomer;

	@FindBy(xpath = "//input[@name='country']")
	WebElement customerCountry;

	@FindBy(xpath = "//input[@name='state']")
	WebElement customerState;

	@FindBy(xpath = "//div[@role='listbox' or @id='mat-autocomplete-22']")
	WebElement countryListing;

	@FindBy(xpath = "//span[text()='Save']//parent::button")
	WebElement saveBtn;

	// Create listing

	@FindBy(xpath = "//input[@placeholder='Global Search'and contains(@class,'global-search')]")
	WebElement globalSearch;

	@FindBy(css = "table > tbody > tr > td:nth-child(2)")
	WebElement searchedEntity;

	@FindBy(tagName = "h2")
	WebElement customerHeader;

	@FindBy(xpath = "//mat-icon[@svgicon='edit']//*[local-name()='svg']")
	WebElement editCustomer;

	@FindBy(xpath = "//span[text()='Edit']//parent::button")
	WebElement editCustomerBtn;

	@FindBy(xpath = "(//span[@class='detail'])[2]")
	WebElement customerDes;

	@FindBy(xpath = "(//span[@class='detail'])[3]")
	WebElement customerCou;

	@FindBy(xpath = "(//span[@class='detail'])[4]")
	WebElement customerST;

	// Users Tab
	@FindBy(xpath = "//div[contains(@class,'mat-tab-label') and contains(text(),'Users')]")
	WebElement usersTab;

	@FindBy(xpath = "//button[@role='menuitem' and contains(text(),'Add User')]")
	WebElement addUsers;

	// ***********create
	// users***********************************************************************************************************************************************

	@FindBy(xpath = "//input[@id='mat-input-10' or @data-placeholder='First Name']")
	WebElement nameOfUser;

	@FindBy(xpath = "//input[@id='mat-input-11' or @data-placeholder='Last Name']")
	WebElement lastnameOfUser;

	@FindBy(xpath = "//div[@role='listbox' or @id='mat-select-8-panel']")
	WebElement genderListBox;

	@FindBy(xpath = "//mat-select[@role='combobox' and @formcontrolname='genderCode']")
	WebElement userGender;

	@FindBy(xpath = "//input[@id='mat-input-16' or @data-placeholder='Email Address']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@role='combobox' or @id='mat-input-17' or @formcontrolname='countryCode']")
	WebElement userCountry;

	@FindBy(xpath = "//mat-select[@role='combobox' and @formcontrolname='roleName']")
	WebElement userRole;

	@FindBy(xpath = "//span[contains(text(),'Save')]//parent::button")
	WebElement saveUserBtn;

	@FindBy(xpath = "//div[@class='content']//p")
	WebElement toasterMessage;
	
	@FindBy(xpath = "//mat-icon[text()='clear']")
	WebElement closeToaster;
	
	

	public void addNewCustomerUser(String firstName, String lastname, String email, String gender, String country,
			String role) throws InterruptedException

	{

		enterFirstName(firstName);
		enterLastName(lastname);
		selectGender(gender);
		enterEmaiID(email);
		selectUsersCountry(country);
		selectUsersRole(role);
		clickOnSaveUserBtn();

	}

	public void enterFirstName(String firstName)

	{

		click_custom(nameOfUser, "First Name");
		sendKeys_custom(nameOfUser, "First Name", firstName);

	}

	public void enterLastName(String lastname)

	{

		click_custom(lastnameOfUser, "Last Name");
		sendKeys_custom(lastnameOfUser, "Last Name", lastname);

	}

	public void enterEmaiID(String email)

	{

		click_custom(userEmail, "Email");
		sendKeys_custom(userEmail, "Email", email);

	}

	public void clickOnSaveUserBtn()

	{

		click_custom(saveUserBtn, "Save User");

	}

	public void selectUsersCountry(String countryName) throws InterruptedException

	{
		Thread.sleep(1000);
		click_custom(userCountry, "User Country Dropdown");
		sendKeys_custom(userCountry, "User Country Dropdown", countryName);
		Thread.sleep(1000);
		List<WebElement> countryToBeSelected = DriverFactoryShaip.getInstance().getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
		// System.out.println(countryToBeSelected.size());

		Thread.sleep(1000);

		for (int i = 0; i < countryToBeSelected.size(); i++) {

			String country = countryToBeSelected.get(i).getText().replaceAll("\r\n", " ").replaceAll("\r", " ")
					.replaceAll("\n", " ");
			System.out.println(countryToBeSelected);
			// String[] menues = menu.split(" ");
			// String menuName = menues[1];

			if (country.equalsIgnoreCase(countryName))

			{
				click_custom(countryToBeSelected.get(i), countryName);
				break;
			}

		}

	}

	public void selectUsersRole(String roleName) throws InterruptedException

	{
		Thread.sleep(1000);
		click_custom(userRole, "User Country Dropdown");
		List<WebElement> roleToBeSelected = DriverFactoryShaip.getInstance().getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
		// System.out.println(countryToBeSelected.size());

		Thread.sleep(1000);

		for (int i = 0; i < roleToBeSelected.size(); i++) {

			String role = roleToBeSelected.get(i).getText().replaceAll("\r\n", " ").replaceAll("\r", " ")
					.replaceAll("\n", " ");
			System.out.println(roleToBeSelected);
			// String[] menues = menu.split(" ");
			// String menuName = menues[1];

			if (role.equalsIgnoreCase(roleName))

			{
				click_custom(roleToBeSelected.get(i), roleName);
				break;
			}

		}

	}

	public void selectGender(String gender) throws InterruptedException

	{

		click_custom(userGender, "Gender Dropdown");
		Thread.sleep(1000);
		List<WebElement> genderToBeSelected = DriverFactoryShaip.getInstance().getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
		// System.out.println(countryToBeSelected.size());

		for (int i = 0; i < genderToBeSelected.size(); i++) {

			String genders = genderToBeSelected.get(i).getText().replaceAll("\r\n", " ").replaceAll("\r", " ")
					.replaceAll("\n", " ");

			if (genders.equalsIgnoreCase(gender))

			{
				click_custom(genderToBeSelected.get(i), gender);
				break;
			}

		}

	}

	public void clickOnUsersTab()

	{
		waitUntilClickable(usersTab);
		click_custom(usersTab, "Users Tab");

	}

	public void clickAddUserMenu() throws InterruptedException

	{
		clickOnAddCustomerButton();
		waitUntilClickable(addUsers);
		click_custom(addUsers, "Add Users");
		Thread.sleep(2000);

	}

	public void editAndVerifyCustomerFromListing(String searchEntity, String UpdatedName, String UpdatedDescription,
			String UpdatedcountryName, String UpdatedstateName) throws InterruptedException

	{
		waitUntilClickable(globalSearch);
		click_custom(globalSearch, searchEntity);
		sendKeys_custom(globalSearch, "Global Search", searchEntity);
		Thread.sleep(2000);
		click_custom(editCustomer, "Edit customer icon");
		waitForProcessBarToGo();
		updateExistingCustomer(UpdatedName, UpdatedDescription, UpdatedcountryName, UpdatedstateName);
		Thread.sleep(2000);
		verifyUpdatedCustomerInformation(UpdatedName, UpdatedName, UpdatedDescription, UpdatedcountryName,
				UpdatedstateName);

	}

	public void editAndVerifyCustomerFromDetailsPage(String searchEntity, String UpdatedName, String UpdatedDescription,
			String UpdatedcountryName, String UpdatedstateName) throws InterruptedException

	{
		waitUntilClickable(globalSearch);
		click_custom(globalSearch, searchEntity);
		sendKeys_custom(globalSearch, "Global Search", searchEntity);
		Thread.sleep(2000);
		click_custom(searchedEntity, "Searched Result");
		click_custom(editCustomerBtn, "Edit customer Button");
		waitForProcessBarToGo();
		updateExistingCustomer(UpdatedName, UpdatedDescription, UpdatedcountryName, UpdatedstateName);
		Thread.sleep(2000);
		verifyUpdatedCustomerInformationFromDetail(UpdatedName, UpdatedName, UpdatedDescription, UpdatedcountryName,
				UpdatedstateName);

	}

	public void verifyUpdatedCustomerInformationFromDetail(String searchEntity, String Name, String Description,
			String countryName, String stateName) throws InterruptedException

	{

		String customerNam = getText_custom(customerHeader, "Updated Name");
		String customerDesc = getText_custom(customerDes, "Updated Description");
		String customerCountry = getText_custom(customerCou, "Updated Country");
		String customerState = getText_custom(customerST, "Updated State");

		if (!customerNam.equalsIgnoreCase("Steve Smith")) {

			sa.assertEquals(customerNam, "Steve Smith", "Name not get updated");

		}
		if (!customerDesc.equalsIgnoreCase(Description)) {

			sa.assertEquals(customerDesc, Description, "Description not get updated");
		}
		if (!customerCountry.equalsIgnoreCase(countryName)) {

			sa.assertEquals(customerCountry, countryName, "Country not get updated");
		}
		if (!customerState.equalsIgnoreCase(stateName)) {

			sa.assertEquals(customerState, stateName, "State not get updated");
		}

		sa.assertAll();

	}


	public void verifyUpdatedCustomerInformation(String searchEntity, String Name, String Description,
			String countryName, String stateName) throws InterruptedException

	{
		clearText(globalSearch);
		click_custom(globalSearch, searchEntity);
		sendKeys_custom(globalSearch, "Global Search", searchEntity);
		Thread.sleep(2000);
		click_custom(searchedEntity, "Searched Result");
		waitForProcessBarToGo();
		String customerNam = getText_custom(customerHeader, "Updated Name");
		String customerDesc = getText_custom(customerDes, "Updated Description");
		String customerCountry = getText_custom(customerCou, "Updated Country");
		String customerState = getText_custom(customerST, "Updated State");

		if (!customerNam.equalsIgnoreCase(Name) && !customerDesc.equalsIgnoreCase(Description)
				&& !customerCountry.equalsIgnoreCase(countryName) && !customerState.equalsIgnoreCase(stateName)) {

			sa.assertEquals(customerNam, Name, "Name not get updated");
			sa.assertEquals(customerDesc, Description, "Description not get updated");
			sa.assertEquals(customerCountry, countryName, "Country not get updated");
			sa.assertEquals(customerState, stateName, "State not get updated");

		}

		sa.assertAll();

	}

	public void doSearch(String searchEntity) throws InterruptedException

	{
		waitUntilClickable(globalSearch);
		click_custom(globalSearch, searchEntity);
		sendKeys_custom(globalSearch, "Global Search", searchEntity);
		Thread.sleep(2000);
		click_custom(searchedEntity, "Searched Result");
		waitForProcessBarToGo();

		String searchedResult = getText_custom(customerHeader, "Searched Result");
		System.out.println("searched result" + searchedResult);

		if (!searchedResult.equalsIgnoreCase(searchEntity)) {

			sa.assertEquals(searchedResult, searchEntity);
			sa.assertTrue(false);

		}

		sa.assertAll();
	}

	public void clickOnAddCustomerButton() throws InterruptedException

	{
		Thread.sleep(1000);
		click_custom(addCustomerBtn, "Add Customer Button");
		System.out.println("Button clicked");

	}

	public void clickOnSave()

	{

		click_custom(saveBtn, "SaveButton");

	}

	public void enterCustomerName(String Name)

	{
		waitUntilClickable(nameOfCustomer);
		click_custom(nameOfCustomer, "CustomerDescription");
		sendKeys_custom(nameOfCustomer, "CustomerName", Name);
	}

	public void enterCustomerDescription(String Description)

	{
		waitUntilClickable(descriptionOfCustomer);
		click_custom(descriptionOfCustomer, "CustomerDescription");
		sendKeys_custom(descriptionOfCustomer, "CustomerDescription", Description);

	}

	public void selectCountry(String countryName) throws InterruptedException

	{
		Thread.sleep(1000);
		click_custom(customerCountry, "Country Dropdown");
		sendKeys_custom(customerCountry, "Country Dropdown", countryName);
		Thread.sleep(1000);
		List<WebElement> countryToBeSelected = DriverFactoryShaip.getInstance().getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
		// System.out.println(countryToBeSelected.size());

		Thread.sleep(1000);

		for (int i = 0; i < countryToBeSelected.size(); i++) {

			String country = countryToBeSelected.get(i).getText().replaceAll("\r\n", " ").replaceAll("\r", " ")
					.replaceAll("\n", " ");
			System.out.println(countryToBeSelected);
			// String[] menues = menu.split(" ");
			// String menuName = menues[1];

			if (country.equalsIgnoreCase(countryName))

			{
				click_custom(countryToBeSelected.get(i), countryName);
				break;
			}

		}

	}

	public void selectState(String customerStates) throws InterruptedException

	{
		Thread.sleep(1000);

		click_custom(customerState, "State Dropdown");
		sendKeys_custom(customerState, "State Dropdown", customerStates);
		Thread.sleep(1000);
		List<WebElement> stateToBeSelected = DriverFactoryShaip.getInstance().getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
		// System.out.println(countryToBeSelected.size());

		Thread.sleep(1000);

		for (int i = 0; i < stateToBeSelected.size(); i++) {

			String state = stateToBeSelected.get(i).getText().replaceAll("\r\n", " ").replaceAll("\r", " ")
					.replaceAll("\n", " ");
			System.out.println(stateToBeSelected);
			// String[] menues = menu.split(" ");
			// String menuName = menues[1];

			if (state.equalsIgnoreCase(customerStates))

			{
				click_custom(stateToBeSelected.get(i), customerStates);
				break;
			}
		}

	}

	public void addNewCustomer(String Name, String Description, String countryName, String stateName)
			throws InterruptedException

	{
		enterCustomerName(Name);
		enterCustomerDescription(Description);
		selectCountry(countryName);
		selectState(stateName);
		waitUntilClickable(saveBtn);
		clickOnSave();

	}

	public void updateExistingCustomer(String Name, String Description, String countryName, String stateName)
			throws InterruptedException

	{
		clearText(nameOfCustomer);
		enterCustomerName(Name);
		clearText(descriptionOfCustomer);
		enterCustomerDescription(Description);
		clearText(customerCountry);
		selectCountry(countryName);
		clearText(customerState);
		selectState(stateName);
		waitUntilClickable(saveBtn);
		clickOnSave();
		waitForUpdateToasterMessage();

	}

	public void waitForSuccessToasterMessage() throws InterruptedException {
		
		waitForVisibility(toasterMessage);
		sa.assertTrue(toasterMessage.isDisplayed(), "Toaster message is getting displayed");
		String toasterMessages=getText_custom(toasterMessage, "Toaster Message");
		sa.assertEquals(toasterMessages, "The customer has been created successfully", "Wrong toaster message getting displayed");
		Thread.sleep(1000);
		click_custom(closeToaster, "Close Toaster");
		Thread.sleep(1000);
		sa.assertAll();
		
	
}
	
public void waitForUpdateToasterMessage() throws InterruptedException {
		
		waitForVisibility(toasterMessage);
		sa.assertTrue(toasterMessage.isDisplayed(), "Toaster message is getting displayed");
		String toasterMessages=getText_custom(toasterMessage, "Toaster Message");
		sa.assertEquals(toasterMessages, "The customer has been updated successfully", "Wrong toaster message getting displayed");
		Thread.sleep(1000);
		click_custom(closeToaster, "Close Toaster");
		Thread.sleep(1000);
		sa.assertAll();
		
	
}
}
