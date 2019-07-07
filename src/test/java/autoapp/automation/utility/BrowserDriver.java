package autoapp.automation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BrowserDriver implements WebDriver {

    public static WebDriver driver;
    String browserName;

    public BrowserDriver(WebDriver driver){
        this.driver = driver;
    };

    public BrowserDriver(String browserName) {
        this.browserName = browserName;

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/src/test/resources/chromedriver");
            this.driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + "/src/test/resources/geckodriver");
            this.driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void close() {
        this.driver.close();

    }

    public WebElement findElement(By arg0) {
        return this.driver.findElement(arg0);
    }

    public List<WebElement> findElements(By arg0) {
        return this.driver.findElements(arg0);
    }

    public void get(String arg0) {
        this.driver.get(arg0);

    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public String getPageSource() {
        return this.driver.getPageSource();
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    public Options manage() {
        return this.driver.manage();
    }

    public Navigation navigate() {
        return this.driver.navigate();
    }

    public void quit() {
        this.driver.quit();
    }

    public TargetLocator switchTo() {
        return this.driver.switchTo();
    }
    public static WebElement waitAndClick(WebDriver driver, WebElement element)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            return element;
        }
        catch(Exception e)
        {
            throw  e;
        }
    }
    public static WebElement waitUntilElementIsVisible(WebDriver driver,WebElement element)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOf(element));
            return element;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw  e;
        }
    }
    public static WebElement waitAndSendKeys(WebDriver driver, WebElement element, String text) {
        try{
            waitUntilElementIsVisible(driver,element);
            element.clear();
            element.sendKeys(text);
            return element;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw  e;
        }
    }

    public static void selectDropdown(WebDriver driver, WebElement dropDownBox, String value)
    {
        try
        {
            Select se1ect1 = new Select(dropDownBox);
            se1ect1.selectByVisibleText(value);
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public static String getPageTitle(){
            return driver.getTitle();
    }

    public static void hover_On_Element(WebDriver driver, WebElement element) {
            waitUntilElementIsVisible(driver,element);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();

    }
}