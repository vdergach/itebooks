package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookInfoPage {

    WebDriver webDriver;
    WebDriverWait wait;

//    @FindBy(tagName = "title[value='']")
//    WebDriver titleBookInfoPage;

    public BookInfoPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    public void isCorrectPageOpened(){
//        Home Automation with Intel Galileo - Free Download eBook - pdf
//        System.out.println(webDriver.getTitle());
        webDriver.getTitle().equals("Home Automation with Intel Galileo - Free Download eBook - pdf");
    }
}
