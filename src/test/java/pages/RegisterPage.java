package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class RegisterPage {
	private static final int implicitTimeout = 10;
    private static final String email_input = "email_create";

    public static void openApplication(WebDriver driver) {
        driver.navigate().to("http://automationpractice.com/index.php");
        new WebDriverWait(driver, implicitTimeout).
        	until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        
        driver.manage().window().maximize();
    }
    
    public static void clickSignIn(WebDriver driver) {
        String signIn_link = "a[title='Log in to your customer account']";
        driver.findElement(By.cssSelector(signIn_link)).click();
        
        new WebDriverWait(driver, implicitTimeout).
        	until(ExpectedConditions.visibilityOfElementLocated(By.id(email_input)));
    }

	public static void submitSignupEmail(WebDriver driver, String userEmail) {
        driver.findElement(By.id(email_input)).sendKeys(userEmail);
        new WebDriverWait(driver, implicitTimeout).
        	until(ExpectedConditions.textToBePresentInElementValue(By.id(email_input), userEmail));

        String createAccount_btn = "SubmitCreate";
        driver.findElement(By.id(createAccount_btn)).click();
	}

	public static void verifyValidationMessage(WebDriver driver, String expectedMsg) {
	    String emailError_msg = "create_account_error";
        new WebDriverWait(driver, implicitTimeout).
    		until(ExpectedConditions.visibilityOfElementLocated(By.id(emailError_msg)));
        
        String errorMsg = driver.findElement(By.id(emailError_msg)).getText();
        Assert.assertEquals("Verify email validation message", expectedMsg, errorMsg);
	}
}
