package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;

import testBase.BaseClass;

public class HotelBookingPage extends BaseClass{

	@FindBy(xpath="//h2[contains(.,'Hotel Booking Form')]")
	WebElement HotelBookingPageHeading;
	
	@FindBy(xpath="//input[@id='txtFirstName']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='txtLastName']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='txtEmail']")
	WebElement EmailId;
	
	@FindBy(xpath="//input[@id='txtPhone']")
	WebElement MobileNumber;
	
	@FindBy(xpath="//td[contains(.,'Address')]/following-sibling::td/textarea")
	WebElement Address;
	
	@FindBy(xpath="//select[@name='city']")
	WebElement CityDropDown;
	
	@FindBy(xpath="//select[@name='state']")
	WebElement StateDropDown;
	
	@FindBy(xpath="//select[@name='persons']")
	WebElement PersonsDropDown;
	
	@FindBy(xpath="//div[@id='rooms']")
	WebElement Rooms;
		
	@FindBy(xpath="//input[@id='txtCardholderName']")
	WebElement CardHolderName;
	  
	@FindBy(xpath="//input[@id='txtDebit']")
	WebElement DebitCardNumber;
	  
	@FindBy(xpath="//input[@id='txtCvv']")
	WebElement CVV;
	  
	@FindBy(xpath="//input[@id='txtMonth']")
	WebElement ExpirationMonth;
	
	@FindBy(xpath="//input[@id='txtYear']")
	WebElement ExpirationYear;
	
	@FindBy(xpath="//input[@value='Confirm Booking']")
	WebElement ConfirmBookingButton;
	
	@FindBy(xpath="//h1[contains(.,'Booking Completed!')]")
	WebElement BookingSuccessMessage;
	 
	public HotelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String capturePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePageHeading() {
		boolean result=HotelBookingPageHeading.isDisplayed();
		if (result) {
			Reporter.addStepLog("HotelBookingPageHeading element is displayed");
		} else {
			Reporter.addStepLog("HotelBookingPageHeading element is not displayed");
		}
		return result;
	}
	
	public void clickConfirmBooking() {
		expWait.until(ExpectedConditions.elementToBeClickable(ConfirmBookingButton));
		ConfirmBookingButton.click();
		Reporter.addStepLog("ConfirmBookingButton element is found and clicked");
	}
	
	public void typeFirstName(String FirstName) {
		expWait.until(ExpectedConditions.elementToBeClickable(this.FirstName));
		this.FirstName.clear();
		this.FirstName.sendKeys(FirstName);
		Reporter.addStepLog("FirstName element is found and \""+FirstName+"\"is entered");
	}
	
	public void typeLastName(String LastName) {
		expWait.until(ExpectedConditions.elementToBeClickable(this.LastName));
		this.LastName.clear();
		this.LastName.sendKeys(LastName);
		Reporter.addStepLog("LastName element is found and \""+LastName+"\"is entered");
	}
	
	public void typeEmailId(String Email) {
		expWait.until(ExpectedConditions.elementToBeClickable(EmailId));
		EmailId.clear();
		EmailId.sendKeys(Email);
		Reporter.addStepLog("EmailId element is found and \""+Email+"\"is entered");
	}
	
	public void typeMobileNumber(String MobileNo) {
		expWait.until(ExpectedConditions.elementToBeClickable(MobileNumber));
		MobileNumber.clear();
		MobileNumber.sendKeys(MobileNo);
		Reporter.addStepLog("MobileNumber element is found and \""+MobileNo+"\"is entered");
	}
	
	public void typeAddress(String address) {
		expWait.until(ExpectedConditions.elementToBeClickable(Address));
		Address.clear();
		Address.sendKeys(address);
		Reporter.addStepLog("Address element is found and \""+address+"\"is entered");
	}
	
	public void selectCity(String City) {
		expWait.until(ExpectedConditions.elementToBeClickable(CityDropDown));
		Select select = new Select(CityDropDown);
		switch (City.toUpperCase()) {
		case "CHENNAI":
			select.selectByVisibleText("Chennai");
			break;
		case "PUNE":
			select.selectByVisibleText("Pune");
			break;
		case "BANGALORE":
			select.selectByVisibleText("Bangalore");
			break;
		case "HYDERABAD":
			select.selectByVisibleText("Hyderabad");
			break;
		default:
			break;
		}
		Reporter.addStepLog("CityDropDown element is found and \""+City+"\"is selected");
	}
	
	public void selectState(String State) {
		expWait.until(ExpectedConditions.elementToBeClickable(StateDropDown));
		Select select = new Select(StateDropDown);
		switch (State.toUpperCase()) {
		case "TAMILNADU":case "TAMIL NADU":
			select.selectByVisibleText("Tamilnadu");
			break;
		case "MAHARASHTRA":
			select.selectByVisibleText("Maharashtra");
			break;
		case "KARNATAKA":
			select.selectByVisibleText("Karnataka");
			break;
		case "TELANGANA":
			select.selectByVisibleText("Telangana");
			break;
		default:
			break;
		}
		Reporter.addStepLog("StateDropDown element is found and \""+State+"\"is selected");
	}
	
	public void selectNoOfPersons(String Persons) {
		expWait.until(ExpectedConditions.elementToBeClickable(PersonsDropDown));
		Select select = new Select(PersonsDropDown);
		select.selectByVisibleText(Persons);
		Reporter.addStepLog("PersonsDropDown element is found and \""+Persons+"\"is selected");
	}
	
	public void captureNumberOfRooms() {
		expWait.until(ExpectedConditions.elementToBeClickable(Rooms));
		String NoOfRooms = Rooms.getText();
		Reporter.addStepLog("No of rooms to be booked as per persons entered is "+NoOfRooms);
	}
	
	public void typeCardHolderName(String CardName) {
		expWait.until(ExpectedConditions.elementToBeClickable(CardHolderName));
		CardHolderName.clear();
		CardHolderName.sendKeys(CardName);
		Reporter.addStepLog("CardHolderName element is found and \""+CardName+"\"is entered");
	}
	
	public void typeCardNumber(String CardNo) {
		expWait.until(ExpectedConditions.elementToBeClickable(DebitCardNumber));
		DebitCardNumber.clear();
		DebitCardNumber.sendKeys(CardNo);
		Reporter.addStepLog("DebitCardNumber element is found and \""+CardNo+"\"is entered");
	}
	
	public void typeCVV(String CVV) {
		expWait.until(ExpectedConditions.elementToBeClickable(this.CVV));
		this.CVV.clear();
		this.CVV.sendKeys(CVV);
		Reporter.addStepLog("CVV element is found and \""+CVV+"\"is entered");
	}
	
	public void typeExpiryMonth(String Month) {
		expWait.until(ExpectedConditions.elementToBeClickable(ExpirationMonth));
		ExpirationMonth.clear();
		ExpirationMonth.sendKeys(Month);
		Reporter.addStepLog("ExpirationMonth element is found and \""+Month+"\"is entered");
	}
	
	public void typeExpiryYear(String Year) {
		expWait.until(ExpectedConditions.elementToBeClickable(ExpirationYear));
		ExpirationYear.clear();
		ExpirationYear.sendKeys(Year);
		Reporter.addStepLog("ExpirationYear element is found and \""+Year+"\"is entered");
		
	}
	
	public boolean validateBooking() {
		expWait.until(ExpectedConditions.elementToBeClickable(BookingSuccessMessage));
		boolean result=BookingSuccessMessage.isDisplayed();
		if (result) {
			Reporter.addStepLog("BookingSuccessMessage element is displayed");
		} else {
			Reporter.addStepLog("BookingSuccessMessage element is not displayed");
		}
		return result;
	}
	

}
