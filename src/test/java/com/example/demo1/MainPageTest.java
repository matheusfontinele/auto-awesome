package com.example.demo1;

import com.example.demo1.utils.ScreenshotUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MainPageTest {

    private static Logger LOGGER = LoggerFactory.getLogger(MainPageTest.class);
    private final String MAIN_PAGE_URL = "https://plexusworldwide.com/";

    private final String EXPECTED_JOIN_PAGE_URL = "https://plexusworldwide.com/join";

    private WebDriver driver;
    MainPage mPage;

    @BeforeTest
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        LOGGER.info("Open the browser");
        driver.manage().window().maximize();
        LOGGER.info("Maximize screen");
        driver.get(MAIN_PAGE_URL);
        LOGGER.info("URL: " + MAIN_PAGE_URL);

        mPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void getDataOfJoinButtonAndClick() {
        String joinText = mPage.joinButton.getText();
        LOGGER.info("Text: " + joinText);
        assertEquals("Join", joinText);
        ScreenshotUtils.takeScreenshot(driver, "Data of element Join");

        mPage.joinButton.click();
        LOGGER.info("Button Join clicked");

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        JoinPage joinPage = new JoinPage(driver);

        LOGGER.info("Waiting for the visibility of the join image");
        wait.until(ExpectedConditions.visibilityOf(joinPage.imageJoinHero));
        LOGGER.info("Join image is visible now");


        String joinPageTitle = driver.getCurrentUrl();
        LOGGER.info("Join page url: " + joinPageTitle);

        assertEquals(EXPECTED_JOIN_PAGE_URL, joinPageTitle);
        ScreenshotUtils.takeScreenshot(driver, "Join page load successfully");
    }

}
