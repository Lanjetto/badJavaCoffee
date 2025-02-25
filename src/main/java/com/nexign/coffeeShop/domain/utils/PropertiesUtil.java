package com.nexign.coffeeShop.domain.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    private PropertiesUtil(){

    }
    static {
        loadProperties();
    }

    private static void loadProperties()  {
        try (var resource = PropertiesUtil.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            PROPERTIES.load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
