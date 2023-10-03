package pl.senla.hotel.application.di;

import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.application.annotation.StartMethod;
import pl.senla.hotel.application.annotation.StartPoint;
import pl.senla.hotel.application.config.Configuration;
import pl.senla.hotel.application.config.DIConfiguration;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.properties.ConfigPropertyAnnotationLoader;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class DIContext {

    private static DIContext context;
    private final Configuration configuration = new DIConfiguration();
    private final AnnotationScanner annotationScanner;
    private final ConfigPropertyAnnotationLoader configLoader;
    private final Map<Class<?>, Object> DIContainer = new HashMap<>();
    private final String configDirectory = configuration.setPropertiesDirectory();
    private final String configName = configuration.setPropertiesFileName();

    private DIContext(){
        this.annotationScanner = new AnnotationScanner();
        this.configLoader = ConfigPropertyAnnotationLoader
                .getConfigPropertyAnnotationLoader();
    }

    public static synchronized DIContext getContext() {
        if (context == null) {
            context = new DIContext();
        }
        return context;
    }

    public void createDIContainer() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Set<Class<?>> classesForDIContainer = annotationScanner.getAnnotatedClasses();
        putClassesToDIContainer(DIContainer, classesForDIContainer);
        while (DIContainer.containsValue(null)) {
            for (Class<?> aClass : classesForDIContainer) {
                if (DIContainer.get(aClass) == null) {
                    Object bean = aClass.getConstructor().newInstance();
                    Field[] declaredFields = bean.getClass().getDeclaredFields();
                    int numberOfFields = declaredFields.length;
                    if (numberOfFields == 0) {
                        DIContainer.replace(aClass, bean);
                    } else {
                        int counter = 0;
                        for (Field f : declaredFields) {
                            GetInstance annotationGetInstance = f.getAnnotation(GetInstance.class);
                            if (annotationGetInstance != null) {
                                Class<?> fullFieldClassName = getFullClassName(annotationGetInstance);
                                if (DIContainer.get(fullFieldClassName) != null) {
                                    setFieldValue(f, fullFieldClassName, bean);
                                    counter++;
//                                } else {
//                                    System.out.println("Error: there is no such bean in DIContainer yet");
                                }
                            } else {
                                ConfigProperty annotationProperty = f.getAnnotation(ConfigProperty.class);
                                if (annotationProperty != null) {
                                    f.setAccessible(true);
                                    String configFileName = annotationProperty.configFileName();
                                    String propertyName = annotationProperty.propertyName();
                                    String type = annotationProperty.type();
                                    System.out.println("Set value of " + propertyName + " from Properties");
                                    configLoader.setField(configDirectory, configFileName, f, propertyName, type, bean);
                                }
                                counter++;
                            }
                        }
                        if (counter == numberOfFields) {
                            DIContainer.replace(aClass, bean);
                            System.out.println("Class " + aClass.getTypeName() +
                                    " and his Bean have been added to DIContainer!");
//                        } else {
//                            System.out.println("Some of Fields is not in Container yet");
                        }
                    }
                }
            }
        }
    }

    public void injectValuesFromDIContainer() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Set<Class<?>> annotatedEntities = DIContainer.keySet();
        for (Class<?> aClass : annotatedEntities) {
            Object bean = aClass.getConstructor().newInstance();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                GetInstance annotationGetInstance = field.getAnnotation(GetInstance.class);
                if (annotationGetInstance != null) {
                    Class<?> fullFieldClassName = getFullClassName(annotationGetInstance);
                    if (DIContainer.get(fullFieldClassName) != null) {
                        setFieldValue(field, fullFieldClassName, bean);
                    } else {
                        System.out.println("Error: there is no " + annotationGetInstance.beanName() + " in DIContainer");
                    }
                }
            }
        }
    }

    public Class<?> getStartPoint() {
        Class<?> startClass = null;
        Set<Class<?>> classSet = annotationScanner.getStartPoints();
        for (Class<?> aClass : classSet) {
            StartPoint annotation = aClass.getAnnotation(StartPoint.class);
            if (annotation != null) {
                startClass = aClass;
            }
        }
        return startClass;
    }

    public Method getStartMethod() {
        Class<?> startClass = getStartPoint();
        Method[] methods = startClass.getMethods();
        Method startMethod = null;
        for (Method m : methods) {
            StartMethod annotation = m.getAnnotation(StartMethod.class);
            if (annotation != null) {
                startMethod = m;
            }
        }
        return startMethod;
    }

    private void setFieldValue(Field f, Class<?> fullFieldClassName, Object bean) throws IllegalAccessException {
        Object fieldValue = DIContainer.get(fullFieldClassName);
        f.setAccessible(true);
        f.set(bean, fieldValue);
    }

    private Class<?> getFullClassName(GetInstance annotation) {
        String beanName = annotation.beanName();
        return DIContainer.keySet()
                .stream()
                .filter(c -> c.getTypeName().endsWith(beanName))
                .findFirst().orElse(null);
    }

    private void putClassesToDIContainer(Map<Class<?>, Object> container, Set<Class<?>> annotatedClasses) {
        for (Class<?> aClass : annotatedClasses) {
            container.put(aClass, null);
        }
    }

    public <T> T getBean(Class<T> beanType) {
        return (T) DIContainer.get(beanType);
    }

}
