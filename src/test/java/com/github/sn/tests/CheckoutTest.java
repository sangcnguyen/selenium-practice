package com.github.sn.tests;

import com.github.sn.bases.BaseTest;
import com.github.sn.model.Product;
import com.github.sn.pages.ApparelPage;
import com.github.sn.pages.CheckoutPage;
import com.github.sn.pages.GroceriesPage;
import com.github.sn.pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void validateAddToCart() {
        ProductDetailPage productDetailPage = new ProductDetailPage(webDriver);
        ApparelPage apparelPage = new ApparelPage(webDriver);
        apparelPage.goToPage();
        apparelPage.clickRandomProduct();
        productDetailPage.addRandomProductNQuantity();
        Product apparelProduct = new Product(
                productDetailPage.getProductName(),
                productDetailPage.getProductPrice(),
                productDetailPage.getProductQuantity()
        );


        GroceriesPage groceriesPage = new GroceriesPage(webDriver);
        groceriesPage.goToPage();
        productDetailPage.addRandomProductNQuantity();
        Product groceriesProduct = new Product(
                productDetailPage.getProductName(),
                productDetailPage.getProductPrice(),
                productDetailPage.getProductQuantity()
        );

//        CheckoutPage checkoutPage = new CheckoutPage(webDriver);
//        checkoutPage.goToPage();
//
//        // Number of products
//        Assert.assertEquals(2, checkoutPage.getNumberOfProduct());
//        // Name, Quantity & Price
//        Assert.assertEquals(checkoutPage.actualProduct(), productDetailPage.expectedProduct());
//        // Subtotal
//        Assert.assertEquals(checkoutPage.getSubtotal(), checkoutPage.calculateTotal());
    }
}
