package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import vn.kms.course.selenium.bases.BasePage;

public class ApparelPage extends BasePage {
    public ApparelPage(WebDriver webDriver) {
        super(webDriver);
        path = "products/category/apparel-3/";
    }
}



