package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;
    static String DefaultBrowser = "chrome";
    private static SeleniumDriver seleniumDriver;
    private static WebDriver driver;
    private static WebDriverWait waitDriver;

    private SeleniumDriver(String Browser) {
        if (Browser.matches("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            final FirefoxOptions firefoxOptions = new FirefoxOptions();

            firefoxOptions.setHeadless(true);
            driver = new FirefoxDriver(firefoxOptions);
        }

        if (Browser.matches("chrome")) {
            WebDriverManager.chromedriver().setup();

            final ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.setHeadless(true);
            chromeOptions.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(chromeOptions);
        }

        driver.manage().window().maximize();
        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        String window = driver.getWindowHandle();

        System.out.println("Window ->" + window);
    }

    public static void openPage(String url) {
        System.out.println(url);
        System.out.println(driver);
        driver.get(url);
    }

    public static String getPageTitle() {
        String Title = driver.getTitle();
        System.out.println(Title);
        return Title;
    }

    public static void tearDown() {
        if (driver != null) {
            // driver.close();
            driver.quit();
        }

        seleniumDriver = null;
    }

    public static void waitForPageToLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    //https://seleniumjava.com/2017/05/21/how-to-run-scripts-in-a-specific-browser-with-maven/
    private static String getParameter(String name) {
        String value = System.getProperty(name);

        if (value == null) {
            value = DefaultBrowser;
            //throw new RuntimeException(name + " is not a parameter!");
        }

        if ("".equals(value)) {
            value = DefaultBrowser;
            //throw new RuntimeException(name + " is empty!");
        }

        return value;
    }

    public static void setUpDriver() {
        if (seleniumDriver == null) {
            String browserName = getParameter("browser");

            seleniumDriver = new SeleniumDriver(browserName);
        }
    }

//scroll to the top of the page
    public static void scrollToTop()
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,-10000)");
    }


}


//~ Formatted by Jindent --- http://www.jindent.com
