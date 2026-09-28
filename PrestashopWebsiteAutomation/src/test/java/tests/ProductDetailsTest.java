package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductDetailsPg;


public class ProductDetailsTest extends BaseTest{
	
	// Create Page Object
	ProductDetailsPg productdetailspg = new ProductDetailsPg(driver, wait);

    // =========================================================
    // PD_TC62 - OPEN PRODUCT DETAILS PAGE
    // =========================================================

    @Test(priority = 1)
    public void verifyProductDetailsPageOpens() {

        WebElement productTitle =
        		productdetailspg.getFeaturedProducts();

        Assert.assertTrue(
                productTitle.isDisplayed(),
                "Product details page was not displayed");

        System.out.println(
                "PD_TC62 - Product details page opened successfully");
    }

    // =========================================================
    // PD_TC63 - PRODUCT NAME
    // =========================================================

    @Test(priority = 2)
    public void verifyProductName() {

     productdetailspg.openProduct();

        WebElement productName =
        		productdetailspg.getProductName();

        Assert.assertFalse(
                productName.getText().trim().isEmpty(),
                "Product name is not displayed");

        System.out.println(
                "PD_TC63 - Product Name: "
                        + productName.getText());
    }

    // =========================================================
    // PD_TC66 - PRODUCT PRICE
    // =========================================================

    @Test(priority = 3)
    public void verifyProductPrice() {

        productdetailspg.openProduct();

        WebElement price =
        		productdetailspg.getCurrentPrice();

        Assert.assertTrue(
                price.isDisplayed(),
                "Discounted/current price is not displayed");

        Assert.assertFalse(
                price.getText().trim().isEmpty(),
                "Price value is empty");

        System.out.println(
                "PD_TC66 - Current price: "
                        + price.getText());
    }

    // =========================================================
    // PD_TC69 - PRODUCT DETAILS SECTION
    // =========================================================

    @Test(priority = 4)
    public void verifyProductDetailsSection() {

        productdetailspg.openProduct();

        WebElement details =
        		productdetailspg.openProductDetails();

        Assert.assertTrue(
                details.isDisplayed(),
                "Product Details section is not displayed");

        String detailsText =
                details.getText();

        Assert.assertTrue(
                detailsText.contains("Reference")
                        || detailsText.contains("Brand")
                        || detailsText.contains("In stock"),
                "Product details information is missing");

        System.out.println(
                "PD_TC69 - Product Details:");
        System.out.println(detailsText);
    }

    // =========================================================
    // PD_TC72 - SEARCH FROM PRODUCT PAGE
    // =========================================================

    @Test(priority = 5)
    public void verifySearchFromProductPage() {

        productdetailspg.openProduct();

        String heading =
        		productdetailspg.searchProduct("Mug");

        Assert.assertTrue(
                heading.toLowerCase().contains("search")
                        || heading.toLowerCase().contains("mug"),
                "Search results were not displayed");

        System.out.println(
                "PD_TC72 - Search from product page successful");
    }

    // =========================================================
    // PD_TC73 - SIZE AND COLOR SELECTION
    // =========================================================

    @Test(priority = 6)
    public void verifySizeAndColorSelection() {

        productdetailspg.openProduct();

        boolean selectionCompleted =
        		productdetailspg.selectSizeAndColor();

        Assert.assertTrue(
                selectionCompleted,
                "Size/color selection was not completed");

        System.out.println(
                "PD_TC73 - Size/Color selection tested");
    }

    // =========================================================
    // PD_TC74 - PRODUCT QUANTITY
    // =========================================================

    @Test(priority = 7)
    public void verifyProductQuantityIncreaseDecrease() {

        productdetailspg.openProduct();

        productdetailspg.enterQuantity("1");

        int initialQuantity =
        		productdetailspg.getQuantity();

        productdetailspg.clickPlus();

        productdetailspg.waitForQuantityIncrease(initialQuantity);

        int increasedQuantity =
        		productdetailspg.getQuantity();

        Assert.assertEquals(
                increasedQuantity,
                initialQuantity + 1,
                "Quantity did not increase correctly");

        productdetailspg.clickMinus();

        productdetailspg.waitForQuantity(initialQuantity);

        Assert.assertEquals(
        		productdetailspg.getQuantity(),
                initialQuantity,
                "Quantity did not decrease correctly");

        System.out.println(
                "PD_TC74 - Quantity increase/decrease successful");
    }

    // =========================================================
    // PD_TC75 - ADD PRODUCT TO CART
    // =========================================================

    @Test(priority = 8)
    public void verifyAddProductToCart() {

        productdetailspg.openProduct();

        WebElement cartModal =
        		productdetailspg.clickAddToCart();

        Assert.assertTrue(
                cartModal.isDisplayed(),
                "Add to cart confirmation was not displayed");

        System.out.println(
                "PD_TC75 - Product added to cart successfully");
    }

    // =========================================================
    // PD_TC76 - CART QUANTITY UPDATE
    // =========================================================

    @Test(priority = 9)
    public void verifyCartQuantityUpdate() {

        productdetailspg.openProduct();

        productdetailspg.enterQuantity("2");

        productdetailspg.clickAddToCart();

        String cartCount =
        		productdetailspg.getCartQuantity();

        Assert.assertTrue(
                cartCount.contains("2"),
                "Cart quantity was not updated correctly");

        System.out.println(
                "PD_TC76 - Cart quantity updated successfully");
    }
    
    @Test(priority = 10)
    public void navigateToHomePageTest() {

    	productdetailspg.clickMystorelogo();

        System.out.println("Navigated to Home page - Passed");
    }
}