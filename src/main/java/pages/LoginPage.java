package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommanUtils;
import utils.ElementUtils;

public class LoginPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	public  LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMassage;

	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}
	public void enterPassword(String PasswordText) {
		elementUtils.typeTextIntoElement(passwordField, PasswordText, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}
	public AccountPage clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton, CommanUtils.EXPLICIT_WAIT_BASICTIME);
		return new AccountPage(driver);
	}
	public String  getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMassage, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

}
