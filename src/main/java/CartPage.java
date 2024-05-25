import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage extends BasePage {

    public WebDriverWait wait;

    public CartPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    // ADD Awesome Granite Chips Product To Cart Test
    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement addProductGraniteChipsToCartLink;

    public void clickAddProductGraniteChipsToCartLink() {
        addProductGraniteChipsToCartLink.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addProductGraniteChipsToCartButton;

    public void clickAddProductGraniteChipsToCartButton() {
        addProductGraniteChipsToCartButton.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }

    @FindBy(id = "item_1_title_link")
    private WebElement graniteChipsProduct;

    public WebElement getGraniteChipsProduct() {
        return graniteChipsProduct;
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement checkOutButton;

    public WebElement getCheckOutButton() {
        return checkOutButton;
    }

    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemsTotal;

    public WebElement getItemsTotal() {
        return itemsTotal;
    }

    public double productPrice() {
        String amountValue = itemsTotal.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);

    }

    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement plusQuantity;

    public void clickPlusQuantity() {
        plusQuantity.click();
    }

    @FindBy(xpath = "(//td[@class='amount'])[2]")
    private WebElement taxAmount;

    public double taxPrice() {
        String taxValue = taxAmount.getText();
        String cleanTaxValue = taxValue.replace("$", "");
        return Double.parseDouble(cleanTaxValue);


    }

    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement totalAmount;

    public double totalPrice() {
        String totalValue = totalAmount.getText();
        String cleanTotalValue = totalValue.replace("$", "");
        return Double.parseDouble(cleanTotalValue);
    }

    @FindBy(css = ".svg-inline--fa.fa-minus-circle.fa-w-16")
    private WebElement minusButton;

    public void clickMinusButton() {minusButton.click();}

    @FindBy(css = ".text-center.container")
    private WebElement addProductsToCartText;

    public WebElement getAddProductsToCartText(){return addProductsToCartText;}
}