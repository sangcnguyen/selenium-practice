package vn.kms.course.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vn.kms.course.selenium.bases.BaseTest;
import vn.kms.course.selenium.pages.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;


public class Tc2 extends BaseTest {
    private WebDriver webDriver;

    @BeforeEach
    public void beforeEach() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void Validate_add_to_cart_feature() throws InterruptedException {
        ApparelPage apparelPage = new ApparelPage(webDriver);
        apparelPage.goToPage();
        apparelPage.clickRandomProduct();
        apparelPage.enterRandomQuantityNumber();
        apparelPage.clickAddToCard();
        String apparelName = apparelPage.getProductName();
        double apparelPrice = apparelPage.getProductPrice();
        int apparelQuantity = Integer.parseInt(apparelPage.getProductQuantity());
        Thread.sleep(2000);

        GroceriesPage groceriesPage = new GroceriesPage(webDriver);
        groceriesPage.goToPage();
        groceriesPage.clickRandomProduct();
        groceriesPage.enterRandomQuantityNumber();
        groceriesPage.clickAddToCard();
        String groceriesName = groceriesPage.getProductName();
        double groceriesPrice = groceriesPage.getProductPrice();
        int groceriesQuantity = Integer.parseInt(groceriesPage.getProductQuantity());
        String variant = groceriesPage.getVariant();
        Thread.sleep(2000);

        NumberFormat nf = new DecimalFormat("#,###.00");

        CartPage cartPage = new CartPage(webDriver);
        cartPage.goToPage();

        // Number of products
        Assertions.assertEquals(cartPage.numOfProduct(), 2);
        // Name
        String arr1[]= new String[2];
        arr1[0]= apparelName + "\n"+"Size: XS";
        arr1[1] = groceriesName+"\n"+variant.trim();
        Assertions.assertArrayEquals(cartPage.nameOfProducts().toArray(),arr1);
        // Quantity
        int arr2[] = new int[2];
        arr2[0] = apparelQuantity;
        arr2[1] = groceriesQuantity;
        Assertions.assertArrayEquals(cartPage.getProductQuantity(), arr2);
        // Price
        Assertions.assertEquals(nf.format(cartPage.getPricePro1()), nf.format((double) apparelQuantity*apparelPrice));
        Assertions.assertEquals(nf.format(cartPage.getPricePro2()),nf.format((double)groceriesQuantity*groceriesPrice));
        // Subtotal
        String result = "";
        try {
            double value = cartPage.getPricePro1() + cartPage.getPricePro2();
            result = "" + nf.format(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(cartPage.getSubtotal(), result);
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }
}
