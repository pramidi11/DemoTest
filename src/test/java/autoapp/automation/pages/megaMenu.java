package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class megaMenu extends BasePage{
	
	 public megaMenu(BrowserDriver driver) {
	        super(driver);
	    }
	 
    public static void clickMegaMenuOpt(String mmOpt) {
    	
       	if (mmOpt.equals("WOMEN"))
    	{
       		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a")).click();    		
    	}
    	
    	if (mmOpt.equals("DRESSES"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();	
    	}
    	
    	if(mmOpt.equals("T-SHIRTS"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a")).click();	
    	}
    }

    public static void pageValidation(String pgVal)
    {
    	String catName;
    	System.out.println("In pgVal="+pgVal);
    	pgVal = pgVal.replaceAll("\\s","");
    	
    	if (pgVal.equals("WOMEN"))
    	{
    		catName= driver.findElement(By.xpath("//*[@id=\\'center_column\\']/div[1]/div/div/span")).getText();
       		Assert.assertEquals(catName.toLowerCase(), pgVal.toLowerCase());
    		System.out.println("The page is"+catName);
    	}

    	if(pgVal.equals("DRESSES"))
    	{
        	catName= driver.findElement(By.xpath("//*[@id=\\'center_column\\']/div[1]/div/div/span")).getText();
        	Assert.assertEquals(catName.toLowerCase(), pgVal.toLowerCase());
       		System.out.println("The page is"+catName);
    	}

    	if(pgVal.equals("T-SHIRTS"))
    	{
        	catName= driver.findElement(By.xpath("//*[@id=\'center_column\']/div[1]/div/div/span")).getText();
        	Assert.assertEquals(catName.toLowerCase(), pgVal.toLowerCase());
        	System.out.println("The page is"+catName);	
    	}
    	
    	if(pgVal.equals("BLOUSES"))
    	{
            catName= driver.findElement(By.xpath("//*[@id=\\'center_column\\']/div[1]/div/div/span")).getText();
            Assert.assertEquals(catName.toLowerCase(), pgVal.toLowerCase());
            System.out.println("The page is"+catName);
    	}

    	if(pgVal.equals("CASUAL DRESSES"))
    	{
        	catName= driver.findElement(By.xpath("//*[@id=\\'center_column\\']/div[1]/div/div/span")).getText();
        	Assert.assertEquals(catName.toLowerCase(), pgVal.toLowerCase());
            System.out.println("The page is"+catName);
    	}
    	
    	if(pgVal.equals("EVENING DRESSES"))
    	{
    		catName= driver.findElement(By.xpath("//*[@id=\\'center_column\\']/div[1]/div/div/span")).getText();
    	    Assert.assertEquals(catName, pgVal);
    	    System.out.println("The page is"+catName);
    	}
    	
    	if(pgVal.equals("SUMMER DRESSES"))
    	{
    		catName= driver.findElement(By.xpath("//*[@id=\\'center_column\\']/div[1]/div/div/span")).getText();
    		Assert.assertEquals(catName.toLowerCase(), pgVal.toLowerCase());
        	System.out.println("The page is"+catName);
    	}
    	
    }

    
    public static void mmHover(String mmHverOpt) {
    	
    	WebElement mmOption; 
    	
    	if(mmHverOpt.equals("WOMEN"))
    	{
    		mmOption = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
       		Actions action = new Actions(driver);
    		action.moveToElement(mmOption).perform();
    	}
    	
    	if(mmHverOpt.equals("DRESSES"))
       	{
        	mmOption = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));     		
       		Actions action = new Actions(driver);
       		action.moveToElement(mmOption).perform();
       	}
    }
    
    public static void hoverOptClick(String mmSubOpt){
    	  	
    	if(mmSubOpt.equals("T-Shirts"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
    	}

    	if(mmSubOpt.equals("Blouses"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a")).click();
    	}
    	
    	if(mmSubOpt.equals("Casual Dresses"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a")).click();
    	}
    	
    	if(mmSubOpt.equals("Evening Dresses"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[2]/a")).click();
    	}
    	
    	if(mmSubOpt.equals("Summer Dresses"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[3]/a")).click();
    	}
    	
    	if(mmSubOpt.equals("CASUAL DRESSES"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")).click();
    	}
    	
    	if(mmSubOpt.equals("EVENING DRESSES"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[2]/a")).click();
    	}
    	
    	if(mmSubOpt.equals("SUMMER DRESSES"))
    	{
    		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")).click();
    	}
    	
    }
    
}
