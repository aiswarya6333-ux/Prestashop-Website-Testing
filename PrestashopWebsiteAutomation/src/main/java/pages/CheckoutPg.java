package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class CheckoutPg extends BaseTest{
	
	// Cart icon
	private By cartIcon = By.id("desktop_ps_shoppingcart");

    // Product on Home Page
	private By addproductToCart = By.xpath(
            "//*[@id='content']/section[3]/div/div[1]/div/article[1]/div/div[2]/div[2]/form/button");

    // Proceed to checkout
	private By proceedToCheckout = By.xpath(
            "//a[contains(text(),'Proceed to checkout')]");

    // Personal information
	private By personalInformation = By.xpath(
            "//*[contains(text(),'Personal Information') or contains(text(),'Guest checkout')]");

    // First name
	private By firstName = By.id("field-firstname");

    // Last name
	private By lastName = By.id("field-lastname");

    // Email
	private By email = By.id("field-email");

    // Continue button
	private By continueButton = By.xpath("//button[contains(.,'Continue')]");

    // Addresses
	private By addresses = By.xpath("//*[contains(text(),'Addresses')]");

    // Show details
	private By showDetails = By.xpath("//*[contains(text(),'Show details')]");

    // First name label
	private By firstNameLabel = By.cssSelector("label[for='field-firstname']");

    // Last name label
	private By lastNameLabel = By.cssSelector("label[for='field-lastname']");

    // Postal code
	private By postalCode = By.id("field-postcode");

    // Country
	private By country = By.id("field-id_country");

    // Shipping
	private By shipping = By.xpath("//*[contains(text(),'Shipping')]");

    // Payment methods
	private By bankWire = By.xpath("//*[contains(text(),'Bank wire')]");
	private By cashOnDelivery = By.xpath("//*[contains(text(),'Cash on delivery')]");
	private By check = By.xpath("//*[contains(text(),'Check')]");

    // Radio buttons
	private By paymentRadioButtons = By.cssSelector("input[type='radio']");

    // Terms checkbox
	private By terms = By.id("conditions_to_approve[terms-and-conditions]");

    // Order total
	private By orderTotal = By.cssSelector(".cart-total .value");

    // Back to shipping
	private By backToShipping = By.xpath("//a[contains(text(),'Back to shipping')]");

    // Terms and conditions link
	private By termsLink = By.xpath("//*[contains(text(),'terms and conditions')]");

    // Place order
	private By placeOrder = By.xpath("//button[contains(.,'Place order')]");

    // Order confirmation
	private By orderConfirmation = By.xpath(
            "//*[contains(text(),'Your order is confirmed')]");


    // Constructor
    public CheckoutPg(WebDriver driver, WebDriverWait wait) {
        BaseTest.driver = driver;
        BaseTest.wait = wait;
    }


    // ---------------------------------------------------------
    // Open Checkout
    // ---------------------------------------------------------

    public void openCheckout() {

        // If product is already in cart, click cart
        if (driver.findElements(cartIcon).size() > 0) {

            driver.findElement(cartIcon).click();

        } else {

            // Add product to cart
            driver.findElement(addproductToCart).click();
        }

        // Proceed to checkout
        WebElement checkout = wait.until(
                ExpectedConditions.elementToBeClickable(proceedToCheckout));

        checkout.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.tagName("body")));
    }


    // ---------------------------------------------------------
    // CO_TC103 - Personal Information
    // ---------------------------------------------------------

    public void enterPersonalInformation(
            String firstNameValue,
            String lastNameValue,
            String emailValue) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(firstNameValue);

        driver.findElement(lastName)
                .sendKeys(lastNameValue);

        driver.findElement(email)
                .sendKeys(emailValue);
    }


    public String getFirstNameValue() {
        return driver.findElement(firstName).getAttribute("value");
    }


    public String getLastNameValue() {
        return driver.findElement(lastName).getAttribute("value");
    }


    public String getEmailValue() {
        return driver.findElement(email).getAttribute("value");
    }


    // ---------------------------------------------------------
    // Continue
    // ---------------------------------------------------------

    public void clickContinue() {

        wait.until(ExpectedConditions.elementToBeClickable(continueButton))
                .click();
    }


    // ---------------------------------------------------------
    // Show Details
    // ---------------------------------------------------------

    public void clickShowDetails() {

        wait.until(ExpectedConditions.elementToBeClickable(showDetails))
                .click();
    }


    // ---------------------------------------------------------
    // Payment
    // ---------------------------------------------------------

    public void clickBankWire() {

        wait.until(ExpectedConditions.elementToBeClickable(bankWire))
                .click();
    }


    public void clickCashOnDelivery() {

        wait.until(ExpectedConditions.elementToBeClickable(cashOnDelivery))
                .click();
    }


    // ---------------------------------------------------------
    // Terms
    // ---------------------------------------------------------

    public boolean isTermsDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(terms))
                .isDisplayed();
    }


    public void selectTerms() {

        WebElement termsElement = wait.until(
                ExpectedConditions.elementToBeClickable(terms));

        if (!termsElement.isSelected()) {
            termsElement.click();
        }
    }


    // ---------------------------------------------------------
    // Postal Code
    // ---------------------------------------------------------

    public void enterPostalCode(String postalCodeValue) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode))
                .sendKeys(postalCodeValue);
    }


    public String getPostalCodeValue() {

        return driver.findElement(postalCode)
                .getAttribute("value");
    }


    // ---------------------------------------------------------
    // Verification methods
    // ---------------------------------------------------------

    public boolean isAddressesDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(addresses))
                .isDisplayed();
    }


    public boolean isPersonalInformationDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(personalInformation))
                .isDisplayed();
    }


    public boolean isFirstNameLabelMandatory() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameLabel))
                .getText().contains("*");
    }


    public boolean isLastNameLabelMandatory() {

        return driver.findElement(lastNameLabel)
                .getText().contains("*");
    }


    public boolean isCountryDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(country))
                .isDisplayed();
    }


    public boolean isShippingDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(shipping))
                .isDisplayed();
    }


    public boolean isBankWireDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(bankWire))
                .isDisplayed();
    }


    public boolean isCashOnDeliveryDisplayed() {

        return driver.findElement(cashOnDelivery).isDisplayed();
    }


    public boolean isCheckDisplayed() {

        return driver.findElement(check).isDisplayed();
    }


    public int getSelectedPaymentMethodCount() {

        int selectedCount = 0;

        for (WebElement radio : driver.findElements(paymentRadioButtons)) {

            if (radio.isSelected()) {
                selectedCount++;
            }
        }

        return selectedCount;
    }


    public boolean isOrderTotalDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(orderTotal))
                .isDisplayed();
    }


    // ---------------------------------------------------------
    // Back to Shipping
    // ---------------------------------------------------------

    public void clickBackToShipping() {

        wait.until(ExpectedConditions.elementToBeClickable(backToShipping))
                .click();
    }


    // ---------------------------------------------------------
    // Terms Link
    // ---------------------------------------------------------

    public void clickTermsLink() {

        wait.until(ExpectedConditions.elementToBeClickable(termsLink))
                .click();
    }


    // ---------------------------------------------------------
    // Place Order
    // ---------------------------------------------------------

    public void clickPlaceOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(placeOrder))
                .click();
    }


    public boolean isOrderConfirmationDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        orderConfirmation))
                .isDisplayed();
    }


    // ---------------------------------------------------------
    // Page Source Verification
    // ---------------------------------------------------------

    public boolean isPersonalInformationInPageSource() {

        return driver.getPageSource().contains("Personal Information")
                || driver.getPageSource().contains("First name");
    }


    public boolean isTermsInPageSource() {

        return driver.getPageSource().contains("Terms");
    }
}