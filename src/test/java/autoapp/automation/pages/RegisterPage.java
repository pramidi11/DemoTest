package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;


public class RegisterPage extends BasePage {

    public static String signIn_xpath = "//a[@title='Log in to your customer account']";
    public static String email_id = "email_create";
    public static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";
    private static By createAccountError = By.id("create_account_error");
    private static String megaMenuItem = "ul.sf-menu>li>a[title='MENUITEM']";
    private static String subMenuItem = "li.sfHover a[title='MENUITEM']";

    public RegisterPage(BrowserDriver driver) {

        super(driver);
    }

    public static void openApplicaiton() {
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    public static void clickSignIn() {
        driver.findElement(By.xpath(signIn_xpath)).click();
    }

    public static void createAccount(String emailid) {
        emailid = emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        driver.findElement(By.id(email_id)).sendKeys(emailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }

    public static String getCreateAccountError() {
        waitUntilElementIsVisible(driver, driver.findElement(createAccountError));
        return driver.findElement(createAccountError).getText();
    }

    public static void hoverOnMenu(String menuItem) {
        megaMenuItem = megaMenuItem.replaceAll("MENUITEM", menuItem);
        hover_On_Element(driver, driver.findElement(By.cssSelector(megaMenuItem)));
    }

    public static void clickSubMenu(String menuItem) {
        subMenuItem = subMenuItem.replaceAll("MENUITEM", menuItem);
        waitAndClick(driver, driver.findElement(By.cssSelector(subMenuItem)));
    }
}
