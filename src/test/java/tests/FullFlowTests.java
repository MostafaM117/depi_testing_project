package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AccountsOverviewPage;
import pages.BillPayPage;
import pages.FindTransactionsPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.WebElement;

public class FullFlowTests extends BaseTest {

    @Test(description="Full flow: login, billpay, find by account, find by date")
    public void fullFlow() {
        // 1) Login
        LoginPage login = new LoginPage(driver);
        login.goTo(baseUrl);
        login.login(username, password);

        // 2) Get first account id
        AccountsOverviewPage accounts = new AccountsOverviewPage(driver);
        String accountId = accounts.getFirstAccountId();

        // 3) Make a bill payment to create a transaction
        BillPayPage bill = new BillPayPage(driver);
        bill.goTo(baseUrl);
        bill.setPayeeName("Auto Test Payee");
        bill.setAddress("100 Test St");
        bill.setAccount(accountId);
        bill.setAmount("10");
        bill.clickSend();
        String conf = bill.getConfirmationText().toLowerCase();
        Assert.assertTrue(conf.contains("payment complete") || conf.contains("bill payment complete") ||
                          conf.contains("success") || conf.contains("confirmation"),
                          "Bill payment confirmation not found: " + conf);

        // 4) Find transactions by account
        FindTransactionsPage find = new FindTransactionsPage(driver);
        find.goTo(baseUrl);
        find.setAccountId(accountId);
        find.clickFind();
        List<WebElement> rows = find.getResults();
        Assert.assertFalse(rows.isEmpty(), "Expected transactions for account: " + accountId);

        // 5) Find transactions by date range (last 7 days)
        LocalDate to = LocalDate.now();
        LocalDate from = to.minusDays(7);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        find.setDateRange(from.format(fmt), to.format(fmt));
        find.clickFind();
        List<WebElement> rows2 = find.getResults();
        Assert.assertFalse(rows2.isEmpty(), "Expected transactions in the last 7 days for account: " + accountId);
    }
}
