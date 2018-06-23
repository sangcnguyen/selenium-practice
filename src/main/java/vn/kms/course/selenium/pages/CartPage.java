package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vn.kms.course.selenium.bases.BasePage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
        path = "cart/";
    }

    @FindBy(css = "div.cart__line__product p")
    private List<WebElement> productNameList;

    @FindBy(id = "id_quantity")
    private List<WebElement> quantitiesInput;

    @FindBy(className = "cart-item-price")
    private List<WebElement> pricesText;

    @FindBy(css = "h3.cart-subtotal")
    private WebElement subTotalText;

    public int getNumberOfProduct() {
        return productNameList.size();
    }

    public String[] getProductName() {
        String[] nameList = new String[productNameList.size()];
        for (int i = 0; i < nameList.length; i++) {
            nameList[i] = getTextNode(productNameList.get(i));
        }
        return nameList;
    }

    public String[] getProductQuantity() {
        String[] quantityList = new String[quantitiesInput.size()];
        for (int i = 0; i < quantityList.length; i++) {
            quantityList[i] = quantitiesInput.get(i).getAttribute("value");
        }
        return quantityList;
    }

    public Double[] getProductPrice_Double() {
        Double[] priceList = new Double[pricesText.size()];
        for (int i = 0; i < pricesText.size(); i++) {
            try {
                priceList[i] = Double.parseDouble(removeChar(pricesText.get(i).getText().replace(",", "").trim(), 0));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return priceList;
    }

    public String[] getProductPrice_String() {
        String[] priceList = new String[pricesText.size()];
        for (int i = 0; i < pricesText.size(); i++) {
            priceList[i] = pricesText.get(i).getText().trim();
        }
        return priceList;
    }

    public String getSubtotal() {
        return subTotalText.getText().replace("$", "").trim();
    }

    public String removeChar(String s, int p) {
        return s.substring(0, p) + s.substring(p + 1);
    }

    public String calculateTotal() {
        NumberFormat nf = new DecimalFormat("#,###.00");
        String result = "";
        double sum = 0;
        for (double priceList : getProductPrice_Double()) {
            try {
                sum += priceList;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return result = "" + nf.format(sum);
    }

    public String getTextNode(WebElement e) {
        String text = e.getText().split("\n")[0].trim();
        return text;
    }

    public HashMap<String, String> actualProduct() {
        HashMap<String, String> actualProduct = new HashMap<String, String>();
        for (int i = 0; i < productNameList.size(); i++) {
            actualProduct.put(getProductName()[i], convertArrayListToString(getProductName()[i], getProductQuantity()[i], getProductPrice_String()[i]));
        }
        return actualProduct;
    }

    public String convertArrayListToString(String name, String quantity, String price) {
        List<String> strList = new ArrayList<String>();
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
}
