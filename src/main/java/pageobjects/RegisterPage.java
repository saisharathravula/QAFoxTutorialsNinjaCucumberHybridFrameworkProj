package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameTextField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameTextField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressTextField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneTextField;
	
	@FindBy(id="input-password")
	private WebElement passwordTextField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmTextField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesToNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessageOfDuplicateEmailAddress;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessageOfPrivacyPolicy;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement warningMessageOfFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement warningMessageOfLastName;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement warningMessageOfEmailAddress;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement warningMessageOfTelephone;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement warningMessageOfPassword;
	
	public void enterFirstNameText(String firstNameText) {
		
		elementUtils.typeTextIntoElement(firstNameTextField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or firstNameTextField.sendKeys(firstNameText);
		
	}
	
	public void enterLastNameText(String lastNameText) {
		
		elementUtils.typeTextIntoElement(lastNameTextField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or lastNameTextField.sendKeys(lastNameText);
		
	}
	
	public void enterEmailAddressText(String emailAddressText) {
		
		elementUtils.typeTextIntoElement(emailAddressTextField, emailAddressText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or emailAddressTextField.sendKeys(emailAddressText);
		
	}
	
	public void enterTelephoneText(String telephoneText) {
		
		elementUtils.typeTextIntoElement(telephoneTextField, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or telephoneTextField.sendKeys(telephoneText);
		
	}
	
	public void enterPasswordText(String passwordText) {
		
		elementUtils.typeTextIntoElement(passwordTextField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or passwordTextField.sendKeys(passwordText);
		
	}
	
	public void enterPasswordConfirmText(String passwordConfirmText) {
		
		elementUtils.typeTextIntoElement(passwordConfirmTextField, passwordConfirmText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or passwordConfirmTextField.sendKeys(passwordConfirmText);
		
	}
	
	public void clickOnPrivacyPolicyCheckBox() {
		
		elementUtils.clickOnElement(privacyPolicyCheckBox, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or privacyPolicyCheckBox.click();
		
	}
	
	public AccountCreatedSuccessPage clickOnContinueButton() {
		
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or continueButton.click();
		return new AccountCreatedSuccessPage(driver);
		
	}
	
	public void selectYesToNewsLetterOption() {
		
		elementUtils.clickOnElement(yesToNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or yesToNewsLetterOption.click();
		
	}
	
	public String displayStatusOfWarningMessageOfDuplicateEmailAddress() {
		
		return elementUtils.getTexFromElement(warningMessageOfDuplicateEmailAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return warningMessageOfDuplicateEmailAddress.getText();
		
	}
	
	public String displayStatusOfWarningMessageOfPrivacyPolicy() {
		
		return elementUtils.getTexFromElement(warningMessageOfPrivacyPolicy, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return warningMessageOfPrivacyPolicy.getText();
		
	}
	
	public String displayStatusOfWarningMessageOfFirstName() {
		
		return elementUtils.getTexFromElement(warningMessageOfFirstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return warningMessageOfFirstName.getText();
		
	}
	
	public String displayStatusOfWarningMessageOfLastName() {
		
		return elementUtils.getTexFromElement(warningMessageOfLastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return warningMessageOfLastName.getText();
		
	}
	
	public String displayStatusOfWarningMessageOfEmailAddress() {
		
		return elementUtils.getTexFromElement(warningMessageOfEmailAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return warningMessageOfEmailAddress.getText();
		
	}
	
	public String displayStatusOfWarningMessageOfTelephone() {
		
		return elementUtils.getTexFromElement(warningMessageOfTelephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return warningMessageOfTelephone.getText();
		
	}
	
	public String displayStatusOfWarningMessageOfPassword() {
		
		return elementUtils.getTexFromElement(warningMessageOfPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return warningMessageOfPassword.getText();
		
	}
	

}
