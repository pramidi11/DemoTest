package autoapp.automation.stepDef;

import autoapp.automation.pages.SelectedItemPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class SelectItemStepDef   {

    @And("^I change the quantity to \"([^\"]*)\", size to \"([^\"]*)\" and color to \"([^\"]*)\"$")
    public void i_change_the_quantity_size_and_color(String quantity, String size, String color) throws Throwable {
        SelectedItemPage.setQuantity(quantity);
        SelectedItemPage.setSize(size);
        SelectedItemPage.setColor(color);
    }

    @And("^I add the item to the cart$")
    public void iAddTheItemToTheCart() {
        SelectedItemPage.addToCart();
    }

    @Then("^I validate that item is added to the cart correctly$")
    public void iValidateThatItemIsAddedToTheCartCorrectly() {
        assertEquals("Quantity doesn't match to values in the cart frame","2", SelectedItemPage.getQuantityFromCartFrame());
        assertEquals("Size doesn't match to values in the cart frame", "M", SelectedItemPage.getSizeFromCartFrame());
        assertEquals("Color doesn't match to values in the cart frame", "Blue", SelectedItemPage.getColorFromCartFrame());

    }
}
