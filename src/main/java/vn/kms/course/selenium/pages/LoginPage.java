package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vn.kms.course.selenium.bases.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        path="account/login/";
    }

    @FindBy(id = "id_username")
    private WebElement emailEdt;

    @FindBy(id = "id_password")
    private WebElement passEdt;

    @FindBy(xpath = "//*[contains(@class,'btn primary narrow')]")
    private WebElement loginButton;

    public void logIn(String email, String password) {
        emailEdt.clear();
        emailEdt.sendKeys(email);
        passEdt.clear();
        passEdt.sendKeys(password);
        loginButton.click();
    }
}

