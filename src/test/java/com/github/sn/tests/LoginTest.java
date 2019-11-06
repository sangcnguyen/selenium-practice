package com.github.sn.tests;

import com.github.sn.bases.BaseTest;
import com.github.sn.pages.HomePage;
import com.github.sn.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginSuccessfully() {
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.goToPage();
        loginPage.logIn("admin@example.com", "admin");

        Assert.assertEquals("Log out", homePage.getLogOutText());
        String[] expectedOutputAfterLogin = {"ENGLISH", "DASHBOARD", "YOUR ACCOUNT", "LOG OUT"};
        Assert.assertEquals(expectedOutputAfterLogin, homePage.getTextOnMenu().toArray());

        homePage.clickLogout();

        Assert.assertEquals("You have been successfully logged out.", homePage.getMessSuccessful());
        String[] expectedOutputAfterLogout = {"ENGLISH", "REGISTER", "LOG IN"};
        Assert.assertEquals(expectedOutputAfterLogout, homePage.getTextOnMenu().toArray());
    }
}
