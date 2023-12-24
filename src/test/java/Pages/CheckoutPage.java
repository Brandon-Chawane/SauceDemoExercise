package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {


    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Your Information')]")
    WebElement checkOutXpath;
    @FindBy(id ="first-name")
    WebElement firstNameTxtBox;

    @FindBy(id = "last-name")
    WebElement lastNameTxtBox;

    @FindBy(id="postal-code")
    WebElement postalCodeTxtBox;

    @FindBy(id="continue")
    WebElement continueBtn;

    public void checkOutPage(WebDriver driver){

        this.driver = driver;

    }

    public void checkPageVerification(){
        checkOutXpath.isDisplayed();
    }
    public void enterFirstName(String firstName ){
        firstNameTxtBox.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameTxtBox.sendKeys(lastName);
    }

    public  void enterPostalCode(String postalCode){
        postalCodeTxtBox.sendKeys(postalCode);
    }

    public void pressContinueBtn(){
        continueBtn.click();
    }

}
