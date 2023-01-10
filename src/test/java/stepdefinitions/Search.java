package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;

public class Search {
	
	WebDriver driver;
	
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
	   
		driver = DriverFactory.getDriver();
		
	}

	@When("User enters valid product {string} into Search box text field")
	public void user_enters_valid_product_into_search_box_text_field(String validProductText) {
	   
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(validProductText);
		
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	    
		searchResultsPage = homePage.clickOnSearchButton();
		
	}

	@Then("User should get valid product displaying in search results")
	public void user_should_get_valid_product_displaying_in_search_results() {
	   
		Assert.assertTrue(searchResultsPage.dispalyStatusOfValidHPProduct());
		
	}

	@When("User enters invalid product {string} into Search box text field")
	public void user_enters_invalid_product_into_search_box_text_field(String invalidProductText) {
	    
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(invalidProductText);
		
	}

	@Then("User should get a message about No product matches")
	public void user_should_get_a_message_about_no_product_matches() {
	    
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultsPage.dispalyStatusOfProductMessageText());
		
	}

	@When("User does not enter any product into Search box text field")
	public void user_does_not_enter_any_product_into_search_box_text_field() {
	   
		homePage = new HomePage(driver);
	
	}

}
