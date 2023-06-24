package shaip_stepdefinations;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shaip_base.DriverFactoryShaip;
import shaip_base.ExtentFactoryShaip;
import shaip_base.TestBaseShaip;
import shaip_pageobjects.AdministrationPage_EP;
import shaip_pageobjects.CustomersPage_EP;
import shaip_pageobjects.LandingPage_EP;
import shaip_pageobjects.LoginPage_EP;
import shaip_utilitiescomponents.PropertiesOperationsShaip;

public class steapdefinations extends TestBaseShaip {

	LoginPage_EP loginPage;
	LandingPage_EP landingPage;
	AdministrationPage_EP Administration;
	CustomersPage_EP customer;;
	public static WebDriver driver;

	@Given("^User must be on EP login page$")
	public void setupMethod() throws Throwable {
		driver = LaunchShaipCloud();
		loginPage = new LoginPage_EP();
		landingPage = new LandingPage_EP();
		Administration = new AdministrationPage_EP();
		customer = new CustomersPage_EP();
	}

	@When("^user enters valid (.+), valid (.+) and hit enter button$")
	public void user_enters_valid_valid_and_hit_enter_button(String username, String password) throws Throwable {

		loginPage.loginToEP(username, password);
	}
	
	
	
	@When("^user enters valid \"([^\"]*)\", valid \"([^\"]*)\" and hit enter buttons$")
    public void user_enters_valid_something_valid_something_and_hit_enter_button(String strArg1, String strArg2) throws Throwable {
		loginPage.loginToEP(strArg1, strArg2);
	}

	
	@Then("^user login is success and user navigated to Landing page and verify copyright text$")
	public void user_login_is_success_and_user_navigated_to_landing_page_and_verify_copyright_text() throws Throwable

	{

		landingPage.verifyShaipURI();

	}

	
	@When("^user enters invalid (.+), invalid (.+) and hit enter button and  user error message should get display$")
	public void user_enters_invalid_invalid_and_hit_enter_button_and_user_error_message_should_get_display(
			String username, String password) throws Throwable {

		loginPage.loginToEP(username, password);

	}

	
	@Then("^verify menu permission of user based on logged in (.+)$")
	public void verify_menu_permission_of_user_based_on_logged_in(String username) throws Throwable {

		landingPage.verifyMenuPermissions(username);
		Thread.sleep(3000);
	}

	// customer creation

	
	@When("^User clicks on \"([^\"]*)\" menu from landing page$")
	public void user_clicks_on_something_menu_from_landing_page(String strArg1) throws Throwable {
		landingPage.clickOnMenu(strArg1);

	}

	
	@Then("^Verify customer created successfully with all given values$")
	public void verify_customer_created_successfully_with_all_given_values() throws Throwable {
		customer.waitForSuccessToasterMessage();

		Thread.sleep(3000);
	}

	
	@And("^select \"([^\"]*)\" as a submenu$")
	public void select_something_as_a_submenu(String strArg1) throws Throwable {
		Administration.selectAdministrationSubMenu(strArg1);

	}

	
	@And("^click on Add customer button from customer listing screen$")
	public void click_on_add_customer_button_from_customer_listing_screen() throws Throwable {
		customer.clickOnAddCustomerButton();
		

	}

	
	@And("^Add new customer by filling or mandatory fileds$")
    public void add_new_customer_by_filling_or_mandatory_fileds() throws Throwable {
		customer.addNewCustomer("Manoj1", "Manoj Kapoor1", "India", "Gujarat");
    }

	
	//Search customer
	
	
	 
	@And("^Start searching by \"([^\"]*)\" from global search menu and verify searched results$")
	    public void start_searching_by_something_from_global_search_menu_and_verify_searched_results(String strArg1) throws Throwable {
			customer.doSearch(strArg1);
	    }
	 
	
	@Then("^Verify edit and verify newly created customer details from listing page$")
	    public void verify_edit_and_verify_newly_created_customer_details_from_listing_page() throws Throwable {
		 	
			customer.editAndVerifyCustomerFromListing("Manoj1", "Manoj Kapoor1","From Ahmedabad-editing a from listing Ami obroi", "China", "Fujian");
			Thread.sleep(5000);
	    }
	 
	
	@Then("^Verify edit and verify newly created customer details from customer details page$")
	    public void verify_edit_and_verify_newly_created_customer_details_from_customer_details_page() throws Throwable {
	   
		 	customer.editAndVerifyCustomerFromDetailsPage("Manoj Kapoor1", "Manoj Patel1", "Ami updating from detail page", "India","Gujarat");
			Thread.sleep(5000);
	 }
	 
	 //Add new user
	 
	 
	 
	@When("^user clicks on Users tab$")
	    public void user_clicks_on_users_tab() throws Throwable {
		 customer.clickOnUsersTab();
	    }

	   
	@Then("^verify add new customer user functionality by filling all mendatory details$")
	    public void verify_add_new_customer_user_functionality_by_filling_all_mendatory_details() throws Throwable {
	    	
			customer.addNewCustomerUser("Manoj1","Kapoor1", "manoj.maas1t@bccstudent.me","Male","India","Customer Administrator");

	    }

	 
	@Then("^verify user created successfully$")
	    public void verify_user_created_successfully() throws Throwable {
	    	System.out.println("User created successfully...");
	    	
	    }

	   
	@And("^clicks on Add New User button$")
	    public void click_on_add_new_user_button() throws Throwable {
	    	
	    	customer.clickAddUserMenu();
	    }
	   
	@And("^click on Add Customer User button$")
	    public void click_on_add_customer_user_button() throws Throwable {
	    	customer.clickOnAddCustomerButton();
			
	    }


	   
}
