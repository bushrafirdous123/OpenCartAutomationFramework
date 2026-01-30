package com.opencart.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

 // Locators
    By myAccount = By.xpath("//span[normalize-space()='My Account']");
    By registerLink = By.linkText("Register");

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By privacyPolicy = By.name("agree");
    By continueBtn = By.xpath("//input[@value='Continue']");

    By warningMsg = By.cssSelector(".alert-danger");


    // ====== Actions ======

    public void openRegisterPage() {

        // Click My Account (span inside dropdown)
        driver.findElement(myAccount).click();

        // Click Register link
        driver.findElement(registerLink).click();
    }


    public void enterMandatoryFields(String fn, String ln, String mail, String phone, String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(telephone).sendKeys(phone);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(pwd);
    }

    public void acceptPrivacyPolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicy)).click();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public String getWarningMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(warningMsg)).getText();
    }
}

