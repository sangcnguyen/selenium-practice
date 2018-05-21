package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vn.kms.course.selenium.bases.BasePage;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
        path = "/";
    }

    @FindBy(xpath = "//a[@href='/account/login/']")
    private WebElement txt_Login;

    @FindBy(xpath = "//a[@href='/account/signup/']")
    private WebElement txt_Register;

    @FindBy(xpath = "//a[@href='/dashboard/']")
    private WebElement txt_Dashboard;

    @FindBy(xpath = "//a[@href='/profile/']")
    private WebElement txt_Youraccount;

    @FindBy(xpath = "//a[@href='/account/logout/']")
    private WebElement txt_Logout;

    @FindBy(id = "XMLID_124_")
    private WebElement img_logo;

    @FindBy(xpath = "//*[@class='alert alert-success']")
    private WebElement mess_logout;

    public void clickLogout() {
        txt_Logout.click();
    }

    public boolean isHomePage() {
        return img_logo.isDisplayed();
    }

    public String isDashboard() {
        return txt_Dashboard.getText();
    }

    public String isYourAccount() {
        return txt_Youraccount.getText();
    }

    public String isLogout() {
        return txt_Logout.getText();
    }

    public String isRegister() {
        return txt_Register.getText();
    }

    public String isLogin() {
        return txt_Login.getText();
    }

    public String isMessSuccessful() {
        return removeChar(mess_logout.getText(),0).trim();
    }

    public String removeChar(String s, int p){
        return  s.substring(0,p)+s.substring(p+1);
    }
}
