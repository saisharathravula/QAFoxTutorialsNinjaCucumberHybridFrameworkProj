package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountCreatedSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	
	private RegisterPage registerPage;
	private AccountCreatedSuccessPage accountCreatedSuccessPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	    
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		registerPage = homePage.clickOnRegisterOption();
		
	}

	@When("User enters the below details into the fields")
	public void user_enters_the_below_details_into_the_fields(DataTable dataTable) {
	   
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerPage.enterFirstNameText(dataMap.get("firstName"));
		registerPage.enterLastNameText(dataMap.get("lastName"));
		
		commonUtils = new CommonUtils();
		registerPage.enterEmailAddressText(commonUtils.getEmailWithTimeAndDateStamp());
		registerPage.enterTelephoneText(dataMap.get("telephone"));
		registerPage.enterPasswordText(dataMap.get("password"));
		registerPage.enterPasswordConfirmText(dataMap.get("password"));
		
	}
	
	@When("User enters the below details into the fields with duplicate email")
	public void user_enters_the_below_details_into_the_fields_with_duplicate_emai(DataTable dataTable) {
	   
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerPage.enterFirstNameText(dataMap.get("firstName"));
		registerPage.enterLastNameText(dataMap.get("lastName"));
		registerPage.enterEmailAddressText(dataMap.get("emailAddress"));
		registerPage.enterTelephoneText(dataMap.get("telephone"));
		registerPage.enterPasswordText(dataMap.get("password"));
		registerPage.enterPasswordConfirmText(dataMap.get("password"));
		
	}

	@When("User selects Privacy Policy check box")
	public void user_selects_privacy_policy_check_box() {
	   
		registerPage.clickOnPrivacyPolicyCheckBox();
		
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	    
		accountCreatedSuccessPage = registerPage.clickOnContinueButton();
		
	}

	@Then("User account should create successfully")
	public void user_account_should_create_successfully() {
		
		Assert.assertEquals("Your Account Has Been Created!",accountCreatedSuccessPage.displayStatusOfYourAccountHasBeenCreatedText());
		
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	   
		registerPage.selectYesToNewsLetterOption();
		
	}

	@Then("User should get a proper warning message about duplicate email address")
	public void user_should_get_a_proper_warning_message_about_duplicate_email_address() {
	   
		Assert.assertTrue(registerPage.displayStatusOfWarningMessageOfDuplicateEmailAddress().contains("Warning: E-Mail Address is already registered!"));
		
	}

	@When("User does not enter any details into the fields")
	public void user_does_not_enter_any_details_into_the_fields() {
	    
		//Intentionally kept blank or
		
		registerPage.enterFirstNameText("");
		registerPage.enterLastNameText("");
		registerPage.enterEmailAddressText("");
		registerPage.enterTelephoneText("");
		registerPage.enterPasswordText("");
		registerPage.enterPasswordConfirmText("");
		
	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
		
		Assert.assertTrue(registerPage.displayStatusOfWarningMessageOfPrivacyPolicy().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.displayStatusOfWarningMessageOfFirstName());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.displayStatusOfWarningMessageOfLastName());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.displayStatusOfWarningMessageOfEmailAddress());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.displayStatusOfWarningMessageOfTelephone());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.displayStatusOfWarningMessageOfPassword());

		
	}
	
}
