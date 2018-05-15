package selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedmineTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\geckodriver.exe");
        driver = new ChromeDriver();
//        chromeDriver = new FirefoxDriver();
    }

    @Test
    public void loginProcedure() throws InterruptedException {
        a_testLogin();
        b_testShowProfile();
    }

//    @Test
    public void a_testLogin() throws InterruptedException {
        driver.get("http://demo.redmine.org/");
        assertEquals("http://demo.redmine.org/", driver.getCurrentUrl());
//        assertFalse(chromeDriver.findElement(By.id("loggedas")).isDisplayed());
        List<WebElement> elements = driver.findElement(By.id("top-menu"))
            .findElements(By.tagName("div"));
        for (WebElement element : elements) {
            assertNotEquals("loggedas", element.getAttribute("id"));
        }

        driver
            .findElement(By.cssSelector("a.login"))
            .click();

        assertEquals("http://demo.redmine.org/login", driver.getCurrentUrl());

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("testUser654321");
        password.sendKeys("heslo");

        WebElement loginButton = driver.findElement(By.xpath("//*[@name=\"login\"]"));
        loginButton.click();

        assertEquals("http://demo.redmine.org/", driver.getCurrentUrl());
//        assertEquals("Přihlášen jako testUser654321", chromeDriver.findElement(By.id("loggedas")).getText());
//        if (chromeDriver.findElement(By.id("top-menu"))
//            .findElements(By.tagName("div"))
//            .stream()
//            .noneMatch((e) -> e.getAttribute("id").equals("loggedas"))) {
//            fail();
//        }

        assertTrue(driver.findElement(By.id("loggedas")).isDisplayed());

        Thread.sleep(1000);
    }

//    @Test
    public void b_testShowProfile() {
        WebElement profileButton = driver.findElement(By.cssSelector("#loggedas > .user"));
        profileButton.click();

        assertEquals("http://demo.redmine.org/users/338647", driver.getCurrentUrl());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
