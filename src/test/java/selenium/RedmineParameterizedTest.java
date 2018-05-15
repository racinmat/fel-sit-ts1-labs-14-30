package selenium;

import helpers.CSVfileReader;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class RedmineParameterizedTest {

    static WebDriver driver;

    private String username;
    private String password;

    public RedmineParameterizedTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\geckodriver.exe");
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("http://demo.redmine.org/");
        assertEquals("http://demo.redmine.org/", driver.getCurrentUrl());

        driver
            .findElement(By.cssSelector("a.login"))
            .click();

        assertEquals("http://demo.redmine.org/login", driver.getCurrentUrl());

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys(this.username);
        password.sendKeys(this.password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@name=\"login\"]"));
        loginButton.click();

        assertEquals("http://demo.redmine.org/", driver.getCurrentUrl());

        assertTrue(driver.findElement(By.id("loggedas")).isDisplayed());

        Thread.sleep(1000);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Parameterized.Parameters()
    public static Collection<String[]> data() throws IOException {
        return CSVfileReader.readCSVfileToCollection("src\\test\\resources\\users.csv");
    }

}
