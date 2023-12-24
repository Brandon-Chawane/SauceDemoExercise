package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePage {
    public WebDriver driver;

    //Finding burger menu
    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement homepage_Products_Xpath;

    //Finding item to add to cart
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackPack_Id;

    //Confirming item added
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement addedItem_Id;

    //finding shopping cart element
    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCartLink_Id;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertHeading() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(homepage_Products_Xpath));
        Assert.assertEquals(homepage_Products_Xpath.getText(), "Products");
    }


    public void addToCart() {

        addBackPack_Id.click();

    }

    public void assertAdd() {
        Assert.assertEquals(addedItem_Id.getText(), "Remove");

    }

    public void shoppingCartClick() {
        shoppingCartLink_Id.click();
    }
}