package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected static final String URL = "https://demo.prestashop.com/#/en/front";

    @BeforeTest
    @Parameters("browser")
    public void startBrowser(@Optional("chrome")String browser) {

    	// Select browser
        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        }


        driver.manage().window().maximize();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        driver.get(URL);

        // Wait for PrestaShop iframe
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("framelive")
                )
        );

        switchToPrestaShopFrame();

        System.out.println("Browser started successfully");
    }

    public void switchToPrestaShopFrame() {

        driver.switchTo().defaultContent();

        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                        By.id("framelive")
                )
        );
    }

    @AfterTest
    public void closeBrowser() {

        if (driver != null) {

            driver.quit();

            System.out.println(
                    "Browser closed successfully."
            );
        }
    }
}
