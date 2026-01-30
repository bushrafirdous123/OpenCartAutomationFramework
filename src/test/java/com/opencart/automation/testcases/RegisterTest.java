package com.opencart.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.automation.base.BaseTest;
import com.opencart.automation.pages.RegisterPage;
import com.opencart.automation.utilities.TestDataProvider;

public class RegisterTest extends BaseTest {

    @Test(dataProvider = "invalidEmails", dataProviderClass = TestDataProvider.class)
    public void invalidEmailValidation(String email) {

        RegisterPage rp = new RegisterPage(driver);
        rp.openRegisterPage();
        rp.enterMandatoryFields(
            "Bushra", "Firdous", email, "9876543210", "Test@123"
        );
        rp.acceptPrivacyPolicy();
        rp.clickContinue();

        Assert.assertTrue(driver.getPageSource().contains("E-Mail"),
                "Expected email validation message not displayed");
    }

    @Test(dataProvider = "invalidPhones", dataProviderClass = TestDataProvider.class)
    public void invalidPhoneValidation(String phone) {

        RegisterPage rp = new RegisterPage(driver);
        rp.openRegisterPage();
        rp.enterMandatoryFields(
            "Bushra", "Firdous",
            "test" + System.currentTimeMillis() + "@gmail.com",
            phone, "Test@123"
        );
        rp.acceptPrivacyPolicy();
        rp.clickContinue();

        Assert.assertTrue(driver.getPageSource().contains("Telephone"),
                "Expected phone validation message not displayed");
    }
}

