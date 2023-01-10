package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginSuccessPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  LoginSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(linkText="Change your password")
	private WebElement changeYourPasswordOption;
	
	public boolean displayStatusOfChangeYourPasswordOption() {
		
		return elementUtils.getDisplayStatusOfElement(changeYourPasswordOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//or return changeYourPasswordOption.isDisplayed(); 
		
	}

}
