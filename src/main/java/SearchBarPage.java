import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBarPage extends BasePage {

    public WebDriverWait wait;

    public SearchBarPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "input-search")
    private WebElement searchBar;

    public void fillSearchBar() {
        searchBar.sendKeys("mouse");
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;
    public void clickSearchButton() {
        searchButton.click();
    }
    @FindBy (linkText = "Refined Frozen Mouse")
    private WebElement frozenMouse;

    public WebElement getFrozenMouse (){
        return frozenMouse;
    }
    @FindBy (linkText = "Practical Metal Mouse")
    private WebElement metalMouse;

    public WebElement getMetalMouse () {
        return metalMouse;
    }

}