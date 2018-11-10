package pages.locators;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LCHomePageLocator {

    @FindBy(
            how = How.XPATH,
            using = "//input[@id='search']"
    )
    public WebElement search;

    @FindBy(
            how = How.CLASS_NAME,
            using = "Search--submitBtn"
    )
    public WebElement searchButton;
    @FindBy(
            how = How.LINK_TEXT,
            using = "Excavating & Earthmovers"
    )
    public WebElement searchcategory;
}


//~ Formatted by Jindent --- http://www.jindent.com
