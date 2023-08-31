package ru.cashdance.config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_LIMIT = "db.limit";
    public static final String CD_URL = "cd.url";

    public static Properties properties = new Properties();

    // TODO Understand what is Property, InputStream
    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            try (InputStream is = Config.class.getClassLoader()
                    .getResourceAsStream("config.properties")) {
                properties.load(is);


            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return properties.getProperty(name);
    }
}
