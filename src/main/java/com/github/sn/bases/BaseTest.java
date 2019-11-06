package vn.kms.course.selenium.bases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private static boolean firstRun = true;
    public WebDriver webDriver;

    @BeforeAll
    public static void beforeAll() {
        if (firstRun) {
            firstRun = false;
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_win64_0.19.1.exe");
            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/edgedriver_15063.exe");
        }
    }

    @BeforeEach
    public void beforeEach() {
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }
}
