package pages;

import org.openqa.selenium.WebDriver;

public class BooksSite {
    WebDriver webDriver;

    public BooksSite(WebDriver driver){
        webDriver = driver;
    }

    public MainPage mainPage(){ return new MainPage(webDriver); }
    public SearchResultsPage searchResultsPage(){return new SearchResultsPage(webDriver);}
    public BookInfoPage bookInfoPage(){return new BookInfoPage(webDriver);}
}
