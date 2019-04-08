package autoapp.automation.utility;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserDriver implements WebDriver {

    public static WebDriver driver;
    String browserName;

    public BrowserDriver(WebDriver driver){
        BrowserDriver.driver = driver;
    };

    public BrowserDriver(String browserName) {
        this.browserName = browserName;
        if (BrowserDriver.driver == null) {
        	 if (browserName.equalsIgnoreCase("chrome")) {
                 System.setProperty("webdriver.chrome.driver",
                         System.getProperty("user.dir") + "/src/test/resources/chromedriver");
                 BrowserDriver.driver = new ChromeDriver();
             } else if (browserName.equalsIgnoreCase("firefox")) {
                 System.setProperty("webdriver.gecko.driver",
                         System.getProperty("user.dir") + "/src/test/resources/geckodriver");
                 BrowserDriver.driver = new FirefoxDriver();
             }
        }
    }
   

    public void close() {
        BrowserDriver.driver.close();

    }

    public WebElement findElement(By arg0) {
        return BrowserDriver.driver.findElement(arg0);
    }

    public List<WebElement> findElements(By arg0) {
        return BrowserDriver.driver.findElements(arg0);
    }

    public void get(String arg0) {
        BrowserDriver.driver.get(arg0);

    }

    public String getCurrentUrl() {
        return BrowserDriver.driver.getCurrentUrl();
    }

    public String getPageSource() {
        return BrowserDriver.driver.getPageSource();
    }

    public String getTitle() {
        return BrowserDriver.driver.getTitle();
    }

    public String getWindowHandle() {
        return BrowserDriver.driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return BrowserDriver.driver.getWindowHandles();
    }

    public Options manage() {
        return BrowserDriver.driver.manage();
    }

    public Navigation navigate() {
        return BrowserDriver.driver.navigate();
    }

    public void quit() {
        BrowserDriver.driver.quit();
    }

    public TargetLocator switchTo() {
        return BrowserDriver.driver.switchTo();
    }
}