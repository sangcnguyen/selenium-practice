package vn.kms.course.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vn.kms.course.selenium.bases.BaseTest;
import vn.kms.course.selenium.pages.*;


public class CartTest extends BaseTest {
    private WebDriver webDriver;

    @BeforeEach
    public void beforeEach() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void validateAddToCart() {
        CommonProductPage commonProductPage = new CommonProductPage(webDriver);
        ApparelPage apparelPage = new ApparelPage(webDriver);
        apparelPage.goToPage();
        commonProductPage.addRandomProductNQuantity();

        GroceriesPage groceriesPage = new GroceriesPage(webDriver);
        groceriesPage.goToPage();
        commonProductPage.addRandomProductNQuantity();

        CartPage cartPage = new CartPage(webDriver);
        cartPage.goToPage();

        // Number of products
        Assertions.assertEquals(2, cartPage.getNumberOfProduct());
        // Name, Quantity & Price
        Assertions.assertTrue(commonProductPage.expectedProduct().equals(cartPage.actualProduct()));
        // Subtotal
        Assertions.assertEquals(cartPage.getSubtotal(), cartPage.calculateTotal());
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }
}
