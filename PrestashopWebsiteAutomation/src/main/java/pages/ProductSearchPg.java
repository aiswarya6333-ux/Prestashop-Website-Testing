package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class ProductSearchPg extends BaseTest{
	
	// Search box
	private By searchBox = By.xpath("//*[@id='ps_searchbar']/form/input[2]");

    // Search button
	private By searchButton = By.xpath("//*[@id='ps_searchbar']/form/i");

    // Search results - frames
	private By frameSearchResults = By.xpath("//h1[text()='Search results for \"frames\"']");

    // Invalid / blank search results
	private By searchResults = By.xpath("//*[@id='center-column']");

    // Search result - Hummingbird printed sweater
	private By hummingbirdSweater = By.xpath("//a[text()='Hummingbird printed sweater']");
    
	private By searchResultsShirt = By.xpath("//a[text()='Hummingbird printed t-shirt']");

    // Wrapper - used for case sensitivity comparison
	private By wrapper = By.xpath("//*[@id='wrapper']");
    
    // mystorelogo - click it and navigates to home page
	private By navToHome = By.xpath("//*[@id='header']/div[2]/div/div/div[1]/a");

    // Constructor
    public ProductSearchPg(WebDriver driver, WebDriverWait wait) {
    	BaseTest.driver = driver;
    	BaseTest.wait = wait;
    }

    // Search product using Enter key
    public void searchProduct(String productName) {

        WebElement search = wait.until(
                ExpectedConditions.elementToBeClickable(searchBox));

        search.clear();
        search.sendKeys(productName);
        search.sendKeys(Keys.ENTER);
    }

    // Search product using search icon
    public void searchProductByClickingIcon(String productName) {

        WebElement search = wait.until(
                ExpectedConditions.elementToBeClickable(searchBox));

        search.clear();
        search.sendKeys(productName);

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(searchButton));

        button.click();
    }

    // Get product name from search results
    public String getHummingbirdSweaterText() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        hummingbirdSweater))
                .getText();
    }

    // Get search results page text
    public String getSearchResultsText() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        searchResults))
                .getText();
    }

    // Verify frames search results page is displayed
    public boolean isFramesSearchResultsDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        frameSearchResults))
                .isDisplayed();
    }

    // Verify correct search results displayed for capital letters keyword search
    public void getSHIRTSearchResults() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                		searchResultsShirt));
    }
    
    // Verify correct search results displayed for capital letters keyword search
    public void getshirtSearchResults() {
    	 wait.until(
                 ExpectedConditions.visibilityOfElementLocated(
                 		searchResultsShirt));		
	}

    // Get wrapper count for case sensitivity test
    public int getWrapperCount() {

        return driver.findElements(wrapper).size();
    }
    
    // Navigate to home page
    public void clickMystorelogo() {

        wait.until(
                ExpectedConditions.elementToBeClickable(navToHome)
        ).click();
    }
}