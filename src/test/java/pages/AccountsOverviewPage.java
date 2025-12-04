package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountsOverviewPage {
    private WebDriver driver;

    // Accounts table links are usually in a element like //a[contains(@href,'overview.htm?id=')];
    private By accountLinks = By.cssSelector("#accountTable a, table.accountsTable a, .accountTable a");

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstAccountId() {
        List<WebElement> links = driver.findElements(accountLinks);
        if (links.isEmpty()) {
            throw new RuntimeException("No account links found on Accounts Overview page.");
        }
        String href = links.get(0).getAttribute("href");
        // href, e.g., ...overview.htm?id=12345 -> extract id
        String id = href.replaceAll(".*id=(\\d+).*", "$1");
        return id;
    }
}
