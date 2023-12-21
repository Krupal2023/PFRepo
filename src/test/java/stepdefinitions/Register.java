package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.Registerpage;
import utils.CommanUtils;

public class Register {
	WebDriver driver;
	private Registerpage registerpage;
	private AccountSuccessPage accountsuccesspage;
	private CommanUtils commanutils;
	private DriverFactory driverfactory;

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {

		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();
	}

	@When("User enters details into below fileds")
	public void user_enters_details_into_below_fileds(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		commanutils = new CommanUtils();
		registerpage = new Registerpage(driver);
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(commanutils.getEmailWithTimeStamp());
		registerpage.eneterTelephoenNumber((dataMap.get("telephone")));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("password"));
	}

	@When("User enters details into below fileds with duplicate email")
	public void User_enters_details_into_below_fileds_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerpage = new Registerpage(driver);
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(dataMap.get("email"));
		registerpage.eneterTelephoenNumber((dataMap.get("telephone")));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("password"));

	}

	@And("User clicks on privacy policy")
	public void user_clicks_on_privacy_policy() {
		registerpage.selectPrivacyPolicy();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountsuccesspage = registerpage.clickOnContinueButton();

	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountsuccesspage.getPageHeading());

	}

	@And("User selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		registerpage.selectYesNewsletterOption();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {

		Assert.assertTrue(
				registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));

	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		registerpage.enterFirstName("");
		registerpage.enterLastName("");
		registerpage.enterEmailAddress("");
		registerpage.eneterTelephoenNumber("");
		registerpage.enterPassword("");
		registerpage.enterConfirmPassword("");

	}

	@Then("User should get proper warning massages for every mandatory fields")
	public void user_should_get_proper_warning_massages_for_every_mandatory_fields() {
//		Assert.assertTrue(
//				registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));

		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getFirstNameWarning());

		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getEmailNameWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerpage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getPasswordWarning());

	}

}
