package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cucumber.listener.Reporter;

import testBase.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//h1[contains(.,'Hotel Booking Application')]")
	WebElement LoginPageHeading;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement LoginUserName;
	
	@FindBy(xpath="//input[@name='userPwd']")
	WebElement LoginPassword;
	
	@FindBy(xpath="//input[@type='button' and @value='Login']")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@id='userErrMsg' and contains(.,'Please enter userName')]")
	WebElement ErrorLoginUserName;
	
	@FindBy(xpath="//div[@id='pwdErrMsg' and contains(.,'Please enter password')]")
	WebElement ErrorLoginPassword;
	
	public LoginPage() {
		System.out.println(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePageHeading() {
		boolean result=LoginPageHeading.isDisplayed();
		if (result) {
			Reporter.addStepLog("LoginPageHeading element is displayed");
		} else {
			Reporter.addStepLog("LoginPageHeading element is not displayed");
		}
		return result;
	}
	
	public boolean validateErrorForUserName() {
		boolean result=ErrorLoginUserName.isDisplayed();
		if (result) {
			Reporter.addStepLog("ErrorLoginUserName element is displayed");
		} else {
			Reporter.addStepLog("ErrorLoginUserName element is not displayed");
		}
		return result;
	}
	
	public boolean validateErrorForPassword() {
		boolean result=ErrorLoginPassword.isDisplayed();
		if (result) {
			Reporter.addStepLog("ErrorLoginPassword element is displayed");
		} else {
			Reporter.addStepLog("ErrorLoginPassword element is not displayed");
		}
		return result;
	}
	
	public void clickLoginButton() {
		expWait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		LoginButton.click();
		Reporter.addStepLog("LoginButton element is found and click");
	}
	
	public void typeUserName(String UserName) {
		expWait.until(ExpectedConditions.elementToBeClickable(LoginUserName));
		LoginUserName.sendKeys(UserName);
		Reporter.addStepLog("LoginUserName element is found and user name is sent");
	}
	
	public void typePassword(String Password) {
		expWait.until(ExpectedConditions.elementToBeClickable(LoginPassword));
		LoginPassword.sendKeys(Password);
		Reporter.addStepLog("LoginPassword element is found and password is sent");
	}
	
	public void login(String UserName,String Password) {
		typeUserName(UserName);
		typePassword(Password);
		clickLoginButton();
	}
	
	
}
