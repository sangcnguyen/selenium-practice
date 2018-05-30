package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vn.kms.course.selenium.bases.BasePage;

import java.util.List;
import java.util.Random;

public class ApparelPage extends BasePage {
    public ApparelPage(WebDriver webDriver) {
        super(webDriver);
        path = "products/category/apparel-3/";
    }
}



