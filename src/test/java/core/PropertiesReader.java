package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <h1>Properties Reader</h1>
 * This class provides the methods to read properties file
 *
 * @author bsa
 * @version 1.0
 * @since 2022-06-11
 */
public class PropertiesReader {

    private static PropertiesReader instance = null;
    private final Properties properties;
    private final Properties envProperties;

    private PropertiesReader() {
        this.properties = new Properties();
        this.envProperties = new Properties();

        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("configs.properties");
            if (inputStream == null) {
                throw new IOException("configs.properties not found in classpath");
            }
            this.properties.load(inputStream);

            // Try env-configs.properties first; fall back to env-configs.properties.default
            InputStream myInputStream = this.getClass().getClassLoader().getResourceAsStream("env-configs.properties");
            if (myInputStream == null) {
                System.out.println("[PropertiesReader] env-configs.properties not found, falling back to env-configs.properties.default");
                myInputStream = this.getClass().getClassLoader().getResourceAsStream("env-configs.properties.default");
            }
            if (myInputStream == null) {
                throw new IOException("Neither env-configs.properties nor env-configs.properties.default found in classpath");
            }
            this.envProperties.load(myInputStream);
        } catch (IOException e) {
            Report.log(e.getMessage());
        }
    }

    public static synchronized PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getValue(String key) {
        String value = this.properties.getProperty(key, null);
        if (value == null) {
            throw new IllegalArgumentException(String.format("The env key %s does not exist!", key));
        }
        return value;
    }

    public String getEnvValue(String key) {
        String value = this.envProperties.getProperty(key, null);
        if (value == null) {
            throw new IllegalArgumentException(String.format("The env key %s does not exist!", key));
        }
        return value;
    }
}
