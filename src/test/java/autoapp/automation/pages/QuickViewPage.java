package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*
Since QuickView is implemented as an iFrame, we will need to use Webdriver.switchTo() in order to interact with the iFrame
and its contents
 */
public class QuickViewPage extends HomePage{

    private static String quickViewCloseBtn_xpath = "//a[@title='Close' and contains(@class,'fancybox-close')]";
    private static String verifyQuickViewFrame_xpath = "//iframe[@class='fancybox-iframe']";
    private static String colourPicker_xpath = "//ul[@id='color_to_pick_list']/li/a";
    private static String addToCart_xpath = "//button[@name='Submit']";

    // The longest number of seconds we will wait for something to appear on the page
    // For iFrames we will be more generous
    private static int waitTime = 10;

    public QuickViewPage(BrowserDriver driver){
        super(driver);
    }

    /*
    Verify the application is currently displaying the expected page
     */
    public static void verifyCorrectPage() {
        // Wait for the QuickView (iFrame) to appear, occasionally it takes some time to fully load
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyQuickViewFrame_xpath)));
        Assert.assertTrue((driver.findElement(By.xpath(verifyQuickViewFrame_xpath)) != null), "We're not on the expected page: Quick View");
    }

    public static void selectColour(String colour) {
        WebElement frame = driver.findElement(By.xpath(verifyQuickViewFrame_xpath));
        driver.switchTo().frame(frame.getAttribute("id"));

        // Verify whether the colour exists for the given product first
        // Xpath is case-sensitive, therefore the name of the colour must be exactly as per the page HTML (eg, "Blue")
        // To make this more robust, we can either import a library or write custom code to convert the colour string
        // into camel case, for example https://www.baeldung.com/java-string-title-case
        WebElement colourElem = null;

        // Here I started by using a SoftAssert, but driver.findElement() throws an exception if it can't locate the
        // element, so I can't evaluate the true/false in time
        // The other issue is, even if I had a SoftAssert inside the if() condition, upon assertion failure I found that
        // Selenium skipped the remaining test steps which I don't want
        try {
            colourElem = driver.findElement(By.xpath(colourPicker_xpath + "[@name='" + colour + "']"));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to locate the colour '" + colour + "', so the default colour remains selected");
        }

        if(colourElem != null) {
           colourElem.click();
        }

        // Switch the frame back to the default, in case the next step wants to interact with something else
        driver.switchTo().defaultContent();
    }

    public static void clickAddToCart() {
        WebElement frame = driver.findElement(By.xpath(verifyQuickViewFrame_xpath));
        driver.switchTo().frame(frame.getAttribute("id"));

        driver.findElement(By.xpath(addToCart_xpath)).click();

        // Switch the frame back to the default, in case the next step wants to interact with something else
        driver.switchTo().defaultContent();
    }
}
