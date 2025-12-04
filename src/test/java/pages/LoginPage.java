package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("input[value='Log In']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void goTo(String baseUrl) {
        driver.get(baseUrl + "/index.htm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    public void login(String user, String pass) {
        WebElement u = wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        u.clear();
        u.sendKeys(user);
        WebElement p = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        p.clear();
        p.sendKeys(pass);
        driver.findElement(loginButton).click();
        // Wait for accounts overview link or logout to appear
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")),
            ExpectedConditions.visibilityOfElementLocated(By.linkText("Accounts Overview"))
        ));
    }
}
