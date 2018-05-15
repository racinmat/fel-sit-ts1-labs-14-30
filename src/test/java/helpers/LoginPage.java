package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//    public static final String username = "username";
//    public static final String password = "password";
    public static final String loginButton = "//*[@name=\"login\"]";
//
//    public static By usernameBy = By.id(username);
//    public static By passwordBy = By.id(password);
//    public static By loginButtonBy = By.xpath(loginButton);

//    @FindBy(id = username)
//    public WebElement usernameEl;
    public WebElement username;

//    @FindBy(id = password)
//    public WebElement passwordEl;
    public WebElement password;

    @FindBy(xpath = loginButton)
    public WebElement submitButtonEl;

    public static LoginPage create(WebDriver driver) {
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public void login(String login, String password) {
//        usernameEl.sendKeys(login);
//        passwordEl.sendKeys(password);
        this.username.sendKeys(login);
        this.password.sendKeys(password);
        submitButtonEl.click();
    }
}
