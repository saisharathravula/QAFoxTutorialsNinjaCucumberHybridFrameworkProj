package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.LoginSuccessPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	
	private LoginPage loginPage;
	private LoginSuccessPage loginSuccessPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		loginPage = homePage.clickOnLoginOption();
		
	}

	@When("^User enters valid email address (.+) into the email address text field$")
	public void user_enters_valid_email_address_into_the_email_address_text_field(String validEmailAddressText) {
		
		loginPage.enterEmailAddressText(validEmailAddressText);
	
	}
	
	@And("^User enters valid password (.+) into the password text field$")
	public void user_enters_valid_password_into_the_password_text_field(String validPasswordText) {
	    
		loginPage.enterPasswordAddressText(validPasswordText);
		
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	    
		loginSuccessPage = loginPage.clickOnLoginButton();
		
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	    
		Assert.assertTrue(loginSuccessPage.displayStatusOfChangeYourPasswordOption());
		
	}

	@When("User enters invalid email address into the email address text field")
	public void user_enters_invalid_email_address_into_the_email_address_text_field() {
	    
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddressText(commonUtils.getEmailWithTimeAndDateStamp());
	
	}

	@And("User enters invalid password {string} into the password text field")
	public void user_enters_invalid_password_into_the_password_text_field(String invalidPasswordText) {
	    
		loginPage.enterPasswordAddressText(invalidPasswordText);

	}

	@Then("User should get a proper warning message about login credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_login_credentials_mismatch() {
	    
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}

	@When("User does not enter any email address into the email address text field")
	public void user_does_not_enter_any_email_address_into_the_email_address_text_field() {
	    
		loginPage.enterEmailAddressText("");
		
	}

	@And("User does not enter any password into the password text field")
	public void user_does_not_enter_any_password_into_the_password_text_field() {
	    
		loginPage.enterPasswordAddressText("");
		
	}
	
	
}
