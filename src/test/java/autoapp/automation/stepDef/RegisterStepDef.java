package autoapp.automation.stepDef;

import autoapp.automation.pages.MyAccountPage;
import autoapp.automation.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class RegisterStepDef{

    @And("^I create account with emailid \"([^\"]*)\"$")
    public void i_create_account_with_emailid(String emailId) throws Throwable {
        RegisterPage.createAccount(emailId);
    }

    @Then("^I should be able to register with my below details$")
    public void i_should_be_able_to_register_with_my_below_details(DataTable dataTable) throws Throwable {
        RegisterPage.verifyPersonalInformationFormHasLoaded();
        RegisterPage.enterPersonalInformation(dataTable);
        RegisterPage.clickRegister();
        MyAccountPage.verifyCorrectPage();
    }

    @Then("^I should see the registrationMessage \"([^\"]*)\"$")
    public void i_should_see_the_registration_error_message(String expectedErrorMessage) throws Throwable {
        RegisterPage.verifyEmailRegistrationErrorMessage(expectedErrorMessage);
    }
}
