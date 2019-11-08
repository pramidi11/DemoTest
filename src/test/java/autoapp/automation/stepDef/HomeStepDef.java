package autoapp.automation.stepDef;

import autoapp.automation.pages.HomePage;
import autoapp.automation.pages.RegisterPage;
import autoapp.automation.pages.ShoppingCartSummaryPage;
import autoapp.automation.pages.SummerDressesPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeStepDef {

    @Given("^Automation practice application is opened$")
    public void automation_practice_application_is_opened() throws Throwable {
        HomePage.openApplication();
    }

    @When("^I click sign in$")
    public void i_click_sign_in() throws Throwable {
        HomePage.clickSignIn();
        RegisterPage.verifyCorrectPage();
    }

    @When("^I navigate to the \"([^\"]*)\" page$")
    public void i_navigate_to_the_page(String pageName) throws Throwable {
        HomePage.navigateTo(pageName, false);
        switch(pageName.toLowerCase()) {
            case "cart summary":
                ShoppingCartSummaryPage.verifyCorrectPage();
                break;
            case "summer dresses":
                SummerDressesPage.verifyCorrectPage();
                break;
            default:
        }
    }

    @When("^I navigate to the \"([^\"]*)\" page via the Megamenu$")
    public void i_navigate_to_the_page_via_the_megamenu(String pageName) throws Throwable {
        HomePage.navigateTo(pageName, true);
        switch(pageName.toLowerCase()) {
            case "summer dresses":
                SummerDressesPage.verifyCorrectPage();
                break;
            default:
        }
    }
}
