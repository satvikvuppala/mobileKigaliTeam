package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FormPage;

public class Form {
    FormPage formPage = new FormPage();

    @When("the user taps on Forms link")
    public void the_user_taps_on_forms_link() {
        formPage.navigateToFormsPage();
    }

    @When("the user fills the form")
    public void the_user_fills_the_form() {
        formPage.typeInInputField();
        formPage.turnOnSwitch();
        formPage.selectItemFromDropdown();
    }

    @When("the user taps on Active button")
    public void the_user_taps_on_active_button() {
        formPage.tapActiveBtn();
    }

    @When("the user taps on OK button from the popup")
    public void the_user_taps_on_ok_button_from_the_popup() {
        formPage.closePopup();
    }

    @Then("popup should close")
    public void popup_should_close() {
        formPage.isPopupClosed();
    }
}
