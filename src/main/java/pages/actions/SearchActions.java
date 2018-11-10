package pages.actions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.locators.LCHomePageLocator;
import pages.locators.LCResultPageLocator;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

import static org.testng.Assert.assertEquals;
import static utils.SeleniumDriver.scrollToTop;


public class SearchActions {
    LCHomePageLocator lcHomePage = null;
    LCResultPageLocator lcResultPage = null;


    public SearchActions()
    {
        this.lcHomePage = new LCHomePageLocator();
        this.lcResultPage = new LCResultPageLocator();
        PageFactory.initElements(SeleniumDriver.getDriver(), lcHomePage);
        PageFactory.initElements(SeleniumDriver.getDriver(), lcResultPage);
    }
    public void search(String searchkey) {
        lcHomePage.search.click();
        lcHomePage.search.sendKeys(searchkey);
    }
    public void clickSearch(){
        SeleniumHelper.isVisableAndClickable(lcHomePage.searchButton);
        lcHomePage.searchButton.click();

    }

    public void clickOnResult() {
        //assertEquals(Result + " has been added.", lcResultPage.resultCcheck.getText());

        SeleniumHelper.waitForPageToLoad();
        scrollToTop();
        Actions action = new Actions(SeleniumDriver.getDriver());
        SeleniumHelper.isElementEnabled(lcResultPage.resultClick);
        SeleniumHelper.isVisableAndClickable(lcResultPage.resultClick);
        action.moveToElement(lcResultPage.resultClick).perform();
        lcResultPage.resultClick.click();
     }

    public void verifyTheResult(String businessProfileName)
    {
        assertEquals(lcResultPage.resultCheck.getText(), businessProfileName);
    }

    public void clickPopular()
    {

        lcHomePage.searchcategory.click();
    }
}
