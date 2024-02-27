package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static Properties props = new Properties();

    public Properties getProps() throws IOException {
        InputStream inputStream = null;
        String propsFileName = "config.properties";

        if(props.isEmpty()) {
            try {
                inputStream = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        return props;
    }
}
