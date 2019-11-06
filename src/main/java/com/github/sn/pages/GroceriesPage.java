package com.github.sn.pages;

import com.github.sn.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GroceriesPage extends BasePage {

    public GroceriesPage(WebDriver webDriver) {
        super(webDriver);
        path = "products/category/groceries-8/";
    }

    @FindBy(css = "div.product-list>a>div")
    private List<WebElement> productImages;

    public void clickRandomProduct() {
        waitForAllElements(productImages);
        productImages.get(randNumberBetween(1, productImages.size())).click();
    }
}
