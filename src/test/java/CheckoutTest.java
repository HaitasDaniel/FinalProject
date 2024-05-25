import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;

    public CartPage cartPage;

    public WishlistPage wishlistPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Enter user's credentials in checkout process")
    public void SubmitCredentialsCheckoutTest() throws InterruptedException { // InterruptedException e pentru threadsleep, se poate sterge daca nu il folosesti.
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterLastNameField();
        checkoutPage.enterAddressField();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The credential fields were successfully completed with user's credentials");
        checkoutPage.clickContinueCheckoutButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The user is able to move forward to checkout process and the 'Order Summary' is shown to the user");
        assertEquals("Order summary", checkoutPage.getOrderSummaryText().getText());
        Thread.sleep(2000);
    }

    @Test(description = "Enter user's credentials in checkout process without completing the first name field")
    public void SubmitIncompleteCredentialsCheckoutTest1() throws InterruptedException {
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterLastNameField();
        checkoutPage.enterAddressField();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Only the user's last name field and address field were completed");
        checkoutPage.clickContinueCheckoutButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "When the user try to move forward and clicks the continue checkout button, he is notified that the first name field is mandatory");
        assertEquals("First Name is required", checkoutPage.getErrorNotify().getText());
        Thread.sleep(2000);


    }

    @Test(description = "Enter user's credentials in checkout process without completing the last name field")
    public void SubmitIncompleteCredentialsCheckoutTest2() throws InterruptedException {
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterAddressField();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Only the user's first name field and address field were completed");
        checkoutPage.clickContinueCheckoutButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "When the user try to move forward and clicks the continue checkout button, he is notified that the last name field is mandatory.");
        assertEquals("Last Name is required", checkoutPage.getErrorNotify().getText());
        Thread.sleep(2000);

    }

    @Test(description = "Enter user's credentials in checkout process without completing the address field")
    public void SubmitIncompleteCredentialsCheckoutTest3() throws InterruptedException {
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterLastNameField();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Only the user's first name field and last name field were completed");
        checkoutPage.clickContinueCheckoutButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "When the user try to move forward and clicks the continue checkout button, he is notified that the address field is mandatory");
        assertEquals("Address is required", checkoutPage.getErrorNotify().getText());
        Thread.sleep(2000);
    }

    @Test(description = "Checking out without completing any credential fields")
    public void SubmitIncompleteCredentialsCheckoutTest4() throws InterruptedException {
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.clickContinueCheckoutButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "When the user try to move forward with the checkout process and clicks the continue checkout button, he is notified that the first name field is mandatory");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The user should be notified that all credential fields are mandatory, not only the first name field");
        assertEquals("First Name is required", checkoutPage.getErrorNotify().getText());
        Thread.sleep(2000);

    }

    @Test(description = "Complete a full checkout test")
    public void CompleteCheckoutTest() throws InterruptedException { // InterruptedException e pentru threadsleep, se poate sterge daca nu il folosesti.
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Product 'Awesome Granit Chips' was added to cart");
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterLastNameField();
        checkoutPage.enterAddressField();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The credential fields were successfully completed");
        checkoutPage.clickContinueCheckoutButton();
        checkoutPage.clickCompleteOrderButton();
        assertEquals("Order complete", checkoutPage.getOrderCompleteNotify().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The user is notified with the following text 'Order complete'");
        Thread.sleep(2000);
    }

    @Test(description = "Testing 'Reset the application state' button")
    public void ResetButtonTest() throws InterruptedException {
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickAddToWishlistButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Product 'Awesome Granit Chips' was added to Cart multiple times than it was added to Wishlist");
        checkoutPage.clickResetButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Reset button was clicked and all products from cart and wishlist were emptied");
        Thread.sleep(2000);

    }
}


