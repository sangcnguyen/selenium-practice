package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import vn.kms.course.selenium.bases.BasePage;


public class GroceriesPage extends BasePage {
    public GroceriesPage(WebDriver webDriver) {
        super(webDriver);
        path = "products/category/groceries-2/";
    }
}
