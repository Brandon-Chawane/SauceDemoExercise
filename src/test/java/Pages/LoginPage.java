package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;


import java.time.Duration;

public class LoginPage {

    public WebDriver driver;

    //building constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "user-name")
    WebElement username_id;

    @FindBy(id = "password")
    WebElement password_id;

    @FindBy(id = "login-button")
    WebElement logInBtn_id;


    public void enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(username_id));
        username_id.sendKeys(username);
    }

    public void enterPassword(String password) {
        password_id.sendKeys(password);
    }

    public void clickLoginBtn(){
        logInBtn_id.click();
    }
}
