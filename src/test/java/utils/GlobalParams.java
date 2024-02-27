package utils;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();

    public void setPlatformName(String platformName1) {
        platformName.set(platformName1);
    }

    public String getPlatformName() {
        return platformName.get();
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }

    public void initializeGlobalParams() {
        GlobalParams params = new GlobalParams();
        params.setPlatformName("Android");
        params.setDeviceName(System.getProperty("deviceName", "Pixel7"));
        params.setSystemPort("10000");
    }
}
