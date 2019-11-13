package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class ShoppingCartSummaryPage extends HomePage{

    private static String verifyCartSummary_xpath = "//h1[@id='cart_title']";
    private static String cartDescription_xpath = "//td[@class='cart_description']";
    private static String productName_xpath = "/p[@class='product-name']/a";
    private static String productAttributes_xpath = "/small/a";
    private static String productQuantity_xpath = "//td[contains(@class,'cart_quantity')]/input[contains(@class,'cart_quantity_input')]";


    // The longest number of seconds we will wait for something to appear on the page
    // For carts we will be more generous
    private static int waitTime = 10;

    public ShoppingCartSummaryPage(BrowserDriver driver){
        super(driver);
    }

    /*
    Verify the application is currently displaying the expected page
     */
    public static void verifyCorrectPage() {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyCartSummary_xpath)));
        Assert.assertTrue((driver.findElement(By.xpath(verifyCartSummary_xpath)) != null), "We're not on the expected page: Shopping Cart Summary");
    }

    /*
    Verify the cart contains the expected product, and its details
    Future work would extend this function to handle multiple products in the cart
     */
    public static void verifyCartContents(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        SoftAssert sa = new SoftAssert();

        // Get the expected values
        String expectedProductName = list.get(0).get("Product Name");
        String expectedProductColour = list.get(0).get("Colour");
        String expectedProductSize = list.get(0).get("Size");
        String expectedProductQuantity = list.get(0).get("Quantity");

        // The first 3 thngs to verify are in the "Description" column of the table
        String actualProductName = driver.findElement(By.xpath(cartDescription_xpath + productName_xpath)).getText();
        String actualProductColour = driver.findElement(By.xpath(cartDescription_xpath + productAttributes_xpath)).getText().split("[:,]")[1].trim();
        String actualProductSize = driver.findElement(By.xpath(cartDescription_xpath + productAttributes_xpath)).getText().split("[:,]")[3].trim();
        // Quantity is in its own column
        String actualProductQuantity = driver.findElement(By.xpath(productQuantity_xpath)).getAttribute("value");

        sa.assertEquals(expectedProductName, actualProductName, "Product Names don't match:");
        sa.assertEquals(expectedProductColour, actualProductColour, "Product Colours don't match:");
        sa.assertEquals(expectedProductSize, actualProductSize, "Product Sizes don't match:");
        sa.assertEquals(expectedProductQuantity, actualProductQuantity, "Product Quantities don't match:");
        sa.assertAll();
    }
}
