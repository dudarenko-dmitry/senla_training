package pl.senla.hotel.annotations.di;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClassCollector {

    private static ClassCollector classCollector;
    private ClassCollector(){}

    public static ClassCollector getInstanceLoader() {
        if (classCollector == null) {
            classCollector = new ClassCollector();
        }
        return classCollector;
    }

    public List<Class<?>> getAllClassesFrom(String packageName) {
        return new Reflections(packageName, new SubTypesScanner(false))
                .getAllTypes()
                .stream()
                .map(name -> {
                    try {
                        return Class.forName(name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
