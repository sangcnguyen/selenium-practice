package com.github.sn.bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private static boolean firstRun = true;
    public WebDriver webDriver;

    @BeforeSuite
    public static void beforeAll() {
        if (firstRun) {
            firstRun = false;
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_win64_0.19.1.exe");
            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/edgedriver_15063.exe");
            WebDriverManager.chromedriver().setup();
        }

    }

    @BeforeMethod
    public void beforeEach() {
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void afterEach() {
        webDriver.quit();
    }
}
