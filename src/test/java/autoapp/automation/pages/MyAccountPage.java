package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class MyAccountPage extends HomePage{
    private static String verifyMyAccountPage_xpath = "//p[@class='info-account']";

    public MyAccountPage(BrowserDriver driver){
        super(driver);
    }

    /*
    Verify the application is currently displaying the expected page
     */
    public static void verifyCorrectPage() {
        // Normally I would use the visible page title to verify that we've landed on the correct page, but the structure
        // of some websites may cause such an approach to lead to false positives
        Assert.assertTrue((driver.findElement(By.xpath(verifyMyAccountPage_xpath)) != null), "We're not on the expected page: My Account");
    }
}
