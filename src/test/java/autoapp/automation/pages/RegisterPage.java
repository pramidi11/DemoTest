package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class RegisterPage extends BasePage{
	
	public RegisterPage(BrowserDriver driver) {
        super(driver);
    }
	
    public static String signIn_xpath = "//a[@title='Log in to your customer account']";
    public static String email_id = "email_create";
    public static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";
    public static String createAccountError_xpath = "//div[@id='create_account_error']//li";
    
    
    //Page-Object Model : Initialize Webdriver and Pagefactory and use the below code
    @FindBy(how=How.XPATH, using="//div[@id='create_account_error']//li")
	private static WebElement invalidEmailMsg_text;
    
    public static String invalidEmailMsg(){
		return invalidEmailMsg_text.getText();
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
    
    public static String invalidEmailMsgTxt() throws InterruptedException {
    	Thread.sleep(5000);
        String invalidMsg_text = driver.findElement(By.xpath(createAccountError_xpath)).getText();
        return invalidMsg_text;
    }
}
