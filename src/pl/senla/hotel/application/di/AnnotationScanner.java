package pl.senla.hotel.application.di;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import pl.senla.hotel.application.config.Configuration;
import pl.senla.hotel.application.config.DIConfiguration;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.Entity;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.application.annotation.StartPoint;

import java.lang.reflect.Field;
import java.util.Set;

public class AnnotationScanner {

    private final Configuration configuration = new DIConfiguration();
    private final Reflections reflections = new Reflections(configuration.getPackageToScan(),
            new FieldAnnotationsScanner(),
            new TypeAnnotationsScanner(),
            new SubTypesScanner());


    public Set<Field> getAnnotatedPropertyFields() {
        return reflections.getFieldsAnnotatedWith(ConfigProperty.class);
    }

    public Set<Class<?>> getAnnotatedClasses() {
        return reflections.getTypesAnnotatedWith(AppComponent.class);
    }

    public Set<Class<?>> getStartPoints() {
        return reflections.getTypesAnnotatedWith(StartPoint.class);
    }

    public Set<Field> getAnnotatedFields() {
        return reflections.getFieldsAnnotatedWith(GetInstance.class);
    }

    public Set<Class<?>> getAnnotatedEntities() {
        return reflections.getTypesAnnotatedWith(Entity.class);
    }

}
