package autoapp.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	static WebDriver objCurrentDriver;
	
	//Constructor
	public CreateAccountPage(WebDriver objDriver){
		CreateAccountPage.objCurrentDriver = objDriver;
		//This initElements method will create all WebElements
		PageFactory.initElements(objCurrentDriver, this);
	}
	
	@FindBy(how=How.XPATH, using="//a[@title='Log in to your customer account']")
	private static WebElement signIn_xpath;

	@FindBy(how=How.ID, using="email_create")
	private static WebElement emailCreate_input;

	@FindBy(how=How.ID, using="SubmitCreate")
	private static WebElement createAnAccount_button;

	public static void clickOnSignInLink(){
		signIn_xpath.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void typeEmailId(String emailId) {
		emailCreate_input.sendKeys(emailId);
	}

	public static void clickSubmitCreate() {
		createAnAccount_button.click();
	}
	
	@FindBy(how=How.XPATH, using="//div[@id=\"create_account_error\"]//li")
	private static WebElement invalidEmailMsg_text;

	public static String invalidEmailMsg(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return invalidEmailMsg_text.getText();
	}
	
	public static void openApplicaiton() {
		objCurrentDriver.navigate().to("http://automationpractice.com/index.php");
		objCurrentDriver.manage().window().maximize(); 
	 }
	
}
