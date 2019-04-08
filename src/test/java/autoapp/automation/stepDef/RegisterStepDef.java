	package autoapp.automation.stepDef;

import org.junit.Assert;

import autoapp.automation.pages.InfoPage;
import autoapp.automation.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDef {

    @Given("^Automation practice application is opened$")
    public void automation_practice_application_is_opened() throws Throwable {
        RegisterPage.openApplicaiton();
    }

    @When("^I click sign in$")
    public void i_click_sign_in() throws Throwable {
        RegisterPage.clickSignIn();

    }

    @And("^I create account with emailid \"([^\"]*)\"$")
    public void i_create_account_with_emailid(String emailId) throws Throwable {
        RegisterPage.createAccount(emailId);
        Thread.sleep(5000);
    }


    @Then("^I should be able to register with my below details$")
    public void i_should_be_able_to_register_with_my_below_details(DataTable dataTable) throws Throwable {
        InfoPage.enterPersonalInformation(dataTable);
        Thread.sleep(5000);
    }
    
    @Then("^I should see the error message \"([^\"]*)\"$")
    public void I_should_see_the_error_message(String errorMessage) throws Throwable {
    	String actualMsg = RegisterPage.invalidEmailMsgTxt();
    	//String actualMsg = RegisterPage.invalidEmailMsg(); - Page-Object model call
    	System.out.println("Actual Msg: "+actualMsg);
        Assert.assertEquals(errorMessage,actualMsg);
    }
    
}
