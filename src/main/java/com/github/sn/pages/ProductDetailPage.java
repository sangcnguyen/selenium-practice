package com.github.sn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.sn.bases.BasePage;
import com.github.sn.model.Product;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class CommonProductPage extends BasePage {
    //private Random rand;
    Product product = new Product();

    public CommonProductPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(className = "product__info__name")
    private WebElement productName;

    @FindBy(id = "id_quantity")
    private WebElement productQuantity;

    @FindBy(xpath = "//*[contains(concat(' ',@class,' '),' product__info__price ')]/child::span")
    private WebElement productPrice;

    @FindBy(css = "div.product__info__button")
    private WebElement addButton;

    @FindBy(id = "cart-dropdown-list")
    private WebElement showBox;


    public void enterRandomQuantityNumber() {
        //rand = new Random();
        // int randomNum = rand.nextInt((50 - 1) + 1) + 1;
        productQuantity.clear();
        //productQuantity.sendKeys(String.valueOf(randomNum));
        productQuantity.sendKeys(String.valueOf(randIn(0, 50)));
    }

    public void clickAddToCard() {
        addButton.click();
    }

    public void addRandomProductNQuantity() {
        // clickRandomProduct();
        enterRandomQuantityNumber();
        clickAddToCard();
        waitForBoxShow();
        product.putProduct(getProductName(), convertArrayListToString(getProductName(), getProductQuantity(), getTotalPrice()));
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

    public void waitForBoxShow() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(showBox));
    }

    public String convertArrayListToString(String name, String quantity, String price) {
        List<String> strList = new ArrayList<>();
        strList.add(name);
        strList.add(quantity);
        strList.add(price);
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
            sb.append("\t");
        }
        return sb.toString();
    }

    public Map<String, String> expectedProduct() {
        return product.getProduct();
    }
}
