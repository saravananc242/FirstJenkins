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
import testBase.BaseClass;
import utils.CommonUtilities;

public class HotelBookingStepDef extends BaseClass{
	HotelBookingPage booking;
	@Given("^the user is in Hotel booking page$")
	public void the_user_is_in_Hotel_booking_page() throws Throwable {
		booking = new HotelBookingPage();
		Assert.assertEquals(BookingPageTitle, booking.capturePageTitle());
	    Assert.assertTrue(booking.validatePageHeading());
	}

	@Then("^user verifies validations for first name field$")
	public void user_verifies_validations_for_first_name_field(DataTable UserCred) throws Throwable {
	   List<Map<String,String>> list = UserCred.asMaps(String.class, String.class);
	   for (Map<String, String> map : list) {
		booking.typeFirstName(map.get("FirstName"));
		booking.clickConfirmBooking();
		Assert.assertEquals(FirstNameValidationError, CommonUtilities.captureAlert());
		Reporter.addStepLog("\""+FirstNameValidationError+"\" alert is found");
	}
	}

	@Then("^user verifies validation for last name field$")
	public void user_verifies_validation_for_last_name_field(DataTable UserCred) throws Throwable {
		List<Map<String,String>> list = UserCred.asMaps(String.class, String.class);
		   for (Map<String, String> map : list) {
			booking.typeLastName(map.get("LastName"));
			booking.clickConfirmBooking();
			Assert.assertEquals(LastNameValidationError, CommonUtilities.captureAlert());
			Reporter.addStepLog("\""+LastNameValidationError+"\" alert is found");
		   }
	}

	@Then("^user verifies validation for email field$")
	public void user_verifies_validation_for_email_field(DataTable UserCred) throws Throwable {
		List<Map<String, String>> list = UserCred.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.typeEmailId(map.get("EmailId"));
			booking.clickConfirmBooking();
			if (map.get("Validation").equalsIgnoreCase("EMPTY")) {
				Assert.assertEquals(NoEmailValidationError, CommonUtilities.captureAlert());
				Reporter.addStepLog("\""+NoEmailValidationError+"\" alert is found");
			} else if (map.get("Validation").equalsIgnoreCase("INVALID")) {
				Assert.assertEquals(InvalidEmailValidationError, CommonUtilities.captureAlert());
				Reporter.addStepLog("\""+InvalidEmailValidationError+"\" alert is found");
			}

		}
	}
	
	@When("^user enters a valid first name$")
	public void user_enters_a_valid_first_name(DataTable UserCred) throws Throwable {
		 List<Map<String,String>> list = UserCred.asMaps(String.class, String.class);
		 booking.typeFirstName(list.get(0).get("FirstName"));
	}

	@When("^user enters a valid last name$")
	public void user_enters_a_valid_last_name(DataTable UserCred) throws Throwable {
		List<Map<String,String>> list = UserCred.asMaps(String.class, String.class);
		 booking.typeLastName(list.get(0).get("LastName"));
	}

	@When("^user enters a valid email id$")
	public void user_enters_a_valid_email_id(DataTable UserCred) throws Throwable {
		List<Map<String,String>> list = UserCred.asMaps(String.class, String.class);
		booking.typeEmailId(list.get(0).get("EmailId"));
	}
	
	@Then("^user verifies validation for mobile number field$")
	public void user_verifies_validation_for_mobile_number_field(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.typeMobileNumber(map.get("MobileNo"));
			booking.clickConfirmBooking();
			if (map.get("Validation").equalsIgnoreCase("EMPTY")) {
				Assert.assertEquals(NoMobileNumberValidationError, CommonUtilities.captureAlert());
				Reporter.addStepLog("\""+NoMobileNumberValidationError+"\" alert is found");
			} else if (map.get("Validation").equalsIgnoreCase("INVALID")) {
				Assert.assertEquals(InvalidMobileNumberValidationError, CommonUtilities.captureAlert());
				Reporter.addStepLog("\""+InvalidMobileNumberValidationError+"\" alert is found");
			}
			
		}
	}

	@When("^user enters a valid mobile number$")
	public void user_enters_a_valid_mobile_number(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.typeMobileNumber(list.get(0).get("MobileNo"));
	}

	@When("^user enters a valid address$")
	public void user_enters_a_valid_address(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.typeAddress(list.get(0).get("Address"));
	}

	@Then("^user verifies validation for city dropdown$")
	public void user_verifies_validation_for_city_dropdown(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.selectCity(map.get("City"));
			booking.clickConfirmBooking();
			Assert.assertEquals(CityValidationError, CommonUtilities.captureAlert());
			Reporter.addStepLog("\""+CityValidationError+"\" alert is found");
		}
		
	}

	@When("^user selects a valid city$")
	public void user_selects_a_valid_city(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.selectCity(list.get(0).get("City"));
	}

	@Then("^user verifies validation for State dropdown$")
	public void user_verifies_validation_for_State_dropdown(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.selectState(map.get("State"));
			booking.clickConfirmBooking();
			Assert.assertEquals(StateValidationError, CommonUtilities.captureAlert());
			Reporter.addStepLog("\""+StateValidationError+"\" alert is found");
		}
		
	}

	@When("^user selects a valid state$")
	public void user_selects_a_valid_state(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.selectState(list.get(0).get("State"));
	}

	@When("^user selects number of persons$")
	public void user_selects_number_of_persons(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.selectNoOfPersons(list.get(0).get("Persons"));
	}

	@Then("^user verifies the number of rooms allocated by application$")
	public void user_verifies_the_number_of_rooms_allocated_by_application() throws Throwable {
	    booking.captureNumberOfRooms();
	}
	
	@Then("^user verifies validation for card holder name$")
	public void user_verifies_validation_for_card_holder_name(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.typeCardHolderName(map.get("CardHolderName"));
			booking.clickConfirmBooking();
			Assert.assertEquals(CardHolderNameValidationError, CommonUtilities.captureAlert());
			Reporter.addStepLog("\""+CardHolderNameValidationError+"\" alert is found");
		}    
	}

	@When("^user enters a valid card holder name field$")
	public void user_enters_a_valid_card_holder_name_field(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.typeCardHolderName(list.get(0).get("CardHolderName"));
	  
	}

	@Then("^user verifies validation of card number field$")
	public void user_verifies_validation_of_card_number_field(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.typeCardNumber(map.get("CardNumber"));
			booking.clickConfirmBooking();
			Assert.assertEquals(DebitCardNumberValidationError, CommonUtilities.captureAlert());
			Reporter.addStepLog("\""+DebitCardNumberValidationError+"\" alert is found");
						
		} 
	  
	}

	@When("^user verifies a valid card number$")
	public void user_verifies_a_valid_card_number(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.typeCardNumber(list.get(0).get("CardNumber"));
	    
	}

	@Then("^user verifies validation of cvv field$")
	public void user_verifies_validation_of_cvv_field(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.typeCVV(map.get("CVV"));
			booking.clickConfirmBooking();
			Assert.assertEquals(CVVValidationError, CommonUtilities.captureAlert());
			Reporter.addStepLog("\""+CVVValidationError+"\" alert is found");
						
		} 
	  
	}

	@When("^user enters a valid cvv$")
	public void user_enters_a_valid_cvv(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.typeCVV(list.get(0).get("CVV"));
	    
	}

	@Then("^user validates expiry month field$")
	public void user_validates_expiry_month_field(DataTable UserDetails) throws Throwable {
	    
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.typeExpiryMonth(map.get("ExpiryMonth"));
			booking.clickConfirmBooking();
			Assert.assertEquals(ExpiryMonthValidationError, CommonUtilities.captureAlert());
			Reporter.addStepLog("\""+ExpiryMonthValidationError+"\" alert is found");
						
		} 
	  
	}

	@When("^user enters a valid expiry month$")
	public void user_enters_a_valid_expiry_month(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.typeExpiryMonth(list.get(0).get("ExpiryMonth"));
	    
	}

	@Then("^user validates expiry year field$")
	public void user_validates_expiry_year_field(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			booking.typeExpiryYear(map.get("ExpiryYear"));
			booking.clickConfirmBooking();
			Assert.assertEquals(ExpiryYearValidationError, CommonUtilities.captureAlert());
			Reporter.addStepLog("\""+ExpiryYearValidationError+"\" alert is found");
						
		} 
	}
	
	@When("^user enters a valid expiry year$")
	public void user_enters_a_valid_expiry_year(DataTable UserDetails) throws Throwable {
		List<Map<String,String>> list = UserDetails.asMaps(String.class, String.class);
		booking.typeExpiryYear(list.get(0).get("ExpiryYear"));
	}

	@When("^user clicks on confirm booking button$")
	public void user_clicks_on_confirm_booking_button() throws Throwable {
	    booking.clickConfirmBooking();
	    
	}
	
	@Then("^user validates success of hotel booking$")
	public void user_validates_success_of_hotel_booking() throws Throwable{
		Assert.assertTrue(booking.validateBooking());
	}

}
