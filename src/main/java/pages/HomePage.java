package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommanUtils;
import utils.ElementUtils;

public class HomePage {
	WebDriver driver;
	private ElementUtils elementUtils;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public SearchResultPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, CommanUtils.EXPLICIT_WAIT_BASICTIME);
		return new SearchResultPage(driver);
	}
		
	public void enterProductIntoSearchBoxField(String ProductText) {
		elementUtils.typeTextIntoElement(searchBoxField, ProductText, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	}
	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(loginOption, CommanUtils.EXPLICIT_WAIT_BASICTIME);
		return new LoginPage(driver);
	}
	public Registerpage selectRegisterOption() {
		elementUtils.clickOnElement(registerOption, CommanUtils.EXPLICIT_WAIT_BASICTIME);
		return new Registerpage(driver);
	}

}
