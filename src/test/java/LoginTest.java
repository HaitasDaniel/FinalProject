import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description ="Simple login by using registered credentials" )
    public void loginTestWithCorrectCredentials() throws InterruptedException { // InterruptedException e pentru threadsleep, se poate sterge daca nu il folosesti.
      loginPage.clickLoginButton();
      loginPage.fillUsernameField();
      loginPage.fillPasswordField();
      loginPage.clickLoginButton2();
      assertEquals("dino", loginPage.getHiDino().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The user receive a greetings message 'Hi Dino!' after correct credentials were filled");
      loginPage.clickUsernameButton();
      assertEquals("Account", loginPage.getAccountText().getText());
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The user can access the account page by clicking on the username");

    }
    @Test(description ="Login by using correct username and wrong password" )
    public void loginWithCorrectUsernameAndWrongPasswordTest() throws InterruptedException {
        loginPage.clickLoginButton();
        loginPage.fillUsernameField();
        loginPage.fillWrongPasswordField();
        loginPage.clickLoginButton2();
       assertEquals("Incorrect username or password!", loginPage.getErrorNotification().getText());
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The user cant access the account page and it is notified with following text: ' Incorrect username or password!' " );
    }
    }

