
package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props;

    static {
        try {
            props = new Properties();
            InputStream in = new FileInputStream("src/test/resources/config.properties");
            props.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
