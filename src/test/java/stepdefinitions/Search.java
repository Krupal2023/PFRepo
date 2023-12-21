package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
	WebDriver driver;
	private HomePage homepage;
	private SearchResultPage searchresultpage;
	private DriverFactory driverfactory;

	@Given("User opens the application")
	public void user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String productvalidProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductIntoSearchBoxField(productvalidProductText);
	}

	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
		searchresultpage = homepage.clickOnSearchButton();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(searchresultpage.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		homepage=new HomePage(driver);
		homepage.enterProductIntoSearchBoxField(invalidProductText);

	}

	@Then("User should get a massage about no product matching")
	public void user_should_get_a_massage_about_no_product_matching() {

		Assert.assertEquals("There is no product that matches the search criteria."

				, searchresultpage.getMeassageText());
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		homepage = new HomePage(driver);
	}

}
