package hooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import utils.GlobalParams;
import utils.ServerManager;
import utils.VideoManager;

public class Hooks {
    @Before
    public void initialize(Scenario scenario) throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        String appName = getAppName(scenario);

        new ServerManager().startServer();
        new DriverManager().initializeDriver(appName);
        new VideoManager().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        new VideoManager().stopRecording(scenario.getName());

        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
    }

    private String getAppName(Scenario scenario) {
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.startsWith("@App_")) {
                return tag.substring(5);
            }
        }

        return "";
    }
}
