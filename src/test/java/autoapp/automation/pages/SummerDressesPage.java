package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SummerDressesPage extends ProductPage {

    private static String summerDressesUniqueText = "Short dress, long dress, silk dress, printed dress, you will find the perfect dress for summer.";

    public SummerDressesPage(BrowserDriver driver){
        super(driver);
    }

    /*
    Verify the application is currently displaying the expected page
    For a specific productset page, it's more tricky because there aren't that many elements which are unique to that productset
    (images aside)
     */
    public static void verifyCorrectPage() {

        Assert.assertTrue((driver.findElement(By.xpath("//div[text()='" + summerDressesUniqueText + "']")) != null), "We're not on the expected page: Summer Dresses");
    }
}
