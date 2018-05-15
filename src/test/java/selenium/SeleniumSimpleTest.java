package selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SeleniumSimpleTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\geckodriver.exe");
//        chromeDriver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.get("https://www.google.com");
        assertEquals("https://www.google.com/", driver.getCurrentUrl());

        WebElement searchBar = driver.findElement(By.name("q"));

        searchBar.sendKeys("čvut");
        searchBar.submit();

        Wait<WebDriver> wait = new WebDriverWait(driver, 3);
        wait.until(d ->
            d.findElement(By
                .cssSelector("#rso > div:nth-child(1) > div > div > div > div > h3 > a"))
                .isDisplayed()
        );

        WebElement firstResult = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > h3 > a"));
        assertEquals("ČVUT", firstResult.getText());
        assertTrue(firstResult.isDisplayed());

        firstResult.click();
        assertEquals("https://www.cvut.cz/", driver.getCurrentUrl());
    }

    @Test
    public void checkWebsites() {
        List<String> websites = new ArrayList<>();
        websites.add("https://www.google.com/");
        websites.add("https://www.bing.com/");
        websites.add("https://www.seznam.cz/");

        for (String website : websites) {
            driver.get(website);
            System.out.println(driver.getTitle());
            assertEquals(website, driver.getCurrentUrl());
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
