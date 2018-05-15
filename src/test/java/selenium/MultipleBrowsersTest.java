package selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultipleBrowsersTest {

    static WebDriver chromeDriver;
    static WebDriver firefoxDriver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\geckodriver.exe");

        firefoxDriver = new FirefoxDriver();
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        chromeDriver.get("https://www.google.com");
        firefoxDriver.get("https://www.bing.com");
        assertEquals("https://www.google.com/", chromeDriver.getCurrentUrl());

        WebElement searchBar = chromeDriver.findElement(By.name("q"));

        searchBar.sendKeys("čvut");
        searchBar.submit();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        chromeDriver.quit();
        firefoxDriver.quit();
    }
}
