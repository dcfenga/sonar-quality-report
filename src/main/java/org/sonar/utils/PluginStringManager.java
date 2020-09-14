package org.sonar.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * String manager for sonar-quality-report
 */
public class PluginStringManager {
    private static Properties properties = new Properties();

    private PluginStringManager() {
        throw new IllegalStateException("Utility class");
    }

    protected static final Logger LOGGER = Logger.getLogger(PluginStringManager.class.getCanonicalName());

    static {
        final ClassLoader classLoader = PluginStringManager.class.getClassLoader();

        // load properties file as a stream
        try (InputStream is = classLoader.getResourceAsStream("plugin.properties")) {
            if (is != null) {
                properties.load(is);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static String getProperty(String p) {
        return properties.getProperty(p);
    }
}