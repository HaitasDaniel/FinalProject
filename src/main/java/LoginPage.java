import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy (css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    private WebElement loginButton;

    public void clickLoginButton() { loginButton.click();}


    @FindBy (id = "user-name")
    private WebElement usernameField;

    public void fillUsernameField() { usernameField.sendKeys("dino");}

    @FindBy (id = "password")
    private WebElement passwordField;

    public void fillPasswordField() { passwordField.sendKeys("choochoo");}
    @FindBy (id = "password")
    private WebElement wrongPasswordField;

    public void fillWrongPasswordField() { wrongPasswordField.sendKeys("parola");}

    @FindBy (css = ".btn.btn-primary")
    private WebElement loginButton2;

    public void clickLoginButton2() {loginButton2.click();}

    @FindBy (linkText = "dino")
    private WebElement hiDino;

    public WebElement getHiDino () {
        return hiDino;
    }

    @FindBy (linkText = "dino")
    private WebElement usernameButton;

    public void clickUsernameButton() {usernameButton.click();}

    @FindBy (css = ".text-muted")
    private WebElement accountText;

    public WebElement getAccountText() {return accountText;}

    @FindBy(css = ".error")
    private WebElement errorNotification;

    public WebElement getErrorNotification() {return errorNotification;}
}