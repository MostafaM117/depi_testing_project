package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPayPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By payeeName = By.name("payee.name");
    private By address = By.name("payee.address.street");
    private By account = By.name("payee.accountNumber");
    private By amount = By.name("amount");
    private By sendBtn = By.cssSelector("input[value='Send Payment']");
    private By confirmation = By.cssSelector("h1.title");
    private By error = By.cssSelector(".error");

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void goTo(String baseUrl) {
        driver.get(baseUrl + "/billpay.htm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendBtn));
    }

    public void setPayeeName(String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(payeeName));
        el.clear();
        el.sendKeys(value);
    }
    public void setAddress(String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(address));
        el.clear();
        el.sendKeys(value);
    }
    public void setAccount(String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(account));
        el.clear();
        el.sendKeys(value);
    }
    public void setAmount(String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(amount));
        el.clear();
        el.sendKeys(value);
    }
    public void clickSend() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(sendBtn));
        btn.click();
    }

    public String getConfirmationText() {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmation));
        return el.getText();
    }

    public String getErrorText() {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        return el.getText();
    }
}
