package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "input[value='title']")
    WebElement titleRadioButton;

    @FindBy(css = "input[value='author']")
    WebElement authorRadioButton;

    @FindBy(css = "input[value='isbn']")
    WebElement isbnRadioButton;

    @FindBy(css = "input[value='google']")
    WebElement googleRadioButton;

    @FindBy(css = "input[value='isbndirectory']")
    WebElement isbndirectoryRadioButton;

    @FindBy(id = "q")
    WebElement searchInputField;

    @FindBy(css = "input[type='submit']")
    WebElement searchButton;

    public MainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }
    public void switchSearchToTitle(){
        titleRadioButton.click();
    }

    public void enterSearchableText(String text) throws InterruptedException {
        searchInputField.clear();
        searchInputField.sendKeys(text);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public void checkAllRadioButtons() throws InterruptedException {
        titleRadioButton.click();
        Thread.sleep(500);
        authorRadioButton.click();
        Thread.sleep(500);
        isbnRadioButton.click();
        Thread.sleep(500);
        googleRadioButton.click();
        Thread.sleep(500);
        isbndirectoryRadioButton.click();
        Thread.sleep(500);
    }
}
