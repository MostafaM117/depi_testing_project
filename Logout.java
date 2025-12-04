package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Auto {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tifam\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(5000);
        By username_TF_Path=By.cssSelector("input[name=\"username\"]");
        By pass_TF_Path=By.cssSelector("input[name=\"password\"]");
        By login_btn_path=By.cssSelector(".login>.button");
        WebElement username_TF = driver.findElement(username_TF_Path);
        WebElement pass_TF = driver.findElement(pass_TF_Path);
        WebElement login_btn = driver.findElement(login_btn_path);
        username_TF.sendKeys("mo2222");
        pass_TF.sendKeys("123");
        login_btn.click();
        Thread.sleep(5000);
        By logout_btn_path=By.linkText("Log Out");
        WebElement logout_btn = driver.findElement(logout_btn_path);
        logout_btn.click();
    }
}
