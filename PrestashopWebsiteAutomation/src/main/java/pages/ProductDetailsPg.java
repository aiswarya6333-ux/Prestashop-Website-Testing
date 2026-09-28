package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class ProductDetailsPg extends BaseTest{
	
	// =========================================================
    // LOCATORS
    // =========================================================

    private By productSection = By.xpath("//*[@id='content']/section[3]");

    private By productNameLink = By.xpath("(//a[text()='Hummingbird printed t-shirt'])[1]");

    private By productPageTitle = By.xpath("//span[text()='Hummingbird printed t-shirt']");

    private By featuredProducts = By.xpath("//h2[text()='Featured products']");

    private By productName = By.xpath("//*[@id='center-column']/div[1]/div[2]/h1");

    private By currentPrice = By.cssSelector(".current-price");

    private By detailsTab = By.cssSelector("a[href='#product-details']");

    private By productDetails = By.cssSelector("#product-details");

    private By searchBox = By.cssSelector("input[name='s']");

    private By searchResultsHeading = By.cssSelector("#js-product-list-header");

    private By colorOptions = By.cssSelector(".input-color + span, input[name^='group'][type='radio']");

    private By sizeOptions = By.cssSelector("select[name^='group'], input[name^='group'][type='radio']");

    private By quantity = By.cssSelector("input[name='qty']");

    private By plusButton = By.cssSelector(".touchspin-up");

    private By minusButton = By.cssSelector(".touchspin-down");

    private By addToCart = By.cssSelector("button.add-to-cart");

    private By cartModal = By.cssSelector("#blockcart-modal");

    private By cartCount = By.cssSelector(".cart-products-count");

    private By productCard = By.cssSelector(".products .product-miniature");

    private By productCardTitle = By.cssSelector(".product-title");

    private By productCardImage = By.cssSelector("img");

    private By quickViewButton = By.cssSelector(".js-quick-view");

    private By quickViewModal = By.cssSelector(".quickview.modal.show");

    private By quickViewProductName = By.cssSelector("h1.h1");
    
    private By navToHome = By.xpath("//*[@id='header']/div[2]/div/div/div[1]/a");
    
    // =========================
    // Constructor
    // =========================
    public ProductDetailsPg(WebDriver driver, WebDriverWait wait) {
		BaseTest.driver = driver;
    	BaseTest.wait = wait;
    }

    // =========================================================
    // OPEN PRODUCT
    // =========================================================

    public void openProduct() {

    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
                wait.until(ExpectedConditions
                        .visibilityOfElementLocated(productSection)));

        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(productNameLink));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(productPageTitle));
    }

    // =========================================================
    // PRODUCT DETAILS METHODS
    // =========================================================

    public WebElement getFeaturedProducts() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(featuredProducts));
    }

    public WebElement getProductName() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productName));
    }

    public WebElement getCurrentPrice() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(currentPrice));
    }

    // =========================================================
    // PRODUCT DETAILS SECTION
    // =========================================================

    public WebElement openProductDetails() {

        WebElement tab = wait.until(
                ExpectedConditions.elementToBeClickable(detailsTab));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                tab);

        tab.click();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productDetails));
    }

    // =========================================================
    // SEARCH FROM PRODUCT PAGE
    // =========================================================

    public String searchProduct(String searchText) {

        WebElement search = wait.until(
                ExpectedConditions.elementToBeClickable(searchBox));

        search.clear();
        search.sendKeys(searchText);
        search.sendKeys(Keys.ENTER);

        WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        searchResultsHeading));

        return heading.getText();
    }

    // =========================================================
    // SIZE AND COLOR
    // =========================================================

    public boolean selectSizeAndColor() {

        List<WebElement> colors =
                driver.findElements(colorOptions);

        if (!colors.isEmpty()) {

            WebElement color = colors.get(0);

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    color);
        }

        List<WebElement> sizes =
                driver.findElements(sizeOptions);

        if (!sizes.isEmpty()) {

            WebElement size = sizes.get(0);

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    size);
        }

        return true;
    }

    // =========================================================
    // QUANTITY
    // =========================================================

    public int getQuantity() {

        WebElement qty = wait.until(
                ExpectedConditions.visibilityOfElementLocated(quantity));

        return Integer.parseInt(qty.getAttribute("value"));
    }

    public void enterQuantity(String value) {

        WebElement qty = wait.until(
                ExpectedConditions.visibilityOfElementLocated(quantity));

        qty.clear();
        qty.sendKeys(value);
    }

    public void clickPlus() {

        WebElement plus = wait.until(
                ExpectedConditions.elementToBeClickable(plusButton));

        plus.click();
    }

    public void clickMinus() {

        WebElement minus = wait.until(
                ExpectedConditions.elementToBeClickable(minusButton));

        minus.click();
    }

    public void waitForQuantityIncrease(int initialQuantity) {

        wait.until(driver ->
                getQuantity() > initialQuantity);
    }

    public void waitForQuantity(int expectedQuantity) {

        wait.until(driver ->
                getQuantity() == expectedQuantity);
    }

    // =========================================================
    // ADD TO CART
    // =========================================================

    public WebElement clickAddToCart() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(addToCart));

        button.click();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartModal));
    }

    // =========================================================
    // CART QUANTITY
    // =========================================================

    public String getCartQuantity() {

        WebElement count = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartCount));

        return count.getText();
    }

    // =========================================================
    // PRODUCT CARD
    // =========================================================

    public WebElement getProductCard() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productCard));
    }

    public WebElement getProductCardTitle() {

        return getProductCard().findElement(productCardTitle);
    }

    public WebElement getProductCardImage() {

        return getProductCard().findElement(productCardImage);
    }

    // =========================================================
    // QUICK VIEW
    // =========================================================

    public WebElement openQuickView() {

        WebElement card = getProductCard();

        Actions actions = new Actions(driver);

        actions.moveToElement(card).perform();

        WebElement quickView =
                wait.until(ExpectedConditions.elementToBeClickable(
                        card.findElement(quickViewButton)));

        quickView.click();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        quickViewModal));
    }

    public WebElement getQuickViewProductName() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        quickViewProductName));
    }

    public WebElement getQuickViewPrice() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(
                                ".quickview.modal.show .current-price")));
    }

    public WebElement getQuickViewQuantity() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(
                                ".quickview.modal.show input[name='qty']")));
    }

    public WebElement getQuickViewPlusButton() {

        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(
                                ".quickview.modal.show .touchspin-up")));
    }

    public WebElement getQuickViewAddToCart() {

        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(
                                ".quickview.modal.show button.add-to-cart")));
    }
    
    // Navigate to home page
    public void clickMystorelogo() {

        wait.until(
                ExpectedConditions.elementToBeClickable(navToHome)
        ).click();
    }
}
