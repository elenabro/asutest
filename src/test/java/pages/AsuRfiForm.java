package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static support.TestContext.*;

public class AsuRfiForm extends Page {

    @FindBy(xpath = "//*[@id='degree-type']")
    private WebElement degreeTypeField;

    @FindBy(xpath = "//*[@id='interest-area']")
    private WebElement interestAreaField;

    @FindBy(xpath = "//*[@id='program']")
    private WebElement programField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='asuonline_phone_number']")
    private WebElement phone;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='programs-group']//div[contains(text(),'This is a required field.')]")
    private WebElement errorMessage;


    public void chooseProgram(Map<String, String> rfiFormInfo) {
        degreeTypeField.click();
        new Select(degreeTypeField).selectByValue(rfiFormInfo.get("degree"));

        interestAreaField.click();
        new Select(interestAreaField).selectByValue(rfiFormInfo.get("area"));

        programField.click();
        scrollTo(programField);
        new Select(programField).selectByVisibleText(rfiFormInfo.get("program"));

        continueButton.click();
    }

    public void create(Map<String, String> rfiForm) {
        firstName.sendKeys(rfiForm.get("first name"));
        lastName.sendKeys(rfiForm.get("last name"));
        email.sendKeys(rfiForm.get("email"));
        phone.sendKeys(rfiForm.get("phone"));
    }

    public void submitForm() {
        getActions().moveToElement(submitButton).perform();
        click(submitButton);
    }

    public void chooseProgramRequired(Map<String, String> rfiFormInfo) {
        programField.click();
        scrollTo(programField);
        new Select(programField).selectByVisibleText(rfiFormInfo.get("program"));

        continueButton.click();
    }

    public void chooseProgramReqFieldError(Map<String, String> rfiFormInfo) {
        degreeTypeField.click();
        new Select(degreeTypeField).selectByValue(rfiFormInfo.get("degree"));

        interestAreaField.click();
        new Select(interestAreaField).selectByValue(rfiFormInfo.get("area"));

        programField.click();
        scrollTo(programField);
        new Select(programField).selectByVisibleText(rfiFormInfo.get("program"));
        new Select(programField).selectByVisibleText(rfiFormInfo.get("programError"));
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}




