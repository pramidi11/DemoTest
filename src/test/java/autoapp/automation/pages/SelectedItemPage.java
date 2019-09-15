package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import autoapp.automation.utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectedItemPage extends BasePage {

	public static String addToCartButton_css = "#add_to_cart > button > span";

	public static String quantityField_id = "quantity_wanted";

	public static String sizesDropdown_id = "group_1";

	public static String colorOptions_id = "color_to_pick_list";

	public static String quantityInCartFrame_id = "layer_cart_product_quantity";

	public static String sizeAndColorInCartFrame_id = "layer_cart_product_attributes";

	public static String proceedToCheckoutButton_css = "a[title='Proceed to checkout']";

	public SelectedItemPage(BrowserDriver driver) {
		super(driver);
	}

	public static void addToCart(){
		driver.findElement(By.cssSelector(addToCartButton_css)).click();
		Helper.waitForElementPresence(driver,By.cssSelector(proceedToCheckoutButton_css),10);
	}
	public static void setQuantity(String count) {
		WebElement quantityField=driver.findElement(By.id(quantityField_id));
		quantityField.clear();
		quantityField.sendKeys(count);
	}

	public static String getQuantityFromCartFrame() {
		Helper.waitForElementPresence(driver, By.id(quantityInCartFrame_id),10);
		return driver.findElement(By.id(quantityInCartFrame_id)).getText();
	}

	public static void setSize(String size) {
		Select selectList = new Select(driver.findElement(By.id(sizesDropdown_id)));
		selectList.selectByVisibleText(size);
	}

	public static String getSizeFromCartFrame() {
		WebElement sizeAndColorInCartFrame= driver.findElement(By.id(sizeAndColorInCartFrame_id));
		return sizeAndColorInCartFrame.getText().substring(sizeAndColorInCartFrame.getText().length() - 1);
	}

	public static void setColor(String color) {
		List<WebElement> colors = driver.findElement(By.id(colorOptions_id)).findElements(By.xpath(".//*"));
		for (WebElement li : colors) {
			if (li.getAttribute("title").equals(color)) {
				li.click();
			}
		}
	}
	public static String getColorFromCartFrame() {
		WebElement sizeAndColorInCartFrame= driver.findElement(By.id(sizeAndColorInCartFrame_id));
		return sizeAndColorInCartFrame.getText().substring(0, sizeAndColorInCartFrame.getText().length() - 3);
	}


}
