package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static support.TestContext.getActions;

public class AsuHeader extends Page {

    public AsuHeader(){
        url = "https://asuonline.asu.edu/";
        title = "ASU Online | Arizona State University";
    }


    @FindBy(xpath = "//a[contains(text(),'Request info')]")
    private WebElement requestInfoButton;


    @FindBy(xpath = "//form[@id='asuo-rfi']")
    private WebElement rfiForm;


    public void clickRequestInfoButton() {
        requestInfoButton.click();
    }

    public void moveToRfiForm() {
        getActions().moveToElement(rfiForm).perform();
    }
}

