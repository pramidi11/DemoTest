package autoapp.automation.stepDef;

import autoapp.automation.pages.ProductPage;
import autoapp.automation.pages.QuickViewPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class ProductStepDef {
    @And("^I select QuickView of \"([^\"]*)\"$")
    public void i_select_quickview_of(String productName) throws Throwable {
        ProductPage.loadProducts();
        ProductPage.selectQuickViewOf(productName);
        QuickViewPage.verifyCorrectPage();
    }

    @And("^in QuickView I select the colour \"([^\"]*)\"$")
    public void in_quickview_i_select_the_colour(String colour) throws Throwable {
        QuickViewPage.selectColour(colour);
    }

    @And("^in QuickView I click \"([^\"]*)\"$")
    public void in_quickView_i_add_the_product_to_the_cart(String controlName) {
        switch(controlName.toLowerCase()) {
            case "add to cart":
                QuickViewPage.clickAddToCart();
                break;
            default:
                System.out.println("Unknown button or link to click in Quick View; skipping this step");
        }
    }

    @Then("^I should see the product added to the cart in a popup$")
    public void i_should_see_the_product_added_to_the_cart_in_a_popup() throws Throwable {
        ProductPage.verifyProductAddedPopupAppears();
    }

    @When("^I close the Product Added popup$")
    public void i_close_the_product_added_popup() {
        ProductPage.verifyProductAddedPopupAppears();
        ProductPage.closeProductAddedPopup();
    }
}
