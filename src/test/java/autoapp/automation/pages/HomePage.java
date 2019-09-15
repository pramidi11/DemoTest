package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import autoapp.automation.utility.Helper;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {

    public static String mainMenu_xpath = "//div/div[6]/ul/li[i]/a";
    public static String dresses_subMenu_xpath = "//div/div[6]/ul/li[2]/ul/li[i]/a";
    public  static  String summer_dresses_xpath="//h1[@class='page-heading product-listing']//span[@class='cat-name' and contains(text(),'Summer Dresses')]";
    public  static  String product_link_text="Faded Short Sleeve T-shirts";

    public HomePage(BrowserDriver driver) {
        super(driver);
    }

    public static void hoverMouseOnMenu(Helper.MAIN_MENU mainMenu) {
       int menuIndex = mainMenu.getValue();
        String newXpath=mainMenu_xpath.replaceFirst("\\[i\\]","[" + menuIndex +"]");
        Helper.mouseMouseToElement(driver, driver.findElement(By.xpath(newXpath)));
    }
    public static void validateSubMenuAvailable(Helper.DRESSES_MENU dressesSubMenu) {
        int menuIndex = dressesSubMenu.getValue();
        String newXpath=dresses_subMenu_xpath.replaceFirst("\\[i\\]","[" + menuIndex +"]");
        assertTrue( Helper.isPresent(driver,By.xpath(newXpath)));
    }
    public static void clickSubMenu(Helper.DRESSES_MENU dressesSubMenu) {
        int menuIndex = dressesSubMenu.getValue();
        String newXpath=dresses_subMenu_xpath.replaceFirst("\\[i\\]","[" + menuIndex +"]");
        driver.findElement(By.xpath(newXpath)).click();
    }
    public static void validateSummerDressesPageLoaded() {
        assertTrue( Helper.isPresent(driver,By.xpath(summer_dresses_xpath)));
    }
    public static void selectAProduct() {
       driver.findElement(By.linkText(product_link_text)).click();
    }
}
