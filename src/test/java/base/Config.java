package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Config {
    private static final String configName = "config.properties";
    private static final Logger log = LogManager.getLogger(Config.class);

    private URL baseUrl;

    public URL getBaseUrl() {
        return baseUrl;
    }

    private Duration timeout;

    public Duration getTimeout() {
        return timeout;
    }

    private static Config instance;

    private Config() {
        try (var propFileStream = Config.class.getClassLoader().getResourceAsStream(configName)) {
            var properties = new Properties();
            properties.load(propFileStream);

            baseUrl = new URL(properties.get("base-url").toString());
            timeout = Duration.ofSeconds(Long.valueOf(properties.get("timeout").toString()));
        } catch (IOException e) {
            log.error("Error during reading configuration file", e);
        }
    }

    public static Config Instance() {
        synchronized (Config.class) {
            if (instance == null) {
                instance = new Config();
            }
            return instance;
        }
    }
}
