package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class SignInPg extends BaseTest{

    // Registration
	private By createAccount = By.xpath("//a[contains(text(), 'Create your account')]");
	private By mrRadio = By.xpath("//input[@id='field-id_gender_1']");
	private By mrsRadio = By.xpath("//input[@id='field-id_gender_2']");
	private By firstName = By.name("firstname");
	private By lastName = By.name("lastname");
	private By email = By.name("email");
	private By password = By.name("password");
	private By birthday = By.id("field-birthday");
	private By termsCheckbox = By.id("field-psgdpr");
	private By privacyCheckbox = By.id("field-customer_privacy");
	private By createAccountButton = By.xpath("//button[contains(., 'Create account')]");
	private By duplicateEmailError = By.xpath("//*[@id='customer-form']/section/div[4]/div/div");
    
    // Sign In
	private By signInLink = By.xpath("//span[contains(text(),'Sign in')]");
	private By emailField = By.id("field-email");
	private By passwordField = By.id("field-password");
	private By signInButton = By.id("submit-login");
	private By navToHome = By.xpath("//*[@id='header']/div[2]/div/div/div[1]/a");
    
    // Logout
	private By signOut = By.cssSelector("a.logout");

    // Constructor
    public SignInPg(WebDriver driver, WebDriverWait wait) {
    	BaseTest.driver = driver;
    	BaseTest.wait = wait;
    }

    // =====================================================
    // REGISTRATION METHODS
    // =====================================================

    public void clickSignInLink() {

        wait.until(
                ExpectedConditions.elementToBeClickable(signInLink)
        ).click();
    }


    public void clickCreateAccount() {

        wait.until(
                ExpectedConditions.elementToBeClickable(createAccount)
        ).click();
    }


    public void selectGender(String gender) {

        if (gender.equals("Mr.")) {

            wait.until(
                    ExpectedConditions.elementToBeClickable(mrRadio)
            ).click();

        } else if (gender.equals("Mrs.")) {

            wait.until(
                    ExpectedConditions.elementToBeClickable(mrsRadio)
            ).click();
        }
    }


    public void enterFirstName(String value) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName)
        ).sendKeys(value);
    }


    public void enterLastName(String value) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastName)
        ).sendKeys(value);
    }


    public void enterRegistrationEmail(String value) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(email)
        ).sendKeys(value);
    }


    public void enterRegistrationPassword(String value) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(password)
        ).sendKeys(value);
    }


    public void enterBirthday(String value) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(birthday)
        ).sendKeys(value);
    }


    public void selectTerms(boolean required) {

        WebElement checkbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(termsCheckbox)
        );

        if (required && !checkbox.isSelected()) {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    checkbox
            );
        }
    }


    public void selectPrivacy(boolean required) {

        WebElement checkbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(privacyCheckbox)
        );

        if (required && !checkbox.isSelected()) {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    checkbox
            );
        }
    }


    public void clickCreateAccountButton() {

        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        createAccountButton
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                button
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
        );
    }


    public boolean isRegistrationSuccessful() {

        WebElement logout = wait.until(
                ExpectedConditions.visibilityOfElementLocated(signOut)
        );

        return logout.isDisplayed();
    }


    public boolean isDuplicateEmailErrorDisplayed() {

        WebElement duplicateEmailErrorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        duplicateEmailError
                )
        );

        return duplicateEmailErrorElement.isDisplayed();
    }


    public boolean isDuplicateEmailErrorCorrect() {

        WebElement duplicateEmailErrorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        duplicateEmailError
                )
        );

        return duplicateEmailErrorElement.getText().contains(
                "The email is already used, please choose another one or sign in"
        );
    }


    public void clickSignOut1() {

        WebElement signOutElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(signOut)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                signOutElement
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                signOutElement
        );
    }


    // =====================================================
    // SIGN IN METHODS
    // =====================================================

    public void enterEmail(String email) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
        ).sendKeys(email);
    }


    public void enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        ).sendKeys(password);
    }


    public void clickSignInButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(signInButton)
        ).click();
    }


    public boolean isSignOutDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(signOut)
        ).isDisplayed();
    }


    public boolean isSignInPageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
        ).isDisplayed();
    }


    public void clickSignOut2() {

        WebElement logout = wait.until(
                ExpectedConditions.visibilityOfElementLocated(signOut)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                logout
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                logout
        );
    }
    
    // Navigate to home page
    public void clickMystorelogo() {

        wait.until(
                ExpectedConditions.elementToBeClickable(navToHome)
        ).click();
    }
}