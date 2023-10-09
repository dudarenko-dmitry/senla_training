package pl.senla.hotel.configuration;

import pl.senla.hotel.annotations.di.AppComponent;

import java.util.Properties;

@AppComponent
public class AppConfiguration implements Configuration{

    private static AppConfiguration appConfiguration;
    private final Properties properties;

    private AppConfiguration() {
        PropertiesLoader propertiesLoader = new AppPropertiesLoader();
        properties = propertiesLoader.loadConfiguration();
    }

    public static AppConfiguration getSingletonInstance() {
        if (appConfiguration == null) {
            appConfiguration = new AppConfiguration();
        }
        return appConfiguration;
    }

    @Override
    public Boolean getBooleanProperty(String propertyName) {
        return Boolean.valueOf(properties.getProperty(propertyName));
    }

    @Override
    public String getStringProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    @Override
    public int getIntegerProperty(String propertyName) {
        return Integer.parseInt(properties.getProperty(propertyName));
    }
}
