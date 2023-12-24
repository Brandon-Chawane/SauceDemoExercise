package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OverviewPage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement overView_Xpath;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement myItem_Xpath;

    @FindBy(xpath = "//div[@class='summary_subtotal_label'][contains(.,'Item total: $29.99')]")
    WebElement itemTotal_Xpath;

    @FindBy(xpath = "//div[@class='summary_tax_label'][contains(.,'Tax: $2.40')]")
    WebElement tax_Xpath;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label'][contains(.,'Total: $32.39')]")
    WebElement total_Xpath;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(id = "cancel")
    WebElement cancelBtn;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

    @FindBy(xpath = "//a[contains(@id,'link')][@class='bm-item menu-item'][contains(.,'Logout')]")
    WebElement logOut;


    public void overViewPage(WebDriver driver) {
        this.driver = driver;
    }


    public void inOverViewPage() {
        overView_Xpath.isDisplayed();
    }

    public void myItemisDisplayed() {
        myItem_Xpath.isDisplayed();
    }

    public void clickFinishBtn() {
        finishBtn.click();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    public void clickBurgerMenu() {
        burgerMenu.click();

    }

    public void clickLogout() throws InterruptedException {
        Thread.sleep(2000);
        logOut.click();
    }


    public void totalItemCost() throws InterruptedException {

        double itemTotal = Double.parseDouble(itemTotal_Xpath.getText().substring(13));
        double tax = Double.parseDouble(tax_Xpath.getText().substring(6));
        double total = Double.parseDouble(total_Xpath.getText().substring(8));


        if (total == itemTotal + tax) {
            clickFinishBtn();
            System.out.println("Your order is dispatched");
        } else {

            clickCancelBtn();
            clickBurgerMenu();
            clickLogout();


        }
    }


}
