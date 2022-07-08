package com.clipboard.tests;

import com.clipboard.common.base.BaseClass;
import com.clipboard.tests.helperfunction.TestUtils;
import org.testng.annotations.Test;

import static com.clipboard.tests.constants.ClipboardConstants.*;

public class SeleniumTest extends BaseClass {

    @Test
    public void login() throws InterruptedException {
        // Navigate to Amazon.in website
        driver.get(TARGET_URL);

        // Maximize window
        driver.manage().window().maximize();

        TestUtils testUtils = new TestUtils();
        // Click on Hamburger Menu
        testUtils.clickIdSelector(NAV_HAMBURGER_MENU, driver);

        // Click on TV, Appliances, Electronics
        testUtils.clickCssSelector(CLICK_TV_APPLIANCE_ELECTRONICS, driver);

        // Click on Televisions
        testUtils.clickCssSelector(CLICK_TELEVISIONS, driver);

        // Click on Samsung
        testUtils.clickCssSelector(CLICK_SAMSUNG, driver);

        // Click on Drop down
        testUtils.clickIdSelector(CLICK_DROPDOWN, driver);

        // Click on High to Low option
        testUtils.clickIdSelector(CLICK_SORT_HIGH_LOW, driver);

        // Click on 2nd highest option
        testUtils.clickXpathSelector(CLICK_SECOND_HIGHEST_OPTION, driver);

        //  Switch focus to new tab
        testUtils.switchTabs(driver);

        // Assertion "About this item" section
        testUtils.assertions(CHECK_ABOUT_THIS_ITEM, ABOUT_THIS_ITEM, driver);

        // Print content from About this item in the console
        testUtils.printContent(PRINT_ABOUT_THIS_ITEM, driver);

        // Quit the browser and end the WebDriver session
        driver.quit();
    }
}
