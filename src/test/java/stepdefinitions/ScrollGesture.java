package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.ApiDemosPage;

public class ScrollGesture {
    
    @Then("the user should be able to scroll down and see WebView link")
    public void the_user_should_be_able_to_scroll_down_and_see_web_view_link() throws InterruptedException {
        new ApiDemosPage().scrollToWebViews();
    }
}
