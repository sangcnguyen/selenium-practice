package vn.kms.course.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import vn.kms.course.selenium.bases.BasePage;

import java.util.List;
import java.util.Random;

public class GroceriesPage extends BasePage {
    private Random rand = new Random();
    private int randomValue;

    public GroceriesPage(WebDriver webDriver) {
        super(webDriver);
        path = "products/category/accessories-4/";
    }

    @FindBy(xpath = "//*[@class='col-6 col-md-4 product-list']")
    private List<WebElement> img_products;

    @FindBy(id = "id_quantity")
    private WebElement input_quantity;

    @FindBy(xpath = "//*[@class='form-group product__info__button']")
    private WebElement btn_add;

    @FindBy(xpath = "//*[@class='product__info__name']")
    private WebElement product_name;

    @FindBy(xpath = "//*[@class='product__info__price']/child::span")
    private WebElement product_price;

    @FindBy(id = "id_variant")
    private WebElement txt_Variant;

    public void clickRandomProduct() {
        WebDriverWait wait = new WebDriverWait(webDriver, 50);
        wait.until(ExpectedConditions.visibilityOfAllElements(img_products));
        randomValue = rand.nextInt(img_products.size());
        img_products.get(randomValue).click();
    }

    public void enterRandomQuantityNumber() {
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

    public String getProductPrice_String() {
        return product_price.getText().trim();
    }

    public String getProductQuantity(){
        return input_quantity.getAttribute("value");
    }

    public String removeChar(String s, int p){
        return  s.substring(0,p)+s.substring(p+1);
    }

    public String getVariant(){
        Select select = new Select(txt_Variant);
        WebElement option = select.getFirstSelectedOption();
        return (option.getText().replace("- "+getProductPrice_String(),""));
    }
}
