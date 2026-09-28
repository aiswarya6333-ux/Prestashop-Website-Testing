package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class HomePg extends BaseTest{
	
	// =========================
    // Locators
    // =========================

    // HP_TC38 / HP_TC46 - Home Page Slider
	private By nextButton = By.xpath("//span[@class='carousel-control-next-icon']");
	private By previousButton = By.xpath("//span[@class='carousel-control-prev-icon']");

    // HP_TC39 - Language Selector
	private By languageSelector = By.cssSelector("select[aria-label='Change language']");
	private By languageDropdown = By.xpath("//select[.//option[normalize-space()='English']]");
//    By languageDropdown = By.xpath("//*[@id='_desktop_ps_languageselector']/div/select/option[6]");

    // HP_TC40 - Featured Products
	private By featuredProducts = By.xpath("//h2[text()='Featured products']");

    // HP_TC42 - Quantity and Add to Cart
	private By quantity = By.xpath("(//*[@id='quantity_wanted_1'])[1]");
	private By increaseButton = By.xpath("(//*[@id='increment_button_1'])[1]");

	private By addToCart = By.xpath(
        "//*[@id='content']/section[3]/div/div[1]/div/article[1]/div/div[2]/div[2]/form/button"
    );

    // HP_TC43 - Promotion Banner
	private By promotionBanner = By.xpath("//*[@id='content']/section[4]/div/a/img");

    // HP_TC44 - Header
	private By logo = By.cssSelector(".logo");
	private By searchBox = By.cssSelector("input[name='s']");
	private By signIn = By.xpath("//a[contains(.,'Sign in')]");
	private By cart = By.xpath("//*[@id='_desktop_ps_shoppingcart']/div/div/span");
	private By clothes = By.xpath("//*[@id='top-menu']/li[1]/div[1]/a");
	private By accessories = By.xpath("//*[@id='top-menu']/li[2]/div[1]/a");

    // HP_TC45 - Footer
	private By footer = By.cssSelector("footer");
	private By products = By.xpath(".//*[contains(text(),'Products')]");
	private By company = By.xpath(".//*[contains(text(),'Our company')]");
	private By account = By.xpath(".//*[contains(text(),'Your account')]");
	private By storeInformation = By.xpath(".//*[contains(text(),'Store information')]");
    
    // =========================
    // Constructor
    // =========================
    public HomePg(WebDriver driver, WebDriverWait wait) {
		BaseTest.driver = driver;
    	BaseTest.wait = wait;
	}


    // =========================
    // HP_TC38 / HP_TC46
    // Home Page Load and Slider
    // =========================

    public WebElement getNextButton() {

        return wait.until(
            ExpectedConditions.elementToBeClickable(nextButton)
        );
    }

    public WebElement getPreviousButton() {

        return wait.until(
            ExpectedConditions.elementToBeClickable(previousButton)
        );
    }

    public void clickNextSlider() {

        getNextButton().click();
    }

    public void clickPreviousSlider() {

        getPreviousButton().click();
    }


    // =========================
    // HP_TC39
    // Language Selector
    // =========================

    public WebElement getLanguageSelector() {

        return wait.until(
            ExpectedConditions.elementToBeClickable(languageSelector)
        );
    }

    public void clickLanguageSelector() {

        getLanguageSelector().click();
    }
    
    // Select English language
    public void selectEnglishLanguage() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(languageDropdown));

        Select language = new Select(driver.findElement(languageDropdown));

        language.selectByVisibleText("English");
    }


    // =========================
    // HP_TC40
    // Featured Products
    // =========================

    public WebElement getFeaturedProducts() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(featuredProducts)
        );
    }

    public void hoverFeaturedProducts() {

        Actions actions = new Actions(driver);

        actions.moveToElement(getFeaturedProducts())
               .pause(Duration.ofSeconds(5))
               .perform();
    }


    // =========================
    // HP_TC42
    // Quantity
    // =========================

    public String getQuantity() {

        return driver.findElement(quantity)
                     .getAttribute("value");
    }

    public void increaseProductQuantity() {

        WebElement increase = wait.until(
            ExpectedConditions.elementToBeClickable(increaseButton)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            increase
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();",
            increase
        );
    }

    public void waitForQuantityToChange(String oldQuantity) {

        wait.until(
            ExpectedConditions.not(
                ExpectedConditions.attributeContains(
                    driver.findElement(quantity),
                    "value",
                    oldQuantity
                )
            )
        );
    }


    // =========================
    // HP_TC42
    // Add To Cart
    // =========================

    public void clickAddToCart() {

        WebElement addCart = wait.until(
            ExpectedConditions.elementToBeClickable(addToCart)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            addCart
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();",
            addCart
        );
    }


    // =========================
    // HP_TC43
    // Promotion Banner
    // =========================

    public WebElement getPromotionBanner() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                promotionBanner
            )
        );
    }


    // =========================
    // HP_TC44
    // Header
    // =========================

    public WebElement getLogo() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(logo)
        );
    }

    public WebElement getSearchBox() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(searchBox)
        );
    }

    public WebElement getSignIn() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(signIn)
        );
    }

    public WebElement getCart() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(cart)
        );
    }

    public WebElement getClothesCategory() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(clothes)
        );
    }

    public WebElement getAccessoriesCategory() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(accessories)
        );
    }


    // =========================
    // HP_TC45
    // Footer
    // =========================

    public WebElement getFooter() {

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(footer)
        );
    }

    public WebElement getProductsFooter() {

        return getFooter().findElement(products);
    }

    public WebElement getCompanyFooter() {

        return getFooter().findElement(company);
    }

    public WebElement getAccountFooter() {

        return getFooter().findElement(account);
    }

    public WebElement getStoreInformationFooter() {

        return getFooter().findElement(storeInformation);
    }
}