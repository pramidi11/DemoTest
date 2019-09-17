package autoapp.automation.stepDef;

import autoapp.automation.pages.RegisterPage;
import autoapp.automation.pages.megaMenu;
import autoapp.automation.utility.hooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class megaMenuFunc {
	
	
	@Given("^User navigates to the Automation Practise website$")
	public void user_navigates_to_the_Automation_Practise_website() throws Throwable {
		hooks.setUp();
		RegisterPage.openApplicaiton();
		//Thread.sleep(5000);
	}

	@When("^They click \"([^\"]*)\" in the Mega Menu$")
	public void they_click_in_the_Mega_Menu(String mmOpt) throws Throwable {
		megaMenu.clickMegaMenuOpt(mmOpt);
		//Thread.sleep(2000);
	}

	@Then("^The user is navigated to the \"([^\"]*)\" page$")
	public void the_user_is_navigated_to_the_page(String pageVal) throws Throwable {
	    megaMenu.pageValidation(pageVal);
	}

	@When("^They hover over \"([^\"]*)\" in the Mega Menu$")
	public void they_hover_over_in_the_Mega_Menu(String mmHoverOption) throws Throwable {
		   megaMenu.mmHover(mmHoverOption);
	}

	@And("^Click the \"([^\"]*)\" link$")
	public void click_the_link(String mmSubOptClick) throws Throwable {
		   megaMenu.hoverOptClick(mmSubOptClick);
	}

}
