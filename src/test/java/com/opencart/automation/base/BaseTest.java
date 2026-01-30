package com.opencart.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://demo.opencart.com");

        // wait until OpenCart home page is really loaded
        wait.until(ExpectedConditions.titleContains("Your Store"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

