package pl.senla.hotel.application.di;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import pl.senla.hotel.application.annotation.StartMethod;
import pl.senla.hotel.application.config.Configuration;
import pl.senla.hotel.application.config.AppConfiguration;
import pl.senla.hotel.application.annotation.AppComponent;

import pl.senla.hotel.application.annotation.StartPoint;

import java.util.Set;

import static pl.senla.hotel.constant.ApplicationContextConstant.*;

@Slf4j
public class AnnotationScanner {

    private final Configuration configuration = new AppConfiguration();
    private final Reflections reflections = new Reflections(configuration.getPackageToScan(),
            new FieldAnnotationsScanner(),
            new TypeAnnotationsScanner(),
            new SubTypesScanner());

    public Set<Class<?>> getAnnotatedClasses() {
        log.debug(GET_ANNOTATION_APP_COMPONENT);
        return reflections.getTypesAnnotatedWith(AppComponent.class);
    }

    public Set<Class<?>> getStartPoints() {
        log.debug(GET_ANNOTATION_START_POINT);
        return reflections.getTypesAnnotatedWith(StartPoint.class);
    }

}
