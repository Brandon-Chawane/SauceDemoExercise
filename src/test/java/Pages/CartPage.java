package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {

    WebDriver driver;


    @FindBy(id = "item_4_title_link")
    WebElement itemVerificationXpath;
    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    public CartPage(WebDriver driver) {
        this.driver = driver;

    }

    public void assertItem() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(itemVerificationXpath));
        Assert.assertEquals(itemVerificationXpath.getText(), "Sauce Labs Backpack");

    }

    public void checkOutBtnClick(){
        checkOutBtn.click();
    }
}
