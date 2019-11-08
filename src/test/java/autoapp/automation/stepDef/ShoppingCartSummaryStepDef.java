package autoapp.automation.stepDef;

import autoapp.automation.pages.ShoppingCartSummaryPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartSummaryStepDef {

    @Then("^I should see the following products in my cart$")
    public void i_should_see_the_following_products_in_my_cart(DataTable dataTable) throws Throwable {
        ShoppingCartSummaryPage.verifyCartContents(dataTable);
    }
}
