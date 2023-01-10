package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountCreatedSuccessPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountCreatedSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement yourAccountHasBeenCreatedText;
	
	public String displayStatusOfYourAccountHasBeenCreatedText() {
		
		return elementUtils.getTexFromElement(yourAccountHasBeenCreatedText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return yourAccountHasBeenCreatedText.getText();
		
	}

}
