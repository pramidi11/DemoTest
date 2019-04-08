package autoapp.automation.stepDef;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import autoapp.automation.pages.CreateAccountPage;
import autoapp.automation.utility.BrowserDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccountStepDef {
	
	 static WebDriver objDriver = BrowserDriver.driver;
	 CreateAccountPage createAccountPage = new CreateAccountPage(objDriver);
	 
	 @Given("^Automation practice site is opened$")
	    public void automation_practice_site_is_opened() throws Throwable {
	        CreateAccountPage.openApplicaiton();
	    }

	    @When("^I click on SignIn$")
	    public void i_click_on_sign_in() throws Throwable {
	        CreateAccountPage.clickOnSignInLink();
	    }
	    
	    @When("^I create account with invalid emailid \"([^\"]*)\"$")
	    public void i_create_account_with_invalid_emailid(String emailId) throws Throwable {
	       CreateAccountPage.typeEmailId(emailId);
	       CreateAccountPage.clickSubmitCreate();
	    }

	    @Then("^I should see the error message as \"([^\"]*)\"$")
	    public void i_should_see_the_error_message_as(String expectedErrorMsg) throws Throwable {
	        String actualErrorMsg=CreateAccountPage.invalidEmailMsg();
	        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
	    }

	 
	 

}
