import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class CartTest extends Hooks {

    public CartPage cartPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver, 10);
    }


    @Test(description = "Simple adding a product to cart using 'Awesome Granite Chips' product")
    public void addProductToCart() throws InterruptedException { // InterruptedException e pentru threadsleep, se poate sterge daca nu il folosesti.
        //TEST 1
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Verify in cart page if the product was successfully added");
        assertEquals("Awesome Granite Chips", cartPage.getGraniteChipsProduct().getText());
        assertEquals("Checkout", cartPage.getCheckOutButton().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "'Awesome Granite Chips' product was successfully added to cart");
        Thread.sleep(2000);
    }

    @Test(description = "Removing  product 'Awesome Granite Chips' from cart using '-' quantity button")
    public void removeProductFromCart() throws InterruptedException {
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        cartPage.clickMinusButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product was removed and the user is notified with the following text: 'How about adding some products in your cart?' if the only product from cart was 'Awesome Granite Chips'");
        assertEquals("How about adding some products in your cart?", cartPage.getAddProductsToCartText().getText());
        Thread.sleep(2000);

    }

    @Test(description = "Change the quantity of a product from cart")
    public void changeProductQuantityTest() throws InterruptedException {
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the 'Awesome Granite Chips' product is: " + cartPage.productPrice());
        double expectedTotal = cartPage.productPrice() * 2;
        cartPage.clickPlusQuantity();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product 'Awesome Granite Chips' after updating quantity to 2 is: " + cartPage.productPrice());
        assertEquals(cartPage.productPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price was updated according to quantity");

    }

    @Test(description = "Calculating the total price with taxes when checking out an order")
    public void totalPriceWithTaxesTest() throws InterruptedException {
        cartPage.clickAddProductGraniteChipsToCartLink();
        cartPage.clickAddProductGraniteChipsToCartButton();
        cartPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product 'Awesome Granite Chips' is: " + cartPage.productPrice());
        double expectedTotal = cartPage.productPrice() + cartPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The tax price is: " + cartPage.taxPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price should be: " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price is: " + cartPage.totalPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The test will fail because tax price is not added to product price");

        assertEquals(cartPage.totalPrice(), expectedTotal);
    }
}

