package seleniumgluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LandingPage;
import pages.RegisterPage;

public class test {
    public static WebDriver driver;
    
	@Given("^Automation practice application is opened$")
	public void automation_practice_application_is_opened() throws Throwable {
    	System.setProperty("webdriver.gecko.driver","/Users/peterbaldwin/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        RegisterPage.openApplication(driver);
	}

	@When("^I click sign in$")
	public void i_click_sign_in() throws Throwable {
		RegisterPage.clickSignIn(driver);
	}

	@When("^I create account with emailid \"([^\"]*)\"$")
	public void i_create_account_with_emailid(String userEmail) throws Throwable {
		RegisterPage.submitSignupEmail(driver, userEmail);
	}

	@Then("^I should see error message \"([^\"]*)\"$")
	public void i_should_see_error_message(String expectedMsg) throws Throwable {
		RegisterPage.verifyValidationMessage(driver, expectedMsg);
	}
	
	@When("^I navigate to \"([^\"]*)\" > \"([^\"]*)\"$")
	public void i_navigate_to(String menu1, String menu2) throws Throwable {
		System.out.println("In step definition");
		LandingPage.menuNavigation(driver, menu1, menu2);
	}

	@Then("^I should see \"([^\"]*)\" page$")
	public void i_should_see_page(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@After
	static public void releaseResources() {
		driver.close();
	}
}
