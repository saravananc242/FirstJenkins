package stepdefs;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HotelBookingPage;
import pages.LoginPage;
import testBase.BaseClass;
import utils.CommonUtilities;

public class LoginStepDef extends BaseClass{
	LoginPage login;
	HotelBookingPage booking;
	@Given("^the user has navigated to login portal$")
	public void the_user_navigates_to_login_portal() throws Throwable {
		login = new LoginPage();
	    Assert.assertTrue(login.validatePageHeading());
	    
	}

	@When("^user clicks on login button without entering a valid user name$")
	public void user_clicks_on_login_button_without_entering_a_valid_user_name() throws Throwable {
	    login.clickLoginButton();
	    
	}

	@Then("^a validataion message is displayed mentioning user name is mandatory for login$")
	public void a_validataion_message_is_displayed_mentioning_user_name_is_mandatory_for_login() throws Throwable {
	    Assert.assertTrue(login.validateErrorForUserName());
	    
	}

	@When("^user enters user name without a password and clicks on login button$")
	public void user_enters_user_name_without_a_password_and_clicks_on_login_button(DataTable UserCred) throws Throwable {
	   List<Map<String,String>> map =  UserCred.asMaps(String.class, String.class);
	    login.typeUserName(map.get(0).get("UserName"));	   
	    login.clickLoginButton();
	}

	@Then("^a validataion message is displayed mentioning password is mandatory for login$")
	public void a_validataion_message_is_displayed_mentioning_password_is_mandatory_for_login() throws Throwable {
	    Assert.assertTrue(login.validateErrorForPassword());
	    
	}

	@When("^user enters a valid user name and password and clicks on login button$")
	public void user_enters_a_valid_user_name_and_password_and_clicks_on_login_button(DataTable UserCred) throws Throwable {
		 List<Map<String,String>> map =  UserCred.asMaps(String.class, String.class);  
	    login.login(map.get(0).get("UserName"), map.get(0).get("Password"));	    
	}

	@Then("^the user is logged into hotel booking application$")
	public void the_user_is_logged_into_hotel_booking_application() throws Throwable {
		booking = new HotelBookingPage();
		Assert.assertEquals(BookingPageTitle, booking.capturePageTitle());
	    Assert.assertTrue(booking.validatePageHeading());
	    
	}
	
	@When("^user enters a invalid user name and password and clicks on login button$")
	public void user_enters_a_invalid_user_name_and_password_and_clicks_on_login_button(DataTable UserCred) throws Throwable {
		List<Map<String,String>> map =  UserCred.asMaps(String.class, String.class);  
	    login.login(map.get(0).get("UserName"), map.get(0).get("Password"));	
	}

	@Then("^user validates error message for invalid login$")
	public void user_validates_error_message_for_invalid_login() throws Throwable {
		Assert.assertEquals(InvalidLoginValidationError, CommonUtilities.captureAlert());
		Reporter.addStepLog("\""+InvalidLoginValidationError+"\" alert is found");
	}
}
