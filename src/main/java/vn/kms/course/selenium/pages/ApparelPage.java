package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vn.kms.course.selenium.bases.BasePage;

import java.util.List;
import java.util.Random;

public class ApparelPage extends BasePage {
    private Random rand = new Random();
    private int randomValue;

    public ApparelPage(WebDriver webDriver) {
        super(webDriver);
        path = "products/category/apparel-1/";
    }

    @FindBy(xpath = "//*[@class='link--clean']")
    private List<WebElement> img_products;

    @FindBy(id = "id_quantity")
    private WebElement input_quantity;

    @FindBy(xpath = "//*[@class='form-group product__info__button']")
    private WebElement btn_add;

    @FindBy(xpath = "//*[@Class='badge ']")
    private WebElement count_items;

    @FindBy(xpath = "//*[@class='product__info__name']")
    private WebElement product_name;

    @FindBy(xpath = "//*[@class='product__info__price']/child::span")
    private WebElement product_price;

//    @FindBy(xpath = "//div[@class='col-md-2']")
//    private WebElement total_price;

    public void clickRandomProduct() {
        WebDriverWait wait = new WebDriverWait(webDriver, 50);
        wait.until(ExpectedConditions.visibilityOfAllElements(img_products));
        randomValue = rand.nextInt(img_products.size());
        img_products.get(randomValue).click();
    }

    public void enterRandomQuantityNumber() {
        rand = new Random();
        int randomNum = rand.nextInt((50 - 1) + 1) + 1;
        input_quantity.clear();
        input_quantity.sendKeys(String.valueOf(randomNum));
    }

    public void clickAddToCard() {
        btn_add.click();
    }

    public String getProductName() {
        return product_name.getText();
    }

    public double getProductPrice() {
        return Double.parseDouble(removeChar(product_price.getText(),0).trim());
    }

    public String getProductQuantity(){
        return input_quantity.getAttribute("value");
    }

    public String removeChar(String s, int p){
        return  s.substring(0,p)+s.substring(p+1);
    }
}



