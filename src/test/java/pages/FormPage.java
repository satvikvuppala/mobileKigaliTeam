package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class FormPage extends BasePage {
    By formsLinkBy = AppiumBy.xpath("//android.widget.TextView[@text=\"Forms\"]");
    By inputFieldBy = AppiumBy.accessibilityId("text-input");
    By inputFieldResultBy = AppiumBy.accessibilityId("input-text-result");
    By DropdownBy = AppiumBy.xpath("//android.widget.EditText[@text=\"Select an item...\"]");
    By dropdownOptionBy = AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"Appium is awesome\"]");
    By toggleBtnBy = AppiumBy.accessibilityId("switch");
    By switchTextBy = AppiumBy.accessibilityId("switch-text");
    By activeBtnBy = AppiumBy.xpath("//android.widget.TextView[@text=\"Active\"]");
    By okBtnBy = AppiumBy.xpath("//android.widget.Button[@text=\"OK\"]");
    By alertTitleBy = AppiumBy.xpath("//android.widget.TextView[@text=\"This button is\"]");

    public void navigateToFormsPage() {
        getElement(formsLinkBy).click();
    }

    public void typeInInputField() {
        String text = "Testing";
        addTextToField(inputFieldBy, text);
        WebElement inputFieldResults = getElement(inputFieldResultBy);
        checkSimilarityOfText(text, inputFieldResults.getText());
    }

    public void turnOnSwitch() {
        getElement(toggleBtnBy).click();
        String actualSwitchText = getElement(switchTextBy).getText();
        String expectedSwitchText = "Click to turn the switch OFF";
        checkSimilarityOfText(expectedSwitchText, actualSwitchText);
    }

    public void selectItemFromDropdown() {
        getElement(DropdownBy).click();
        getElement(dropdownOptionBy).click();
    }

    public void tapActiveBtn() {
        getElement(activeBtnBy).click();
    }

    public void closePopup() {
        getElement(okBtnBy).click();
    }

    public void isPopupClosed() {
        String isDisplayed = getElement(inputFieldBy).getAttribute("displayed");
        assertTrue(isDisplayed.contains("true"));
    }
}
