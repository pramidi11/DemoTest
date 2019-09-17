package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;


public class RegisterPage extends BasePage{

    public static String signIn_xpath = "//a[@title='Log in to your customer account']";
    public static String email_id = "email_create";
    public static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";

    public RegisterPage(BrowserDriver driver) {
        super(driver);
    }

    public static void openApplicaiton() {
   		WebDriverManager.chromedriver().setup();    
    	driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    public static void clickSignIn() {
        driver.findElement(By.xpath(signIn_xpath)).click();
        
    }

    public static void createAccount(String emailid) {
        emailid= emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        driver.findElement(By.id(email_id)).sendKeys(emailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }
    
    public static void emailAddValid() {
    	boolean errorMsgEx = driver.findElement(By.xpath("//*[@id='create_account_error']")).isDisplayed();
    	Assert.assertTrue(errorMsgEx==true);
    	String errorMsgDt = driver.findElement(By.xpath("//*[@id=\'create_account_error\']/ol/li")).getText();
    	Assert.assertEquals(errorMsgDt, "Invalid email address.");  			
      }
}
