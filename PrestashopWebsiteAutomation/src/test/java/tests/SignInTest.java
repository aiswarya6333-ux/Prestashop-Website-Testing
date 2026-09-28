package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import base.BaseTest;
import pages.SignInPg;

public class SignInTest extends BaseTest {

	@DataProvider(name = "userRegistrationData")
	public Object[][] userRegistrationData() {

	    return new Object[][] {
	    	
	    	// Test Case, Gender, First Name, Last Name, Email, Password,
            // Birthday, Terms, Privacy, Expected Success, Validation Type

	        {"Valid Registration",
	         "Mrs.", "Aiswarya", "Test", "asdf@gmail.com",
	         "aw3se4dr5", "09/22/2002", true, true, true},

	        {"Register with an already registered email",
	         "Mrs.", "Aiswarya", "Test", "asdf@gmail.com",
	         "aw3se4dr5", "09/22/2002", true, true, false}
	    };
	}

    @DataProvider(name = "LoginData")
    public Object[][] LoginData() {
    	return new Object[][] {

            // Test Case, Email, Password, Expected Success
    		
          {"Login with registered email", "asdf@gmail.com", "aw3se4dr5", true},

          {"Login with invalid email", "df@gmail.com", "aw3se4dr5", false},
          
          {"Login with invalid password", "asdf@gmail.com", "aw3serrrr", false},
          
          {"Login with blank credentials", "", "", false},
          
          {"Login with valid email and blank password", "asdf@gmail.com", "", false}
	
    	};
    }
    
    // Create Page Object
    SignInPg signInPage = new SignInPg(driver, wait);
    
    // =====================================================
    // REGISTRATION TEST
    // =====================================================
    
    @Test(
            priority = 1,
            dataProvider = "userRegistrationData"
        )
        public void userRegistration(
            String testCase,
            String gender,
            String firstName,
            String lastName,
            String email,
            String password,
            String birthday,
            boolean termsCheckboxRequired,
            boolean privacyCheckboxRequired,
            boolean expectedSuccess) throws InterruptedException {

            System.out.println("Running: " + testCase);
            
         // Make sure we are inside PrestaShop iframe
            switchToPrestaShopFrame();
           
            
         // =========================
         // OPEN REGISTRATION PAGE
         // =========================
            Thread.sleep(3000);
            signInPage.clickSignInLink();
            signInPage.clickCreateAccount();

            signInPage.selectGender(gender);
            signInPage.enterFirstName(firstName);
            signInPage.enterLastName(lastName);
            signInPage.enterEmail(email);
            signInPage.enterPassword(password);
            signInPage.enterBirthday(birthday);

            signInPage.selectTerms(termsCheckboxRequired);
            signInPage.selectPrivacy(privacyCheckboxRequired);

            signInPage.clickCreateAccountButton();
            
            // =========================
            // VERIFY RESULT
            // =========================

            		if (expectedSuccess) {

            		    // Successful registration
            		    Assert.assertTrue(
            		    		signInPage.isRegistrationSuccessful(),
            		            "Registration was not successful."
            		    );

            		    System.out.println(
            		            "Valid Registration passed"
            		    );

            		    // Sign out
            		    signInPage.clickSignOut1();

            		} else {

            		    // Duplicate email
            		    Assert.assertTrue(
            		    		signInPage.isDuplicateEmailErrorDisplayed(),
            		            "Duplicate email error message was not displayed."
            		    );

            		    Assert.assertTrue(
            		    		signInPage.isDuplicateEmailErrorCorrect(),
            		            "Incorrect duplicate email error message."
            		    );

            		    System.out.println(
            		            "Already registered email test validation passed"
            		    );
            		}
            
            
            }

    // =====================================================
    // LOGIN TEST
    // =====================================================

    @Test(
        priority = 2,
        dataProvider = "LoginData"
    )
    public void userLogin(
        String testCase,
        String email,
        String password,
        boolean expectedSuccess) {

        System.out.println("Running: " + testCase);

        signInPage.clickSignInLink();

        signInPage.enterEmail(email);

        signInPage.enterPassword(password);

        signInPage.clickSignInButton();


        if (expectedSuccess) {
            
        	// Login successful → user should reach Home page
            // and Sign out should be available
        	Assert.assertTrue(
                signInPage.isSignOutDisplayed(),
                "Sign out option is not available after successful login."
            );

            System.out.println(
                "LOGIN PASSED: " + testCase
            );

            signInPage.clickSignOut2();

        } else {
            
        	// Login failed → user should remain on Sign in page
        	Assert.assertTrue(
                signInPage.isSignInPageDisplayed(),
                "Invalid login was accepted: " + testCase
            );

            System.out.println(
                "LOGIN VALIDATION PASSED: " + testCase
            );
        }      
    }  
    
    @Test(priority = 3)
    public void navigateToHomePageTest() {

        signInPage.clickMystorelogo();

        System.out.println("Navigated to Home page - Passed");
    }
}