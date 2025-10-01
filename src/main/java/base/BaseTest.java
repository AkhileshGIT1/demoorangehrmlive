package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
    	
    	// 1. Set up ChromeDriver using WebDriverManager for automatic driver management
        WebDriverManager.chromedriver().setup();

        // 2. Create ChromeOptions object
        ChromeOptions options = new ChromeOptions();

        // 3. Add the incognito argument
        options.addArguments("--incognito");

        // 4. Initialize the ChromeDriver with the custom options
        driver = new ChromeDriver(options);
    	
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
