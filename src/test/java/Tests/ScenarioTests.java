package Tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ScenarioTests extends Base {


    //---------------------------- Login Test----------------------------------

    @Test
    public void enterusernameTests() {

        loginPage.enterUsername(readFromExcel.username);
    }

    @Test(dependsOnMethods = "enterusernameTests")
    public void enterpasswordTests() {

        loginPage.enterPassword(readFromExcel.password);

    }

    @Test(dependsOnMethods = "enterpasswordTests")
    public void clickLoginButtonTests() {
        takeScreenshots.takeSnapShot(driver, "Login Page");
        loginPage.clickLoginBtn();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyLoginSuccess() {

        takeScreenshots.takeSnapShot(driver, "Home Page");
        homePage.assertHeading();

    }


    //------------------------Home Page Test-------------------------------


    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void addToCartTest() {
        homePage.addToCart();
    }


    @Test(dependsOnMethods = "addToCartTest")
    public void assertAddedToCartTest() {
        homePage.assertAdd();
        takeScreenshots.takeSnapShot(driver, "assertAdded");
    }

    @Test(dependsOnMethods = "assertAddedToCartTest")
    public void cartClickTest() {
        homePage.shoppingCartClick();
    }


    //---------------------Cart Page Test-----------------------------

    @Test(dependsOnMethods = "cartClickTest")
    public void assertItemInCart() {

        cartPage.assertItem();
        takeScreenshots.takeSnapShot(driver, "Item In Cart");
    }

    @Test(dependsOnMethods = "assertItemInCart")
    public void clickCheckOutBut() {

        cartPage.checkOutBtnClick();
    }

    //------------------------CheckOut Page Test-----------------------

    @Test(dependsOnMethods = "clickCheckOutBut")
    public void checkOutVerificationTest() {
        checkoutPage.checkPageVerification();
    }

    @Test(dependsOnMethods = "checkOutVerificationTest")
    public void enterFirstNameTests() {
        checkoutPage.enterFirstName(readFromExcel.firstName);
    }

    @Test(dependsOnMethods = "enterFirstNameTests")
    public void enterLastNameTest() {
        checkoutPage.enterLastName(readFromExcel.LastNAme);
    }

    @Test(dependsOnMethods = "enterLastNameTest")
    public void enterPostalCodeTest() {
        checkoutPage.enterPostalCode(readFromExcel.ZipCode);
        takeScreenshots.takeSnapShot(driver, "Personal details");
    }

    @Test(dependsOnMethods = "enterPostalCodeTest")
    public void pressContinueBtnTest() {
        checkoutPage.pressContinueBtn();
    }

    //--------------------------Over View Page Test----------------------------


    @Test(dependsOnMethods = "pressContinueBtnTest")
    public void verifyOverviewPage() {
        overviewPage.inOverViewPage();
    }

    @Test(dependsOnMethods = "verifyOverviewPage")
    public void itemIsVisibleTest() {
        overviewPage.myItemisDisplayed();
        takeScreenshots.takeSnapShot(driver, "Verify Item is visible");
    }

    @Test(dependsOnMethods = "itemIsVisibleTest")
    public void calculations() throws InterruptedException {
        overviewPage.totalItemCost();
    }

  //  @AfterTest
   // public void tearDown(){
      //  driver.quit();
  //  }

}
