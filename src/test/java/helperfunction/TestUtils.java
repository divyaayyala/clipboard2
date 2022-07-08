package helperfunction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestUtils {
    public static Logger log = LogManager.getLogger();
    // Get selector-ID and click on that element
    public void clickIdSelector(String idSelector, ChromeDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idSelector))).click();
    }

    // Get selector-css and click on that element
    public void clickCssSelector(String cssSelector, ChromeDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).click();
    }

    // Get selector-xpath and click on that element
    public void clickXpathSelector(String xpathSelector, ChromeDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector))).click();
    }

    // Switch focus to new tab
    public void switchTabs(ChromeDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        // Hold all window handles in array list
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        // Switch to new tab
        driver.switchTo().window(newTab.get(1));
    }

    // Assertions
    public void assertions(String classNameSelector, String expectedTitle, ChromeDriver driver){
        // Assertion "About this item" section
        // Get Original text
        String actualTitle = driver.findElement(By.className(classNameSelector)).getText();
        // Actual text should be equals to Expected text
        assertEquals(actualTitle, expectedTitle);
        // If matching then print the result
        log.info(expectedTitle+":");
    }

    public void printContent(String cssSelector, ChromeDriver driver){
        // Get details from About this item section
        String content = driver.findElement(By.cssSelector(cssSelector)).getText();
        // Print the result
        log.info(""+content);

    }
}
