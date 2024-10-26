package case1.com.enuygundemo.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.enuygundemo.pages.BasePage;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    
    @Before
    public void setUp() {
        // Stup ChromeDriver
        FirefoxOptions options = new FirefoxOptions();
        // Add any needed Chrome options
        // options.addArguments("--headless"); // Uncomment for headless mode
        
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Set the driver in BasePage
        BasePage.setDriver(driver);
        
        // Navigate to the website
        driver.get("https://www.enuygun.com");
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
