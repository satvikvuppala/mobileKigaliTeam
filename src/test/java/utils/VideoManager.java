package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;

import io.appium.java_client.screenrecording.CanRecordScreen;

public class VideoManager {

    public void startRecording(){
        ((CanRecordScreen) new DriverManager().getDriver()).startRecordingScreen();
    }

    public void stopRecording(String scenarioName) throws IOException {
        GlobalParams params = new GlobalParams();
        String media = ((CanRecordScreen) new DriverManager().getDriver()).stopRecordingScreen();
        String dirPath = "target/reports/videos" + File.separator + params.getDeviceName();

        File videoDir = new File(dirPath);

        synchronized(videoDir){
            if(!videoDir.exists()) {
                videoDir.mkdirs();
            }
        }
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(videoDir + File.separator + scenarioName + ".mp4");
            stream.write(Base64.decodeBase64(media));
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stream != null) {
                stream.close();
            }
        }
    }
}
