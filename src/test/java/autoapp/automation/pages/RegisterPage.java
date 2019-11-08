package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends HomePage{

    private static String verifyAuthenticationPage_xpath = "//body[@id='authentication']";
    private static String verifyPersonalDetailsForm_xpath = "//form[@id='account-creation_form']";
    private static String email_id = "email_create";
    private static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";

    private static String mr_id = "id_gender1";
    private static String mrs_id = "id_gender2";
    private static String customerFirstName_id = "customer_firstname";
    private static String customerLastName_id = "customer_lastname";
    private static String emailRegistration_id = "email";
    private static String password_id = "passwd";
    private static String offers_id = "optin";
    private static String firstName_id = "firstname";
    private static String lastName_id = "lastname";
    private static String address1_id = "address1";
    private static String city_id = "city";
    private static String state_id = "id_state";
    private static String postcode_id = "postcode";
    private static String country_id = "id_country";
    private static String mobilePhone_id = "phone_mobile";
    private static String alias_id = "alias";
    private static String register_id = "submitAccount";

    private static String registrationErrorMessage_xpath = "//div[@id='create_account_error']/ol/li";

    // store the randomly generated emailid (when creating a new account) for verification purposes
    private static String emailOfNewAccount;

    // The longest number of seconds we will wait for something to appear on the page
    private static int waitTime = 5;

    public RegisterPage(BrowserDriver driver){
        super(driver);
    }

    /*
    Verify the application is currently displaying the expected page
     */
    public static void verifyCorrectPage() {
        // Wait for the page to appear, occasionally it takes some time to fully load
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyAuthenticationPage_xpath)));
        Assert.assertTrue((driver.findElement(By.xpath(verifyAuthenticationPage_xpath)) != null), "We're not on the expected page: Authentication");
    }

    /*
    Method to enter a (randomised) email address and click the "Create an account" button
     */
    public static void createAccount(String emailid) {
        emailOfNewAccount = emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        driver.findElement(By.id(email_id)).sendKeys(emailOfNewAccount);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }

    /*
    Verify the Personal Information Form has loaded, before proceeding
     */
    public static void verifyPersonalInformationFormHasLoaded() {
        // Wait for the form to appear, occasionally it takes some time to fully load
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyPersonalDetailsForm_xpath)));
        Assert.assertTrue((driver.findElement(By.xpath(verifyPersonalDetailsForm_xpath)) != null), "We're not on the expected page: Authentication");

    }

    /*
    The method for entering personal information when creating an account
    Note that I have only populated the mandatory fields so far, and have left some fields to their default values
     */
    public static void enterPersonalInformation(DataTable personalInformation) {
        // http://www.automationtestinghub.com/cucumber-data-table/
        // I used this implementation on the off-chance that future extensions will add multiple rows to the
        // personalInformation table in the feature file. But it would mean "list.get(0)" needs to be
        // parameterised
        List<Map<String, String>> list = personalInformation.asMaps(String.class, String.class);

        // Determine gender to select the correct radio button
        String title = list.get(0).get("Gender");
        String elemId = "";
        switch(title) {
            case "Mr":
                elemId = mr_id;
                break;
            case "Mrs":
                elemId = mrs_id;
                break;
            default:
                System.out.println("Unknown title '" + title + "'; skipping this selection");
        }
        if(!elemId.equals("")) {
            driver.findElement(By.id(elemId)).click();
        }

        // Enter Customer First Name
        driver.findElement(By.id(customerFirstName_id)).sendKeys(list.get(0).get("FirstName"));

        // Enter Customer Last Name
        driver.findElement(By.id(customerLastName_id)).sendKeys(list.get(0).get("LastName"));

        // Verify the email address entered previously is displayed here
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(emailOfNewAccount, driver.findElement(By.id(emailRegistration_id)).getAttribute("value"), "Email addresses are different!");

        // Enter Password
        driver.findElement(By.id(password_id)).sendKeys(list.get(0).get("Password"));

        // Enter Address First Name
        //driver.findElement(By.id(firstName_id)).sendKeys(list.get(0).get("FirstName"));
        // value is set to the Customer First Name by the application

        // Enter Address Last Name
        //driver.findElement(By.id(lastName_id)).sendKeys(list.get(0).get("LastName"));
        // value is set to the Customer Last Name by the application

        // Enter Address Line 1
        driver.findElement(By.id(address1_id)).sendKeys(list.get(0).get("Address"));

        // Enter City
        driver.findElement(By.id(city_id)).sendKeys(list.get(0).get("City"));

        // Select State
        Select selCity = new Select(driver.findElement(By.id(state_id)));
        selCity.selectByVisibleText(list.get(0).get("State")); // Really should verify the option exists, before selecting

        // Enter Postcode
        driver.findElement(By.id(postcode_id)).sendKeys(list.get(0).get("Zip"));

        // Select Country
        /*
        Select selCountry = new Select(driver.findElement(By.id(country_id)));
        selCountry.selectByVisibleText(list.get(0).get("Country")); // Really should verify the option exists, before selecting
        */
        // Country is set to "United States" by default

        // Enter Mobile Phone
        driver.findElement(By.id(mobilePhone_id)).sendKeys(list.get(0).get("Mobile"));

        // Enter Alias
        driver.findElement(By.id(alias_id)).clear();
        driver.findElement(By.id(alias_id)).sendKeys(list.get(0).get("AddressAlias"));
    }

    public static void clickRegister() {
        driver.findElement(By.id(register_id)).click();
    }

    /*
    Verify the contents of error messages in email registration
    In this context, it seems there can only be a single message at any time.
    In other pages of the application, multiple error messages could appear (eg, when entering Personal Information)
     */
    public static void verifyEmailRegistrationErrorMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registrationErrorMessage_xpath)));
        String actualMessage = driver.findElement(By.xpath(registrationErrorMessage_xpath)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
