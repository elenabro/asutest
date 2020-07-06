package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsuThankYouPage extends Page {

    @FindBy(xpath = "//h1[contains(text(), 'Thank you')]")
    private WebElement greetings;

    public boolean isGreetingsDisplayed() {
        try {
            return greetings.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
