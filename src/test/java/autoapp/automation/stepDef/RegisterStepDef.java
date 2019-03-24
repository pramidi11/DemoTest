package autoapp.automation.stepDef;

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
        
// Vinod Vijayan - User gets error message when an invalid email id is supplied for Task #1 - Start
     @Then("^I should not be able to register$") 
     public void i_should_not_be_able_to_register(String invalidEmailid) throws Throwable {
    	 RegisterPage.createAccountInvalid(invalidEmailid);
         Thread.sleep(5000);
    }
// Vinod Vijayan - User gets error message when an invalid email id is supplied for Task #1 - End
     
     
// Vinod Vijayan - User navigates to Summer dresses under Dresses menu for Task #2 - Start
     @When("^I click on Dresses and select Summer Dresses$") 
     public void i_click_on_dresses_and_select_summer_dresses() throws Throwable {
    	 HomePage.selectDressAndSummerDress();
         Thread.sleep(5000);
    }    
 // Vinod Vijayan - User navigates to Summer dresses under Dresses menu for Task #2 - End
     
 // Vinod Vijayan - User navigates to Summer dresses under Dresses menu for Task #2 - Start
     @Then("^Summer Dresses page comes up$") 
     public void summer_dresses_page_comes_up() throws Throwable {
    	 HomePage.checkPageDisplay();
         Thread.sleep(5000);
    }
 // Vinod Vijayan - User navigates to Summer dresses under Dresses menu for Task #2 - Start
    
}
