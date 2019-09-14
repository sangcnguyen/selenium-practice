package vn.kms.course.selenium.model;

import java.util.*;

public class Product {
    private HashMap<String, String> product = new HashMap<>();

    public Map<String, String> getProduct() {
        return product;
    }

    public void putProduct(String k, String v) {
        product.put(k, v);
    }
}
