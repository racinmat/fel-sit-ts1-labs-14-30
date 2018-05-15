package selenium;

import helpers.LoginPage;
import helpers.TopMenuLoggedIn;
import helpers.TopMenuPublic;
import org.junit.*;
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
    private LoginPage loginPage;
    private TopMenuPublic topMenuPublic;
    private TopMenuLoggedIn topMenuLoggedIn;

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver",
            "C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\geckodriver.exe");
        driver = new ChromeDriver();
//        chromeDriver = new FirefoxDriver();
    }

    @Before
    public void setUp() throws Exception {
        loginPage = LoginPage.create(driver);
        topMenuPublic = TopMenuPublic.create(driver);
        topMenuLoggedIn = TopMenuLoggedIn.create(driver);
    }

    @Test
    public void loginProcedure() throws InterruptedException {
        a_testLogin();
        b_testShowProfile();
        c_createProject();
    }

    //    @Test
    public void a_testLogin() throws InterruptedException {
        driver.get("http://demo.redmine.org/");
        assertEquals("http://demo.redmine.org/", driver.getCurrentUrl());

        topMenuPublic.loginButton.click();

        assertEquals("http://demo.redmine.org/login", driver.getCurrentUrl());

        loginPage.login("testUser222", "heslo");

        assertEquals("http://demo.redmine.org/", driver.getCurrentUrl());

        assertTrue(topMenuLoggedIn.user.isDisplayed());

        Thread.sleep(1000);
    }

    //    @Test
    public void b_testShowProfile() {
        WebElement profileButton = driver.findElement(By.cssSelector("#loggedas > .user"));
        profileButton.click();

        assertEquals("http://demo.redmine.org/users/340939", driver.getCurrentUrl());
    }

    public void c_createProject() {
        driver.get("http://demo.redmine.org/projects");
        driver.findElement(By.cssSelector("#content > div.contextual > a.icon.icon-add"))
            .click();

        assertEquals("http://demo.redmine.org/projects/new", driver.getCurrentUrl());
        driver.findElement(By.id("project_name")).sendKeys("my new project");
        driver.findElement(By.id("project_identifier")).sendKeys("my_new_project");
        driver.findElement(By.name("commit")).click();

        WebElement selectBox = driver.findElement(By.id("project_quick_jump_box"));
        selectBox.findElements(By.xpath("//*[@id=\"project_quick_jump_box\"]/option[text()=\"my new project\"]"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
