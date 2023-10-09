package pl.senla.hotel.annotations.config;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

public class ConfigPropertyAnnotationLoader {

    private static final String EMPTY = "";
    private final String configDirectory;
    private final String configName;

    public ConfigPropertyAnnotationLoader(String configDirectory, String configName) {
        this.configName = configName;
        this.configDirectory = configDirectory;
    }

    public void load(Object configProperties) throws IllegalAccessException {
        Field[] fields = configProperties.getClass().getDeclaredFields();
        for (Field field : fields) {
            ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
            if (annotation != null) {
                field.setAccessible(true);
                String configFileName = annotation.configFileName();
                String propertyName = annotation.propertyName();
                String type = annotation.type();
                if (configName.equals(EMPTY)) {
                    setField(this.configDirectory, this.configName, field, propertyName, type, configProperties);
                } else {
                    setField(configDirectory, configFileName, field, propertyName, type, configProperties);
                }
            }
        }
    }

    public void loadConfiguration(Object configProperties) throws IllegalAccessException {
        Reflections reflections = new Reflections("pl.senla.hotel", new FieldAnnotationsScanner());

        Set<Field> fields = reflections.getFieldsAnnotatedWith(ConfigProperty.class);
        for (Field field : fields) {
            ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
            if (annotation != null) {
                field.setAccessible(true);
                String configFileName = annotation.configFileName();
                String propertyName = annotation.propertyName();
                String type = annotation.type();
                if (configName.equals(EMPTY)) {
                    setField(this.configDirectory, this.configName, field, propertyName, type, configProperties);
                } else {
                    setField(configDirectory, configFileName, field, propertyName, type, configProperties);
                }
            }
        }
    }

    private void setField(String configDirectory, String configName, Field field, String propertyName, String type,
                          Object configProperties) throws IllegalAccessException {
        Properties properties = loadProperty(configDirectory, configName);
        String fieldName = field.getName();
        String propertyValue;
        if (propertyName.equals(EMPTY)) {
            propertyValue = properties.getProperty(fieldName);
        } else {
            propertyValue = properties.getProperty(propertyName);
        }
        setFieldValue(field, propertyValue, type, configProperties);
    }

    private Properties loadProperty(String configDirectory, String configName) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(new File(configDirectory, configName))){
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    private void setFieldValue(Field field, String propertyValue, String type,
                               Object configProperties) throws IllegalAccessException {
        String typeEnum = type.toUpperCase();
        TypeOfField typeOfField = TypeOfField.valueOf(typeEnum);
        typeOfField.setField(field, propertyValue, configProperties);
    }

}
