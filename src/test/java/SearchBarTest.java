import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)


public class SearchBarTest extends Hooks {

    public SearchBarPage searchBarPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        searchBarPage = new SearchBarPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Searching the keyword 'mouse' (should return 2 results)" )
    public void searchKeywordMouseTest() throws InterruptedException {
        searchBarPage.fillSearchBar();
        searchBarPage.clickSearchButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Search after 'mouse' keyword filled");
        assertEquals("Refined Frozen Mouse", searchBarPage.getFrozenMouse().getText());
        assertEquals("Practical Metal Mouse", searchBarPage.getMetalMouse().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The expected 'Refined Frozen Mouse' and 'Practical Metal Mouse' products were found");
        Thread.sleep(2000);

        }

}



