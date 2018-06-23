package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vn.kms.course.selenium.bases.BasePage;

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
    private WebElement logoutMess;

    public void clickLogout() {
        logoutLink.click();
    }

    public List<String> getTextOnMenu() {
        List<String> labelList = new ArrayList<String>();
        for (WebElement element : menuText) {
            labelList.add(element.getText());
        }
        return labelList;
    }

    public boolean getHomePage() {
        return logoImage.isDisplayed();
    }

    public String getMessSuccessful() {
        return removeChar(logoutMess.getText(), 0).trim();
    }

    public String removeChar(String s, int p) {
        return s.substring(0, p) + s.substring(p + 1);
    }
}
