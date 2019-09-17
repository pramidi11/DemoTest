package autoapp.automation.stepDef;

import autoapp.automation.pages.RegisterPage;
import autoapp.automation.utility.hooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class emailAddressValidation {
	
	
	@Given("^User navigates to Automation Practise website$")
	public void user_navigates_to_Automation_Practise_website() throws Throwable {
		hooks.setUp();
		RegisterPage.openApplicaiton();
	}

	@When("^Clicks on the Sign-In button$")
	public void clicks_on_the_Sign_In_button() throws Throwable {
		RegisterPage.clickSignIn();
	}

	@And("^Create an account with the invalid email address \"([^\"]*)\"$")
		public void enter_an_invalid_email_address_in_the_CREATE_ACCOUNT_section(String emailId) throws Throwable {
		RegisterPage.createAccount(emailId);
		Thread.sleep(5000);
	}

	@Then("^An error message is displayed indicating that they have entered an invalid email address$")
	public void an_error_message_is_displayed_indicating_that_they_have_entered_an_invalid_email_address() throws Throwable {
		RegisterPage.emailAddValid();
	}	
	
	
	
}
