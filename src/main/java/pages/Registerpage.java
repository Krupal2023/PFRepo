package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommanUtils;
import utils.ElementUtils;

public class Registerpage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public Registerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyOption;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div ")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div ")
	private WebElement passwordWarning;

	public String getFirstNameWarning() {
		return elementUtils.getTextFromElement(firstNameWarning, CommanUtils.EXPLICIT_WAIT_BASICTIME);

	}

	public String getLastNameWarning() {
		return elementUtils.getTextFromElement(lastNameWarning, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public String getEmailNameWarning() {
		return elementUtils.getTextFromElement(emailWarning, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public String getTelephoneWarning() {
		return elementUtils.getTextFromElement(telephoneWarning, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public String getPasswordWarning() {
		return elementUtils.getTextFromElement(passwordWarning, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public void enterFirstName(String firstNameText) {
		elementUtils.typeTextIntoElement(firstNameField, firstNameText,CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public void enterLastName(String lastNameText) {
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public void eneterTelephoenNumber(String telephoneText) {
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public void enterPassword(String passwordtext) {
		elementUtils.typeTextIntoElement(passwordField, passwordtext, CommanUtils.EXPLICIT_WAIT_BASICTIME);

	}

	public void enterConfirmPassword(String passwordtext) {
		elementUtils.typeTextIntoElement(passwordConfirmField, passwordtext, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicyOption, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, CommanUtils.EXPLICIT_WAIT_BASICTIME);
		return new AccountSuccessPage(driver);
	}

	public void selectYesNewsletterOption() {
		elementUtils.clickOnElement(yesNewsLetterOption, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}

}
