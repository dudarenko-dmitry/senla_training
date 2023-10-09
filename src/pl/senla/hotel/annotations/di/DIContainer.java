package pl.senla.hotel.annotations.di;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AppComponent
public class DIContainer {

    @GetInstance
    private final ClassCollector classCollector = ClassCollector.getInstanceLoader();
    private final String packageName = "pl.senla.hotel";
    private final Map<Class<?>, Object> singletonInstances = new HashMap<>();
    private static DIContainer instance;
    private DIContainer(){}

    public static DIContainer getSingletonInstance() {
        if (instance == null) {
            instance = new DIContainer();
        }
        return instance;
    }

    public void createDI() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Class<?>> appClasses = classCollector.getAllClassesFrom(packageName);
        for (Class<?> c : appClasses) {
            AppComponent annotation = c.getAnnotation(AppComponent.class);
            if (annotation != null) {
                Method getSingletonInstance = c.getMethod("getSingletonInstance");
                getSingletonInstance.setAccessible(true);
                registerBean(c, getSingletonInstance.invoke(c));
            }
        }
    }

    public Map<Class<?>, Object> getSingletonContainer() {
        return singletonInstances;
    }

    public void registerBean(Class<?> beanType, Object bean) {
        singletonInstances.put(beanType, bean);
    }

    public <T> T getBean(Class<T> beanType) {
        return (T) singletonInstances.get(beanType);
    }

}
