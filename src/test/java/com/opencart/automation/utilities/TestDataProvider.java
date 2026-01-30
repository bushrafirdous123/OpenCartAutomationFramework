package com.opencart.automation.utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmails() {
        return new Object[][] {
            {"bushra"},
            {"bushra@"},
            {"bushra@gmail"},
            {"bushra@gmail.com"} // already registered
        };
    }

    @DataProvider(name = "invalidPhones")
    public Object[][] invalidPhones() {
        return new Object[][] {
            {"111"},
            {"abcde"}
        };
    }
}

