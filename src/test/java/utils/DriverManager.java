package utils;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public void initializeDriver(String appName) throws Exception {
        AppiumDriver driver = null;

        if(driver == null) {
            try {
                driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCapabilities(appName));
                DriverManager.driver.set(driver);
            }
            catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

}
