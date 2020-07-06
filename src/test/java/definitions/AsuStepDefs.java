package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;


public class AsuStepDefs {

    AsuHeader header = new AsuHeader();
    AsuRfiForm form = new AsuRfiForm();
    AsuThankYouPage page = new AsuThankYouPage();
    Map<String, String> rfiInfo = getData("rfiInfo");
    Map<String, String> infoForm = getRfiForm("rfiInfo");


    @Given("I open the {string} page")
    public void iOpenThePage(String arg0) {
        header.open();
    }

    @When("I go to {string} form")
    public void iGoToForm(String arg0) {
        header.clickRequestInfoButton();
        header.moveToRfiForm();
    }

    @And("I select  degree,  area,  program in first step")
    public void iSelectDegreeAreaProgramInFirstStep() throws InterruptedException {
        form.chooseProgram(rfiInfo);
    }

    @And("i fill out fields in second step")
    public void iFillOutFieldsInSecondStep() {
        form.create(infoForm);
    }

    @And("I submit RFI form")
    public void iSubmitRFIForm() {
        form.submitForm();
    }

    @Then("I verify that Thank you page is displayed")
    public void iVerifyThatThankYouPageIsDisplayed() {
        boolean isDisplayed = page.isGreetingsDisplayed();
        assertThat(isDisplayed).isTrue();
    }
}

