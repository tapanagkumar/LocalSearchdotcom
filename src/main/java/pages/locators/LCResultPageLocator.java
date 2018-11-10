package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LCResultPageLocator {

    @FindBy(
            how = How.CLASS_NAME,
            using = "ListViewTitle__keyWordDisplay"
    )
    public WebElement resultConfirm;

    @FindBy(
            how = How.XPATH,
            using = "(.//*[normalize-space(text()) and normalize-space(.)='Read More'])[1]/following::a[1]"

    )
    public WebElement resultClick;

    @FindBy(
            how = How.ID,
            using = "businessProfileName"
    )
    public WebElement resultCheck;


}


//~ Formatted by Jindent --- http://www.jindent.com
