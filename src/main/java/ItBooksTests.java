import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BooksSite;
import pages.MainPage;

public class ItBooksTests {

    WebDriver webDriver;
//    MainPage mainPage;
    BooksSite webSite;
    WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "F:\\learn\\auto\\drivers\\chromedriver.exe");

        webDriver = new ChromeDriver();
        webSite = new BooksSite(webDriver);
        wait = new WebDriverWait(webDriver, 30, 500);

        webDriver.get("http://it-ebooks.info/");

//        System.out.println(webDriver.getTitle());
//        System.out.println(webDriver.getCurrentUrl());
        System.out.println("Step 1: Switch to search by title");
        webSite.mainPage().switchSearchToTitle();
        System.out.println("Step 2: clear input field and insert Automation for search");
        webSite.mainPage().enterSearchableText("Automation");
        System.out.println("Step 3: Click on Search Button");
        webSite.mainPage().clickSearchButton();

//        webDriver.findElement(By.id("type")).click();
//        webDriver.findElement(By.id("q")).sendKeys(Keys.RETURN);


        System.out.println("Step 4: Wait for search results");
        webSite.searchResultsPage().waitForSearchResults();
    }

    @Test
    public void testBooksSearch() {
        System.out.println("Check quantity of results");
        Assert.assertTrue(webDriver.findElement(By.className("top")).findElements(By.tagName("tr")).size() == 10);
    }
    @Test
    public void testSearchBookUrl(){
        System.out.println("Check is Url contain value");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("search/?q=Automation&type=title"));
    }
    @Test
    public void testOpenBookInfoFromSearch(){
        System.out.println("Open Book info");
        webSite.searchResultsPage().openBookFromResultsBy("Home Automation with Intel Galileo");

        System.out.println("Wait for Page to load");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h1[itemprop='name']")));

        System.out.println("Check page title");
        webSite.bookInfoPage().isCorrectPageOpened();
        System.out.println("Title is correct");
    }
    @Test
    public void testAllRadioButtonsArePresented() throws InterruptedException {
        System.out.println("Check all radio buttons");
        webSite.mainPage().checkAllRadioButtons();
    }
    @Test
    public void testSearchResults(){
        System.out.println("Check that's all pages are available");
        webSite.searchResultsPage().allPagesAreAvailable("Raspberry Pi Home Automation with Arduino, 2nd Edition");
        webSite.searchResultsPage().allPagesAreAvailable("Home Automation with Intel Galileo");
        webSite.searchResultsPage().allPagesAreAvailable("DevOps Automation Cookbook");
        webSite.searchResultsPage().allPagesAreAvailable("Pragmatic Project Automation");
        webSite.searchResultsPage().allPagesAreAvailable("Smart Home Automation with Linux");
        webSite.searchResultsPage().allPagesAreAvailable(".NET Test Automation Recipes");
        webSite.searchResultsPage().allPagesAreAvailable("BMC Control-M 7");
        webSite.searchResultsPage().allPagesAreAvailable("Continuous Delivery");
        webSite.searchResultsPage().allPagesAreAvailable("Test iOS Apps with UI Automation");
        webSite.searchResultsPage().allPagesAreAvailable("Windows Server 2012 Automation with PowerShell Cookbook");
    }


        @After
    public void tearDown(){
        if (webDriver != null){
            webDriver.quit();
        }
    }
}
