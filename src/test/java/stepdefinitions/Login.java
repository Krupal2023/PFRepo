package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommanUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accoutpage;
	private CommanUtils commanutils;
	private DriverFactory driverfactory;

	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();

	}

	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText) {

		loginpage.enterEmailAddress(emailText);
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		loginpage.enterPassword(passwordText);

	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		accoutpage = loginpage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(accoutpage.displayStatusOfEditYourAccountInformationOption());

	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		commanutils = new CommanUtils();
		loginpage.enterEmailAddress(commanutils.getEmailWithTimeStamp());

	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswardText) {
		loginpage.enterPassword(invalidPasswardText);

	}

	@Then("User should get proper warning massage about credentials missmatch")
	public void user_should_get_proper_warning_massage_about_credentials_missmatch() {
		;
		Assert.assertTrue(
				loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {

		loginpage.enterEmailAddress("");
	}

	@And("user dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginpage.enterPassword("");
	}

}
