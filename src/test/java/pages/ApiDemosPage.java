package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class ApiDemosPage extends BasePage {

    By viewsLinkBy = AppiumBy.accessibilityId("Views");
    By dragAndDropBy = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]");
    By preferenceLinkBy = AppiumBy.accessibilityId("Preference");
    By preferenceDependenciesLinkBy = AppiumBy.accessibilityId("3. Preference dependencies");
    By galleryLinkBy = AppiumBy.accessibilityId("Gallery");
    By photosLinkBy = AppiumBy.accessibilityId("1. Photos");
    By firstImageBy = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]");
    By secondImageBy = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[2]");

    public ApiDemosPage navigateToViews() {
        getElement(viewsLinkBy).click();
        return this;
    }

    public DragAndDropPage navigateToDragAndDrop() {
        getElement(dragAndDropBy).click();
        return new DragAndDropPage();
    }

    public void navigateToPreference() {
        getElement(preferenceLinkBy).click();
    }

    public void scrollToWebViews() throws InterruptedException {
        scrollUntilVisibilityOf("WebView");
    }

    public void navigateToGallery() {
        getElement(galleryLinkBy).click();
    }

    public void navigateToPhotos() {
        getElement(photosLinkBy).click();
    }

    public void swipeFirstImageLeft() {
        swipe(firstImageBy, "left");
    }

    public void isImageSwiped() {
        String firstImageFocusable = getElement(firstImageBy).getAttribute("focusable");
        String secondImageFocusable = getElement(secondImageBy).getAttribute("focusable");
        assertEquals(firstImageFocusable, "false");
        assertEquals(secondImageFocusable, "true");
    }

    public void navigateToPreferencesDependencies() {
        getElement(preferenceDependenciesLinkBy).click();
    }
}
