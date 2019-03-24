//Page added by Vinod Vijayan for Task #2 

package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HomePage extends BasePage{
	
    public static String dress_xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a";
    public static String summer_dress_xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a"
	public static String summer_dress_tag_xpath = "//*[@id=\"center_column\"]/h1/span[1]"

    public HomePage(BrowserDriver driver) {
        super(driver);
    }
   
    public static void selectDressAndSummerDress() {
        driver.findElement(By.xpath(dress_xpath)).click();
        driver.findElement(By.xpath(summer_dress_xpath)).click();
        sleep(5000);
    }

    public static void checkPageDisplay() {
    	FileWriter fw=new FileWriter(“C:\\Program Files\\DemoTest\\TestResult.txt”);
    	BufferedWriter bw=new BufferedWriter(fw);    	
        If (driver.findElement(By.xpath(summer_dress_tag_xpath)).isDisplayed {
        	bw.write(“PASSED: Summer Dress page is displayed as expected”);
        	bw.newLine();
        } else {
        	bw.write(“FAILED: Summer Dress page is NOT displayed as expected”);
        	bw.newLine();
        }
        bw.close();
    }

}

