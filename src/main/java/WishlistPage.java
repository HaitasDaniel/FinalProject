import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BasePage {

    public WebDriverWait wait;

    public WishlistPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement addProductGraniteChipsToWishlistLink;

    public void clickAddProductGraniteChipsToWishlistLink() {
        addProductGraniteChipsToWishlistLink.click();
    }


    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x")
    private WebElement addProductGraniteChipsToWishlistButton;

    public void clickAddToWishlistButton() {
        addProductGraniteChipsToWishlistButton.click();
    }

    @FindBy(xpath = ("//svg[@data-icon='heart-broken']"))
    private WebElement productAddedToWishlistSymbol;

    public WebElement getProductAddedToWishlistSymbol() {
        return productAddedToWishlistSymbol;
    }

    public boolean isProductAddedToWishlist() {
        wait.until(ExpectedConditions.visibilityOf(productAddedToWishlistSymbol));
        return productAddedToWishlistSymbol.isDisplayed();
    }

    public boolean isProductRemovedFromWishlist() {
        wait.until(ExpectedConditions.invisibilityOf(productAddedToWishlistSymbol));
        return !productAddedToWishlistSymbol.isDisplayed();

    }
}