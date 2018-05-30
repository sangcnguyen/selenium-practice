package vn.kms.course.selenium.model;

import java.util.*;

public class Product {
    private HashMap<String,String> product = new HashMap<String, String>();
//    private String productName;
//    private String productQuantity;
//    private String productPrice;
//
//    public Product(String productName, String productQuantity, String productPrice) {
//        this.productName = productName;
//        this.productQuantity = productQuantity;
//        this.productPrice = productPrice;
//    }

//    public Product(){
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getProductQuantity() {
//        return productQuantity;
//    }
//
//    public void setProductQuantity(String productQuantity) {
//        this.productQuantity = productQuantity;
//    }
//
//    public String getProductPrice() {
//        return productPrice;
//    }
//
//    public void setProductPrice(String productPrice) {
//        this.productPrice = productPrice;
//    }

    public HashMap<String, String> getProduct() {
        return product;
    }

    public void putProduct(String k,String v){
        product.put(k,v);
    }
}
