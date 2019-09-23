package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;



public class cartSummary extends BasePage{

	public static String productName;
	public static String colourOfTheDress;
	public static String dressQuantity;
	
	
	 public cartSummary(BrowserDriver driver) {
	        super(driver);
	    }
	 
	 public static void dressColourPick(String colourPick) {
		 		 
		 driver.findElement(By.xpath("//*[@id=\'list\']/a")).click();
				 
		 if(colourPick.equals("Blue"))
		 {
			 driver.findElement(By.xpath("//*[@id=\'color_20\']")).click();
			 			
		 }
	 }
	
	 public static void addQuantity(int quantityNo) {
		 int i;
		 System.out.println("Quantity="+quantityNo);
		 for (i=1;i<quantityNo;i++)
		 {
			 driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]/span")).click(); 
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 }
	
	 public static void addSize(String dressSize) {
		 
		 System.out.println("Dress Size="+dressSize);
		  Select dSize = new Select (driver.findElement(By.xpath("//*[@id='group_1']")));
		  dSize.selectByVisibleText(dressSize);
		  
	 }

	 public static void addToCart() {
		 
		  driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();
		  		
		}

	 public static void proceedToCheckout() {
		 
		 
		  productName = driver.findElement(By.xpath("//*[@id='layer_cart_product_title']")).getText();
		  System.out.println("product Name="+productName);
		  
		  dressQuantity = driver.findElement(By.xpath("//*[@id='layer_cart_product_quantity']")).getText();
		  System.out.println("dress Quantity="+dressQuantity);
		  
		  colourOfTheDress = driver.findElement(By.xpath("//*[@id='layer_cart_product_attributes']")).getText();
		  String[] arrSplit = colourOfTheDress.split(",");
		    for (int i=0; i<1; i++)
		    {
		      System.out.println(arrSplit[i]);
		      colourOfTheDress=arrSplit[i];
		    }
		    System.out.println("colour Of The Dress="+colourOfTheDress);
		    driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")).click();
		    
		
		    }
	 
	 
	 public static void validateCheckout(String pageName) {
		 
		 //Validate if the user is in the SHOPPING-CART SUMMARY page
		 String chkOutPgName = driver.findElement(By.xpath("//*[@id=\'cart_title\']")).getText();
		 boolean pageHeaderFound = chkOutPgName.indexOf(pageName) !=-1? true: false;
		 System.out.println(chkOutPgName);
		 Assert.assertTrue(pageHeaderFound);
		 
		 //Validate if the product name of the dress in the Cart Summary page is the same as what was selected
		 String productNameInSC = driver.findElement(By.xpath("//*[@id=\'cart_summary\']/tbody/tr/td[2]/p/a")).getText();
		 Assert.assertEquals(productName, productNameInSC);
		 		 
		 //Validate if the color of the dress in the Cart Summary page is the same as what was selected
		 String colorName = driver.findElement(By.xpath("//*[@id=\'cart_summary\']/tbody/tr/td[2]/small[2]/a")).getText();
		 System.out.println(colorName);
		 boolean isFound = colorName.indexOf(colourOfTheDress) !=-1? true: false;
		 Assert.assertTrue(isFound);
		 
		 //Validate if the quantity of the dresses in the Cart Summary page is the same as what was selected
		 String dressQtyInSC = driver.findElement(By.xpath("//*[@id=\'cart_summary\']/tbody/tr/td[5]/input[2]")).getAttribute("value");
		 System.out.println("Qty in Shoppint Cart page="+dressQtyInSC);
		 Assert.assertEquals(dressQuantity, dressQtyInSC);
		 
		
		
		 }
	
	 
	  

}
