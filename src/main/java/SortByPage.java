import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortByPage extends BasePage {

    public WebDriverWait wait;

    public SortByPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortProductsDropDown;

    public WebElement getSortProductsDropDown() {
        return sortProductsDropDown;
    }

    @FindBy(xpath = "//span[text()='1.99']")
    private WebElement lowestPrice;

    public WebElement getLowestPrice (){ return lowestPrice;}

    @FindBy(xpath = "//span[text()='29.99']")
    private WebElement highestPrice;

    public WebElement getHighestPrice (){ return highestPrice;}

    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement sortAtoZProduct;

    public WebElement getSortAtoZProduct(){return sortAtoZProduct;}
    @FindBy(linkText = "Refined Frozen Mouse")
    private WebElement sortZtoAProduct;

    public WebElement getSortZtoAProduct(){return sortZtoAProduct;}
}