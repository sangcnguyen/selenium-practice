package com.github.sn.pages;

import com.github.sn.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(className = "product__info__name")
    private WebElement productName;

    @FindBy(id = "id_quantity")
    private WebElement productQuantity;

    @FindBy(xpath = "//*[contains(concat(' ',@class,' '),' product__info__price ')]/child::span")
    private WebElement productPrice;

    @FindBy(css = "div.product__info__button")
    private WebElement addToCartButton;

    @FindBy(id = "checkout-preview-dropdown-list")
    private WebElement showBox;


    public void enterRandomQuantityNumber() {
        productQuantity.clear();
        productQuantity.sendKeys(String.valueOf(randNumberBetween(0, 50)));
    }

    public void clickAddToCard() {
        addToCartButton.click();
    }

    public void i

    public void addRandomProductNQuantity() {
        enterRandomQuantityNumber();
        clickAddToCard();
        waitForElementClickable(showBox);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductQuantity() {
        return productQuantity.getAttribute("value");
    }

    public String getTotalPrice() {
        NumberFormat nf = new DecimalFormat("$#,###.00");
        return nf.format(Double.parseDouble(getProductPrice().replace("$", "").trim()) * Double.parseDouble(getProductQuantity()));
    }
}
