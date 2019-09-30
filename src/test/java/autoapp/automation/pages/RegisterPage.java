package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;
import autoapp.automation.utility.Helper;

public class RegisterPage extends BasePage{

    public static String signIn_xpath = "//a[@title='Log in to your customer account']";
    public static String email_id = "email_create";
    public static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";
    public static String error_id = "create_account_error";

    public RegisterPage(BrowserDriver driver) {
        super(driver);
    }

    public static void clickSignIn() {
        driver.findElement(By.xpath(signIn_xpath)).click();
    }

    public static void createAccount(String emailid) {
        emailid= emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        driver.findElement(By.id(email_id)).sendKeys(emailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }

    public static void errorMessageDisplayed() {
        assertTrue("The error message is missing", Helper.isPresent(driver, By.id(error_id)));
    }

}
