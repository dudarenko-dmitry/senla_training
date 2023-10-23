package pl.senla.hotel.annotations.config;

import pl.senla.hotel.annotations.AnnotationScanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Set;

public class ConfigPropertyAnnotationLoader {

    private static ConfigPropertyAnnotationLoader configPropertyAnnotationLoader;
    private static final String EMPTY = "";
    private final AnnotationScanner annotationScanner;
    private final String configDirectory;
    private final String configName;

    private ConfigPropertyAnnotationLoader(String configDirectory, String configName) {
        this.annotationScanner = new AnnotationScanner();
        this.configName = configName;
        this.configDirectory = configDirectory;
    }

    public static synchronized ConfigPropertyAnnotationLoader getConfigPropertyAnnotationLoader
            (String configDirectory, String configName) {
        if (configPropertyAnnotationLoader == null) {
            configPropertyAnnotationLoader = new ConfigPropertyAnnotationLoader(configDirectory, configName);
        }
        return configPropertyAnnotationLoader;
    }

    public void load() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Field> fields = annotationScanner.getAnnotatedPropertyFields();
        for (Field field : fields) {
            ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
            if (annotation != null) {
                Class<?> declaringClass = field.getDeclaringClass();
                Object object;
                try {
                    Constructor<?> constructor = declaringClass.getConstructor();
                    object = constructor.newInstance();
                } catch (NoSuchMethodException e) {
                    object = null;
                }
                field.setAccessible(true);
                String configFileName = annotation.configFileName();
                String propertyName = annotation.propertyName();
                String type = annotation.type();
                if (configName.equals(EMPTY)) {
                    setField(this.configDirectory, this.configName, field, propertyName, type, object);
                } else {
                    setField(configDirectory, configFileName, field, propertyName, type, object);
                }
            }
        }
    }

    private void setField(String configDirectory, String configName, Field field, String propertyName, String type,
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
        try (FileInputStream fis = new FileInputStream(new File(configDirectory, configName))){
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
