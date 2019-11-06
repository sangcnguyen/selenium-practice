package vn.kms.course.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.kms.course.selenium.bases.BaseTest;
import vn.kms.course.selenium.pages.HomePage;
import vn.kms.course.selenium.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginSuccessfully() {
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.goToPage();
        loginPage.logIn("admin@sample.com", "admin");

        Assertions.assertTrue(homePage.getHomePage());
        String[] expectedOutputAfterLogin = {"DASHBOARD", "YOUR ACCOUNT", "LOG OUT"};
        Assertions.assertArrayEquals(expectedOutputAfterLogin, homePage.getTextOnMenu().toArray());

        homePage.clickLogout();

        String[] expectedOutputAfterLogout = {"REGISTER", "LOG IN"};
        Assertions.assertArrayEquals(expectedOutputAfterLogout, homePage.getTextOnMenu().toArray());
        Assertions.assertEquals("You have been successfully logged out.", homePage.getMessSuccessful());
    }
}
