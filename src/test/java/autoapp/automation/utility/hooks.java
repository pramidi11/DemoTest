package autoapp.automation.utility;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    public static BrowserDriver driver;

    @Before
    public void setUp(){
        String browserName;
        try {
            browserName = getParameter("browser");
        } catch(NoSuchFieldException e) {
            browserName = "chrome";
//            browserName = "firefox";
            System.out.println("No browser property found, defaulting to " + browserName);
        }
        System.out.println("driver " + browserName + "");
        driver = new BrowserDriver(browserName);
    }

    @After
    public void tearDown(){
        if(driver != null) {
            driver.close();
        }
    }

    private String getParameter(String name) throws NoSuchFieldException {
        String value = System.getProperty(name);
        if (value == null)
            throw new NoSuchFieldException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new NoSuchFieldException(name + " is empty!");

        return value;
    }
}
