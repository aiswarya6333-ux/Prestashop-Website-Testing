package tests;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import base.BaseTest;
import pages.RegistrationPg;

public class RegistrationTest extends BaseTest {
	
	// =========================
    // REGISTRATION DATA
    // =========================

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {

        return new Object[][] {
        	
        	// Test Case, Gender, First Name, Last Name, Email, Password,
            // Birthday, Terms, Privacy, Expected Success, Validation Type

            {"Blank Last Name",
            	"Mrs.", "Aiswarya", "", "ac@gmail.com", "aw3se4dr5",
                "09/22/2002", true, true, false},

            {"Invalid Email",
                "Mr.", "Ashwin", "Test", "asdf@g", "aw3se4dr5",
                "", true, true, false},

            {"Invalid First Name",
                "Mrs.", "12345", "Test", "aw@gmail.com", "aw3se4dr5",
                "", true, true, false},

            {"Invalid Last Name",
                "Mrs.","Aiswarya", "12345", "awse@gmail.com", "aw3se4dr5",
                "", true, true, false},

            {"Weak Password",
                "Mrs.","Aiswarya", "Test", "dr@gmail.com", "123",
                "", true, true, false},

            {"Terms Not Selected",
                "Mrs.","Aiswarya", "Test", "ft@gmail.com", "aw3se4dr5",
                "", false, true, false},

            {"Privacy Not Selected",
                "Mrs.","Aiswarya", "Test", "gy@gmail.com", "aw3se4dr5",
                "09/22/2002", true, false, false},

            {"All Mandatory Fields Blank",
                "", "", "", "", "", "",
                false, false, false}
        };
    }

    // =========================
    // REGISTRATION TEST
    // =========================

    @Test(
            priority = 1,
            dataProvider = "registrationData"
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
            boolean expectedSuccess) {


        System.out.println("Running: " + testCase);


        // Create Page Object
        RegistrationPg registrationPage =
                new RegistrationPg(driver, wait);


        // =========================
        // OPEN REGISTRATION PAGE
        // =========================

        registrationPage.clickSignIn();

        registrationPage.clickCreateAccount();


        // =========================
        // ENTER DATA
        // =========================

        registrationPage.selectGender(gender);

        registrationPage.enterFirstName(firstName);

        registrationPage.enterLastName(lastName);

        registrationPage.enterEmail(email);

        registrationPage.enterPassword(password);

        registrationPage.enterBirthday(birthday);


        // =========================
        // CHECKBOXES
        // =========================

        registrationPage.selectTerms(
                termsCheckboxRequired
        );

        registrationPage.selectPrivacy(
                privacyCheckboxRequired
        );


        // =========================
        // CREATE ACCOUNT
        // =========================

        registrationPage.clickCreateAccountButton();


        // =========================
        // VERIFY RESULT
        // =========================

        if (expectedSuccess) {

        	Assert.assertTrue(
                    registrationPage.isRegistrationSuccessful(),
                    "Registration was not successful."
            );

            System.out.println(
                    "REGISTRATION PASSED: " + testCase
            );

        } else {

        	Assert.assertTrue(
                    registrationPage.isRegistrationPageDisplayed(),
                    "Invalid data was accepted: " + testCase
            );

            System.out.println(
                    "VALIDATION PASSED: " + testCase
            );
        }
    }
}