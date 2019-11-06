package com.github.sn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.github.sn.bases.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        path = "account/login/";
    }

    @FindBy(id = "id_username")
    private WebElement emailField;

    @FindBy(id = "id_password")
    private WebElement passField;

    @FindBy(xpath = "//*[contains(@class,'btn btn-primary narrow')]")
    private WebElement loginButton;

    public void logIn(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passField.clear();
        passField.sendKeys(password);
        loginButton.click();
    }
}

