package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
//Vinod Vijayan: To write result to file - Start
import java.io.BufferedWriter;
import java.io.FileWriter;
//Vinod Vijayan: To write result to file - End

import org.openqa.selenium.By;


public class RegisterPage extends BasePage{

    public static String signIn_xpath = "//a[@title='Log in to your customer account']";
    public static String email_id = "email_create";
    public static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";
    public static String createAccountError_locateID = "create_account_error";
    

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
        emailid= emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        driver.findElement(By.id(email_id)).sendKeys(emailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }
    // Vinod Vijayan: Function to enter email id and check of error message (Task#1)- Start
    public static void createAccountInvalid(String invalidEmailid) {
        driver.findElement(By.id(email_id)).sendKeys(invalidEmailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
        FileWriter fw=new FileWriter(“C:\\Program Files\\DemoTest\\TestResult.txt”);
    	BufferedWriter bw=new BufferedWriter(fw);
        If (driver.findElement(By.id(createAccountError_locateID)).isDisplayed {
        	// write results to a flat file
        	bw.write(“PASSED: createAccountInvalid-Error Message displayed to User when an invalid email id is used to create new account”);
        	bw.newLine();
        } else {
        	bw.write(“FAILED: createAccountInvalid-Error Message NOT displayed to User when an invalid email id is used to create new account”);
    		bw.newLine();
        }
        bw.close();
    }
    // Vinod Vijayan: Function to enter email id and check of error message (Task#1) - End
}


