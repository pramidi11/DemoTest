package autoapp.automation.stepDef;

import autoapp.automation.pages.BasePage;
import autoapp.automation.pages.InfoPage;
import autoapp.automation.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDef {


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
        //InfoPage.enterPersonalInformation(dataTable);
        Thread.sleep(5000);
    }

    @Then("^I should be getting an error message displayed$")
    public void i_should_be_getting_an_error_message_displayed() throws Throwable {
        RegisterPage.errorMessageDisplayed();
        Thread.sleep(5000);
    }
}
