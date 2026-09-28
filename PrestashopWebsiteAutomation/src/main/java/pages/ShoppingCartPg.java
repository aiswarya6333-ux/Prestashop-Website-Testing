package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class ShoppingCartPg extends BaseTest{
	
	// Product on Home Page
	private By addproductToCart = By.xpath(
            "(//button[@data-button-action='add-to-cart' and contains(@title,'Hummingbird printed t-shirt')])[1]");

    // Cart icon in header
	private By cartIcon = By.id("desktop_ps_shoppingcart");

    // Cart page elements
	private By shoppingCartHeading = By.xpath("//h1[text()='Shopping Cart']");

    // First product in home page
	private By productName = By.xpath("(//a[contains(text(),'Hummingbird printed t-shirt')])[1]");

    // Product image in shopping cart
	private By productImage = By.xpath("(//img[@alt ='Hummingbird printed t-shirt'])[1]");

    // Product price in shopping cart
	private By productPrice = By.cssSelector(".product-line__item-price");

    // Minus button in shopping cart
	private By minusButton = By.xpath("(//*[@id='decrement_button_1'])[1]");

    // Plus button in shopping cart
	private By plusButton = By.xpath("(//*[@id='increment_button_1'])[1]");

    // Quantity in shopping cart
	private By quantityField = By.cssSelector("input.js-cart-line-product-quantity");

    // Remove option
	private By removeButton = By.cssSelector("a[data-link-action='delete-from-cart']");

    // Proceed to checkout
	private By proceedToCheckout = By.xpath("//a[contains(text(),'Proceed to checkout')]");

    // Order summary section
	private By orderSummary = By.xpath("//*[contains(text(),'Order summary')]");

    // Product remove alert
	private By productRemoveAlert = By.cssSelector(".js-cart-update-alert");

    // Cart empty message
	private By cartEmptyMessage = By.className("cart__empty");
	
	// Navigate to home page - clicking my store logo
	private By navToHome = By.xpath("//*[@id='header']/div[2]/div/div/div[1]/a");
    
    // =========================
    // Constructor
    // =========================
    public ShoppingCartPg(WebDriver driver, WebDriverWait wait) {
		BaseTest.driver = driver;
    	BaseTest.wait = wait;
	}


    // Open Shopping Cart
    public void openCartPage() {

        // If cart icon is available, click it
        if (driver.findElements(cartIcon).size() > 0) {

            driver.findElement(cartIcon).click();

        } else {

            // Otherwise add product to cart
            driver.findElement(addproductToCart).click();
        }
    }


    // Verify Shopping Cart heading
    public boolean isShoppingCartPageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(shoppingCartHeading))
                .isDisplayed();
    }


    // Verify product name
    public boolean isProductNameDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productName))
                .isDisplayed();
    }


    // Verify product image
    public boolean isProductImageDisplayed() {

        return driver.findElement(productImage).isDisplayed();
    }


    // Get product name
    public String getProductName() {

        return driver.findElement(productName).getText();
    }


    // Get product price
    public String getProductPrice() {

        return driver.findElement(productPrice).getText();
    }


    // Verify order summary
    public boolean isOrderSummaryDisplayed() {

        return driver.findElement(orderSummary).isDisplayed();
    }


    // Increase quantity
    public void increaseQuantity() {

        WebElement quantity = driver.findElement(quantityField);

        String oldQuantity = quantity.getAttribute("value");

        driver.findElement(plusButton).click();

        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeToBe(
                        quantityField, "value", oldQuantity)));
    }


    // Get current quantity
    public String getQuantity() {

        return driver.findElement(quantityField).getAttribute("value");
    }


    // Decrease quantity
    public void decreaseQuantity() {

        WebElement quantity = driver.findElement(quantityField);

        String oldQuantity = quantity.getAttribute("value");

        driver.findElement(minusButton).click();

        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeToBe(
                        quantityField, "value", oldQuantity)));
    }


    // Remove product
    public void removeProduct() {

        driver.findElement(removeButton).click();
    }


    // Verify product remove alert
    public boolean isProductRemoveAlertDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productRemoveAlert))
                .isDisplayed();
    }


    // Check whether cart is empty
    public boolean isCartEmpty() {

        return driver.findElements(cartEmptyMessage).size() > 0;
    }


    // Add product again
    public void addProductToCart() {

        driver.findElement(addproductToCart).click();
    }


    // Proceed to checkout
    public void clickProceedToCheckout() {

        driver.findElement(proceedToCheckout).click();
    }
    
 // Navigate to home page
    public void clickMystorelogo() {

        wait.until(
                ExpectedConditions.elementToBeClickable(navToHome)
        ).click();
    }
}