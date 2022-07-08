import helperfunction.TestUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class SeleniumTest {

    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/divyaayyalasomayajula/chromedriver");

        ChromeDriver driver = new ChromeDriver();

        // Navigate to Amazon.in website
        driver.get("http://amazon.in/");

        // Maximize window
        driver.manage().window().maximize();

        TestUtils testUtils = new TestUtils();
        // Click on Hamburger Menu
        testUtils.clickIdSelector("nav-hamburger-menu", driver);

        // Click on TV, Appliances, Electronics
        testUtils.clickCssSelector("li:nth-child(16) a.hmenu-item", driver);

        // Click on Televisions
        testUtils.clickCssSelector("ul:nth-child(9) li:nth-child(3) a.hmenu-item", driver);

        // Click on Samsung
        testUtils.clickCssSelector("div:nth-child(20) li:nth-child(2) i.a-icon-checkbox", driver);

        // Click on Drop down
        testUtils.clickIdSelector("a-autoid-0-announce", driver);

        // Click on High to Low option
        testUtils.clickIdSelector("s-result-sort-select_2", driver);

        // Click on 2nd highest option
        testUtils.clickXpathSelector("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div[1]/span/a/div/img", driver);

        //  Switch focus to new tab
        testUtils.switchTabs(driver);

        // Assertion "About this item" section
        testUtils.assertions("a-size-base-plus", "About this item", driver );

        // Print content from About this item in the console
        testUtils.printContent("#feature-bullets ul", driver);

     // Quit the browser and end the WebDriver session
     driver.quit();
    }
}
