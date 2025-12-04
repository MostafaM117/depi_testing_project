package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    protected String username;
    protected String password;

    @BeforeClass
    public void setupClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        // load config
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("src/test/resources/config.properties")) {
            props.load(in);
        }
        baseUrl = props.getProperty("baseUrl").trim();
        username = props.getProperty("username").trim();
        password = props.getProperty("password").trim();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
