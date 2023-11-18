package pl.senla.hotel.application.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

@Slf4j
public class ConfigPropertyAnnotationLoader {

    private static ConfigPropertyAnnotationLoader configPropertyAnnotationLoader;
    private static final String EMPTY = "";

    private ConfigPropertyAnnotationLoader() {
    }

    public static synchronized ConfigPropertyAnnotationLoader getConfigPropertyAnnotationLoader() {
        if (configPropertyAnnotationLoader == null) {
            log.debug("Create ConfigProperties.");
            configPropertyAnnotationLoader = new ConfigPropertyAnnotationLoader();
        }
        return configPropertyAnnotationLoader;
    }

    public void setField(String configDirectory, String configName, Field field, String propertyName, String type,
                         Object object) throws IllegalAccessException {
        Properties properties = loadProperty(configDirectory, configName);
        String fieldName = field.getName();
        String propertyValue;
        if (propertyName.equals(EMPTY)) {
            propertyValue = properties.getProperty(fieldName);
        } else {
            propertyValue = properties.getProperty(propertyName);
        }
        setFieldValue(field, propertyValue, type, object);
    }

    private Properties loadProperty(String configDirectory, String configName) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(new File(configDirectory, configName))) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    private void setFieldValue(Field field, String propertyValue, String type,
                               Object object) throws IllegalAccessException {
        String typeEnum = type.toUpperCase();
        TypeOfField typeOfField = TypeOfField.valueOf(typeEnum);
        typeOfField.setField(field, propertyValue, object);
    }

}
