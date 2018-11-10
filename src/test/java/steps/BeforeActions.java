package steps;

import cucumber.api.java.Before;
import utils.SeleniumDriver;

public class BeforeActions {
    @Before
    public static void setUp() {
        System.out.println("Before");
        SeleniumDriver.setUpDriver();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
