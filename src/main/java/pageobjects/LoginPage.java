package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(name="email")
	private WebElement emailAddressOptionField;
	
	@FindBy(name="password")
	private WebElement passwordAddressOptionField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessageForWrongCredentials;
	
	public void enterEmailAddressText(String emailAddressText) {
		
		elementUtils.typeTextIntoElement(emailAddressOptionField, emailAddressText, 15);
		//or emailAddressOptionField.sendKeys(emailAddressText);
		
	}
	
	public void enterPasswordAddressText(String passwordText) {
		
		elementUtils.typeTextIntoElement(passwordAddressOptionField, passwordText, 15);
		//or passwordAddressOptionField.sendKeys(passwordText);
		
	}
	
	public LoginSuccessPage clickOnLoginButton() {
		
		
		elementUtils.clickOnElement(loginbutton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or loginbutton.click();
		return new LoginSuccessPage(driver);
		
	}
	
	public String getWarningMessageText() {
		
		return elementUtils.getTexFromElement(warningMessageForWrongCredentials, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return warningMessageForWrongCredentials.getText();
		
	}
	

}
