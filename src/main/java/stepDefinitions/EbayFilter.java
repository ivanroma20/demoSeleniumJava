package stepDefinitions;

import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class EbayFilter extends DriverFactory {
	@Given("^I access ebay website$")
	public void i_access_ebay_website() throws Throwable {
		Reporter.addStepLog("Accessing ebay website");
		homePage.getIndexEbay();
		
	}

	@Given("^I enter 'shoes' in box$")
	public void i_enter_shoes_in_box() throws Throwable {
		homePage.enterCategoryName("shoes");

	}

	@When("^I click on the search button$")
	public void i_click_on_the_search_button() throws Throwable {
		homePage.clickOnSubmiButton();
	}

	@When("^I select brand$")
	public void i_select_brand() throws Throwable {
		filtersPage.selectBrand();
	}

	@When("^I select size$")
	public void i_select_size() throws Throwable {
		filtersPage.selectSize();

	}

	@When("^I order of ascending form$")
	public void i_order_of_ascending_form() throws Throwable {

		filtersPage.mouseOverAndClick();
	}

	@Then("^The order the first (\\d+) results should be correct$")
	public void the_order_the_first_results_should_be_correct(int arg1) throws Throwable {
		Assert.assertEquals(true, filtersPage.assertOrderResults());  // si los precios están ordenados ascedentemente retorna true
		System.out.println("I-Número de resultados: "+"\n"+filtersPage.printNumberResults());
		System.out.println("II-5 primeros (Nombres & Precios) : " + filtersPage.showNamePrice());
		System.out.println("III-Nombres Ordenados ascendentemente : " + filtersPage.showNamesAsc());
		System.out.println("IV-Precios Ordenados descendentemente : " + filtersPage.showPricesDsc());

	}


}
