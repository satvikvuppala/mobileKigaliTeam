package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public AppiumDriverLocalService getServer() {
        return server.get();
    }

    public void startServer() {
        int maxRetries = 5;
        int attempt = 0;

        while (attempt < maxRetries) {
            try {
                AppiumDriverLocalService server = getAppiumService();
                server.start();

                if (server.isRunning()) {
                    ServerManager.server.set(server);
                    break; // Exit the loop if the server started successfully
                }
            } catch (Exception e) {
                // Handle the exception (you might want to log it)
                System.out.println("[WARNING]FAILED TO START APPIUM SERVER. RETRYING...");

                // Increment the attempt count
                attempt++;

                // Wait for a specified delay before retrying
                try {
                    Thread.sleep(5000); // 5 seconds delay, adjust as needed
                } catch (InterruptedException ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        if (attempt == maxRetries) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "[ERROR] APPIUM SERVER NOT STARTED AFTER MAXIMUM NUMBER OF RETRIES. ABORTING...");
        }
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService getAppiumService() {
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE));
    }
}
