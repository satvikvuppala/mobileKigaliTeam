package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class PreferenceDependeciesPage extends BasePage {
    By wifiCheckboxBy = AppiumBy.id("android:id/checkbox");
    By wifiSettingsLinkBy = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout");

    By wifiSettingNameFieldBy = AppiumBy.id("android:id/edit");
    By okBtnBy = AppiumBy.id("android:id/button1");
    
    public void openWifiSettingsPopUp() {
        getElement(wifiSettingsLinkBy).click();
    }

    public void addWifiSettingsName(String name) {
        addTextToField(wifiSettingNameFieldBy, name);
    }

    public void clickOkBtn() {
        getElement(okBtnBy).click();
    }

    public void isWifiNameSaved() throws Exception {
        String value = getTextValueOfField(wifiSettingNameFieldBy);
        if(!value.contains("Norrsken")) {
            throw new Exception("[ERROR] Wifi Settings Name Not Saved!");
        }
    }

    public void activateWifi() {
        getElement(wifiCheckboxBy).click();
    }
}
