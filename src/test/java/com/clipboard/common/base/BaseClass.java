package com.clipboard.common.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    public static ChromeDriver driver;
    public static Logger log = LogManager.getLogger();

    @BeforeSuite
    public void setUp() {
        if (driver == null) {
            log.info("Clipboard App Startup!");
            //System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @AfterSuite
    public void tearDown() {
        log.info("Clipboard App Teardown!");
        if (driver != null) {
            driver.quit();
        }
    }
}