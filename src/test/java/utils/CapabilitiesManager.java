package utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {
    public DesiredCapabilities getCapabilities(String appName) throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", params.getPlatformName());
            capabilities.setCapability("deviceName", params.getDeviceName());
            capabilities.setCapability("systemPort", Integer.parseInt(params.getSystemPort()));
            capabilities.setCapability("automationName", props.getProperty("androidAutomationName"));

            String androidAppUrl = null;
            if (appName.contains("wdiodemo")) {
                capabilities.setCapability("appPackage", "com.wdiodemoapp");
                capabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
                System.out.println(appName);
                androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                        + File.separator + "resources" + File.separator + "app" + File.separator + "wdiodemoapp.apk";
            } else {
                capabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
                capabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
                androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                        + File.separator + "resources" + File.separator + "app" + File.separator + "ApiDemos-debug.apk";
            }
            capabilities.setCapability("app", androidAppUrl);

            return capabilities;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
