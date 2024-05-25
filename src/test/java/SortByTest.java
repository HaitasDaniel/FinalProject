import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)


public class SortByTest extends Hooks {

    public SortByPage sortByPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        sortByPage = new SortByPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Sorting products in order from lowest price to highest price")
    public void sortByLowestPriceTest() throws InterruptedException {

        sortByPage.selectOption(sortByPage.getSortProductsDropDown(), "Sort by price (low to high)");
        assertEquals("1.99", sortByPage.getLowestPrice().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The order of products had successfully changed starting with the lowest product price at '1.99'");

        Thread.sleep(2000);

    }

    @Test(description = "Sorting products in order from highest price to lowest price")
    public void sortByHighestPriceTest() throws InterruptedException {

        sortByPage.selectOption(sortByPage.getSortProductsDropDown(), "Sort by price (high to low)");
        assertEquals("29.99", sortByPage.getHighestPrice().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The order of products had successfully changed starting with the highest product price at '29.99'");

        Thread.sleep(2000);

    }
    @Test(description = "Sorting products alphabetically from A to Z")
    public void sortByAToZTest() throws InterruptedException {

        sortByPage.selectOption(sortByPage.getSortProductsDropDown(), "Sort by name (A to Z)");
        assertEquals("Awesome Granite Chips", sortByPage.getSortAtoZProduct().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The order of products had successfully changed from A to Z, 'Awesome Granite Chips' being the first product");

        Thread.sleep(2000);

    }
    @Test(description = "Sorting products alphabetically from Z to A")
    public void sortByZToATest() throws InterruptedException {

        sortByPage.selectOption(sortByPage.getSortProductsDropDown(), "Sort by name (Z to A)");
        assertEquals("Refined Frozen Mouse", sortByPage.getSortZtoAProduct().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The order of products had successfully changed from Z to A, 'Refined Frozen Mouse' being the first product");

        Thread.sleep(2000);

    }
}



