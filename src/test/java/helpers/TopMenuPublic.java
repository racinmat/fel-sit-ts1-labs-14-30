package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPublic {

    @FindBy(css = "a.login")
    public WebElement loginButton;

    @FindBy(css = "a.register")
    public WebElement registerButton;

    public static TopMenuPublic create(WebDriver driver) {
        return PageFactory.initElements(driver, TopMenuPublic.class);
    }
}
