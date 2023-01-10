package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenuOption;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxTextField;
	
	@FindBy(xpath="//span[@class='input-group-btn']//button[@type='button']")
	private WebElement searchButton;
	
	
	public void clickOnMyAccountDropMenu() {
		
		elementUtils.clickOnElement(myAccountDropMenuOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or myAccountDropMenuOption.click();
		
	}
	
	public LoginPage clickOnLoginOption() {
		
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage clickOnRegisterOption() {
		
		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or registerOption.click();
		return new RegisterPage(driver);
		
	}
	
	public void enterProductIntoSearchBoxField(String ProductText) {
		
		elementUtils.typeTextIntoElement(searchBoxTextField, ProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME
				);
		//or searchBoxTextField.sendKeys(ProductText);
		
	}
	
	public SearchResultsPage clickOnSearchButton() {
		
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or searchButton.click();
		return new SearchResultsPage(driver);
		
	}

}
