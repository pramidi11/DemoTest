package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;

public abstract class ProductPage extends HomePage{

    private static Map<String, Integer> productsMap = new HashMap<String, Integer>();
    private static String productAddedPopup_id = "layer_cart";
    private static String productName_id = "layer_cart_product_title";
    private static String productAttributes_id = "layer_cart_product_attributes";
    private static String productQuantity_id = "layer_cart_product_quantity";
    private static String productAddedPopupClose_xpath = "//span[@class='cross' and @title='Close window']";

    // The longest number of seconds we will wait for something to appear on the page
    private static int waitTime = 5;

    public ProductPage(BrowserDriver driver){
        super(driver);
    }

    public static void loadProducts() {
        productsMap.put("printed summer dress (1)", 5);
        productsMap.put("printed summer dress (2)", 6);
        productsMap.put("printed chifon dress", 7);
    }

    /*
    Verify the application is currently displaying the expected page
     */
    public static void verifyCorrectPage() {
    }

    /*
   The names of some products are the same, so the name is not a unique identifier.
   Therefore I've chosen to identify by numerical productId, which means I need a mapping between name and productId
   I'm not totally convinced the map should be associated with this ProductPage class, however it's true that the
   single product numbering system applies across all product sets (dresses, blouses, etc).
 */
    public static void selectQuickViewOf(String productName) {
        int productId = -1;
        String imageXpath = "", quickViewXpath = "";

        if(productsMap.containsKey(productName.toLowerCase())) {
            productId = productsMap.get(productName.toLowerCase());
        } else {
            Assert.fail("Unknown product '" + productName + "'");
        }

        // This may only work in the Desktop display. The xpaths appear to be different if the site is being rendered in
        // the mobile/responsive display
        // First hover over the image to bring up the quick view icon, then click on that icon
        imageXpath = "//a[@class='product_img_link' and contains(@href,'id_product=" + productId + "&controller=product')]";
        quickViewXpath = "//a[@class='quick-view' and contains(@href,'id_product=" + productId + "&controller=product')]";
        Actions action = new Actions(driver);
        WebElement elem = driver.findElement(By.xpath(imageXpath));
        action.moveToElement(elem).perform();

        driver.findElement(By.xpath(quickViewXpath)).click();
    }


    public static void verifyProductAddedPopupAppears() {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(productAddedPopup_id)));
        Assert.assertTrue((driver.findElement(By.id(productAddedPopup_id)) != null), "The popup has not appeared");
    }

    public static void closeProductAddedPopup() {
        driver.findElement(By.xpath(productAddedPopupClose_xpath)).click();
    }
}
