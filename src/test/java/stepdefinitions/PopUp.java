package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApiDemosPage;
import pages.PreferenceDependeciesPage;

public class PopUp {
    @When("a user taps on preference link")
    public void a_user_taps_on_preference_link() {
        new ApiDemosPage().navigateToPreference();
    }

    @When("the user taps on preference dependencies link")
    public void the_user_taps_on_preference_dependencies_link() {
        new ApiDemosPage().navigateToPreferencesDependencies();
    }

    @When("the user checks the WIFI checkbox")
    public void the_user_checks_the_wifi_checkbox() {
        new PreferenceDependeciesPage().activateWifi();
    }

    @When("the user taps on WIFI settings")
    public void the_user_taps_on_wifi_settings() {
        new PreferenceDependeciesPage().openWifiSettingsPopUp();
    }

    @When("the user enters their WIFI settings name as {string}")
    public void the_user_enters_their_wifi_settings_name_as(String string) {
        new PreferenceDependeciesPage().addWifiSettingsName(string);
    }

    @When("the user taps on OK button")
    public void the_user_taps_on_ok_button() {
        new PreferenceDependeciesPage().clickOkBtn();
    }

    @Then("WIFI settings should be saved")
    public void wifi_settings_should_be_saved() throws Exception {
        new PreferenceDependeciesPage().openWifiSettingsPopUp();
        new PreferenceDependeciesPage().isWifiNameSaved();
    }
}
