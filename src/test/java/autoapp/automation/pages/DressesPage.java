package autoapp.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DressesPage {

static WebDriver objCurrentDriver;
	
	//Constructor
	public DressesPage(WebDriver objDriver){
		DressesPage.objCurrentDriver = objDriver;
		//This initElements method will create all WebElements
		PageFactory.initElements(objCurrentDriver, this);
	}
	
	@FindBy(how= How.XPATH, using="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private static WebElement dressesBtn;

	@FindBy(how= How.XPATH, using="//*[@id=\"block_top_menu\"]/ul/li[2]/ul")
	private static WebElement dressesDropDown;

	@FindBy(how= How.XPATH, using="//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
	private static WebElement dressesSummerDressesBtnDropDown;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"selectProductSort\"]")
	private static WebElement sortDressDropDown;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span[1]")
	private static WebElement priceSummerDress1;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[1]/span[1]")
	private static WebElement priceSummerDress2; 
	
	@FindBy(how= How.XPATH, using="//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[1]/span[1]")
	private static WebElement priceSummerDress3;

	
	@FindBy(how= How.XPATH, using="//*[@id=\"center_column\"]/ul/li[" + 1 + "]")
	private WebElement summerDressNumber1;

	
	@FindBy(how= How.XPATH, using="//*[@id=\"color_20\"]")
	private static WebElement changeColorToBlueBtn;

	@FindBy(how= How.XPATH, using="//*[@id=\"add_to_cart\"]/button/span")
	private static WebElement addToCartButton;

	@FindBy(how= How.XPATH, using="//a[@title=\"Proceed to checkout\"]")
	private static WebElement proceedToCheckoutButton;

	@FindBy(how=How.ID, using="layer_cart_product_title")
	private static WebElement selectedDressTitle;

	@FindBy(how=How.ID, using="layer_cart_product_attributes")
	private static WebElement selectedDressColor;

	@FindBy(how= How.XPATH, using="//td[@class=\"cart_description\"]//p[@class=\"product-name\"]/a")
	private static WebElement productNameOnCartSummaryPage;

	@FindBy(how= How.XPATH, using="//td[@class=\"cart_description\"]//small[2]/a")
	private static WebElement productColorOnCartSummaryPage;

	@FindBy(how=How.XPATH, using="//input[@class=\"cart_quantity_input form-control grey\"]")
	private static WebElement productQtyOnCartSummaryPage;

	public static Float getPriceSummerDress1() {
		String priceDress = priceSummerDress1.getText();
		String price = priceDress.replace("$", "");
		
		float priceNum = Float.parseFloat(price);	
		System.out.println(priceNum);
		return priceNum;
	}
	
	public static Float getPriceSummerDress2() {
		String priceDress = priceSummerDress2.getText();
		String price = priceDress.replace("$", "");
		
		float priceNum = Float.parseFloat(price);	
		System.out.println(priceNum);
		return priceNum;
	}
	
	public static Float getPriceSummerDress3() {
		String priceDress = priceSummerDress3.getText();
		String price = priceDress.replace("$", "");
		
		float priceNum = Float.parseFloat(price);	
		System.out.println(priceNum);
		return priceNum;
	}
	
	public static WebElement getProductNameOnCartSummaryPageElement() {
		return productNameOnCartSummaryPage;
	}

	public static String getProductQty(){
		return productQtyOnCartSummaryPage.getAttribute("value");
	}

	public static String getProductName(){
		return productNameOnCartSummaryPage.getText();
	}

	public static String getProductColor(){
		return productColorOnCartSummaryPage.getText();
	}

	public static String getselectedDressTitle(){
		return selectedDressTitle.getText();
	}

	public static String getselectedDressColor(){
		return selectedDressColor.getText();
	}

	public static WebElement getProceedToCheckoutButton(){
		return proceedToCheckoutButton;
	}

	public static void clickOnProceedToCheckOutButton() {
		proceedToCheckoutButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void hoverOverTheFirstSummerDressItem() {
		Actions action = new Actions(objCurrentDriver);
		action.moveToElement(getSummerDressProduct(1)).perform();
	}

	public static void clickOnAddToCartButton() {
		Actions action = new Actions(objCurrentDriver);
		action.moveToElement(getSummerDressProduct(1)).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		action.moveToElement(changeColorToBlueBtn).perform();
		action.click(changeColorToBlueBtn).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		action.moveToElement(addToCartButton).perform(); 
		action.click(addToCartButton).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static boolean isDressesButtonDisplayed() {
		return dressesBtn.isDisplayed();
	}
	
	public static void clickDressesButton() {
		System.out.println();
		dressesBtn.click();
	}
	
	public static void HoverDressesButton() {
		Actions action = new Actions(objCurrentDriver);
		action.moveToElement(dressesBtn).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static boolean SummerMenubuttonExist(){
		boolean btn = dressesSummerDressesBtnDropDown.isDisplayed();
		if(btn){
			return true;
		}else {
			return false;
		}
	}

	public static void clickSummerDressesMenuBtn() {
		Actions action = new Actions(objCurrentDriver);
		action.moveToElement(dressesSummerDressesBtnDropDown).perform();
		dressesSummerDressesBtnDropDown.click();
		
	}
	
	public static void sortSummerDresses(String sortByValue) {
		Select sortByDropDown = new Select(sortDressDropDown);
		sortByDropDown.selectByVisibleText(sortByValue);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public static WebElement getSummerDressProduct(int dressNum) {
		return objCurrentDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"));
	}

	

}
