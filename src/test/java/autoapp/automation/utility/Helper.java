package autoapp.automation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    public enum DRESSES_MENU{
        CASUAL_DRESSES(1),
        EVENING_DRESSES(2),
        SUMMER_DRESSES(3);
        private final int value;

        DRESSES_MENU(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
    }
    public enum MAIN_MENU{
        WOMEN(1),
        DRESSES(2),
        T_SHIRTS(3);
        private final int value;

        MAIN_MENU(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
        }

    public static boolean isPresent(WebDriver webdriver, By selector) {
        // try to find element by specified selector
        try {
            webdriver.findElement(selector);
        } catch (NoSuchElementException e) {
            // if element not exist return false
            return false;
        }
        return true;
    }

    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.visibilityOfElementLocated(selector));
        return element;
    }
    public static void mouseMouseToElement(WebDriver driver, WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }
}