package com.github.sn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.github.sn.bases.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        path = "/";
    }

    @FindBy(linkText = "Log out")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[contains(concat(' ',@class,' '),' float-right ')]/li")
    private List<WebElement> menuText;

    @FindBy(id = "XMLID_124_")
    private WebElement logoImage;

    @FindBy(xpath = "//*[contains(concat(' ',@class,' '),' alert alert-success ')]")
    private WebElement logoutMessage;

    public void clickLogout() {
        logoutLink.click();
    }

    public List<String> getTextOnMenu() {
        List<String> labelList = new ArrayList<>();
        for (WebElement element : menuText) {
            labelList.add(element.getText());
        }
        return labelList;
    }

    public String getLogOutText() {
        return logoutLink.getText();
    }

    public String getMessSuccessful() {
        return removeChar(logoutMessage.getText(), 0).trim();
    }

    private String removeChar(String s, int p) {
        return s.substring(0, p) + s.substring(p + 1);
    }
}
