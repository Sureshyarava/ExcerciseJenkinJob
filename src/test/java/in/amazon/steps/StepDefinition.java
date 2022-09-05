package in.amazon.steps;

import in.amazon.common.TestBase;
import in.amazon.pageobjects.AmazonHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class StepDefinition extends TestBase {
    AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
    static List<WebElement> listOfResultsAfterApplyingFilter;

    @Given("the user is at Amazon Home Page")
    public void amazon_page_is_open() {
        assertTrue(amazonHomePage.isOpen());
    }

    @When("the user searches for {string} in the search bar")
    public void theUserSearchForInTheSearchBar(String product) {
        amazonHomePage.searchProduct(product);
    }

    @Then("the user gets the search results")
    public void i_should_get_a_series_of_results() {
        assertTrue(amazonHomePage.areResultsVisible());
    }

    @Given("search results for {string} are shown")
    public void searchResultsForAreShown(String Product) {
        assertTrue(amazonHomePage.areResultsVisible());
    }

    @When("user selects the {string} under Delivery Day section")
    public void i_select_the_checkbox_under_delivery_day_section(String deliveryDayOption) {
        amazonHomePage.selectDeliveryDay(deliveryDayOption);
    }

    @Then("the user gets the filtered search results")
    public void i_should_get_filtered_series_of_results() {
        assertTrue(amazonHomePage.areResultsVisible());
        listOfResultsAfterApplyingFilter = amazonHomePage.getProductSearchResults();
    }

    @And("the user verifies the results obtained using this {string}")
    public void verifyTheResultsObtainedUsingThis(String product) {
        for (WebElement element : listOfResultsAfterApplyingFilter) {
            List<String> results = amazonHomePage.verifyProduct(element);
            assertTrue(results.get(0).equals(results.get(1)));
        }
    }



}
