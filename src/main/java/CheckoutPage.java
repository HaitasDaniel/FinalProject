import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement checkoutButton;

    public void clickCheckoutButton() {
        checkoutButton.click();
    }


    @FindBy(id = "first-name")
    private WebElement firstNameField;

    public void enterFirstNameField() {
        firstNameField.sendKeys("Daniel");
    }

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    public void enterLastNameField() {
        lastNameField.sendKeys("Haitas");
    }

    @FindBy(id = "address")
    private WebElement addressField;

    public void enterAddressField() {
        addressField.sendKeys("Cluj-Napoca, str. Primaverii, nr. 22, ap. 12, jud. Cluj");
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement continueCheckoutButton;

    public void clickContinueCheckoutButton() {
        continueCheckoutButton.click();
    }

    @FindBy(css = ".text-muted")
    private WebElement orderSummaryText;

    public WebElement getOrderSummaryText() {
        return orderSummaryText;
    }

    @FindBy(css = ".error")
    private WebElement errorNotify;

    public WebElement getErrorNotify() {
        return errorNotify;
    }


    @FindBy(className= "text-muted")
    private WebElement orderCompleteNotify;

    public WebElement getOrderCompleteNotify() {return orderCompleteNotify;}

    @FindBy(css = ".btn.btn-success")
    private WebElement completeOrderButton;

    public void clickCompleteOrderButton () {completeOrderButton.click();}

    @FindBy(css= ".svg-inline--fa.fa-heart.fa-w-16.fa-3x")
    private WebElement addToWishlistButton;

    public void clickAddToWishlistButton () {addToWishlistButton.click();}

    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16")
    private WebElement resetButton;

    public void clickResetButton(){resetButton.click();}

    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);


    }
}