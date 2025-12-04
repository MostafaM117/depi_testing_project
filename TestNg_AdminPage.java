import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg_AdminPage {
    // Admin page test cases
    WebDriver driver;

    // *** Define locators first ***
    By headerLocator = By.tagName("h1"); // then check its text
    By initialButtonLocator = By.id("initialBalance");
    By minimumBalanceLocator = By.id("minimumBalance");
    By submitButtonLocator = By.xpath("//input[@value='Submit']");
    By Initialize_DB_ButtonLocator = By.xpath("//input[@value='Initialize Database']");
    By Clean_DB_ButtonLocator = By.xpath("//input[@value='Clean']");


    @BeforeMethod
    public void Before_Method() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\abdel\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //opens the chrom web app
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        //open the website
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");
        Thread.sleep(2000);


    }
   //Test 1: Verify Navigation Buttons
    @Test
    public void Tc1() throws InterruptedException {
        driver.get("https://parabank.parasoft.com/parabank/sitemap.htm");
        Thread.sleep(1000);
        driver.navigate().back();
        System.out.println("TC Casses Have Finished!");

    }

    // Test 2: Initial Balance field accepts input
    @Test
    public void Tc2_SetInitialBalance() throws InterruptedException {
        driver.findElement(initialButtonLocator).clear();
        driver.findElement(initialButtonLocator).sendKeys("100");


        Thread.sleep(1000);
        driver.findElement(submitButtonLocator).click();
        System.out.println("Initial Balance set successfully!");
    }

    // Test 3: Minimum Balance field accepts input
    @Test
    public void Tc3_SetMinimumBalance() throws InterruptedException {
        driver.findElement(minimumBalanceLocator).clear();
        driver.findElement(minimumBalanceLocator).sendKeys("10");

        Thread.sleep(1000);
        driver.findElement(submitButtonLocator).click();
        System.out.println("Minimum Balance set successfully!");
    }

    //  Test 4: Refresh Admin Page
    @Test
    public void Tc4_RefreshAdminPage() {
        driver.navigate().refresh();
        WebElement header = driver.findElement(headerLocator);


        Assert.assertTrue(header.getText().contains("Administration"));
        System.out.println("Admin Page refreshed successfully!");
    }
    /// //////////
    // Test 5: Minimum Balance submit while clear
    @Test
    public void Tc5_SetInitialB_only() throws InterruptedException {
        driver.findElement(minimumBalanceLocator).clear();


        driver.findElement(initialButtonLocator).clear();
        driver.findElement(initialButtonLocator).sendKeys("100");


        Thread.sleep(1000);
        driver.findElement(submitButtonLocator).click();
        System.out.println("Initial Balance set unsuccessfully!");
    }

    // Test 6: Initial Balance submit while clear
    @Test
    public void Tc6_SetMinimumB_only() throws InterruptedException {
        driver.findElement(initialButtonLocator).clear();

        driver.findElement(minimumBalanceLocator).clear();
        driver.findElement(minimumBalanceLocator).sendKeys("10");

        Thread.sleep(1000);
        driver.findElement(submitButtonLocator).click();
        Thread.sleep(3000);

        System.out.println("Minimum Balance set unsuccessfully!");
    }

    @AfterMethod
    public void After_Method(){
        //close the browser itself
        System.out.println("TC Casses Have Finished!");
           driver.quit();
    }
    @AfterSuite
    public void After_Suite() {
        System.out.println("All Tests Completed!");
    }
}
