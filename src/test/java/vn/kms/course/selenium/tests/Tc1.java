package vn.kms.course.selenium.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vn.kms.course.selenium.bases.BasePage;
import vn.kms.course.selenium.bases.BaseTest;
import vn.kms.course.selenium.pages.HomePage;
import vn.kms.course.selenium.pages.LoginPage;

public class Tc1 extends BaseTest {
    private WebDriver webDriver;

    @BeforeEach
    public void beforeEach() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void Login_successfully() {
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.goToPage();
        loginPage.logIn("admin@sample.com","Kms@2017");
        Assertions.assertTrue(homePage.isHomePage());
        Assertions.assertEquals(homePage.isDashboard(),"DASHBOARD");
        Assertions.assertEquals(homePage.isYourAccount(),"YOUR ACCOUNT");
        Assertions.assertEquals(homePage.isLogout(),"LOG OUT");
        homePage.clickLogout();
        Assertions.assertEquals(homePage.isRegister(),"REGISTER");
        Assertions.assertEquals(homePage.isLogin(),"LOG IN");
        Assertions.assertEquals(homePage.isMessSuccessful(),"You have been successfully logged out.");
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }
}
