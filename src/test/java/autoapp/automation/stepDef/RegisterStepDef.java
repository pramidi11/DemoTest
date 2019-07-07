package autoapp.automation.stepDef;

import autoapp.automation.pages.CustomerDetails;
import autoapp.automation.pages.InfoPage;
import autoapp.automation.pages.RegisterPage;
import autoapp.automation.utility.BrowserDriver;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

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
    }


    @Then("^I should be able to register with my below details$")
    public void i_should_be_able_to_register_with_my_below_details(List<CustomerDetails> customerDetails) throws Throwable {
        InfoPage.enterPersonalInformation(customerDetails);
    }

    @Then("^I should be on My Account page$")
    public void i_Should_Be_On_MyAccount_Page() throws Throwable {
        Assert.assertEquals("My account - My Store", BrowserDriver.getPageTitle());
    }

    @Then("^I should see an error$")
    public void iShouldSeeAnError() throws Throwable {
        Assert.assertEquals("Invalid email address.", RegisterPage.getCreateAccountError());
    }

    @When("^I hover on mega menu \"([^\"]*)\"$")
    public void iHoverOnMegaMenu(String arg0) throws Throwable {
        RegisterPage.hoverOnMenu(arg0);
    }

    @And("^I click on sub menu \"([^\"]*)\"$")
    public void iClickOnSubMenu(String arg0) throws Throwable {
        RegisterPage.clickSubMenu(arg0);
    }

    @Then("^I should be on \"([^\"]*)\" page$")
    public void iShouldBeOnPage(String arg0) throws Throwable {
        Assert.assertEquals(arg0, RegisterPage.getPageTitle());
    }
}
