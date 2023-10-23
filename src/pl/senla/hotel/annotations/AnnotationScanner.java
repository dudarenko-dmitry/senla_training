package pl.senla.hotel.annotations;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import pl.senla.hotel.annotations.config.ConfigProperty;
import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.Entity;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.annotations.di.StartPoint;

import java.lang.reflect.Field;
import java.util.Set;

public class AnnotationScanner {

    private final Reflections reflections = new Reflections("pl.senla.hotel",
            new FieldAnnotationsScanner(),
            new TypeAnnotationsScanner(),
            new SubTypesScanner());


    public Set<Field> getAnnotatedPropertyFields() {
        return reflections.getFieldsAnnotatedWith(ConfigProperty.class);
    }

    public Set<Class<?>> getAnnotatedClasses() {
        return reflections.getTypesAnnotatedWith(AppComponent.class);
    }

    public Set<Class<?>> getStartPoints(){
        return reflections.getTypesAnnotatedWith(StartPoint.class);
    }

    public Set<Field> getAnnotatedFields() {
        return reflections.getFieldsAnnotatedWith(GetInstance.class);
    }

    public Set<Class<?>> getAnnotatedEntities() {
        return reflections.getTypesAnnotatedWith(Entity.class);
    }

}
