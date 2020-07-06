package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public class Page {

    protected String url;
    protected String title;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public void waitingToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        waitingToBeClickable(element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            jsclick(element);
        }
    }

    public void jsclick(WebElement element) {
        getExecutor().executeScript("arguments [0].click();", element);
    }

    public void scrollTo(WebElement element) {
        getExecutor().executeScript("arguments [0].scrollIntoView();", element);
    }
}


