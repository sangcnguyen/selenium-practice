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
    private WebElement edt_Email;

    @FindBy(id = "id_password")
    private WebElement edt_Password;

    @FindBy(xpath = "//*[@class='btn primary narrow']")
    private WebElement btn_Login;

    public void logIn(String email, String password) {
        edt_Email.clear();
        edt_Email.sendKeys(email);
        edt_Password.clear();
        edt_Password.sendKeys(password);
        btn_Login.click();
    }
}

