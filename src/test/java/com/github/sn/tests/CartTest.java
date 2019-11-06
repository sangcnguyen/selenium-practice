package vn.kms.course.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.kms.course.selenium.bases.BaseTest;
import vn.kms.course.selenium.pages.ApparelPage;
import vn.kms.course.selenium.pages.CartPage;
import vn.kms.course.selenium.pages.CommonProductPage;
import vn.kms.course.selenium.pages.GroceriesPage;

public class CartTest extends BaseTest {

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
}
