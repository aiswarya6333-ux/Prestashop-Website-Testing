package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class RegistrationPg extends BaseTest{
	
    // =========================
    // LOCATORS
    // =========================

    // Sign in
	private By signIn = By.xpath("//span[contains(text(),'Sign in')]");

    // Create an account link
	private By createAccount = By.xpath("//a[contains(text(), 'Create your account')]");

    // Gender
	private By mrRadio = By.xpath("//input[@id='field-id_gender_1']");
	private By mrsRadio = By.xpath("//input[@id='field-id_gender_2']");

    // Registration fields
	private By firstName = By.name("firstname");
	private By lastName = By.name("lastname");
	private By email = By.name("email");
	private By password = By.name("password");
	private By birthday = By.id("field-birthday");

    // Terms and privacy
	private By termsCheckbox = By.id("field-psgdpr");
	private By privacyCheckbox = By.id("field-customer_privacy");

    // Create account button
	private By createAccountButton = By.xpath("//button[contains(., 'Create account')]");

    // Logout
	private  By signOut = By.cssSelector("a.logout");


    // =========================
    // CONSTRUCTOR
    // =========================

    public RegistrationPg(WebDriver driver, WebDriverWait wait) {

    	BaseTest.driver = driver;
    	BaseTest.wait = wait;
    }


    // =========================
    // NAVIGATION METHODS
    // =========================

    public void clickSignIn() {

        wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
    }


    public void clickCreateAccount() {

        wait.until(ExpectedConditions.elementToBeClickable(createAccount)).click();
    }


    // =========================
    // GENDER METHODS
    // =========================

    public void selectGender(String gender) {

        if (gender.equals("Mr.")) {

            WebElement mr = wait.until(
                    ExpectedConditions.elementToBeClickable(mrRadio));

            mr.click();

        } else if (gender.equals("Mrs.")) {

            WebElement mrs = wait.until(
                    ExpectedConditions.elementToBeClickable(mrsRadio));

            mrs.click();
        }
    }


    // =========================
    // REGISTRATION FIELD METHODS
    // =========================

    public void enterFirstName(String value) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(value);
    }


    public void enterLastName(String value) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName))
                .sendKeys(value);
    }


    public void enterEmail(String value) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .sendKeys(value);
    }


    public void enterPassword(String value) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .sendKeys(value);
    }


    public void enterBirthday(String value) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(birthday))
                .sendKeys(value);
    }


    // =========================
    // CHECKBOX METHODS
    // =========================

    public void selectTerms(boolean required) {

        WebElement checkbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(termsCheckbox));

        if (required && !checkbox.isSelected()) {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", checkbox);
        }
    }


    public void selectPrivacy(boolean required) {

        WebElement checkbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(privacyCheckbox));

        if (required && !checkbox.isSelected()) {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", checkbox);
        }
    }


    // =========================
    // CREATE ACCOUNT
    // =========================

    public void clickCreateAccountButton() {

        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        createAccountButton));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                button);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button);
    }


    // =========================
    // VERIFICATION METHODS
    // =========================

    public boolean isRegistrationSuccessful() {

        WebElement logout = wait.until(
                ExpectedConditions.visibilityOfElementLocated(signOut));
        return logout.isDisplayed();
    }


    public boolean isRegistrationPageDisplayed() {

        WebElement firstNameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName));

        return firstNameField.isDisplayed();
    }
}