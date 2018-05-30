package vn.kms.course.selenium.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vn.kms.course.selenium.bases.BaseTest;
import vn.kms.course.selenium.pages.HomePage;
import vn.kms.course.selenium.pages.LoginPage;

public class LoginTest extends BaseTest {
    private WebDriver webDriver;

    @BeforeEach
    public void beforeEach() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void loginSuccessfully() {
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.goToPage();
        loginPage.logIn("admin@sample.com", "Kms@2017");

        Assertions.assertTrue(homePage.getHomePage());
        String[] expectedOutputAfterLogin = {"DASHBOARD", "YOUR ACCOUNT", "LOG OUT"};
        System.out.print(homePage.getTextOnMenu());
        Assertions.assertArrayEquals(expectedOutputAfterLogin, homePage.getTextOnMenu().toArray());

        homePage.clickLogout();

        String[] expectedOutputAfterLogout = {"REGISTER", "LOG IN"};
        Assertions.assertArrayEquals(expectedOutputAfterLogout, homePage.getTextOnMenu().toArray());
        Assertions.assertEquals("You have been successfully logged out.", homePage.getMessSuccessful());
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }
}
