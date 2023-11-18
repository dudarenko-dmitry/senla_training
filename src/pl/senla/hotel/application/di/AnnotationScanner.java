package pl.senla.hotel.application.di;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import pl.senla.hotel.application.config.Configuration;
import pl.senla.hotel.application.config.AppConfiguration;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.Entity;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.application.annotation.StartPoint;

import java.lang.reflect.Field;
import java.util.Set;

@Slf4j
public class AnnotationScanner {

    private final Configuration configuration = new AppConfiguration();
    private final Reflections reflections = new Reflections(configuration.getPackageToScan(),
            new FieldAnnotationsScanner(),
            new TypeAnnotationsScanner(),
            new SubTypesScanner());


    public Set<Field> getAnnotatedPropertyFields() {
        log.debug("getFieldsAnnotatedWith(ConfigProperty.class)");
        return reflections.getFieldsAnnotatedWith(ConfigProperty.class);
    }

    public Set<Class<?>> getAnnotatedClasses() {
        log.debug("getTypesAnnotatedWith(AppComponent.class)");
        return reflections.getTypesAnnotatedWith(AppComponent.class);
    }

    public Set<Class<?>> getStartPoints() {
        log.debug("getTypesAnnotatedWith(StartPoint.class)");
        return reflections.getTypesAnnotatedWith(StartPoint.class);
    }

    public Set<Field> getAnnotatedFields() {
        log.debug("getFieldsAnnotatedWith(GetInstance.class)");
        return reflections.getFieldsAnnotatedWith(GetInstance.class);
    }

    public Set<Class<?>> getAnnotatedEntities() {
        log.debug("getTypesAnnotatedWith(Entity.class)");
        return reflections.getTypesAnnotatedWith(Entity.class);
    }

}
