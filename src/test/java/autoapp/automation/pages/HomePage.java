package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class HomePage extends BrowserDriver{

	private static String homePageUrl = "http://automationpractice.com/index.php";

	private static String signIn_xpath = "//a[@title='Log in to your customer account']";
	private static String dresses_xpath = "//div[@id='block_top_menu']/ul/li/a[@title='Dresses']";
	private static String casualDresses_xpath = "//li/a[@title='Casual Dresses']";
	private static String eveningDresses_xpath = "//li/a[@title='Evening Dresses']";
	private static String summerDresses_xpath = "/../ul/li/a[@title='Summer Dresses']";

	private static String viewCartLink_xpath = "//div[@class='shopping_cart']/a[@title='View my shopping cart']";
	private static String cartCheckOut_xpath = "//a[@id='button_order_cart']";

	// The longest number of seconds we will wait for something to appear on the page
	private static int waitTime = 5;

	public HomePage(BrowserDriver driver){
		super(driver);
	}

	public static int generateRandomIntIntRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static void openApplication() {
		driver.navigate().to(homePageUrl);
		driver.manage().window().maximize();
	}

	public static void clickSignIn() {
		driver.findElement(By.xpath(signIn_xpath)).click();
	}

	/*
	This method is designed with extensibility in mind; in theory it should be able to handle the user clicking on
	any link in the Homepage, to navigate somewhere else
	 */
	public static void navigateTo(String pageName, boolean useMegaMenu) throws InterruptedException {
		String mainOption = "";
		String subOption = "";

		// If navigating via the mega menu, we need to first hover over the relevant top level menu item
		if(useMegaMenu) {
			mainOption = dresses_xpath;
			switch(pageName.toLowerCase()) {
				case "casual dresses":
					subOption = casualDresses_xpath;
					break;
				case "evening dresses":
					subOption = eveningDresses_xpath;
					break;
				case "summer dresses":
					subOption = summerDresses_xpath;
					break;
				default:
					System.out.println("Unknown page '" + pageName + "; skipping this navigation");
			}

			// From https://artoftesting.com/mouse-hover-in-selenium-webdriver-java
			Actions action = new Actions(driver);
			WebElement elem = driver.findElement(By.xpath(dresses_xpath));
			// the simple (and recommended) action below only worked for chromedriver, but not geckodriver
			// action.moveToElement(elem).perform();
			// The solution below seems to work for both browsers, googled and adapted from
			// https://stackoverflow.com/questions/48881989/is-there-any-alternate-way-to-do-mouse-hover-in-selenium-box-using-java-1-8-geck
			// EDIT: I've found this to be a little hit-and-miss for geckodriver (it sometimes fails to trigger the expected event
			// from the mouseOver action, such as showing a drop-down)
			action.moveToElement(elem).moveToElement( driver.findElement(By.xpath(dresses_xpath))).build().perform();

			// Use Implicit Wait to wait for the submenu to appear
			WebDriverWait wait = new WebDriverWait(driver, waitTime);

			// Combining the main and sub xpaths was the only way I could correctly locate the Megamenu element
			// Without the main xpath, I think Selenium located another element with the same criteria, which led to
			// "org.openqa.selenium.ElementNotInteractableException: element not interactable"
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainOption + subOption)));
			driver.findElement(By.xpath(mainOption + subOption)).click();
		}
		else // Navigate without using a Megamenu
			{
			switch(pageName.toLowerCase()) {
				case "cart summary":
					mainOption = viewCartLink_xpath;
					Actions action = new Actions(driver);
					WebElement elem = driver.findElement(By.xpath(mainOption));
					action.moveToElement(elem).moveToElement( driver.findElement(By.xpath(mainOption))).build().perform();

					// Use Implicit Wait to wait for the expanded cart to appear
					WebDriverWait wait = new WebDriverWait(driver, waitTime);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartCheckOut_xpath)));
					driver.findElement(By.xpath(cartCheckOut_xpath)).click();

					break;
				default:
					System.out.println("Unknown page '" + pageName + "; skipping this navigation");
			}
			if(mainOption != "") {
				driver.findElement(By.xpath(mainOption)).click();
			}
		}
	}
}
