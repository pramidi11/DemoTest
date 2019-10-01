package autoapp.automation.stepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import autoapp.automation.pages.CreateAccountPage;
import autoapp.automation.pages.DressesPage;
import autoapp.automation.utility.BrowserDriver;
import autoapp.automation.utility.ProductDetails;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SummerDressCart {
	
	 static WebDriver objDriver = BrowserDriver.driver;
	 CreateAccountPage createAccountPage = new CreateAccountPage(objDriver);
	 DressesPage dressesPage = new DressesPage(objDriver);
	
	@When("^click on the \"([^\"]*)\" menu from the main \"([^\"]*)\" menu$")
	public void click_on_the_menu_from_the_main_menu(String arg1, String arg2) throws Throwable {
		
		//Check that Dresses button is displayed
		boolean isDressesBtnDisplayed = DressesPage.isDressesButtonDisplayed();
        Assert.assertTrue("Dresses Button is not displayed",isDressesBtnDisplayed);
        
        //Check that on hover Summer sub menu are displayed
		DressesPage.HoverDressesButton();
        boolean summerSubMenuDisplayed = DressesPage.SummerMenubuttonExist();
        Assert.assertTrue("Summer Sub Menu is not displayed",summerSubMenuDisplayed);
        
        //Click Summer Dress Sub Menu
        DressesPage.clickSummerDressesMenuBtn();   
	}
	

	@When("^I sort by \"([^\"]*)\"$")
	public void i_sort_by(String sortByValue) throws Throwable {
		//Sort the Summer Dresses by Price:Lowest first
		DressesPage.sortSummerDresses(sortByValue);  
	}

	@Then("^the product grid is arranged accordingly$")
	public void the_product_grid_is_arranged_accordingly() throws Throwable {
	   //Validate that the dresses are dispayed as per the sort
		Float priceSummerDress1 = DressesPage.getPriceSummerDress1();
		Float priceSummerDress2 = DressesPage.getPriceSummerDress2();
		Float priceSummerDress3 = DressesPage.getPriceSummerDress3();
		
		if (priceSummerDress2 > priceSummerDress1 && priceSummerDress3 > priceSummerDress2) {
			Assert.assertTrue("Product Grid is arranged as per sort by",true);
		
		} else {
			Assert.assertTrue("Product Grid is not arranged as per sort by",false);
		}
		
	}
	
	
	@When("^I click on \"([^\"]*)\" button for one summer dress$")
	public void i_click_on_button_for_one_summer_dress(String arg1) throws Throwable {
		DressesPage.hoverOverTheFirstSummerDressItem();
        DressesPage.clickOnAddToCartButton();
	}

	@Then("^I am able to see and click the \"([^\"]*)\" button on the status dialog$")
	public void i_am_able_to_see_and_click_the_button_on_the_status_dialog(String arg1) throws Throwable {
		ProductDetails.setProductName(DressesPage.getselectedDressTitle());
        ProductDetails.setProductColor(DressesPage.getselectedDressColor());
        DressesPage.clickOnProceedToCheckOutButton();
	}

	@Then("^validate the \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" on the \"([^\"]*)\" page$")
	public void validate_the_and_on_the_page(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		String actualProductName = DressesPage.getProductName();
        String actualProductColor = DressesPage.getProductColor();
        String actualProductQty = DressesPage.getProductQty();

        String expectedProductName = ProductDetails.getProductName();
        String expectedProductColor = ProductDetails.getProductColor();

        Assert.assertEquals("Product Name does not match: ",actualProductName,expectedProductName);
        Assert.assertTrue(actualProductColor.contains(expectedProductColor));
        Assert.assertEquals("Product Qty does not match: ",actualProductQty,"1");
	}
}
