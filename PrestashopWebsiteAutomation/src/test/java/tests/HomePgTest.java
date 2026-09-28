package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePg;

public class HomePgTest extends BaseTest{
	
	// Create Page Object
	HomePg homepg = new HomePg(driver, wait);
	
    // =========================
    // HP_TC38 - Home Page Load
    // HP_TC46 - Home Page Slider
    // =========================

    @Test(priority = 1)
    public void verifyHomePageLoadsSuccessfullyandBannerSlider() {

        Assert.assertTrue(
            homepg.getNextButton().isDisplayed(),
            "Next arrow is not displayed"
        );

        Assert.assertTrue(
            homepg.getPreviousButton().isDisplayed(),
            "Previous arrow is not displayed"
        );

        homepg.clickNextSlider();

        homepg.clickPreviousSlider();

        System.out.println(
            "HP_TC38 - Home page loaded successfully and " +
            "HP_TC46 - Home page slider verified"
        );
    }


    // =========================
    // HP_TC39 - Language Selector
    // =========================

    @Test(priority = 2)
    public void verifyLanguageSelector() {

        homepg.clickLanguageSelector();

        Assert.assertTrue(
            homepg.getLanguageSelector().isDisplayed(),
            "Language options are not displayed"
        );

        System.out.println(
            "HP_TC39 - Language selector is working"
        );
    }
    
    @Test(priority = 3)
    public void selectEnglishLanguageTest() {

        homepg.selectEnglishLanguage();

        System.out.println("HP_TC39 - English language selected - Passed");
    }


    // =========================
    // HP_TC40 - Featured Products
    // =========================

    @Test(priority = 4)
    public void verifyFeaturedProducts() {

        Assert.assertTrue(
            homepg.getFeaturedProducts().isDisplayed(),
            "Featured products section is not displayed"
        );

        homepg.hoverFeaturedProducts();

        System.out.println(
            "HP_TC40 - Featured products are displayed and " +
            "clickable in home page"
        );
    }


    // =========================
    // HP_TC42 - Quantity & Add To Cart
    // =========================

    @Test(priority = 5)
    public void verifyProductQuantityAndAddToCart() {

        String oldQuantity = homepg.getQuantity();

        homepg.increaseProductQuantity();

        homepg.waitForQuantityToChange(oldQuantity);

        String newQuantity = homepg.getQuantity();

        Assert.assertNotEquals(
            newQuantity,
            oldQuantity,
            "Product quantity did not increase"
        );

        System.out.println(
            "HP_TC42 - Product quantity increased successfully from "
            + oldQuantity + " to " + newQuantity
        );

        homepg.clickAddToCart();

        System.out.println(
            "HP_TC42 - Product quantity increased and " +
            "it is added to cart successfully"
        );
    }


    // =========================
    // HP_TC43 - Promotion Banner
    // =========================

    @Test(priority = 6)
    public void verifyPromotionBanner() {

        Assert.assertTrue(
            homepg.getPromotionBanner().isDisplayed(),
            "Promotion banner is not displayed"
        );

        System.out.println(
            "HP_TC43 - Promotion banner displayed"
        );
    }


    // =========================
    // HP_TC44 - Header Section
    // =========================

    @Test(priority = 7)
    public void verifyHeaderSection() {

       Assert.assertTrue(
            homepg.getLogo().isDisplayed(),
            "Logo is not displayed"
        );

        Assert.assertTrue(
            homepg.getSearchBox().isDisplayed(),
            "Search box is not displayed"
        );

        Assert.assertTrue(
            homepg.getSignIn().isDisplayed(),
            "Sign in option is not displayed"
        );

        Assert.assertTrue(
            homepg.getCart().isDisplayed(),
            "Cart option is not displayed"
        );

        Assert.assertTrue(
            homepg.getClothesCategory().isDisplayed(),
            "Clothes category is not displayed"
        );

        Assert.assertTrue(
            homepg.getAccessoriesCategory().isDisplayed(),
            "Accessories category is not displayed"
        );

        System.out.println(
            "HP_TC44 - Header section verified"
        );
    }


    // =========================
    // HP_TC45 - Footer Section
    // =========================

    @Test(priority = 8)
    public void verifyFooterSection() {

        Assert.assertTrue(
            homepg.getFooter().isDisplayed(),
            "Footer is not displayed"
        );

        Assert.assertTrue(
            homepg.getProductsFooter().isDisplayed(),
            "Products is not displayed"
        );

        Assert.assertTrue(
            homepg.getCompanyFooter().isDisplayed(),
            "Our company is not displayed"
        );

        Assert.assertTrue(
            homepg.getAccountFooter().isDisplayed(),
            "Your account is not displayed"
        );

        Assert.assertTrue(
            homepg.getStoreInformationFooter().isDisplayed(),
            "Store information is not displayed"
        );

        System.out.println(
            "HP_TC45 - Footer section verified"
        );
    }
}