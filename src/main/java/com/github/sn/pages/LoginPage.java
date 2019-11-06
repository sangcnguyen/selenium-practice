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
    private WebElement emailFld;

    @FindBy(id = "id_password")
    private WebElement passFld;

    @FindBy(xpath = "//*[contains(@class,'btn btn-primary narrow')]")
    private WebElement loginBtn;

    public void logIn(String email, String password) {
        emailFld.clear();
        emailFld.sendKeys(email);
        passFld.clear();
        passFld.sendKeys(password);
        loginBtn.click();
    }
}

