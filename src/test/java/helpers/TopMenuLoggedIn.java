package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuLoggedIn {

    @FindBy(id = "loggedas")
    public WebElement user;

    public static TopMenuLoggedIn create(WebDriver driver) {
        return PageFactory.initElements(driver, TopMenuLoggedIn.class);
    }
}
