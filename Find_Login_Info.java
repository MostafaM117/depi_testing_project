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
        driver.get("https://parabank.parasoft.com/parabank/lookup.htm");
        Thread.sleep(5000);
        By firstName_TF_Path=By.id("firstName");
        By lastName_TF_Path=By.id("lastName");
        By address_TF_Path=By.id("address.street");
        By city_TF_Path=By.id("address.city");
        By state_TF_Path=By.id("address.state");
        By zipCode_TF_Path=By.id("address.zipCode");
        By ssn_TF_Path=By.id("ssn");
        By findloginInfo_btn_path=By.cssSelector("input[value=\"Find My Login Info\"]");
        WebElement firstName_TF = driver.findElement(firstName_TF_Path);
        WebElement lastName_TF = driver.findElement(lastName_TF_Path);
        WebElement address_TF = driver.findElement(address_TF_Path);
        WebElement city_TF = driver.findElement(city_TF_Path);
        WebElement state_TF = driver.findElement(state_TF_Path);
        WebElement zipCode_TF = driver.findElement(zipCode_TF_Path);
        WebElement ssn_TF = driver.findElement(ssn_TF_Path);
        WebElement findloginInfo_btn = driver.findElement(findloginInfo_btn_path);
        firstName_TF.sendKeys("mo2222");
        lastName_TF.sendKeys("12345");
        address_TF.sendKeys("hi");
        city_TF.sendKeys("hi");
        state_TF.sendKeys("hi");
        zipCode_TF.sendKeys("hi");
        ssn_TF.sendKeys("20000");
        findloginInfo_btn.click();
    }
}
