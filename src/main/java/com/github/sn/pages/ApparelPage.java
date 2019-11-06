package com.github.sn.pages;

import com.github.sn.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ApparelPage extends BasePage {

    public ApparelPage(WebDriver webDriver) {
        super(webDriver);
        path = "products/category/apparel-9/";
    }

    @FindBy(css = "div.product-list>a>div")
    private List<WebElement> productImages;

    public void clickRandomProduct() {
        waitForAllElements(productImages);
        productImages.get(randNumberBetween(0, productImages.size() - 1, 13)).click();
    }
}