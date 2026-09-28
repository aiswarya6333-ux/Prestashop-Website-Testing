package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ShoppingCartPg;

public class ShoppingCartTest extends BaseTest{
	
	// Create Page Object
	ShoppingCartPg shoppingcartpg = new ShoppingCartPg(driver, wait);
	
	// SC_TC88
    @Test(priority = 1)
    public void verifyShoppingCartPage() {

        Assert.assertTrue(
        		shoppingcartpg.isShoppingCartPageDisplayed(),
                "Shopping Cart page is not displayed"
        );
    }


    // SC_TC89
    @Test(priority = 2)
    public void verifyProductDisplayedInCart() {

        Assert.assertTrue(
        		shoppingcartpg.isProductNameDisplayed(),
                "Product name is not displayed"
        );

        Assert.assertTrue(
        		shoppingcartpg.isProductImageDisplayed(),
                "Product image is not displayed"
        );
    }


    // SC_TC90
    @Test(priority = 3)
    public void verifyProductDetailsInCart() {

        String productText = shoppingcartpg.getProductName();

        Assert.assertTrue(
                productText.contains("Hummingbird"),
                "Wrong product is displayed"
        );
    }


    // SC_TC91
    @Test(priority = 4)
    public void verifyProductPriceInCart() {

        String price = shoppingcartpg.getProductPrice();

        Assert.assertEquals(
                price,
                "€22.94"
        );
    }


    // SC_TC92
    @Test(priority = 5)
    public void verifyOrderSummary() {

        Assert.assertTrue(
        		shoppingcartpg.isOrderSummaryDisplayed(),
                "Order summary is not displayed"
        );
    }


    // SC_TC93
    @Test(priority = 6)
    public void verifyIncreaseQuantity() {

        String oldQuantity = shoppingcartpg.getQuantity();

        shoppingcartpg.increaseQuantity();

        String newQuantity = shoppingcartpg.getQuantity();

        Assert.assertNotEquals(
                oldQuantity,
                newQuantity,
                "Quantity did not increase"
        );
    }


    // SC_TC93
    @Test(priority = 7)
    public void verifyDecreaseQuantity() {

        String oldQuantity = shoppingcartpg.getQuantity();

        shoppingcartpg.decreaseQuantity();

        String newQuantity = shoppingcartpg.getQuantity();

        Assert.assertNotEquals(
                oldQuantity,
                newQuantity,
                "Quantity did not decrease"
        );
    }


    // SC_TC96
    @Test(priority = 8)
    public void verifyRemoveProduct() {

    	shoppingcartpg.removeProduct();

        Assert.assertTrue(
        		shoppingcartpg.isProductRemoveAlertDisplayed(),
                "Product was not removed from cart"
        );
    }


    // SC_TC98 / SC_TC99
    @Test(priority = 9)
    public void verifyProceedToCheckout() {

        // Add product again if cart is empty
        if (shoppingcartpg.isCartEmpty()) {

        	shoppingcartpg.addProductToCart();
        }

        shoppingcartpg.clickProceedToCheckout();
    }
    
    @Test(priority = 10)
    public void navigateToHomePageTest() {

    	shoppingcartpg.clickMystorelogo();

        System.out.println("Navigated to Home page - Passed");
    }
}