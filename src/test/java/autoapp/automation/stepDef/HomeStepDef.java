package autoapp.automation.stepDef;

import autoapp.automation.pages.BasePage;
import autoapp.automation.pages.HomePage;
import autoapp.automation.utility.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeStepDef {

    @Given("^Automation practice application is opened$")
    public void automation_practice_application_is_opened() throws Throwable {
        BasePage.openApplicaiton();
    }

    @When("^I hover mouse over \"([^\"]*)\" on Home page$")
    public void i_hover_mouse_over_Menu_on_HomePage(String menu) throws Throwable {
        Helper.MAIN_MENU maninMenu= Helper.MAIN_MENU.valueOf(menu.replaceAll(" ", "_"));
        HomePage.hoverMouseOnMenu(maninMenu);
    }

    @Then("^I should see the sub-menu \"([^\"]*)\"$")
    public void i_should_see_the_subMenu(String menu) throws Throwable {
        Helper.DRESSES_MENU dressesSubMenu = Helper.DRESSES_MENU.valueOf(menu.replaceAll(" ", "_"));
        HomePage.validateSubMenuAvailable(dressesSubMenu);
    }

    @Then("^I should be landing on \\[Summer Dresses\\] page$")
    public void i_should_be_landing_on_summerDresses_page() {
        HomePage.validateSummerDressesPageLoaded();
    }

    @And("^I click on sub-menu \"([^\"]*)\"$")
    public void i_click_on_subMenu(String menu) throws Throwable {
        Helper.DRESSES_MENU dressesSubMenu = Helper.DRESSES_MENU.valueOf(menu.replaceAll(" ", "_"));
        HomePage.clickSubMenu(dressesSubMenu);
    }

    @And("^I select a product from the list$")
    public void iSelectAProductFromTheList() {
        HomePage.selectAProduct();
    }
}
