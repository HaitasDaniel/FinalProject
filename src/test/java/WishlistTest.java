import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)
public class WishlistTest extends Hooks {

    public WishlistPage wishlistPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        wishlistPage = new WishlistPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Add product to wishlist using 'Awesome Granite Chips'")
    public void addProductToWishlistTest() throws InterruptedException { // InterruptedException e pentru threadsleep, se poate sterge daca nu il folosesti.
    wishlistPage.clickAddProductGraniteChipsToWishlistLink();
    wishlistPage.clickAddToWishlistButton();
//        boolean isProductAdded = wishlistPage.isProductAddedToWishlist();
//        Assert.assertTrue(isProductAdded, "The product should be added to the wishlist.");
    Thread.sleep(2000);
    }

    @Test(description = "Remove a product from wishlist using 'Awesome Granite Chips'")
    public void removeProductFromWishlistTest() throws InterruptedException { // InterruptedException e pentru threadsleep, se poate sterge daca nu il folosesti.
        wishlistPage.clickAddProductGraniteChipsToWishlistLink();
        wishlistPage.clickAddToWishlistButton();
//    assertEquals(wishlistPage.getProductAddedToWishlistSymbol();
//    assertEquals("Awesome Granite Chips", wishlistPage.getAwesomeGraniteChipsLink();
        Thread.sleep(2000);
    }
        }

