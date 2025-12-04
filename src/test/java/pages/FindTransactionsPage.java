package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindTransactionsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By accountIdInput = By.name("accountId");
    private By findBtn = By.cssSelector("input[value='Find Transactions']");
    private By fromDate = By.name("criteria.fromDate");
    private By toDate = By.name("criteria.toDate");
    private By resultsRows = By.cssSelector("#transactionTable tbody tr, #resultTable tbody tr, .transactions-table tbody tr");

    public FindTransactionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void goTo(String baseUrl) {
        driver.get(baseUrl + "/findtrans.htm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBtn));
    }

    public void setAccountId(String id) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(accountIdInput));
        el.clear();
        el.sendKeys(id);
    }

    public void setDateRange(String from, String to) {
        WebElement f = wait.until(ExpectedConditions.elementToBeClickable(fromDate));
        f.clear();
        f.sendKeys(from);
        WebElement t = wait.until(ExpectedConditions.elementToBeClickable(toDate));
        t.clear();
        t.sendKeys(to);
    }

    public void clickFind() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(findBtn));
        btn.click();
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(resultsRows),
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".noResults, .message"))
        ));
    }

    public List<WebElement> getResults() {
        return driver.findElements(resultsRows);
    }
}
