package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPg;

public class CheckoutPgTest extends BaseTest {

	// Create Page Object
	CheckoutPg checkoutpg = new CheckoutPg(driver, wait);
	
	
	// ---------------------------------------------------------
    // CO_TC101
    // Verify Proceed to Checkout button works
    // ---------------------------------------------------------

    @Test(priority = 1)
    public void verifyProceedToCheckout() {

    	checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isAddressesDisplayed(),
                "Checkout page was not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC102
    // Verify checkout before user registration
    // ---------------------------------------------------------

    @Test(priority = 2)
    public void verifyGuestCheckoutNavigation() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isPersonalInformationDisplayed(),
                "Personal Information page was not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC103
    // Verify Personal Information page
    // ---------------------------------------------------------

    @Test(priority = 3)
    public void verifyPersonalInformationPage() {

        checkoutpg.openCheckout();

        checkoutpg.enterPersonalInformation(
                "Aiswarya",
                "Test",
                "aiswarya12345@gmail.com");

        Assert.assertEquals(
                checkoutpg.getFirstNameValue(),
                "Aiswarya");

        Assert.assertEquals(
                checkoutpg.getLastNameValue(),
                "Test");

        Assert.assertTrue(
                checkoutpg.getEmailValue().contains("@"));
    }


    // ---------------------------------------------------------
    // CO_TC104
    // Verify blank mandatory personal information fields
    // ---------------------------------------------------------

    @Test(priority = 4)
    public void verifyBlankPersonalInformationValidation() {

        checkoutpg.openCheckout();

        checkoutpg.clickContinue();

        Assert.assertTrue(
                checkoutpg.isPersonalInformationInPageSource(),
                "Validation page was not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC109
    // Verify checkout after user registration
    // ---------------------------------------------------------

    @Test(priority = 5)
    public void verifyRegisteredUserCheckout() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isAddressesDisplayed(),
                "Addresses page was not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC111
    // Verify product details in Addresses page
    // ---------------------------------------------------------

    @Test(priority = 6)
    public void verifyProductDetailsInAddressPage() {

        checkoutpg.openCheckout();

        checkoutpg.clickShowDetails();

        Assert.assertTrue(
                checkoutpg.isAddressesDisplayed(),
                "Addresses page was not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC112
    // Verify checkout steps
    // ---------------------------------------------------------

    @Test(priority = 7)
    public void verifyCheckoutSteps() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isAddressesDisplayed(),
                "Addresses step is not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC113
    // Verify mandatory fields
    // ---------------------------------------------------------

    @Test(priority = 8)
    public void verifyMandatoryFields() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isFirstNameLabelMandatory(),
                "First name is not marked mandatory");

        Assert.assertTrue(
                checkoutpg.isLastNameLabelMandatory(),
                "Last name is not marked mandatory");
    }


    // ---------------------------------------------------------
    // CO_TC118
    // Verify Zip / Postal Code
    // ---------------------------------------------------------

    @Test(priority = 9)
    public void verifyPostalCodeField() {

        checkoutpg.openCheckout();

        checkoutpg.enterPostalCode("1234");

        Assert.assertEquals(
                checkoutpg.getPostalCodeValue(),
                "1234",
                "Postal code was not entered correctly");
    }


    // ---------------------------------------------------------
    // CO_TC119
    // Verify Country dropdown
    // ---------------------------------------------------------

    @Test(priority = 10)
    public void verifyCountryDropdown() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isCountryDisplayed(),
                "Country dropdown is not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC121
    // Verify product details in shipping page
    // ---------------------------------------------------------

    @Test(priority = 11)
    public void verifyProductDetailsInCheckout() {

        checkoutpg.openCheckout();

        checkoutpg.clickShowDetails();

        Assert.assertTrue(
                checkoutpg.isShippingDisplayed(),
                "Shipping section is not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC123
    // Verify shipping cost
    // ---------------------------------------------------------

    @Test(priority = 12)
    public void verifyShippingCost() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isShippingDisplayed(),
                "Shipping cost is not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC127
    // Verify payment methods
    // ---------------------------------------------------------

    @Test(priority = 13)
    public void verifyPaymentMethods() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isBankWireDisplayed(),
                "Bank Wire payment method is not displayed");

        Assert.assertTrue(
                checkoutpg.isCashOnDeliveryDisplayed(),
                "Cash on Delivery payment method is not displayed");

        Assert.assertTrue(
                checkoutpg.isCheckDisplayed(),
                "Check payment method is not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC131
    // Verify only one payment method can be selected
    // ---------------------------------------------------------

    @Test(priority = 14)
    public void verifyOnlyOnePaymentMethodSelected() {

        checkoutpg.openCheckout();

        checkoutpg.clickBankWire();

        checkoutpg.clickCashOnDelivery();

        int selectedCount =
                checkoutpg.getSelectedPaymentMethodCount();

        Assert.assertEquals(
                selectedCount,
                1,
                "More than one payment method is selected");
    }


    // ---------------------------------------------------------
    // CO_TC132
    // Verify Terms of Service
    // ---------------------------------------------------------

    @Test(priority = 15)
    public void verifyTermsAndConditions() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isTermsDisplayed(),
                "Terms and conditions checkbox is not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC133
    // Verify order total
    // ---------------------------------------------------------

    @Test(priority = 16)
    public void verifyOrderTotal() {

        checkoutpg.openCheckout();

        Assert.assertTrue(
                checkoutpg.isOrderTotalDisplayed(),
                "Order total is not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC134
    // Verify Back to Shipping button
    // ---------------------------------------------------------

    @Test(priority = 17)
    public void verifyBackToShipping() {

        checkoutpg.openCheckout();

        checkoutpg.clickBackToShipping();

        Assert.assertTrue(
                checkoutpg.isShippingDisplayed(),
                "Shipping page was not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC135
    // Verify Terms of Service is clickable
    // ---------------------------------------------------------

    @Test(priority = 18)
    public void verifyTermsLink() {

        checkoutpg.openCheckout();

        checkoutpg.clickTermsLink();

        Assert.assertTrue(
                checkoutpg.isTermsInPageSource(),
                "Terms and Conditions window was not displayed");
    }


    // ---------------------------------------------------------
    // CO_TC137
    // Verify Order Confirmation page
    // ---------------------------------------------------------

    @Test(priority = 19)
    public void verifyOrderConfirmationPage() {

        checkoutpg.openCheckout();

        // Select Bank Wire
        checkoutpg.clickBankWire();

        // Select Terms
        checkoutpg.selectTerms();

        // Place order
        checkoutpg.clickPlaceOrder();

        // Verify confirmation
        Assert.assertTrue(
                checkoutpg.isOrderConfirmationDisplayed(),
                "Order confirmation message was not displayed");
    }
}