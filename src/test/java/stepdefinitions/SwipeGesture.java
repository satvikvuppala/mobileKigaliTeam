package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApiDemosPage;

public class SwipeGesture {

    @When("the user taps on Gallery link")
    public void the_user_taps_on_gallery_link() {
        new ApiDemosPage().navigateToGallery();
    }

    @When("the user taps on Photos link")
    public void the_user_taps_on_photos_link() {
        new ApiDemosPage().navigateToPhotos();
    }

    @When("the user swipes left on the first image")
    public void the_user_swipes_left_on_the_first_image() {
        new ApiDemosPage().swipeFirstImageLeft();
    }

    @Then("the second image should be in focus")
    public void the_second_image_should_be_in_focus() {
        new ApiDemosPage().isImageSwiped();
    }
}
