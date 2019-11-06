package com.github.sn.bases;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {
    private static final String BASE_URL = "https://demo.getsaleor.com/en/";
    protected String path;
    public WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getUrl() {
        if (this.path.contains("http") || this.path.contains("https")) {
            return this.path;
        } else {
            return BASE_URL.concat(this.path);
        }
    }

    public void goToPage() {
        this.webDriver.get(getUrl());
    }

    public String getTitle() {
        return this.webDriver.getTitle();
    }

    public void goTo(String link) {
        this.webDriver.get(link);
    }

    public int randNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public int randNumberBetween(int min, int max, int exclusiveNum) {
        int number = randNumberBetween(min, max);
        if (number == exclusiveNum) {
            randNumberBetween(min, max, exclusiveNum);
        }
        return number;
    }


    public void waitForElementClickable(WebElement element) {
        webDriverWait = new WebDriverWait(webDriver, 10);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public void waitForAllElements(List<WebElement> elements) {
        webDriverWait = new WebDriverWait(webDriver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
