package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vn.kms.course.selenium.bases.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
        path = "cart/";
    }

    @FindBy(xpath = "//*[@class='col-7 cart__line__product']")
    private List<WebElement> lst_name;

    @FindBy(xpath = "//*[@class='text-right cart-subtotal']")
    private WebElement txt_subtotal;

//    @FindBy(xpath = "//*[@class='text-right']")
//    private List<WebElement> txt_prices;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/p")
    private WebElement price_pro1;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div[2]/div/div[2]/p")
    private WebElement price_pro2;

    @FindBy(id = "id_quantity")
    private List<WebElement> quantities;


    public int numOfProduct() {
        return lst_name.size();
    }

    public List<String> nameOfProducts() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < lst_name.size(); i++) {
            list.add(lst_name.get(i).getText());
        }
        return list;
    }

    public String getSubtotal() {
        return removeChar(txt_subtotal.getText(), 0).trim();
    }

    public double getPricePro1() {
        return Double.parseDouble(removeChar(price_pro1.getText().replace(",",""), 0).trim());
    }

    public double getPricePro2() {
        return Double.parseDouble(removeChar(price_pro2.getText().replace(",",""), 0).trim());
    }

    public String removeChar(String s, int p) {
        return s.substring(0, p) + s.substring(p + 1);
    }

    public int[] getProductQuantity() {
        int arr[] = new int[quantities.size()];
        for (int i = 0; i < quantities.size(); i++) {
            arr[i]=Integer.parseInt(quantities.get(i).getAttribute("value"));
        }
        return arr;
    }

    public String[] getNameofProducts(){
        String arr[] = new String[lst_name.size()];
        for(int i=0;i<lst_name.size();i++){
            arr[i] = lst_name.get(i).toString();
        }
        return arr;
    }
}
