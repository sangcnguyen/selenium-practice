package com.github.sn.pages;

import com.github.sn.bases.BasePage;
import com.github.sn.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
        path = "checkout/";
    }

    @FindBy(css = "div.checkout-preview__line")
    private List<WebElement> productList;

    @FindBy(css = "div.checkout-preview__line__product p")
    private List<WebElement> productNameList;

    @FindBy(id = "id_quantity")
    private List<WebElement> productQuantityList;

    @FindBy(xpath = "/*[contains(concat(' ',@class,' '),' checkout-preview-item-price ')]//span")
    private List<WebElement> productPriceList;

    @FindBy(css = "h3.cart-subtotal")
    private WebElement subTotalText;

    public int getNumberOfProduct() {
        return productList.size();
    }

    public String getProductNameByIndex(int index) {
        String productName = "";
        for (int i = 0; i < productNameList.size(); i++) {
            productName = getTextNode(productNameList.get(index));
        }
        return productName;
    }

    public String getProductQuantityByIndex(int index) {
        String productQuantity = "";
        for (int i = 0; i < productQuantityList.size(); i++) {
            productQuantity = productQuantityList.get(index).getAttribute("value");
        }
        return productQuantity;
    }

    public String getProductPriceByIndex(int index) {
        String productPrice = "";
        for (int i = 0; i < productPriceList.size(); i++) {
            productPrice = removeChar(productPriceList.get(index).getText().replace(",", "").trim(), 0);
        }
        return productPrice;
    }

    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i <= productList.size(); i++) {
            productList.add(new Product(
                    getProductNameByIndex(i),
                    getProductPriceByIndex(i),
                    getProductQuantityByIndex(i))
            );
        }
        return productList;
    }

//    public Double[] getProductPriceDoubleByIndex() {
//        Double[] priceList = new Double[productPriceList.size()];
//        for (int i = 0; i < productPriceList.size(); i++) {
//            try {
//                priceList[i] = Double.parseDouble(removeChar(productPriceList.get(i).getText().replace(",", "").trim(), 0));
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//        }
//        return priceList;
//    }

    public String getSubtotal() {
        return subTotalText.getText().replace("$", "").trim();
    }

    public String removeChar(String s, int p) {
        return s.substring(0, p) + s.substring(p + 1);
    }

//    public String calculateTotal() {
//        NumberFormat nf = new DecimalFormat("#,###.00");
//        double sum = 0;
//        for (double priceList : getProductPriceDouble()) {
//            try {
//                sum += priceList;
//            } catch (NumberFormatException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return "" + nf.format(sum);
//    }

    private String getTextNode(WebElement element) {
        return element.getText().split("\n")[0].trim();
    }

//    private boolean isBoxPresent(WebElement webElement){
//        if(waitForElementClickable(webElement))
//    }
}
