package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApiDemosPage;
import pages.DragAndDropPage;

public class LongClickGesture {
    ApiDemosPage apiDemosPage = new ApiDemosPage();
    DragAndDropPage dragdropPage;
    @When("a user tap on views link")
    public void a_user_tap_on_views_link() {
        apiDemosPage.navigateToViews();
    }

    @When("the user tap on Drag and Drop link")
    public void the_user_tap_on_drag_and_drop_link() {
       dragdropPage = apiDemosPage.navigateToDragAndDrop();
    }

    @When("the user long clicks on the textless circle")
    public void the_user_long_clicks_on_the_textless_circle() {
        dragdropPage.longClickOnTextlessCircle();
    }

    @Then("the message {string} should be displayed")
    public void the_message_should_be_displayed(String string) {
        dragdropPage.isElementDropped(string);
    }
}
