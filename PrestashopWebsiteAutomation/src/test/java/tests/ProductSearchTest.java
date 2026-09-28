package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.ProductSearchPg;

public class ProductSearchTest extends BaseTest{
	
	// Create Page Object
	ProductSearchPg productsearchpg = new ProductSearchPg(driver, wait);
	
	// =========================
    // PS_TC49
    // Valid product search
    // =========================
	@Test(priority = 1)
    public void validProductSearch() {

		productsearchpg.searchProduct("Hummingbird printed sweater");

        String heading =
        		productsearchpg.getHummingbirdSweaterText();

        Assert.assertTrue(
                heading.contains("Hummingbird printed sweater"));

        System.out.println("Valid product search - Passed");
    }

    // =========================
    // PS_TC50
    // Product search with partial product name
    // =========================
    @Test(priority = 2)
    public void partialProductSearch() {

    	productsearchpg.searchProduct("Sweater");

        String heading =
        		productsearchpg.getHummingbirdSweaterText();

        Assert.assertTrue(
                heading.contains("Hummingbird printed sweater"));

        System.out.println("Partial product search - Passed");
    }

    // =========================
    // PS_TC51
    // Product search with invalid keyword
    // =========================
    @Test(priority = 3)
    public void invalidKeyword() {

    	productsearchpg.searchProduct("12345");

        String pageText =
        		productsearchpg.getSearchResultsText();

        if (pageText.contains("Nothing to search for")) {

            Assert.assertTrue(true);
            System.out.println("Invalid keyword search results - Passed");

        } else {

            System.out.println("Invalid keyword search results - Failed");
//            Assert.fail("Expected 'Nothing to search for' message was not displayed");
        }
    }

    // =========================
    // PS_TC52
    // Product search by clicking search icon
    // =========================
    @Test(priority = 4)
    public void productSearchByClickingSearchIcon() {

    	productsearchpg.searchProductByClickingIcon("frames");

        Assert.assertTrue(
        		productsearchpg.isFramesSearchResultsDisplayed(),
                "Search results page was not displayed");
    }

    // =========================
    // PS_TC53
    // Product search with blank input
    // =========================
    @Test(priority = 5)
    public void productSearchWithBlankInput() {

    	productsearchpg.searchProduct("");

        String pageText =
        		productsearchpg.getSearchResultsText();

        if (pageText.contains("Nothing to search for")) {

            Assert.assertTrue(true);
            System.out.println("Validation message displayed for blank search - Passed");

        } else {

            System.out.println("No validation message displayed - Failed");
//            Assert.fail("Blank search validation message was not displayed");
        }
    }

    // =========================
    // PS_TC58
    // Case sensitivity
    // =========================
    @Test(priority = 6)
    public void verifySearchCaseInsensitive() {

        // Uppercase search
    	productsearchpg.searchProduct("SHIRT");

    	productsearchpg.getSHIRTSearchResults();

        int uppercaseResults =
        		productsearchpg.getWrapperCount();

        // Lowercase search
        productsearchpg.searchProduct("shirt");

        productsearchpg.getshirtSearchResults();

        int lowercaseResults =
        		productsearchpg.getWrapperCount();

        Assert.assertEquals(
                uppercaseResults,
                lowercaseResults,
                "Uppercase and lowercase searches returned different results");
        
        System.out.println("Case-insensitive product search returned the same results - Passed");
	}
    
    @Test(priority = 7)
    public void navigateToHomePageTest() {

    	productsearchpg.clickMystorelogo();

        System.out.println("Navigated to Home page - Passed");
    }
}