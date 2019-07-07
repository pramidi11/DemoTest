package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class InfoPage extends BasePage {

    private static By genderMale = By.id("uniform-id_gender1");
    private static By genderFemale = By.id("uniform-id_gender2");
    private static By firstName = By.id("customer_firstname");
    private static By lastName = By.id("customer_lastname");
    private static By password = By.id("passwd");
    private static By city = By.id("city");
    private static By address = By.id("address1");
    private static By state = By.id("id_state");
    private static By zip = By.id("postcode");
    private static By mobile = By.id("phone_mobile");
    private static By dropDown = By.id("id_state");
    private static By registerButton = By.id("submitAccount");

    public InfoPage(BrowserDriver driver) {
        super(driver);
    }

    public static void enterPersonalInformation(List<CustomerDetails> customerDetails) {
        for (CustomerDetails customerDetail : customerDetails) {
            if (customerDetail.getGender().equalsIgnoreCase("Mr"))
                waitAndClick(driver, driver.findElement(genderMale));
            else if (customerDetail.getGender().equalsIgnoreCase("Mrs"))
                waitAndClick(driver, driver.findElement(genderFemale));
            waitAndSendKeys(driver, driver.findElement(firstName), customerDetail.getFirstName());
            waitAndSendKeys(driver, driver.findElement(lastName), customerDetail.getLastName());
            waitAndSendKeys(driver, driver.findElement(password), customerDetail.getPassword());
            waitAndSendKeys(driver, driver.findElement(city), customerDetail.getCity());
            waitAndSendKeys(driver, driver.findElement(address), customerDetail.getAddress());
            selectDropdown(driver, driver.findElement(dropDown), customerDetail.getState());
            waitAndSendKeys(driver, driver.findElement(zip), customerDetail.getZip());
            waitAndSendKeys(driver, driver.findElement(mobile), customerDetail.getMobile());
            waitAndClick(driver, driver.findElement(registerButton));
        }
    }
}

