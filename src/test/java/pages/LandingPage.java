package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	private static final int implicitTimeout = 10;

	public static void hoverOver(WebDriver driver, String menu1) {
//        String menu_link = "a[title='" + menu1 + "']";
        String menu_link = "a[title='Dresses']";

        Actions action = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector(menu_link));
        action.moveToElement(menu).perform();
	}

	public static void clickNavigation(WebDriver driver, String navigation) {
        String navigation_link = "a[title='" + navigation + "']";

        WebDriverWait clickable_wait = new WebDriverWait(driver, implicitTimeout);
        WebElement menu_item = clickable_wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(navigation_link)));
        menu_item.click();
        //driver.findElement(By.cssSelector(navigation_link)).click();
	}

	public static void menuNavigation(WebDriver driver, String menu1, String menu2) {
        String menu1_link = "a[title='" + menu1 + "']";
        
        WebDriverWait clickable_wait = new WebDriverWait(driver, implicitTimeout);
        WebElement menu_item = clickable_wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(menu1_link)));
        menu_item.click();

		Actions action = new Actions(driver);
		System.out.println("I'm going to exit!");
		//WebElement topMenu = driver.findElement(By.cssSelector("a[title='Dresses']"));
//		action.moveToElement(topMenu).moveToElement(driver.findElement(By.cssSelector("a[title='Summer Dresses']"))).click().build().perform();
	}

}
