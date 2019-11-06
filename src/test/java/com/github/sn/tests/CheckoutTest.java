package com.github.sn.tests;

import com.github.sn.bases.BaseTest;
import com.github.sn.model.Product;
import com.github.sn.pages.ApparelPage;
import com.github.sn.pages.CheckoutPage;
import com.github.sn.pages.GroceriesPage;
import com.github.sn.pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckoutTest extends BaseTest {

    @Test
    public void validateAddToCart() {
        List<Product> expectedProductList = new ArrayList<>();

        ProductDetailPage productDetailPage = new ProductDetailPage(webDriver);
        ApparelPage apparelPage = new ApparelPage(webDriver);
        apparelPage.goToPage();
        apparelPage.clickRandomProduct();
        productDetailPage.addRandomProductNQuantity();
        expectedProductList.add(new Product(
                productDetailPage.getProductName(),
                productDetailPage.getProductPrice(),
                productDetailPage.getProductQuantity()
        ));


        GroceriesPage groceriesPage = new GroceriesPage(webDriver);
        groceriesPage.goToPage();
        groceriesPage.clickRandomProduct();
        productDetailPage.addRandomProductNQuantity();
        expectedProductList.add(new Product(
                productDetailPage.getProductName(),
                productDetailPage.getProductPrice(),
                productDetailPage.getProductQuantity()
        ));

        CheckoutPage checkoutPage = new CheckoutPage(webDriver);
        checkoutPage.goToPage();

        // Verify number of products
        Assert.assertEquals(checkoutPage.getNumberOfProduct(),expectedProductList.size());
        // Verify name, quantity and price on each product
        Assert.assertEquals(checkoutPage.getProductList(), expectedProductList);
//        // Subtotal
//        Assert.assertEquals(checkoutPage.getSubtotal(), checkoutPage.calculateTotal());
    }
}
