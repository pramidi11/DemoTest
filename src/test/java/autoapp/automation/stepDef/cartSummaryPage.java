package autoapp.automation.stepDef;

import autoapp.automation.pages.RegisterPage;
import autoapp.automation.pages.cartSummary;
import autoapp.automation.pages.megaMenu;
import autoapp.automation.utility.hooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cartSummaryPage {
	
	@Given("^The user navigates to Automation Practise website$")
	public void the_user_navigates_to_Automation_Practise_website() throws Throwable {
		hooks.setUp();
		RegisterPage.openApplicaiton();
		Thread.sleep(5000);
	}

	@And("^Hover over \"([^\"]*)\" in the Mega Menu$")
	public void hover_over_in_the_Mega_Menu(String mmHoverOption) throws Throwable {
		megaMenu.mmHover(mmHoverOption);
	}

	@And("^They click on \"([^\"]*)\" option to navigate to the category page$")
	public void they_click_on_option_to_navigate_to_the_category_page(String mmSubOptClick) throws Throwable {
		megaMenu.hoverOptClick(mmSubOptClick);
		Thread.sleep(5000);
	}

	@And("^They select a dress that has the color \"([^\"]*)\"$")
	public void they_select_a_dress_that_has_the_color(String dressColor) throws Throwable {
	    cartSummary.dressColourPick(dressColor);
	    Thread.sleep(2000);
	}

	@And("^They add the quantity as \"([^\"]*)\"$")
	public void they_add_the_quantity_as(int qtyNo) throws Throwable {
		
		cartSummary.addQuantity(qtyNo);
		Thread.sleep(2000);
	}

	@And("^Select the dress size \"([^\"]*)\"$")
	public void select_the_dress_size(String dressSize) throws Throwable {
	    cartSummary.addSize(dressSize);
	    Thread.sleep(2000);
	}

	@And("^They click the Add to cart button$")
	public void they_click_the_add_to_cart_button() throws Throwable {
	    cartSummary.addToCart();
	    Thread.sleep(2000);
	}

	@When("^They Proceed to checkout$")
	public void they_proceed_to_checkout() throws Throwable {
		cartSummary.proceedToCheckout();
		Thread.sleep(2000);
	    
	}
	

	@Then("^In the \"([^\"]*)\" page The product name, color and quantity displayed as what was selected$")
	public void in_the_page_the_product_name_color_and_quantity_displayed_as_what_was_selected(String pgName) throws Throwable {
		cartSummary.validateCheckout(pgName);
	    
	}

}
