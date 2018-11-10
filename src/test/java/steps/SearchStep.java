package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.actions.*;

import static org.testng.Assert.assertEquals;
import static utils.SeleniumDriver.*;

public class SearchStep {
    public static WebDriver driver = null;
    pages.actions.SearchActions searchActions = new SearchActions();

    @Given("^I am on the Home Page of Website \"([^\"]*)\"$")
    public void i_am_on_the_Home_Page_of_Website(String webSiteURL) throws Throwable {
        openPage(webSiteURL);
        String a = getPageTitle();
        assertEquals(a, "Localsearch | It's how the locals search!" );

    }


    @When("^I enter \"([^\"]*)\" in the search field$")
    public void i_enter_in_the_search_field(String searchword) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    searchActions.search(searchword);
    }

    @When("^I click search key$")
    public void i_click_search_window() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     searchActions.clickSearch();
     searchActions.clickOnResult();
    }
    @Then("^the search \"([^\"]*)\" should match$")
    public void the_search_should_be_displayed(String businessProfileName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getPageTitle();

        searchActions.verifyTheResult(businessProfileName);
    }

    @When("^I click on any \"([^\"]*)\" item from popular searches$")
    public void i_click_on_any_item_from_popular_searches(String category) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        searchActions.clickPopular();
    }

    @When("^choose an item from the list$")
    public void choose_an_item_from_the_list() throws Throwable {

        searchActions.clickOnResult();
    }

}
