package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiter.Waiter;


public class SeleniumHelper {
    private static WebDriver driver;
    private Waiter waiter = new Waiter();



    public static boolean isElementEnabled(WebElement webElement) {
        try {
            boolean isEnabled = webElement.isEnabled();

            return isEnabled;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            boolean isPresent = webElement.isDisplayed();

            return isPresent;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isVisableAndClickable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //select the dropdown using "select by visible text", so pass VisibleText as 'Yellow' to funtion
    public static void selectddbyText(WebElement WE, String VisibleText){
        Select selObj=new Select(WE);
        selObj.selectByVisibleText(VisibleText);
    }

    //select the dropdown using "select by index", so pass IndexValue as '2'
    public static void selectddbyIndex(WebElement WE, int IndexValue){
        Select selObj=new Select(WE);
        selObj.selectByIndex(IndexValue);
    }

    //select the dropdown using "select by value", so pass Value as 'thirdcolor'
    public static void selectddbyValue(WebElement WE, String Value){
        Select selObj=new Select(WE);
        selObj.selectByValue(Value);
    }


    public static void waitForPageToLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }


}


//~ Formatted by Jindent --- http://www.jindent.com
